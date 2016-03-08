using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class _Default : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }

    protected void btn_crear_Click(object sender, EventArgs e)
    {
        HttpCookie cookie1 = new HttpCookie("edad", txt_valor_cookie.Text); //Creamos la cookie así
        cookie1.Expires = new DateTime(2018, 12, 5); //Crear fecha de expiración para la cookie

        Response.Cookies.Add(cookie1);

        lbl_resultado.Text = "Se creo la cookie";
    }
}