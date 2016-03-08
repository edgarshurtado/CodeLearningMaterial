<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Default2.aspx.cs" Inherits="Default2" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
        Edad
        <asp:TextBox ID="txt_edad" runat="server"></asp:TextBox>
&nbsp;<asp:RangeValidator ID="RangeValidator1" runat="server" ControlToValidate="txt_edad" ErrorMessage="RangeValidator" MaximumValue="90" MinimumValue="10" Type="Integer">La edad debe estar entre 10 y 90 años</asp:RangeValidator>
        <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" ControlToValidate="txt_edad" ErrorMessage="RequiredFieldValidator">No puede estar vacío</asp:RequiredFieldValidator>
        <br />
        <br />
        <asp:Button ID="btn_confirmar" runat="server" OnClick="btn_confirmar_Click" Text="Confirmar" />
    </div>
    </form>
</body>
</html>
