package stikeball;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread extends Thread{
    ServerSocket server = null;
    Socket client = null;
    String stringaIn = null;
    String stringaOut = null;
    BufferedReader inDalClient;
    DataOutputStream outVersoClient;
    
    public ServerThread(Socket socket){
        this.client = socket;
    }
    @Override
    public void run(){
        try{
            comunica();
        }
        catch (Exception e){
            e.printStackTrace(System.out);
        }
    }
    public void comunica() throws Exception{
        inDalClient = new BufferedReader (new InputStreamReader(client.getInputStream()));
        outVersoClient = new DataOutputStream(client.getOutputStream());
        while(true){
            stringaIn = inDalClient.readLine();
            if(stringaIn == null || stringaIn.equals("FINE")){
                outVersoClient.writeBytes(stringaIn + ("-->Server in chiusura")+ "\n");
                System.out.println("Echo sul server in chiusura:" + stringaIn);
                break;
            }
            else{
                outVersoClient.writeBytes(stringaIn+"(ricevuta e ritrasmessa)"+'\n');
                System.out.println("6 echo sul server: " +stringaIn);
                }
        }
            outVersoClient.close();
            inDalClient.close();
            System.out.println("9 Chiusura socket" + client);
            client.close();
        
    
    
    }
    
    
    
}
