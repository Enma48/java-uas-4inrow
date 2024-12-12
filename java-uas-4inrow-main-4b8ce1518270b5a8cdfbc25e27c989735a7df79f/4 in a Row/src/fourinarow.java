import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class fourinarow extends JFrame {
    private final Board board;
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;
    private final CirclePanel[][] panels;
    private final JLabel statusLabel;

    public fourinarow(Player player1, Player player2) {
        this.board = new Board();
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
        this.panels = new CirclePanel[6][7];
        this.statusLabel = new JLabel("Welcome to 4 in a Row! " + currentPlayer.getName() + "'s turn.");

        initializeGUI();
    }

    private void initializeGUI() {
        setTitle("4 in a Row");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 900); // Ukuran jendela disesuaikan untuk ruang tombol
        setLayout(new BorderLayout());

        // Panel atas untuk tombol "Back", status, dan tombol "Reset"
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());

        // Tombol "Back"
        JButton backButton = new JButton("\u2190 Back");
        backButton.setBackground(Color.BLUE);
        backButton.setForeground(Color.WHITE);
        backButton.setFont(new Font("Arial", Font.BOLD, 14));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                returnToMainMenu(); // Method untuk balik ke menu utama
            }
        });
        topPanel.add(backButton, BorderLayout.WEST);

        // Label status di tengah
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 16));
        topPanel.add(statusLabel, BorderLayout.CENTER);

        // Tombol "Reset" di kanan atas
        JButton resetButton = new JButton("Reset");
        resetButton.setBackground(Color.BLUE);
        resetButton.setForeground(Color.WHITE);
        resetButton.setFont(new Font("Arial", Font.BOLD, 14));
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGame(); // Method untuk reset game
            }
        });
        topPanel.add(resetButton, BorderLayout.EAST);

        add(topPanel, BorderLayout.NORTH);

        // Game Board Panel
        JPanel boardPanel = new JPanel();
        boardPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // This sets a black line border with a thickness of 2 pixels.
        boardPanel.setLayout(new GridLayout(6, 7));
        boardPanel.setPreferredSize(new Dimension(600, 500)); // Ukuran tetap grid papan permainan

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                panels[i][j] = new CirclePanel();
                panels[i][j].setPreferredSize(new Dimension(80, 80)); // Ukuran tetap tiap lingkaran
                boardPanel.add(panels[i][j]);
            }
        }

        // Panel pembungkus untuk memastikan ukuran grid tetap
        JPanel boardWrapper = new JPanel();
        int red = 97; // Example red value (0-255)
        int green = 165; // Example green value (0-255)
        int blue = 251; // Example blue value (0-255)
        boardWrapper.setBackground(new Color(red, green, blue));
        boardWrapper.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 40));
        boardWrapper.add(boardPanel);

        add(boardWrapper, BorderLayout.CENTER);

        // Column Selection Panel
        JPanel columnPanel = new JPanel();
        columnPanel.setLayout(new GridLayout(1, 7, 5, 0)); // Tambah gap horizontal antar tombol
        columnPanel.setPreferredSize(new Dimension(600, 80)); // Ukuran tetap untuk tombol kolom

        for (int j = 0; j < 7; j++) {
            JButton colButton = new JButton("\u2191");
            colButton.setFont(new Font("Arial", Font.BOLD, 24));  // This increases the font size to make the arrow larger
            colButton.setPreferredSize(new Dimension(80, 80));    // This ensures the button is large enough to display the arrow clearly

            final int col = j; // Untuk menyimpan indeks kolom dalam listener
            colButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    handleColumnSelection(col);
                }
            });
            columnPanel.add(colButton);
        }

        // Panel pembungkus untuk tombol bawah
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(new Color(red, green, blue));
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0)); // Letakkan tombol di tengah
        bottomPanel.add(columnPanel);

        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void resetGame() {
        // Reset papan permainan
        board.initializeBoard();

        // Reset giliran ke Player 1
        currentPlayer = player1;

        // Update papan ke warna awal (putih)
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                panels[i][j].setColor(Color.WHITE);
            }
        }

        // Update status label
        statusLabel.setText("Welcome to 4 in a Row! " + currentPlayer.getName() + "'s turn.");

        // Aktifkan kembali tombol kolom
        enableColumnSelection();
    }

    private void enableColumnSelection() {
        for (Component comp : getContentPane().getComponents()) {
            if (comp instanceof JPanel) {
                for (Component button : ((JPanel) comp).getComponents()) {
                    if (button instanceof JButton) {
                        button.setEnabled(true);
                    }
                }
            }
        }
    }


    private void handleColumnSelection(int col) {
        // Attempt to drop a disc
        if (board.dropDisc(col, currentPlayer.getDisc())) {
            updateBoard();

            // Check for a win
            if (board.checkWin(currentPlayer.getDisc())) {
                statusLabel.setText(currentPlayer.getName() + " wins!");
                disableColumnSelection();

                Timer timer = new Timer(2000, e -> returnToMainMenu());
                timer.setRepeats(false); // Timer hanya dijalankan sekali
                timer.start();

                return;
            }

            // Check for a draw
            if (board.isFull()) {
                statusLabel.setText("It's a draw!");
                disableColumnSelection();

                Timer timer = new Timer(2000, e -> returnToMainMenu());
                timer.setRepeats(false); // Timer hanya dijalankan sekali
                timer.start();

                return;
            }

            // Switch turns
            currentPlayer = (currentPlayer == player1) ? player2 : player1;
            statusLabel.setText(currentPlayer.getName() + "'s turn.");
        } else {
            statusLabel.setText("Column full! Try a different column.");
        }
    }

    private void updateBoard() {
        char[][] grid = board.getGrid();
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (grid[i][j] == player1.getDisc()) {
                    panels[i][j].setColor(Color.BLACK); // Pemain 1 (hitam)
                } else if (grid[i][j] == player2.getDisc()) {
                    int red = 255; // Example red value (0-255)
                    int green = 32; // Example green value (0-255)
                    int blue = 155; // Example blue value (0-255)

                    panels[i][j].setColor(new Color(red, green, blue));// Pemain 2 (pink)
                } else {
                    panels[i][j].setColor(Color.WHITE); // Kotak kosong (putih)
                }
            }
        }
    }

    private void disableColumnSelection() {
        for (Component comp : getContentPane().getComponents()) {
            if (comp instanceof JPanel) {
                for (Component button : ((JPanel) comp).getComponents()) {
                    if (button instanceof JButton) {
                        button.setEnabled(false);
                    }
                }
            }
        }
    }

    private void returnToMainMenu() {
        dispose(); // Tutup jendela game
        new MainMenu(); // Panggil Main Menu
    }

    public static void main(String[] args) {
        Player player1 = new Player("Player 1", 'X');
        Player player2 = new Player("Player 2", 'O');
        new fourinarow(player1, player2);
    }
}

// Custom JPanel for circles
class CirclePanel extends JPanel {
    private Color color = Color.WHITE;

    public void setColor(Color color) {
        this.color = color;
        repaint(); // Redraw panel with new color
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(color);

        // Cari sisi terpendek untuk lingkaran sempurna
        int diameter = Math.min(getWidth(), getHeight());
        int x = (getWidth() - diameter) / 2;  // Posisi X supaya di tengah
        int y = (getHeight() - diameter) / 2; // Posisi Y supaya di tengah

        g2d.fillOval(x, y, diameter, diameter); // Gambar lingkaran
    }
}
