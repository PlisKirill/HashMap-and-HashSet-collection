import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<String> set = new HashSet<>();
        Address address = new Address(null, null);
        Map<Address, Integer> costPerAddress = new HashMap<>();

        costPerAddress.put(new Address("Россия", "Ярославль"), 50);
        costPerAddress.put(new Address("Россия", "Москва"), 150);
        costPerAddress.put(new Address("Россия", "Симферополь"), 100);
        costPerAddress.put(new Address("Украина", "Харьков"), 70);
        costPerAddress.put(new Address("Украина", "Одесса"), 80);

        int allTotalCost = 0;
        while (true) {
            System.out.println("Заполнение нового заказа.");
            System.out.print("Введите страну: ");
            address.setCountry(sc.nextLine());
            if ("end".equals(address.getCountry())) {
                return;
            }
            System.out.print("Введите город: ");
            address.setCity(sc.nextLine());
            System.out.print("Введите вес (кг): ");
            int weight = Integer.parseInt(sc.nextLine());
            if (!costPerAddress.containsKey(address)) {
                System.out.println("Доставки по этому адресу нет!");
                address.setCountry(null);
                address.setCity(null);
            } else {
                set.add(address.getCountry());
                int cost = costPerAddress.get(address);
                int totalCost = weight * cost;
                allTotalCost += totalCost;
                System.out.printf("Стоимость доставки составит: %d руб.%n", totalCost);
                System.out.printf("Общая стоимость всех доставок: %d руб.%n", allTotalCost);
                System.out.print("Доставки были оформлены в  такие страны: " + set);
            }
            address.setCountry(null);
            address.setCity(null);
            System.out.println();
        }
    }
}
