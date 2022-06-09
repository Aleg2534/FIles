import buildings.Buildings;
import buildings.criterions.FloorsSpacesComparator;
import buildings.dwelling.Dwelling;
import buildings.interfaces.Building;
import buildings.interfaces.Floor;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Building building = new Dwelling(4, 4, 5, 6,4);
            Buildings.sortArraysByComparator(building.getFloors(),new FloorsSpacesComparator());
            List<Integer> list = new ArrayList<>();
            list.stream().sorted((o1, o2) -> o2-o1);
    }
}
