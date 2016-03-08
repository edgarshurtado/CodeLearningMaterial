using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using ProyectoCarreras5.Models;

namespace ProyectoCarreras5.Controllers
{
    public class participantesController : Controller
    {
        private carrerasEntities db = new carrerasEntities();

        // GET: participantes
        public ActionResult Index()
        {
            var participantes = db.Participantes.Include(p => p.carreras).Include(p => p.chips);
            return View(participantes.OrderBy(Participante => Participante.posicionGeneral).ToList());
        }

        // GET: participantes/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Participante participante = db.Participantes.Find(id);
            if (participante == null)
            {
                return HttpNotFound();
            }
            return View(participante);
        }

        // GET: participantes/Create
        public ActionResult Create()
        {
            ViewBag.IdCarrera = new SelectList(db.carreras, "idCarrera", "descripcionCarrera");
            ViewBag.chip = new SelectList(db.chips, "codigoChip", "codigoChip");
            return View();
        }

        // POST: participantes/Create
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "IdParticipante,IdCarrera,chip,apellidos,nombre,dni,posicionGeneral,tiempoOficial,dorsal")] Participante participante)
        {
            if (ModelState.IsValid)
            {
                db.Participantes.Add(participante);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            ViewBag.IdCarrera = new SelectList(db.carreras, "idCarrera", "descripcionCarrera", participante.IdCarrera);
            ViewBag.chip = new SelectList(db.chips, "codigoChip", "codigoChip", participante.chip);
            return View(participante);
        }

        // GET: participantes/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Participante participante = db.Participantes.Find(id);
            if (participante == null)
            {
                return HttpNotFound();
            }
            ViewBag.IdCarrera = new SelectList(db.carreras, "idCarrera", "descripcionCarrera", participante.IdCarrera);
            ViewBag.chip = new SelectList(db.chips, "codigoChip", "codigoChip", participante.chip);
            return View(participante);
        }

        // POST: participantes/Edit/5
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "IdParticipante,IdCarrera,chip,apellidos,nombre,dni,posicionGeneral,tiempoOficial,dorsal")] Participante participante)
        {
            if (ModelState.IsValid)
            {
                db.Entry(participante).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.IdCarrera = new SelectList(db.carreras, "idCarrera", "descripcionCarrera", participante.IdCarrera);
            ViewBag.chip = new SelectList(db.chips, "codigoChip", "codigoChip", participante.chip);
            return View(participante);
        }

        // GET: participantes/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Participante participante = db.Participantes.Find(id);
            if (participante == null)
            {
                return HttpNotFound();
            }
            return View(participante);
        }

        // POST: participantes/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            Participante participante = db.Participantes.Find(id);
            db.Participantes.Remove(participante);
            db.SaveChanges();
            return RedirectToAction("Index");
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }
    }
}
