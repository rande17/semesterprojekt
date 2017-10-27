/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semesterprojekt;

import java.util.ArrayList;

/**
 *
 * @author marti
 */
public class NPC {

    private String desc;
    private int dmgValue;
    private ArrayList<String> dialog = new ArrayList<String>();
    private Room currentPosition;

    
    // Constructor, creates NPC's
    public NPC(String name, Room currentPosition) {

    }

    
    
    public void addDialog(String _dialog) {
        dialog.add(_dialog);
    }

    public String getDialog(int i) {
        if (i > 0 && i < dialog.size()) {
            return "You have baffled me, I don't know what to say";
        }
        return dialog.get(i);
    }

    public void setDamageValue(int _dmgValue) {
        dmgValue = _dmgValue;
    }

    public int damageValue() {

        return dmgValue;
    }

    public void setDescribtion(String _desc) {
        desc = _desc;
    }

    public String getDescribtion() {
        return desc;
    }

    public void quitDialog() {

    }

    public Room getCurrentRoom() {
        return currentPosition;
    }

    public void setCurrentRoom(Room goToRoom) {
        currentPosition = goToRoom;
    }

}
