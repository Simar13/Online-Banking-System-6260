<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" import="java.util.*" import="DAOImpl.CustomerDaoImpl" errorPage="" %>
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
-->
</style>
</head>

<body>
<form id="form1" name="form1" method="post" action="/Online-Banking-System/transferInfoController" onsubmit="return validateform()">
<table width="100%" height="603" border="0">
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
  
  <tr bgcolor="#F3F4EF">
    <td height="320"><p>&nbsp;</p>
      <table width="718" height="30" border="0" align="center">
      <tr>
        <td width="353" height="24" align="center"><font color="#FF0000"><a href="/Online-Banking-System/transferInfoController">Between Accounts</a></font></td>
        <td width="349" align="center" valign="middle"><span class="style2"><a href="/Online-Banking-System/transferConfirmController">Interact e-Transfer</a></span></td>
        </tr>
    </table>
      <p>&nbsp;</p>
      <table width="424" border="0" align="center">
        <tr>
          <td><span class="style2">Between Accounts</span></td>
          <td>&nbsp;</td>
        </tr>
        <tr>
          <td width="173">From</td>
          <td width="176"><label>
            <select name="AccountTrfrm" id="AccountTrfrm">
            <% String nric =(String) session.getAttribute("nric");
  			CustomerDaoImpl customerDaoImpl = new CustomerDaoImpl();
    		
    		ArrayList<String> accountTypeList = new ArrayList<String>();
    		try {
    			accountTypeList = customerDaoImpl.getAccountsByCustomerID(nric);
    		
    			
    		} catch (SQLException e1) {
    			// TODO Auto-generated catch block
    			e1.printStackTrace();
    		}
            
          		  Iterator itracc = accountTypeList.iterator();
           			 while(itracc.hasNext()) 
					
					{
						String acc = (String) itracc.next(); 
			%>
					<option value="<%=acc %>"><%=acc %></option>
			<%
					}
			%>
            </select>
          </label></td>
          <c:forEach var="list" items="${ sessionScope.aidlist }">
				<a href="${pageContext.request.contextPath }/login?accountId=${list.accountId}">${ list.accountId }</a><br/>
			</c:forEach>
        </tr>
        <tr>
          <td>To</td>
          <td><label>
            <select name="AccountTrTo" id="AccountTrTo">
            <% 
    		
    		ArrayList<String> accountTypeList1 = new ArrayList<String>();
    		try {
    			accountTypeList1 = customerDaoImpl.getAccountsByCustomerID(nric);
    		
    			
    		} catch (SQLException e1) {
    			// TODO Auto-generated catch block
    			e1.printStackTrace();
    		}
            
          		  Iterator itr = accountTypeList1.iterator();
           			 while(itr.hasNext()) 
					
					{
						String acc = (String) itr.next(); 
			%>
					<option value="<%=acc %>"><%=acc %></option>
			<%
					}
			%>
            </select>
          </label></td>
        </tr>
        <tr>
          <td>Amount$</td>
          <td><label>
            <input name="Ammount1" type="text" id="Ammount1" maxlength="10" />
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
      <p>&nbsp;</p></td>
  </tr>
  <c:if test="${!empty error}">
				<div style="padding-bottom:15px; padding-top:15px; padding-left:45px; padding-right:15px; float:none;display: block;" class="error">${error}</div>
	</c:if>
  <tr>
    <td height="30" bgcolor="#FF0000">&nbsp;</td>
  </tr>
</table>
</form>
<script>
	function validateform(){  
var Ammount1=document.form1.Ammount1.value; 
var AccountTrTo=document.form1.AccountTrTo.value; 
  var AccountTrfrm=document.form1.AccountTrfrm.value; 
  
 if (AccountTrfrm==null || AccountTrfrm==""){  
 alert("Please select recipient");  
 return false;   
}
else if(AccountTrTo==null || AccountTrTo==""){  
	  alert("Please select the account");  
	  return false;  
	  } 
else if (Ammount1==null || Ammount1==""){  
  alert("Please Entre the Amount");  
  return false;   
}
else if (isNaN(Ammount1)){  
  alert("Please Entre digit");  
  return false;   
}

}
</script>
</body>
</html>
