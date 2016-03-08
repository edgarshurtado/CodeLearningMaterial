using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class _Default : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }

    protected void Button1_Click(object sender, EventArgs e)
    {
        if (Page.IsValid)
        {
            //Crear archivo y si ya existe sobreescribirlo
            StreamWriter arch = new StreamWriter(Server.MapPath(".") + "/" + 
                txt_nombre.Text + txt_apellido1.Text + txt_apellido2.Text + ".txt", false);

            arch.WriteLine("Datos personales<br>");
            arch.WriteLine("Nombre: " + txt_nombre.Text + " " + txt_apellido1.Text + " " + txt_apellido2.Text + "<br>");
            arch.WriteLine("Fecha de nacimiento :" + cal_nacimiento.SelectedDate + "<br>");
            arch.WriteLine("Estudios:<br>");
            arch.WriteLine(txt_estudios.Text + "<br>");
            arch.WriteLine("Experiencia:<br>");
            arch.WriteLine(txt_experiencia.Text);

            arch.Close();
        }
        


    }
}