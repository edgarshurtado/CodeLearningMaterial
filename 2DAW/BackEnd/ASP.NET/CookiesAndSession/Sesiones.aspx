<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Sesiones.aspx.cs" Inherits="Sesiones" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
    
        Usuario:
        <asp:TextBox ID="txt_usuario" runat="server"></asp:TextBox>
        <br />
        <br />
        Clave:&nbsp;
        <asp:TextBox ID="txt_clave" runat="server"></asp:TextBox>
        <br />
        <br />
        <asp:Button ID="btn_confirmar" runat="server" OnClick="btn_confirmar_Click" Text="Confirmar" />
    
    </div>
    </form>
</body>
</html>
