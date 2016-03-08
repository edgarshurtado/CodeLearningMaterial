using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class Default3 : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }

    protected void btn_validar_Click(object sender, EventArgs e)
    {
        if (IsValid)
        {
            Response.Redirect("Default4.aspx");
        }
    }

    protected void CustomValidator1_ServerValidate(object source, ServerValidateEventArgs args)
    {
        int valor;
        valor = int.Parse(txt_numero.Text);

        if(valor % 5 == 0)
        {
            args.IsValid = true;
        } else
        {
            args.IsValid = false;
        }
    }
}