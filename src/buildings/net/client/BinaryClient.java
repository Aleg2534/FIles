package buildings.net.client;

import buildings.Buildings;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class BinaryClient {
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(8000)) {
            System.out.println("Client started 228");
            serverSocket.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (Socket socket = new Socket("127.0.0.1", 8080);
             DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
             DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
             Reader reader = new FileReader(
                     "C:\\Users\\Home\\IdeaProjects\\test1\\src\\buildings\\net\\data\\initialInformation.txt");
             Scanner scanner = new Scanner(
                     new FileReader("C:\\Users\\Home\\IdeaProjects\\test1\\src\\buildings\\net\\data\\initialInformationTypes.txt"));
             Writer writer = new FileWriter(
                     "C:\\Users\\Home\\IdeaProjects\\test1\\src\\buildings\\net\\data\\result.txt")) {
            while (scanner.hasNext()) {
                String s = scanner.nextLine();
                dataOutputStream.writeUTF(s);
                Buildings.outputBuilding(Buildings.readBuilding(reader), dataOutputStream);
                System.out.println(s);
                String s1 = dataInputStream.readUTF();
                System.out.println(s1);
                writer.write(s1 + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
