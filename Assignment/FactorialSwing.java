package Assignment;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
 
public class FactorialSwing extends JFrame implements ActionListener
{
    private static final long serialVersionUID = 1L;
    static JFrame frame;
    static JLabel l1, l2;
    static JTextField t1, t2;
    static JButton b;
 
    FactorialSwing()
    {
        l1 = new JLabel("Enter Number");
        l1.setBounds(50, 50, 100, 20);
 
        t1 = new JTextField();
        t1.setBounds(150, 50, 100, 20);
 
        b = new JButton("Find Factorial");
        b.setBounds(50, 100, 250, 20);
        b.addActionListener(this);
 
        l2 = new JLabel("Factorial");
        l2.setBounds(50, 150, 100, 20);
   
        t2 = new JTextField();
        t2.setBounds(150, 150, 100, 20);
 
        add(l1);
        add(t1);
        add(b);
        add(l2);
        add(t2);
 
        setSize(500,500);
        setLayout(null);
        setVisible(true);
    }
 
    public void actionPerformed(ActionEvent e)
    {
        int n = Integer.parseInt(t1.getText());
        int fact = fact(n);
        t2.setText(String.valueOf(fact));
    }
 
    static int fact(int n)
    {
        int output;
        if(n==1){
          return 1;
        }
        output = fact(n-1)* n;
        return output;
    }
   
    public static void main(String[] args)
    {
        frame = new FactorialSwing();
        frame.setTitle("Factorial of a Number");
    }
}
