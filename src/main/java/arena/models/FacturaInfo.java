package arena.models;

import java.util.Date;

public class FacturaInfo
{
    private Integer id;

    private String descripcion;

    private Date fecha;

    private String producto;

    private double precio;

    private Integer cantidad;

    private double subTotal;

    public FacturaInfo(Integer id, String descripcion, Date fecha, String producto, double precio, Integer cantidad, double subTotal) {
        this.id = id;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.producto = producto;
        this.precio = precio;
        this.cantidad = cantidad;
        this.subTotal = subTotal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
}
