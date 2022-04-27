import buildings.Buildings;
import buildings.dwelling.Dwelling;
import buildings.interfaces.Building;
import buildings.office.Office;
import buildings.office.OfficeFloor;
import exceptions.SpaceIndexOutOfBoundsException;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Building building = Buildings.deserializableBuilding(new FileInputStream("C:\\Users\\Home\\IdeaProjects\\test1\\src\\buildings\\test.txt"));
        System.out.println(222);
    }
}
