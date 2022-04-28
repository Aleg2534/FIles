import buildings.Buildings;
import buildings.dwelling.Dwelling;
import buildings.interfaces.Building;
import buildings.office.Office;
import buildings.office.OfficeFloor;
import exceptions.SpaceIndexOutOfBoundsException;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try {
            Building building = new Dwelling(4,2,3,4,5);
            System.out.println(222);
            Buildings.writeBuildingFormat(building,
                    new FileWriter("C:\\Users\\Home\\IdeaProjects\\test1\\src\\buildings\\test.txt"));
        } finally {

        }
    }
}
