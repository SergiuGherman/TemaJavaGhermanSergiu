import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;
import java.net.Socket;
import java.util.Collections;

class Server {
    public static int NrClient=0;
    public static List<Human> HumanList=new ArrayList<>();
    public static void main(String[] args)
    {
        ServerSocket server = null;
        int portNumber = 80;

        try {

            server = new ServerSocket(portNumber);
            server.setReuseAddress(true);

            // running infinite loop for getting
            // client request
            while (true) {

                // socket object to receive incoming client
                // requests

                Socket client = server.accept();

                // Displaying that new client is connected
                // to server
                System.out.println("New client connected"
                        + client.getInetAddress()
                        .getHostAddress());

                // create a new thread object
                NrClient++;
                ClientHandler clientSock
                        = new ClientHandler(client);

                // This thread will handle the client
                // separately
                new Thread(clientSock).start();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (server != null) {
                try {
                    server.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    // ClientHandler class
    private static class ClientHandler implements Runnable {
        private final Socket clientSocket;
        private int Client;
        // Constructor
        public ClientHandler(Socket socket)
        {
            this.clientSocket = socket;
            this.Client=NrClient;
        }

        public void run()
        {
            PrintWriter out = null;
            BufferedReader in = null;
            try {

                // get the outputstream of client
                out = new PrintWriter(
                        clientSocket.getOutputStream(), true);

                // get the inputstream of client
                in = new BufferedReader(
                        new InputStreamReader(
                                clientSocket.getInputStream()));

                String line;
                while ((line = in.readLine()) != null) {

                    // writing the received message from
                    // client
                    String tip[];
                    tip=line.split(" ",6);

                    switch (tip[0])
                    {
                        case "Student":
                            HumanList.add(new Student(tip[1],tip[2],tip[3],Integer.parseInt(tip[4]),Integer.parseInt(tip[5])));
                            break;
                        case "Profesor":
                            HumanList.add(new Profesor(tip[1],tip[2],tip[3],Integer.parseInt(tip[4]),tip[5]));
                            break;
                    }
                    Collections.sort(HumanList);

                    for(Human x:HumanList)
                    {
                        System.out.println(x.toString());
                    }
                    out.println(line);

                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                try {
                    if (out != null) {
                        out.close();
                    }
                    if (in != null) {
                        in.close();
                        clientSocket.close();
                    }
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
