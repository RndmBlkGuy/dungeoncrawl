import java.io.*; 
import java.lang.*; 
import java.util.*; 

public class Player{

    
    private String name;
    private HashSet <String> keys = new HashSet<String>();


    public Player(String _name){
        name = _name;
    }

    public String getName(){
        return name;
    }

    public void placeKeyInInventory(String keyName){
        keys.add(keyName);
    }

    public boolean doesPlayerHaveKey(String keyName){
        return keys.contains(keyName);
    }

    public void resetPlayer(){
        name = "";
        keys.remove("Key");
    }
}