package semesterprojekt;

import java.util.Date;

public class Item {

    // Data field
    private String itemDescribtion;
    private int maxCarryWeight = 10;
    private int totalWeightInBackpack;
    private int weight = 1;
    private Date respawnTime;
    private Room mapLocation;
    private String name;

    /**
     *
     * @param _name
     */
    // Constructor, with arg, Room mapLocation maybe has to be changed
    Item(String _name) {
        name = _name;
    }

    /**
     *
     * @param _name
     * @param _weight
     */
    // Constructor
    Item(String _name, int _weight) {
        name = _name;
        weight = _weight;
    }

    /**
     *
     * @param _name
     * @param _weight
     * @param _respawnTime
     * @param _mapLocation
     */
    // Constructor
    Item(String _name, int _weight, Date _respawnTime, Room _mapLocation) {
        name = _name;
        weight = _weight;
        respawnTime = _respawnTime;
        mapLocation = _mapLocation;
    }

    /**
     *
     * @return
     */
    // Method, get weight
    public int getWeight() {
        return weight;
    }

    /**
     *
     * @param newDescribtion
     */
    // Method, set item desribtion
    public void setItemDescribtions(String newDescribtion) {
        itemDescribtion = newDescribtion;
    }

    /**
     *
     * @return
     */
    // Method, get item describtion
    public String getItemDescribtion() {
        return itemDescribtion;
    }

    /**
     *
     * @return
     */
    // Method, get respawntime
    public Date getRespawnTime() {
        return respawnTime;
    }

    /**
     *
     * @return
     */
    // Method, get name
    public String getName() {
        return name;
    }
}
