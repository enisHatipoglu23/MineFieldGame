package com.company;

import java.util.Scanner;

public class Main {
public static void main(String[] args) {

   Scanner scanner = new Scanner(System.in);
   int row,column;
    System.out.println("Welcome to Mine Field ! ");
    System.out.println("Lütfen oynamak istediğiniz boyutları giriniz! ");
    System.out.println("Sütun sayısı : ");
   row = scanner.nextInt();
    System.out.println("Satır sayısı : ");
   column = scanner.nextInt();
   MineField mineField = new MineField(row,column);
   mineField.run();
}


}

