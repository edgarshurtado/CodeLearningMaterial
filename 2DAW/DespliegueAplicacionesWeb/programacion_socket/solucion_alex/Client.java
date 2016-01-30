
import java.net.*;
import java.io.*;

public class Client {

    public static void main(String argv[]) {
        String fraseOriginal;
        String fraseModificada;

        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

        try {
            Socket socketCliente = new Socket("10.2.1.207", 7689);
            int puerto = socketCliente.getPort();
            System.out.println("Conectado por el Puerto " + puerto);
            boolean respuesta = socketCliente.isConnected();
            if (respuesta) {
                System.out.println("Servidor Apagado");
           
            } else {
                System.out.println("servidor OK");
            }

            DataOutputStream SalidaAlServidor = new DataOutputStream(socketCliente.getOutputStream());
            BufferedReader EntradaDelServidor = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
            System.out.println("Escribe una frase: ");
            fraseOriginal = teclado.readLine();

            SalidaAlServidor.writeBytes(fraseOriginal + '\n');
            fraseModificada = EntradaDelServidor.readLine();
            System.out.println("Respuesta del servidor: " + fraseModificada);
            socketCliente.close();

        } catch (Exception e) {
            System.out.println("ERROR!" + e.getMessage() + "\nEl servidor esta Apagado");
        }

    }
}
