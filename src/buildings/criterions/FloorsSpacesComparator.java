package buildings.criterions;

import buildings.interfaces.Floor;

import java.util.Comparator;

public class FloorsSpacesComparator implements Comparator<Floor> {

    @Override
    public int compare(Floor o1, Floor o2) {
        return o2.getNumberOfSpaces()-o1.getNumberOfSpaces();
    }
}
