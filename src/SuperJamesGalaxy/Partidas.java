package SuperJamesGalaxy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jrgir
 */
public class Partidas implements Serializable {

 private   String nombre;
  private  Date FechaCreacion;
   private ArrayList<Estrellas> Stars;
   private ArrayList<Jugadores> Players;

    private static final long SerialVersionUID = 99770L;

    public Partidas(String nombre) {
        this.nombre = nombre;
        this.FechaCreacion = new Date();
        this.Stars = new ArrayList();
        this.Players = new ArrayList();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(Date FechaCreacion) {
        this.FechaCreacion = FechaCreacion;
    }

    public ArrayList<Estrellas> getStars() {
        return Stars;
    }

    public void setStars(ArrayList<Estrellas> Stars) {
        this.Stars = Stars;
    }

    public ArrayList<Jugadores> getPlayers() {
        return Players;
    }

    public void setPlayers(ArrayList<Jugadores> Players) {
        this.Players = Players;
    }

    public boolean agregarEstrella(String nombre, String descripcion, int distancia) {

        if (validarExistenciaStar(nombre) == false) {

            Stars.add(new Estrellas(nombre, descripcion, distancia));

            return true;
        } else {

            return false;
        }

    }

    public boolean agregarJugador(int velocidad, String name) {

        if (validarExistenciaJugador(nombre) == false) {

            Players.add(new Jugadores(velocidad, nombre));

            return true;
        } else {

            return false;
        }

    }

    public boolean validarExistenciaJugador(String name) {

        boolean validar = false;

        for (Jugadores p : Players) {

            if (name.equals(p.getName())) {

                validar = true;
                return validar;

            }

        }

        return validar;

    }

    public boolean validarExistenciaStar(String name) {

        boolean validar = false;

        for (Estrellas Star : Stars) {

            if (name.equals(Star.getNombre())) {

                validar = true;
                return validar;

            }

        }

        return validar;

    }

    @Override
    public String toString() {
        return   nombre ;
    }
    
    
}
