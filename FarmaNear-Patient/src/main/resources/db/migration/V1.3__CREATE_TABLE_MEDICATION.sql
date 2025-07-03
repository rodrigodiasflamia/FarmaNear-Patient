CREATE TABLE IF NOT EXISTS MEDICATIONS (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    dosage VARCHAR(255),
    administration_route VARCHAR(255),
    frequency VARCHAR(255),
    start_date DATE,
    end_date DATE,
    notes VARCHAR(255),
    id_patient INTEGER,
    CONSTRAINT fk_medication_patient FOREIGN KEY (id_patient) REFERENCES PATIENTS(id) ON DELETE CASCADE
);