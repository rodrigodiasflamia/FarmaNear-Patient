package br.com.fiap.FarmaNear_Patient.entities.address;

import br.com.fiap.FarmaNear_Patient.infra.repository.address.AddressEntity;

public class Address implements AddressEntityInterface{

    private Long id;
    private String street;
    private String number;
    private String neighborhood;
    private String complement;
    private String city;
    private String state;
    private String zipCode;
    private String mobilePhone;
    private String email;

    public Address() { }

    public Address(String street, String number, String neighborhood, String complement, String city, String state, String zipCode, String mobilePhone, String email) {
        this.street = street;
        this.number = number;
        this.neighborhood = neighborhood;
        this.complement = complement;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.mobilePhone = mobilePhone;
        this.email = email;
    }

    public Address(Long id, String street, String number, String neighborhood, String complement, String city, String state, String zipCode, String mobilePhone, String email) {
        this.id = id;
        this.street = street;
        this.number = number;
        this.neighborhood = neighborhood;
        this.complement = complement;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.mobilePhone = mobilePhone;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getComplement() {
        return complement;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public AddressEntity createAddressEntity(){
        return new AddressEntity(street, number, neighborhood, complement, city, state, zipCode, mobilePhone, email);
    }
}