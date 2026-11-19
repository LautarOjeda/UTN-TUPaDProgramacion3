/** DTO inmutable que expone solo los datos necesarios del producto. */
public record ProductoRecord(String codigo, String nombre, double precio) {
    /** Convierte un objeto del dominio a su DTO, sin incluir el proveedor. */
    public ProductoRecord(Producto producto) {
        this(producto.getCodigo(), producto.getNombre(), producto.getPrecio());
    }
}
