package arena.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "inventarios")
public class Inventario implements Serializable
{
    //------------------------------ ATRIBUTOS ------------------------------

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @CreationTimestamp
    private Date fecha;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "inventario_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<Activo> activos;

    //------------------------------ CONSTRUCTORES ------------------------------

    public Inventario() {
        activos = new ArrayList<>();
    }

    //------------------------------ METODOS ------------------------------


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<Activo> getActivos() {
        return activos;
    }

    public void setActivos(List<Activo> activos) {
        this.activos = activos;
    }
}
