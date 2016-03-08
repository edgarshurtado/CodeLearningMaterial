using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class Listado : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        StreamReader archivo = new StreamReader(Server.MapPath(".") + "/visitas.txt", true);

        lbl_contenido.Text = archivo.ReadToEnd();
    }
}