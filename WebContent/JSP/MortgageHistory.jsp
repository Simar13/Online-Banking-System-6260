<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<form id="form1" name="form1" method="post" action="/Online-Banking-System/LoanHistoryController">
<table width="100%" height="622" border="0">
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
  
  <tr >
    <td height="407" align="center" bgcolor="#F3F4EF"><table width="1025" height="248" border="0">
      <tr>
        <td height="44" align="center"><span class="style2">Mortgage Transaction History</span></td>
      </tr>
      <tr>
        <td><c:if test="${!empty error}">
            <div style="padding-bottom:15px; padding-top:15px; padding-left:45px; padding-right:15px; float:none;display: block;" class="error">${error}</div>
        </c:if>
            <table style="border:1px outset black;" cellpadding="10">
              <%-- <th align="left"><fmt:message key="label.transaction.transactionId"/></th>
				<th align="left"><fmt:message key="label.transaction.accountId"/></th> --%>
              <tr>
                <th align="left">Mortgage ID</th>
                <th align="left">Paid Amount</th>
                <th align="left">Outstanding</th>
                  <th align="left">Installment</th>
                <th align="left">Start date</th>
                 <th align="left">End date</th>
                  <th align="left">Last pay date</th>
              </tr>
              <c:forEach items="${loanHistory}" var="loanHistory">
              <tr>
                <td>${loanHistory.mortgageId}</td>
                <td>${loanHistory.paidAmount}</td>
                <td>${loanHistory.outstanding}</td>
                <td>${loanHistory.installment}</td>
                <td>${loanHistory.startDate}</td>
                <td>${loanHistory.endDate}</td>
                <td>${loanHistory.lastPayDate}</td>
              </tr>
              </c:forEach>
            </table>
           </td>
      </tr>
    </table>
      <p>&nbsp;</p></td>
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
    
	window.location = "Profile.jsp"
	}
	function Signout() {
    
	window.location = "Login.jsp"
	}
	function Request() {
    document.getElementById("demo").style.color = "blue";
	window.location = "AdminRequestDeposit.jsp"
	}
	
	function Search() {
    document.getElementById("demo1").style.color = "blue";
	window.location = "AdminSearchName.jsp"
	}
	
function Customer() {
    document.getElementById("demo2").style.color = "blue";
	window.location = "AdminCustomerCreate.jsp"
	}
	
	
</script>

</body>
</html>
