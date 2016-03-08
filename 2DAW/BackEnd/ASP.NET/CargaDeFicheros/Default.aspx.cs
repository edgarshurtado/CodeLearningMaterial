using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class _Default : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }

    protected void btn_subir_Click(object sender, EventArgs e)
    {
        if (File.Exists(Server.MapPath(".") + "/images/" + FileUpload1.FileName))
        {
            lbl_resultado.Text = "El Archivo seleccionado ya existe en el servidor";
        } else
        {
            FileUpload1.SaveAs(Server.MapPath(".") + "/images/" + FileUpload1.FileName);
            lbl_resultado.Text = "Archivo subido satisfactoriamente";

            lbl_resultado.Text += "<br>Tamaño: " + FileUpload1.PostedFile.ContentLength.ToString();
            lbl_resultado.Text += "<br>Tipo: " + FileUpload1.PostedFile.ContentType.ToString();
        }

        
    }
}