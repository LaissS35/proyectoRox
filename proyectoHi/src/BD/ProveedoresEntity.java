package BD;

import javax.persistence.*;

@Entity
@Table(name = "Proveedores", schema = "Almacen", catalog = "")
public class ProveedoresEntity {
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Codigo", nullable = false, length = 6)
    private String codigo;
    @Basic
    @Column(name = "Nombre", nullable = false, length = 45)
    private String nombre;
    @Basic
    @Column(name = "Apellidos", nullable = false, length = 45)
    private String apellidos;
    @Basic
    @Column(name = "DireccionPostal", nullable = false, length = 445)
    private String direccionPostal;
    @OneToOne(mappedBy = "proveedor")
    private GestionEntity gestion;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccionPostal() {
        return direccionPostal;
    }

    public void setDireccionPostal(String direccionPostal) {
        this.direccionPostal = direccionPostal;
    }

    public GestionEntity getGestion() {
        return gestion;
    }

    public void setGestion(GestionEntity gestion) {
        this.gestion = gestion;
    }
}
