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
-->
</style>
</head>

<body>
<form id="form1" name="form1" method="post" action="/Online-Banking-System/forgetPasswordVerify" onsubmit="return validateform()">
<table width="100%" height="647" border="0">
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
    <td height="253" bgcolor="#F3F4EF"><p>&nbsp;</p>
      <table width="493" height="209" border="0" align="center">
      <tr>
        <td><label></label></td>
      </tr>
      <tr>
        <td width="239" class="style1">Answer the security questions</td>
        <td width="239">&nbsp;</td>
      </tr>
      <tr>
        <td><label>
          <input type="text" name="question1" id="question1" size="40" readonly="readonly" value='<%=request.getAttribute("question1")%>'></input>
        </label></td>
        <td><label>
          <input type="text" name="answer1" id="answer1" />
        </label></td>
      </tr>
      <tr>
        <td height="30"><input type="text" name="question2" id="question3" size="40" readonly="readonly" value='<%=request.getAttribute("question2")%>'></input></td>
        <td><input type="text" name="answer2" id="answer2" /></td>
      </tr>
      <tr>
        <td height="30" align="center">New Password</td>
        <td><input type="password" name="newpassword" id="newpassword" /></td>
      </tr>
      <tr>
        <td height="32" align="center"><label>Re Entre New Password</label></td>
        <td><label>
          <input type="password" name="repassword" id="repassword" />
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
      </table>
      <c:if test="${!empty error}">
				<div style="padding-bottom:15px; padding-top:15px; padding-left:45px; padding-right:15px; float:none;display: block;" class="error">${error}</div>
			</c:if>
      <p class="style3">&nbsp;</p></td>
  </tr>
  <tr>
    <td height="28" bgcolor="#FF0000">&nbsp;</td>
  </tr>
</table>
</form>
<script>
	function validateform(){  
var answer1=document.form1.answer1.value; 
var answer2=document.form1.answer2.value; 
var newpassword=document.form1.newpassword.value; 
var repassword=document.form1.repassword.value;    
 var pass = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^&*()_+])[A-Za-z\d][A-Za-z\d!@#$%^&*()_+]{8,20}$/g;
  
if (answer1==null || answer1==""){  
  alert("Please Entre the answer1");  
  return false;   
}
else if (answer2==null || answer2==""){  
  alert("Please Entre the answer2");  
  return false;   
}
else if (newpassword==null || newpassword==""){  
  alert("Please Entre the new password");  
  return false;   
}
else if (!pass.test(newpassword)){ 
       alert('The new password should include atleast one letter,number and special character from !@#$%^&*()_+ and Its first letter should be alphanumeric');
	return false; 
		}
else if (repassword==null || repassword==""){  
  alert("Please re enter the password");  
  return false;   
}
else if (newpassword!=repassword){  
  alert("Rentre password do not matches to new password");  
  return false;   
}


}
</script>
</body>
</html>
