package Stuff.Arrays;

import java.util.*;

public class ArrayTest1 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Podaj liczbę całkowitą ");
            int number = 0;
            try{
                number = scanner.nextInt();
            }
            catch (InputMismatchException nfe){
                System.out.println("Miała być liczba całkowita...");
            }
            catch (Exception e){
                e.printStackTrace();
            }
            int size = (int) Math.ceil(number / 4.0);

            int[][] arr = new int[4][];
            int x = 1;
            for(int i = 0; i < 4; i++){
             arr[i] = new int[size];
                for (int j = 0; j < size; j++) {
                    if (x <= number) arr[i][j] = x++;
                    else arr[i][j] = -1;
                }
            }
            for(int i = 0; i < 4; i++){
                System.out.print("{");
                for (int j = 0; j < size; j++) {
                    System.out.print(" " + arr[i][j] + " ");
                }
                System.out.println("}");
            }

            //mogłem ostatnia tablicę zrobić krótszą, ale mi się nie chciało :)
        }   //Wtedy nie byłoby tych końcowych -1, znaczących, że nic tam nie ma. int nie może być null.
    }
