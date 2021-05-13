package server;

//imported items
import java.awt.Color;//for backgroun color
import java.io.BufferedReader;//message reader
import java.io.InputStreamReader;//message reader
import java.net.ServerSocket;//socket creater
import java.net.Socket;//socket acceptor
import javax.swing.JFrame;//frame 
import javax.swing.JLabel;//some written things
import javax.swing.JTextField;//respose text field 


//JFrame for the frame, Runnable for thread and ActrionListener for event Handling
public class acceptor extends JFrame implements Runnable
{
    //some atributes
    ServerSocket aa;
    JLabel lb1;
    JTextField mess;

    //constractor of the acceptor method and the GUI
    public acceptor(ServerSocket aab){
        this.aa=aab;        
        lb1=new JLabel("messages");
        lb1.setBounds(150, 50, 180, 40);
        mess= new JTextField(60);
        mess.setBackground(Color.pink);
        mess.setBounds(10, 100, 350, 150);
        add(lb1);
        add(mess);
        setTitle("Server message Form");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocation(0,400);
        setVisible(true);}
    
    //the run method
    @Override
    public void run() 
    {
        try
        {
            Socket s= aa.accept();
            InputStreamReader st = new InputStreamReader(s.getInputStream());
            BufferedReader br= new BufferedReader(st);
            String message = br.readLine();   
            while (message==null || message.equalsIgnoreCase("exit")!=true){
                s= aa.accept();
                //read what the client sent
                st = new InputStreamReader(s.getInputStream());
                br= new BufferedReader(st);    
                message = br.readLine();
                System.out.println(message);  
                mess.setText(message);
            }
        }
        catch(Exception ex){System.out.println(ex.getMessage()); }
    }
    
}
