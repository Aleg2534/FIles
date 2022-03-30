package buildings.office;

import buildings.office.oneList.OneList;

public class OfficeFloor {
    private OneList listOffices;

    public OfficeFloor(int numberOffices) {
        listOffices= new OneList(new Office());
        for(int i=1;i<numberOffices;i++)
        {
            listOffices.addOffice(new Office());
        }
    }

    public OfficeFloor(OneList listOffices) {
        this.listOffices = listOffices;
    }

    public OfficeFloor(Office[] offices) {
        listOffices = new OneList(offices[0]);
        for(int i=1;i<offices.length;i++)
        {
            listOffices.addOffice(offices[i]);
        }
    }

    public OneList getListOffices() {
        return listOffices;
    }

    public void setListOffices(OneList listOffices) {
        this.listOffices = listOffices;
    }

    public double getOfficeFloorSquare()
    {
        OneList node = listOffices.getNextOffice();
        double square=node.getOffice().getSquare();
        while(node!=listOffices)
        {
            square+=node.getNextOffice().getOffice().getSquare();
            node=node.getNextOffice();
        }
        return square;
    }

    public int getNumberOffices()
    {
        OneList node = listOffices.getNextOffice();
        int numberOffices=1;
        while(node!=listOffices)
        {
            numberOffices++;
        }
        return numberOffices;
    }
}
