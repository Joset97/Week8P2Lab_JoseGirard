/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperJamesGalaxy;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jrgir
 */
public class HiloLables implements Runnable {

    private JComboBox box;
    private JProgressBar barra;
    private JLabel partida;
    private JLabel jugador;
    private JLabel distanciaT;
    private JLabel distanciaR;
    private JLabel star;
    private JTable table;
    private boolean jugando=true;
    private boolean estado=true;

    public HiloLables(JComboBox box, JProgressBar barra, JLabel partida, JLabel jugador, JLabel distanciaT, JLabel distanciaR, JLabel star, JTable table) {
        this.box = box;
        this.barra = barra;
        this.partida = partida;
        this.jugador = jugador;
        this.distanciaT = distanciaT;
        this.distanciaR = distanciaR;
        this.star = star;
        this.table = table;
    }

    public JComboBox getBox() {
        return box;
    }

    public void setBox(JComboBox box) {
        this.box = box;
    }

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    public JProgressBar getBarra() {
        return barra;
    }

    public void setBarra(JProgressBar barra) {
        this.barra = barra;
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

    public JLabel getPartida() {
        return partida;
    }

    public void setPartida(JLabel partida) {
        this.partida = partida;
    }

    public JLabel getJugador() {
        return jugador;
    }

    public void setJugador(JLabel jugador) {
        this.jugador = jugador;
    }

    public JLabel getDistanciaT() {
        return distanciaT;
    }

    public void setDistanciaT(JLabel distanciaT) {
        this.distanciaT = distanciaT;
    }

    public JLabel getDistanciaR() {
        return distanciaR;
    }

    public void setDistanciaR(JLabel distanciaR) {
        this.distanciaR = distanciaR;
    }

    public JLabel getStar() {
        return star;
    }

    public void setStar(JLabel star) {
        this.star = star;
    }

    @Override
    public void run() {
        int fila = 0;
        int pos = 0;
        int Inicio = 0;
        while (jugando) {
            try {
                String partida;//=((String)((DefaultTableModel) table.getModel()).getValueAt(fila, 0));
                String jugador = ((String) ((DefaultTableModel) table.getModel()).getValueAt(0, fila));
                String Star = ((String) ((DefaultTableModel) table.getModel()).getValueAt(2, fila));
                String distancT = ((String) ((DefaultTableModel) table.getModel()).getValueAt(3, fila));
                String distanciaR;//  =((String)((DefaultTableModel) table.getModel()).getValueAt(fila, 4));

                partida = ((Partidas) ((DefaultComboBoxModel) box.getModel()).getSelectedItem()).getNombre();
                this.partida.setText(partida);
                this.jugador.setText(jugador);
                star.setText(Star);
                distanciaT.setText(distancT);

                if (estado) {

                    distanciaR = (String.valueOf(barra.getValue() + ((int) ((DefaultTableModel) table.getModel()).getValueAt(1, fila))));
                    this.distanciaR.setText(distanciaR);
                    barra.setValue(barra.getValue() + ((int) ((DefaultTableModel) table.getModel()).getValueAt(1, fila)));
                    if (barra.getValue() >= ((int) ((DefaultTableModel) table.getModel()).getValueAt(3, fila))) {
                        barra.setValue(Inicio);
                        pos++;
                        jugando = false;
                    }
                } //FIN IF

                try {
                    Thread.sleep(100000);
                } catch (InterruptedException ex) {
                }
            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }
    }

}
