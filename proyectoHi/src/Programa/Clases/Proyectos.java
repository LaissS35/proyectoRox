package Programa.Clases;

import java.io.Serializable;

public class Proyectos  implements Serializable {
    private String Codigo;
    private String nombre;
    private String ubicacion;
    private String descripcion;

    //constructores

    public Proyectos(String codigo, String nombre, String ubicacion, String descripcion) {
        Codigo = codigo;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
    }

    public Proyectos() {
    }

    public Proyectos(String codigo) {
        Codigo = codigo;
    }


    //get y set


    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String codigo) {
        Codigo = codigo;
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
}