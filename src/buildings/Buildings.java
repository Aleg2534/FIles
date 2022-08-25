package buildings;

import buildings.criterions.SpacesRoomsComparator;
import buildings.factories.DwellingFactory;
import buildings.interfaces.Building;
import buildings.interfaces.BuildingFactory;
import buildings.interfaces.Floor;
import buildings.interfaces.Space;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Comparator;
import java.util.Formatter;

public class Buildings {
    private static BuildingFactory buildingFactory = new DwellingFactory();

    public static void setBuildingFactory(BuildingFactory newBuildingFactory) {
        buildingFactory = newBuildingFactory;
    }

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
        Floor[] floors = new Floor[dataInputStream.readInt()];
        for (int i = 0; i < floors.length; i++) {
            int a = dataInputStream.readInt();
            System.out.println(a);
            floors[i] = createFloor(a);
            for (int j = 0; j < floors[i].getNumberOfSpaces(); j++) {
                int numberRooms = dataInputStream.readInt();
                floors[i].setSpace(j, createSpace(dataInputStream.readDouble(), numberRooms));
            }
        }
        return createBuilding(floors);
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
        stream.write("\n");
        stream.flush();
    }

    public static Building readBuilding(Reader stream) throws IOException {
        StreamTokenizer streamTokenizer = new StreamTokenizer(stream);
        streamTokenizer.nextToken();
        Floor[] floors = new Floor[(int) streamTokenizer.nval];
        for (int i = 0; i < floors.length; i++) {
            streamTokenizer.nextToken();
            floors[i] = createFloor((int) streamTokenizer.nval);
            for (int j = 0; j < floors[i].getNumberOfSpaces(); j++) {
                streamTokenizer.nextToken();
                int numberRooms = (int) streamTokenizer.nval;
                streamTokenizer.nextToken();
                floors[i].setSpace(j, createSpace(streamTokenizer.nval, numberRooms));
            }
        }
        return createBuilding(floors);
    }

    public static void serializableBuilding(Building building, OutputStream stream) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(stream);
        objectOutputStream.writeObject(building);
    }

    public static Building deserializableBuilding(InputStream stream) throws IOException {
        ObjectInputStream objectOutputStream = new ObjectInputStream(stream);
        try {
            Building building = (Building) objectOutputStream.readObject();
            return createBuilding(building.getFloors());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writeBuildingFormat(Building building, Writer stream) {
        Formatter formatter = new Formatter(stream);
        formatter.format("Number of floors: %d\n", building.getNumberFloors());
        for (int i = 0; i < building.getNumberFloors(); i++) {
            formatter.format("Number of spaces on floor: %d\n", building.getFloor(i).getNumberOfSpaces());
            for (int j = 0; j < building.getFloor(i).getNumberOfSpaces(); j++) {
                formatter.format("Number of Space: [%d] Number of rooms: %d Square: %f\n", j,
                        building.getFloor(i).getSpace(j).getNumberRooms(), building.getFloor(i).getSpace(j).getSquare());
            }
        }
        formatter.flush();
    }

    public static Space createSpace(double square) {
        return buildingFactory.createSpace(square);
    }

    public static Space createSpace(double square, int numberRooms) {
        return buildingFactory.createSpace(square, numberRooms);
    }

    public static Floor createFloor(int numberSpaces) {
        return buildingFactory.createFloor(numberSpaces);
    }

    public static Floor createFloor(Space[] spaces) {
        return buildingFactory.createFloor(spaces);
    }

    public static <T extends Space> Space createSpace(double square, Class<T> spaceClass) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return spaceClass.getConstructor(double.class).newInstance(square);
    }

    public static <T extends Space> Space createSpace(double square, int numberRooms, Class<T> spaceClass) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return spaceClass.getConstructor(double.class, int.class).newInstance(square, numberRooms);
    }

    public static <T extends Floor> Floor createFloor(int numberSpaces, Class<T> floorClass) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return floorClass.getConstructor(int.class).newInstance(numberSpaces);
    }

    public static <T extends Floor> Floor createFloor(Space[] spaces, Class<T> floorCLass) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return floorCLass.getConstructor(Space[].class).newInstance((Object) spaces);
    }

    public static Building createBuilding(int numberOfFloors, int... numbersOfSpaces) {
        return buildingFactory.createBuilding(numberOfFloors, numbersOfSpaces);
    }

    public static <T extends Building> Building createBuilding(Class<T> buildingClass, int numberOfFloors, int... numbersOfSpaces) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return buildingClass.getConstructor(int.class, int[].class).newInstance(numberOfFloors, numbersOfSpaces);
    }

    public static Building createBuilding(Floor[] floors) {
        return buildingFactory.createBuilding(floors);
    }

    public static <T extends Building> Building createBuilding(Floor[] floors, Class<T> buildingClass) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        try {
            return buildingClass.getConstructor(Floor[].class).newInstance(floors);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static SynchronizedFloor createSychronizedFloor(Floor floor) {
        return new SynchronizedFloor(floor);
    }

    public static <T extends Comparable<T>> void sortArrays(T[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    T obj = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = obj;
                }
            }
        }
    }

    public static void sortedSpacesByCriterion(Space[] array, Comparator<Space> comparator) {
        new SpacesRoomsComparator();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (comparator.compare(array[j], array[j + 1]) < 0) {
                    Space obj = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = obj;
                }
            }
        }
    }

    public static void sortedFloorsByCriterion(Floor[] array, Comparator<Floor> comparator) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (comparator.compare(array[j], array[j + 1]) < 0) {
                    Floor obj = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = obj;
                }
            }
        }
    }

    public static <T> void sortArraysByComparator(T[] array, Comparator<T> comparator) {

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (comparator.compare(array[j], array[j + 1]) < 0) {
                    T obj = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = obj;
                }
            }
        }
    }
}
