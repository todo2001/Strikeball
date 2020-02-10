package Stikeball3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {
    public static void main(String[] args) throws IOException {
        boolean attivo = true;
        byte[] bufferOUT = new byte[1024];
        int conta = 20;
        int porta = 6789;
        InetAddress gruppo = InetAddress.getByName("255.4.5.6");
        MulticastSocket socket = new MulticastSocket(porta);
        String dstring = null;
        while(attivo){
            dstring = new Date().toString();
            bufferOUT = dstring.getBytes();
            DatagramPacket packet = new DatagramPacket(bufferOUT,bufferOUT.length, gruppo, porta);
            socket.send(packet);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }
                conta--;
                if(conta==0){
                    System.out.println("SERVER IN CHIUSURA");
                    attivo=false;
                }
                else{
                    System.out.println("SERVER attivo per altri secondi"+conta);
                }
                
        }
        socket.close();
        }
    }
    

