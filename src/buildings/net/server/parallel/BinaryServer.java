package buildings.net.server.parallel;

import buildings.Buildings;
import buildings.dwelling.Dwelling;
import buildings.factories.DwellingFactory;
import buildings.factories.HotelFactory;
import buildings.factories.OfficeFactory;
import buildings.interfaces.Building;
import buildings.office.OfficeBuilding;
import exceptions.BuildingUnderArrestException;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BinaryServer {

    private static void setType(String type) {
        switch (type) {
            case "Dwelling" -> {
                Buildings.setBuildingFactory(new DwellingFactory());
            }
            case "OfficeBuilding" -> {
                Buildings.setBuildingFactory(new OfficeFactory());
            }
            case "Hotel" -> {
                Buildings.setBuildingFactory(new HotelFactory());
            }
            default -> {
            }
        }
    }

    private static boolean seize() {
        return ((int) (Math.random() * 10)) == 6;
    }

    private static double estimation(Building building)
            throws BuildingUnderArrestException, IOException {
        if (seize()) throw new BuildingUnderArrestException();
        System.out.println("estimation");
        double result = building.getSquare();
        if (building instanceof Dwelling) {
            result *= 1;
        } else if (building instanceof OfficeBuilding) {
            result *= 1.5;
        } else {
            result *= 2;
        }
        return result;
    }

    public static void main(String[] args) {

        try (ServerSocket socket = new ServerSocket(8080)) {
            System.out.println("server started 228");
            Socket clientSocket = socket.accept();
            while (true) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        DataInputStream dataInputStream = null;
                        DataOutputStream dataOutputStream = null;
                        try {
                            dataInputStream = new DataInputStream(clientSocket.getInputStream());
                            dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
                            setType(dataInputStream.readUTF());
                            Building building = Buildings.inputBuilding(dataInputStream);
 //                           System.out.println(building.toString());
                            String result = "";
                            try {
                                double price = estimation(building);
                                System.out.println("Price of building:" + price);
                                result = Double.toString(price);
                            } catch (BuildingUnderArrestException e) {
                                result = "Building is under arrest!";
                            }
                            dataOutputStream.writeUTF(result);
                            dataOutputStream.flush();
                        }
                        catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();

            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
