package com.example.tictacto_minimax;

import java.util.*;
/* credit to https://www.youtube.com/watch?v=gQb3dE-y1S4 */

public class ticTacToe {

    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();

    public static void main(String[] args) {

        char[][] gameBoard = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};

//        setBoard(gameBoard);

        String result = "";
        int depth = 0;

        Scanner scan = new Scanner(System.in);
        while (result == "") {
            System.out.println("What is your move? (from 1-9): ");
            int playerPos = scan.nextInt();

            while(playerPositions.contains(playerPos) || cpuPositions.contains(playerPos)) {
                System.out.println("Position occupied, choose again");
                playerPos = scan.nextInt();
            }

            place(gameBoard, playerPos, "player");

//            Random random = new Random();
            int cpuMove = minimax.findBestMove(gameBoard);
//            while(playerPositions.contains(cpuMove) || cpuPositions.contains(cpuMove)) {
//                cpuMove = minimax.findBestMove(gameBoard);
//            }

            place(gameBoard, cpuMove, "computer");

            result = whoWon();
            System.out.println(result);

            setBoard(gameBoard);

            System.out.println(result);
        }
    }
    public static void place(char[][] gameBoard, int pos, String whoPlayed) {
        char xo = ' ';

        if (whoPlayed.equals("player")){
            xo = 'X';
            playerPositions.add(pos);
        } else if(whoPlayed.equals("computer")) {
            xo = 'O';
            cpuPositions.add(pos);
        }
        switch (pos) {
            case 1:
                gameBoard[0][0] = xo;
                break;
            case 2:
                gameBoard[0][1] = xo;
                break;
            case 3:
                gameBoard[0][2] = xo;
                break;
            case 4:
                gameBoard[1][0] = xo;
                break;
            case 5:
                gameBoard[1][1] = xo;
                break;
            case 6:
                gameBoard[1][2] = xo;
                break;
            case 7:
                gameBoard[2][0] = xo;
                break;
            case 8:
                gameBoard[2][1] = xo;
                break;
            case 9:
                gameBoard[2][2] = xo;
                break;
            default:
                break;
        }
    }

    public static String whoWon() {
        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List botRow = Arrays.asList(7, 8, 9);
        List lCol = Arrays.asList(1, 4, 7);
        List rCol = Arrays.asList(3, 6, 9);
        List midCol = Arrays.asList(2, 5, 8);
        List lrDiag = Arrays.asList(1, 5, 9);
        List rlDiag = Arrays.asList(3, 5, 7);

        List<List> win = new ArrayList<List>();
        win.add(topRow);
        win.add(botRow);
        win.add(midRow);
        win.add(lCol);
        win.add(rCol);
        win.add(midCol);
        win.add(lrDiag);
        win.add(rlDiag);

        for (List l : win) {
            if (playerPositions.containsAll(l)) {
                return "Player wins!";
            } else if (cpuPositions.containsAll(l)) {
                return "CPU wins!";
            } else if (playerPositions.size() + cpuPositions.size() == 9) {
                return "Draw!";
            }
        }
        return "";
    }


    public static void setBoard(char[] [] gameBoard) {
        for(char [] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}