package buildings.office.twolist;

import buildings.office.OfficeFloor;

public class TwoList {
    private OfficeFloor officeFloor;
    private TwoList nextOfficeFloor;
    private TwoList backOfficeFloor;

    public TwoList(OfficeFloor officeFloor) {
        this.officeFloor = officeFloor;
        nextOfficeFloor=this;
        backOfficeFloor=this;
    }

    public TwoList(OfficeFloor officeFloor, TwoList nextOfficeFloor, TwoList backOfficeFloor) {
        this.officeFloor = officeFloor;
        this.nextOfficeFloor = nextOfficeFloor;
        this.backOfficeFloor = backOfficeFloor;
    }

    public OfficeFloor getOfficeFloor() {
        return officeFloor;
    }

    public void setOfficeFloor(OfficeFloor officeFloor) {
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

    public void addOfficeFloor(OfficeFloor officeFloor)
    {
        TwoList newNode= new TwoList(officeFloor, nextOfficeFloor, this);
        newNode.nextOfficeFloor.backOfficeFloor=newNode;
        nextOfficeFloor=newNode;
    }

}