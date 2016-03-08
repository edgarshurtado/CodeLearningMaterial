using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class Modificacion : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }

    protected void btn_buscar_Click(object sender, EventArgs e)
    {
        SqlDataSource1.DataSourceMode = SqlDataSourceMode.DataReader;

        SqlDataReader datos;

        datos = (SqlDataReader)SqlDataSource1.Select(DataSourceSelectArguments.Empty);

        if (datos.Read())
        {
            txt_clave.Text = datos["clave"].ToString();
            txt_mail.Text = datos["mail"].ToString();
        } else
        {
            lbl_buscar.Text = "No existe el usuario indicado";
        }
    }

    protected void btn_modificar_Click(object sender, EventArgs e)
    {
        int cantidad;

        cantidad = SqlDataSource1.Update();

        if(cantidad == 1)
        {
            lbl_modificar.Text = "Se modificaron los datos correctamente";
        } else
        {
            lbl_modificar.Text = "No existe dicho código de usuario";
        }
    }
}