import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Objetos originales: contienen todos los datos del producto.
        Producto producto1 = new Producto(1, "El principito", 12500.0,
                "Antoine de Saint-Exupery");
        Producto producto2 = new Producto(2, "Don Quijote", 18900.0,
                "Miguel de Cervantes");
        Producto producto3 = new Producto(3, "Ficciones", 15400.0,
                "Jorge Luis Borges");

        // Carga manual de los DTO mediante getters y setters.
        // El atributo autor no se transporta porque no pertenece al DTO.
        ProductoDTO dto1 = new ProductoDTO();
        dto1.setCodigo(producto1.getCodigo());
        dto1.setNombre(producto1.getNombre());
        dto1.setPrecio(producto1.getPrecio());

        ProductoDTO dto2 = new ProductoDTO();
        dto2.setCodigo(producto2.getCodigo());
        dto2.setNombre(producto2.getNombre());
        dto2.setPrecio(producto2.getPrecio());

        ProductoDTO dto3 = new ProductoDTO();
        dto3.setCodigo(producto3.getCodigo());
        dto3.setNombre(producto3.getNombre());
        dto3.setPrecio(producto3.getPrecio());

        List<ProductoDTO> productosDTO = new ArrayList<>();
        productosDTO.add(dto1);
        productosDTO.add(dto2);
        productosDTO.add(dto3);

        System.out.println("Lista de productos DTO:");
        for (ProductoDTO dto : productosDTO) {
            System.out.println(dto);
        }
    }
}
