using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class MostrarSesion2 : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        //Leer variables de sesión

        lbl_datos_sesion.Text = "Usuario: " + this.Session["usuario"].ToString();
        lbl_datos_sesion.Text = "<br>Clave: " + this.Session["clave"].ToString();
    }
}