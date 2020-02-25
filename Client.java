
import java.io.*;
import java.net.*;

public class Client {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int portNum = 9999;

        Socket socket = new Socket("localhost", portNum);

        Integer num = 50;

        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

        out.writeObject(num);

        String response = (String) in.readObject();
        System.out.println("Server message: " + response);

        socket.close();
    }

}