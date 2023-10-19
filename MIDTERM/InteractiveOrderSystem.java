// NAME: DONITA ROSE D. SEGUERRA
// COURSE & YR : BSCA-2A
// SUB & SCHED : OOP 9:00AM-10:30AM
// ASSIGNMENT IN OOP

import java.util.*;

class MenuItem {
    private String name;
    private double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class Order {
    private Map<MenuItem, Integer> items;

    public Order() {
        items = new HashMap<>();
    }

    public void addItem(MenuItem item, int quantity) {
        items.put(item, items.getOrDefault(item, 0) + quantity);
    }

    public Map<MenuItem, Integer> getItems() {
        return items;
    }

    public double calculateTotalPrice() {
        double totalPrice = 0.0;
        for (Map.Entry<MenuItem, Integer> entry : items.entrySet()) {
            totalPrice += entry.getKey().getPrice() * entry.getValue();
        }
        return totalPrice;
    }
}

public class InteractiveOrderSystem {

    private static Scanner scanner = new Scanner(System.in);
    private static double exchangeRate = 57.0;

    public static void main(String[] args) {
        Map<String, MenuItem> menu = createMenu();
        Map<String, MenuItem> addons = createAddons();
        Order order = new Order();

        displayMenu(menu);
        displayAddons(addons);
        takeOrders(menu, addons, order);

        displayOrderSummary(order);
    }

    private static Map<String, MenuItem> createMenu() {
        Map<String, MenuItem> menu = new HashMap<>();
        menu.put("C1", new MenuItem("C1", 100.00));
        menu.put("C2", new MenuItem("C2", 150.00));
        menu.put("C3", new MenuItem("C3", 200.00));
        return menu;
    }

    private static Map<String, MenuItem> createAddons() {
        Map<String, MenuItem> addons = new HashMap<>();
        addons.put("R1", new MenuItem("R1", 35.00));
        addons.put("R2", new MenuItem("R2", 50.00));
        return addons;
    }

    private static void displayMenu(Map<String, MenuItem> menu) {
        System.out.println("Menu:");
        for (MenuItem item : menu.values()) {
            System.out.println(item.getName() + " - Php " + item.getPrice());
        }
    }

    private static void displayAddons(Map<String, MenuItem> addons) {
        System.out.println("\nAdd Ons:");
        for (MenuItem item : addons.values()) {
            System.out.println(item.getName() + " - Php " + item.getPrice());
        }
    }

    private static void takeOrders(Map<String, MenuItem> menu, Map<String, MenuItem> addons, Order order) {
        while (true) {
            System.out.print("Enter your selection (or 'done' to finish ordering): ");
            String choice = scanner.next().toUpperCase();

            if (choice.equals("DONE")) {
                break;
            }

            if (menu.containsKey(choice) || addons.containsKey(choice)) {
                System.out.print("How many " + choice + " do you want to order? ");
                int qty = scanner.nextInt();

                if (qty > 0) {
                    MenuItem selected = menu.containsKey(choice) ? menu.get(choice) : addons.get(choice);
                    order.addItem(selected, qty);
                    System.out.println(qty + " " + choice + " added to your order.");
                } else {
                    System.out.println("Quantity must be greater than zero.");
                }
            } else {
                System.out.println("Invalid selection. Please choose an item from the menu.");
            }
        }
    }

    private static void displayOrderSummary(Order order) {
        Map<MenuItem, Integer> orderItems = order.getItems();
        System.out.println("\nOrder Summary:");
        for (Map.Entry<MenuItem, Integer> entry : orderItems.entrySet()) {
            MenuItem item = entry.getKey();
            int qty = entry.getValue();
            System.out.println(item.getName() + ": " + qty + " x Php " + item.getPrice());
        }

        double totalPriceInPHP = order.calculateTotalPrice();
        double totalPriceInUSD = totalPriceInPHP / exchangeRate;

        System.out.println("Total Price in PHP: Php " + totalPriceInPHP);
        System.out.println("Total Price in USD: $" + totalPriceInUSD);
    }
}