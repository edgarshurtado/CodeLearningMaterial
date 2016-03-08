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
    
        Nombre:
        <asp:TextBox ID="txt_nombre" runat="server"></asp:TextBox>
        <asp:RequiredFieldValidator ID="rqd_nombre" runat="server" ControlToValidate="txt_nombre" ErrorMessage="Debe introducir un nombre"></asp:RequiredFieldValidator>
        <br />
        <br />
        Apellido:
        <asp:TextBox ID="txt_apellido" runat="server"></asp:TextBox>
        <asp:RequiredFieldValidator ID="rqd_apellido" runat="server" ControlToValidate="txt_apellido" ErrorMessage="Debe introducir un Apellido"></asp:RequiredFieldValidator>
        <br />
        <br />
        <asp:Button ID="Button1" runat="server" Text="Enviar" />
    
    </div>
    </form>
</body>
</html>
