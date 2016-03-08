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
    
        Cuál es la capital de España?<br />
        <asp:RadioButtonList ID="rbtn_capital" runat="server">
            <asp:ListItem Value="0">Barcelona</asp:ListItem>
            <asp:ListItem Value="0">Valencia</asp:ListItem>
            <asp:ListItem Value="1">Madrid</asp:ListItem>
        </asp:RadioButtonList>
        <br />
        <br />
        Cuánto es 15/0?<br />
        <asp:RadioButtonList ID="rbtn_operacion" runat="server">
            <asp:ListItem>0</asp:ListItem>
            <asp:ListItem Value="0">15</asp:ListItem>
            <asp:ListItem Value="1">La operación no se puede realizar</asp:ListItem>
        </asp:RadioButtonList>
        <br />
        <br />
        Cuántos habitantes tiene Gandia?<br />
        <asp:RadioButtonList ID="rbtn_gandia" runat="server">
            <asp:ListItem Value="0">7000</asp:ListItem>
            <asp:ListItem Value="1">70000</asp:ListItem>
            <asp:ListItem Value="0">700000</asp:ListItem>
        </asp:RadioButtonList>
        <br />
        <br />
        Si tiramos una pluma y una pelota de goma desde la misma altura en condiciones de vacío, cuál llega antes?<br />
        <asp:RadioButtonList ID="rbtn_fisica" runat="server">
            <asp:ListItem Value="0">La pelota</asp:ListItem>
            <asp:ListItem Value="0">La pluma</asp:ListItem>
            <asp:ListItem Value="1">Caerán a la vez</asp:ListItem>
        </asp:RadioButtonList>
        <br />
        <asp:Label ID="lbl_resultado" runat="server"></asp:Label>
        <br />
        <br />
        <asp:Button ID="Button1" runat="server" OnClick="Button1_Click" Text="Comprobar" />
    
    </div>
    </form>
</body>
</html>
