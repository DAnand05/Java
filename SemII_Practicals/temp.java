package SemII_Practicals;
import javax.swing.*;
class temp extends JFrame{
    
    temp(){
        JButton btn=new JButton("click");
        btn.setBounds(100,50,100,100);
        add(btn);
        setLayout(null);
        setVisible(true);
        setSize(300,500);

    }
    public static void main(String[] args) {
        new temp();
    }
}