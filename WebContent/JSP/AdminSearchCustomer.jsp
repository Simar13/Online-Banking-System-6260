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
<form id="form1" name="form1" method="post" action="/Online-Banking-System/AdminSearchCustomer" onsubmit="return validateform()">
<table width="100%" height="622" border="0">
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
    <td height="407" align="center" bgcolor="#F3F4EF"><table width="1476" height="414" border="0">
      <tr>
        <td width="1466" height="50"><table width="1015" height="40" border="0">
          <tr>
            <td width="380" align="right">Enter Customer Identity</td>
            <td width="258" align="center"><label>
              <input type="text" name="nric" id="nric" required />
            </label></td>
            <td width="355"><label>
              <input name="searchbutton" type="submit" class="CsButton" id="searchbutton" value="Search" />
            </label></td>
          </tr>
        </table></td>
      </tr>
      <tr><td valign="top"><c:if test="${!empty error}">
				<div style="padding-bottom:15px; padding-top:15px; padding-left:45px; padding-right:15px; float:none;display: block;" class="error">${error}</div>
			</c:if>
        
			<table style="border:1px outset black;" cellpadding="10" width="100%">
				
				<%-- <th align="left"><fmt:message key="label.transaction.transactionId"/></th>
				<th align="left"><fmt:message key="label.transaction.accountId"/></th> --%>
				<th align="left"> Name</th>
				<th align="left">Address</th>
				<th align="left">Date of Birth</th>
				<th align="left">Nationality</th>
				<th align="left">Gender</th>
				<th align="left">User ID</th>
				<th align="left">Date of joining</th>					
				<th align="left">Email </th>
				<th align="left">Phone Number</th>
				<c:forEach items="${customers}" var="customers">
 				 <tr>
   			     <td>${customers.name}</td>
   			     <td>${customers.address}</td>
   			     <td>${customers.dateOfBirth}</td>
   			     <td>${customers.nationality}</td>
   			     <td>${customers.gender}</td>
   			     <td>${customers.userid}</td>
   			     <td>${customers.dateOfJoining}</td>
   			     <td>${customers.email}</td>
   			     <td>${customers.phone}</td>
  			  </tr>
				</c:forEach>
			</table> </td>
      </tr>
      
    </table></td>
  </tr>
  <tr>
    <td height="21" bgcolor="#FF0000">&nbsp;</td>
  </tr>
</table>
</form>
<script>

	function Help() {
    
	window.location = "Help.jsp"
	}
	function Contactus() {
    
	window.location = "Contactus.jsp"
	}
	function Profile() {
    
	window.location = "Manage.jsp"
	}
	function Signout() {
    
	window.location = "Login.jsp"
	}
	function Request() {
    document.getElementById("demo").style.color = "blue";
	window.location = "AdminRequests.jsp"
	}
	
	function Search() {
    document.getElementById("demo1").style.color = "blue";
	window.location = "AdminSearchDisp.jsp"
	}
	
function Customer() {
    document.getElementById("demo2").style.color = "blue";
	window.location = "AdminCustomerDisp.jsp"
	}
	function Acct() {
    
	window.location = "AdminSearchAccount.jsp"
	}
	function Cust() {
    
	window.location = "AdminSearchCustomer.jsp"
	}
	function Trans() {
    
	window.location = "AdminSearchTransaction.jsp"
	}
	function validateform(){  
var nric=document.form1.nric.value;
var regularExpression = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{8,12}$/g;    
  
if (nric==null || nric==""){  
  alert("Please Entre the Customerid");  
  return false;   
}
else if (!regularExpression.test(nric)){ 
       alert("The Customerid is not in specified format as given by bank");
	return false; 
		}
}
</script>


</body>
</html>
