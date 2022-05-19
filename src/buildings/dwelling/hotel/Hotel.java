package buildings.dwelling.hotel;

import buildings.dwelling.Dwelling;
import buildings.dwelling.DwellingFloor;
import buildings.dwelling.Flat;
import buildings.interfaces.Floor;
import buildings.interfaces.Space;
import exceptions.FloorIndexOutOfBoundsException;
import exceptions.InvalidRoomsCountExceptions;

public class Hotel extends Dwelling {
    private int stars;

    public Hotel(int numberOfFloors, int... numbersOfFlats) throws ArrayIndexOutOfBoundsException, InvalidRoomsCountExceptions {
        super(numberOfFloors, numbersOfFlats);
        for(int i=0;i<numberOfFloors;i++)
        {
            setFloor(i,new HotelFloor(getFloor(i).getFloor()));
        }
        stars=HotelFloor.STARS;
    }

    public Hotel(int numberOfFloors) throws FloorIndexOutOfBoundsException {
        super(numberOfFloors);
        for(int i=0;i<numberOfFloors;i++)
        {
            setFloor(i,new HotelFloor(getFloor(i).getFloor()));
        }
        stars=HotelFloor.STARS;
    }

    public Hotel(Floor... dwellingFloors) {

        super(dwellingFloors);
        upStars();
    }

    public int getStars() {
        upStars();
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    private void upStars()
    {
        int maxNumberStars=0;
        for(int i=0;i<getNumberFloors();i++)
        {
            if(getFloor(i) instanceof HotelFloor)
            {
                maxNumberStars=Math.max(maxNumberStars,((HotelFloor) getFloor(i)).getStars());
            }
        }
        stars=maxNumberStars;
    }

    private double K(int stars)
    {
        if(stars==1) return 0.25;
        if(stars==2) return 0.5;
        if(stars==3) return 1;
        if(stars==4) return 1.25;
        return 1.5;
    }

    @Override
    public Space getBestSpace()
    {
        Space bestSpace = getFloor(0).getBestSpace();
        int numberFloorWithBestSpace=0;
        for (int i = 1;i<getNumberFloors();i++)
        {
            if(getFloor(i).getBestSpace().getSquare()*K(((HotelFloor)getFloor(i)).getStars())>bestSpace.getSquare()
                    *K(((HotelFloor) getFloor(numberFloorWithBestSpace)).getStars()))
            {
                bestSpace=getFloor(i).getBestSpace();
                numberFloorWithBestSpace=i;
            }
        }
        return bestSpace;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("Hotel( Stars:"+stars+", ");
        for (Floor i : getFloors()) {
            str.append(i.toString());
        }
        str.append(")");
        return str.toString();
    }


}
