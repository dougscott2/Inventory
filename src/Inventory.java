import java.util.ArrayList;
import java.util.Scanner;
/**
 * Created by DrScott on 10/12/15.
 */
public class Inventory {
    static void printInventory(ArrayList<InventoryList> list){
        int inventoryNum = 1;

        for (InventoryList inventory : list){

            System.out.println( inventoryNum + ". [" + inventory.quantity + "] " + inventory.item);
            inventoryNum++;
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ArrayList<InventoryList> inventory = new ArrayList();


        while(true){   //infinite loop
            printInventory(inventory);
            System.out.println("Inventory options");
            System.out.println("[1] Create new inventory item");
            System.out.println("[2] Remove item");
            System.out.println("[3] Update item quantity");
            bumdsfadsf

            String option = scanner.nextLine();
            int optionNum = Integer.valueOf(option);


            if(optionNum == 1){
                //create new inventory code
                System.out.println("What would you like to add?");
                String newItem = scanner.nextLine();
                InventoryList list = new InventoryList(newItem);
                System.out.println("How many " + newItem + " are you adding?");
                String amount = scanner.nextLine();
                int newQuantity = Integer.valueOf(amount);
                list.quantity = newQuantity;


                inventory.add(list);

            }
            else if (optionNum == 2){
                //delete inventory code
                System.out.println("Which item would you like to remove?");
                String select = scanner.nextLine();
                int selectNum = Integer.valueOf(select);
                InventoryList list = inventory.remove(selectNum - 1);

            }
            else if (optionNum == 3){
                System.out.println("Which item would you like to change?");
                String select = scanner.nextLine();
                int selectNum = Integer.valueOf(select);
                InventoryList list = inventory.get(selectNum - 1);

                // selectNum - 1 to keep it in line with the array
                System.out.println("You currently have " + list.quantity + " " + list.item);
                System.out.println("What is the new amount?");
                select = scanner.nextLine();
                int newQuantity = Integer.valueOf(select);
                list.quantity = newQuantity;



            }
        }
    }

}
