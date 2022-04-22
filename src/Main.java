import buildings.Buildings;
import buildings.dwelling.Dwelling;
import buildings.interfaces.Building;
import buildings.office.Office;
import buildings.office.OfficeFloor;
import exceptions.SpaceIndexOutOfBoundsException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Building building = Buildings.inputBuilding(
                new FileInputStream("C:\\Users\\Home\\IdeaProjects\\test1\\src\\buildings\\test.txt"));

        System.out.println(222);
    }
}
