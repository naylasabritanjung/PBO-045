import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginForm extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel errorLabel;

    public LoginForm() {
        setTitle("Form Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Halaman Login", SwingConstants.LEFT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JPanel usernamePanel = new JPanel();
        JLabel label1 = new JLabel("Username: ");
        usernameField = new JTextField(15);
        usernamePanel.add(label1);
        usernamePanel.add(usernameField);

        JPanel passwordPanel = new JPanel();
        JLabel label2 = new JLabel("Password: ");
        passwordField = new JPasswordField(15);
        passwordPanel.add(label2);
        passwordPanel.add(passwordField);

        JButton signInButton = new JButton("Sign In");
        signInButton.setPreferredSize(new Dimension(100, 30));

        errorLabel = new JLabel();
        errorLabel.setForeground(Color.RED);

        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(10));
        panel.add(usernamePanel);
        panel.add(passwordPanel);
        panel.add(signInButton);
        panel.add(Box.createVerticalGlue());
        panel.add(errorLabel);

        signInButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (username.equals("admin") && password.equals("1234")) {
                    openWelcomePage(username);
                    clearFields();
                } else {
                    errorLabel.setText("Username atau password salah");
                    clearPasswordField();
                }
            }
        });

        add(panel);
        setVisible(true);
    }

    private void clearFields() {
        usernameField.setText("");
        passwordField.setText("");
        errorLabel.setText("");
    }

    private void clearPasswordField() {
        passwordField.setText("");
    }

    private void openWelcomePage(String username) {
        JFrame welcomeFrame = new JFrame();
        welcomeFrame.setTitle("Welcome Page");

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel welcomeLabel = new JLabel("Halo " + username, SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JButton backButton = new JButton("Kembali");
        backButton.setPreferredSize(new Dimension(100, 30));

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                welcomeFrame.dispose();
                new LoginForm();
            }
        });

        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createVerticalGlue());
        panel.add(welcomeLabel);
        panel.add(Box.createVerticalStrut(20));
        panel.add(backButton);
        panel.add(Box.createVerticalGlue());

        welcomeFrame.add(panel);
        welcomeFrame.setSize(300, 200);
        panel.setPreferredSize(welcomeFrame.getSize());
        welcomeFrame.setLocationRelativeTo(null);

        welcomeFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new LoginForm();
    }
}