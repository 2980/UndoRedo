/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package undoredo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author unouser
 */
public class UndoRedo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        Scanner scanner = new Scanner(System.in);
        
        while(true)
        {
            String nextWord = scanner.next();
            
            if(nextWord.equals("undo"))
            {
                undo();
            }
            else if(nextWord.equals("redo"))
            {
                redo();
            }
            else
            {
                addWord(nextWord);
            }
            
            System.out.println(currentSentence);
            
            
        }
    }
    
    
    /*
    Two undo/redo philosophies....
    1. Keep a complete copy of the every moment of the past in a stack.
    -Easy to implement (if ou keep evething in a global model.
    2. Command Objects (delta). Keep track of what changed and how to undo it and redo it
    -Harder to implement, but the only practical approach.
    */
    
    //Approach 1
    /*static List<String> UndoStack = new ArrayList<String>();
    static List<String> RedoStack = new ArrayList<String>();*/
    
    //Approach 2
    static List<Command> UndoStack = new ArrayList<Command>();
    static List<Command> RedoStack = new ArrayList<Command>();
    
    
    static String currentSentence = "";

    private static void undo() {      
       
        Command last = UndoStack.get(UndoStack.size() - 1);
        UndoStack.remove(UndoStack.size() - 1);
        RedoStack.add(last);
        currentSentence = last.Undo(currentSentence);
    }

    private static void redo() {
        Command last = RedoStack.get(UndoStack.size() - 1);
        RedoStack.remove(RedoStack.size() - 1);
        currentSentence =last.Do(currentSentence);
        UndoStack.add(last);
    }

    private static void addWord(String nextWord) {
        Command newCommand = new Command(nextWord);
        UndoStack.add(newCommand);
        currentSentence = newCommand.Do(currentSentence);
    }

    
    
}
