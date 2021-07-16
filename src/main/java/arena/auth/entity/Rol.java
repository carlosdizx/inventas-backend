package arena.auth.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="roles")
public class Rol implements Serializable
{
    //------------------------------ ATRIBUTOS ------------------------------

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String nombre;

}
