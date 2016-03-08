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
    <iframe width="560" height="315" src="https://www.youtube.com/embed/D72rugnk5kE" frameborder="0" allowfullscreen></iframe>
        <br />
        <br />
        <asp:ScriptManager ID="ScriptManager1" runat="server">
        </asp:ScriptManager>
        <asp:UpdatePanel ID="UpdatePanel1" runat="server">
            <ContentTemplate>
                <asp:Button ID="btn_comentarios" runat="server" OnClick="btn_comentarios_Click" Text="Ver Comentarios" />
<br />
                <asp:Label ID="lbl_comentarios" runat="server"></asp:Label>
<br />
            </ContentTemplate>
        </asp:UpdatePanel>
        <br />
        <br />
    </div>
    </form>
</body>
</html>
