package HW1;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class program {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        //Задача 1: Вычислить n-ое треугольного числа(сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
        Task1();

        //Вывести все простые числа от 1 до 1000
        Task2();

        //Реализовать простой калькулятор
        Task3();
    }
    /**Методы для задачи 1*/
    public static void Task1(){
        System.out.print("Введите число: ");
        int num = sc.nextInt();
        int digit = Givnumber(num);
        if (digit != 0){
            System.out.printf("Введенное число "+num+" - треугольное. Это "+digit+"-е число в последовательности.");
            System.out.println("А теперь проверим, правилно ли выполнился метод?");
            int num2 = GivNum(digit);
            if (num2 == num){
                System.out.println("Все верно! Число, полученное методом 'GivNum' ("+num2+") равено введенному ("+num+")");
            }
        }else {
            System.out.printf("Введенное число "+num+" - не треугольное.");
        }
    }
    /**
     * *Метод определяет является ли введенное число треугольным и если да, то показывает какое это число
     */
    public static int Givnumber(int num){
        int sum = 0;
        int n = 0;
        for (int x = 1; sum <= num; x++)
        {
            sum = sum + x;
            if (sum == num)
                n = x;
        }
        return n;
    }
    /**Этот метод делает все наоборот, принимает номер треугольного числа в последовательности,
     * и возвращает сумму всех чисел входящих в него (по формуле). Проверяем, а верно ли отработал прошлый метод*/
    public static int GivNum(int a){
        return (a * (a + 1)) / 2;
    }

    /**Методы для задачи 2*/
    public static void Task2(){
        System.out.println("Выводим все простые числа от 1 до 1000");
        List<Integer> digits = new ArrayList<>();
        for (int i = 2; i <= 1000 ; i++) {
            boolean truDigit = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    truDigit = false;
                    break;
                }
            }
            if (truDigit){
                digits.add(i);
            }
        }
        System.out.println("Простые числа в заданном промежутке, это: "+digits);
    }

    /**Методы для задачи 3*/
    public static void Task3(){
        int num1 = GetDigit();
        int num2 = GetDigit();
        char symbol = GetSymbol();
        int rez = Result(num1, num2, GetSymbol());
        System.out.println("Число "+num1+" "+symbol+" "+num2+" равно: "+rez);
    }
    public static int GetDigit(){
        System.out.println("Укажите число: ");
        int num;
        if (sc.hasNextInt()){
            num = sc.nextInt();
        }else {
            System.out.println("Ошибка, введите целое число: ");
            sc.next();
            num = GetDigit();
        }
        return num;
    }
    public static char GetSymbol(){
        System.out.println("Введите операцию (-,+,*,/): ");
        char symbol;
        if (sc.hasNext()){
            symbol = sc.next().charAt(0);
        }else {
            System.out.println("Ошибка, введите операцию (-,+,*,/): ");
            sc.next();
            symbol = GetSymbol();
        }
        return symbol;
    }
    public static int Result(int num1, int num2, char symbol){
        int rez;
        switch (symbol) {
            case '-' -> rez = num1 - num2;
            case '+' -> rez = num1 + num2;
            case '*' -> rez = num1 * num2;
            case '/' -> rez = num1 / num2;
            default -> {
                System.out.println("Операция не определена, укажите операцию снова: ");
                rez = Result(num1, num2, GetSymbol());
            }
        }
        return rez;
    }
}