
package stikeball;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client2 {
    Socket miosocket;
    String stringaIn = null;
    String StringaRicevutaDalServer = null;
    String StringaUtente = null;
    BufferedReader tastiera;
    BufferedReader inDalServer;
    DataOutputStream outVersoServer;
    
    
    
    public void comunica(){
        while(true)
        try{
            tastiera = new BufferedReader(new InputStreamReader(System.in));
            outVersoServer = new DataOutputStream(miosocket.getOutputStream());
            inDalServer = new BufferedReader(new InputStreamReader(miosocket.getInputStream()));
            System.out.println("4...Utente,Inserisci la stringa da trasmettere al server");
            StringaUtente = tastiera.readLine();
            System.out.println("5...invio la stringa al server e attendo");
            
            outVersoServer.writeBytes(StringaUtente +'\n');
            
            StringaRicevutaDalServer = inDalServer.readLine();
            System.out.println("7...Risposta dal server"+'\n'+StringaRicevutaDalServer);
            if(StringaUtente.equals("FINE")){
                System.out.println("8 CLIENT: termina elaborazione e chiude connessione");
                miosocket.close();
                break;
            }
        
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("Errore durante la comunicazione col server");
            System.exit(1);
        }
    }
    public Socket connetti(){
        System.out.println("2 Client partito in esecuzione");
        tastiera = new BufferedReader(new InputStreamReader(System.in));
        try {
            miosocket = new Socket("127.0.0.1",3000);
        } catch (IOException ex) {
            Logger.getLogger(Client2.class.getName()).log(Level.SEVERE, null, ex);
        }
        return miosocket;
    }
    
    
    
    }