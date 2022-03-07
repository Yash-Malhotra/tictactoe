package com.example.tictacto_minimax;
// inspired in part by https://www.geeksforgeeks.org/minimax-algorithm-in-game-theory-set-3-tic-tac-toe-ai-finding-optimal-move/

public class minimax {

    static class Move
    {
        int row;
        int col;
    }

    static int evaluate() {
        if (ticTacToe.whoWon() == "Player wins!") {
            return 100;
        } else if (ticTacToe.whoWon() == "CPU wins!") {
            return -100;
        } else {
            return 0;
        }
    }

    static int minimax(char gameBoard[][], int depth, Boolean isMax) {

        int score = evaluate();

        if (score == 10)
            return score;
        if (score == -10)
            return score;
        if (ticTacToe.whoWon() == "Draw!")
            return 0;


        if (isMax) {
            int best = Integer.MIN_VALUE;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (gameBoard[i][j] == ' ') {
                        gameBoard[i][j] = 'O';
                        best = Math.max(best, minimax(gameBoard,
                                depth + 1, !isMax));
                        gameBoard[i][j] = ' ';
                    }
                }
            }
            return best;
        }

        else {
            int best = Integer.MAX_VALUE;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (gameBoard[i][j] == ' ') {
                        gameBoard[i][j] = 'X';
                        best = Math.min(best, minimax(gameBoard,
                                depth + 1, !isMax));
                        gameBoard[i][j] = ' ';
                    }
                }
            }
            return best;
        }
    }

    static int findBestMove(char gameBoard[][]) {
        int bestVal = Integer.MIN_VALUE;
        Move theMove = new Move();
        theMove.row = -1;
        theMove.col = -1;
        int bestMove = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameBoard[i][j] == ' ') {
                    gameBoard[i][j] = 'O';
                    int moveVal = minimax(gameBoard, 0, false);
                    gameBoard[i][j] = ' ';
                    if (moveVal > bestVal) {
                        theMove.row = i;
                        theMove.col = j;
                        bestVal = moveVal;
                    }
                }
            }

        }

        if (theMove.row == 0 && theMove.col == 0) {
            bestMove = 1;
        } else if (theMove.row == 0 && theMove.col == 1) {
            bestMove = 2;
        } else if (theMove.row == 0 && theMove.col == 2) {
            bestMove = 3;
        } else if (theMove.row == 1 && theMove.col == 0) {
            bestMove = 4;
        } else if (theMove.row == 1 && theMove.col == 1) {
            bestMove = 5;
        } else if (theMove.row == 1 && theMove.col == 2) {
            bestMove = 6;
        } else if (theMove.row == 2 && theMove.col == 0) {
            bestMove = 7;
        } else if (theMove.row == 2 && theMove.col == 1) {
            bestMove = 8;
        } else if (theMove.row == 2 && theMove.col == 2) {
            bestMove = 9;
        }
        return bestMove;
    }

}

