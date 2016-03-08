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

    protected void Calendar1_SelectionChanged(object sender, EventArgs e)
    {
        string fecha = Calendar1.SelectedDate.Day.ToString() + Calendar1.SelectedDate.Month.ToString() + Calendar1.SelectedDate.Year.ToString();

        if(File.Exists(Server.MapPath(".") + "/" + fecha))
        {
            StreamReader archivo = new StreamReader(Server.MapPath(".") + "/" + fecha);

            txt_evento.Text = archivo.ReadToEnd();

            archivo.Close();
        }else
        {
            txt_evento.Text = "";
        }
    }

    protected void btn_guardar_Click(object sender, EventArgs e)
    {
        string fecha = Calendar1.SelectedDate.Day.ToString() + Calendar1.SelectedDate.Month.ToString() + Calendar1.SelectedDate.Year.ToString();
        StreamWriter archivo = new StreamWriter(Server.MapPath(".") + "/" + fecha);

        archivo.WriteLine(txt_evento.Text);

        archivo.Close();
        

    }
}