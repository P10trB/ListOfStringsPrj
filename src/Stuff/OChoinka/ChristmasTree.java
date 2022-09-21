package Stuff.OChoinka;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ChristmasTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj wysokosc choinki: ");
        String noga = "";
        int number;
        try {
            number = scanner.nextInt();
            for (int i = 1; i <= number; i++) {
                for (int j = number; j > i; j--) {
                    System.out.print(" ");
                    if(i == 1) noga += " ";
                }
                for (int j = 0; j / 2 < i; j++) {
                    System.out.print("*");
                    if(i == 1) noga += "|";
                }
                System.out.println();
            }
            System.out.println(noga);
        } catch (InputMismatchException e) {
            System.out.println("Wysokosc miala byc podana jako liczba calkowita");
            e.printStackTrace();
        }


    }
}
