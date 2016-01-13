
import DAO.ConexionBD;  //automaticament simporta la clase conexionDB
import DAO.ParticipanteDAO;
import Entidad.Participante;
import java.sql.Connection;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        try {
            ConexionBD conexion = new ConexionBD();
            System.out.println("Obrir conexio");  //obrim la conexio
            Connection con = conexion.abrirConexion();
            System.out.println("Conexio oberta");

            //instanciar DAO
            ParticipanteDAO participanteDAO = new ParticipanteDAO(); //instanciem dao per a poder utilitzar el insertar...etc
            
            //CREAR PARTICIPANTE
            Participante participante = new Participante();
            participante.setDorsal(9999);
            participante.setNombre("Aida");
            participante.setApellidos("Pepota");
            participante.setPoblacion("Andandara ");
            participante.setClub("Conchinchina");

            //Inserta Participante
            //participanteDAO.inserta(con, participante); 
            
            //EDITAR PARTICIPANTE
            participante.setDorsal(9999);
            participante.setNombre("Manola");
            participante.setApellidos("Calderon");
            participante.setPoblacion("En buscaYcaptura ");
            participante.setClub("Los fujitivos");

            //Actualizar participante
            //participanteDAO.actualiza(con, participante);
            
            //BORRAR PARTICIPANTE
            participante.setDorsal(9999);
            participanteDAO.eliminar(con, participante);
            
            
            //BUSCAR POR DORSAL
            participante.setDorsal(6); //ponemos el numero del dorsal que queremos buscar
            participante = participanteDAO.buscarPorDorsal(con, participante); // BERPOINTS - esto son paradas del programa, paramos aqui el programa - apretem Debug >Debur Project
            //participanteDAO.mostrarParticipante(participante);
            
            
            //BUSCAR POR POBLACION
            participante.setPoblacion("DENIA");
            ArrayList<Participante> listaParticipantes = participanteDAO.buscarPorPoblacion(con, participante);
            for(int i = 0; i < listaParticipantes.size(); i++){
                
                participanteDAO.mostrarParticipante(listaParticipantes.get(i));
                        
                
            }

            System.out.println("Tancar conexio");  //tanquem la conexio
            conexion.cerrarConexion(con);
            System.out.println("Conexio tancada");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        

    }

}
