package SuperJamesGalaxy;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jrgir
 */
public class AdminStars {
    
    
      private ArrayList<Estrellas> Stars = new ArrayList();
    private File archivo = null;

    public AdminStars(String path) {
        archivo = new File(path);
    }

    public ArrayList<Estrellas> getListaStars() {
        return Stars;
    }

    public void setListaPersonas(ArrayList<Estrellas> Stars) {
        this.Stars = Stars;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    @Override
    public String toString() {
        return "Estrellas=" + Stars;
    }

    //extra mutador
    public void setPersona(Estrellas p) {
        this.Stars.add(p);
    }

    public void cargarArchivo() {
        try {            
            Stars = new ArrayList();
            Estrellas temp;
            if (archivo.exists()) {
                FileInputStream entrada
                    = new FileInputStream(archivo);
                ObjectInputStream objeto
                    = new ObjectInputStream(entrada);
                try {
                    while ((temp = (Estrellas) objeto.readObject()) != null) {
                        Stars.add(temp);
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
            for (Estrellas t : Stars) {
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
