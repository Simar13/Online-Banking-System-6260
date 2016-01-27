<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" import="Bean.Customer" import="BL.PreferenceManager" 
 import="java.util.*" import="DAOImpl.CustomerDaoImpl" errorPage="" %>
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
.style3 {
	color: #0000FF;
	font-size: 12px;
}
-->
</style>
</head>

<body>
<form id="form1" name="form1" method="post" action="/Online-Banking-System/MortgageRequest" onsubmit="return validateform()">
<table width="100%" height="722" border="0">
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
  

  <tr>
    <td height="498" bgcolor="#F3F4EF"><p>&nbsp;</p>
      
      <table width="420" border="0" align="center">
        <tr>
          <td width="201"><span class="style2">Mortgage </span></td>
          <td width="203">&nbsp;</td>
        </tr>
        <tr>
        <c:if test="${!empty error}">
				<div style="padding-bottom:15px; padding-top:15px; padding-left:45px; padding-right:15px; float:none;display: block;" class="error">${error}</div>
			</c:if>
          <td>Mortgage Amount Requested</td>
          <td><label>
            <input name="amount" type="text" id="amount" maxlength="10" />
          </label></td>
        </tr>
              <td height="24" align="center">Duration in years</td>
              <td align="center" valign="middle"><select name="duration" id="duration">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                <option value="6">6</option>
                <option value="7">7</option>
                <option value="8">8</option>
                <option value="9">9</option>
                <option value="10">10</option>
                           
              </select></td>
          <tr>
               <td height="24" align="center">Select Installment Type</td>
              <td align="center" valign="middle"><select name="insType" id="insType">
              <option value="M">Monthly</option>
                <option value="B">Biweekly</option>
                
             
              </select></td>
            </tr>
            <tr>
          <td class="style1">Commodity Price</td>
          <td><label>
            <input name="price" type="text" id="price" maxlength="10" />
          </label></td>
        </tr>
        <tr>
        <td class="style1">Downpayment Amount</td>
          <td><label>
            <input name="down" type="text"  id="down" maxlength="10" />
          </label></td>
        </tr>
        <tr>
        <td class="style1">Your Annual Income(CAD)</td>
          <td><label>
            <input name="income" type="text"  id="income" maxlength="10" />
          </label></td>
        </tr>
        <tr>
          <td class="style1">Your Annual Expenditure(CAD)</td>
          <td><label>
            <input name="expenditure" type="text"  id="expenditure" maxlength="10" />
          </label></td>
        </tr>
        <tr>
          <td class="style1">interest rate</td>
          <td><label>
            <input type="text" name="rate"  id="rate" value="5" />
          </label></td>
        </tr>
      </table>
      <table width="200" border="0" align="center">
        <tr>
          <td align="center"><label>
            <input name="TransferB" type="submit" class="CsButton" id="TransferB" value="Submit" />
          </label></td>
        </tr>
      </table>
     <c:if test="${!empty error}">
            <div style="padding-bottom:15px; padding-top:15px; padding-left:45px; padding-right:15px; float:none;display: block;" class="error">${error}</div>
        </c:if></td>
  </tr>
  <tr>
    <td height="30" bgcolor="#FF0000">&nbsp;</td>
  </tr>
</table>
</form>
<script>
function validateform(){  
var amount=document.form1.amount.value;   
  var duration=document.form1.duration.value;
  var price=document.form1.price.value;
   var down=document.form1.down.value;
    var income=document.form1.income.value;
	 var expenditure=document.form1.expenditure.value;
	 
   if(amount==null || amount==""){  
	  alert("Please Entre amount");  
	  return false;  
	  } 
	  else if (isNaN(amount)){  
  alert("Please Entre digit");  
  return false;   
}
else if(duration==null || duration==""){  
	  alert("Please Entre duration ");  
	  return false;  
	  } 
	else  if(price==null || price==""){  
	  alert("Please Entre rate");  
	  return false;  
	  } 
	  else if (isNaN(price)){  
  alert("Please Entre digit");  
  return false; 
}	
else  if(down==null || down==""){  
	  alert("Please Entre Downpayment Ammount");  
	  return false;  
	  } 
	  else if (isNaN(down)){  
  alert("Please Entre digit");  
  return false; 
}	
else  if(income==null || income==""){  
	  alert("Please Entre income");  
	  return false;  
	  } 
	  else if (isNaN(income)){  
  alert("Please Entre digit");  
  return false; 
}	
else  if(expenditure==null || expenditure==""){  
	  alert("Please Entre rate");  
	  return false;  
	  } 
	  else if (isNaN(expenditure)){  
  alert("Please Entre digit");  
  return false; 
}	
}
</script>
</body>
</html>
