package buildings.factories;

import buildings.dwelling.Flat;
import buildings.dwelling.hotel.Hotel;
import buildings.dwelling.hotel.HotelFloor;
import buildings.interfaces.Building;
import buildings.interfaces.BuildingFactory;
import buildings.interfaces.Floor;
import buildings.interfaces.Space;
import buildings.office.OfficeFloor;

public class HotelFactory implements BuildingFactory {
    @Override
    public Space createSpace(double square) {
        return new Flat(square);
    }

    @Override
    public Space createSpace(double square, int numberRooms) {
        return new Flat(square,numberRooms);
    }

    @Override
    public Floor createFloor(int numberSpaces) {
        return new HotelFloor(numberSpaces);
    }

    @Override
    public Floor createFloor(Space[] spaces) {
        return new HotelFloor(spaces);
    }

    @Override
    public Building createBuilding(int numberOfFloors, int... numbersOfSpaces) {
        return new Hotel(numberOfFloors,numbersOfSpaces);
    }

    @Override
    public Building createBuilding(Floor[] floors) {
        return new Hotel(floors);
    }
}
