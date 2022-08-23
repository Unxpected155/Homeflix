package Server;

import java.io.*;
import java.net.*;

public class ServidorHost {

    public void inicarHost()throws IOException {

        String fromClient;
        String toClient;

        ServerSocket server = new ServerSocket(8080);
        System.out.println("Esperando conexion en el puerto 8080");

        boolean run = true;

        while (run){

            Socket client = server.accept();

            System.out.println("Se recibió una conexion en el puerto 8080");
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);

            fromClient = in.readLine();
            System.out.println("Recibido" + fromClient);

            if (fromClient.equals("Hola")) {
                toClient = "aloH";
                System.out.println("enviar aloH");
                System.out.println(toClient);
                fromClient = in.readLine();
                System.out.println("Recibido " + fromClient);

                if (fromClient.equals("Bye")){

                    toClient = "eyB";
                    System.out.println("enviar eyB");
                    out.println(toClient);
                    client.close();
                    run = false;
                    System.out.println("Socket cerrado");
                }
            }
        }

        System.exit(0);
    }
}
