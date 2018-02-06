/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package undoredo;

/**
 *
 * @author unouser
 */
public class Command {
    
    String string;
    
    public Command(String inString)
    {
        string = inString;
    }
    
    public String Do(String currentSentence){
        return currentSentence + " " + string;
    }
    
    public String Undo(String currentSentence){
       return currentSentence.substring(0, currentSentence.lastIndexOf(" "));
    }
    
}
