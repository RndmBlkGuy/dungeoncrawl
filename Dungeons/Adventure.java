import java.io.*; 
import java.lang.*; 
import java.util.*; 
import java.util.Scanner;

public class Adventure{

    public static void main(String args[]){

        GameMaster gameMaster = new GameMaster();

        boolean isGameOver = false;
        
        gameMaster.newGame();

        while(!isGameOver){

            isGameOver = gameMaster.gameLoop();


        }
        
    }
}