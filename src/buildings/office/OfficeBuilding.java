package buildings.office;

import buildings.office.oneList.OneList;
import buildings.office.twolist.TwoList;

public class OfficeBuilding {
    TwoList listOfficeFloors;

    public OfficeBuilding(TwoList listOfficeFloors) {
        this.listOfficeFloors = listOfficeFloors;
    }

    public  OfficeBuilding(int numberOfficeFloors, int... numbersOffices)
    {
        listOfficeFloors= new TwoList(new OfficeFloor(numbersOffices[0]));
        for(int i=1;i<numberOfficeFloors;i++)
        {
            listOfficeFloors.addOfficeFloor(new OfficeFloor(numbersOffices[i]));
        }
    }

    public TwoList getListOfficeFloors() {
        return listOfficeFloors;
    }

    public void setListOfficeFloors(TwoList listOfficeFloors) {
        this.listOfficeFloors = listOfficeFloors;
    }

    public double getOfficeBuildingSquare()
    {
        TwoList node = listOfficeFloors.getNextOfficeFloor();
        double square=node.getOfficeFloor().getOfficeFloorSquare();
        while(node!=listOfficeFloors)
        {
            square+=node.getOfficeFloor().getOfficeFloorSquare();
            node=node.getNextOfficeFloor();
        }
        return square;
    }

    public int getOfficeBuildingNumberOffice()
    {
        TwoList node = listOfficeFloors.getNextOfficeFloor();
        int number=node.getOfficeFloor().getNumberOffices();
        while(node!=listOfficeFloors)
        {
            number+=node.getOfficeFloor().getNumberOffices();
            node=node.getNextOfficeFloor();
        }
        return number;
    }

    public int getOfficeBuildingNumberOfficeFloors()
    {
        TwoList node = listOfficeFloors.getNextOfficeFloor();
        int number=1;
        while(node!=listOfficeFloors)
        {
            number++;
            node=node.getNextOfficeFloor();
        }
    }

    public int GetOfficeBuildingNumberRooms()
    {
        TwoList node = listOfficeFloors.getNextOfficeFloor();
        int number=node.getOfficeFloor().getOfficeFloorNumberRooms();
        while(node!=listOfficeFloors)
        {
            number+=node.getOfficeFloor().getOfficeFloorNumberRooms();
            node=node.getNextOfficeFloor();
        }
        return number;
    }

    public Office getBestSpace()
    {
        TwoList node=listOfficeFloors.getNextOfficeFloor();
        Office bestSpace=listOfficeFloors.getOfficeFloor().getBestSpace();
        while (node!=listOfficeFloors)
        {
            if(bestSpace.getSquare()<node.getOfficeFloor().getBestSpace().getSquare())
            {
                bestSpace=node.getOfficeFloor().getBestSpace();
            }
        }
        return bestSpace;
    }

    public Office[] getListOffices()
    {
        int i=0;
        Office[] arrayOffices=new Office[getOfficeBuildingNumberOffice()];
        TwoList node=listOfficeFloors.getNextOfficeFloor();
        for(i=i;i<listOfficeFloors.getOfficeFloor().getNumberOffices();i++)
        {
            arrayOffices[i]=listOfficeFloors.getOfficeFloor().getOffice(i);
        }
        while (node!=listOfficeFloors)
        {
            for(int j=0;j<node.getOfficeFloor().getNumberOffices();j++)
            {
                arrayOffices[i]=listOfficeFloors.getOfficeFloor().getOffice(j);
                i++;
            }
            node=node.getNextOfficeFloor();
        }
        return arrayOffices;
    }
}
