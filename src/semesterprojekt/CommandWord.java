package semesterprojekt;

/**
 * @author Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */

//Enum containing the command words and their represented strings for the user input
public enum CommandWord { 
    GO("go"), QUIT("quit"), HELP("help"), UNKNOWN("?"), INSPECT("inspect"), TAKE("take"), USE("use"), TALK("talk"), DROP("drop"), CRAFT("craft"), SHOW("show"), MISSION("mission"); //her ses de førnævnte værdier
    
    //String used to set the command words
    private String commandString; 
    
    //Constructor that sets the commandString of the CommandWord, while creating it
    /** 
     * @param commandString used to set the commandString
     */
    CommandWord(String commandString) { 
        this.commandString = commandString; 
    }

    /**
    *@return the commandString as a String
    */
    public String toString() { 
        return commandString;
    }
}
