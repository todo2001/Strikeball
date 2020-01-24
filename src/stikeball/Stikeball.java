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
    public static void main(String[] args) {
         Socket socket = null;
        String indirizzo = null;
         ServerSocket server = null;
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
             BufferedReader input = new BufferedReader(new InputStreamReader(Client.getInputStream()));
            PrintWriter out = new PrintWriter(Client.getOutputStream(), true);
            String clientMessage=input.readLine();
            out.println("ciao");
            input.close();
            out.close();
            
            
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
  