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

    public int getOfficeFloorNumberRooms()
    {
        OneList node = listOffices.getNextOffice();
        int number=node.getOffice().getNumberRooms();
        while(node!=listOffices)
        {
            number+=node.getOffice().getNumberRooms();
            node=node.getNextOffice();
        }
        return number;
    }

    public Office getOffice(int numberOffice)
    {
        if(numberOffice>getNumberOffices())
        {
            return null;
        }
        OneList node = listOffices;
        for(int i=0;i<numberOffice;i++){
            node=node.getNextOffice();
        }
        return node.getOffice();
    }

    public Office[] getArrayOffices()
    {
        Office[] arrayOffices=new Office[getNumberOffices()];
        OneList node = listOffices.getNextOffice();
        arrayOffices[0]=listOffices.getOffice();
        int i=1;
        while (node!=listOffices)
        {
            arrayOffices[i]=node.getOffice();
            node=node.getNextOffice();
            i++;
        }
        return arrayOffices;
    }

    public int getNumberOffices()
    {
        OneList node = listOffices.getNextOffice();
        int numberOffices=1;
        while(node!=listOffices)
        {
            numberOffices++;
            node=node.getNextOffice();
        }
        return numberOffices;
    }

    public Office getBestSpace()
    {
        OneList node =listOffices.getNextOffice();
        Office bestSpace=listOffices.getOffice();
        while(node!=listOffices)
        {
            if(bestSpace.getSquare()<node.getOffice().getSquare())
            {
                bestSpace=node.getOffice();
            }
            node=node.getNextOffice();
        }
        return bestSpace;
    }

}
