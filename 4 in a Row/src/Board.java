public class Board {
    private final int rows = 6;
    private final int cols = 7;
    private final char[][] grid;

    public Board() {
        grid = new char[rows][cols];
        initializeBoard();
    }


    public void initializeBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = '-'; // Kosong
            }
        }
    }

    // Menambahkan metode clearBoard untuk reset board
    public void clearBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = '-'; // Reset semua elemen menjadi '-'
            }
        }
    }

    public boolean dropDisc(int col, char disc) {
        if (col < 0 || col >= cols || grid[0][col] != '-') {
            return false; // Kolom penuh atau invalid
        }
        for (int i = rows - 1; i >= 0; i--) {
            if (grid[i][col] == '-') {
                grid[i][col] = disc;
                return true;
            }
        }
        return false;
    }

    public boolean checkWin(char disc) {
        // Logika cek kemenangan (horizontal, vertikal, diagonal)
        // Horizontal
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <= cols - 4; j++) {
                if (grid[i][j] == disc && grid[i][j + 1] == disc &&
                        grid[i][j + 2] == disc && grid[i][j + 3] == disc) {
                    return true;
                }
            }
        }
        // Vertikal
        for (int i = 0; i <= rows - 4; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == disc && grid[i + 1][j] == disc &&
                        grid[i + 2][j] == disc && grid[i + 3][j] == disc) {
                    return true;
                }
            }
        }
        // Diagonal (\)
        for (int i = 0; i <= rows - 4; i++) {
            for (int j = 0; j <= cols - 4; j++) {
                if (grid[i][j] == disc && grid[i + 1][j + 1] == disc &&
                        grid[i + 2][j + 2] == disc && grid[i + 3][j + 3] == disc) {
                    return true;
                }
            }
        }
        // Diagonal (/)
        for (int i = 0; i <= rows - 4; i++) {
            for (int j = 3; j < cols; j++) {
                if (grid[i][j] == disc && grid[i + 1][j - 1] == disc &&
                        grid[i + 2][j - 2] == disc && grid[i + 3][j - 3] == disc) {
                    return true;
                }
            }
        }
        return false;
    }

    public char[][] getGrid() {
        return grid;
    }

    public void displayBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}