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
public class AdminPlayers {
  private ArrayList<Jugadores> Player = new ArrayList();
    private File archivo = null;

    public AdminPlayers(String path) {
        archivo = new File(path);
    }

    public ArrayList<Jugadores> getListaJugadores() {
        return Player;
    }

    public void setListaPersonas(ArrayList<Jugadores> Player) {
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
        return "Jugadores=" + Player;
    }

    //extra mutador
    public void setPersona(Jugadores p) {
        this.Player.add(p);
    }

    public void cargarArchivo() {
        try {            
            Player = new ArrayList();
            Jugadores temp;
            if (archivo.exists()) {
                FileInputStream entrada
                    = new FileInputStream(archivo);
                ObjectInputStream objeto
                    = new ObjectInputStream(entrada);
                try {
                    while ((temp = (Jugadores) objeto.readObject()) != null) {
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
            for (Jugadores t : Player) {
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
