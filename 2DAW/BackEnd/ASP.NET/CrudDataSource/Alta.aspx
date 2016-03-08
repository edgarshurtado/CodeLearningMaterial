<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Alta.aspx.cs" Inherits="Alta" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
    
        Nombre:
        <asp:TextBox ID="txt_nombre" runat="server"></asp:TextBox>
        <br />
        <br />
        Clave:&nbsp;
        <asp:TextBox ID="txt_clave" runat="server"></asp:TextBox>
        <br />
        <br />
        Mail:
        <asp:TextBox ID="txt_mail" runat="server"></asp:TextBox>
        <br />
        <br />
        <asp:Button ID="btn_alta" runat="server" OnClick="btn_alta_Click" Text="Alta" />
        <br />
        <br />
        <br />
        <asp:Label ID="lbl_resultado" runat="server"></asp:Label>
        <br />
        <asp:SqlDataSource ID="SqlDataSource1" runat="server" ConnectionString="Data Source=DESKTOP-F851ML8\SQLEXPRESS;Initial Catalog=base1;Integrated Security=True" InsertCommand="INSERT INTO Usuarios(nombre, clave, mail) VALUES (@nombre, @clave, @mail)" OnSelecting="SqlDataSource1_Selecting" ProviderName="System.Data.SqlClient">
            <InsertParameters>
                <asp:ControlParameter ControlID="txt_nombre" Name="nombre" PropertyName="Text" />
                <asp:ControlParameter ControlID="txt_clave" Name="clave" PropertyName="Text" />
                <asp:ControlParameter ControlID="txt_mail" Name="mail" PropertyName="Text" />
            </InsertParameters>
            <SelectParameters>
                <asp:Parameter Name="nombre" />
                <asp:Parameter Name="mail" />
                <asp:Parameter Name="clave" />
            </SelectParameters>
        </asp:SqlDataSource>
    
    </div>
    </form>
</body>
</html>
