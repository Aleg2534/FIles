package buildings.dwelling;

import exceptions.FloorIndexOutOfBoundsException;
import exceptions.SpaceIndexOutOfBoundsException;

public class Dwelling {
    private DwellingFloor[] dwellingFloors;

    public Dwelling(int numberOfFloors, int... numbersOfFlats) throws ArrayIndexOutOfBoundsException{
        if(numbersOfFlats.length<numberOfFloors)
        {
            throw new ArrayIndexOutOfBoundsException();
        }
        dwellingFloors= new DwellingFloor[numberOfFloors];
        for(int i = 0; i<numberOfFloors;i++)
        {
            dwellingFloors[i]=new DwellingFloor(numbersOfFlats[i]);
        }
    }

    public Dwelling(DwellingFloor... dwellingFloors) {
        this.dwellingFloors = dwellingFloors;
    }

    public int getNumbersOfSpaces()
    {
        int i=0;
        for(DwellingFloor dwellingFloor: dwellingFloors)
        {
            i+=dwellingFloor.getNumberSpaces();
        }
        return i;
    }

    public int getNumbersOfRooms()
    {
        int i=0;
        for(DwellingFloor dwellingFloor: dwellingFloors)
        {
            i+=dwellingFloor.getNumberRoomsOnFloor();
        }
        return i;
    }

    public double getSquare()
    {
        double i=0;
        for(DwellingFloor dwellingFloor: dwellingFloors)
        {
            i+=dwellingFloor.getFloorSquare();
        }
        return i;
    }

    public Flat getBestSpace()
    {
        Flat bestSpase=dwellingFloors[0].getBestSpace();
        for(DwellingFloor dwellingFloor: dwellingFloors)
        {
            if(bestSpase.getSquare()<dwellingFloor.getBestSpace().getSquare())
            {
                bestSpase=dwellingFloor.getBestSpace();
            }
        }
        return bestSpase;
    }

    public DwellingFloor[] getFloors() {
        return dwellingFloors;
    }

    public DwellingFloor getFloor(int numberOfFloor) throws FloorIndexOutOfBoundsException
    {
        if((numberOfFloor<0)||(numberOfFloor>dwellingFloors.length))
        {
            throw new FloorIndexOutOfBoundsException(dwellingFloors.length,numberOfFloor);
        }
        return dwellingFloors[numberOfFloor];
    }

    public void changeFloor(int numberOfFloor, DwellingFloor floor)
    {
        dwellingFloors[numberOfFloor]=floor;
    }

    public Flat getSpacesByNumber(int numberOfFlat) throws SpaceIndexOutOfBoundsException
    {
        if((numberOfFlat<0)||(numberOfFlat>=getNumbersOfSpaces()))
        {
            throw new SpaceIndexOutOfBoundsException(getNumbersOfSpaces(), numberOfFlat);
        }
        for(DwellingFloor dwellingFloor : dwellingFloors)
        {
            if(numberOfFlat>dwellingFloor.getNumberSpaces())
            {
                numberOfFlat-=dwellingFloor.getNumberSpaces();
            }
            else
            {
                return dwellingFloor.getFlatByNumber(numberOfFlat);
            }
        }
        return null;
    }

    public void setSpacesByNumber(int numberOfFlat, Flat newFlat) throws SpaceIndexOutOfBoundsException
    {
        if((numberOfFlat<0)||(numberOfFlat>=getNumbersOfSpaces()))
        {
            throw new SpaceIndexOutOfBoundsException(getNumbersOfSpaces(), numberOfFlat);
        }
        for(DwellingFloor dwellingFloor : dwellingFloors)
        {
            if(numberOfFlat>dwellingFloor.getNumberSpaces())
            {
                numberOfFlat-=dwellingFloor.getNumberSpaces();
            }
            else
            {
                dwellingFloor.changeFlat(numberOfFlat,newFlat);
            }
        }
    }

    public void removeSpacesByNumber(int numberOfFlat) throws SpaceIndexOutOfBoundsException
    {
        if((numberOfFlat<0)||(numberOfFlat>=getNumbersOfSpaces()))
        {
            throw new SpaceIndexOutOfBoundsException(getNumbersOfSpaces(), numberOfFlat);
        }
        for(DwellingFloor dwellingFloor : dwellingFloors)
        {
            if(numberOfFlat>dwellingFloor.getNumberSpaces())
            {
                numberOfFlat-=dwellingFloor.getNumberSpaces();
            }
            else
            {
                dwellingFloor.removeFlat(numberOfFlat);
            }
        }
    }

    public void addSpacesByNumber(int numberOfFlat, Flat newFlat) throws SpaceIndexOutOfBoundsException
    {
        if((numberOfFlat<0)||(numberOfFlat>getNumbersOfSpaces()))
        {
            throw new SpaceIndexOutOfBoundsException(getNumbersOfSpaces(), numberOfFlat);
        }
        for(DwellingFloor dwellingFloor : dwellingFloors)
        {
            if(numberOfFlat>dwellingFloor.getNumberSpaces())
            {
                numberOfFlat-=dwellingFloor.getNumberSpaces();
            }
            else
            {
                dwellingFloor.addingFlat(numberOfFlat, newFlat);
            }
        }
    }

    private void bubblesortFLatBySquare(Flat[] flats)
    {
        for(int i=0;i<flats.length;i++)
        {
            for(int j=0;j<flats.length-1-i;j++)
            {
                if(flats[j].getSquare()>flats[j+1].getSquare())
                {
                    Flat flat=flats[j];
                    flats[j]=flats[j+1];
                    flats[j+1]=flat;
                }
            }
        }
    }

    public Flat[] getSpacesSortedBySquare()
    {
        Flat[] flats = new Flat[getNumbersOfSpaces()];
        for(int i=0;i<getNumbersOfSpaces();i++)
        {
            flats[i]= getSpacesByNumber(i);
        }
        bubblesortFLatBySquare(flats);
        return flats;
    }
}