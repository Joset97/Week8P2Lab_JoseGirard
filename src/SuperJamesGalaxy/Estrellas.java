package SuperJamesGalaxy;

import java.io.Serializable;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jrgir
 */
public class Estrellas implements Serializable {
    
    private String nombre;
    private String descripcion;
    private int distancia;
    
   private static final long SerialVersionUID = 99770L;

    public Estrellas(String nombre, String descripcion, int distancia) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.distancia = distancia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    @Override
    public String toString() {
        return  nombre ;
    }
    
    
    
}
