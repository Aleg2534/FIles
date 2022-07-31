import buildings.Buildings;
import buildings.criterions.FloorsSpacesComparator;
import buildings.dwelling.Dwelling;
import buildings.dwelling.hotel.Hotel;
import buildings.interfaces.Building;
import buildings.interfaces.Floor;
import buildings.office.Office;
import buildings.office.OfficeBuilding;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try (FileWriter fileWriter= new FileWriter(
                "C:\\Users\\Home\\IdeaProjects\\test1\\src\\buildings\\net\\data\\initialInformation.txt");
             FileReader fileReader = new FileReader("C:\\Users\\Home\\IdeaProjects\\test1\\src\\buildings\\net\\data\\initialInformation.txt")){
            Buildings.writeBuilding(new Dwelling(3,3,4,5),fileWriter);
            Buildings.writeBuilding(new OfficeBuilding(3,3,4,5),fileWriter);
            Buildings.writeBuilding(new Hotel(3,3,4,5),fileWriter);
            System.out.println(Buildings.readBuilding(fileReader).toString());
        }
    }
}
