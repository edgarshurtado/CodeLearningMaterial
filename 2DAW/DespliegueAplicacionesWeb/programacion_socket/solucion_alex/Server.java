import java.io.*;
import java.net.*;

public class Server {
	static final int PORT = 6978;
	
	public static void main (String[] args) throws Exception{
		String fraseCliente;
		String fraseModificada;
		
		ServerSocket socketServer = new ServerSocket(PORT);
                
		while (true){
			System.out.println("Estado servidor actual: ON");
			Socket soConnect = socketServer.accept();
                        //crear un objeto socket soConnect , especifico para el cliente
                        BufferedReader entradaCliente = new BufferedReader(new InputStreamReader(soConnect.getInputStream()));
                        DataOutputStream salidaCliente = new DataOutputStream(soConnect.getOutputStream());
                        fraseCliente = entradaCliente.readLine();
                        fraseModificada = fraseCliente.toUpperCase() + '\n';
                        salidaCliente.writeBytes(fraseModificada);
            
		}
		
	}
}
