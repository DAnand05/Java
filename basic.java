import javax.swing.*;

public class basic extends JFrame{
    public basic(){
        JButton btn = new JButton("Submit");
        btn.setBounds(50,50,100,50);
        
        add(btn);
        setLayout(null);
        setSize(300,300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new basic();
    }
}