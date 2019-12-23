package com.jgupte.backtracking;

public class NQueens {
    class Position {
        int row;
        int col;

        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    Position[] getNQueensPosition(int n) {
        Position[] positions = new Position[n];
        boolean hasSolution = solveNQueenOneSolutionUtil(n, 0, positions);
        if (hasSolution) {
            return positions;
        } else {
            return new Position[0];
        }
    }

    private boolean solveNQueenOneSolutionUtil(int n, int row, Position[] positions) {

        if (n == row)
            return true;

        for (int col = 0; col < n; col++) {
            boolean safe = true;

            for (int queen = 0; queen < row; queen++) {
                if (positions[queen].col == col || positions[queen].row - positions[queen].col == row - col ||
                        positions[queen].row + positions[queen].col == row + col) {
                    safe = false;
                    break;
                }
            }

            if (safe) {
                positions[row] = new Position(row, col);
                if (solveNQueenOneSolutionUtil(n, row + 1, positions)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();

        Position[] nQueensPosition = nQueens.getNQueensPosition(8);
        for (Position position : nQueensPosition) {
            System.out.println(position.row + " " + position.col);
        }
    }

}
