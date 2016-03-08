<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Default5.aspx.cs" Inherits="Default5" %>

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
        <asp:RequiredFieldValidator ID="rq_usuario" runat="server" ControlToValidate="txt_usuario" ErrorMessage="Es obligado poner usuario">*</asp:RequiredFieldValidator>
        <br />
        <br />
        Clave:
        <asp:TextBox ID="txt_clave" runat="server" TextMode="Password"></asp:TextBox>
        <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" ControlToValidate="txt_clave" ErrorMessage="Es obligado poner una pass">*</asp:RequiredFieldValidator>
        <br />
        <br />
        <asp:Button ID="btn_validar" runat="server" Text="Button" />
        <br />
        <br />
        <asp:ValidationSummary ID="ValidationSummary1" runat="server" />
        <br />
    
    </div>
    </form>
</body>
</html>
