package buildings.office;

import buildings.interfaces.Building;
import buildings.interfaces.Floor;
import buildings.interfaces.Space;
import buildings.office.twolist.TwoList;

public class OfficeBuilding implements Building {
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

    @Override
    public double getSquare()
    {
        TwoList node = listOfficeFloors.getNextOfficeFloor();
        double square=node.getOfficeFloor().getSquare();
        while(node!=listOfficeFloors)
        {
            square+=node.getOfficeFloor().getSquare();
            node=node.getNextOfficeFloor();
        }
        return square;
    }

    @Override
    public int getBuildingSize()
    {
        TwoList node = listOfficeFloors.getNextOfficeFloor();
        int number=node.getOfficeFloor().getNumberRooms();
        while(node!=listOfficeFloors)
        {
            number+=node.getOfficeFloor().getNumberRooms();
            node=node.getNextOfficeFloor();
        }
        return number;
    }

    @Override
    public int getNumberFloors(){
        TwoList twoList = listOfficeFloors.getNextOfficeFloor();
        int i=1;
        while (twoList!=listOfficeFloors)
        {
            twoList=twoList.getNextOfficeFloor();
            i++;
        }
        return i;
    }

    @Override
    public int getNumberRooms()
    {
        TwoList node = listOfficeFloors.getNextOfficeFloor();
        int number=node.getOfficeFloor().getNumberRooms();
        while(node!=listOfficeFloors)
        {
            number+=node.getOfficeFloor().getNumberRooms();
            node=node.getNextOfficeFloor();
        }
        return number;
    }

    @Override
    public Space[] getSpaces(){
        int i =0,k=0;
        TwoList twoList = listOfficeFloors;
        Space[] Spaces= new Space[getNumberSpaces()];
        while (i<getBuildingSize())
        {
            int j = 0;
            while (j<twoList.getOfficeFloor().getNumberOfSpaces())
            {
                Spaces[k]=twoList.getOfficeFloor().getSpace(j);
                j++;
                k++;
            }
            i++;
            twoList=twoList.getNextOfficeFloor();
        }
        return Spaces;
    }

    @Override
    public int getNumberSpaces() {
        int i =0,number=0;
        TwoList twoList = listOfficeFloors;
        Space[] Spaces= new Space[getNumberSpaces()];
        while (i<getBuildingSize())
        {
            i++;
            number+=twoList.getOfficeFloor().getNumberOfSpaces();
            twoList=twoList.getNextOfficeFloor();
        }
        return number;
    }

    @Override
    public Floor[] getFloors() {
        int i = 0;
        Floor[] floors = new Floor[getNumberFloors()];
        TwoList twoList=listOfficeFloors;
        while(i<getNumberFloors())
        {
            floors[i]=twoList.getOfficeFloor();
            i++;
            twoList=twoList.getNextOfficeFloor();
        }
        return floors;
    }

    @Override
    public Floor getFloor(int number) {
        TwoList twoList = listOfficeFloors;
        int i=0;
        while (i<number){
            twoList=twoList.getNextOfficeFloor();
            i++;
        }
        return twoList.getOfficeFloor();
    }

    @Override
    public Space getSpace(int number) {
        TwoList twoList = listOfficeFloors.getNextOfficeFloor();
        if(number<twoList.getOfficeFloor().getNumberOfSpaces())
        {
            return twoList.getOfficeFloor().getSpace(number);
        }
        else {
            int i =twoList.getOfficeFloor().getNumberOfSpaces()-1;
            twoList=twoList.getNextOfficeFloor();
            while(i+twoList.getNextOfficeFloor().getOfficeFloor().getNumberOfSpaces()<number)
            {
                i+=twoList.getNextOfficeFloor().getOfficeFloor().getNumberOfSpaces();
                twoList=twoList.getNextOfficeFloor();
            }
            return twoList.getOfficeFloor().getSpace(number-i);
        }
    }

