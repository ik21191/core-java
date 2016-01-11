package window;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Win1 implements ActionListener,ItemListener
{
    JTextField f1,f2;
    JButton b1;
    JLabel l1,l2,l3;
    JCheckBox cb;
    JList list1;
    public Win1()
    {
        JFrame frame=new JFrame();
        frame.setTitle("MyWindow");
        Container c=frame.getContentPane();
        c.setLayout(null);
        l1=new JLabel();
        l1.setText("Enter A");
        l1.setBounds(20,50,100,25);
        c.add(l1);
        l2=new JLabel();
        l2.setText("Enter B");
        l2.setBounds(20,100,100,25);
        c.add(l2);
        f1=new JTextField();
        f1.setBounds(100,50,100,25);
        c.add(f1);
        f2=new JTextField();
        f2.setBounds(100,100,100,25);
        c.add(f2);
        b1=new JButton();
        b1.setText("Add");
        b1.setBounds(100,300,100,25);
        b1.addActionListener(this);
        c.add(b1);
        l3=new JLabel();
        l3.setBounds(250,300,100,25);
        l3.setVisible(false);
        c.add(l3);
        String val[]={"1","2","3","4","5"};
        list1=new JList(val);
        list1.setSelectedIndex(0);
        list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list1.setBounds(250,400,100,100);
        c.add(list1);
        frame.setSize(500,600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
   
    public void itemStateChanged(ItemEvent e)
    {
        
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            System.out.println("Button b1 is clicked.");
            int a=Integer.parseInt(f1.getText());
            int b=Integer.parseInt(f2.getText());
            int c=a+b;
            l3.setText("Addition is "+c);
            l3.setVisible(true);
        }
    }
    
    public static void main(String arr[])
    {
        Win1 w=new Win1();
    }
}
