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
<form id="form1" name="form1" method="post" action="/Online-Banking-System/AdminCreateUpdate" onsubmit="return validateform()">
<table width="100%" height="772" border="0">
 <div> 
   <tr>
     <td height="118" bgcolor="#F3F4EF"><table width="1061" height="122" border="0">
         <tr>
           <td width="510" height="116"><table width="500" height="104" border="0" align="center">
               <tr >
                 <td width="229" height="98"><img src="../Resources/Images/logo.jpg" width="95" height="95" align="right" /></td>
                 <td width="250" align="center"><strong><font color="#FF0000" size="+2">StudentBankOfCanada</font></strong></td>
               </tr>
           </table></td>
           <td width="541" align="right"><table width="424" height="110" border="0" align="right">
               <tr align="right">
                 <td width="146" valign="top"><p onclick="Profile()">&nbsp;</p></td>
                 <td width="75" valign="top"><font color="#FF0000"> <a href="/Online-Banking-System/Login?logout=true">Sign out</a> </font></td>
               </tr>
           </table></td>
         </tr>
     </table></td>
   </tr>
   <tr>
     <td height="25" bgcolor="#FF0000"><table width="946" border="0" align="center">
         <tr>
           <td width="108" align="center" class="style1"><a href="/Online-Banking-System/AdminSearchAccount" class="cs1">Search by Account</a></td>
           <td width="116" align="center" class="cs1"><a href="/Online-Banking-System/AdminSearchCustomer" class="cs1">Search By Customer Id</a></td>
           <td width="126" align="center" class="cs1"><a href="/Online-Banking-System/AdminSearchTransaction" class="cs1">Search Transactions</a></td>
           <td width="113" align="center" class="cs1"><a href="/Online-Banking-System/AdminCreateUpdate" class="cs1">Create Customer</a></td>
           <td width="113" align="center" class="cs1"><a href="/Online-Banking-System/AdminUpdateCustSearch" class="cs1">Update Customer</a></td>
           <td width="149" align="center" class="style1"><a href="/Online-Banking-System/AdminCustDeactivate" class="cs1">Deactivate Customer</a></td>
         </tr>
     </table></td>
   </tr>
   <tr>
     <td height="28" bgcolor="#F0F0F0" class="cs1"><table width="837" border="0" align="center">
         <tr>
           <td width="175" align="center" class="style1"><a href="/Online-Banking-System/AdminLoanAction?action=loanRequestAll" class="style1">Loan Request</a></td>
           <td width="173" align="center" class="style1"><a href="/Online-Banking-System/AdminSearchLoan" class="style1">Loan Details</a></td>
           <td width="179" align="center" class="style1"><a href="/Online-Banking-System/AdminMortgageAction?action=mortgageRequestAll" class="style1">Mortgage Request</a></td>
           <td width="292" align="center" class="style1"><a href="/Online-Banking-System/AdminSearchMortgage" class="style1">Mortgage Details</a></td>
         </tr>
     </table></td>
   </tr>
  </div>
  
  <tr>
    <td height="557" align="center" bgcolor="#F3F4EF"><c:if test="${!empty error}">
				<div style="padding-bottom:15px; padding-top:15px; padding-left:45px; padding-right:15px; float:none;display: block;" class="error">${error}</div>
			</c:if>
      <table width="738" border="0" align="center">
      <tr>
        <td width="236"><span class="style2">Create Customer</span></td>
        <td width="486">&nbsp;</td>
      </tr>
      <tr>
        <td>Customer ID</td>
        <td><label>
        <input type="text" name="nric" id="nric" />
        </label></td>
      </tr>
      <tr>
        <td>Name</td>
        <td><label>
          <input type="text" name="name" id="name" />
        </label></td>
      </tr>
      <tr>
        <td>Address</td>
        <td><input type="text" name="address" id="address" /></td>
      </tr>
      <tr>
        <td>Date Of Birth</td>
        <td><input type="text" name="dateofbirth" id="dateofbirth" />  yyyy-dd-mm</td>
      </tr>
      <tr>
        <td>Nationality</td>
        <td><input name="nationality" type="text" id="nationality" maxlength="10" /></td>
      </tr>
      <tr>
        <td>Gender</td>
        <td><input name="gender" type="text" id="gender" maxlength="1" /></td>
      </tr>
      <tr>
        <td>User id</td>
        <td><input type="text" name="userid" id="userid" /></td>
      </tr>
      <tr>
        <td>Password</td>
        <td><input type="password" name="password" id="password" /></td>
      </tr>
      <tr>
        <td>Date Of Joining</td>
        <td><input type="text" name="dateofjoining" id="dateofjoining" />yyyy-dd-mm</td>
      </tr>
      <tr>
        <td>Enter question 1 and answer</td>
        <td><label>
        <textarea name="quest1" id="quest1" cols="45" rows="2"></textarea>
        <input type="text" name="answer1" id="answer1" />
        </label></td>
      </tr>
      <tr>
        <td>Enter question 2 and answer</td>
        <td><textarea name="quest2" id="quest2" cols="45" rows="2"></textarea>
            <input type="text" name="answer2" id="answer2" /></td>
      </tr>
      <tr>
        <td>Email</td>
        <td><input type="text" name="email" id="email" /></td>
      </tr>
      <tr>
        <td>Phone</td>
        <td><input name="phone" type="text" id="phone" maxlength="10"></td>
      </tr>
      <tr>
        <td>User Type</td>
        <td><input name="usertype" type="text" id="usertype" maxlength="1" /></td>
      </tr>
      <tr>
        <td>Status</td>
        <td><input name="status" type="text" id="status" maxlength="1" /></td>
      </tr>
    </table>
      <p>&nbsp;</p>
      <table width="200" border="0" align="center">
        <tr>
          <td align="center"><label>
            <input name="Create" type="submit" class="CsButton" id="Create" value="Create" />
          </label></td>
        </tr>
    </table></td>
  </tr>
  <tr>
    <td height="21" bgcolor="#FF0000">&nbsp;</td>
  </tr>
