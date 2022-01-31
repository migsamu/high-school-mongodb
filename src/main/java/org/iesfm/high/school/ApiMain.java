package org.iesfm.high.school;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class ApiMain {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ApiMain.class, args);

    }
}
/*
Escribe un programa que gestione la información de un instituto:

- Grupos:

o Id

o Título(por ejemplo Desarrollo de Aplicaciones Multiplataforma)

o Curso

o Letra

o Aula

o Año (entero)

- Alumnos:

o Nif

o Nombre

o Apellidos

o Id del curso

o Faltas:

§ Fecha

§ Módulo

Implementa lo siguientes endpoints:

- Listar grupos

- Listar alumnos de un grupo

- Listar las faltas de un alumno

- Añadir grupo

- Añadir alumno a grupo

- Eliminar alumno

- Actualizar los datos de un alumno

- **** Dado un nif, una fecha y un módulo, añadir una falta a un alumno*/