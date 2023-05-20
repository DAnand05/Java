package jdbc;

import java.awt.event.*;
import javax.swing.*;

public class StudentManagement extends JFrame {
    private JButton btn1,btn2,btn3,btn4,btn5;

    public StudentManagement(){
        super("Student Management");

        btn1=new JButton("Add Data");
        btn2=new JButton("Delete Data");
        btn3=new JButton("Display Data");
        btn4=new JButton("Modify Data");
        btn5=new JButton("Exit");

        btn1.setBounds(25, 25, 150, 50);
        btn2.setBounds(200, 25, 150, 50);
        btn3.setBounds(25, 100, 150, 50);
        btn4.setBounds(200, 100, 150, 50);
        btn5.setBounds(100, 175, 150, 50);

        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                new AddData();
                //openFile("AddData.java");
            }
        });

        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                DeleteData deleteData = new DeleteData();
                deleteData.loadTableData();
                deleteData.setVisible(true);
            }
        });

        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                new DisplayData();
                //openFile("DisplayData.java");
            }
        });

        btn4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                new ModifyData();
                //openFile("DisplayData.java");
            }
        });

        btn5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                dispose();
            }
        });

        add(btn1);
        add(btn2);   
        add(btn3);
        add(btn4);
        add(btn5);
        
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setVisible(true);

    }
    /* 
    public void openFile(String fileName){
        try{
            File file=new File(fileName);
            if(!file.exists()){
                JOptionPane.showMessageDialog(this,"file not found: "+ fileName);
                return;
            }
            Desktop.getDesktop().open(file);
        }catch (IOException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,"Error opening file :"+ e.getMessage());
        }
    }
*/
    public static void main(String[] args) {
        new StudentManagement();
    }
}
