<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Consulta.aspx.cs" Inherits="Consulta" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
    
        Nombre Usuario:
        <asp:TextBox ID="TextBox1" runat="server"></asp:TextBox>
        <br />
        <br />
        <asp:SqlDataSource ID="SqlDataSource1" runat="server" ConnectionString="Data Source=DESKTOP-F851ML8\SQLEXPRESS;Initial Catalog=base1;Integrated Security=True" ProviderName="System.Data.SqlClient" SelectCommand="SELECT id, nombre, clave, mail FROM Usuarios WHERE (nombre = @nombre)">
            <SelectParameters>
                <asp:ControlParameter ControlID="TextBox1" Name="nombre" PropertyName="Text" />
            </SelectParameters>
        </asp:SqlDataSource>
        <br />
        <asp:Button ID="btn_consulta" runat="server" OnClick="btn_consulta_Click" Text="Consulta" />
        <br />
        <br />
        <asp:Label ID="lbl_informacion" runat="server"></asp:Label>
    
    </div>
    </form>
</body>
</html>
