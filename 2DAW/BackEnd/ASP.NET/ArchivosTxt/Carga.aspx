<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Carga.aspx.cs" Inherits="Carga" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
    
        <asp:Label ID="lbl_nombre" runat="server" Text="Nombre:"></asp:Label>
&nbsp;
        <asp:TextBox ID="txt_nombre" runat="server"></asp:TextBox>
        <br />
        <br />
        <asp:Label ID="lbl_pais" runat="server" Text="País"></asp:Label>
&nbsp;
        <asp:TextBox ID="txt_pais" runat="server"></asp:TextBox>
        <br />
        <br />
        <asp:Label ID="lbl_comentarios" runat="server" Text="Comentarios:"></asp:Label>
    
        <br />
        <asp:TextBox ID="txt_comentarios" runat="server" Height="109px" TextMode="MultiLine" Width="287px"></asp:TextBox>
        <br />
        <br />
        <asp:Button ID="btn_confirmar" runat="server" OnClick="btn_confirmar_Click" Text="Confirmar" />
        <br />
        <br />
        <asp:Label ID="lbl_mensaje" runat="server"></asp:Label>
        <br />
        <br />
        <asp:HyperLink ID="HyperLink1" runat="server" NavigateUrl="~/Default.aspx">Volver</asp:HyperLink>
    
    </div>
    </form>
</body>
</html>
