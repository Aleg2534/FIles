package buildings.office.twolist;

import buildings.interfaces.Floor;
import buildings.office.Office;
import buildings.office.OfficeFloor;

public class TwoList {
    private Floor officeFloor;
    private TwoList nextOfficeFloor;
    private TwoList backOfficeFloor;

    public TwoList(Floor officeFloor) {
        this.officeFloor = officeFloor;
        nextOfficeFloor=this;
        backOfficeFloor=this;
    }

    public TwoList(Floor officeFloor, TwoList nextOfficeFloor, TwoList backOfficeFloor) {
        this.officeFloor = officeFloor;
        this.nextOfficeFloor = nextOfficeFloor;
        this.backOfficeFloor = backOfficeFloor;
    }

    public Floor getOfficeFloor() {
        return officeFloor;
    }

    public void setOfficeFloor(Floor officeFloor) {
        this.officeFloor = officeFloor;
    }

    public TwoList getNextOfficeFloor() {
        return nextOfficeFloor;
    }

    public void setNextOfficeFloor(TwoList nextOfficeFloor) {
        this.nextOfficeFloor = nextOfficeFloor;
    }

    public TwoList getBackOfficeFloor() {
        return backOfficeFloor;
    }

    public void setBackOfficeFloor(TwoList backOfficeFloor) {
        this.backOfficeFloor = backOfficeFloor;
    }

    public void addOfficeFloor(Floor officeFloor)
    {
        TwoList newNode= new TwoList(officeFloor, nextOfficeFloor, this);
        newNode.nextOfficeFloor.backOfficeFloor=newNode;
        nextOfficeFloor=newNode;
    }

}