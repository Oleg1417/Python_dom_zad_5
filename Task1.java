import java.util.HashMap;
import java.util.Scanner;

//Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может 
//иметь несколько телефонов.

public class Task1 {

    public static void main(String[] args) {
        HashMap<String, String> list = new HashMap<String, String>();
        next(list);
    }

    public static void next(HashMap<String, String> list) {
        if (list.isEmpty()) {
            System.out.println("телефонная книга пуcта");
        } else {
            for (String i : list.keySet()) {
                System.out.println(i + " телефон: " + list.get(i));
            }
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print(
                "1: добавить контакт\n2: добавить номер к контакту\n3: изменить контакт\n4: удалить контакт\n5: Выход\n input:  ");
        int a = scanner.nextInt();
        switch (a) {
            case 1:
                addContact(list, 1, "", "");
                break;
            case 4:
                deleteContact(list);
                break;
            case 2:
                addContact(list, 3, "", "");
                break;
            case 3:
                addContact(list, 2, "", "");
                break;
            case 5:
                System.exit(0);
                break;
        }
        scanner.close();
    }

    public static void addContact(HashMap<String, String> list, int temp, String name, String number) {
        Scanner scanner = new Scanner(System.in);
        if (temp == 1) {
            System.out.print("Введите имя и фамилию: ");
            name = scanner.nextLine();
            if (list.containsKey(name)) {
                System.out.println("Такой контакт уже существует");
                next(list);
            }
        } else if (temp > 1) {
            System.out.print("Введите имя и фамилию: ");
            name = scanner.nextLine();
            if (!list.containsKey(name)) {
                System.out.println("Такого контакта не существует");
                next(list);
            }
        }
        if (temp > 2) {
            number = list.get(name);
        }
        System.out.print("\nВведите номер: ");
        number = scanner.nextLine() + ", " + number;
        list.put(name, number);
        next(list);
        scanner.close();
    }

    public static void deleteContact(HashMap<String, String> list) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя и фамилию контакта: ");
        String name = scanner.nextLine();
        list.remove(name);
        next(list);
        scanner.close();
    }

}