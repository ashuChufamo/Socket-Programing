package client2;

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
public class acceptor extends JFrame implements Runnable {
    
    //some attrbutes
    JLabel lb1;
    JTextField mess;

    //constractor of the acceptor and the GUI
    public acceptor(){
        lb1=new JLabel("messages");
        lb1.setBounds(150, 50, 180, 40);
        mess= new JTextField(60);
        mess.setBackground(Color.GRAY);
        mess.setBounds(10, 100, 350, 150);
        add(lb1);
        add(mess);
        setTitle("client 2 message Form");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocation(900,400);
        setVisible(true);}
    
    //the run method with some acceptor and reader code
    @Override
    public void run() {
        try{
            ServerSocket aa= new ServerSocket(400);
            Socket sw;
            InputStreamReader st;
            BufferedReader br;
            String message=null;;
            
            while (message==null || message.equalsIgnoreCase("exit")!=true){
                
                sw= aa.accept();
                //read what the client sent
                st = new InputStreamReader(sw.getInputStream());
                br= new BufferedReader(st);    
                message = br.readLine();
                mess.setText(message);
            
                    }            
            }
        catch(Exception ex){System.out.println(ex.getMessage());}}
    
}

