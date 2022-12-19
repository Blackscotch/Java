package HW3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        // Задача 1
        // System.out.print("Введите размерность массива: ");
        // int size = sc.nextInt();

        // System.out.print("Введите минимальное значение: ");
        // int min = sc.nextInt();

        // System.out.print("Введите максимальное значение: ");
        // int max = sc.nextInt();

        // int [] arr = GetArray(size, min, max);
        // System.out.println("Новый массив: "+Arrays.toString(arr));
        // int len = arr.length;
        // MergeSort(arr, len);
        // System.out.println("Отсортированный массив: "+Arrays.toString(arr));
        // System.out.println();

        // Задача 2
        // System.out.print("Введите размерность списка: ");
        // int size_list = sc.nextInt();
        // GetList(size_list);
        // System.out.println();


        // Задача 3 - Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.
        System.out.print("Введите размерность списка: ");
        int lsize = sc.nextInt();
        ArrayList<Integer> list = CreateList(lsize);
        System.out.println("Случайный список: "+list);
        ReternValuesInArr(list);
        
    }
    /**
     * Создаем рандомный массив интов из указанных пользователем данных.
    */
    private static int [] GetArray(int massSize, int min, int max){
        int arr[] = new int[massSize];
        for (int i = 0; i < arr.length; i++) {
            int rand = new Random().nextInt(min, max);
            arr[i] = rand;
        }
        return arr;
    }

    /** 
     * Реализовываем алгоритм сортировки слиянием
    */
    private static void MergeSort(int[] arr, int len){
        if (len < 2) {
            return;
        }
        int mid = len/2;
        int[] left = new int[mid];
        int[] right = new int[len - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }

        for (int i = mid; i < len; i++) {
            right[i - mid] = arr[i];
        }

        MergeSort(left, mid);
        MergeSort(right, len - mid);

        Merge(arr, left, right, mid, len - mid);
    }
    /**
     * Объединение подмассивов
    */
    private static void Merge(int[] arr, int[] left, int[] right, int lindex, int rindex){
        int i = 0, j = 0, k = 0;
        while (i < lindex && j < rindex) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            }else{
                arr[k++] = right[j++];
            }
        }
        while (i < lindex){
            arr[k++] = left[i++];
        }
        while (j < rindex) {
            arr[k++] = right[j++];
        }
    }
    /** 
     * Пусть дан произвольный список целых чисел, удалить из него четные числа
    */
    private static void GetList(int len){
        ArrayList<Integer> list = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            int rand = new Random().nextInt(-20, 20);
            list.add(rand);
        }
        System.out.println("Произвольный список: "+list);
        for (int i = 0; i < list.size();) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
            }else{
                i++;
            }
        }
        System.out.println("Список без четных чисел: "+list);
    }
    /** 
     * Создадим список случайных интов и размера, уоторый укажет пользовыватель
    */
    private static ArrayList<Integer> CreateList(int size){
        ArrayList<Integer> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            int rand = new Random().nextInt(-100, 100);
            list.add(rand);
        }
        return list;
    }
    /*
     * Нахдим минимальное, максимальное и среднее значение списка 
     */
    private static void ReternValuesInArr(ArrayList<Integer> list){
        int min = list.get(0); 
        int max = list.get(0);
        double mean = 0;
        int len = list.size();
        for (int i = 0; i < len; i++) {
            if (list.get(i) < min) {
                min = list.get(i);
            }
            if(list.get(i) > max){
                max = list.get(i);
            }
            mean += list.get(i);
        }
        mean = mean/len;
        System.out.println("min = "+min+", max = "+max+", average = "+mean);
    }
}
