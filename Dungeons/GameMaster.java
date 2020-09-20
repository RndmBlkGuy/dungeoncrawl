import java.io.*; 
import java.lang.*; 
import java.util.*; 
import java.util.Scanner;

public class GameMaster{
    
    private Room currentRoom;
    private Player player;
    enum GameState{
        INTRO,
        ACTION,
        GOAL
    }

    GameState gs;
    Scanner readInput = new Scanner(System.in);

    public void newGame(){
        gs = gs.INTRO;
        player = new Player("test");
        createRooms();
    }
    
    public boolean gameLoop(){

        didPlayerWin();

        System.out.println("###########################################################################");
        giveMeSpace();

        switch(gs){
            case INTRO:
                Introduction();
                gs = gs.ACTION;
            break;

            case ACTION:
                System.out.println("You currently in " + currentRoom.getRoomName());
                System.out.println("There is " + currentRoom.getItem() + " in the room");

                giveMeSpace();

                playerChoice(currentRoom);

                String playerAction = readInput.nextLine();

                if(playerAction.equals("p")){
                    pickUpKey();
                }
                else if(playerAction.equals("q")){
                    System.out.println("Thanks for playing");
                    System.exit(0); 
                }
                else{
                    move(playerAction);
                }

            break;

            case GOAL:

                System.out.println("YOU WIN!!!!!!!");
                return true;

            default:
                break;
        }

        return false;
       
    }

    public void giveMeSpace(){

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }

    public void playerChoice(Room room){

        

        if(room.getNorthRoom() != null){
            System.out.println("Press w to go to " + room.getNorthRoom().getRoomName() );
        }
        if(room.getSouthRoom() != null){
            System.out.println("Press s to go to " + room.getSouthRoom().getRoomName() );
        }
        if(room.getWestRoom() != null){
            System.out.println("Press a to go to " + room.getWestRoom().getRoomName() );
        }
        if(room.getEastRoom() != null){
            System.out.println("Press d to go to " + room.getEastRoom().getRoomName() );
        }

        if(doesPlayerHaveKey("Key")){
            System.out.println("You have 1 Key");
        }

        if(currentRoom.getItem() != "Nothing"){
            System.out.println("Press p to pick up Key");
        }
        
        System.out.println("Quit Game? press q");
        
    }
    public void move(String direction){

        switch (direction) {
            case "w":
                    if(currentRoom.getNorthRoom() != null){
                        currentRoom = currentRoom.getNorthRoom();
                    }
                break;
            
            case "s":
                    if(currentRoom.getSouthRoom() != null){
                        currentRoom = currentRoom.getSouthRoom();
                    }
                 break;
                 
            case "a":
                if(currentRoom.getWestRoom() != null){
                    currentRoom = currentRoom.getWestRoom();
                }
                break;

            case "d":
                if(currentRoom.getEastRoom() != null){
                    currentRoom = currentRoom.getEastRoom();
                }
                break;
        
            default:
                break;
        }
    }

    public boolean doesPlayerHaveKey(String key){

        if(player.doesPlayerHaveKey("Key")){
            return true;
        }

        return false;

    }

    public void didPlayerWin(){

        if(doesPlayerHaveKey("Key") && currentRoom.getRoomName().equals("Goal")){
            gs = gs.GOAL;
            
        }
       
    }

    public void pickUpKey(){
        player.placeKeyInInventory("Key");
        currentRoom.setItem("Nothing");
    }

    public void Introduction(){

        System.out.println("Welcome to the duengeon");
        System.out.println("In order to complete the following quest you must find the key and open the door to reach freedom.");
        System.out.println("Use the w, a, s, d, to move North, South, West, or East to visit the other rooms in search for the key");
    }

    public void howToMove(){
        System.out.println("Use the w, a, s, d, to move North, South, West, or East");
    }

    public void createRooms()
    {
        Room room1 = new Room();
        Room room2 = new Room();
        Room room3 = new Room();
        Room room4 = new Room();
        Room room5 = new Room();
        Room room6 = new Room();
        Room room7 = new Room();
        Room room8 = new Room();
        Room room9 = new Room();
        Room room10 = new Room();
        Room room11 = new Room();
        Room room12 = new Room();
        Room room13 = new Room();
        Room room14 = new Room();
        Room goalRoom = new Room();

        room1.createRoom("Room 1","Nothing", null, room2, null, null);
        room2.createRoom("Room 2","Nothing", room1, room3, null, null);
        room3.createRoom("Room 3","Nothing", room2, room9, room5, room4);
        room4.createRoom("Room 4","Nothing", null, null, room3, null);
        room5.createRoom("Room 5","Nothing", null, null, room6, room3);
        room6.createRoom("Room 6","Nothing", null, room7, null, room5);
        room7.createRoom("Room 7","Nothing", room6, room8, null, null);
        room8.createRoom("Room 8","Key", room7, null, null, null);
        room9.createRoom("Room 9","Nothing", room3, room10, null, null);
        room10.createRoom("Room 10","Nothing", room9, room11, null, null);
        room11.createRoom("Room 11","Nothing", room10, null, null, room12);
        room12.createRoom("Room 12","Nothing", null, null, room11, room13);
        room13.createRoom("Room 13","Nothing", null, null, room12, room14);
        room14.createRoom("Room 14","Nothing", null, null, room14, goalRoom);
        goalRoom.createRoom("Goal","Nothing", null, null, null, null);

        currentRoom = room1;
        
        
    }
}