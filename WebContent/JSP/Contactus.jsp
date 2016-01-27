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
</head>

<body>
<form id="form1" name="form1" method="post" action="">
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
                 <td valign="top"><p onclick="Help()">Help</p></td>
                 <td valign="top"><p onclick="Contactus()">Contact us</p></td>
                 <td valign="top"><p onclick="Profile()">Manage my Account</p></td>
                 <td valign="top"><font color="#FF0000">
                   <p onclick="Signout()">Sign out</p>
                 </font></td>
               </tr>
           </table></td>
         </tr>
     </table></td>
   </tr>
   <tr>
     <td height="28" bgcolor="#FF0000"><table width="726" border="0" align="center">
         <tr>
           <td width="235" height="21" align="center" class="style1"><p class="cs1"  id="demo"  onclick="Changecolour()">Account</p></td>
           <td width="235" align="center" class="style1"><p class="cs1"  id="demo1" onclick="Changecolour1()">Bill Payment</p></td>
           <td width="234" align="center" class="style1"><p class="cs1"  id="demo2" onclick="Changecolour2()">Transfer</p></td>
         </tr>
     </table></td>
   </tr>
   <tr>
     <td height="26" bgcolor="#F0F0F0" class="cs1">&nbsp;</td>
   </tr>
  </div>
  </div>
  <tr >
    <td height="407" bgcolor="#F3F4EF"><table width="508" height="217" border="1" align="center">
      <tr>
        <td align="center"><h3> General Inquiries</h3>
            <ol>
              <li>Fulfill all your banking needs 24 hours a day, 7 days a week with  number<br />
                514-814-0031.<br />
                <br />
              </li>
              <li>For daily routine work you can visit us in our main branch<br />
                  <br />
                518-3777 COTE-DES-NEIGES<br />
                MONTREAL,QUEBEC,H3H 1V8.<br />
              </li>
            </ol></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="21" bgcolor="#FF0000">&nbsp;</td>
  </tr>
</table>
</form>
<script>
function Changecolour() {
    document.getElementById("demo").style.color = "blue";
	window.location = "Account.jsp"
	}
	
	function Changecolour1() {
    document.getElementById("demo1").style.color = "blue";
	window.location = "billPay.jsp"
	}
	
function Changecolour2() {
    document.getElementById("demo2").style.color = "blue";
	window.location = "Transfer.jsp"
	}
	function Help() {
    
	window.location = "Help.jsp"
	}
	function Contactus() {
    
	window.location = "Manage.jsp"
	}
	function Profile() {
    
	window.location = "Profile.jsp"
	}
	function Signout() {
    
	window.location = "Login.jsp"
	}
	
</script>

</body>
</html>
