<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Default3.aspx.cs" Inherits="Default3" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
    
        Múltiplo de 5<br />
        <asp:TextBox ID="txt_numero" runat="server"></asp:TextBox>
        <asp:CustomValidator ID="CustomValidator1" runat="server" ControlToValidate="txt_numero" ErrorMessage="CustomValidator" OnServerValidate="CustomValidator1_ServerValidate">No es múltiplo de 5</asp:CustomValidator>
        <br />
        <asp:Button ID="btn_validar" runat="server" OnClick="btn_validar_Click" Text="Validar" />
        <br />
    
    </div>
    </form>
</body>
</html>
