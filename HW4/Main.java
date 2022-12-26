package HW4;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        // Задача 1 Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.
        List<Integer> list = GetLinkedList();
        ReVerseList(list);
        
        // Задача 2 Реализуйте очередь с помощью LinkedList со следующими методами:
        // enqueue() - помещает элемент в конец очереди,
        // dequeue() - возвращает первый элемент из очереди и удаляет его,
        // first() - возвращает первый элемент из очереди, не удаляя.

        System.out.print("Начальная очередь: ");
        Deque<Integer> line = GetQueue();

        System.out.print("Введите какое-нибудь число: ");
        int num = sc.nextInt();
        System.out.println();

        System.out.println("Число "+num+ " положим в конец очереди");
        enqueue(num, line);
        System.out.println(line);
        System.out.println();

        int del = dequeue(line);
        System.out.println(del+" Первый элемент, который был удален");
        System.out.println(line);
        System.out.println();

        int first = first(line);
        System.out.println("Теперь первый элемент очереди = "+first+", он удален не будет: ");
        System.out.println(line);

        /*
         *  3. В калькулятор добавьте возможность отменить последнюю операцию.
         */

        Callculator();
        
    }
    /**
    * Создает LinkedList с рандомным количеством (от 2 до 10) рандомных элементов со значением от 0 до 100
    */
    private static List<Integer> GetLinkedList(){
        int rand = new Random().nextInt(2, 10);
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < rand; i++) {
            int val = new Random().nextInt(100);
            list.add(val);
        }
        System.out.println(list);
        return list;
    }
    /** 
     * Переворачивает входящий список LinkedList
    */
    private static void ReVerseList(List<Integer> list){
        for(int i = 0, mid = list.size()/2, j = list.size() - 1; i < mid; i++, j--){
            list.set(i, list.set(j, list.get(i)));
        }
        System.out.println(list);
    }
    /**
     * Создаем случайную очередь случайных элементов типа Integer с помощью LinkedList
     */
    private static LinkedList<Integer> GetQueue(){
        int rand = new Random().nextInt(4, 10);
        LinkedList<Integer> line = new LinkedList<>();
        for (int i = 0; i < rand; i++) {
            int val = new Random().nextInt(100);
            line.add(val);
        }
        System.out.println(line);
        return line;
    }
    /**
     * Помещает элемент в конец очереди
     * @param el
     * @param line
     */
    private static void enqueue(int el, Deque<Integer> line){
        line.addLast(el);
    }
    /**
     * возвращает первый элемент из очереди и удаляет его
     * @param line
     */
    private static int dequeue(Deque<Integer> line){
        int del = line.pollFirst();
        return del;
    }
    /**
     * возвращает первый элемент из очереди, не удаляя
     * @param line
     * @return
     */
    private static int first(Deque<Integer> line){
        int fitst = line.peekFirst();
        return fitst;
    }
    /**
     * Метод для калькулятора 
     */
    private static void Callculator(){
        Deque<Double> line = new LinkedList<>();
        boolean esc = false;
        while (esc != true) {
            Double num1;

            if (line.size() >= 1){
                num1 = line.peekLast();
            }else{
                num1 = GetDigit();
            }
            
            char symbol = GetSymbol();
            Double num2 = GetDigit();
            Double result = 0.0;
            if (symbol == '+'){
                result = Summa(num1, num2);
            }else if (symbol == '-'){
                result = Differ(num1, num2);
            }else if (symbol == '*'){
                result = Multi(num1, num2);
            }else if (symbol == '/'){
                result = Division(num1, num2);
            }else{
                System.out.println("Ошибка, операция не определена: ");
            }
            
            if (line.size() == 3){
                line.pollFirst();
            }
            line.addLast(result);
            System.out.println(num1+" "+symbol+" "+num2+" = "+line.peekLast());
            System.out.println("Очередь: "+line);
            System.out.println("Введите '1' - для работы с результатом, '2' - для ввода нового числа, '3' - для выхода, '4' - для отмены последней операции");
            String out  = sc.next();

            if (out.equals("2")) {
                line.clear();
            }
            if (out.equals("3")) {
                esc = true;
            }
            if (out.equals("4")) {
                result = line.pollLast();
                System.out.println("Результат "+result+" отменен, работаем с : "+line);
            }
        }

    }
    public static double GetDigit(){
        System.out.print("Укажите число: ");
        double num;
        if (sc.hasNextInt()){
            num = sc.nextInt();
        } else if (sc.hasNextDouble()) {
            num = sc.nextDouble();
        } else {
            System.out.println("Ошибка, введите число: ");
            num = GetDigit();
        }
        return num;
    }
    public static char GetSymbol(){
        System.out.print("Введите операцию (-,+,*,/): ");
        char symbol;
        if (sc.hasNext()){
            symbol = sc.next().charAt(0);
            if (symbol != '-' && symbol != '+' && symbol != '*' && symbol != '/'){
                System.out.println("Ошибка, неизвестная операция");
                symbol = GetSymbol();
            }
        }else {
            System.out.println("Ошибка, неизвестная операция");
            symbol = GetSymbol();
        }
        return symbol;
    }
    private static double Summa (double a, double b){
        return a + b;
    }
    private static double Differ (double a, double b){
        return a - b;
    }
    private static double Multi (double a, double b){
        return a * b;
    }
    private static double Division (double a, double b){
        return a / b;
    }
}