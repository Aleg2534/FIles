package buildings;

import buildings.dwelling.Dwelling;
import buildings.dwelling.DwellingFloor;
import buildings.dwelling.Flat;
import buildings.interfaces.Building;
import buildings.interfaces.Floor;
import buildings.interfaces.Space;

import java.io.*;

public class Buildings {
    public static void outputBuilding(Building building, OutputStream stream) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(stream);
        dataOutputStream.writeInt(building.getNumberFloors());
        for (int i = 0; i < building.getNumberFloors(); i++) {
            dataOutputStream.writeInt(building.getFloor(i).getNumberOfSpaces());
            for (int j = 0; j < building.getFloor(i).getNumberOfSpaces(); j++) {
                dataOutputStream.writeInt(building.getFloor(i).getSpace(j).getNumberRooms());
                dataOutputStream.writeDouble(building.getFloor(i).getSpace(j).getSquare());
            }
        }
        dataOutputStream.flush();
    }

    public static Building inputBuilding(InputStream stream) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(stream);
        Building building = new Dwelling(dataInputStream.readInt());
        for (int i = 0; i < building.getNumberFloors(); i++) {
            Floor floor = new DwellingFloor(dataInputStream.readInt());
            for (int j = 0; j < floor.getNumberOfSpaces(); j++) {
                int numberRooms = dataInputStream.readInt();
                Space space = new Flat(dataInputStream.readDouble(), numberRooms);
                floor.setSpace(j, space);
            }
            building.setFloor(i, floor);
        }
        return building;
    }

    public static void writeBuilding(Building building, Writer stream) throws IOException {
        stream.write(building.getNumberFloors() + " ");
        for (int i = 0; i < building.getNumberFloors(); i++) {
            stream.write(building.getFloor(i).getNumberOfSpaces() + " ");
            for (int j = 0; j < building.getFloor(i).getNumberOfSpaces(); j++) {
                stream.write(building.getFloor(i).getSpace(j).getNumberRooms() + " ");
                stream.write(building.getFloor(i).getSpace(j).getSquare() + " ");
            }
        }
        stream.flush();
    }

    public static Building readBuilding(Reader stream) throws IOException {
        StreamTokenizer streamTokenizer= new StreamTokenizer(stream);
        streamTokenizer.nextToken();
        Building building = new Dwelling((int)streamTokenizer.nval);
        streamTokenizer.nextToken();
        for (int i = 0; i < building.getNumberFloors(); i++) {
            Floor floor = new DwellingFloor((int)streamTokenizer.nval);
            streamTokenizer.nextToken();
            for (int j = 0; j < floor.getNumberOfSpaces(); j++) {
                int numberRooms = (int)streamTokenizer.nval;
                streamTokenizer.nextToken();
                Space space = new Flat(streamTokenizer.nval, numberRooms);
                streamTokenizer.nextToken();
                floor.setSpace(j, space);
            }
            building.setFloor(i, floor);
        }
        return building;
    }

    public static void serializableBuilding(Building building, OutputStream stream) throws IOException {
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(stream);
        objectOutputStream.writeObject(building);
    }

    public static Building deserializableBuilding(InputStream stream) throws IOException, ClassNotFoundException {
        ObjectInputStream objectOutputStream=new ObjectInputStream(stream);
        return (Building) objectOutputStream.readObject();
    }
}
