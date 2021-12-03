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
public class Jugadores implements Serializable{
    
   private double velocidad;
    private String name;

     private static final long SerialVersionUID= 7770L;
    
    public Jugadores(double velocidad, String name) {
        this.velocidad = velocidad;
        this.name = name;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
}
