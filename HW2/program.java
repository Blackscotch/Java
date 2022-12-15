package HW2;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.logging.*;
import java.util.Arrays;
import java.util.Random;

public class program {

    public static void main(String[] args) {
        // Задача 1
        System.out.println("Выполняем задачу 1");
        JSONObject where = new JSONObject("{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}");
        String new_strig = SqlSelect(where).toString();
        System.out.println(new_strig);
        System.out.println();

        // Задача 2
        System.out.println("Выполняем задачу 2");
        
        int arr [] = new int[20];
        for (int i = 0; i < arr.length; i++) {
            int rand = new Random().nextInt(-100, 100);
            arr[i] = rand;
        }
        System.out.println(Arrays.toString(arr));
        int array [] = SortAndLog(arr);
        System.out.println("Отсортированный массив: "+Arrays.toString(array));
        System.out.println();

        // Задача 3
        System.out.println("Выполняем задачу 3");
        JSONArray new_arr = new JSONArray("[" +
            "{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"}," +
            "{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"}," +
            "{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]"
        );
        SetStudentJson(new_arr);
    }

        /**
         * Дана строка sql-запроса "select * from students where ".
         * Сформируйте часть WHERE этого запроса, используя StringBuilder.
         * Данные для фильтрации приведены ниже в виде json строки
         * Если значение null, то параметр не должен попадать в запрос.
         * Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
         */
        public static Object SqlSelect(JSONObject a){
            StringBuilder bilder = new StringBuilder("select * from students where");
            String name = (String) a.get("name");
            if (!name.matches("null")){
                bilder.append(" name = "+name);
            }
            String country = (String) a.get("country");
            if (!country.matches("null")){
                bilder.append(" and country = "+country);
            }
            String city = (String) a.get("city");
            if (!city.matches("null")){
                bilder.append(" and city = "+city);
            }
            String age = (String) a.get("age");
            if (!age.matches("null")){
                bilder.append(" and age = "+age);
            }
            return bilder;
        }

        /**
         * Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл
         */
        private static int[] SortAndLog(int[] arr){
            Logger logger = Logger.getLogger(program.class.getName());
            FileHandler fh = null;
            try {
                fh = new FileHandler("log.txt");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            logger.addHandler(fh);
            SimpleFormatter sFormatter = new SimpleFormatter();
            fh.setFormatter(sFormatter);

            logger.info("Метод 'SortAndLog' стартовал.");
            logger.info("Массив для обработки: "+Arrays.toString(arr));
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length - 1; j++) {
                    if(arr[j] > arr[j + 1]){
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
                logger.info("Итерация {"+i+"}: "+Arrays.toString(arr));
            }
            logger.info("Метод завершен.");
            return arr;
        }
        
        /**
         * Дана json строка (можно сохранить в файл и читать из файла)
         * Написать метод(ы), который распарсит json и, используя StringBuilder,
         * создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет]
         * Пример вывода:
         * Студент Иванов получил 5 по предмету Математика.
         * Студент Петрова получил 4 по предмету Информатика.
         * Студент Краснов получил 5 по предмету Физика.
         */
        private static void SetStudentJson(JSONArray b){
            StringBuilder studetn = new StringBuilder();
            for (int i = 0; i < b.length(); i++)
            {
                String lastName = (String) b.getJSONObject(i).get("фамилия");
                String grade = (String) b.getJSONObject(i).get("оценка");
                String subject = (String) b.getJSONObject(i).get("предмет");
                studetn.append("Студент " + lastName + " получил " + grade + " по предмету " + subject+"\n");
            }
            System.out.println(studetn);
        }
}
