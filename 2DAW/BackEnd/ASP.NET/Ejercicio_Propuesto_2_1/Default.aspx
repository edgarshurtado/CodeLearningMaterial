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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Apellido1:
        <asp:TextBox ID="txt_apellido1" runat="server"></asp:TextBox>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Apellido 2:
        <asp:TextBox ID="txt_apellido2" runat="server"></asp:TextBox>
        <br />
        <br />
        Fecha Nacimiento :
        <br />
        <asp:Calendar ID="cal_nacimiento" runat="server"></asp:Calendar>
        <br />
        <br />
        Estudios: <br />
        <br />
        <asp:TextBox ID="txt_estudios" runat="server" Height="192px" TextMode="MultiLine" Width="423px"></asp:TextBox>
        <br />
        <br />
        <br />
        Experiencia:<br />
        <asp:TextBox ID="txt_experiencia" runat="server" Height="192px" TextMode="MultiLine" Width="423px"></asp:TextBox>
        <br />
        <br />
        <asp:Button ID="Button1" runat="server" OnClick="Button1_Click" Text="Registrar" />
    
    </div>
    </form>
</body>
</html>
