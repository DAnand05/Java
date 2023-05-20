package SemII_Practicals;
import java.awt.event.*;

import javax.swing.*;
class first extends JFrame implements ActionListener{
        first(){

            JLabel l = new JLabel("LOL");
            l.setBounds(50,20,100,25);
            add(l);

            JTextField t= new JTextField("");
            t.setBounds(100,20,100,25);
            add(t);

            JPasswordField pwd = new JPasswordField();
            pwd.setBounds(100,80,100,25);
            add(pwd);

            JList li=new JList<String>();
            add(li);
            li.setBounds(100,200,100,50);

            JButton b=new JButton("Click Me!!!");
            b.setBounds(100,150,100,40);
            add(b);
            b.addActionListener(this);

            JScrollBar sb=new JScrollBar();
            add(sb);

            setSize(300,300);
            setLayout(null);
            setVisible(true);
        }
        public void actionPerformed(ActionEvent e){
            Calc c=new Calc();
        }
        public static void main(String[] args) {
            new first();
        }        
        /*lol */
}
