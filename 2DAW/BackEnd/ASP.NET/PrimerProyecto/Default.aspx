<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Default.aspx.cs" Inherits="_Default" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <asp:Label ID="lbl_hora" runat="server"></asp:Label>
        <br />
        <br />
        <br />
        <br />
        <asp:Label ID="lbl_hola" runat="server"></asp:Label>
        <p>
            <asp:Button ID="btn_hola" runat="server" OnClick="btn_hola_Click" Text="Click aquí" />
        </p>
    </form>
</body>
</html>
