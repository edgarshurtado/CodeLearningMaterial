package controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.ParticipanteDAO;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import java.util.List;
import model.entidad.Participantes;

/**
 *
 * @author AIDA
 */
public class ParticipanteController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {

        //Cridem a la vista participantes
        ModelAndView mv = new ModelAndView("participantes");

        try {

            List<Participantes> listaParticipantes = ParticipanteDAO.llistaParticipants();
            mv.addObject("listaParticipantes", listaParticipantes);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return mv;

    }

}
