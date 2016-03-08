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

    protected void btn_calcular_Click(object sender, EventArgs e)
    {
        int x1 = int.Parse(txt_1.Text);
        int x2 = int.Parse(txt_2.Text);

        int resultado;

        if (chk_sumar.Checked)
        {
            resultado = x1 + x2;
            lbl_resultado.Text += "La suma de los valores es =" + resultado.ToString();
        }
        if(chk_restar.Checked)
        {
            resultado = x1 - x2;
            lbl_resultado.Text += " <br>La resta de los valores es = " + resultado.ToString();
        }

        if (lst_operaciones.Items[0].Selected)
        {
            resultado = x1 + x2;
            lbl_resultado.Text += "La suma de los valores es =" + resultado.ToString();
        }
    }

    protected void CheckBoxList1_SelectedIndexChanged(object sender, EventArgs e)
    {
       
    }
}