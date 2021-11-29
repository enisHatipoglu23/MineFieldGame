package com.company;

import java.util.Random;
import java.util.Scanner;

public class MineField {
    int colNumber;
    int rowNumber;
    int size = colNumber * rowNumber;



    int[][] map;
    int[][] board;


    boolean isGameOn = true;
    Scanner input = new Scanner(System.in);


    Random random = new Random();



    MineField(int rowNumber, int colNumber){
        this.colNumber = colNumber;
        this.rowNumber = rowNumber;
        this.map = new int[rowNumber][colNumber];
        this.board = new int[rowNumber][colNumber];
        this.size = colNumber * rowNumber;

    }

    public void run(){
        createGame();
        print(map);
        int row,column,success=0;
        System.out.println("Game has been starded ! ! !");
        while(isGameOn){
            print(board);

            System.out.println("Row: ");
            row = input.nextInt();
            System.out.println("Column: ");
            column = input.nextInt();
            if ((row > rowNumber || column > colNumber) || ((row < 0) || (column < 0))){
                System.out.println("Geçersiz aralıkta değer girildi. ");
                continue;
            }


            if (map[row][column] != 404){
                success++;
                checkMines(row, column);
                if(success == size - (size/4)){
                    System.out.println("Congrats. You win!!! ");
                    break;
                }
            }else{
                isGameOn = false;
                System.out.println("Game Over ! ! ! ");
                int again;
                System.out.println("Do you want to play again? \n" +
                        " If you want to play again press 1, if you don't press 2. ");
                again = input.nextInt();
                switch (again){
                    case 1 :
                        isGameOn = true;
                        run();
                        break;
                    case 2 :
                        System.out.println("Goodbye :)");
                        break;
                }
            }
        }

    }

    public void createGame(){
        int randomRow;
        int randomCol;

        int count = 0;
        while(count != (size / 4)){
            randomRow = random.nextInt(rowNumber);
            randomCol = random.nextInt(colNumber);
            if (map[randomRow][randomCol] != 404){
                map[randomRow][randomCol] = 404;
                count++;
            }

        }
    }
    public void print(int[][] arr){
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                if(arr[i][j] >= 0){
                    System.out.print(" ");
                }
                System.out.print(" " + "|" + arr[i][j] + "|" + " ");
            }
            System.out.println();
        }
    }
    public void checkMines(int row, int col){
        if (map[row][col] == 0){
            if ((col < colNumber - 1) && map[row][col + 1] == 404){
                board[row][col]++;
            }
            if((row < rowNumber - 1) && map[row + 1][col] == 404){
                board[row][col]++;
            }
            if((col > 0) && map[row][col - 1] == 404){
                board[row][col]++;
            }
            if ((row > 0) && map[row - 1][col] == 404){
                board[row][col]++;
            }
            if (board[row][col] == 0){
                board[row][col] = -3;
            }



        }
    }
}
