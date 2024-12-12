//import java.util.Scanner;
//
//public class Game {
//    private final Board board;
//    private final Player player1;
//    private final Player player2;
//
//    public Game(Player player1, Player player2) {
//        this.board = new Board();
//        this.player1 = player1;
//        this.player2 = player2;
//    }
//
//    public void start() {
//        Scanner scanner = new Scanner(System.in);
//        Player currentPlayer = player1;
//
//        while (true) {
//            board.displayBoard();
//            System.out.println(currentPlayer.getName() + "'s turn. Enter column (0-6): ");
//            int col = scanner.nextInt();
//
//            if (board.dropDisc(col, currentPlayer.getDisc())) {
//                if (board.checkWin(currentPlayer.getDisc())) {
//                    board.displayBoard();
//                    System.out.println(currentPlayer.getName() + " wins!");
//                    break;
//                }
//                currentPlayer = (currentPlayer == player1) ? player2 : player1;
//            } else {
//                System.out.println("Invalid move. Try again.");
//            }
//        }
//        scanner.close();
//    }
//}