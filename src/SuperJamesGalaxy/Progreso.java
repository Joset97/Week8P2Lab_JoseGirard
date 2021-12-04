/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperJamesGalaxy;

import javax.swing.JProgressBar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jrgir
 */
public class Progreso  extends Thread{

    private JProgressBar barra;
    private boolean jugando;
    private boolean estado;
    private Partidas game;

    public Progreso(JProgressBar barra, Partidas game) {
        this.barra = barra;
        this.game= game;
        jugando=true;
        estado=true;
    }

    public boolean isJugando() {
        return jugando;
    }

    public void setJugando(boolean jugando) {
        this.jugando = jugando;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    public JProgressBar getBarra() {
        return barra;
    }

    public void setBarra(JProgressBar barra) {
        this.barra = barra;
    }

    public Partidas getGame() {
        return game;
    }

    public void setGame(Partidas game) {
        this.game = game;
    }
    
    
    
    @Override
    public void run(){
        int pos=0;
        int Inicio=0;
        
        while(jugando){
            if(estado){
                barra.setValue(barra.getValue()+game.getPlayers().get(pos).getVelocidad());
                if(barra.getValue()>= game.getStars().get(pos).getDistancia()){
                    barra.setValue(Inicio);
                    pos++;
                    jugando=false;
                }                
            } //FIN IF
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
        }
    }

    
}

    
    
    
    

