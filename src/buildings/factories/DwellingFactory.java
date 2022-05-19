package buildings.factories;

import buildings.dwelling.Dwelling;
import buildings.dwelling.DwellingFloor;
import buildings.dwelling.Flat;
import buildings.interfaces.Building;
import buildings.interfaces.BuildingFactory;
import buildings.interfaces.Floor;
import buildings.interfaces.Space;

public class DwellingFactory implements BuildingFactory {
    @Override
    public Space createSpace(double square) {
        return new Flat(square);
    }

    @Override
    public Space createSpace(double square, int numberRooms) {
        return new Flat(square, numberRooms);
    }

    @Override
    public Floor createFloor(int numberSpaces) {
        return new DwellingFloor(numberSpaces);
    }

    @Override
    public Floor createFloor(Space[] spaces) {
        return new DwellingFloor(spaces);
    }

    @Override
    public Building createBuilding(int numberOfFloors, int... numbersOfSpaces) {
        return new Dwelling(numberOfFloors, numbersOfSpaces);
    }

    @Override
    public Building createBuilding(Floor[] floors) {
        return new Dwelling(floors);
    }
}
