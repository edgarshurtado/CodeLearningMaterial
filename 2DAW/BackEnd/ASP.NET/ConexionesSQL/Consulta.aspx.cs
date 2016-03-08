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

    protected void btn_buscar_Click(object sender, EventArgs e)
    {

        this.txt_clave.Text = "";
        this.txt_mail.Text = "";

        string s = System.Configuration.ConfigurationManager.ConnectionStrings["cadenaConexion1"].ConnectionString;

        SqlConnection conexion = new SqlConnection(s);

        string sql = "SELECT * FROM Usuarios WHERE nombre='" + txt_nombre.Text + "'";

        conexion.Open();
        SqlCommand comando = new SqlCommand(sql, conexion);

        SqlDataReader registro = comando.ExecuteReader();

        if (registro.Read())
        {
            /*this.lbl_resultado.Text = "clave: " + registro["clave"] + "<br>" + "Mail: " + registro["mail"];*/

            this.txt_clave.Text = registro["clave"].ToString();
            this.txt_mail.Text = registro["mail"].ToString();


        } else
        {
            this.lbl_resultado.Text = "No existe el usuario";
        }

        conexion.Close();
    }

    protected void btn_actualizar_Click(object sender, EventArgs e)
    {
        string s = System.Configuration.ConfigurationManager.ConnectionStrings["cadenaConexion1"].ConnectionString;

        SqlConnection conexion = new SqlConnection(s);

        string sql = "UPDATE Usuarios SET clave='" + this.txt_clave.Text + "', mail='" + this.txt_mail.Text + "'" + 
            "WHERE nombre='" + this.txt_nombre.Text + "'";
        conexion.Open();

        SqlCommand comando = new SqlCommand(sql, conexion);
        int cantidad = comando.ExecuteNonQuery();

        if (cantidad == 1)
        {
            this.lbl_modificados.Text = "Registro modificado";
        } else
        {
            this.lbl_modificados.Text = "Error en la modificación";
        }

        conexion.Close();
    }
}