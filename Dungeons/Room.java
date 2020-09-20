public class Room{

    private String roomName;
    private String item;
    private Room north;
    private Room south;
    private Room west;
    private Room east;

    public void createRoom(String _roomName, String _itemName, Room _north, Room _south, Room _west, Room _east){

        roomName = _roomName;
        item = _itemName;
        north = _north;
        south = _south;
        west = _west;
        east = _east;
    }

    public String getRoomName(){
        return roomName;
    }

    public String getItem(){
        return item;
    }

    public void setItem(String _item){
        item = _item;
    }

    public Room getNorthRoom(){
        return north;
    }

    public Room getSouthRoom(){
        return south;
    }
    public Room getWestRoom(){
        return west;
    }
    public Room getEastRoom(){
        return east;
    }
}