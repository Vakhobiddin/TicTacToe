package pdp_lessons.module1.extraTask;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("This is the game if Tic Tac Toe.");
        System.out.println("You will be playing against the computer.");

        String[][] tictac = new String[3][3];

        int x;
        int y;
        int computer_x;
        int computer_y;

        while (true) {
            while (true) {
                System.out.print("Enter X,Y coordinates for your move: ");
                x = scanner.nextInt();
                y = scanner.nextInt();

                if (tictac[x - 1][y - 1] == null)
                    break;
                if (tictac[x - 1][y - 1].contains("*"))
                    break;
            }
            tictac[x - 1][y - 1] = " X ";

            if (checkTable(tictac, "X")) {
                System.out.println("You won!");
                showTable(tictac);
                System.exit(0);
            }

            while (true) {
                computer_x = randInt(0, 2);
                computer_y = randInt(0, 2);

                if (tictac[computer_x][computer_y] == null)
                    break;
                if (tictac[computer_x][computer_y].contains("*"))
                    break;
            }
            tictac[computer_x][computer_y] = " O ";
            if (checkTable(tictac, "O")) {
                System.out.println("You lost!");
                showTable(tictac);
                System.exit(0);
            }
            showTable(tictac);
        }
    }

    public static boolean checkTable(String[][] tictac, String sign) {
        if (checkFirstDiagonal(tictac, sign)) return true;
        if (checkSecondDiagonal(tictac, sign)) return true;
        if (checkColumns(tictac, sign)) return true;
        return checkRows(tictac, sign);
    }

    public static boolean checkColumns(String[][] tictac, String sign) {
        for (int i = 0; i < 3; i++) {
            int onColumn = 0;
            for (int j = 0; j < 3; j++) {
                if (tictac[j][i] != null) {
                    if (tictac[j][i].contains(sign))
                        onColumn++;
                }
            }
            if (onColumn == 3)
                return true;
        }
        return false;
    }

    public static boolean checkRows(String[][] tictac, String sign) {
        for (int i = 0; i < 3; i++) {
            int onRow = 0;
            for (int j = 0; j < 3; j++) {
                if (tictac[i][j] != null) {
                    if (tictac[i][j].contains(sign))
                        onRow++;
                }
            }
            if (onRow == 3)
                return true;
        }
        return false;
    }

    public static boolean checkFirstDiagonal(String[][] tictac, String sign) {
        int onDiagonal = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j && tictac[i][j] != null) {
                    if (tictac[i][j].contains(sign))
                        onDiagonal++;
                }
            }
        }
        return onDiagonal == 3;
    }

    public static boolean checkSecondDiagonal(String[][] tictac, String sign) {
        int onDiagonal = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if ((i + j) == (3 - 1) && tictac[i][j] != null) {
                    if (tictac[i][j].contains(sign))
                        onDiagonal++;
                }
            }
        }
        return onDiagonal == 3;
    }

    public static void showTable(String[][] tictac) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tictac[i][j] == null)
                    tictac[i][j] = " * ";
                System.out.print(tictac[i][j]);
            }
            System.out.println();
        }
    }

    public static int randInt(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

}
