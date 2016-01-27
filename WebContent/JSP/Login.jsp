<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" >
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
-->
	
</style>
</head>

<body >
<form id="form1" name="form1" method="post" action="/Online-Banking-System/Login" onsubmit="return validateform()">
<table width="100%" height="529"  border="0">
  <tr>
    <td width="1439" height="118" bgcolor="#F3F4EF"><table width="1026" height="122" border="0">
      <tr>
        <td width="501" height="116"><table width="477" height="104" border="0" align="center">
          <tr >
            <td width="230" height="98"><img src="../Resources/Images/logo.jpg" width="95" height="95" align="right" /></td>
            <td width="231" align="center"><strong><font color="#FF0000" size="+2">StudentBankOfCanada</font></strong></td>
          </tr>
        </table></td>
        <td width="497">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="37" bgcolor="#FF0000" >&nbsp;</td>
  </tr>
  <tr>
    <td height="28" bgcolor="#F0F0F0" >&nbsp;</td>
  </tr>
  <tr >
    <td height="305" bgcolor="#F3F4EF" ><table width="718" height="146" border="0" align="center">
    <c:if test="${!empty message}">
				<div style="padding-bottom:15px; padding-top:15px; padding-left:45px; padding-right:15px; float:none;display: block;" class="error">${message}</div>
			</c:if>
      <tr>
        <td width="353" height="140"><table width="299" height="107" border="0" align="center">
            <tr>
              <td width="143">User id Number:</td>
              <td width="146"><label>
                <input name="id" type="text" id="id" align="middle"  />
                </label>              </td>
            </tr>
            <tr>
              <td height="25">Password:</td>
              <td><input type="password" name="pwd" id="pwd"  /></td>
            </tr>
            <tr>
              <td>&nbsp;</td>
              <td ><font size="-1" color="#3366FF"><a href="Reset password.jsp"><font size="-1" color="#3366FF"><a href="/Online-Banking-System/forgetPassword">Forgot password</a></td>
            </tr>
            <tr>
              <td>&nbsp;</td>
              <td align="center"><font color="#0000FF">
                <label>
                <input name="SignIn" type="submit" class="CsButton" id="SignIn" style="background-color:#FF0000" value="Sign In" />
                </label>
              </font></td>
            </tr>
        </table></td>
        <td width="349" align="center" valign="middle"><h3>&nbsp;</h3>
            </td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="23" bgcolor="#FF0000">&nbsp;</td>
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
var name=document.form1.id.value;  
var password=document.form1.pwd.value; 
var regularExpression = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{8,12}$/g; 
var regularExpression1 = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^&*()_+])[A-Za-z\d][A-Za-z\d!@#$%^&*()_+]{8,20}$/g;
  
if (name==null || name==""){  
  alert("Userid can't be blank");  
  return false;   
}
else if(password==null || password==""){  
	  alert("Password can't be blank");  
	  return false;  
	  }
	  else if (!regularExpression.test(name)){ 
       alert("The userid is not in specified format as given by bank");
	return false; 
		}
		else if (!regularExpression1.test(password)){ 
       alert('The password is not in specified format as given by bank it should include atleast one letter,number and special character from !@#$%^&*()_+ and Its firts letter should be letter');
	return false; 
		}  

}  
	</script>
</body>
</html>
