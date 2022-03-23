import buildings.DwellingFloor;
import buildings.Flat;

public class Main {
    public static void main(String[] args) {
        DwellingFloor dwellingFloor= new DwellingFloor(10);
        Flat flat = new Flat(100,3);
        dwellingFloor.addingFlat(10,flat);
        Flat bestFlat = dwellingFloor.getBestSpace();
        dwellingFloor.changeFlat(5,bestFlat);
    }
}
