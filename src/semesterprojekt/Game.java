package semesterprojekt;

import java.util.ArrayList;

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
    Inventory ob2 = new Inventory();

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
        ob1.addItem(airport, new Item("bottle"));
        ob1.addItem(airport, new Item("boardingpass"));

        beach.setExit("north", jungle);
        beach.setExit("south", seaBottom);
        beach.setExit("west", camp);

        ob1.addItem(beach, new Item("stone"));
        ob1.addItem(beach, new Item("fish"));
        ob1.addItem(beach, new Item("flint"));
        ob1.addItem(beach, new Item("rope"));
        ob1.addItem(beach, new Item("stick"));

        jungle.setExit("north", mountain);
        jungle.setExit("east", cave);
        jungle.setExit("south", beach);
        ob1.addItem(jungle, new Item("berry"));
        ob1.addItem(jungle, new Item("lumber"));
        ob1.addItem(jungle, new Item("lian"));
        ob1.addItem(jungle, new Item("stone"));
        ob1.addItem(jungle, new Item("stick"));

        mountain.setExit("south", jungle);
        ob1.addItem(mountain, new Item("stone"));
        ob1.addItem(mountain, new Item("egg"));

        cave.setExit("west", jungle);
        ob1.addItem(cave, new Item("shroom"));
        ob1.addItem(cave, new Item("stone"));
        ob1.addItem(cave, new Item("freshwater"));
        ob1.addItem(cave, new Item("flint"));

        camp.setExit("east", beach);
        camp.setExit("west", raft);
        ob1.addItem(camp, new Item(""));

        seaBottom.setExit("north", beach);
        ob1.addItem(seaBottom, new Item("backpack"));
        ob1.addItem(seaBottom, new Item("waterBottle"));
        ob1.addItem(seaBottom, new Item("rope"));

        raft.setExit("east", camp);

        currentRoom = airport;

    }

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
        } else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);
        } else if (commandWord == CommandWord.INSPECT) {
            ArrayList items = ob1.getItems(currentRoom);
            Item seeItem;

            for (int i = 0; i < items.size(); i++) {

                seeItem = (Item) items.get(i);
                System.out.println(seeItem.getName());
            }

       } else if (commandWord == CommandWord.TAKE) {

            ArrayList items2 = ob1.getItems(currentRoom);
            Item seeItem;
            int indexItem = -1;
            
            for (int i = 0; i < items2.size(); i++) {
                seeItem = (Item) items2.get(i);
                if (seeItem.getName().equalsIgnoreCase(command.getSecondWord())) {
                    indexItem = i;
                    break;
                }
            }
            if(indexItem >= 0){
                items2.remove(indexItem);
                ob1.setItem(currentRoom, items2);
                System.out.println("You took "+command.getSecondWord());
            }
            else
                System.out.println("could not find item");
            
        }
        
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

    //method that when....
    private boolean quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        } else {
            return true;
        }
    }
}
