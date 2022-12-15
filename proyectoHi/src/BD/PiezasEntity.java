package BD;

import javax.persistence.*;
import java.awt.*;
import java.math.BigInteger;

@Entity
@Table(name = "Piezas", schema = "Almacen", catalog = "")
public class PiezasEntity {
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Codigo", nullable = false, length = 6)
    private String codigo;
    @Basic
    @Column(name = "Nombre", nullable = false, length = 45)
    private String nombre;
    @Basic
    @Column(name = "Precio", nullable = false, precision = 0)
    private BigInteger precio;
    @Basic
    @Column(name = "Descripcion", nullable = true, length = 445)
    private String descripcion;
    @OneToOne(mappedBy = "pieza")
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

    public BigInteger getPrecio() {
        return precio;
    }

    public void setPrecio(BigInteger precio) {
        this.precio = precio;
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
