import java.io.*;
import java.net.*;
public class Server {

    
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        int portNum = 9999;
        
        
        ServerSocket listener = new ServerSocket(portNum);
        System.out.println("Server is running at port: " + portNum);
        
        while(true){
            try{
                Socket clientSocket = listener.accept();
                
                ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
                
                ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());

                int i = (Integer) in.readObject();

                String response = "Integer Object Recieved.";
                out.writeObject(response);

                System.out.println("Received integer: " + i);

                out.close();
                in.close();

                clientSocket.close();
                break;
            }
            finally{
                listener.close();
            }
        
        }
        
    }
    
}




 
