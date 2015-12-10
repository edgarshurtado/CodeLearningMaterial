import java.io.*;
import java.net.*;
public class Parte_Cliente {
    public static void main(String[] args) {
        BufferReader dataIn = new BufferReader(new InputStreamReader(System.in));
        System.out.println("Escribe un mensaje en minúsculas: ");
        String fraseCliente = dataIn.readLine();
        String FraseMayusculas;

        String serverName = args[0];
        int serverPort = 6789;
        ServerSocket socketCliente = new Socket(serverName, serverPort);
    }
}
