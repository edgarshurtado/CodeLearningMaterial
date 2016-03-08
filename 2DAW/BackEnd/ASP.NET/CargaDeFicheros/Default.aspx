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
    
        Seleccione Fichero<br />
        <asp:FileUpload ID="FileUpload1" runat="server" />
        <br />
        <br />
        <asp:Button ID="btn_subir" runat="server" OnClick="btn_subir_Click" Text="Subir" />
        <br />
        <br />
        <asp:Label ID="lbl_resultado" runat="server"></asp:Label>
    
    </div>
    </form>
</body>
</html>
