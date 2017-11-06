package semesterprojekt;

import java.util.*;

public class Inventory {

    // Data field
    private int inventoryMaxQuantity = 10;
    private int currentQuantity = 0;
    private int inventoryMaxWeight = 10; //set default inventory weight 
    private int currentInventoryWeight = 0;
    private HashMap<String, Integer> inventory = new HashMap<>(); //Create a HashMap

    // Constructor, no arg  
    Inventory() {
    }

    // Constructor with args
    Inventory(int newInventoryMaxWeight) {
        inventoryMaxWeight = newInventoryMaxWeight;
    }

    // Method, getInventoryMaxWeight
    public int getInventoryMaxWeight() {
        return inventoryMaxWeight;
    }

    // Method, addItemToInventory
    public void addItemToInventory(Item _item) {
        int quantity = 0;
        String itemInInventory = "";
        String itemName = _item.getName();

        if (currentQuantity < inventoryMaxQuantity) {
            // If inventory already contains itemname, add 1 to quantity
            if (inventory.containsKey(itemName)) {
                quantity = inventory.get(itemName) + 1;

            } else {
                quantity = 1;
            }
            // Adds item to inventory hashmap
            inventory.put(itemName, quantity);
            currentQuantity += 1;
        } else {
            System.out.println("You cannot pickup this item");
        }
    }

    // Method, drops item from inventory
    public void dropItemInventory(String _string) {
        int quantity = inventory.get(_string) - 1;
        // If inventory quantity <= 1, remove item completely.
        if (inventory.get(_string) <= 1) {
            inventory.remove(_string);

            // Else, decrease quantity of item in inventory by 1
        } else {
            inventory.replace(_string, quantity);
        }

        currentQuantity = currentQuantity - 1;
//        getItems itemList
//        .put(_item, quantity);
//        quantity = itemList.get(_item)
    }

    // Method, get current inventory weight
    public int getCurrentInventoryWeight() {
        currentInventoryWeight = 0;

        //Iterates through list of item in inventory to get current inventory weight 
        for (String items : inventory.keySet()) {
            int quantity = inventory.get(items);
//            int weight = items.getWeight();
            int weight = 1;
            int thisItemWeight = quantity * weight;
            currentInventoryWeight += thisItemWeight;
        }
        return currentInventoryWeight;
    }

    // Method, get inventory
    public HashMap getInventory() {
        return inventory;
    }

    //Method, set new inventory max weight
    void setInventoryMaxWeight(int newInventoryMaxWeight) {
        inventoryMaxWeight = newInventoryMaxWeight;
    }
    
    // Method, use item
    public void useItem() {

    }
    
    // Method, show inventory
    public void showInventory() {
        System.out.println(inventory + "\n");
    }

//    public void addItemToInventory() {
//        if (checkInventoryMaxWeigth()) {
//            inventory.put(Item.Name, Item.Weight)   
//        } else {
//            System.out.println("Inventory is full");
//        }
//    }
//    public void dropItemInventory(Item _item) {
//        if(inventory.containsKey(_item)){
//        
//        inventory.remove(_item);
//        }
//    }
//   
//Check max weigth of the inventory everytime you pick up a new item
//    public boolean checkInventoryMaxWeigth() {
//        if (currentInventoryWeight + item.getWeight <= inventoryMaxWeight) {
//            return true;
//        } else {
//            return false;
//        }
//    }
}
