package HW6;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import static HW6.Filter.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
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

        Set<Laptop> lap = createCatalog();
        // for (var laptop : lap) {
        //     System.out.println(laptop);
        // }
        getResult(lap);

        
    }
    /**
     * Добавляет ноутбуки во множество и возвращает его
     * @return
     */
    private static Set<Laptop> createCatalog(){
        Laptop lap1 = new Laptop(1, "ASUS",8 , 500, 128, "Windows 11", "Black");
        Laptop lap2 = new Laptop(1,"ASUS", 4, 0, 256, "Windows 11", "Red");
        Laptop lap3 = new Laptop(1,"ASUS", 8, 500, 512, "Windows 10", "Blue");
        Laptop lap4 = new Laptop(1,"Lenovo", 12, 2000, 128, "Windows 10", "Gray");
        Laptop lap5 = new Laptop(1, "Lenovo", 12, 500, 128, "Windows 11", "Black");
        Laptop lap6 = new Laptop(1,"Lenovo", 16, 1000, 256, "Windows 11", "Gold");
        Laptop lap7 = new Laptop(1,"MSI", 12, 0, 1000, "Windows 10", "Blue");
        Laptop lap8 = new Laptop(1,"MSI", 8, 500, 256, "Windows 11", "Gray");

        Set<Laptop> Laptops = new HashSet<>();
        Laptops.add(lap1);
        Laptops.add(lap2);
        Laptops.add(lap3);
        Laptops.add(lap4);
        Laptops.add(lap5);
        Laptops.add(lap6);
        Laptops.add(lap7);
        Laptops.add(lap8);

        return Laptops;
    }
    /**
     * Запрашивает параметры фильтрации для множества и показывает результат
     * @param laptop
     */
    private static void getResult(Set<Laptop> laptop){
        boolean filt = true;
        while (filt) {
            System.out.println("Выберите фильтры ноутбуков: \n"+
                "1 - Фильтровать по ОЗУ;\n"+
                "2 - Фильтровать по Производителю;\n"+
                "3 - Фильтровать по объему жесткого диска;\n"+
                "4 - Фильтровать по объему твердотельного накопителя;\n"+
                "5 - Фильтровать по операционной системе;\n"+
                "6 - Фильтровать по цвету;\n"+
                "7 - Завершить фильтрацию;\n"
            );
            String filter = sc.nextLine();
            switch (filter) {
                case "1" -> FilterRam(laptop);
                case "2" -> FilterVendor(laptop);
                case "3" -> FilterHDD(laptop);
                case "4" -> FilterSSD(laptop);
                case "5" -> FilterOS(laptop);
                case "6" -> FilterColor(laptop);
                case "7" -> filt = false;
                default -> {
                    System.out.println("Ошибка типа фильтра.");
                    getResult(laptop);
                }
            }
        }
    }
}
