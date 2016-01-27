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
.style1 {color: #FF0000}
.style2 {color: #0000FF}
.style3 {
	font-size: 12;
	color: #0000FF;
}
.cs1 {	font-family: "Times New Roman", Times, serif;
	font-size: 14px;
	font-style: italic;
	font-weight: bold;
	color: #FFFFFF;
}
.style4 {	color: #333333
}
-->
</style>
</head>

<body>
<form id="form1" name="form1" method="post" action="/Online-Banking-System/passwordChange" onsubmit="return validateform()">
<table width="100%" height="555" border="0">
  <tr>
    <td height="118" bgcolor="#F3F4EF"><table width="1026" height="122" border="0">
        <tr>
          <td width="501" height="116"><table width="477" height="104" border="0" align="center">
              <tr >
                <td width="230" height="98"><img src="../../../../Desktop/Project/Online-Banking-System/WebContent/Resources/Images/logo.jpg" width="95" height="95" align="right" /></td>
                <td width="231" align="center"><strong><font color="#FF0000" size="+2">StudentBankOfCanada</font></strong></td>
              </tr>
          </table></td>
          <td width="497"><table width="424" height="110" border="0" align="right">
              <tr align="right">
                <td width="146" valign="top"><p onclick="Profile()"><a href="/Online-Banking-System/updateAddress">Manage my Account</a></p></td>
                <td width="75" valign="top"><font color="#FF0000">
                  <a href="/Online-Banking-System/Login?logout=true">Sign out</a>
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
        <td width="235" height="21" align="center" class="style4"><a href="/Online-Banking-System/Login" class="cs1">Account</a></td>
        <td width="235" align="center" class="style4"><a href="/Online-Banking-System/BillPayee" class="cs1">Bill Payment</a></td>
        <td width="234" align="center" class="style4"><a href="/Online-Banking-System/transferInfoController" class="cs1">Transfer</a></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="28" bgcolor="#F0F0F0" class="cs1"><table width="724" border="0" align="center">
      <tr align="center">
        <td width="235" class="style4"><a href="/Online-Banking-System/TransactionController">Account Details</a></td>
        <td width="236" class="style4"><a href="/Online-Banking-System/LoanRequest?action=loan">Loan </a></td>
        <td width="231" class="style4"><a href="/Online-Banking-System/MortgageRequest?action=mortgage">Mortgage </a></td>
      </tr>
    </table></td>
  </tr>
  
  
  <tr >
    <td height="253" bgcolor="#F3F4EF"><p>&nbsp;</p>
    <table width="494" border="0" align="center">
      <tr>
        <td width="239" class="style1">Change  Password</td>
        <td width="239">&nbsp;</td>
      </tr>
      <tr>
        <td>Old Password</td>
        <td><label>
          <input type="password" name="oldPassword" id="oldPassword" />
        </label></td>
      </tr>
      <tr>
        <td>New Password</td>
        <td><input type="password" name="newPassword" id="newPassword" /></td>
      </tr>
      <tr>
        <td>Re Enter New Password</td>
        <td><input type="password" name="rePassword" id="rePassword" /></td>
      </tr>
    </table>
      <p>&nbsp;</p>
      <table width="200" border="0" align="center">
        <tr>
          <td align="center"><label>
            <input name="TransferB" type="submit" class="CsButton" id="TransferB" value="Submit" />
          </label></td>
        </tr>
      </table>
      <c:if test="${!empty error}">
				<div style="padding-bottom:15px; padding-top:15px; padding-left:45px; padding-right:15px; float:none;display: block;" class="error">${error}</div>
			</c:if>
      <p class="style3">&nbsp;</p></td>
  </tr>
  <tr>
    <td height="31" background="../Resources/Images/imag1.jpg">&nbsp;</td>
  </tr>
</table>
</form>
<script>
function Help() {
    
	window.location = "HelpLogin.jsp"
	}
	function Contactus() {
    
	window.location = "ContactusLogin.jsp"
	}
		function validateform(){  
var oldPassword=document.form1.oldPassword.value; 
var newPassword=document.form1.newPassword.value; 
var rePassword=document.form1.rePassword.value;    
  var regularExpression = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^&*()_+])[A-Za-z\d][A-Za-z\d!@#$%^&*()_+]{8,20}$/g;
  
   if (oldPassword==null || oldPassword==""){  
  alert("Please Entre the oldpassword");  
  return false;   
}
else if (newPassword==null || newPassword==""){  
  alert("Please Entre the new password");  
  return false;   
}
else if (rePassword==null || rePassword==""){  
  alert("Please re enter the password");  
  return false;   
}
else if (newPassword!=rePassword){  
  alert("Rentre password do not matches to new password");  
  return false;   
}
 else if (!regularExpression.test(oldPassword)){ 
       alert('The old password is not in specified format it should include atleast one letter,number and special character from !@#$%^&*()_+ and Its first letter should be letter');
	return false; 
		}
		else if (!regularExpression.test(newpassword)){ 
       alert('The new password should include atleast one letter,number and special character from !@#$%^&*()_+ and Its first letter should be letter');
	return false; 
		}

else if (!regularExpression.test(rePassword)){ 
       alert('The re entered password should include atleast one letter,number and special character from !@#$%^&*()_+ and Its first letter should be letter');
	return false; 
		}
}
	</script>
</body>
</html>
