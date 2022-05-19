import buildings.Buildings;
import buildings.dwelling.Dwelling;
import buildings.dwelling.DwellingFloor;
import buildings.dwelling.Flat;
import buildings.dwelling.hotel.Hotel;
import buildings.dwelling.hotel.HotelFloor;
import buildings.factories.HotelFactory;
import buildings.factories.OfficeFactory;
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
        try (Writer outputStream= new FileWriter("C:\\Users\\Home\\IdeaProjects\\test1\\src\\buildings\\test.txt");
             Reader inputStream = new FileReader("C:\\Users\\Home\\IdeaProjects\\test1\\src\\buildings\\test.txt")) {
            System.out.println(228);
            Building building = new Dwelling(4, 2, 3, 4, 5);
            Buildings.writeBuilding(building, outputStream);
            Buildings.setBuildingFactory(new HotelFactory());
            System.out.println(Buildings.readBuilding(inputStream).toString());
        } finally {

        }
    }
}
