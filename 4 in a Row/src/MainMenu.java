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
        mainPanel.setLayout(new GridBagLayout()); // GridBagLayout untuk center
        add(mainPanel, BorderLayout.CENTER);

        // Panel Tombol
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS)); // Vertikal

        // Tombol Start
        JButton startButton = new JButton("Start");
        startButton.setFont(new Font("Arial", Font.BOLD, 16));
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Tengah secara horizontal
        startButton.addActionListener(e -> {
            dispose(); // Tutup Main Menu
            Player player1 = new Player("Player 1", 'X');
            Player player2 = new Player("Player 2", 'O');
            new fourinarow(player1, player2); // Panggil game
        });
        buttonPanel.add(startButton);

        // Spacer untuk jarak antar tombol
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Spasi vertikal

        // Tombol Exit
        JButton exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial", Font.BOLD, 16));
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Tengah secara horizontal
        exitButton.addActionListener(e -> System.exit(0)); // Keluar aplikasi
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
