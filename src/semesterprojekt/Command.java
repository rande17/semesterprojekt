package semesterprojekt;

/**
 * @author Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public class Command {

    private CommandWord commandWord;
    private String secondWord;
    
    //Laver et commandWord der skal have et secondWord
    public Command(CommandWord commandWord, String secondWord) {
        this.commandWord = commandWord;
        this.secondWord = secondWord;
    }
    //Laver getter metoder
    public CommandWord getCommandWord() {
        return commandWord;
    }
    
    public String getSecondWord() {
        return secondWord;
    }
    
    //Tjekker om den command der er blevet indtastet er korrekt
    public boolean isUnknown() {
        return (commandWord == CommandWord.UNKNOWN);
    }
    //Tjekker om commandWord har second word
    public boolean hasSecondWord() {
        return (secondWord != null);
    }
}
