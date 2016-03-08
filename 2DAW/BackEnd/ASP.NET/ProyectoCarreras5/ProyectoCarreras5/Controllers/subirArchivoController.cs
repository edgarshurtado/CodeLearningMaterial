using ProyectoCarreras5.Models;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.IO;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace ProyectoCarreras4.Controllers
{
    public class subirArchivoController : Controller
    {
        // GET: subirArchivo
        public ActionResult Index()
        {
            return View();
        }

        [HttpPost]
        public ActionResult Index(HttpPostedFileBase file)
        {

            if (file.ContentLength > 0)
            {
                var fileName = Path.GetFileName(file.FileName);
                var path = Path.Combine(Server.MapPath("~/App_Data/"), fileName);
                file.SaveAs(path);

            }

            return RedirectToAction("updateBD");
        }

        public ActionResult updateBD()
        {
            carrerasEntities db = new carrerasEntities();
            System.IO.StreamReader file =
                    new System.IO.StreamReader(Server.MapPath("~/App_Data/chips.txt"));
            string line;
            int posicion = 1;
            while ((line = file.ReadLine()) != null)
            {
                string[] datos = line.Split(' ');

                var codigoChip = datos[0];
                chip c = db.chips.Find(datos[0]);

                c.tiempo = TimeSpan.Parse(datos[1]);

                db.Entry(c).State = EntityState.Modified;
                db.SaveChanges();

                // Editar Participantes
                Participante p = db.Participantes.FirstOrDefault(Participante => Participante.chip == codigoChip);
                carrera carrera = db.carreras.Find(p.IdCarrera);


                p.tiempoOficial =  c.tiempo - carrera.horaInicio;
                p.posicionGeneral = posicion++;
                db.Entry(p).State = EntityState.Modified;
                db.SaveChanges();
            }

            file.Close();
            return RedirectToAction("Index");
        }

    }
}