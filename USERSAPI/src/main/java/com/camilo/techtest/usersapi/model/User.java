package com.camilo.techtest.usersapi.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //sequence para oracle, table para otras bases de datos, auto para que hibernate
    private Long id;
    
    private String name;
    private String address;
}
// La anotación @Entity("user") no es válida. Debe ser solo @Entity.
// @Id y @GeneratedValue son las anotaciones correctas para la clave primaria.
// Se recomienda usar @Table(name = "users") para evitar problemas con SQL reservado.
