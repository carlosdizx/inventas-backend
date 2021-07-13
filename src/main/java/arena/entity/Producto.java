package arena.entity;

import javax.persistence.*;

@Entity
@Table(name = "productos")
public class Producto
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    private double precioCompra;

    private double precioVenta;
}
