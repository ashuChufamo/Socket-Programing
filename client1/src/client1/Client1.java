package client1;

//import java.io.IOException;
//import java.net.ServerSocket;
//import java.util.logging.Level;
//import java.util.logging.Logger;


public class Client1 {
    public static void main(String[] args) 
    {
        try {
//            ServerSocket aa= new ServerSocket(200);
            Thread t1= new Thread(new sender("Client 1"));
            Thread t2= new Thread(new acceptor());//aa));//separate trades so as to get message while typing
            t2.start();
            t1.start();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}