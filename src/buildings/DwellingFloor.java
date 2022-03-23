package buildings;

public class DwellingFloor {
    private Flat[] flats;

    public DwellingFloor(int numberFlats) {
        flats = new Flat[numberFlats];
        for(int i = 0; i<numberFlats;i++)
        {
            flats[i]=new Flat();
        }
    }

    public DwellingFloor(Flat[] flats) {
        this.flats = flats;
    }

    public int getNumberFlats() {
        return flats.length;
    }

    public double getFloorSquare() {
        double sumSquare = 0;
        for (Flat flat : flats) {
            sumSquare += flat.getSquare();
        }
        return sumSquare;
    }

    public int getNumberRoomsOnFloor() {
        int numberFlats=0;
        for(Flat flat: flats)
        {
            numberFlats += flat.getNumberRooms();
        }
        return numberFlats;
    }

    public Flat[] getFlats() {
        return flats;
    }

    public Flat getFlatByNumber(int flatNumber) {
        return flats[flatNumber];
    }

    public void changeFlat(int flatNumber, Flat newFlat) {
        if(flatNumber<flats.length) {
            flats[flatNumber] = newFlat;
        }
    }

    public void addingFlat(int flatNumber, Flat newFlat) {
        if(flatNumber>flats.length || flatNumber<0)
        {
            System.out.println("incorrect number of flat");
        }
        else {
            int i;
            Flat[] flatsNew = new Flat[flats.length + 1];
            for (i = 0; i < flatNumber; i++) {
                flatsNew[i] = flats[i];
            }
            flatsNew[i] = newFlat;
            if(flatNumber<flats.length)
            {
                i++;
                for (i = i; i < flatsNew.length + 1; i++) {
                    flatsNew[i] = flats[i - 1];
                }
            }
            flats=flatsNew;
        }
    }
    public void removeFlat(int flatNumber)
    {
        if(flatNumber>flats.length - 1 || flatNumber<0)
        {
            System.out.println("incorrect number of flat");
        }
        else{
            int i;
            Flat[] flatsNew = new Flat[flats.length - 1];
            for (i = 0; i < flats.length; i++) {
                if(flatNumber>i) {
                    flatsNew[i] = flats[i];
                }
                else if(flatNumber<i)
                {
                    flatsNew[i-1]=flats[i];
                }
            }
            flats=flatsNew;
        }
    }

    public Flat getBestSpace()
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
