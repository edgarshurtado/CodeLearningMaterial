using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class MostrarCookie : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        //Comprueba existencia de la cookie
        if (Request.Cookies["edad"] == null)
        {
            lbl_informacion_cookie.Text = "No existe la cookie.";
        } else
        {
            lbl_informacion_cookie.Text = this.Request.Cookies["edad"].Value;
        }


    }
}