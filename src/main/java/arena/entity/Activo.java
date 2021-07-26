package arena.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "activos")
public class Activo implements Serializable
{
    //------------------------------ ATRIBUTOS ------------------------------

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private Long codigo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Producto producto;

    private boolean estado = true;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "inventario_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Inventario inventario;
    //------------------------------ CONSTRUCTORES ------------------------------

    public Activo() {
    }

    //------------------------------ METODOS ------------------------------


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }
}
