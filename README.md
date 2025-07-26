# 💊 FarmaSUS Microservice de Paciente - Hackaton FIAP 6ADJT
Este repositório contém a aplicação backend do microservice de Paciente desenvolvida para o Hackaton da pós-graduação Arquitetura e Desenvolvimento Java - 6ADJT (FIAP).

## 🧾 Descrição

O microserviço **FarmaNear-Patient** é responsável pela gestão dos pacientes que utilizam os serviços da plataforma FarmaSus.

---

## 🛠️ Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.5**
- **Spring Data JPA** (Hibernate) para persistência
- **PostgreSQL** como banco de dados relacional
- **Flyway** para versionamento e migração de banco de dados
- **Spring Security** com **JWT** para autenticação e segurança
- **Springdoc OpenAPI** para documentação da API

---

## 🧩 Modelagem do Domínio

### Entidades principais e relacionamentos

- **Paciente**
    - Campos: `id`, `name`, `cpf`
    - Relacionamento 1:1 com **Endereço**
    - Relacionamento 1:N com **Medicamento**

- **Endereço**
    - Campos: `id`, `street`, `number`, `neighborhood`, `complement`, `city`, `state`, `zipCode`, `mobilePhone`, `email`
    - Relacionamento 1:1 com **Paciente** (chave estrangeira `id_patient`)

- **Medicamento**
    - Campos: `id`, `name`, `dosage`, `administrationRoute`, `frequency`, `startDate`, `endDate`, `notes`
    - Relacionamento N:1 com **Paciente** (chave estrangeira `id_patient`)

---

## 📡 Endpoints da API

### 👤 Paciente

| Método | Endpoint                    | Descrição                           |
|--------|-----------------------------|-----------------------------------|
| POST   | `/patient/create`           | Cria cadastro do paciente          |
| GET    | `/patient/read/id/{id}`     | Busca paciente pelo ID             |
| GET    | `/patient/read/cpf/{cpf}`   | Busca paciente pelo CPF            |
| PUT    | `/patient/update`           | Atualiza cadastro do paciente      |
| DELETE | `/patient/delete/{id}`      | Remove cadastro do paciente        |

---

### 🏠 Endereço

| Método | Endpoint                          | Descrição                                |
|--------|-----------------------------------|------------------------------------------|
| POST   | `/address/create`                 | Cria cadastro do endereço                 |
| GET    | `/address/read/{id}`              | Busca endereço pelo ID                     |
| GET    | `/address/patient/read/{patientId}` | Busca endereço pelo ID do paciente     |
| PUT    | `/address/update`                 | Atualiza cadastro do endereço              |
| DELETE | `/address/delete/{id}`            | Remove cadastro do endereço                 |

---

### 💉 Medicamento

| Método | Endpoint                          | Descrição                                   |
|--------|-----------------------------------|---------------------------------------------|
| POST   | `/medication/create`             | Cria cadastro do medicamento                  |
| GET    | `/medication/read/{id}`          | Busca medicamento pelo ID                      |
| GET    | `/medication/patient/read/{patientId}` | Busca medicamentos pelo ID do paciente     |
| PUT    | `/medication/update`             | Atualiza cadastro do medicamento               |
| DELETE | `/medication/delete/{id}`        | Remove cadastro do medicamento                 |

---

## 🚀 Como executar
```bash
# Clone o repositório
git clone https://github.com/rodrigodiasflamia/FarmaNear-Patient.git

# Compile o projeto
mvn clean install

# Inicie a aplicação
mvn spring-boot:run

# A documentação interativa da API estará disponível em:
http://localhost:8080/swagger-ui.html
```