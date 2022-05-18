package buildings.interfaces;

import buildings.dwelling.DwellingFloor;

public interface Floor extends  Iterable<Space>, Comparable<Floor>{
    int getNumberOfSpaces();
    Space[] getFloor();
    double getSquare();
    int getNumberRooms();
    Space getSpace(int number);
    void setSpace(int number, Space newSpace);
    void addSpace(int number, Space newSpace);
    void deleteSpace(int number);
    Space getBestSpace();
}
