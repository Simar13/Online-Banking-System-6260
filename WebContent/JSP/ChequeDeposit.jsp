<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" import="java.util.*" import="DAOImpl.CustomerDaoImpl" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>
<style type="text/css">
<!--
.cs1 {
	font-family: "Times New Roman", Times, serif;
	font-size: 14px;
	font-style: italic;
	font-weight: bold;
	color: #FFFFFF;
}
.style1 {
	color: #333333
}
-->
</style>
<link href="Colour" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
.style2 {color: #FF0000}
.CsButton {	font-family: "Times New Roman", Times, serif;
	font-size: 14px;
	font-style: italic;
	font-weight: bold;
	color: #FFFFFF;
	background-color: #FF0000;
}
-->
</style>
</head>

<body>
<form id="form1" name="form1" enctype="multipart/form-data"  method="post" action="/Online-Banking-System/deposit">
<table width="1032" height="622" border="0">
 <div> <tr>
    <td height="118" background="../download.png"><table width="1026" height="122" border="1">
      <tr>
        <td width="501" height="116"><table width="477" height="104" border="0" align="center">
          <tr >
            <td width="230" height="98"><img src="../logo.jpg" width="95" height="95" align="right" /></td>
            <td width="231" align="center"><strong><font color="#FF0000" size="+2">StudentBankOfCanada</font></strong></td>
          </tr>
        </table></td>
        <td width="497"><table width="424" height="110" border="0" align="right">
          <tr align="right">
            <td width="82" valign="top"><p onclick="Help()">Help</p></td>
            <td width="103" valign="top"><p onclick="Contactus()">Contact us</p></td>
            <td width="146" valign="top"><p onclick="Profile()">Manage my Account</p></td>
            <td width="75" valign="top"><font color="#FF0000"><p onclick="Signout()">Sign out</p></font></td>
            </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="28" background="../imag1.jpg"><table width="726" border="1" align="center">
      <tr>
        <td width="235" class="style1"><p  id="demo"  onclick="Changecolour()">Account</p></td>
        <td width="235" class="style1"><p  id="demo1" onclick="Changecolour1()">Bill Payment</p></td>
        <td width="234" class="style1"><p  id="demo2" onclick="Changecolour2()">Transfer</p></td>
      </tr>
    </table></td>
  </tr></div>
  <tr>
    <td height="28" background="../bar.jpg" class="cs1"><table width="724" border="1" align="center">
      <tr align="center">
        <td width="235" class="style1"><p onclick="Acct()">Deposit</p></td>
        <td width="236" class="style1"><p onclick="AcctD()">Loan</p></td>
        <td width="231" class="style1">Mortgage</td>
      </tr>
    </table></td>
  </tr>
  <tr background="../download.png">
    <td height="407" align="center"><table width="444" border="1">
      <tr>
        <td width="215"><span class="style2">Deposit Cheque</span></td>
        <td width="213">&nbsp;</td>
      </tr>
      <tr>
        <td align="center">First Name</td>
        <td align="center"><label>
          <input name="firstname" id="firstname">
          </input>
        </label></td>
      </tr>
      <tr>
      <tr>
        <td align="center">Last Name</td>
        <td align="center"><label>
          <input name="lastname" id="lastname">
          </input>
        </label></td>
      </tr>
      <tr>
      <tr>
        <td align="center">Account Number</td>
        <td align="center"><label>
          <select name="account" id="account">
           <% String nric ="cst1";
  			CustomerDaoImpl customerDaoImpl = new CustomerDaoImpl();
    		
    		ArrayList<String> accountTypeList = new ArrayList<String>();
    		try {
    			accountTypeList = customerDaoImpl.getAccountsByCustomerID(nric);
    		
    			
    		} catch (SQLException e1) {
    			// TODO Auto-generated catch block
    			e1.printStackTrace();
    		}
            
          		  Iterator itracc = accountTypeList.iterator();
           			 while(itracc.hasNext()) 
					
					{
						String acc = (String) itracc.next(); 
			%>
					<option value="<%=acc %>"><%=acc %></option>
			<%
					}
			%>
          </select>
        </label></td>
      </tr>
      <tr>
        <td align="center">Amount</td>
        <td align="center"><label>
          <input type="text" name="amount" id="amount" />
        </label></td>
      </tr>
      <tr>
        <td align="center">Cheque Number</td>
        <td align="center"><label>
          <input type="text" name="cheqnumber" id="cheqnumber" />
        </label></td>
      </tr>
      <tr>
        <td align="center">Bank Name</td>
        <td align="center"><label>
          <input type="text" name="bankname" id="bankname" />
        </label></td>
      </tr>
      <tr>
        <td align="center">Cheque Image</td>
        <td><input type="file" name="file"></td>
      </tr>
      <c:if test="${!empty error}">
				<div style="padding-bottom:15px; padding-top:15px; padding-left:45px; padding-right:15px; float:none;display: block;" class="error">${error}</div>
			</c:if>
      <tr>
        <td>&nbsp;</td>
        <td align="center">&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td align="center"><input name="acctdetail" type="submit" class="CsButton" id="acctdetail" value="Submit" /></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="21" background="../imag1.jpg">&nbsp;</td>
  </tr>
</table>
</form>
<script>
function Changecolour() {
    document.getElementById("demo").style.color = "blue";
	window.location = "Account.jsp"
	}
	
	function Changecolour1() {
    document.getElementById("demo1").style.color = "blue";
	window.location = "pay_bill.jsp"
	}
	
function Changecolour2() {
    document.getElementById("demo2").style.color = "blue";
	window.location = "Transfer.jsp"
	}
	function Help() {
    
	window.location = "Help.jsp"
	}
	function Contactus() {
    
	window.location = "Contactus.jsp"
	}
	function Profile() {
    
	window.location = "Profile.jsp"
	}
	function Signout() {
    
	window.location = "Login.jsp"
	}
	function Acct() {
    
	window.location = "Account.jsp"
	}
	function AcctD() {
    
	window.location = "Account_details.jsp"
	}
	
</script>

</body>
</html>
