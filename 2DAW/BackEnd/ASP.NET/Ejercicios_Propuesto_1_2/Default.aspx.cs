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

    protected void Button1_Click(object sender, EventArgs e)
    {
        int respuestasValidas = 0;

        if(Int32.Parse(rbtn_capital.SelectedValue) == 1)
        {
            respuestasValidas++;
        }

        if (Int32.Parse(rbtn_operacion.SelectedValue) == 1)
        {
            respuestasValidas++;
        }

        if (Int32.Parse(rbtn_gandia.SelectedValue) == 1)
        {
            respuestasValidas++;
        }

        if (Int32.Parse(rbtn_fisica.SelectedValue) == 1)
        {
            respuestasValidas++;
        }

        lbl_resultado.Text = "Lars respuestas válidas han sido: " + respuestasValidas;
    }
}