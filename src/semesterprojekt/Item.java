/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semesterprojekt;
import java.util.Date;
/**
 *
 * @author marti
 */
public class Item {
/*
    Dette dokument er ikke færdigarbejdet
    */
    private String itemDescribtion;

    /*
    Klasse: Item
    Constructor: Item(name, weight, respawnTime, mapLocation(StringArray))
    Metoder: getItemOnMap, setItemOnMap, addItemInInventory, removeItemFromInventory, setItemDescribtions, getItemDescribtion, getRespawnTime
     */
    
//Creating a constructor with a parameter-list, Room mapLocation maybe has to be changed
    Item(String name, int weight, Date respawnTime, Room mapLocation) {
        //This body is left empty for now
    }

    public Item getItemOnMap(Item[] allItems) {
//        This body is left empty for now
    }

    public void setItemOnMap(Item _item, Room location) {
//        Body is empty
    }

    public boolean addItemInInventory(Item _item) {
        if (item.weight + totalWeightInBackpack < maxCarryWeight) {
            //Body is empty
            return true;
        } else {
            return false;
        }
    }

    public void removeItemFromInventory(Item _item) {
        //Her skal objekt"tingen" sættes til null, hvis en anden bedre måde ikke fremkommer
    }

    public void setItemDescribtions(String newDescribtion) {
        itemDescribtion=newDescribtion;
    }
    public String getItemDescribtion(){
        return itemDescribtion;
    }
    public Date getRespawnTime(){
//        return spawnTime;
    }
}
