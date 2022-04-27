package buildings.dwelling;

import buildings.interfaces.Floor;
import buildings.interfaces.Space;
import exceptions.SpaceIndexOutOfBoundsException;

import java.io.Serializable;

public class DwellingFloor implements Floor, Serializable {
    private Space[] flats;

    public DwellingFloor(int numberFlats) {
        flats = new Flat[numberFlats];
        for(int i = 0; i<numberFlats;i++)
        {
            flats[i]=new Flat();
        }
    }

    public DwellingFloor(Space[] flats) {
        this.flats = flats;
    }

    @Override
    public int getNumberOfSpaces() {
        return flats.length;
    }

    @Override
    public Space[] getFloor() {
        return flats;
    }

    @Override
    public double getSquare() {
        double sumSquare = 0;
        for (Space flat : flats) {
            sumSquare += flat.getSquare();
        }
        return sumSquare;
    }

    @Override
    public int getNumberRooms() {
        int numberFlats=0;
        for(Space flat: flats)
        {
            numberFlats += flat.getNumberRooms();
        }
        return numberFlats;
    }

    @Override
    public Space getSpace(int number) throws SpaceIndexOutOfBoundsException {
        if((number<0)||(number>=flats.length))
        {
            throw new SpaceIndexOutOfBoundsException(flats.length, number);
        }
        return flats[number];
    }

    @Override
    public void setSpace(int number, Space newSpace) throws SpaceIndexOutOfBoundsException{
        if((number<0)||(number>=flats.length))
        {
            throw new SpaceIndexOutOfBoundsException(flats.length, number);
        }
        if(number<flats.length) {
            flats[number] = newSpace;
        }
    }

    @Override
    public void addSpace(int number, Space newSpace) {
        if((number<0)||(number>flats.length))
        {
            throw new SpaceIndexOutOfBoundsException(flats.length, number);
        }
        else {
            int i;
            Space[] flatsNew = new Flat[flats.length + 1];
            for (i = 0; i < number; i++) {
                flatsNew[i] = flats[i];
            }
            flatsNew[i] = newSpace;
            if(number<flats.length)
            {
                i++;
                for (i = i; i < flatsNew.length + 1; i++) {
                    flatsNew[i] = flats[i - 1];
                }
            }
            flats=flatsNew;
        }
    }

    @Override
    public void deleteSpace(int number) {
        if((number<0)||(number>=flats.length))
        {
            throw new SpaceIndexOutOfBoundsException(flats.length, number);
        }
        else{
            int i;
           Space[] flatsNew = new Flat[flats.length - 1];
            for (i = 0; i < flats.length; i++) {
                if(number>i) {
                    flatsNew[i] = flats[i];
                }
                else if(number<i)
                {
                    flatsNew[i-1]=flats[i];
                }
            }
            flats=flatsNew;
        }
    }

    public Space getBestSpace()
    {
        int numberBestFlat=0;
        for(int i = 1; i<flats.length;i++) {
            if(flats[i].getSquare()>flats[numberBestFlat].getSquare()){
                numberBestFlat=i;
            }
        }
        return flats[numberBestFlat];
    }

}
