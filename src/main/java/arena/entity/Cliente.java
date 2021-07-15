package arena.entity;

import javax.persistence.*;

@Entity
@Table(name="clientes")
public class Cliente
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String nombres;

    @Column(unique = true)
    private Long documento;

    private String direccion;

    private String ciudad;

    private String departamento;

    private String codigoPostal;

    private String celular;

    private String correo;
}
