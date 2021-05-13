package server;

import java.net.ServerSocket;//to rate socket server

public class Server {
    public static void main(String[] args) 
    {        
        try
        {
            ServerSocket aa= new ServerSocket(300);//first hs to be created because it is server
            Thread t1= new Thread(new sender());
            Thread t2= new Thread(new acceptor(aa));//separate threads for parallal processing
            t2.start();
            t1.start();}
        catch(Exception ex){System.out.println(ex.getMessage());}           
    }
    
}
