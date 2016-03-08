using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class Carga : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }

    protected void btn_confirmar_Click(object sender, EventArgs e)
    {
        StreamWriter archivo = new StreamWriter(Server.MapPath(".")+ "/visitas.txt", true);
        archivo.WriteLine("nombre: " + txt_nombre.Text);
        archivo.WriteLine("pais: " + txt_pais.Text);
        archivo.WriteLine("comentario: " + txt_comentarios.Text);
        archivo.WriteLine("--------");

        archivo.Close();

        lbl_mensaje.Text = "Datos registrados";
    }
}