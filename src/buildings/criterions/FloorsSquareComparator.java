package buildings.criterions;

import buildings.interfaces.Floor;

import java.util.Comparator;

public class FloorsSquareComparator implements Comparator<Floor> {
    @Override
    public int compare(Floor o1, Floor o2) {
        return (int) (o2.getSquare()-o1.getSquare());
    }
}
