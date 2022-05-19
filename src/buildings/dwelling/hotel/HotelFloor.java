package buildings.dwelling.hotel;

import buildings.dwelling.DwellingFloor;
import buildings.interfaces.Space;

public class HotelFloor extends DwellingFloor {
    private int stars;

    public static final int STARS = 1;
    public HotelFloor(int numberFlats) {
        super(numberFlats);
        stars=STARS;
    }

    public HotelFloor(Space[] flats) {
        super(flats);
        stars=STARS;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    @Override
    public String toString()
    {
        StringBuilder str= new StringBuilder("HotelFloor( Stars:"+stars+", ");
        for(Space i:getFloor())
        {
            str.append(i.toString()+", ");
        }
        str.append(")");
        return str.toString();
    }

    @Override
    public boolean equals(Object floor)
    {
        if(!(floor instanceof HotelFloor))
        {
            return false;
        }
        if(stars!=((HotelFloor)floor).getStars())
        {
            return false;
        }
        if(getNumberOfSpaces()!=((DwellingFloor) floor).getNumberOfSpaces())
        {
            return false;
        }
        for(int i = 0; i<getNumberOfSpaces();i++)
        {
            if(!(getFloor()[i].equals(((DwellingFloor) floor).getSpace(i))))
            {
                return false;
            }
        }
        return true;
    }
}
