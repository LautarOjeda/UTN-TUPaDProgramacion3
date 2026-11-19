# Trabajo práctico: Lombok - DTO

Tecnicatura Universitaria en Programación - Programación III

## Objetivo

Crear DTOs modernos e inmutables mediante records de Java y compararlos con una clase tradicional.

## Solución

- `src/Producto.java`: clase POJO con los atributos `codigo`, `nombre`, `proveedor` y `precio`, constructor, getters, setters y `toString()`.
- `src/ProductoRecord.java`: record con los componentes `codigo`, `nombre` y `precio`. Su constructor adicional recibe un `Producto` y copia los datos necesarios.
- `src/Main.java`: crea tres productos, los convierte en records, los almacena en una `List<ProductoRecord>` y los muestra en consola. También demuestra la independencia del DTO y la comparación por valores.

El proveedor pertenece al objeto de dominio, pero no al DTO solicitado. La conversión permite transferir solamente los datos que necesita el consumidor.

## Ejecución

Requisito: JDK 17 o superior. Desde la carpeta del proyecto:

```sh
javac -encoding UTF-8 -d out src/Producto.java src/ProductoRecord.java src/Main.java
java -cp out Main
```

## Salida esperada

```text
PRODUCTOS COMPLETOS (POJO)
Producto[codigo=P001, nombre=Teclado, proveedor=TecnoSur, precio=25000.0]
Producto[codigo=P002, nombre=Mouse, proveedor=Insumos Centro, precio=12000.0]
Producto[codigo=P003, nombre=Monitor, proveedor=TecnoSur, precio=180000.0]

PRODUCTOS COMO DTO (RECORD)
P001 | Teclado | $25000.00
P002 | Mouse | $12000.00
P003 | Monitor | $180000.00

INMUTABILIDAD DEL DTO
Precio actual del POJO: 27000.0
Precio conservado por el DTO: 25000.0
DTOs con los mismos valores: true
```

## Marco teórico y conclusiones

Un DTO (Data Transfer Object) transporta datos entre capas o componentes. No necesita exponer todos los atributos de la entidad original ni implementar lógica de negocio.

Un record es una forma concisa de declarar una clase de datos. Java genera el constructor canónico, los métodos de acceso `codigo()`, `nombre()` y `precio()`, y los métodos `equals()`, `hashCode()` y `toString()`. Los componentes se almacenan en campos privados y finales; no se generan setters.

| Aspecto | Producto (POJO de este proyecto) | ProductoRecord |
| --- | --- | --- |
| Declaración | Campos y métodos explícitos | Componentes en la cabecera |
| Acceso | `getNombre()` | `nombre()` |
| Modificación | Permite setters | No permite reasignar componentes |
| Igualdad | Hereda la identidad de Object | Compara los componentes |
| Representación textual | `toString()` escrito manualmente | `toString()` generado |
| Uso en el proyecto | Producto completo y modificable | Datos para transferencia |

La inmutabilidad del record es superficial en general: si contiene un objeto mutable, ese objeto podría modificarse. En este ejercicio sus componentes son `String`, que es inmutable, y `double`, que es primitivo, por lo que los valores del DTO quedan protegidos frente a cambios posteriores en el producto original. La lista es mutable; esa característica es independiente de la inmutabilidad de cada DTO.

Un POJO también puede diseñarse como inmutable. La diferencia es que el record reduce el código necesario y define automáticamente la igualdad por componentes.

Aunque el título del trabajo menciona Lombok, las consignas concretas solicitan un record y no exigen anotaciones de esa biblioteca. Esta solución utiliza Java estándar, sin dependencias externas. Lombok podría reducir el código repetitivo del POJO mediante anotaciones, pero no es necesario para declarar un record.

Se utiliza `double` para respetar la firma pedida en la consigna.
