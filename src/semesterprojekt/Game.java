package semesterprojekt;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Michael Kolling and David J. Barnes
 * @version 2006.03.30
 * @author Nicolai
 * @version 2006.03.30daSFT
 */
public class Game {

    /* data field with the attributes parser and currentRoom
       making them private so we only can use them in the Game class */
    private Parser parser;
    private Room currentRoom;

    /* Constructor that runs the method createRooms and set our variable parser
       equal to the Parser method in the Parser class */
    public Game() {
        createRooms();
        parser = new Parser();
    }

    /* Private method createRoom which means we can only use createRoom in the Game class */
 /* In the method body we set the names of the rooms, create the rooms by using the Room 
       constructor from the Room class and then set where you can move to from the different rooms by
       using the method setExit from the Room class */
 /* The currentRoom is also given a value which is the start location = outside */
    ItemLocation ob1 = new ItemLocation();
    Inventory inventory = new Inventory();
    NPC npc1 = new NPC();
    NPC npc2 = new NPC();
    NPC npc3 = new NPC();
    Item debug = new Item("debug");

    private void createRooms() {
        Room airport, beach, jungle, mountain, cave, camp, raft, seaBottom;

        airport = new Room("at the airport");
        beach = new Room("at the beach");
        jungle = new Room("in the jungle");
        mountain = new Room("at the mountain");
        cave = new Room("in the cave");
        camp = new Room("in the camp");
        seaBottom = new Room("at the bottom of the sea");
        raft = new Room("building the raft");

        airport.setExit("west", beach);
        ob1.addItem(airport, new Item("Bottle"));
        ob1.addItem(airport, new Item("Boardingpass"));

        beach.setExit("north", jungle);
        beach.setExit("south", seaBottom);
        beach.setExit("west", camp);

        ob1.addItem(beach, new Item("Stone"));
        ob1.addItem(beach, new Item("Fish"));
        ob1.addItem(beach, new Item("Flint"));
        ob1.addItem(beach, new Item("Rope"));
        ob1.addItem(beach, new Item("Stick"));

        jungle.setExit("north", mountain);
        jungle.setExit("east", cave);
        jungle.setExit("south", beach);
        ob1.addItem(jungle, new Item("Berry"));
        ob1.addItem(jungle, new Item("Lumber"));
        ob1.addItem(jungle, new Item("Lian"));
        ob1.addItem(jungle, new Item("Stone"));
        ob1.addItem(jungle, new Item("Stick"));
        
        npc1.NPC("Good guy", jungle);
        npc1.setDescribtion("The survivor of the plane crash look to be some kind of veteran soldier, but he is heavly injured on his right leg so he cant move ");
        npc1.addDialog("If you want to survive on this GOD forsaken island, you must first find food and shelter");
        
        mountain.setExit("south", jungle);
        ob1.addItem(mountain, new Item("Stone"));
        ob1.addItem(mountain, new Item("Egg"));
        
        npc3.NPC("Evil guy", mountain);
     
        cave.setExit("west", jungle);
        ob1.addItem(cave, new Item("Shroom"));
        ob1.addItem(cave, new Item("Stone"));
        ob1.addItem(cave, new Item("Freshwater"));
        ob1.addItem(cave, new Item("Flint"));
        
        npc2.NPC("Mysterious crab", cave);
        npc2.setDescribtion("A mysterious crab that you dont really get why can talk");
        npc2.addDialog("MUHAHAHA i'm the finest and most knowledgeable crab of them all mr.Crab and know this island like the back of my hand.... oh i mean claw"
                     + "\n SO if you want the rarest item you can find on this island, you must first help me find some stuff ");
        
        
        camp.setExit("east", beach);
        camp.setExit("west", raft);
        ob1.addItem(camp, new Item(""));

        seaBottom.setExit("north", beach);
        ob1.addItem(seaBottom, new Item("Backpack"));
        ob1.addItem(seaBottom, new Item("WaterBottle"));
        ob1.addItem(seaBottom, new Item("Rope"));

        raft.setExit("east", camp);

        currentRoom = airport;

    }
    
//    private void createItems(){
//    
//    ob1.addItem(airport, new Item("Bottle"));
//    ob1.addItem(airport, new Item("Boardingpass"));    
//    }
    

