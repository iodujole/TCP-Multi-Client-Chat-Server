import java.io.*;
import java.net.*;

// Client Class
public class Client {

    public static void main(String args[])throws Exception{
        // Parameters
        String total;
        String input;
        try {

            // Establishing connection by host and port number 
        Socket clientSocket = new Socket("localhost", 1234);
        
            while(true)
            {

         // Reading Input       
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        
        // Enter Input 
        System.out.print("The TCP client is on. Please enter you input: ");
        
        input = inFromUser.readLine();
            if(input.equals("exit"))
            {
                outToServer.writeBytes(input + '\n');
                    break;
            }
            else
            {
                outToServer.writeBytes(input + '\n');
                    total = inFromServer.readLine();

                    // Client Ouput
                    System.out.println("Total Messages: " + total);
                    System.out.print("");
            }
        }
        // Closing Client Socket
        clientSocket.close();
    }
    catch (Exception e)
    {
        System.out.print("Connect to the server");
        
    }
}
}

    


