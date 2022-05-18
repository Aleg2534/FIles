import buildings.Buildings;
import buildings.dwelling.Dwelling;
import buildings.dwelling.DwellingFloor;
import buildings.dwelling.Flat;
import buildings.dwelling.hotel.Hotel;
import buildings.dwelling.hotel.HotelFloor;
import buildings.interfaces.Building;
import buildings.interfaces.Floor;
import buildings.interfaces.Space;
import buildings.office.Office;
import buildings.office.OfficeBuilding;
import buildings.office.OfficeFloor;
import exceptions.SpaceIndexOutOfBoundsException;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try {
            System.out.println(228);
            Building building = new Hotel(4,2,3,4,5);
            Building building2 = new Hotel(4,4,3,4,5);
            building.setFloor(2, new HotelFloor(5));
            building.setFloor(3, new HotelFloor(5));
            building.getFloor(3).getSpace(2).setSquare(350);
            ((HotelFloor)building.getFloor(3)).setStars(5);
            building.getFloor(2).getSpace(3).setSquare(500);
            Floor floor= new DwellingFloor(10);
            for(Space i:floor){
                System.out.println(i.toString());
            }
        } finally {

        }
    }
}
