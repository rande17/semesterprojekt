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

    HashMap<Room, ArrayList> ItemList = new HashMap<>();
    private ArrayList items;

    public ItemLocation() {

    }

    public void addItem(Room _room, Item _item) {
        if (!ItemList.containsKey(_room)) {
            ItemList.put(_room, new ArrayList());
        }
        items = ItemList.get(_room);
        items.add(_item);
        ItemList.put(_room, items);
    }
//    public ArrayList getItems(Room room){
        ArrayList getItems(Room currentRoom) {
        return ItemList.get(currentRoom);
    }
    
public void setItem(Room _room, ArrayList itemsInRoom){
    ItemList.replace(_room, itemsInRoom);
}

   

}
