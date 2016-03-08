using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class Baja : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }

    protected void btn_borrar_Click(object sender, EventArgs e)
    {
        int cantidad;

        cantidad = SqlDataSource1.Delete();

        if (cantidad == 1)
        {
            lbl_resultado.Text = "Se ha borrado el usuario";
        } else
        {
            lbl_resultado.Text = "No se ha borrado el usuario";
        }
    }
}