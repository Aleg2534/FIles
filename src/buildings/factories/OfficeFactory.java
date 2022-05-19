package buildings.factories;

import buildings.interfaces.Building;
import buildings.interfaces.BuildingFactory;
import buildings.interfaces.Floor;
import buildings.interfaces.Space;
import buildings.office.Office;
import buildings.office.OfficeBuilding;
import buildings.office.OfficeFloor;

public class OfficeFactory implements BuildingFactory {
    @Override
    public Space createSpace(double square) {
        return new Office(square);
    }

    @Override
    public Space createSpace(double square, int numberRooms) {
        return new Office(square,numberRooms);
    }

    @Override
    public Floor createFloor(int numberSpaces) {
        return new OfficeFloor(numberSpaces);
    }

    @Override
    public Floor createFloor(Space[] spaces) {
        return new OfficeFloor(spaces);
    }

    @Override
    public Building createBuilding(int numberOfFloors, int... numbersOfSpaces) {
        return new OfficeBuilding(numberOfFloors,numbersOfSpaces);
    }

    @Override
    public Building createBuilding(Floor[] floors) {
        return new OfficeBuilding(floors);
    }
}
