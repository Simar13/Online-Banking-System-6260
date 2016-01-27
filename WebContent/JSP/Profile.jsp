<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" import="java.util.*" import="DAOImpl.CustomerDaoImpl" 
import="Bean.Customer" import="BL.PreferenceManager" errorPage="" %>
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
.style1 {
	color: #333333
}
-->
</style>
<link href="Colour" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
.style2 {color: #FF0000}
-->
</style>
</head>

<body>
<form id="form1" name="form1" method="post" action="/Online-Banking-System/updateAddress" onsubmit="return validateform()">
<table width="100%" height="622" border="0">
 <div> <tr>
    <td height="118" bgcolor="#F3F4EF" ><table width="1026" height="122" border="0">
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
  </div>
  <tr align="center" >
    <td height="407" bgcolor="#F3F4EF"><p>&nbsp;</p>
      <table width="1024" border="0">
      <tr>
        <td width="503" align="center"><span class="style1"><a href="/Online-Banking-System/updateAddress">View my profile</a></span></td>
        <td width="505" align="center"><span class="style1"><a href="/Online-Banking-System/passwordChange">Change Password</a></span></td>
      </tr>
    </table>
      <c:if test="${!empty error}">
				<div style="padding-bottom:15px; padding-top:15px; padding-left:45px; padding-right:15px; float:none;display: block;" class="error">${error}</div>
		</c:if>
      <table width="532" border="0" align="center">
      <% 		String nric ="cst1";
  			CustomerDaoImpl customerDaoImpl = new CustomerDaoImpl();
  			PreferenceManager mgr=new PreferenceManager();
  			Customer customer=mgr.findCustomer(nric); %>
      <tr>
        <td align="center"><span class="style2">Profile</span></td>
        <td align="center">&nbsp;</td>
      </tr>
      <tr>
        <td width="257" align="center">Name</td>
        <td width="259" align="center"><label>
          <input type="text" name="name" id="name" readonly="readonly" value="<%=customer.getName() %>"/>
        </label></td>
      </tr>
      <tr>
        <td align="center">Address</td>
        <td align="center"><label>
          <input type="text" name="address" id="address" value="<%=customer.getAddress() %>"/>
        </label></td>
      </tr>
      <tr>
        <td align="center">Date Of Birth</td>
        <td align="center"><label>
          <input type="text" name="dateOfBirth" id="dateOfBirth" readonly="readonly" value="<%=customer.getDateOfBirth() %>"/>
        </label></td>
      </tr>
      <tr>
        <td align="center">Nationality</td>
        <td align="center"><label>
          <input type="text" name="nationality" id="nationality" readonly="readonly" value="<%=customer.getNationality() %>" />
        </label></td>
      </tr>
      <tr>
        <td align="center">Gender</td>
        <td align="center"><label>
          <input name="gender" type="text" id="gender" value="<%=customer.getGender() %>" maxlength="1" readonly="readonly" />
        </label></td>
      </tr>
      <tr>
        <td align="center">Userid</td>
        <td align="center"><label>
          <input type="text" name="userid" id="userid" readonly="readonly" value="<%=customer.getUserid() %>" />
        </label></td>
      </tr>
      <tr>
        <td align="center">Date Of Joining</td>
        <td align="center"><label>
          <input type="text" name="dateofjoining" id="dateofjoining" readonly="readonly" value="<%=customer.getDateOfJoining() %>"/>
        </label></td>
      </tr>
      <tr>
        <td align="center">Email</td>
        <td align="center"><label>
          <input type="text" name="Email" id="Email" value="<%=customer.getEmail() %>" />
        </label></td>
      </tr>
      <tr>
        <td align="center">Phone Number</td>
        <td align="center"><input name="phonenumber" type="text" id="phonenumber"  value="<%=customer.getPhone() %>" maxlength="10"/></td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td align="center"><label>
          <input name="profile" type="submit" class="CsButton" id="profile" value="Submit" />
        </label></td>
      </tr>
      <c:if test="${!empty error}">
        <div style="padding-bottom:15px; padding-top:15px; padding-left:45px; padding-right:15px; float:none;display: block;" class="error">${error}</div>
      </c:if>
    </table></td>
  </tr>
  <tr>
    <td height="21" bgcolor="#FF0000">&nbsp;</td>
  </tr>
</table>
</form>
<script>
	function validateform(){  
var Email=document.form1.Email.value;
var phonenumber=document.form1.phonenumber.value;
var regularExpression = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;    
  
if (Email==null || Email==""){  
  alert("Please Entre the user id");  
  return false;   
}
else if (!regularExpression.test(Email)){ 
       alert("The Email should be in desired format like abc@efg.com");
	    return false; 
		}
else if (phonenumber==null || phonenumber==""){  
  alert("Please Entre the user id");  
  return false;   
}
 else if (isNaN(phonenumber)){  
  alert("Please Entre digit");  
  return false;   
}

}
	
</script>

</body>
</html>
