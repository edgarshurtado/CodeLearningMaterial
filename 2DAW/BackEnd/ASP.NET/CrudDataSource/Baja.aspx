<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Baja.aspx.cs" Inherits="Baja" %>

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
        <asp:TextBox ID="txt_usuario" runat="server"></asp:TextBox>
        <br />
        <br />
        <asp:Button ID="btn_borrar" runat="server" OnClick="btn_borrar_Click" Text="Button" />
        <br />
        <br />
        <asp:Label ID="lbl_resultado" runat="server"></asp:Label>
        <asp:SqlDataSource ID="SqlDataSource1" runat="server" ConnectionString="Data Source=DESKTOP-F851ML8\SQLEXPRESS;Initial Catalog=base1;Integrated Security=True" DeleteCommand="DELETE FROM Usuarios WHERE (nombre = @nombre)" ProviderName="System.Data.SqlClient">
            <DeleteParameters>
                <asp:ControlParameter ControlID="txt_usuario" Name="nombre" PropertyName="Text" />
            </DeleteParameters>
        </asp:SqlDataSource>
    
    </div>
    </form>
</body>
</html>
