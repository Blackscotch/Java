package HW5;

import java.util.Arrays;
import java.util.Scanner;
import static HW5.Likepeople.ReadPeople;
import static HW5.HeapSort.*;
import HW5.Queen;
// import static HW5.QuinsOnBoard.*;


public class Main {
    static Scanner sc = new Scanner(System.in);
    /**
     * @param args
     */
    public static void main(String[] args) {
        // 1. Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
        // PhoneGuide();

        // Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности.
        // FindAndPrintLike();

        // 3. Реализовать алгоритм пирамидальной сортировки (HeapSort).
        // System.out.print("Введите размерность мыссива: ");
        // int size_arr = sc.nextInt();
        // int array[] = GetArray(size_arr);
        // Sort(array);
        // System.out.println("Отсортированный массив: "+Arrays.toString(array));
        // System.out.println();

        // 4. На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга
        ChessBoard(); 
    }
    private static void PhoneGuide(){
        Phoneboock book = new Phoneboock();
        book.AddContact("Barney ST", "89510873445");
        book.AddContact("Barney ST", "89510870000");
        book.AddContact("Sidny Spensor", "89510000000");
        book.AddContact("Roman K", "89510727878");
        book.AddContact("Roman K", "22-21-16");
        book.AddContact("Jay Stoun", "47-87-65");
        
        boolean try_find = false;
        while (try_find != true) {
            System.out.print("Введи имя контакта для посика или 'esc' для выхода из программы: ");
            String name = sc.nextLine();
            book.FindName(name);
            if (name.equals("esc")){
                try_find = true;
            }
        }
        
    }
    /**
     * 2. Пусть дан список сотрудников:
        Иван Иванов
        Светлана Петрова
        Кристина Белова
        Анна Мусина
        Анна Крутова
        Иван Юрин
        Петр Лыков
        Павел Чернов
        Петр Чернышов
        Мария Федорова
        Марина Светлова
        Мария Савина
        Мария Рыкова
        Марина Лугова
        Анна Владимирова
        Иван Мечников
        Петр Петин
        Иван Ежов
     */
    public static void FindAndPrintLike(){
        Likepeople book = new Likepeople();
        book.AddPeople("Иван", "Иванов");
        book.AddPeople("Светлана", "Петрова");
        book.AddPeople("Кристина", "Белова");
        book.AddPeople("Анна", "Мусина");
        book.AddPeople("Анна", "Крутова");
        book.AddPeople("Иван", "Юрин");
        book.AddPeople("Петр", "Лыков");
        book.AddPeople("Павел", "Чернов");
        book.AddPeople("Петр", "Чернышов");
        book.AddPeople("Мария", "Федорова");
        book.AddPeople("Марина", "Светлова");
        book.AddPeople("Мария", "Савина");
        book.AddPeople("Мария", "Рыкова");
        book.AddPeople("Марина", "Лугова");
        book.AddPeople("Анна", "Владимирова");
        book.AddPeople("Анна", "Владимирова");
        book.AddPeople("Иван", "Мечников");
        book.AddPeople("Петр", "Петин");
        book.AddPeople("Иван", "Ежов");

        ReadPeople();
    }
    /**
     * Метод для шахмат
     */
    public static void ChessBoard(){
        Queen queen = new Queen();
        queen.GetQueens(0);
    }
}

