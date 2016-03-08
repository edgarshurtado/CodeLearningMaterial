using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class Alta : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }

    protected void SqlDataSource1_Selecting(object sender, SqlDataSourceSelectingEventArgs e)
    {

    }

    protected void btn_alta_Click(object sender, EventArgs e)
    {
       

        SqlDataSource1.Insert();

        lbl_resultado.Text = "Se grabó correctamente";

        txt_nombre.Text = "";
        txt_clave.Text = "";
        txt_mail.Text = "";
    }
}