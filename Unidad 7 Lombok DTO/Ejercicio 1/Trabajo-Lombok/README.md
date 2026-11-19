# Programación III - Trabajo práctico: Lombok - DTO

## Objetivo

Simplificar una clase Java usando Lombok para generar métodos de acceso y constructores durante la compilación.

## Resolución

La clase `Persona` contiene dos atributos privados: `String nombre` e `int edad`.

| Anotación | Función en Persona |
| --- | --- |
| `@Getter` | Genera `getNombre()` y `getEdad()`. |
| `@Setter` | Genera `setNombre(String)` y `setEdad(int)`. |
| `@AllArgsConstructor` | Genera `Persona(String nombre, int edad)`. |
| `@NoArgsConstructor` | Genera `Persona()`. |

La consigna escribe `@NoArgsConstructo`; el nombre correcto es `@NoArgsConstructor`.

En `Main`, se crea una persona con el constructor lleno y otra con el constructor vacío. Los valores de la segunda se asignan mediante setters. Finalmente, los getters permiten mostrar los atributos de ambas en consola.

## Ejecución

Requisitos: JDK 17 o superior, Maven 3.9 y conexión a Internet para descargar las dependencias la primera vez.

Desde la carpeta que contiene `pom.xml`:

```sh
mvn clean package
java -cp target/classes ar.edu.programacion.Main
```

También se puede importar el proyecto Maven en un IDE y ejecutar `Main`. Si el IDE no reconoce los métodos generados, revisar que el procesamiento de anotaciones esté habilitado y que tenga soporte para Lombok.

## Salida esperada

```text
Persona creada con constructor lleno:
Nombre: Ana
Edad: 25

Persona creada con constructor vacio:
Nombre: Juan
Edad: 30
```

## Marco teórico: @Data y DTO

`@Data` combina getters para los atributos, setters para los no finales, `toString()`, `equals()`, `hashCode()` y `@RequiredArgsConstructor`. No equivale a combinar las cuatro anotaciones pedidas: no genera por sí sola un constructor con todos los atributos de esta clase. Por eso se utilizan las cuatro anotaciones explícitas de la consigna.

Un DTO (Data Transfer Object) transporta datos entre capas o componentes. Una clase sencilla con atributos y métodos de acceso, como `Persona`, puede emplearse para ese fin; Lombok reduce el código repetitivo, pero no convierte automáticamente cualquier clase en un DTO. El caso práctico no pide una clase DTO adicional.

## Conclusión

Lombok permite mantener el código fuente de `Persona` breve y legible al generar automáticamente los métodos de acceso y los constructores. El ejemplo demuestra ambas formas de crear objetos y la lectura y modificación de sus atributos, evitando escribir manualmente métodos repetitivos.

## Referencias

- Configuración oficial de Lombok con Maven: https://projectlombok.org/setup/maven
- Documentación de @Data: https://projectlombok.org/features/Data

