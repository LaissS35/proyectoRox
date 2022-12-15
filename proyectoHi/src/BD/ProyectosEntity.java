package BD;

import javax.persistence.*;

@Entity
@Table(name = "Proyectos", schema = "Almacen", catalog = "")
public class ProyectosEntity {
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Codigo", nullable = false, length = 6)
    private String codigo;
    @Basic
    @Column(name = "Nombre", nullable = false, length = 45)
    private String nombre;
    @Basic
    @Column(name = "Ubicacion", nullable = false, length = 45)
    private String ubicacion;
    @Basic
    @Column(name = "Descripcion", nullable = true, length = 45)
    private String descripcion;
    @OneToOne(mappedBy = "proyecto")
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

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public GestionEntity getGestion() {
        return gestion;
    }

    public void setGestion(GestionEntity gestion) {
        this.gestion = gestion;
    }
}
