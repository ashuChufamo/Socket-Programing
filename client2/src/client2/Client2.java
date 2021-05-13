package client2;

//import java.net.ServerSocket;

public class Client2 {
    public static void main(String[] args) 
    {
        //ServerSocket aa= new ServerSocket(300);
        Thread t1= new Thread(new sender("Client 2"));
        Thread t2= new Thread(new acceptor());//aa));//two threads for parallel processing
        t2.start();
        t1.start();
    }
}
