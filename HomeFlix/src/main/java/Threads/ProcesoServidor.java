package Threads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ProcesoServidor extends Thread{

    @Override
    public void run () {

        String fromClient;
        String toClient;

        ServerSocket server = null;

        try {
            server = new ServerSocket(8080);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Esperando conexion en el puerto 8080");

        boolean run = true;

        try {

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

        }catch (IOException e){

            throw new RuntimeException(e);
        }


        System.exit(0);
    }
}
