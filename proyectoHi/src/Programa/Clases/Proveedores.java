package Programa.Clases;

import java.io.Serializable;

public class Proveedores implements Serializable {
    private String Codigo;
    private String nombre;
    private String apellidos;
    private String direccionPostal;

    //constructores


    public Proveedores(String codigo, String nombre, String apellidos, String direccionPostal) {
        Codigo = codigo;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccionPostal = direccionPostal;
    }

    public Proveedores(String codigo) {
        Codigo = codigo;
    }

    public Proveedores() {
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
}
