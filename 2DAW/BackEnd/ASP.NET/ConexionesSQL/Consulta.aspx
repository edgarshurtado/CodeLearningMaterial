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
    
        Dame el nombre de Usuario
        <asp:TextBox ID="txt_nombre" runat="server"></asp:TextBox>
&nbsp;
        <asp:Button ID="btn_buscar" runat="server" OnClick="btn_buscar_Click" Text="Buscar" />
        <br />
        <br />
        <asp:Label ID="lbl_resultado" runat="server"></asp:Label>
        <br />
        <br />
        <br />
        Clave:
        <asp:TextBox ID="txt_clave" runat="server"></asp:TextBox>
        <br />
        <br />
        Email:
        <asp:TextBox ID="txt_mail" runat="server"></asp:TextBox>
        <br />
        <br />
        <asp:Button ID="btn_actualizar" runat="server" OnClick="btn_actualizar_Click" Text="Actualizar" />
        <br />
        <br />
        <asp:Label ID="lbl_modificados" runat="server"></asp:Label>
    
    </div>
    </form>
</body>
</html>
