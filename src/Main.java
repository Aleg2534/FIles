import buildings.Buildings;
import buildings.criterions.FloorsSpacesComparator;
import buildings.dwelling.Dwelling;
import buildings.dwelling.DwellingFloor;
import buildings.dwelling.hotel.Hotel;
import buildings.interfaces.Building;
import buildings.interfaces.Floor;
import buildings.interfaces.Space;
import buildings.office.Office;
import buildings.office.OfficeBuilding;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
            DwellingFloor dwellingFloor= new DwellingFloor(5);
            dwellingFloor.getSpace(3).setSquare(235);
            Buildings.sortedSpacesByCriterion(dwellingFloor.getFloor(),(Space space1, Space space2)->{
                return (int) (space1.getSquare()-space2.getSquare());
            });
            System.out.println(dwellingFloor.toString());
    }
}
