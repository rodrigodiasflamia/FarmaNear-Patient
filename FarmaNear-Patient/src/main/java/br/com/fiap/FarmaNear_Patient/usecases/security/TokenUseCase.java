package br.com.fiap.FarmaNear_Patient.usecases.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Component
public class TokenUseCase {

    @Value("${api.security.token.secret}")
    private String secret;

    public String getSubject(String token) {
        try {
            var algorithm = Algorithm.HMAC256(secret);
            DecodedJWT decodedJWT = JWT.require(algorithm).withIssuer("FarmaNear").build().verify(token);

            if (isExpired(decodedJWT)) {
                throw new RuntimeException("Token expired");
            }
            return decodedJWT.getSubject();
        } catch (JWTVerificationException e) {
            throw new RuntimeException("Error", e);
        }
    }

    private boolean isExpired(DecodedJWT decodedJWT) {
        Instant tokenExpiration = decodedJWT.getExpiresAt().toInstant();
        Instant currentTime = Instant.now().atOffset(ZoneOffset.of("-03:00")).toInstant();
        return currentTime.isAfter(tokenExpiration);
    }

    private Instant expirationDate() {
        return LocalDateTime.now().plusMinutes(30).toInstant(ZoneOffset.of("-03:00"));
    }
}