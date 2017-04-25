package _04_24;


import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Room
{
    int sm;

    Room( int sm )
    {
        this.sm = sm;
    }
}


class RoomComparator implements Comparator<Room>
{
    @Override public int compare( Room room1, Room room2 )
    {
        return room1.sm - room2.sm;
    }
}

class TestWhatEver {

    public static void main(String[] args) {
        List<Room> list = Arrays.asList(new Room(123), new Room(1123), new Room(100));
        Collections.sort( list, new RoomComparator() );
        System.out.println( list.get(0).sm );
    }

}