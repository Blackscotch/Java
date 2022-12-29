package HW6;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // 1. Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
        // 2. Создать множество ноутбуков.
        // 3. Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки,
        // отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например:
        // “Введите цифру, соответствующую необходимому критерию:
        // 1 - ОЗУ
        // 2 - Объем ЖД
        // 3 - Операционная система
        // 4 - Цвет …
        // 1. Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
        // 2. Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.

        createCatalog();
    }
    private static void createCatalog(){
        Laptop lap1 = new Laptop(1, "ASUS",8 , 500, 128, "Windows 11", "Черный");
        Laptop lap2 = new Laptop(1,"ASUS", 4, 0, 256, "Windows 11", "Красный");
        Laptop lap3 = new Laptop(1,"ASUS", 8, 500, 512, "Windows 10", "Синий");
        Laptop lap4 = new Laptop(1,"Lenovo", 12, 2000, 128, "Windows 10", "Серый");
        Laptop lap5 = new Laptop(1, "Lenovo", 12, 500, 128, "Windows 11", "Черный");
        Laptop lap6 = new Laptop(1,"Lenovo", 16, 1000, 256, "Windows 11", "Золотой");
        Laptop lap7 = new Laptop(1,"MSI", 12, 0, 1000, "Windows 10", "Синий");
        Laptop lap8 = new Laptop(1,"MSI", 8, 500, 256, "Windows 11", "Фиолетовый");

        Set<Laptop> Laptops = new HashSet<>();
        Laptops.add(lap1);
        Laptops.add(lap2);
        Laptops.add(lap3);
        Laptops.add(lap4);
        Laptops.add(lap5);
        Laptops.add(lap6);
        Laptops.add(lap7);
        Laptops.add(lap8);

        for (var laptop : Laptops) {
            System.out.println(laptop);
        }
        
    }
}
