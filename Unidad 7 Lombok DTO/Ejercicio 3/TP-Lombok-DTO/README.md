# Trabajo practico: Lombok - DTO

## Objetivo

Implementar un DTO clasico en Java de forma manual y utilizarlo para transportar datos de productos.

## Marco teorico

Un DTO (Data Transfer Object) es un objeto que agrupa datos para transferirlos entre capas o componentes de una aplicacion. Por ejemplo, una capa de servicio puede entregar un ProductoDTO a la capa de presentacion con los datos que esta necesita mostrar.

Un POJO es una clase Java comun, sin depender de un framework especial. En este trabajo, ProductoDTO es un POJO con atributos privados, constructores y getters/setters escritos manualmente. El DTO no contiene logica de negocio.

Producto tiene codigo, nombre, precio y autor. ProductoDTO transporta solamente codigo, nombre y precio. Asi, el contrato de datos que recibe otra capa puede ser diferente de la clase original.

Aunque el titulo menciona Lombok, no se utilizan anotaciones ni dependencias de esa biblioteca porque la consigna solicita implementar los metodos manualmente. Lombok permite generar codigo repetitivo como constructores y getters/setters durante la compilacion.

## Resolucion

1. Producto.java define los cuatro atributos, un constructor vacio, uno con todos los atributos y los getters/setters.
2. ProductoDTO.java define los tres atributos solicitados, ambos constructores y los getters/setters. Ademas, sobrescribe toString() para mostrar los datos en consola.
3. Main.java crea tres productos y tres DTO. Obtiene los datos de cada producto mediante getters y los asigna al DTO mediante setters.
4. Los DTO se guardan en un ArrayList declarado como List<ProductoDTO> y se muestran mediante un bucle for-each.

## Ejecucion

Con un JDK instalado, abrir una terminal en la carpeta que contiene los tres archivos Java y ejecutar:

```sh
javac -encoding UTF-8 Producto.java ProductoDTO.java Main.java
java Main
```

## Salida esperada

```text
Lista de productos DTO:
ProductoDTO{codigo=1, nombre='El principito', precio=12500.0}
ProductoDTO{codigo=2, nombre='Don Quijote', precio=18900.0}
ProductoDTO{codigo=3, nombre='Ficciones', precio=15400.0}
```

## Conclusion

Un DTO clasico permite agrupar y transportar los datos que necesita otra capa. En este ejemplo se copian codigo, nombre y precio desde Producto hacia ProductoDTO, sin incluir autor. La implementacion manual permite comprender el uso de constructores, encapsulamiento, getters y setters. La lista permite almacenar y recorrer varios DTO de manera ordenada.

Se utiliza double para mantener sencillo el ejercicio; los importes y productos son datos de ejemplo.
