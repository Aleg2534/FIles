package dwelling;

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

    public int getNumberFlats()
    {
        return flats.length;
    }

    public double getFloorSquare()
    {
        double sumSquare = 0;
        for (Flat flat : flats) {
            sumSquare += flat.getSquare();
        }
        return sumSquare;
    }

    public int getNumberRoomsOnFloor()
    {
        int numberFlats=0;
        for(Flat flat: flats)
        {
            numberFlats += flat.getNumberRooms();
        }
        return numberFlats;
    }
}
