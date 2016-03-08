using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class Sesiones : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }

    protected void btn_confirmar_Click(object sender, EventArgs e)
    {
        //Guardar las variables de sesión
        Session["usuario"] = txt_usuario.Text;
        Session["clave"] = txt_clave.Text;

        //Redireccionar a la siguiente página

        Response.Redirect("MostrarSesion2.aspx");
    }
}