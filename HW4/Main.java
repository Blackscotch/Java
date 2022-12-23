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
        // List<Integer> list = GetLinkedList();
        // ReVerseList(list);
        
        // Задача 2 Реализуйте очередь с помощью LinkedList со следующими методами:
        // enqueue() - помещает элемент в конец очереди,
        // dequeue() - возвращает первый элемент из очереди и удаляет его,
        // first() - возвращает первый элемент из очереди, не удаляя.

        // System.out.print("Начальная очередь: ");
        // Deque<Integer> line = GetQueue();

        // System.out.print("Введите какое-нибудь число: ");
        // int num = sc.nextInt();
        // System.out.println();

        // System.out.println("Число "+num+ " положим в конец очереди");
        // enqueue(num, line);
        // System.out.println(line);
        // System.out.println();

        // int del = dequeue(line);
        // System.out.println(del+" Первый элемент, который был удален");
        // System.out.println(line);
        // System.out.println();

        // int first = first(line);
        // System.out.println("Теперь первый элемент очереди = "+first+", он удален не будет: ");
        // System.out.println(line);

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
        Deque<Object> line = new LinkedList<>();
        boolean esc = false;
        while (esc != true) {
            Object num1 = GetDigit();
            Object num2 = GetDigit();
            Object rez = Result(num1, num2);
            if (line.size() == 3){
                line.pollFirst();
            }
            line.addLast(rez);
            System.out.println("Результат: "+line.peekLast());
            System.out.println("Напишите 'esc' для выхода, 'canc' - для возврата к предудущему результату, что-угодно - для продолжения");
            String out  = sc.next();

            if (out.equals("esc")) {
                esc = true;
            }
            if (out.equals("canc")) {
                rez = line.pollLast();
                System.out.println("Результат "+rez+" извлечен, прошлый результат: "+line);
            }
        }

    }
    public static Object GetDigit(){
        System.out.println("Укажите число: ");
        Object num;
        if (sc.hasNextInt()){
            num = sc.nextInt();
        } else if (sc.hasNextDouble()) {
            num = sc.nextDouble();
        } else {
            System.out.println("Ошибка, введите число: ");
            sc.next();
            num = GetDigit();
        }
        return num;
    }
    static Object Result (Object a, Object b){
        if (a instanceof Double && b instanceof Double){
            return (Object) ((Double) a + (Double) b);
        }else if (a instanceof Integer && b instanceof Double) {
            return (Object) ((Integer) a + (Double) b);
        }else if (a instanceof Integer && b instanceof Integer) {
            return (Object) ((Integer) a + (Integer) b);
        }else if (a instanceof Double && b instanceof Integer) {
            return (Object) ((Double) a + (Integer) b);
        }else{
            return 0;
        }
    }

}