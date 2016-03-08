using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class Consulta : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }

    protected void btn_consulta_Click(object sender, EventArgs e)
    {
        SqlDataSource1.DataSourceMode = SqlDataSourceMode.DataReader;

        SqlDataReader datos;
        datos = (SqlDataReader)SqlDataSource1.Select(DataSourceSelectArguments.Empty);

        if (datos.Read())
        {
            lbl_informacion.Text = "Clave: " + datos["clave"] + "<br> Email: " + datos["mail"];
        } else
        {
            lbl_informacion.Text = "No se encuentra un usuario con ese nombre";
        }
    }
}