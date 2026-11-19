package ar.edu.programacion;

public class Main {
    public static void main(String[] args) {
        Usuario usuario1 = Usuario.builder()
                .id(1L)
                .nombre("Ana Garcia")
                .email("ana@example.com")
                .build();

        // Los atributos pueden indicarse en un orden diferente.
        Usuario usuario2 = Usuario.builder()
                .email("lucas@example.com")
                .nombre("Lucas Perez")
                .id(2L)
                .build();

        // println utiliza el metodo toString generado por @Data.
        System.out.println(usuario1);
        System.out.println(usuario2);
    }
}
