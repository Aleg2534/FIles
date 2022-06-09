package buildings;

import buildings.interfaces.Floor;
import buildings.interfaces.Space;

public class SynchronizedFloor {
    private Floor floor;

    public SynchronizedFloor(Floor floor) {
        this.floor = floor;
    }

    public synchronized int  getNumberOfSpaces()
    {
        return  floor.getNumberOfSpaces();
    }

    public synchronized Space[] getFloor()
    {
        return floor.getFloor();
    }

    public synchronized double getSquare()
    {
        return floor.getSquare();
    }

    public synchronized int getNumberRooms()
    {
        return floor.getNumberRooms();
    }

    public synchronized  Space getSpace(int number)
    {
        return floor.getSpace(number);
    }

    public synchronized void setSpace(int number, Space newSpace)
    {
        floor.setSpace(number,newSpace);
    }

    public synchronized void addSpace(int number, Space newSpace)
    {
        floor.addSpace(number,newSpace);
    }

    public synchronized void deleteSpace(int number)
    {
        floor.deleteSpace(number);
    }

    public synchronized Space getBestSpace()
    {
        return floor.getBestSpace();
    }

}
