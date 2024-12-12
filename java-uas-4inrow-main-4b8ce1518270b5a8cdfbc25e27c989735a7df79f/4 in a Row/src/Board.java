class Board {
    private final int rows = 6;
    private final int cols = 7;
    private final char[][] grid;

    public Board() {
        grid = new char[6][7];
        initializeBoard();
    }

    public void initializeBoard() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                grid[i][j] = ' ';
            }
        }
    }

    public boolean dropDisc(int col, char disc) {
            for (int i = 5; i >= 0; i--) {
                if (grid[i][col] == ' ') {
                    grid[i][col] = disc;
                    return true;
                }
            }
            return false;
        }

        public char[][] getGrid () {
            return grid;
        }

        public boolean checkWin ( char disc){
            // Check horizontal win
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 4; j++) {
                    if (grid[i][j] == disc && grid[i][j + 1] == disc && grid[i][j + 2] == disc && grid[i][j + 3] == disc) {
                        return true;
                    }
                }
            }

            // Check vertical win
            for (int j = 0; j < 7; j++) {
                for (int i = 0; i < 3; i++) {
                    if (grid[i][j] == disc && grid[i + 1][j] == disc && grid[i + 2][j] == disc && grid[i + 3][j] == disc) {
                        return true;
                    }
                }
            }

            // Check diagonal win (bottom left to top right)
            for (int i = 3; i < 6; i++) {
                for (int j = 0; j < 4; j++) {
                    if (grid[i][j] == disc && grid[i - 1][j + 1] == disc && grid[i - 2][j + 2] == disc && grid[i - 3][j + 3] == disc) {
                        return true;
                    }
                }
            }

            // Check diagonal win (top left to bottom right)
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 4; j++) {
                    if (grid[i][j] == disc && grid[i + 1][j + 1] == disc && grid[i + 2][j + 2] == disc && grid[i + 3][j + 3] == disc) {
                        return true;
                    }
                }
            }

            return false;
        }

        public boolean isFull() {
            for (int j = 0; j < 7; j++) {
                if (grid[0][j] == ' ') {
                    return false;
                }
            }
            return true;
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


