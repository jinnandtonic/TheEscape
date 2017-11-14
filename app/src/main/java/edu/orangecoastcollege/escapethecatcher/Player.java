package edu.orangecoastcollege.escapethecatcher;

public class Player {
    private int mRow;
    private int mCol;

    public void move(int[][] gameBoard, String direction) {

        // Implement the logic for the move operation
        // If the gameBoard is obstacle free in the direction requested,
        // Move the player in the intended direction.  Otherwise, do nothing (player loses turn)

        switch (direction)
        {
            case "UP":
                if (gameBoard[mRow - 1][mCol] != BoardCodes.OBSTACLE) mRow--;
                break;
            case "DOWN":
                if (gameBoard[mRow + 1][mCol] != BoardCodes.OBSTACLE) mRow++;
                break;
            case "LEFT":
                if (gameBoard[mRow][mCol - 1] != BoardCodes.OBSTACLE) mCol--;
                break;
            case "RIGHT":
                if (gameBoard[mRow][mCol + 1] != BoardCodes.OBSTACLE) mCol++;
                break;
        }
    }

    public void setRow(int row) {
        mRow = row;
    }

    public int getRow() {
        return mRow;
    }

    public void setCol(int col) {
        mCol = col;
    }

    public int getCol() {
        return mCol;
    }

}
