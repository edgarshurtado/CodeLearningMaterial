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
        if (File.Exists(Server.MapPath(".") + "/contador.txt"))
        {
            StreamReader archivo1 = new StreamReader(Server.MapPath(".") + "/contador.txt");
            string valor = archivo1.ReadToEnd();

            int contador = int.Parse(valor);

            contador++;

            archivo1.Close();

            StreamWriter archivo2 = new StreamWriter(Server.MapPath(".") + "/contador.txt");

            archivo2.WriteLine(contador.ToString());

            archivo2.Close();

            lbl_contador.Text = contador.ToString();
        }
        else
        {
            StreamWriter archivo = new StreamWriter(Server.MapPath(".") + "/contador.txt");

            archivo.Write("1");

            archivo.Close();

            lbl_contador.Text = "1";
        }
    }
}