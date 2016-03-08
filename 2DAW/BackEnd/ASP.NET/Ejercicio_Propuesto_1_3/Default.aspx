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
    
        Selecciona un navegador<br />
        <br />
        <asp:RadioButtonList ID="rbtn_navegadores" runat="server">
            <asp:ListItem Value="http://www.google.com">Google</asp:ListItem>
            <asp:ListItem Value="http://www.bing.com">Bing</asp:ListItem>
            <asp:ListItem Value="http://www.yahoo.com">Yahoo</asp:ListItem>
        </asp:RadioButtonList>
        <br />
        <br />
        <asp:Button ID="btn_navegar" runat="server" OnClick="btn_navegar_Click" Text="Ir" />
    
    </div>
    </form>
</body>
</html>
