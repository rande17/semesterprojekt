/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semesterprojekt;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author marti
 */
public class ItemLocation {

    HashMap<Room, ArrayList> itemList = new HashMap<>();
    private ArrayList items;

    public ItemLocation() {

    }

    public void addItem(Room _room, Item _item) {
        if (!itemList.containsKey(_room)) {
            itemList.put(_room, new ArrayList());
        }
        items = itemList.get(_room);
        items.add(_item);
        itemList.put(_room, items);
    }
//    public ArrayList getItems(Room room){
        ArrayList getItems(Room currentRoom) {
        return itemList.get(currentRoom);
    }
    
public void setItem(Room _room, ArrayList itemsInRoom){
    itemList.replace(_room, itemsInRoom);
}

}
