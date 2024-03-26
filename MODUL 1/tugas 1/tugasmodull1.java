import javax.swing.*;

public class tugasmodull1 {
    private JFrame frame;
    private JPanel panel;
    private JButton adminButton;
    private JButton studentButton;

    public tugasmodull1() {
        frame = new JFrame("Library System");
        panel = new JPanel();
        adminButton = new JButton("Login as admin");
        studentButton = new JButton("Login as student");

        adminButton.addActionListener(to -> admin());
        studentButton.addActionListener(to -> student());

        panel.add(adminButton);
        panel.add(studentButton);

        frame.add(panel);
        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void admin() {
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        Object[] fields = {
                "Username:", usernameField,
                "Password:", passwordField
        };

        int result = JOptionPane.showConfirmDialog(null, fields, "Login as admin", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (username.equals("admin") && password.equals("admin")) {
                JOptionPane.showMessageDialog(null, "Login success!");
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password!");
            }
        }
    }

    public void student() {
        String nim = JOptionPane.showInputDialog("Enter your NIM:");

        if (nim != null && nim.length() == 15) {
            JOptionPane.showMessageDialog(null, "Successful login as student");
        } else {
            JOptionPane.showMessageDialog(null, "Invalid NIM!");
        }
    }

    public static void main(String[] args) {
        new tugasmodull1();
    }
}