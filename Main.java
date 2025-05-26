import java.util.*;

public class Main {
    public static Map<Address, Integer> costPerAddress = new HashMap<>();
    public static String country;
    public static String city;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<String> set = new HashSet<>();

        costPerAddress.put(new Address("Россия", "Ярославль"), 50);
        costPerAddress.put(new Address("Россия", "Москва"), 150);
        costPerAddress.put(new Address("Россия", "Симферополь"), 100);
        costPerAddress.put(new Address("Украина", "Харьков"), 70);
        costPerAddress.put(new Address("Украина", "Одесса"), 80);

        int allTotalCost = 0;
        while (true) {
            System.out.println("Заполнение нового заказа.");
            System.out.print("Введите страну: ");
            country = sc.nextLine();
            if ("end".equals(country)) {
                return;
            }
            System.out.print("Введите город: ");
            city = sc.nextLine();
            System.out.print("Введите вес (кг): ");
            int weight = Integer.parseInt(sc.nextLine());
            if (!verificationForAddress(country, city)) {
                System.out.println("Доставки по этому адресу нет");
            } else {
                set.add(country);
                Address key = new Address(country, city);
                int cost = costPerAddress.get(key);
                int totalCost = weight * cost;
                allTotalCost += totalCost;
                System.out.printf("Стоимость доставки составит: %d руб.%n", totalCost);
                System.out.printf("Общая стоимость всех доставок: %d руб.%n", allTotalCost);
                System.out.print("Доставки были оформлены в  такие страны: " + set);
            }
            System.out.println();
        }
    }

    public static boolean verificationForAddress(String country, String city) {
        Address key = new Address(country, city);
        if (costPerAddress.containsKey(key)) {
            return true;
        }
        return false;
    }
}
