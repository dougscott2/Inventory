import java.util.ArrayList;
import java.util.Scanner;
/**
 * Created by DrScott on 10/12/15.
 */
public class Inventory {
    static void printInventory(ArrayList<InventoryItem> list) {
        int inventoryNum = 1;

        for (InventoryItem inventory : list) {
            System.out.println(String.format("%d. [%d] %s [%s]", inventoryNum, inventory.quantity, inventory.item, inventory.category));
            inventoryNum++;
        }
    }
    public static void main(String[] args) throws Exception{  //that sweet sweet main class
        Scanner scanner = new Scanner(System.in);
        ArrayList<InventoryItem> inventory = new ArrayList();

        while (true) {
            printInventory(inventory);
            System.out.println("Inventory options");
            System.out.println("[1] Create new inventory item");
            System.out.println("[2] Remove item");
            System.out.println("[3] Update item quantity");

            String option = scanner.nextLine();
            int optionNum = Integer.valueOf(option);

            if (optionNum == 1) {
                System.out.println("What would you like to add?");
                String newItem = scanner.nextLine();
                System.out.println(String.format("How many %s are you adding?", newItem));
                String amount = scanner.nextLine();
                int newQuantity = Integer.valueOf(amount);
                System.out.println("What category does it fall into? 'Fruits, Dairy, Vegetable, Meat, or Grain?");
                String category = scanner.nextLine();
                InventoryItem list = createItem(newItem, newQuantity, category);
                inventory.add(list);
            } else if (optionNum == 2) {
                System.out.println("Which item would you like to remove?");
                String select = scanner.nextLine();
                int selectNum = Integer.valueOf(select);
                inventory.remove(selectNum - 1);
            } else if (optionNum == 3) {
                System.out.println("Which item would you like to change?");
                String select = scanner.nextLine();
                int selectNum = Integer.valueOf(select);
                InventoryItem list = inventory.get(selectNum - 1);
                System.out.println(String.format("You currently have %d %s  [%s]", list.quantity, list.item, list.category));
                System.out.println("What is the new amount?");
                select = scanner.nextLine();
                int newQuantity = Integer.valueOf(select);
                list.quantity = newQuantity;
            }
        }
    }
            static InventoryItem createItem(String item, int quantity, String category) throws Exception {

                if (category.equals("Fruits")) {
                    return new Fruits(item, quantity);
                } else if (category.equals("Vegetable")) {
                    return new Vegetable(item, quantity);
                } else if (category.equals("Meat")) {
                    return new Meat(item, quantity);
                } else if (category.equals("Dairy")) {
                    return new Dairy(item, quantity);
                } else if (category.equals("Grain")) {
                    return new Grain(item, quantity);
                } else {
                    //throw new Exception("That doesn't exist");
                    return null;

                }
    }
}








