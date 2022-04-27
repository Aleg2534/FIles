package buildings.dwelling;

import buildings.interfaces.Building;
import buildings.interfaces.Floor;
import buildings.interfaces.Space;
import buildings.office.twolist.TwoList;
import exceptions.FloorIndexOutOfBoundsException;
import exceptions.InvalidRoomsCountExceptions;
import exceptions.SpaceIndexOutOfBoundsException;

import java.io.Serializable;

public class Dwelling implements Building, Serializable {
    private Floor[] dwellingFloors;

    public Dwelling(int numberOfFloors, int... numbersOfFlats) throws ArrayIndexOutOfBoundsException, InvalidRoomsCountExceptions {
        if(numbersOfFlats.length<numberOfFloors)
        {
            throw new ArrayIndexOutOfBoundsException();
        }
        dwellingFloors= new DwellingFloor[numberOfFloors];
        for(int i = 0; i<numberOfFloors;i++)
        {
            if((numbersOfFlats[i]>7) ||(numbersOfFlats[i]<1))
            {
                throw new InvalidRoomsCountExceptions(numbersOfFlats[i]);
            }
            dwellingFloors[i]=new DwellingFloor(numbersOfFlats[i]);
        }
    }
    public Dwelling(int numberOfFloors) throws FloorIndexOutOfBoundsException
    {
        if(numberOfFloors>100 || numberOfFloors <1 )
        {
            throw new FloorIndexOutOfBoundsException(100,numberOfFloors);
        }
        dwellingFloors = new DwellingFloor[numberOfFloors];
    }

    public Dwelling(DwellingFloor... dwellingFloors) {
        this.dwellingFloors = dwellingFloors;
    }

    @Override
    public int getNumberSpaces() {
        int i=0;
        for(Floor dwellingFloor: dwellingFloors)
        {
            i+=dwellingFloor.getNumberOfSpaces();
        }
        return i;    }

    @Override
    public int getNumberRooms() {
        int i=0;
        for(Floor dwellingFloor: dwellingFloors)
        {
            i+=dwellingFloor.getNumberRooms();
        }
        return i;
    }

    @Override
    public int getNumberFloors() {
        return dwellingFloors.length;
    }

    public double getSquare()
    {
        double i=0;
        for(Floor dwellingFloor: dwellingFloors)
        {
            i+=dwellingFloor.getSquare();
        }
        return i;
    }

    @Override
    public Space[] getSpaces() {
        Space[] flats = new Flat[getNumberSpaces()];
        for(int i = 0; i< getNumberSpaces(); i++)
        {
            flats[i]= getSpace(i);
        }
        return flats;
    }

    @Override
    public int getBuildingSize() {
        return dwellingFloors.length;
    }

    public Space getBestSpace()
    {
        Space bestSpase=dwellingFloors[0].getBestSpace();
        for(Floor dwellingFloor: dwellingFloors)
        {
            if(bestSpase.getSquare()<dwellingFloor.getBestSpace().getSquare())
            {
                bestSpase=dwellingFloor.getBestSpace();
            }
        }
        return bestSpase;
    }

    public Floor[] getFloors() {
        return dwellingFloors;
    }

    public Floor getFloor(int numberOfFloor) throws FloorIndexOutOfBoundsException
    {
        if((numberOfFloor<0)||(numberOfFloor>dwellingFloors.length))
        {
            throw new FloorIndexOutOfBoundsException(dwellingFloors.length,numberOfFloor);
        }
        return dwellingFloors[numberOfFloor];
    }



    @Override
    public void setFloor(int number, Floor floor) throws FloorIndexOutOfBoundsException{
        if(number<0||number>dwellingFloors.length)
        {
            throw new FloorIndexOutOfBoundsException(dwellingFloors.length-1,number);
        }
        dwellingFloors[number]=floor;
    }


    public void changeFloor(int numberOfFloor, DwellingFloor floor)
    {
        dwellingFloors[numberOfFloor]=floor;
    }

    @Override
    public Space getSpace(int numberOfFlat) throws SpaceIndexOutOfBoundsException
    {
        if((numberOfFlat<0)||(numberOfFlat>= getNumberSpaces()))
        {
            throw new SpaceIndexOutOfBoundsException(getNumberSpaces(), numberOfFlat);
        }
        for(Floor dwellingFloor : dwellingFloors)
        {
            if(numberOfFlat>dwellingFloor.getNumberOfSpaces())
            {
                numberOfFlat-=dwellingFloor.getNumberOfSpaces();
            }
            else
            {
                return dwellingFloor.getSpace(numberOfFlat);
            }
        }
        return null;
    }
    @Override
    public void setSpace(int numberOfFlat, Space newFlat) throws SpaceIndexOutOfBoundsException
    {
        if((numberOfFlat<0)||(numberOfFlat>= getNumberSpaces()))
        {
            throw new SpaceIndexOutOfBoundsException(getNumberSpaces(), numberOfFlat);
        }
        for(Floor dwellingFloor : dwellingFloors)
        {
            if(numberOfFlat>dwellingFloor.getNumberOfSpaces())
            {
                numberOfFlat-=dwellingFloor.getNumberOfSpaces();
            }
            else
            {
                dwellingFloor.setSpace(numberOfFlat,newFlat);
            }
        }
    }

    @Override
    public void deleteSpace(int numberOfFlat) throws SpaceIndexOutOfBoundsException
    {
        if((numberOfFlat<0)||(numberOfFlat>= getNumberSpaces()))
        {
            throw new SpaceIndexOutOfBoundsException(getNumberSpaces(), numberOfFlat);
        }
        for(Floor dwellingFloor : dwellingFloors)
        {
            if(numberOfFlat>dwellingFloor.getNumberOfSpaces())
            {
                numberOfFlat-=dwellingFloor.getNumberOfSpaces();
            }
            else
            {
                dwellingFloor.deleteSpace(numberOfFlat);
            }
        }
    }

    @Override
    public void addSpace(int numberOfFlat, Space newFlat) throws SpaceIndexOutOfBoundsException
    {
        if((numberOfFlat<0)||(numberOfFlat> getNumberSpaces()))
        {
            throw new SpaceIndexOutOfBoundsException(getNumberSpaces(), numberOfFlat);
        }
        for(Floor dwellingFloor : dwellingFloors)
        {
            if(numberOfFlat>dwellingFloor.getNumberOfSpaces())
            {
                numberOfFlat-=dwellingFloor.getNumberOfSpaces();
            }
            else
            {
                dwellingFloor.addSpace(numberOfFlat, newFlat);
            }
        }
    }

    private void bubblesortFLatBySquare(Space[] flats)
    {
        for(int i=0;i<flats.length;i++)
        {
            for(int j=0;j<flats.length-1-i;j++)
            {
                if(flats[j].getSquare()>flats[j+1].getSquare())
                {
                    Space flat=flats[j];
                    flats[j]=flats[j+1];
                    flats[j+1]=flat;
                }
            }
        }
    }

    public Space[] getSpacesSortedBySquare()
    {
        Space[] flats = new Flat[getNumberSpaces()];
        for(int i = 0; i< getNumberSpaces(); i++)
        {
            flats[i]= getSpace(i);
        }
        bubblesortFLatBySquare(flats);
        return flats;
    }
}