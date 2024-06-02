import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel messageLabel;

    public LoginForm() {
        // Set up frame
        setTitle("Form Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Set up panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));
        getContentPane().add(panel);

        // Username field
        panel.add(new JLabel("User Name:"));
        usernameField = new JTextField(15);
        panel.add(usernameField);

        // Password field
        panel.add(new JLabel("Password:"));
        passwordField = new JPasswordField(15);
        panel.add(passwordField);

        // Message label
        messageLabel = new JLabel("", SwingConstants.CENTER);
        messageLabel.setForeground(Color.RED);
        panel.add(messageLabel);

        // Login button
        JButton loginButton = new JButton("Sign in");
        loginButton.addActionListener(new LoginButtonListener());
        panel.add(loginButton);

        // Layout settings
        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    // Listener for login button
    private class LoginButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            // Check credentials
            if (username.equals("adit") && password.equals("1234")) {
                new WelcomeFrame(username);
                dispose(); // Close login frame
            } else {
                messageLabel.setText("Password atau Username Salah");
            }
        }
    }

    public static void main(String[] args) {
        new LoginForm();
    }
}

class WelcomeFrame extends JFrame {
    public WelcomeFrame(String username) {
        // Set up frame
        setTitle("Form 2");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Set up panel
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        getContentPane().add(panel);

        // Welcome label
        JLabel welcomeLabel = new JLabel("Halo " + username, SwingConstants.CENTER);
        panel.add(welcomeLabel, BorderLayout.CENTER);

        // Back button
        JButton backButton = new JButton("Kembali");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new LoginForm();
                dispose(); // Close welcome frame
            }
        });
        panel.add(backButton, BorderLayout.SOUTH);

        // Layout settings
        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }
}