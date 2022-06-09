package buildings.interfaces;

public interface Space extends Comparable<Space> {
    void setSquare(double square);
    void setNumberRooms(int numberRooms);
    double getSquare();
    int getNumberRooms();
}