package client1;

//imported items
import java.awt.Color;//for background color
import java.io.BufferedReader;//message reader
import java.io.InputStreamReader;//message reader
import java.net.ServerSocket;//socket creater
import java.net.Socket;//socket acceptor
import javax.swing.JFrame;//frame 
import javax.swing.JLabel;//some written things
import javax.swing.JTextField;//respose text field 

//JFrame for the frame, Runnable for thread and ActrionListener for event Handling
public class acceptor extends JFrame implements Runnable{
    
    //some attributes
    JLabel lb1;
    JTextField mess;
    //ServerSocket aa;

    //constractor of the acceptor and the GUI
    public acceptor(){//ServerSocket aa){  
        //this.aa= aa;
        
        lb1=new JLabel("messages");
        lb1.setBounds(150, 50, 180, 40);
        mess= new JTextField(60);
        mess.setBackground(Color.ORANGE);
        mess.setBounds(10, 100, 350, 150);
        add(lb1);
        add(mess);
        setTitle("client 1 message Form");
        setLayout(null);
        setSize(400, 300);
        setLocation(450,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);}
    
    //the run method with some acceptor and reader code
    @Override
    public void run() {
        try{
            ServerSocket aa= new ServerSocket(200);
            Socket sw;
            //read what the client sent
            InputStreamReader st;
            BufferedReader br;
            String message=null;
            
            while (message==null || message.equalsIgnoreCase("exit")!=true){
                
                sw= aa.accept();
                st = new InputStreamReader(sw.getInputStream());
                br= new BufferedReader(st);    
                message = br.readLine();
                System.out.println(message);
                mess.setText(message);
            }            
            }
        catch(Exception ex){System.out.println(ex.getMessage());}}
    
}
