/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperJamesGalaxy;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author jrgir
 */
public class AdminPartidas {
  private ArrayList<Partidas> Player = new ArrayList();
    private File archivo = null;

    public AdminPartidas(String path) {
        archivo = new File(path);
    }

    public ArrayList<Partidas> getListaJugadores() {
        return Player;
    }

    public void setListaPartidas(ArrayList<Partidas> Player) {
        this.Player = Player;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    @Override
    public String toString() {
        return "Partida=" + Player;
    }

    //extra mutador
    public void setPersona(Partidas p) {
        this.Player.add(p);
    }

    public void cargarArchivo() {
        try {            
            Player = new ArrayList();
            Partidas temp;
            if (archivo.exists()) {
                FileInputStream entrada
                    = new FileInputStream(archivo);
                ObjectInputStream objeto
                    = new ObjectInputStream(entrada);
                try {
                    while ((temp = (Partidas) objeto.readObject()) != null) {
                        Player.add(temp);
                    }
                } catch (EOFException e) {
                    //encontro el final del archivo
                }
                objeto.close();
                entrada.close();
            }            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void escribirArchivo() {
        FileOutputStream fw = null;
        ObjectOutputStream bw = null;
        try {
            fw = new FileOutputStream(archivo);
            bw = new ObjectOutputStream(fw);
            for (Partidas t : Player) {
                bw.writeObject(t);
            }
            bw.flush();
        } catch (Exception ex) {
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (Exception ex) {
            }
        }
    }

}
