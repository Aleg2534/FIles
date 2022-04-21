package buildings.office.oneList;

import buildings.interfaces.Space;
import buildings.office.Office;
public class OneList {
    private Space space;
    private OneList nextOffice;

    public OneList(Space office) {
        this.space = office;
        nextOffice=this;
    }

    public OneList(Space office, OneList nextOffice) {
        this.space = office;
        this.nextOffice = nextOffice;
    }

    public Space getSpace() {
        return space;
    }

    public void setSpace(Space space) {
        this.space = space;
    }

    public OneList getNextOffice() {
        return nextOffice;
    }

    public void setNextOffice(OneList nextOffice) {
        this.nextOffice = nextOffice;
    }

    public void addSpace(Space office)
    {
        nextOffice=new OneList(office,nextOffice);
    }

    public void deleteNextSpace(){nextOffice=nextOffice.nextOffice;}
}


