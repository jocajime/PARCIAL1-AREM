
package edu.escuelaing.arem.util;

import java.net.*;
import java.io.*;

public class calc {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket (getPort ());
        } catch (IOException e) {
            System.err.println ("Could not listen on port: " + getPort ());
            System.exit (1);
        }
        boolean running = true;
        double numero = 0.0;
        while(running) {
            Socket clientSocket = null;
            try {
                clientSocket = serverSocket.accept ();
            } catch (IOException e) {
                System.err.println ("Accept failed.");
                System.exit (1);
            }

            PrintWriter out = new PrintWriter (clientSocket.getOutputStream (), true);
            BufferedReader in = new BufferedReader (new InputStreamReader (clientSocket.getInputStream ()));
            String inputLine, outputLine;

            while ((inputLine = in.readLine()) != null) {
                if (inputLine == "cos"){
                    outputLine = String.valueOf (Math.cos(numero));
                }else if (inputLine == "sin"){
                    outputLine = String.valueOf (Math.sin (numero));
                }else if (inputLine == "tan"){
                    outputLine = String.valueOf (Math.tan (numero));
                }else {
                    numero = Double.parseDouble (inputLine);
                }
            }
            out.close ();
            in.close ();
            clientSocket.close ();
        }
        serverSocket.close();
    }


    private static int getPort() {
        if (System.getenv ("PORT") != null){
            return Integer.parseInt (System.getenv ("PORT"));
        }
        return 36000;
    }
}