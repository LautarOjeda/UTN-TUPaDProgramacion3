package ar.edu.programacion;

import lombok.Builder;
import lombok.Data;

/** Objeto de datos utilizado para practicar las anotaciones de Lombok. */
@Data
@Builder
public class Usuario {
    private Long id;
    private String nombre;
    private String email;
}
