<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Modificacion.aspx.cs" Inherits="Modificacion" %>

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
        <asp:Button ID="btn_buscar" runat="server" OnClick="btn_buscar_Click" Text="Buscar" />
        <br />
        <br />
        <asp:Label ID="lbl_buscar" runat="server"></asp:Label>
        <br />
        <br />
        <br />
        Clave: <asp:TextBox ID="txt_clave" runat="server"></asp:TextBox>
        <br />
        <br />
        Email:
        <asp:TextBox ID="txt_mail" runat="server"></asp:TextBox>
        <br />
        <br />
        <asp:Button ID="btn_modificar" runat="server" OnClick="btn_modificar_Click" Text="Modificar" />
        <br />
        <br />
        <asp:Label ID="lbl_modificar" runat="server"></asp:Label>
        <br />
        <br />
        <asp:SqlDataSource ID="SqlDataSource1" runat="server" ConnectionString="Data Source=DESKTOP-F851ML8\SQLEXPRESS;Initial Catalog=base1;Integrated Security=True" ProviderName="System.Data.SqlClient" SelectCommand="SELECT * FROM Usuarios WHERE (nombre = @nombre)" UpdateCommand="UPDATE Usuarios SET clave = @clave, mail = @mail WHERE (nombre = @nombre)">
            <SelectParameters>
                <asp:ControlParameter ControlID="txt_usuario" DefaultValue="" Name="nombre" PropertyName="Text" />
            </SelectParameters>
            <UpdateParameters>
                <asp:ControlParameter ControlID="txt_usuario" Name="nombre" PropertyName="Text" />
                <asp:ControlParameter ControlID="txt_clave" Name="clave" PropertyName="Text" />
                <asp:ControlParameter ControlID="txt_mail" Name="mail" PropertyName="Text" />
            </UpdateParameters>
        </asp:SqlDataSource>
    
    </div>
    </form>
</body>
</html>
