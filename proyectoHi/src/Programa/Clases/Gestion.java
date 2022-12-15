package Programa.Clases;

import java.io.Serializable;

public class Gestion implements Serializable {
    private String Cproveedor;
    private String Cpieza;
    private String Cproyecto;
    private int Cantidad;
    //metodos


    public Gestion(String cproveedor, String cpieza, String cproyecto, int cantidad) {
        Cproveedor = cproveedor;
        Cpieza = cpieza;
        Cproyecto = cproyecto;
        Cantidad = cantidad;
    }

    public Gestion(String cproveedor, String cpieza, String cproyecto) {
        Cproveedor = cproveedor;
        Cpieza = cpieza;
        Cproyecto = cproyecto;
    }

    public Gestion() {
    }


    //get y set


    public String getCproveedor() {
        return Cproveedor;
    }

    public void setCproveedor(String cproveedor) {
        Cproveedor = cproveedor;
    }

    public String getCpieza() {
        return Cpieza;
    }

    public void setCpieza(String cpieza) {
        Cpieza = cpieza;
    }

    public String getCproyecto() {
        return Cproyecto;
    }

    public void setCproyecto(String cproyecto) {
        Cproyecto = cproyecto;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int cantidad) {
        Cantidad = cantidad;
    }
}
