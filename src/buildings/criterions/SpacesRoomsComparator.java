package buildings.criterions;

import buildings.interfaces.Space;

import java.util.Comparator;

public class SpacesRoomsComparator implements Comparator<Space> {

    @Override
    public int compare(Space o1, Space o2) {
        return o2.getNumberRooms() - o1.getNumberRooms();
    }
}
