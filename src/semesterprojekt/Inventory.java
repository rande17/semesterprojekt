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
    private int currentInventoryWeight;
    public Map<String, Integer> inventory = new HashMap<>(); //Create a HashMap
//constucter  

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
//get current inventory weight

    public int getCurrentInventoryWeight() {
        currentInventoryWeight = 0;
        //Iterates through list of item in inventory to get current inventory weight 
        for (Item item : int) {
            currentWeight
    }

    {
            currentInventoryWeight += item.weight
        
        
    }

        return currentInventoryWeight
                = // accumulated weight of inventory?;
    }

//Set new weight for the inventory
    void setInventoryMaxWeight(int newInventoryMaxWeight) {
        inventoryMaxWeight = newInventoryMaxWeight;
    }

    useItem() {

    }

    public void showInventory() {
        System.out.println(inventory + "\n");
    }

    public void addItemToInventory() {
        if (checkInventoryMaxWeigth()) {
            inventory.put(Item.Name, Item.Weight)   
        } else {
            System.out.println("Inventory is full");
        }

    }

    dropItemInventory() {
    }
//Check max weigth of the inventory everytime you pick up a new item

    public boolean checkInventoryMaxWeigth() {
        if (currentInventoryWeight + item.getWeight <= inventoryMaxWeight) {
            return true;
        } else {
            return false;
        }
    }
}
