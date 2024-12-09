import java.awt.*;
import javax.swing.*;

public class LoginWindow extends JFrame {
    private final JTextField usernameField;
    private final JPasswordField passwordField;
    private final JCheckBox rememberMeCheckBox;
    private JPasswordField passwordField2;

    public LoginWindow() {
        setTitle("EduTrack Login Adventure!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        setResizable(false);

        // Playful color palette with multiple shades of blue
        Color deepBlue = new Color(25, 118, 210);
        Color ultraLightBlue = new Color(227, 242, 253);

        // Set playful theme
        UIManager.put("Button.background", deepBlue);
        UIManager.put("Button.foreground", Color.WHITE);
        UIManager.put("TextField.background", Color.WHITE);
        UIManager.put("TextField.foreground", Color.BLACK);
        getContentPane().setBackground(ultraLightBlue);

        // Playful bouncy input fields
        usernameField = createBouncyTextField(20);
        passwordField = createBouncyPasswordField(20);
        
        // Sparkly remember me checkbox
        rememberMeCheckBox = new JCheckBox("✨ Remember Me ✨");
        rememberMeCheckBox.setForeground(deepBlue);
        rememberMeCheckBox.setBackground(ultraLightBlue);

        // Create a playful greeting label
        JLabel greetingLabel = new JLabel("Welcome to EduTrack!");
        greetingLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        greetingLabel.setForeground(deepBlue);

        JButton loginButton = createPlayfulButton("Login 🎓");
        loginButton.addActionListener(e -> login());

        // Layout configuration
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;

        // Add greeting label
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(greetingLabel, gbc);

        // Add username components
        gbc.gridwidth = 1;
        gbc.gridy++;
        gbc.gridx = 0;
        JLabel usernameLabel = new JLabel("📧 Username:");
        usernameLabel.setForeground(deepBlue);
        add(usernameLabel, gbc);
        gbc.gridx++;
        add(usernameField, gbc);
        
        // Add password components
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel passwordLabel = new JLabel("🔐 Password:");
        passwordLabel.setForeground(deepBlue);
        add(passwordLabel, gbc);
        gbc.gridx++;
        add(passwordField, gbc);

        // Add remember me checkbox
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        add(rememberMeCheckBox, gbc);

        // Add login button
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        add(loginButton, gbc);

        // Final adjustments
        pack();
        setSize(600, 450); // Slightly taller for playful elements
        setLocationRelativeTo(null);
    }

    private JTextField createBouncyTextField(int columns) {
        JTextField textField = new JTextField(columns);
        textField.setBorder(BorderFactory.createCompoundBorder(
            textField.getBorder(), 
            BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));
        return textField;
    }

    private JPasswordField createBouncyPasswordField(int columns) {
        passwordField2 = new JPasswordField(columns);
        passwordField2.setBorder(BorderFactory.createCompoundBorder(
            passwordField2.getBorder(), 
            BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));
        return passwordField2;
    }

    private JButton createPlayfulButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        button.setFocusPainted(false);
        button.setBackground(new Color(25, 118, 210)); // Deep blue
        button.setForeground(Color.WHITE);
        button.setBorderPainted(false);
        
        // Add a subtle hover effect
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(33, 150, 243)); // Lighter blue on hover
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(25, 118, 210));
            }
        });

        return button;
    }

    private void login() {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword()).trim();

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "🚫 Oops! Username and password cannot be empty.", 
                "Login Error", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Implement your login logic here
        // For demonstration, we're directly opening the next window
        StudentProgressSystem studentProgressSystem = new StudentProgressSystem();
        studentProgressSystem.setVisible(true);
        dispose(); // close the login window
    }
}