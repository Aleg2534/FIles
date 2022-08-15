package buildings.net.server.parallel;

import threads.ClientSocketThread;

import java.io.IOException;
import java.net.ServerSocket;

public class BinaryServer {

    public static void main(String[] args) throws IOException {
                try (ServerSocket socket = new ServerSocket(8080)) {
                    System.out.println("server started 228");
                    while (true)
                    {
                        ClientSocketThread clientSocketThread = new ClientSocketThread(socket.accept());
                        clientSocketThread.start();
                    }
            }
    }
}
