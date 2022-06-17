import java.io.*;
import java.net.*;

// Server class
public class Server {

    public static void main(String args[])throws Exception {
        try
        {
      

        System.out.println("Server On."); 

        // host and port number
        ServerSocket welcomeSocket = new ServerSocket(1234);
        while (true) {

        //Socet to receieve incoming client request
        Socket connectionSocket = welcomeSocket.accept();

            // New Thread Object 
       ClientHandler sct = new ClientHandler(connectionSocket);
        sct.start();
    }
}
        catch (Exception e)
        {
            System.out.println("Server is not available");
        }
    }   
}

// Client Handler Class
class ClientHandler extends Thread {
  
    // Parameters 
    String message;
    int total = 0;
   Socket connectionSocket;
    ClientHandler(Socket inSocket) {
    connectionSocket = inSocket;       
    }

    public void run() {
            try {
                // Input Stream of Client
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                // Output Stream of Client
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
            while (true) {
            message = inFromClient.readLine();
            if (message.equals("exit"))
            {
                break;
            }
            total++; 
          
                // Server Ouput 
            System.out.println("The message is: " + message);
            System.out.println("Your IP address is: " + InetAddress.getLocalHost());
            System.out.println("Your Port Number is: " + 1234);
            System.out.println("");   

            String message = Integer.toString(total);
            outToClient.writeBytes(message + '\n');       
        }    
    }
    catch (Exception e)
    {
        System.out.println ("exit");
    } 
}

}






    