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
<link href="../../../../Desktop/Project/Online-Banking-System/WebContent/JSP/Colour" rel="stylesheet" type="text/css" />
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
<form id="form1" name="form1" method="post" action="" onsubmit="return validateform()">
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
    <td height="407" align="center" bgcolor="#F3F4EF"><p>&nbsp;</p>
    <table width="420" border="0" align="center">
     <c:forEach items="${loan}" var="loan">
      <tr>
        <td width="201"><span class="style2"> Loan Details</span></td>
        <td width="203">&nbsp;</td>
      </tr>
      <tr>
        <td> Loan Id</td>
        <td align="center"><label>
          <input name="loanid" type="text" id="loanid" value="${loan.loanId}" readonly="readonly"  maxlength="10"/>
        </label></td>
      </tr>
      <tr>
        <td height="24" align="left">Duration(Year)</td>
        <td align="center" valign="middle"><input name="duration" type="text" id="duration" readonly="readonly" value="${loan.duration}" maxlength="2"/></td>
      </tr>
      <tr>
        <td height="24" align="left">Gross Amount</td>
        <td align="center" valign="middle"><input name="grossamount" type="text" id="grossamount" readonly="readonly"  value="${loan.grossAmount}" maxlength="10"/></td>
      </tr>
      <tr>
        <td height="24" align="left">Paid Amount</td>
        <td align="center" valign="middle"><input name="paidamount" type="text" id="paidamount" readonly="readonly"  value="${loan.paidAmount}" maxlength="10"/></td>
      </tr>
      <tr>
        <td height="24" align="left">Installment to Pay</td>
        <td align="center" valign="middle"><input name="installment" type="text" id="installment" readonly="readonly"  value="${loan.installment}" maxlength="10" /></td>
      </tr>
      <tr>
        <td height="24" align="left">Principal</td>
        <td align="center" valign="middle"><input name="principal" type="text" id="principal" readonly="readonly"  value="${loan.principal}" maxlength="10"/></td>
      </tr>
      <tr>
        <td height="24" align="left">Outstanding Balance</td>
        <td align="center" valign="middle"><input name="outstanding" type="text" id="outstanding" readonly="readonly"  value="${loan.outstanding}" maxlength="10" /></td>
      </tr>
      <tr>
        <td height="24" align="left">Start Date</td>
        <td align="center" valign="middle"><input type="text" name="startdate" id="startdate" readonly="readonly"  value="${loan.startDate}"/></td>
      </tr>
      <tr>
        <td height="24" align="left">End Date</td>
        <td align="center" valign="middle"><input type="text" name="endDate" id="endDate" readonly="readonly"  value="${loan.endDate}"/></td>
      </tr>
      
      <tr>
        <td height="24" align="left">Interest Rate</td>
        <td align="center" valign="middle"><input name="interestrate" type="text" id="interestrate"   value="${loan.interestRate}" maxlength="10"/></td>
      </tr>
      <tr>
        <td height="24" align="left">&nbsp;</td>
        <td align="center" valign="middle">&nbsp;</td>
      </tr>
         </c:forEach>
    </table>
    <p>&nbsp;</p></td>
  </tr>
  <tr>
    <td height="21" bgcolor="#FF0000">&nbsp;</td>
  </tr>
</table>
</form>
<script>
	function validateform(){  
var accountId=document.form1.accountId.value; 
  var duration=document.form1.duration.value;
  var grossamount=document.form1.grossamount.value;
  var paidAmount=document.form1.paidAmount.value; 
  var installment=document.form1.installment.value;  
  var principal=document.form1.principal.value;  
  var outstanding=document.form1.outstanding.value;
    var startdate=document.form1.startdate.value; 
	  var endDate=document.form1.endDate.value; 
	    var interestrate=document.form1.interestrate.value; 
		      
}
else if (loanid==null || loanid==""){  
  alert("Please Entre the dateofbirth");  
  return false;   
}
else if (isNaN(loanid)){  
  alert("Please Entre loanid");  
  return false;   
}
else if (duration==null || duration==""){  
  alert("Please Entre the dateofbirth");  
  return false;   
}
else  if (isNaN(duration)){  
  alert("Please Entre duration");  
  return false;   
}
else if (grossamount==null || grossamount==""){  
  alert("Please Entre the dateofbirth");  
  return false;   
}
else  if (isNaN(grossamount)){  
  alert("Please Entre grossamount");  
  return false;   
}
else if (paidAmount==null || paidAmount==""){  
  alert("Please Entre the dateofbirth");  
  return false;   
}
else  if (isNaN(paidAmount)){  
  alert("Please Entre paidAmount");  
  return false;   
}
else if (installment==null || installment==""){  
  alert("Please Entre the dateofbirth");  
  return false;   
}
else  if (isNaN(installment)){  
  alert("Please Entre installment");  
  return false;   
}
else if (principal==null || principal==""){  
  alert("Please Entre the dateofbirth");  
  return false;   
}
else  if (isNaN(principal)){  
  alert("Please Entre principal");  
  return false;   
}
else if (outstanding==null || outstanding==""){  
  alert("Please Entre the dateofbirth");  
  return false;   
}
else  if (isNaN(outstanding)){  
  alert("Please Entre outstanding");  
  return false;   
}
else if (startdate==null || startdate==""){  
  alert("Please Entre the dateofbirth");  
  return false;   
}
else if(!startdate.match(dt)) {
      alert("Invalid startdate date format: " + startdate);
      return false;
    } 
	else if (endDate==null || endDate==""){  
  alert("Please Entre the dateofbirth");  
  return false;   
}
else if(!endDate.match(dt)) {
      alert("Invalid endDate date format: " + endDate);
      return false;
    }
	else if (interestrate==null || interestrate==""){  
  alert("Please Entre the dateofbirth");  
  return false;   
}
else  if (isNaN(interestrate)){  
  alert("Please Entre interestrate");  
  return false;   
}
}
</script>
</body>
</html>
