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
    
        <asp:Label ID="lbl_primerNumero" runat="server" Text="Dame el primer valor"></asp:Label>
&nbsp;<asp:TextBox ID="txt_1" runat="server"></asp:TextBox>
        <br />
        <br />
        <asp:Label ID="lbl_segundoNunero" runat="server" Text="Dame el segundo valor"></asp:Label>
&nbsp;
        <asp:TextBox ID="txt_2" runat="server"></asp:TextBox>
        <br />
        <br />
        <asp:CheckBox ID="chk_sumar" runat="server" Text="Sumar" />
        <br />
        <asp:CheckBox ID="chk_restar" runat="server" Text="Restar" />
        <asp:CheckBoxList ID="lst_operaciones" runat="server" Height="65px" OnSelectedIndexChanged="CheckBoxList1_SelectedIndexChanged">
            <asp:ListItem>Multiplicar</asp:ListItem>
            <asp:ListItem>Dividir</asp:ListItem>
        </asp:CheckBoxList>
        <br />
        <br />
        <br />
        <br />
        <asp:Button ID="btn_calcular" runat="server" OnClick="btn_calcular_Click" Text="Calcula" />
        <br />
        <br />
        <asp:Label ID="lbl_resultado" runat="server"></asp:Label>
    
    </div>
    </form>
</body>
</html>
