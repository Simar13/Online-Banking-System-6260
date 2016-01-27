<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
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
.CsButton {font-family: "Times New Roman", Times, serif;
	font-size: 14px;
	font-style: italic;
	font-weight: bold;
	color: #FFFFFF;
	background-color: #FF0000;
}
.style2 {color: #FF0000}
-->
</style>
</head>

<body>
<form id="form1" name="form1" method="post" action="/Online-Banking-System/forgetPassword" onsubmit="return validateform()">
<table width="100%" height="473" border="0">
 <div> 
   <tr>
     <td height="118" bgcolor="#F3F4EF"><table width="1026" height="122" border="0">
         <tr>
           <td width="501" height="116"><table width="477" height="104" border="0" align="center">
               <tr >
                 <td width="230" height="98"><img src="../../../../Desktop/Project/Online-Banking-System/WebContent/Resources/Images/logo.jpg" width="95" height="95" align="right" /></td>
                 <td width="231" align="center"><strong><font color="#FF0000" size="+2">StudentBankOfCanada</font></strong></td>
               </tr>
           </table></td>
           <td width="497">&nbsp;</td>
         </tr>
     </table></td>
   </tr>
   <tr>
     <td height="28" bgcolor="#FF0000">&nbsp;</td>
   </tr>
   <tr>
     <td height="28" bgcolor="#F0F0F0" class="cs1">&nbsp;</td>
   </tr>
  </div>
  
  <tr >
    <td height="253" bgcolor="#F3F4EF" ><p>&nbsp;</p>
    <table width="494" border="0" align="center">
      <tr>
        <td width="239" class="style2">Reset Password</td>
        <td width="239">&nbsp;</td>
      </tr>
      <tr>
        <td>User ID</td>
        <td><label>
          <input type="text" name="userid" id="userid" />
        </label></td>
      </tr>
    </table>
      <p>&nbsp;</p>
      <table width="200" border="0" align="center">
        <tr>
          <td align="center"><label>
          <input name="TransferB2" type="submit" class="CsButton" id="TransferB2" value="Submit" />
          </label></td>
        </tr>
      </table>
      <c:if test="${!empty error}">
				<div style="padding-bottom:15px; padding-top:15px; padding-left:45px; padding-right:15px; float:none;display: block;" class="error">${error}</div>
			</c:if></td>
  </tr>
  <tr>
    <td height="29" bgcolor="#FF0000">&nbsp;</td>
  </tr>
</table>
</form>
<script>
	function validateform(){  
var userid=document.form1.userid.value;
var regularExpression = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{8,12}$/g;    
  
if (userid==null || userid==""){  
  alert("Please Entre the user id");  
  return false;   
}
else if (!regularExpression.test(userid)){ 
       alert("The userid is not in specified format as given by bank");
	return false; 
		}
}

</script>
</body>
</html>
