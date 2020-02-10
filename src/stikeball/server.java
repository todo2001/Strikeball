package stikeball;
import java.net.*;
import java.io.*;
public class server{
    public void star(){
        try{
            ServerSocket server = new ServerSocket(3000);
            while(true){
                System.out.println(" Server in attesa ...");
                Socket socket = server.accept();
                System.out.println("3 Server socket" + socket);
                ServerThread serverthre = new ServerThread(socket);
                serverthre.run();
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("Errore durante l'istanza del server");
            System.exit(1);
        }
                
    }
    
}

