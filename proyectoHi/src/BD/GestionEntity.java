package BD;

import javax.persistence.*;

@Entity
@Table(name = "Gestion", schema = "Almacen", catalog = "")
public class GestionEntity {

    @Basic
    @Column(name = "Cantidad", nullable = false)
    private int cantidad;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;
    @OneToOne
    @JoinColumn(name = "Cpieza", referencedColumnName = "Codigo", nullable = false)
    private PiezasEntity pieza;
    @OneToOne
    @JoinColumn(name = "Cproveedor", referencedColumnName = "Codigo", nullable = false)
    private ProveedoresEntity proveedor;
    @OneToOne
    @JoinColumn(name = "Cproyecto", referencedColumnName = "Codigo", nullable = false)
    private ProyectosEntity proyecto;



    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PiezasEntity getPieza() {
        return pieza;
    }

    public void setPieza(PiezasEntity pieza) {
        this.pieza = pieza;
    }

    public ProveedoresEntity getProveedor() {
        return proveedor;
    }

    public void setProveedor(ProveedoresEntity proveedor) {
        this.proveedor = proveedor;
    }

    public ProyectosEntity getProyecto() {
        return proyecto;
    }

    public void setProyecto(ProyectosEntity proyecto) {
        this.proyecto = proyecto;
    }
}
