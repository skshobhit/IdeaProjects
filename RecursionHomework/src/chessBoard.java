public class chessBoard {

    private static int board[][];
    public int numQueens;

    public chessBoard() {
        numQueens = 0;
        board = new int[8][8];
    }

    public int getNumberQueens() {
        return numQueens;
    }

    public void start() {
        solve(0);
    }

    public boolean solve(int numQueens) {
        if (numQueens == 8) {
            System.out.println("Done ");
            this.printBoard();
            return true;
        } else {
            for (int j = 0; j < 8; j++) {
                for (int k = 0; k < 8; k++) {
                    if (validMove(j, k) == 0) {
                        this.placeQueen(j, k, 0);
                        numQueens++;
                        if (solve(numQueens)) {
                            return true;
                        } else {
                            this.placeQueen(j, k, 1);
                            numQueens--;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static int validMove(int row, int column) {
        for (int j = 0; j < 8; j++) {
            if (get(row, j) == 1
                    || get(j, column) == 1
                    || get(row - j, column - j) == 1
                    || get(row - j, column + j) == 1
                    || get(row + j, column - j) == 1
                    || get(row + j, column + j) == 1)
            {
                return -1;
            }
        }
        return 0;
    }

    public void placeQueen(int x, int y, int type) {
        if (type == 0) {
            board[x][y] = 1;
            numQueens++;
        }
        else if (type == 1) {
            board[x][y] = 0;
        }
    }

    public static int get(int x, int y) {
        if (x < 0 || y < 0 || x > 7 || y > 7) { return -1;}
        return board[x][y];
    }

    public void printBoard() {
        for (int j = 0; j < 8; j++) {
            for (int k = 0; k < 8; k++) {
                System.out.print(this.get(j, k) + " ");
            }
            System.out.println();
        }
    }
}