package buildings;

import buildings.interfaces.Building;
import buildings.interfaces.Floor;
import buildings.interfaces.Space;
import exceptions.FloorIndexOutOfBoundsException;
import exceptions.InexchangeableFloorsException;
import exceptions.InexchangeableSpacesException;
import exceptions.SpaceIndexOutOfBoundsException;

public class PlacementExchanger {
    public static boolean checkExchangebleSpases(Space obj1, Space obj2) {
        return (obj1.getSquare() == obj2.getSquare() && obj1.getNumberRooms() == obj2.getNumberRooms());
    }

    public static boolean checkExchangebleFloors(Floor obj1, Floor obj2) {
        return (obj1.getSquare() == obj2.getSquare() && obj1.getNumberRooms() == obj2.getNumberRooms());
    }

    public static void exchangeFloorSpaces(Floor floor1, int index1, Floor floor2, int index2)
            throws SpaceIndexOutOfBoundsException, InexchangeableSpacesException {
        if (index1 >= floor1.getNumberOfSpaces() || index1 < 0 )
        {
            throw new SpaceIndexOutOfBoundsException(floor1.getNumberOfSpaces(),index1);
        }
        if (index2 >= floor1.getNumberOfSpaces() || index2 < 0 )
        {
            throw new SpaceIndexOutOfBoundsException(floor2.getNumberOfSpaces(),index2);
        }
        if (!checkExchangebleSpases(floor1.getSpace(index1), floor2.getSpace(index2)))
        {
            throw new InexchangeableSpacesException();
        }
        Space space = floor1.getSpace(index1);
        floor1.setSpace(index1,floor2.getSpace(index2));
        floor2.setSpace(index2,space);
    }

    public static void exchangeBuildingFloors(Building building1, int index1, Building building2, int index2)
            throws FloorIndexOutOfBoundsException, InexchangeableFloorsException
    {
        if (index1 >= building1.getNumberFloors() || index1 < 0 )
        {
            throw new FloorIndexOutOfBoundsException(building1.getNumberFloors(),index1);
        }
        if (index2 >= building2.getNumberFloors() || index2 < 0 )
        {
            throw new FloorIndexOutOfBoundsException(building2.getNumberFloors(),index2);
        }
        if(!checkExchangebleFloors(building1.getFloor(index1),building2.getFloor(index2)))
        {
            throw new InexchangeableFloorsException();
        }
        Floor floor= building1.getFloor(index1);
        building1.setFloor(index1,building2.getFloor(index2));
        building2.setFloor(index2,floor);
    }

}
