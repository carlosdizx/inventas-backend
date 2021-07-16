package arena.auth.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable
{
    //------------------------------ ATRIBUTOS ------------------------------

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String nombre;

    @Column(length =60)
    private String clave;

    private boolean habilitado;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name="roleados",joinColumns = @JoinColumn(name="usuario_id"),
    inverseJoinColumns =@JoinColumn(name="rol_id"),
    uniqueConstraints = {@UniqueConstraint(columnNames = {"usuario_id","rol_id"})})
    private List<Rol> roles;
}
