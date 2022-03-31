import buildings.dwelling.Dwelling;
import buildings.office.Office;
import buildings.office.OfficeFloor;

public class Main {
    public static void main(String[] args) {
        Dwelling dwelling = new Dwelling(4,10,10,10,5);
        OfficeFloor officeFloor= new OfficeFloor(10);
        System.out.println(officeFloor.getNumberOffices()+"\n"+officeFloor.getOfficeFloorSquare()+"\n");
        officeFloor.getListOffices().addOffice(new Office(500));
        System.out.println(officeFloor.getOfficeFloorSquare());
    }
}
