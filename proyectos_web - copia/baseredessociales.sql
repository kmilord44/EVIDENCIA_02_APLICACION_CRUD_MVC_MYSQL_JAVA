-- Creación de la base de datos
CREATE DATABASE bdevaluacion;

-- Uso de la base de datos
USE bdevaluacion;

-- Creación de la tabla Usuario
CREATE TABLE Usuario (
  idUsuario INT PRIMARY KEY AUTO_INCREMENT,
  nombreUsuario VARCHAR(50) NOT NULL,
  correoUsuario VARCHAR(100) NOT NULL,
  telefono INT,
  usuario VARCHAR (100) NOT NULL,
  passwordd INT,
  estado boolean
);

CREATE TABLE Estado (
  id INT PRIMARY KEY AUTO_INCREMENT,
  descripcion VARCHAR(500),
  link VARCHAR(100),
  cancion VARCHAR(100)
);


CREATE TABLE Publicacion (
  id INT PRIMARY KEY AUTO_INCREMENT,
  biografia VARCHAR(500),
  estado_animo VARCHAR(50),
  link VARCHAR(200)
);