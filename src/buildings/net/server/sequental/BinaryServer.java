package buildings.net.server.sequental;

import buildings.Buildings;
import buildings.dwelling.Dwelling;
import buildings.dwelling.hotel.Hotel;
import buildings.factories.DwellingFactory;
import buildings.factories.HotelFactory;
import buildings.factories.OfficeFactory;
import buildings.interfaces.Building;
import buildings.office.Office;
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

    private static void estimation(Building building, DataOutputStream dataOutputStream)
            throws BuildingUnderArrestException, IOException {
        if (seize()) {
            dataOutputStream.writeUTF("building under arrest ");
            throw new BuildingUnderArrestException();
        }
        System.out.println("estimation");
        if (building instanceof Dwelling) {
            dataOutputStream.writeUTF((int) building.getSquare()+"");
        } else if (building instanceof OfficeBuilding) {
            dataOutputStream.writeUTF((int) (building.getSquare() * 1.5)+"");
        } else {
            dataOutputStream.writeUTF((int) building.getSquare() * 2+"");
        }
    }

    public static void main(String[] args){
        try (ServerSocket socket = new ServerSocket(8080);
        ) {
            System.out.println("server started 228");
            while (true) {
                try (Socket clientSocket = socket.accept();
                     DataInputStream dataInputStream = new DataInputStream(clientSocket.getInputStream());
                     DataOutputStream dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());) {
                    setType(dataInputStream.readUTF());
                    Building building = Buildings.inputBuilding(dataInputStream);
                    System.out.println(building.toString());
                    estimation(building,dataOutputStream);

                } catch (BuildingUnderArrestException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