    @Override
    public void setFloor(int number, Floor floor) {
        TwoList twoList = listOfficeFloors;
        int i=0;
        while (i<number){
            twoList=twoList.getNextOfficeFloor();
            i++;
        }
        twoList.setOfficeFloor(floor);
    }

    @Override
    public void setSpace(int number, Space space) {
        TwoList twoList = listOfficeFloors.getNextOfficeFloor();
        if(number<twoList.getOfficeFloor().getNumberOfSpaces())
        {
            twoList.getOfficeFloor().setSpace(number,space);
        }
        else {
            int i =twoList.getOfficeFloor().getNumberOfSpaces()-1;
            twoList=twoList.getNextOfficeFloor();
            while(i+twoList.getNextOfficeFloor().getOfficeFloor().getNumberOfSpaces()<number)
            {
                i+=twoList.getNextOfficeFloor().getOfficeFloor().getNumberOfSpaces();
                twoList=twoList.getNextOfficeFloor();
            }
            twoList.getOfficeFloor().setSpace(number-1,space);
        }
    }

    @Override
    public void addSpace(int number, Space space) {
        TwoList twoList = listOfficeFloors.getNextOfficeFloor();
        if(number<twoList.getOfficeFloor().getNumberOfSpaces())
        {
            twoList.getOfficeFloor().setSpace(number,space);
        }
        else {
            int i =twoList.getOfficeFloor().getNumberOfSpaces()-1;
            twoList=twoList.getNextOfficeFloor();
            while(i+twoList.getNextOfficeFloor().getOfficeFloor().getNumberOfSpaces()<number)
            {
                i+=twoList.getNextOfficeFloor().getOfficeFloor().getNumberOfSpaces();
                twoList=twoList.getNextOfficeFloor();
            }
            twoList.getOfficeFloor().addSpace(number-i,space);
        }

    }

    @Override
    public void deleteSpace(int number) {
        TwoList twoList = listOfficeFloors.getNextOfficeFloor();
        if(number<twoList.getOfficeFloor().getNumberOfSpaces())
        {
            twoList.getOfficeFloor().deleteSpace(number);
        }
        else {
            int i =twoList.getOfficeFloor().getNumberOfSpaces()-1;
            twoList=twoList.getNextOfficeFloor();
            while(i+twoList.getNextOfficeFloor().getOfficeFloor().getNumberOfSpaces()<number)
            {
                i+=twoList.getNextOfficeFloor().getOfficeFloor().getNumberOfSpaces();
                twoList=twoList.getNextOfficeFloor();
            }
            twoList.getOfficeFloor().deleteSpace(number-i);
        }
    }

    public Space getBestSpace()
    {
        TwoList node=listOfficeFloors.getNextOfficeFloor();
        Space bestSpace=listOfficeFloors.getOfficeFloor().getBestSpace();
        while (node!=listOfficeFloors)
        {
            if(bestSpace.getSquare()<node.getOfficeFloor().getBestSpace().getSquare())
            {
                bestSpace=node.getOfficeFloor().getBestSpace();
            }
        }
        return bestSpace;
    }

    @Override
    public Space[] getSpacesSortedBySquare() {
        return new Space[0];
    }

    public Space[] getListOffices()
    {
        int i=0;
        Space[] arrayOffices=new Office[getBuildingSize()];
        TwoList node=listOfficeFloors.getNextOfficeFloor();
        for(i=i;i<listOfficeFloors.getOfficeFloor().getNumberOfSpaces();i++)
        {
            arrayOffices[i]=listOfficeFloors.getOfficeFloor().getSpace(i);
        }
        while (node!=listOfficeFloors)
        {
            for(int j=0;j<node.getOfficeFloor().getNumberOfSpaces();j++)
            {
                arrayOffices[i]=listOfficeFloors.getOfficeFloor().getSpace(j);
                i++;
            }
            node=node.getNextOfficeFloor();
        }
        return arrayOffices;
    }
}
