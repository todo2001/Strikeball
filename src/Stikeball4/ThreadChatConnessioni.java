package Stikeball4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadChatConnessioni implements Runnable{
    private ThreadGestioneServizioChat gestoreChat;
    private Socket client = null;
    private BufferedReader input = null;
    private PrintWriter output = null;
    Thread me;
    public ThreadChatConnessioni(ThreadGestioneServizioChat gestoreChat,Socket client){
        this.gestoreChat = gestoreChat;
        this.client=client;
        try {
            this.input = new BufferedReader(new InputStreamReader(client.getInputStream(),true));
            this.output = new PrintWriter (this.client.getOutputStream(),true);
        } catch (Exception ex) {
            output.println("Errore nella Lettura");
        }
        me = new Thread(this);
        me.start();
        
    }    
}
