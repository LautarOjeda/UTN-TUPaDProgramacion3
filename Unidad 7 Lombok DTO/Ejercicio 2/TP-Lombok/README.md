# Trabajo práctico: Lombok - DTO

**Materia:** Programación III  
**Carrera:** Tecnicatura Universitaria en Programación

## Objetivo

Crear una clase `Usuario` con los atributos `id`, `nombre` y `email`, aplicar `@Data` y `@Builder`, construir instancias mediante Builder e imprimir sus datos por consola.

## Marco teórico

Lombok es una biblioteca de Java que genera código durante la compilación mediante anotaciones. Permite reducir código repetitivo y concentrarse en los datos y el comportamiento del programa.

### Anotación @Data

Agrupa la generación de getters, setters para atributos no finales, `toString()`, `equals()` y `hashCode()`. También incorpora el comportamiento de `@RequiredArgsConstructor`; al combinar anotaciones, los constructores generados dependen de la configuración. En este ejercicio se crean los objetos con el Builder generado por `@Builder`.

Los getters permiten consultar atributos, los setters permiten modificarlos, `toString()` permite mostrar una representación del objeto y `equals()`/`hashCode()` permiten comparar objetos a partir de sus datos.

### Anotación @Builder y patrón Builder

El patrón Builder construye objetos paso a paso mediante métodos con el nombre de cada atributo. Lombok genera `Usuario.builder()`, los métodos `id(...)`, `nombre(...)`, `email(...)` y el método `build()`, que devuelve la instancia de `Usuario`.

Por ejemplo:

```java
Usuario usuario = Usuario.builder()
        .id(1L)
        .nombre("Ana Garcia")
        .email("ana@example.com")
        .build();
```

Este código expresa qué valor recibe cada atributo y permite cambiar el orden de asignación. Resulta útil cuando una clase tiene muchos atributos. En esta implementación los valores omitidos quedan en `null`: Builder por sí solo no valida campos obligatorios ni el formato de un correo electrónico. Además, `@Data` genera setters, por lo que este objeto es mutable.

### Relación con DTO

Un DTO (Data Transfer Object) agrupa datos para transferirlos entre partes de una aplicación. La clase `Usuario` puede cumplir ese papel porque contiene datos sin lógica de negocio. No se agregan una base de datos ni un servicio web porque la consigna solicita un ejemplo por consola.

## Desarrollo

1. `Usuario.java` define `Long id`, `String nombre` y `String email`, junto con `@Data` y `@Builder`.
2. `Main.java` construye dos usuarios con `Usuario.builder()` y finaliza cada construcción con `build()`.
3. `System.out.println(...)` imprime cada objeto utilizando el `toString()` generado por Lombok.
4. `pom.xml` declara Lombok como dependencia de compilación y configura explícitamente su procesador de anotaciones.

## Cómo ejecutar

Requisitos: JDK 17 o superior, Maven y conexión a Internet para descargar las dependencias la primera vez.

Abrir una terminal en la carpeta que contiene `pom.xml` y ejecutar:

```shell
mvn clean package
java -jar target/tp-lombok-1.0.0.jar
```

También se puede importar la carpeta como proyecto Maven en un IDE y ejecutar `Main`. Si el IDE no reconoce los métodos generados, revisar que tenga habilitado el procesamiento de anotaciones y soporte de Lombok.

## Salida esperada

```text
Usuario(id=1, nombre=Ana Garcia, email=ana@example.com)
Usuario(id=2, nombre=Lucas Perez, email=lucas@example.com)
```

## Conclusión

El ejercicio permite aplicar el patrón Builder para crear objetos de forma legible y flexible. `@Builder` evita escribir manualmente el constructor fluido y `@Data` genera métodos habituales de una clase de datos. Así se reduce el código repetitivo y se simplifica el mantenimiento de la clase `Usuario`.

## Referencias

- Lombok, @Data: https://projectlombok.org/features/Data
- Lombok, @Builder: https://projectlombok.org/features/Builder
- Lombok, configuración con Maven: https://projectlombok.org/setup/maven
