using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class Alta : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }

    protected void btn_alta_Click(object sender, EventArgs e)
    {
        string s = System.Configuration.ConfigurationManager.ConnectionStrings["cadenaConexion1"].ConnectionString;

        SqlConnection connexion = new SqlConnection(s);

        connexion.Open();

        string sql = "INSERT INTO Usuarios(nombre,clave,mail) VALUES('"+ txt_nombre.Text +"', '"+ txt_clave.Text +"','" + txt_mail.Text +"')";

        SqlCommand comando = new SqlCommand(sql, connexion);

        comando.ExecuteNonQuery();

        lbl_resultado.Text = "El registro se añadió satisfactoriamente";

        connexion.Close();
    }
}