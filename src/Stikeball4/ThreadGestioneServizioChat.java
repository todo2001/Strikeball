
package Stikeball4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ThreadGestioneServizioChat {
    private int NmaxConnessioni;
    private List lista;
    private ThreadChatConnessioni[] listaconnessioni;
    Thread me;
    private ServerSocket serverchat;
    public ThreadGestioneServizioChat (int NmaxConnessioni,List lista){
    this.NmaxConnessioni = NmaxConnessioni;
    this.lista = lista;
    this.listaconnessioni = new ThreadChatConnessioni[this.NmaxConnessioni];
    me = new Thread((Runnable) this);
    me.start();
}
    public void run(){
        boolean continua = true;
        try {
            serverchat = new ServerSocket(6789);
        } catch (IOException ex) {
            Logger.getLogger(ThreadGestioneServizioChat.class.getName()).log(Level.SEVERE, null, ex);
            continua = false;
        }
        if(continua){
            try{
            for(int xx=0;xx<NmaxConnessioni;xx++){
                Socket tempo = null;
                tempo = serverchat.accept();
                listaconnessioni[xx] = new ThreadChatConnessioni(this,tempo);
            }
            serverchat.close();}
            catch(Exception e){
                JOptionPane.showMessageDialog(null,"impossibile instanziare server chat");
            }
            
        }
    }
    public void spedisciMessaggi(String mex){
        lista.add(mex);
        lista.select(lista.getItenCount()-1);
        for(int xx=0;xx<this.NmaxConnessioni;xx++){
        if(listaconnessioni[xx]!=null){
            listaconnessioni[xx].spedisciMessaggiochat(mex);
        }
    }
    }
}