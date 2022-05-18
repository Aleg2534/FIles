package buildings.office;

import buildings.dwelling.DwellingFloor;
import buildings.interfaces.Floor;
import buildings.interfaces.Space;
import buildings.office.oneList.OneList;
import exceptions.SpaceIndexOutOfBoundsException;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class OfficeFloor implements Floor {
    private OneList listOffices;

    public OfficeFloor(int numberOffices) {
        listOffices = new OneList(new Office());
        for (int i = 1; i < numberOffices; i++) {
            listOffices.addSpace(new Office());
        }
    }

    public OfficeFloor(OneList listOffices) {
        this.listOffices = listOffices;
    }

    public OfficeFloor(Office[] offices) {
        listOffices = new OneList(offices[0]);
        for (int i = 1; i < offices.length; i++) {
            listOffices.addSpace(offices[i]);
        }
    }

    public OneList getListOffices() {
        return listOffices;
    }

    public void setListOffices(OneList listOffices) {
        this.listOffices = listOffices;
    }


    @Override
    public int getNumberOfSpaces() {
        OneList node = listOffices.getNextOffice();
        int numberOffices = 1;
        while (node != listOffices) {
            numberOffices++;
            node = node.getNextOffice();
        }
        return numberOffices;
    }

    @Override
    public Space[] getFloor() {
        Space[] arrayOffices = new Office[getNumberOfSpaces()];
        OneList node = listOffices.getNextOffice();
        arrayOffices[0] = listOffices.getSpace();
        int i = 1;
        while (node != listOffices) {
            arrayOffices[i] = node.getSpace();
            node = node.getNextOffice();
            i++;
        }
        return arrayOffices;
    }

    @Override
    public double getSquare() {
        OneList node = listOffices.getNextOffice();
        double square = node.getSpace().getSquare();
        while (node != listOffices) {
            square += node.getNextOffice().getSpace().getSquare();
            node = node.getNextOffice();
        }
        return square;
    }

    @Override
    public int getNumberRooms() {
        OneList node = listOffices.getNextOffice();
        int number = node.getSpace().getNumberRooms();
        while (node != listOffices) {
            number += node.getSpace().getNumberRooms();
            node = node.getNextOffice();
        }
        return number;
    }


    @Override
    public Space getSpace(int number) throws SpaceIndexOutOfBoundsException {
        if (number >= getNumberOfSpaces() || number < 0) {
            throw new SpaceIndexOutOfBoundsException(getNumberOfSpaces(), number);
        }
        int i = 0;
        OneList nowSpace = listOffices;
        while (i != number) {
            i++;
            nowSpace = nowSpace.getNextOffice();
        }
        return nowSpace.getSpace();
    }

    @Override
    public void setSpace(int number, Space newSpace) throws SpaceIndexOutOfBoundsException {
        if (number >= getNumberOfSpaces() || number < 0) {
            throw new SpaceIndexOutOfBoundsException(getNumberOfSpaces(), number);
        }
        int i = 0;
        OneList nowSpace = listOffices;
        while (i != number) {
            i++;
            nowSpace = nowSpace.getNextOffice();
        }
        nowSpace.setSpace(newSpace);
    }

    @Override
    public void addSpace(int number, Space newSpace) throws SpaceIndexOutOfBoundsException {
        if (number > getNumberOfSpaces() || number < 0) {
            throw new SpaceIndexOutOfBoundsException(getNumberOfSpaces(), number);
        }
        int i = 0;
        OneList nowSpace = listOffices;
        while (i != number) {
            i++;
            nowSpace = nowSpace.getNextOffice();
        }
        nowSpace.addSpace(newSpace);
    }

    @Override
    public void deleteSpace(int number) throws SpaceIndexOutOfBoundsException {
        if (number >= getNumberOfSpaces() || number < 0) {
            throw new SpaceIndexOutOfBoundsException(getNumberOfSpaces(), number);
        }
        int i = 0;
        OneList nowSpace = listOffices;
        while (i != number - 1) {
            i++;
            nowSpace = nowSpace.getNextOffice();
        }
        nowSpace.deleteNextSpace();
    }

    public Space getBestSpace() {
        OneList node = listOffices.getNextOffice();
        Space bestSpace = listOffices.getSpace();
        while (node != listOffices) {
            if (bestSpace.getSquare() < node.getSpace().getSquare()) {
                bestSpace = node.getSpace();
            }
            node = node.getNextOffice();
        }
        return bestSpace;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("OfficeFloor(");
        OneList node = listOffices.getNextOffice();
        str.append(listOffices.getSpace().toString() + ", ");
        while (node != listOffices) {
            str.append(node.getSpace().toString() + ", ");
            node = node.getNextOffice();
        }
        str.append(")");
        return str.toString();
    }

    @Override
    public Object clone() {
        Floor newFloor = new OfficeFloor(getNumberOfSpaces());
        for (int i = 0; i < getNumberOfSpaces(); i++) {
            newFloor.setSpace(i, (Space) ((Office) getSpace(i)).clone());
        }
        return newFloor;
    }

    @Override
    public int hashCode() {
        return (int) (getNumberRooms() + getSquare()) * 2;
    }

    @Override
    public Iterator<Space> iterator() {
        return new Iterator<Space>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index<getNumberOfSpaces();
            }

            @Override
            public Space next() {
                return getSpace(index++);
            }
        };
    }

    @Override
    public int compareTo(Floor o) {
        return Integer.compare(getNumberOfSpaces(), o.getNumberOfSpaces());
    }
}
