
package stikeball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {
    public static void main(String[] args) {

        Socket socket = null;
        String indirizzo = null;
        try{
            socket = new Socket("127.0.0.1", 2200);
            indirizzo = InetAddress.getLocalHost().getHostAddress();
            System.out.println(indirizzo);
            System.out.println("Connessione aperta");
            BufferedReader in = new BufferedReader(new InputStreamReader(Stikeball.getInputStream()));
            PrintWriter output=new PrintWriter(Stikeball.getOutputStream(),true);
            String clientMessage=in.readLine();
            in.close();
            output.close();
        }
        catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        finally{
            try {
                   if (socket!=null)
                {
                    socket.close();
                    System.out.println("Connessione chiusa!");
                }
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }
    }

