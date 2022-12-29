package HW5;

import java.util.Arrays;
import java.util.Random;

public class HeapSort {
    /**
     * Создадим массив случайных интов
     * @param len
     */
    public static int[] GetArray(int len){
        int array[] = new int[len];
        for (int i = 0; i < len; i++) {
            int rand = new Random().nextInt(-20, 20);
            array[i] = rand;
        }
        System.out.println("Произвольный массив: "+Arrays.toString(array));
        return array;
    }
    /**
     * Сортировка пирамидой
     * @param array
     */
    public static void Sort(int array[]){
        int len = array.length;

        for (int i = len / 2 - 1; i >= 0; i--) {
            Heapify(array, len, i);
        }

        for (int i = len - 1; i >= 0; i--)
        {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            Heapify(array, i, 0);
        }
    }

    public static void Heapify(int arr[], int len, int i)
    {
        int largest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;

        if (left < len && arr[left] > arr[largest])
            largest = left;

        if (right < len && arr[right] > arr[largest])
            largest = right;

        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            Heapify(arr, len, largest);
        }
    }
}
