<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Default.aspx.cs" Inherits="_Default" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
    
        Valor de la cookie:<br />
        <asp:TextBox ID="txt_valor_cookie" runat="server"></asp:TextBox>
        <br />
        <br />
        <asp:Button ID="btn_crear" runat="server" OnClick="btn_crear_Click" Text="Crear" />
        <br />
        <br />
        <asp:Label ID="lbl_resultado" runat="server"></asp:Label>
        <br />
        <br />
        <br />
        <br />
        <asp:HyperLink ID="HyperLink1" runat="server" NavigateUrl="~/MostrarCookie.aspx">Mostrar cookie</asp:HyperLink>
    
    </div>
    </form>
</body>
</html>
