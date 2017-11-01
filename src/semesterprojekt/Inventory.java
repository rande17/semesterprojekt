/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semesterprojekt;

import java.util.*;

/**
 *
 * @author marti
 */
public class Inventory {

    private int inventoryMaxWeight = 10; //set default inventory weight 
    private int currentInventoryWeight = 0;
    private HashMap<Item, Integer> inventory = new HashMap<>(); //Create a HashMap
//constuctor  

    Inventory() {
    }
//constructer

    Inventory(int newInventoryMaxWeight) {
        inventoryMaxWeight = newInventoryMaxWeight;
    }
//get max inventory weight

    public int getInventoryMaxWeight() {
        return inventoryMaxWeight;
    }

    public void addItemInInventory(Item _item) {
        int quantity = 0;
        if (_item.getWeight() + currentInventoryWeight < inventoryMaxWeight) {
            if(inventory.containsKey(_item)){
                quantity = inventory.get(_item) + 1;
            }else{
                quantity = 1;
            }
         inventory.put(_item, quantity);
         
        } else {
            System.out.println("You can't pickup this item");
        }
    }

//get current inventory weight
    public int getCurrentInventoryWeight() {
        currentInventoryWeight = 0;
        //Iterates through list of item in inventory to get current inventory weight 

        for (Item items : inventory.keySet()) {
            int quantity = inventory.get(items);
            int weight = items.getWeight();
            int thisItemWeight = quantity * weight;
            currentInventoryWeight += thisItemWeight;

        }

        return currentInventoryWeight;
    }

    // get inventory
    public HashMap getInventory() {
        return inventory;
    }

//Set new weight for the inventory
    void setInventoryMaxWeight(int newInventoryMaxWeight) {
        inventoryMaxWeight = newInventoryMaxWeight;
    }

    public void useItem() {

    }

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
