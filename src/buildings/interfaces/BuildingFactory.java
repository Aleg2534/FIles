package buildings.interfaces;

public interface BuildingFactory {
    Space createSpace(double square);
    Space createSpace(double square, int numberRooms);
    Floor createFloor(int numberSpaces);
    Floor createFloor(Space[] spaces);
    Building createBuilding(int numberOfFloors, int... numbersOfSpaces);
    Building createBuilding(Floor[] floors);
}
