package buildings.criterions;

import buildings.interfaces.Space;

import java.util.Comparator;

public class SpacesSquareComparator implements Comparator<Space> {
    @Override
    public int compare(Space o1, Space o2) {
        return (int) (o2.getSquare()-o1.getSquare());
    }
}
