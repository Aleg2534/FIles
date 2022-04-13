package buildings.interfaces;

public interface Floor {
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
