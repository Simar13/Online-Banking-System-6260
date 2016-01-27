<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>
<style type="text/css">
<!--
.CsButton {
	font-family: "Times New Roman", Times, serif;
	font-size: 14px;
	font-style: italic;
	font-weight: bold;
	color: #FFFFFF;
	background-color: #FF0000;
}
.cs1 {
	font-family: "Times New Roman", Times, serif;
	font-size: 14px;
	font-style: italic;
	font-weight: bold;
	color: #FFFFFF;
}
.style1 {color: #333333}
.style2 {color: #FF0000}
.style3 {
	color: #0000FF;
	font-size: 12px;
}
-->
</style>
</head>

<body>
<form id="form1" name="form1" method="post" action="/Online-Banking-System/AddRecipient" onsubmit="return validateform()">
<table width="100%" height="527" border="0">
  <div> 
    <tr>
      <td height="118" bgcolor="#F3F4EF"><table width="1026" height="122" border="0">
          <tr>
            <td width="501" height="116"><table width="477" height="104" border="0" align="center">
                <tr >
                  <td width="230" height="98"><img src="../Resources/Images/logo.jpg" width="95" height="95" align="right" /></td>
                  <td width="231" align="center"><strong><font color="#FF0000" size="+2">StudentBankOfCanada</font></strong></td>
                </tr>
            </table></td>
            <td width="497"><table width="424" height="110" border="0" align="right">
                <tr align="right">
                  <td width="146" valign="top"><p onclick="Profile()"><a href="/Online-Banking-System/updateAddress">Manage my Account</a></p></td>
                  <td width="75" valign="top"><font color="#FF0000"> <a href="/Online-Banking-System/Login?logout=true">Sign out</a>
                        <p onclick="Signout()">&nbsp;</p>
                  </font></td>
                </tr>
            </table></td>
          </tr>
      </table></td>
    </tr>
    <tr>
      <td height="28" bgcolor="#FF0000"><table width="726" border="0" align="center">
          <tr>
            <td width="235" height="21" align="center" class="style1"><a href="/Online-Banking-System/Login" class="cs1">Account</a></td>
            <td width="235" align="center" class="style1"><a href="/Online-Banking-System/BillPayee" class="cs1">Bill Payment</a></td>
            <td width="234" align="center" class="style1"><a href="/Online-Banking-System/transferInfoController" class="cs1">Transfer</a></td>
          </tr>
      </table></td>
    </tr>
    <tr>
      <td height="28" bgcolor="#F0F0F0" class="cs1"><table width="724" border="0" align="center">
          <tr align="center">
            <td width="235" class="style1"><a href="/Online-Banking-System/TransactionController">Account Details</a></td>
            <td width="236" class="style1"><a href="/Online-Banking-System/LoanRequest?action=loan">Loan </a></td>
            <td width="231" class="style1"><a href="/Online-Banking-System/MortgageRequest?action=mortgage">Mortgage </a></td>
          </tr>
      </table></td>
    </tr>
  </div>
  
  <tr>
    <td height="306" bgcolor="#F3F4EF"><table width="420" border="0" align="center">
        <tr>
          <td width="201"><span class="style2">Add Recipient</span></td>
          <td width="203">&nbsp;</td>
        </tr>
        <tr>
          <td>Name</td>
          <td><label>
            <input type="text" name="name" id="Recname" />
          </label></td>
        </tr>
        <tr>
          <td>Email Address</td>
          <td><label>
            <input type="text" name="email" id="email" />
          </label></td>
        </tr>
      </table>
      <p>&nbsp;</p>
      <table width="200" border="0" align="center">
        <tr>
          <td align="center"><label>
            <input name="TransferB" type="submit" class="CsButton" id="TransferB" value="Submit" />
          </label></td>
        </tr>
        <c:if test="${!empty error}">
		<div style="padding-bottom:15px; padding-top:15px; padding-left:45px; padding-right:15px; float:none;display: block;" class="error">${error}</div>
	</c:if>
      </table>
     <c:if test="${!empty error}">
				<div style="padding-bottom:15px; padding-top:15px; padding-left:45px; padding-right:15px; float:none;display: block;" class="error">${error}</div>
			</c:if></td>
  </tr>
  <tr>
    <td height="30" bgcolor="#FF0000">&nbsp;</td>
  </tr>
</table>
</form>
<script>
function validateform(){  
var email=document.form1.email.value;
var name=document.form1.name.value;
var regularExpression = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;    
  
if (email==null || email==""){  
  alert("Please Entre the email ");  
  return false;   
}
else if (!regularExpression.test(email)){ 
       alert("The Email should be in desired format like abc@efg.com");
	    return false; 
		}
		else if (name==null || name==""){  
  alert("Please Entre the name");  
  return false;   
}
else  if (!/^[a-zA-Z-,]+(\s{0,1}[a-zA-Z-, ])*$/g.test(name)) {
        alert("Invalid characters in name");
        return false;
    } 
	}
</script>
</body>
</html>