</table>
<script>
	function validateform(){  
var nric=document.form1.nric.value;  
var name=document.form1.name.value;  
  var address=document.form1.address.value; 
  var dateofbirth=document.form1.dateofbirth.value; 
  var nationality=document.form1.nationality.value; 
  var gender=document.form1.gender.value; 
  var userid=document.form1.userid.value; 
  var password=document.form1.password.value; 
  var dateofjoining=document.form1.dateofjoining.value; 
  var quest1=document.form1.quest1.value; 
  var answer1=document.form1.answer1.value; 
  var quest2=document.form1.quest2.value; 
  var answer2=document.form1.answer2.value; 
  var email=document.form1.email.value; 
  var phone=document.form1.phone.value; 
  var usertype=document.form1.usertype.value; 
  var status=document.form1.status.value;
  var numL= /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{8,12}$/g; 
  var pass = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^&*()_+])[A-Za-z\d][A-Za-z\d!@#$%^&*()_+]{8,20}$/g;
  var Em = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i; 
 var dt= /^(\d{4})-(\d{1,2})-(\d{1,2})/;
  
  if (nric==null || nric==""){  
  alert("Please Entre the name");  
  return false;   
}
else if (!numL.test(nric)){ 
       alert("The Custmer id contain only Letters and number and its length should be more than 8");
	return false; 
		}
		else  if (name==null || name==""){  
  alert("Please Entre the name");  
  return false;   
}
else  if (!/^[a-zA-Z-,]+(\s{0,1}[a-zA-Z-, ])*$/g.test(name)) {
        alert("Invalid characters in name");
        return false;
    } 
else  if (address==null || address==""){  
  alert("Please Entre the address");  
  return false;   
}
else  if (dateofbirth==null || dateofbirth==""){  
  alert("Please Entre the dateofbirth");  
  return false;   
}
 else if(!dateofbirth.match(dt)) {
      alert("Invalid date format: " + dateofbirth);
      return false;
    }
else if (nationality==null || nationality==""){  
  alert("Please Entre the nationality");  
  return false;   
}
else  if (!/^[a-zA-Z-,]+(\s{0,1}[a-zA-Z-, ])*$/g.test(nationality)) {
        alert("Invalid characters in nationality");
        return false;
	} 
	 else if(gender==null || gender==""){  
	  alert("Please Entre gender");  
	  return false;  
	  } 
	 else  if (!/^[a-zA-Z-,]+(\s{0,1}[a-zA-Z-, ])*$/g.test(gender)) {
        alert("Invalid characters in gender");
        return false;
		}
	  else if(userid==null || userid==""){  
	  alert("Please Entre userid");  
	  return false;  
	  } 
	/*else if (!numL.test(userid)){ 
       alert("The User id contain only Letters and number and its length should be more than 8");
	return false; 
		}*/
		 else if(password==null || password==""){  
	  alert("Please Entre password");  
	  return false;  
	  } 
	   else if (!pass.test(password)){ 
       alert('The password should include atleast one letter,number and special character from !@#$%^&*()_+ and Its firts letter should be letter');
	return false; 
		}
	   else if(dateofjoining==null || dateofjoining==""){  
	  alert("Please Entre dateofjoining");  
	  return false;  
	  }
	   else if(!dateofjoining.match(dt)) {
      alert("Invalid date format: " + dateofjoining);
      return false;
    }
	   else if(quest1==null || quest1==""){  
	  alert("Please Entre question1");  
	  return false;  
	  } 
	   else if(answer1==null || answer1==""){  
	  alert("Please Entre answer1");  
	  return false;  
	  } 
	   else if(quest2==null || quest2==""){  
	  alert("Please Entre quest2");  
	  return false;  
	  } 
	   else if(answer2==null || answer2==""){  
	  alert("Please Entre answer2 ");  
	  return false;  
	  } 
	  else if(email==null || email==""){  
	  alert("Please Entre email ");  
	  return false;  
	  } 
	  else if (!Em.test(email)){ 
       alert("The Email should be in proper format like abc@efg.com");
	   return false; 
		}
	  else if(phone==null || phone==""){  
	  alert("Please Entre phone ");  
	  return false;  
	  } else if (isNaN(phone)){  
  alert("Please Entre digit");  
  return false;   
}
	   else if(usertype==null || usertype==""){  
	  alert("Please Entre usertype");  
	  return false;  
	  } 
	  else  if (!/^[a-zA-Z-,]+(\s{0,1}[a-zA-Z-, ])*$/g.test(usertype)) {
        alert("Invalid characters in usertype");
        return false;
		}
	  else if(status==null || status==""){  
	  alert("Please Entre status number");  
	  return false;  
	  }
	  else  if (!/^[a-zA-Z-,]+(\s{0,1}[a-zA-Z-, ])*$/g.test(status)) {
        alert("Invalid characters in status");
        return false;
		} 
	  
}  
	
</script>

</body>
</html>
