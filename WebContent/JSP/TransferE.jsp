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
<form id="form1" name="form1" method="post" action="/Online-Banking-System/transferConfirmController" onsubmit="return validateform()">
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
  
  
  <tr>
    <td height="498" bgcolor="#F3F4Ef"><p>&nbsp;</p>
      <table width="718" height="30" border="0" align="center">
        <tr>
          <td width="353" height="24" align="center"><font color="#FF0000"><a href="/Online-Banking-System/transferInfoController">Between Accounts</a></font></td>
          <td width="349" align="center" valign="middle"><span class="style2"><a href="/Online-Banking-System/transferConfirmController">Interact e-Transfer</a></span></td>
        </tr>
      </table>
      <c:if test="${!empty error}">
				<div style="padding-bottom:15px; padding-top:15px; padding-left:45px; padding-right:15px; float:none;display: block;" class="error">${error}</div>
			</c:if>
      <table width="420" border="0" align="center">
        <tr>
          <td><span class="style2">Interac e-Transfer</span></td>
          <td>&nbsp;</td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
        </tr>
        <tr>
          <td width="201"><span class="style2">Recipient's Details</span></td>
          <td width="203">&nbsp;</td>
        </tr>
        <tr>
          <td>Previous recipients</td>
          <td><label>
            <select name="Etransfer" id="Etransfer">
            <% String nric = (String) session.getAttribute("nric");
    		CustomerDaoImpl customerDaoImpl = new CustomerDaoImpl();
    		ArrayList<String> payeeList = new ArrayList<String>();
    		PreferenceManager mgr=new PreferenceManager();
    		Customer customer = mgr.findCustomer(nric);
    		try {
    			payeeList = customerDaoImpl.getPayeeByCustomerID(nric);
    		
    		} catch (SQLException e1) {
    			// TODO Auto-generated catch block
    			e1.printStackTrace();
    		}
            
          		  Iterator itr = payeeList.iterator();
           			 while(itr.hasNext())
					
					{
						String payee = (String) itr.next(); 
			%>
					<option value="<%=payee %>"><%=payee %></option>
			<%
					}
			%>
            </select>
          </label></td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td><span class="style3"><a href="/Online-Banking-System/AddRecipient">Add recipient</a></span></td>
        </tr>
        <tr>
          <td class="style2">Your Details</td>
          <td>&nbsp;</td>
        </tr>
        <tr>
          <td class="style1">Name:</td>
          <td><label>
            <input type="text" name="nameOfperson" id="nameOfperson" value='<%= customer.getName()%>' />
          </label></td>
        </tr>
        <tr>
          <td class="style1">Email address:</td>
          <td><label>
            <input type="text" name="emailadrress" id="emailadrress" value='<%=customer.getEmail()%>' />
          </label></td>
        </tr>
         <tr>
          <td class="style2">Transfer Details</td>
          <td>&nbsp;</td>
        </tr>
        <tr>
          <td width="121">Account</td>
          <td width="287"><label>
            <select name="AccountTr" id="AccountTr">
            <% 
    		
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
        </tr>
        <tr>
          <td>Amount$</td>
          <td><label>
            <input type="text" name="Ammount1" id="Ammount1" />
          </label></td>
        </tr>
        <tr>
          <td height="62">Security Question</td>
          <td><textarea name="Etext" id="Etext" cols="45" rows="3"></textarea></td>
        </tr>
        <tr>
          <td height="30">Answer</td>
          <td><label>
            <input type="text" name="t2" id="t2" />
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
      <p>&nbsp;</p></td>
  </tr>
  <tr>
    <td height="30" bgcolor="#FF0000">&nbsp;</td>
  </tr>
</table>
</form>
<script>
	function validateform(){  
var Etransfer=document.form1.Etransfer.value;  
var AccountTr=document.form1.AccountTr.value;
var Ammount1= document.form1.Ammount1.value;
var Etext= document.form1.Etext.value;
var t2= document.form1.t2.value;
  
if (Etransfer==null || Etransfer==""){  
  alert("Please select recipient");  
  return false;   
}
else if(AccountTr==null || AccountTr==""){  
	  alert("Please select the account");  
	  return false;  
	  } 
	  else if(Ammount1==null || Ammount1==""){  
	  alert("Please Entre Ammount");  
	  return false;  
	  }
	  else if (isNaN(Ammount1)){  
  alert("Please Entre digit");  
  return false;   
}
	   else if(Etext==null || Etext==""){  
	  alert("Please Entre question");  
	  return false;  
	  } 
	   else if(t2==null || t2==""){  
	  alert("Please Entre the answer");  
	  return false;  
	  } 
}  
    </script>
</body>
</html>
