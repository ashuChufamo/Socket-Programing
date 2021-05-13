package client2;

//imported items
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;//for event handling
import java.io.IOException;//exception
import java.io.PrintStream;//to send
import java.net.Socket;//to connect
import java.util.Scanner;// scan
import javax.swing.JButton;//buttons GUI
import javax.swing.JFrame;//the whole frame of the GUI
import javax.swing.JLabel;//notes or lables on the GUI
import javax.swing.JTextField;//field to write

//JFrame fot the frame, Runnable for thread and ActrionListener for event Handling
public class sender extends JFrame implements Runnable, ActionListener{
    
    //some attributes
    String name;
    JButton jb1, jb2,jb3;
    JTextField userText;
    JLabel lb1,lb2;
    
    //constractor of the sender method and the GUI
    public sender(String  name)
    {
        this.name= name;
        lb1=new JLabel("Type and click for whom to send");
        lb2=new JLabel("give text");
        userText= new JTextField(60);
        jb1= new JButton("to server");
        jb2= new JButton("to client1");
        jb3= new JButton("broadcast");
        lb1.setBounds(10, 50, 200, 40);
        lb2.setBounds(10, 100, 200, 40);
        userText.setBounds(90,100,200,30);
        jb1.setBounds(10, 200, 100, 40);
        jb2.setBounds(150, 200, 135, 40);
        jb3.setBounds(75,280,135,40);
        add(jb1);
        add(jb2);
        add(jb3);
        add(lb1);
        add(lb2);
        add(userText);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Client2 sender");
        setLayout(null);
        setSize(400, 400);
        setVisible(true);
        setLocation(900,0);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);
    }
    
    //the event handler
    @Override
    public void actionPerformed(ActionEvent e){
    String text=userText.getText();
    
    //to server
    if (e.getSource()==jb1){
        try
        {
           
            Scanner input= new Scanner(System.in);
            Socket sw;
            sw= new Socket("localhost", 300);
            String text2=name+" says: "+text;
            PrintStream ps= new PrintStream(sw.getOutputStream());
            ps.println(text2);
        }
        catch(Exception ex){System.out.println(ex.getMessage()); }
        }
    
    //to client 1
    else if(e.getSource()==jb2){
        try
        {
           
            Scanner input= new Scanner(System.in);
            Socket sw;
            sw= new Socket("localhost", 200);
            String text2=name+" says: "+text;
            PrintStream ps= new PrintStream(sw.getOutputStream());
            ps.println(text2);   
        }
        catch(Exception ex){System.out.println(ex.getMessage()); }
    
    //to broadcast
    }else if(e.getSource()==jb3){
        try
        {
           
            Scanner input= new Scanner(System.in);
            Socket sw;
                sw= new Socket("localhost", 200);
                String text2=name+" says: "+text;
                PrintStream ps= new PrintStream(sw.getOutputStream());
                ps.println(text2);
                sw= new Socket("localhost", 300);
                ps= new PrintStream(sw.getOutputStream());
                ps.println(text2);
             
        }
        catch(IOException ex){System.out.println(ex.getMessage()); }}}
    
    //the run method
    @Override
    public void run(){}}
