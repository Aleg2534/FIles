import buildings.dwelling.Dwelling;
import buildings.office.Office;
import buildings.office.OfficeFloor;
import exceptions.SpaceIndexOutOfBoundsException;

public class Main {
    public static void main(String[] args) {
        try {
            Dwelling dwelling = new Dwelling(4, 10, 10);
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            e.printStackTrace();
        }
        System.out.println(222);
    }
}
