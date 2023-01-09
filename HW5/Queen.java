package HW5;

import java.util.Arrays;
import java.util.Scanner;

public class Queen {
    static Scanner sc = new Scanner(System.in);
    /**
     * Количество ферзей
     */
    private int len;

    // Ниже массивы для столбцов и диагоналей. Массивы можно считать булевскими, т.к. содержат только 0 или 1. 
    // Если есть значение 1 в индексе массива - значит, что там есть ферзь и клетка занята

    /**
     * Массив для ферзей по столбцам.
     */
    private int[] col;

    /**
     * Диагональ справа налево, сверху вниз
     */
    private int[] rlud;
    /**
     * Диагональ слева направо, сверху вниз
     */
    private int[] lrud;
    /**
     * Массив ферзей
     */
    private int[] queen;
 
    public Queen() {
        len = 8;
        col = new int[len];
        rlud = new int[(2*len)];
        lrud = new int[(2*len)];

        for (int i = 0; i < len; i++){
            col[i] = 0;
        }

        for (int i = 0; i < (2*len); i++){
            rlud[i] = 0;
            lrud[i] = 0;
        }
            

        queen = new int[len];
    }
 
    public void GetQueens(int i) {
        // Бегаем по строкам
        if (i > 7) {
            for (int y = 0; y < 8; y++) {
                for (int x = 0; x < 8; x++) {
                    if (y == 0) {
                        if(queen[y] == x) {
                            System.out.print("|Q|");
                        } else {
                            System.out.print("| |");
                        }
                    }else{
                        if(queen[y] == x) {
                            System.out.print("Q|");
                        } else {
                            System.out.print(" |");
                        }
                    }
                    
                }
                System.out.println();
            }
        }else{    
            
            for (int j = 0; j < len; j++) {
                
                if ((col[j] == 0) && (rlud[i+j] == 0) && (lrud[i-j+len] == 0)) {
                    queen[i] = j;
                    col[j] = 1; rlud[i+j] = 1; lrud[i-j+len] = 1;
                    GetQueens(i+1);
                    col[j] = 0; rlud[i+j] = 0; lrud[i-j+len] = 0;
                }
            }
        }
        
        
    }
 
    
 
    public static void main(String[] args) {
        Queen queen = new Queen();
        queen.GetQueens(0);
    }
    
}
