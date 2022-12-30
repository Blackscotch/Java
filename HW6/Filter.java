package HW6;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Filter {
    static Scanner sc = new Scanner(System.in);

    public static void FilterRam(Set<Laptop> laptop){
        Set<Laptop> coll = new LinkedHashSet<>();
        boolean activ = true;
        while (activ) {
            System.out.println("Укажите значение оперативной памяти или esc для выхода: ");
            String size = sc.nextLine();
            if (size.equals("esc")) {
                activ = false;
            }else{
                for (var lap : laptop) {
                    if (lap.getram() == Integer.parseInt(size)) {
                        coll.add(lap);
                    }
                }
                if (coll.size() > 0){
                    System.out.println("Отфильрованные ноутбуки: ");
                    for (var item : coll) {
                        System.out.println(item);
                    }
                }else{
                    System.out.println("Нет ноутбуков, подходящих условию фильтрации.");
                }
                coll.clear();
            }
        }  
    }

    public static void FilterVendor(Set<Laptop> laptop){
        Set<Laptop> coll = new LinkedHashSet<>();
        boolean activ = true;
        while (activ) {
            System.out.println("Укажите название производителя или esc для выхода: ");
            System.out.println("ASUS, Lenovo, MSI");
            String size = sc.nextLine().toLowerCase();
            if (size.equals("esc")) {
                activ = false;
            }else{
                for (var lap : laptop) {
                    if (lap.getname().toLowerCase().equals(size)) {
                        coll.add(lap);
                    }
                }
                if (coll.size() > 0){
                    System.out.println("Отфильрованные ноутбуки: ");
                    for (var item : coll) {
                        System.out.println(item);
                    }
                }else{
                    System.out.println("Нет ноутбуков, подходящих условию фильтрации.");
                }
                coll.clear();
            }
        }
    }

    public static void FilterHDD(Set<Laptop> laptop){
        Set<Laptop> coll = new LinkedHashSet<>();
        boolean activ = true;
        while (activ) {
            System.out.println("Укажите значение жесткого диска или esc для выхода: ");
            System.out.println("Объем ЖД: 0, 500, 1000. 0 - ЖД отсутсвует");
            String size = sc.nextLine();
            if (size.equals("esc")) {
                activ = false;
            }else{
                for (var lap : laptop) {
                    if (lap.gethdd() == Integer.parseInt(size)) {
                        coll.add(lap);
                    }
                }
                if (coll.size() > 0){
                    System.out.println("Отфильрованные ноутбуки: ");
                    for (var item : coll) {
                        System.out.println(item);
                    }
                }else{
                    System.out.println("Нет ноутбуков, подходящих условию фильтрации.");
                }
                coll.clear();
            }
        }
    }
    
    public static void FilterSSD(Set<Laptop> laptop){
        Set<Laptop> coll = new LinkedHashSet<>();
        boolean activ = true;
        while (activ) {
            System.out.println("Укажите значение твердотельного накопителя или esc для выхода: ");
            System.out.println("Объем ТН: 0, 128, 256, 512, 1000. 0 - ТН отсутсвует");
            String size = sc.nextLine();
            if (size.equals("esc")) {
                activ = false;
            }else{
                for (var lap : laptop) {
                    if (lap.getssd() == Integer.parseInt(size)) {
                        coll.add(lap);
                    }
                }
                if (coll.size() > 0){
                    System.out.println("Отфильрованные ноутбуки: ");
                    for (var item : coll) {
                        System.out.println(item);
                    }
                }else{
                    System.out.println("Нет ноутбуков, подходящих условию фильтрации.");
                }
                coll.clear();
            }
        }
    }

    public static void FilterOS(Set<Laptop> laptop){
        Set<Laptop> coll = new LinkedHashSet<>();
        boolean activ = true;
        while (activ) {
            System.out.println("Укажите операционную систему или esc для выхода: ");
            System.out.println("Windows 10, Windows 11");
            String size = sc.nextLine().toLowerCase();
            if (size.equals("esc")) {
                activ = false;
            }else{
                for (var lap : laptop) {
                    if (lap.getos().toLowerCase().equals(size)) {
                        coll.add(lap);
                    }
                }
                if (coll.size() > 0){
                    System.out.println("Отфильрованные ноутбуки: ");
                    for (var item : coll) {
                        System.out.println(item);
                    }
                }else{
                    System.out.println("Нет ноутбуков, подходящих условию фильтрации.");
                }
                coll.clear();
            }
        }
    }

    public static void FilterColor(Set<Laptop> laptop){
        Set<Laptop> coll = new LinkedHashSet<>();
        boolean activ = true;
        while (activ) {
            System.out.println("Укажите цвет ноутбука или esc для выхода: ");
            System.out.println("Синий, черный, фиолетовый и т.д.");
            String size = sc.nextLine().toLowerCase();
            if (size.equals("esc")) {
                activ = false;
            }else{
                for (var lap : laptop) {
                    if (lap.getcolor().toLowerCase().equals(size)) {
                        coll.add(lap);
                    }
                }
                if (coll.size() > 0){
                    System.out.println("Отфильрованные ноутбуки: ");
                    for (var item : coll) {
                        System.out.println(item);
                    }
                }else{
                    System.out.println("Нет ноутбуков, подходящих условию фильтрации.");
                }
                coll.clear();
            }
        }
    }
}