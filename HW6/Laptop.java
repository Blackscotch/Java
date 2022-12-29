package HW6;

public class Laptop {
    /**
     * Идентификационный номер
     */
    private int id;
    /**
     * Производитель
     */
    private String name;
    /**
     * Оперативная память
     */
    private int ram;
    /**
     * Объем жесткого диска
     */
    private int hdd;
    /**
     * Объем твердотельного накомителя
     */
    private int ssd;
    /**
     * Операционная система
     */
    private String os;
    /**
     * Цвет ноутбука
     */
    private String color;

    public Laptop(int id, String name, int ram, int hdd, int ssd, String os, String color){
        this.id = id;
        this.name = name;
        this.ram = ram;
        this.hdd = hdd;
        this.ssd = ssd;
        this.os = os;
        this.color = color;
    }
    public int getid() {
        return id;
    }
    public String name() {
        return name;
    }
    public int getram() {
        return ram;
    }
    public int gethdd() {
        return hdd;
    }
    public int getssd() {
        return ssd;
    }
    public String getos() {
        return os;
    }
    public String color() {
        return color;
    }
    public String toString(){
        return String.format("id: %d, name: %s, ram: %d ГБ, hdd: %d ГБ, ssd: %d ГБ, OS: %s, color: %s", id, name, ram, hdd, ssd, os, color);
    }
    public boolean equals(Object o){
        Laptop l = (Laptop) o;
        return id == l.id;
    }
}
