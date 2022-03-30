package buildings.office.oneList;

import buildings.office.Office;

public class OneList {
    private Office office;
    private OneList nextOffice;

    public OneList(Office office) {
        this.office = office;
        nextOffice=this;
    }

    public OneList(Office office, OneList nextOffice) {
        this.office = office;
        this.nextOffice = nextOffice;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public OneList getNextOffice() {
        return nextOffice;
    }

    public void setNextOffice(OneList nextOffice) {
        this.nextOffice = nextOffice;
    }

    public void addOffice(Office office)
    {
        nextOffice=new OneList(office,nextOffice);
    }
}


