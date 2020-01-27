package stikeball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Stikeball {
    public static void main(String[] args) throws IOException {
         Socket socket = null;
        String indirizzo = null;
         ServerSocket server = null;
         String messaggio;
        boolean connesso = false;
        try {
            server = new ServerSocket(2200);
        } catch (IOException ex) {
            Logger.getLogger(Stikeball.class.getName()).log(Level.SEVERE, null, ex);
        }
        try{
            indirizzo = InetAddress.getLocalHost().getHostAddress();
            System.out.println("\n--- In Attesa di Connessione ---");
            socket = server.accept();
            System.out.println("Connessione stabilita!");
            System.out.println(indirizzo);
            System.out.println("Server Socket:" + socket.getLocalSocketAddress());
            System.out.println("Socket client:" + socket.getRemoteSocketAddress());
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            messaggio = in.readLine();
            System.out.println("Messaggio dal Client:"+ messaggio);
            out.println("ciao sono il serverS");
        }catch(SocketTimeoutException e){
            System.out.println("Errore di I/O");
        }
        catch (IOException ex) {
            Logger.getLogger(Stikeball.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
            try{
            if(socket!=null) {
                socket.close();
            }
            } catch (IOException ex) {
                 Logger.getLogger(Stikeball.class.getName()).log(Level.SEVERE, null, ex);
            }
             System.out.println("Connessione chiusa!");
            
            
    }



    }
  