CREATE TABLE IF NOT EXISTS users(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(50) NOT NULL,
    descripcio VARCHAR(1000) NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE,
    contrasenya VARCHAR(20) NOT NULL,
    ultim_acces TIMESTAMP,
    data_creacio TIMESTAMP,
    data_actualitzat TIMESTAMP,
    image_path VARCHAR(500) NULL
    );