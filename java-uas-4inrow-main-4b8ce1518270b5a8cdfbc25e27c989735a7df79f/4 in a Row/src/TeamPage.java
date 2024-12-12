import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeamPage extends JFrame {
    public TeamPage() {
        setTitle("Team");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Close this window but keep the main menu open
        setSize(500, 400); // Set window size
        setLocationRelativeTo(null); // Center the window

        // Create a top panel for the back button
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); // Use FlowLayout for the top panel

        // Back Button
        JButton backButton = new JButton("\u2190 Back");
        backButton.setBackground(Color.BLUE);
        backButton.setForeground(Color.WHITE);
        backButton.setFont(new Font("Arial", Font.BOLD, 14));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                returnToMainMenu(); // Method to return to main menu
            }

            private void returnToMainMenu() {
                dispose(); // Close this window
                new MainMenu(); // Open the Main Menu
            }
        });
        topPanel.add(backButton); // Add the back button to the top panel

        // Create a panel for team label and member names
        JPanel centerPanel = new JPanel();
        int red = 97; // Example red value (0-255)
        int green = 165; // Example green value (0-255)
        int blue = 251; // Example blue value (0-255)
        centerPanel.setBackground(new Color(red, green, blue));
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS)); // Vertical stacking

        // Create a label to display team information
        JLabel teamLabel = new JLabel("Our Team:", SwingConstants.CENTER);
        teamLabel.setFont(new Font("Arial", Font.BOLD, 24));
        teamLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center the label in BoxLayout

        // Panel untuk nama anggota tim
        JPanel memberPanel = new JPanel();
        memberPanel.setBackground(new Color(red, green, blue));
        memberPanel.setLayout(new BoxLayout(memberPanel, BoxLayout.Y_AXIS)); // Gunakan layout vertikal

        // Membuat JLabel untuk setiap anggota tim
        JLabel member1 = new JLabel("1. Nabil Arya Muzakki (2310511081)");
        JLabel member2 = new JLabel("2. Naya Marsha Nabila (2310511083)");
        JLabel member3 = new JLabel("3. Mauleni Risqi Handayani (2310511085)");
        JLabel member4 = new JLabel("4. Nayyara Aqila Marshall (231051102)");
        JLabel member5 = new JLabel("5. Elsya Putri Ramdhani (231051103)");

        // Sesuaikan font, warna, dan perataan teks
        Font memberFont = new Font("Arial", Font.PLAIN, 25); // Ukuran font lebih besar
        Color memberColor = Color.WHITE; // Warna teks biru

        member1.setFont(memberFont);
        member1.setForeground(memberColor); // Atur warna font
        member2.setFont(memberFont);
        member2.setForeground(memberColor);
        member3.setFont(memberFont);
        member3.setForeground(memberColor);
        member4.setFont(memberFont);
        member4.setForeground(memberColor);
        member5.setFont(memberFont);
        member5.setForeground(memberColor);

        member1.setAlignmentX(Component.CENTER_ALIGNMENT);
        member2.setAlignmentX(Component.CENTER_ALIGNMENT);
        member3.setAlignmentX(Component.CENTER_ALIGNMENT);
        member4.setAlignmentX(Component.CENTER_ALIGNMENT);
        member5.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Tambahkan setiap JLabel ke panel anggota
        memberPanel.add(member1);
        memberPanel.add(Box.createVerticalStrut(10)); // Jarak antar anggota
        memberPanel.add(member2);
        memberPanel.add(Box.createVerticalStrut(10));
        memberPanel.add(member3);
        memberPanel.add(Box.createVerticalStrut(10));
        memberPanel.add(member4);
        memberPanel.add(Box.createVerticalStrut(10));
        memberPanel.add(member5);

        // Tambahkan label dan panel anggota ke centerPanel
        centerPanel.add(Box.createVerticalGlue()); // Tambahkan ruang kosong di atas
        centerPanel.add(teamLabel);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Tambahkan sedikit jarak
        centerPanel.add(memberPanel);
        centerPanel.add(Box.createVerticalGlue()); // Tambahkan ruang kosong di bawah

        // Panel untuk tata letak utama
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(topPanel, BorderLayout.NORTH);  // Top panel dengan tombol kembali
        mainPanel.add(centerPanel, BorderLayout.CENTER); // Panel tengah dengan info tim

        // Tambahkan panel utama ke frame
        setLayout(new BorderLayout());
        add(mainPanel); // Tambahkan panel utama ke frame

        setVisible(true);
    }

}
