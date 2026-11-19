import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Instanciar varios objetos Producto.
        Producto teclado = new Producto("P001", "Teclado", "TecnoSur", 25000.0);
        Producto mouse = new Producto("P002", "Mouse", "Insumos Centro", 12000.0);
        Producto monitor = new Producto("P003", "Monitor", "TecnoSur", 180000.0);

        // 2. Instanciar los records a partir de los objetos Producto.
        ProductoRecord tecladoDTO = new ProductoRecord(teclado);
        ProductoRecord mouseDTO = new ProductoRecord(mouse);
        ProductoRecord monitorDTO = new ProductoRecord(monitor);

        // 3. Guardar los DTOs en una lista.
        List<ProductoRecord> productos = new ArrayList<>();
        productos.add(tecladoDTO);
        productos.add(mouseDTO);
        productos.add(monitorDTO);

        // 4. Mostrar los productos completos y los DTOs en consola.
        System.out.println("PRODUCTOS COMPLETOS (POJO)");
        for (Producto producto : List.of(teclado, mouse, monitor)) {
            System.out.println(producto);
        }

        System.out.println("\nPRODUCTOS COMO DTO (RECORD)");
        for (ProductoRecord producto : productos) {
            System.out.printf(java.util.Locale.ROOT,
                    "%s | %s | $%.2f%n", producto.codigo(), producto.nombre(), producto.precio());
        }

        // El DTO conserva los valores copiados aunque cambie el objeto original.
        teclado.setPrecio(27000.0);
        System.out.println("\nINMUTABILIDAD DEL DTO");
        System.out.println("Precio actual del POJO: " + teclado.getPrecio());
        System.out.println("Precio conservado por el DTO: " + tecladoDTO.precio());

        // Los records generan equals() y comparan los valores de sus componentes.
        ProductoRecord copia = new ProductoRecord("P001", "Teclado", 25000.0);
        System.out.println("DTOs con los mismos valores: " + tecladoDTO.equals(copia));
    }
}
