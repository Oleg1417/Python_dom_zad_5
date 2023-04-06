import java.util.Comparator;
import java.util.TreeMap;
// Пусть дан список сотрудников:
// Иван Иванов
// Светлана Петрова
// Кристина Белова
// Анна Мусина
// Анна Крутова
// Иван Юрин
// Петр Лыков
// Павел Чернов
// Петр Чернышов
// Мария Федорова
// Марина Светлова
// Мария Савина
// Мария Рыкова
// Марина Лугова
// Анна Владимирова
// Иван Мечников
// Петр Петин
// Иван Ежов
// Написать программу, которая найдёт и выведет повторяющиеся имена с количеством повторений. 
// Отсортировать по убыванию популярности.

public class Task2 {
    public static void main(String[] args) {
        TreeMap<Integer, String> list = new TreeMap<>();
        TreeMap<Integer, String> listSorted = new TreeMap<>(Comparator.reverseOrder());
        list.put(1, "Иван Иванов");
        list.put(2, "Светлана Петрова");
        list.put(3, "Кристина Белова");
        list.put(4, "Анна Мусина");
        list.put(5, "Анна Крутова");
        list.put(6, "Иван Юрин");
        list.put(7, "Петр Лыков");
        list.put(8, "Павел Чернов");
        list.put(9, "Петр Чернышов");
        list.put(10, "Мария Федорова");
        list.put(11, "Марина Светлова");
        list.put(12, "Мария Савина");
        list.put(13, "Мария Рыкова");
        list.put(14, "Марина Лугова");
        list.put(15, "Анна Владимирова");
        list.put(16, "Иван Мечников");
        list.put(17, "Петр Петин");
        list.put(18, "Иван Ежов");

        for (int i : list.keySet()) {
            int count = 0;
            String arr[] = list.get(i).split(" ", 2);
            String nameI = arr[0];
            for (int j : list.keySet()) {
                String arrJ[] = list.get(j).split(" ", 2);
                String nameJ = arrJ[0];
                if (nameI.equalsIgnoreCase(nameJ)) {
                    count = count + 100;
                }
            }
            if (!listSorted.containsValue(nameI)) {
                listSorted.put(count + i, nameI);
            }
        }

        for (int i : listSorted.keySet()) {
            System.out.println(listSorted.get(i) + " популярность - " + i / 100);
        }
    }

}