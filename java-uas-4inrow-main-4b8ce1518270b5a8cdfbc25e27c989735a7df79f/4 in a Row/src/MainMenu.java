import java.awt.*;
import javax.swing.*;

public class MainMenu extends JFrame {

    public MainMenu() {
        setTitle("4 in a Row - Main Menu");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout()); // BorderLayout untuk tata letak utama

        // Label Judul
        JLabel titleLabel = new JLabel("Welcome to 4 in a Row!");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH); // Tambahkan di atas

        // Panel Utama (Untuk Pusatkan Tombol)
        JPanel mainPanel = new JPanel();
        int red = 97; // Example red value (0-255)
        int green = 165; // Example green value (0-255)
        int blue = 251; // Example blue value (0-255)
        mainPanel.setBackground(new Color(red, green, blue));
        mainPanel.setLayout(new GridBagLayout()); // GridBagLayout untuk center
        add(mainPanel, BorderLayout.CENTER);

        // Panel Tombol
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(red,green, blue));
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS)); // Vertikal

        // Tombol Start
        JButton startButton = new JButton("Start");
        startButton.setBackground(Color.BLUE); // Add this line
        startButton.setForeground(Color.WHITE); // Add this line for better contrast
        startButton.setFont(new Font("Arial", Font.BOLD, 16));
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        startButton.addActionListener(e -> {
            dispose();
            Player player1 = new Player("Player 1", 'X');
            Player player2 = new Player("Player 2", 'O');
            new fourinarow(player1, player2);
        });
        buttonPanel.add(startButton);

        // Add a spacer between buttons
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Tombol About Us
        JButton Au = new JButton("About Us");
        Au.setBackground(Color.BLUE);
        Au.setForeground(Color.WHITE);
        Au.setFont(new Font("Arial", Font.BOLD, 16));
        Au.setAlignmentX(Component.CENTER_ALIGNMENT);
        Au.addActionListener(e -> {
            new TeamPage(); // Open the Team Page when clicked
        });
        buttonPanel.add(Au);

        // Add a spacer between buttons
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Tombol Exit
        JButton exitButton = new JButton("Exit");
        exitButton.setBackground(Color.RED); // Add this line
        exitButton.setForeground(Color.WHITE); // Add this line for better contrast
        exitButton.setFont(new Font("Arial", Font.BOLD, 16));
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.addActionListener(e -> System.exit(0));
        buttonPanel.add(exitButton);


        // Tambahkan buttonPanel ke mainPanel
        mainPanel.add(buttonPanel);

        setLocationRelativeTo(null); // Center window di layar
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainMenu();
    }
}
