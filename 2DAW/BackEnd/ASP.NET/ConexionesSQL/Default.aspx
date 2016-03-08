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
    
        <asp:HyperLink ID="HyperLink1" runat="server" NavigateUrl="~/Alta.aspx">Alta usuario</asp:HyperLink>
&nbsp;
        <asp:HyperLink ID="HyperLink2" runat="server" NavigateUrl="~/Consulta.aspx">Consulta usuario</asp:HyperLink>
&nbsp;
        <asp:HyperLink ID="HyperLink3" runat="server" NavigateUrl="~/Baja.aspx">Baja Usuario</asp:HyperLink>
&nbsp;
        <asp:HyperLink ID="HyperLink4" runat="server" NavigateUrl="~/Modificacion.aspx">Modificacion</asp:HyperLink>
    
    </div>
    </form>
</body>
</html>
