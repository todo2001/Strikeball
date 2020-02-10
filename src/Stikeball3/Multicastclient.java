package Stikeball3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Multicastclient {
    public static void main(String[] args) throws IOException{
        byte[] bufferIN = new byte[1024]; //buffer di ricezione
        int porta = 6789;
        String gruppo= "255.4.5.6";
        MulticastSocket socket = new MulticastSocket(porta);
        socket.joinGroup(InetAddress.getByName(gruppo));
        DatagramPacket packetIN = new DatagramPacket(bufferIN, bufferIN.length);
        socket.receive(packetIN);
        System.out.println("Ho ricevuto dati di lunghezza"+packetIN.getLength()
        + "da: " +packetIN.getAddress().toString()
        + "porta: " +packetIN.getPort());
        System.out.write(packetIN.getData(),0,packetIN.getLength());
        System.out.println();
        socket.leaveGroup(InetAddress.getByName(gruppo));
        socket.close();
    }
}
