CREATE TABLE Estudiante (
    id_estudiante SERIAL PRIMARY KEY,
    codigo VARCHAR(20) NOT NULL UNIQUE,
    nombre VARCHAR(100) NOT NULL
);

CREATE TABLE Materia (
    id_materia SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE Periodo (
    id_periodo SERIAL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE estudiante_materia_periodo (
    id_emp SERIAL PRIMARY KEY,
    id_estudiante INT NOT NULL,
    id_materia INT NOT NULL,
    id_periodo INT NOT NULL,
    aprobada BOOLEAN NOT NULL,

    FOREIGN KEY (id_estudiante) REFERENCES Estudiante(id_estudiante),
    FOREIGN KEY (id_materia) REFERENCES Materia(id_materia),
    FOREIGN KEY (id_periodo) REFERENCES Periodo(id_periodo),
    UNIQUE (id_estudiante, id_materia, id_periodo)
);
