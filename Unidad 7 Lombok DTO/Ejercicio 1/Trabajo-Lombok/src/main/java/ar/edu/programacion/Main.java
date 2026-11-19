package ar.edu.programacion;

public class Main {
    public static void main(String[] args) {
        // Constructor con todos los atributos, generado por Lombok.
        Persona persona1 = new Persona("Ana", 25);

        // Constructor vacio y setters, generados por Lombok.
        Persona persona2 = new Persona();
        persona2.setNombre("Juan");
        persona2.setEdad(30);

        System.out.println("Persona creada con constructor lleno:");
        System.out.println("Nombre: " + persona1.getNombre());
        System.out.println("Edad: " + persona1.getEdad());
        System.out.println();
        System.out.println("Persona creada con constructor vacio:");
        System.out.println("Nombre: " + persona2.getNombre());
        System.out.println("Edad: " + persona2.getEdad());
    }
}
