package threads;

import buildings.interfaces.Floor;

public class Cleaner extends Thread{
    private Floor floor;
    public Cleaner(Floor floor)
    {
        this.floor=floor;
    }
    @Override
    public void run() {
        for(int i=0;i<floor.getNumberOfSpaces();i++)
        {
            System.out.println("cleaning space " + i + " with total area " + floor.getSpace(i).getSquare());
        }
        System.out.println("end of Cleaner");
    }
}
