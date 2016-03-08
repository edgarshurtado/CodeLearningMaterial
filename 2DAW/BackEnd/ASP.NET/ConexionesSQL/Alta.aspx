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
    
        el
    
        Nombre:
        <asp:TextBox ID="txt_nombre" runat="server"></asp:TextBox>
        <br />
        <br />
        Clave:
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
        <asp:Label ID="lbl_resultado" runat="server"></asp:Label>
    
    </div>
    </form>
</body>
</html>