    /* A method that is initialized when we start the game, that first print out a message with the printWelcome method  
       and then checks if the game is finished or not with a while loop where finished is set to false when the game start*/
    public void play() {
        printWelcome();

        boolean finished = false;

        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        
        System.out.println("Thank you for playing.  Good bye.");
    }

    /* A method that is used in the play method to print a message when you start the game */
    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to the game Stranded!");
        System.out.println("Stranded is an adventure game, where you are to "
                + "find out how to escape the island");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /* A method that set wantToQuit to false and the run a if loop that that does so everytime the commandWord is  
       not know to the game it print out the message "I don't know what you mean..." and return false*/
 /* It does the same with Help and GO where it print out a message with the use of the method printHelp and goRoom
       and if the command word is quit it return wantToQuit*/
    private boolean processCommand(Command command) {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        if (commandWord == CommandWord.UNKNOWN) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        if (commandWord == CommandWord.HELP) {
            printHelp();
        } else if (commandWord == CommandWord.GO) {
            goRoom(command);
        } else if (commandWord == CommandWord.SHOW) {
            showInventory(command);
        } else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);
        } else if (commandWord == CommandWord.INSPECT) {
            inspectRoom(command);
        } else if (commandWord == CommandWord.TAKE) {
            takeItem(command);
        } else if (commandWord == CommandWord.TALK) {
//            TalkTo(command);
    }
//        else if (commandWord == CommandWord.DROP) {
//            DropItem(command);
//        }
        return wantToQuit;
    }

    /* A method to print a message that show the different commands everytime the command help is used */
    private void printHelp() {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around on this god forsaken island.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /* method that is initializing everytime you use the command "go" and print the message "Go where" */
    private void goRoom(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        Room nextRoom = currentRoom.getExit(direction);
        /* loop that when next room is equel to null it print a message that says "there is no door" 
           but if nextRoom is not equel null set currentRoom to nextRoom and print the description of the new room*/
        if (nextRoom == null) {
            System.out.println("There is no path!");
        } else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }

    private void showInventory(Command command) {

        HashMap<Item, Integer> inventoryHM = inventory.getInventory();
        for (Item i : inventoryHM.keySet()) {
            System.out.println(inventoryHM.get(i) + "x" + i.getName());
        }
    }

    private void inspectRoom(Command command) {
        ArrayList items = ob1.getItems(currentRoom);
        Item seeItem;

        for (int i = 0; i < items.size(); i++) {

            seeItem = (Item) items.get(i);
            System.out.print(seeItem.getName());
            System.out.println();    
        }
        
    }

    private void takeItem(Command command) {
        ArrayList items2 = ob1.getItems(currentRoom);
        Item seeItem;
        int indexItem = -1;
        Item addToInventory = debug;

        for (int i = 0; i < items2.size(); i++) {
            seeItem = (Item) items2.get(i);
            if (seeItem.getName().equalsIgnoreCase(command.getSecondWord())) {
                addToInventory = seeItem;
                indexItem = i;
                break;
            }
        }
        if (indexItem >= 0) {
            System.out.println(addToInventory.getName());
            inventory.addItemInInventory(addToInventory);
            items2.remove(indexItem);
            ob1.setItem(currentRoom, items2);
        } else {
            System.out.println("could not find " + command.getSecondWord());
        }
    }
    
//     private void TalkTo(Command command){
//        ArrayList talk =  
//        if(npc1 == currentRoom)
//          getdialog();
//     }
        
//    private void DropItem(Command command) {
//        HashMap items3 = inventory.getInventory();
//        Item seeItem;
//        int indexItem = -1;
//        Item DropFromInventory = debug;
//
//        for (int i = 0; i < items3.size(); i++) {
//            seeItem = (Item) items3.get(i);
//            if (seeItem.getName().equalsIgnoreCase(command.getSecondWord())) {
//                DropFromInventory = seeItem;
//                indexItem = i;
//                break;
//            }
//            
//        }
//        if (indexItem >= 0) {
//            inventory.dropItemInventory(DropFromInventory);
//            items3.remove(indexItem);
//        } else {
//            System.out.println("Can't drop item that isn't in inventory " + command.getSecondWord());
//        }
//    }
    
    
    //method to quit the game and if there is a second word it print out a line "Quit what"
    private boolean quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        } else {
            return true;
        }
    }
}
