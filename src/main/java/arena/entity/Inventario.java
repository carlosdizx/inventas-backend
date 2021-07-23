package arena.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "inventarios")
public class Inventario implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "inventario_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<Activo> activos;

    public Inventario() {
        activos = new ArrayList<>();
    }

    public Inventario(Long id, List<Activo> activos) {
        this.id = id;
        this.activos = activos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Activo> getActivos() {
        return activos;
    }

    public void setActivos(List<Activo> activos) {
        this.activos = activos;
    }
}
