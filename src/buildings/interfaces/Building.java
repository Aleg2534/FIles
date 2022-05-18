package buildings.interfaces;

import buildings.dwelling.Dwelling;

public interface Building extends Iterable<Floor>, Comparable<Building> {
    int getBuildingSize();
    int getNumberRooms();
    int getNumberFloors();
    double getSquare();
    Space[] getSpaces();
    int getNumberSpaces();
    Floor[] getFloors();
    Floor getFloor(int number);
    Space getSpace(int number);
    void setFloor(int number, Floor floor);
    void setSpace(int number, Space space);
    void addSpace(int number, Space space);
    void deleteSpace(int number);
    Space getBestSpace();
    Space[] getSpacesSortedBySquare();
}
