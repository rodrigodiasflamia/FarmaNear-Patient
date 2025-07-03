CREATE TABLE IF NOT EXISTS ADDRESSES (
    id SERIAL PRIMARY KEY,
    street VARCHAR(255),
    number VARCHAR(255),
    neighborhood VARCHAR(255),
    complement VARCHAR(255),
    city VARCHAR(255),
    state VARCHAR(255),
    zip_code VARCHAR(255),
    mobile_phone VARCHAR(255),
    email VARCHAR(255),
    id_patient INTEGER UNIQUE,
    CONSTRAINT fk_address_patient FOREIGN KEY (id_patient) REFERENCES PATIENTS (id) ON DELETE CASCADE
);