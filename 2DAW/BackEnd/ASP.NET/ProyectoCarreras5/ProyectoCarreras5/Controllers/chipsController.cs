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
    public class chipsController : Controller
    {
        private carrerasEntities db = new carrerasEntities();

        // GET: chips
        public ActionResult Index()
        {
            return View(db.chips.ToList());
        }

        // GET: chips/Details/5
        public ActionResult Details(string id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            chip chip = db.chips.Find(id);
            if (chip == null)
            {
                return HttpNotFound();
            }
            return View(chip);
        }

        // GET: chips/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: chips/Create
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "codigoChip,tiempo")] chip chip)
        {
            if (ModelState.IsValid)
            {
                db.chips.Add(chip);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            return View(chip);
        }

        // GET: chips/Edit/5
        public ActionResult Edit(string id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            chip chip = db.chips.Find(id);
            if (chip == null)
            {
                return HttpNotFound();
            }
            return View(chip);
        }

        // POST: chips/Edit/5
        // Para protegerse de ataques de publicación excesiva, habilite las propiedades específicas a las que desea enlazarse. Para obtener 
        // más información vea http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "codigoChip,tiempo")] chip chip)
        {
            if (ModelState.IsValid)
            {
                db.Entry(chip).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(chip);
        }

        // GET: chips/Delete/5
        public ActionResult Delete(string id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            chip chip = db.chips.Find(id);
            if (chip == null)
            {
                return HttpNotFound();
            }
            return View(chip);
        }

        // POST: chips/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(string id)
        {
            chip chip = db.chips.Find(id);
            db.chips.Remove(chip);
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
