import javax.swing.*;

public class trial extends JFrame {
    private JLabel idLabel, fnameLabel, lnameLabel, passwordLabel;
    private JTextField idField, fnameField, lnameField, passwordField;
    private JButton submitButton;

    public trial() {
        setTitle("Registration Form");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize the labels
        idLabel = new JLabel("id:");
        fnameLabel = new JLabel("fname:");
        lnameLabel = new JLabel("lname:");
        passwordLabel = new JLabel("Password:");

        // Initialize the text fields
        idField = new JTextField();
        fnameField = new JTextField();
        lnameField = new JTextField();
        passwordField = new JTextField();

        // Initialize the button
        submitButton = new JButton("Register");

        // Create a panel for the form
        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        // Add the components to the panel
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(idLabel)
                .addComponent(fnameLabel)
                .addComponent(lnameLabel)
                .addComponent(passwordLabel)
            )
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(idField)
                .addComponent(fnameField)
                .addComponent(lnameField)
                .addComponent(passwordField)
                .addComponent(submitButton)
            )
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(idLabel)
                .addComponent(idField)
            )
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(fnameLabel)
                .addComponent(fnameField)
            )
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lnameLabel)
                .addComponent(lnameField)
            )
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(passwordLabel)
                .addComponent(passwordField)
            )
            .addComponent(submitButton)
        );

        // Add the panel to the frame
        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new trial();
    }
}