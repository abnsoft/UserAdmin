<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<HEAD>
<META http-equiv="Content-Type" content="text/html; charset=utf-8">
<TITLE>Register User</TITLE>

<LINK href='<c:url value="/rs/css/main.css" />' rel="stylesheet" />
<SCRIPT type='text/javascript' src='<c:url value="/rs/js/jquery-2.1.3.js" />'></SCRIPT>

<SCRIPT type="text/javascript" >
$(document).ready(function() {
	
	//var duplicateAddress = function(){
		var count=0;
		$('#moreAddress').click( function () {
			count++;
			var Clonedtable = $("#addTMPL").clone(true).html(function(i, oldHTML){
				oldHTML = oldHTML.replace(/addressListX/g, "addressList["+count+"]");
				return oldHTML;
			});
			Clonedtable.appendTo('#trgt');
			$("#trgt").html(function(i, txt){
			txt=	txt.replace(/addTMPL/g, "addTBL"+count);
				return txt;
			})
			$("#addTBL"+count).show();
		})
	//}
});
</SCRIPT>
</HEAD>



<BODY>
<TABLE width="780" border="0" align="center" cellpadding="0" cellspacing="0">
<TR>
<TD width="50%" height="30">&nbsp;</TD>
<TD width="50%" align="right">&nbsp;</TD>
</TR>
</TABLE>
<TABLE width="750" border="0" align="center" cellpadding="0" cellspacing="0" class="loginTable">
        <TR>
            <TD height="40" align="center" class="loginTableHeader"><STRONG>Register</STRONG></TD>
        </TR>
        <TR>
            <TD height="300" align="center" valign="top">
                <FORM id="frm1" action="${pageContext.request.contextPath}/register.htm" method="post"
                    onSubmit="return checkForm();">
                    <INPUT name="register" type="hidden" id="register" form="frm1" value="yes">					
                    
                    <TABLE width="95%" border="0" cellspacing="3" cellpadding="0">
                        <TR>
                            <TD width="12%" height="35"><LABEL for="email">Email:</LABEL></TD>
                            <TD width="37%"><INPUT name="email" type="text" class="inputFullSize"
                                id="email" autocomplete="off" value="${frmReg.email}"></TD>
                            <TD width="51%" valign="middle" class="trDashedUL">&nbsp;<SPAN class="errorMsg">${frmReg.errorsMap["valid.frmReg.email"]}</SPAN></TD>
                        </TR>
                        <TR>
                            <TD height="35"><LABEL for="password">Password:</LABEL></TD>
                            <TD><INPUT name="password" type="password" class="inputFullSize"
                                id="password" autocomplete="off" value="${frmReg.password}"></TD>
                            <TD valign="middle" class="trDashedUL">&nbsp;<SPAN class="errorMsg">${frmReg.errorsMap["valid.frmReg.password"]}<BR>
${frmReg.errorsMap["valid.frmReg.passwordInvalid"]}</SPAN></TD>
                        </TR>
                        <TR>
                            <TD height="35"><LABEL for="password2">... Repeat:</LABEL></TD>
                            <TD><INPUT name="password2" type="password" class="inputFullSize"
                                id="password2" autocomplete="off" value="${frmReg.password2}"></TD>
                            <TD valign="middle" class="trDashedUL">&nbsp;<SPAN class="errorMsg">${frmReg.errorsMap["valid.frmReg.passwordConfDiff"]}</SPAN></TD>
                        </TR>
                    </TABLE>
<BR>
<TABLE width="95%" border="0" cellpadding="0" cellspacing="3" id="addTMPL" style="display:none;">
<TR class="addressTableHeader">
<TD width="12%" height="35">&nbsp;</TD>
<TD width="36%" height="35">Address</TD>
<TD width="52%">&nbsp;</TD>
</TR>
<TR class="trDashedUL">
<TD width="12%" height="35" class="trDashedUL"><LABEL for="addressListX.country">Country:</LABEL></TD>
<TD width="37%" class="trDashedUL"><INPUT name="addressListX.country" type="text" class="inputFullSize" id="addressListX.country"></TD>
<TD width="51%" class="trDashedUL"><DIV class="errorMsg"></DIV></TD>
</TR>
<TR class="trDashedUL">
<TD height="35" class="trDashedUL"><LABEL for="addressListX.city">City:</LABEL></TD>
<TD class="trDashedUL"><INPUT name="addressListX.city" type="text" class="inputFullSize" id="addressListX.city"></TD>
<TD class="trDashedUL"><DIV class="errorMsg"></DIV></TD>
</TR>
<TR class="trDashedUL">
<TD height="35" class="trDashedUL"><LABEL for="addressListX.street">Street :</LABEL></TD>
<TD class="trDashedUL"><INPUT name="addressListX.street" type="text" class="inputFullSize" id="addressListX.street"></TD>
<TD class="trDashedUL"><DIV class="errorMsg"></DIV></TD>
</TR>
<TR class="trDashedUL">
<TD height="35" class="trDashedUL"><LABEL for="addressListX.houseNumber">House:</LABEL></TD>
<TD class="trDashedUL"><INPUT name="addressListX.houseNumber" type="text" class="inputFullSize" id="addressListX.houseNumber"></TD>
<TD class="trDashedUL"><DIV class="errorMsg"></DIV></TD>
</TR>
</TABLE>


<TABLE width="95%" border="0" cellpadding="0" cellspacing="3" id="addTbl">
<TR class="addressTableHeader">
<TD width="12%" height="35">&nbsp;</TD>
<TD width="36%" height="35">Address ${status.expression}</TD>
<TD width="52%">&nbsp;</TD>
</TR>
<TR class="trDashedUL">
<TD width="12%" height="35" class="trDashedUL"><LABEL for="addressList[0].country">Country:</LABEL></TD>
<TD width="37%" class="trDashedUL"><INPUT name="addressList[0].country" type="text" class="inputFullSize" id="addressList[0].country" value='${frmReg.addressList["0"].country}'></TD>
<TD width="51%" class="trDashedUL"><DIV class="errorMsg"></DIV></TD>
</TR>
<TR class="trDashedUL">
<TD height="35" class="trDashedUL"><LABEL for="addressList[0].city">City:</LABEL></TD>
<TD class="trDashedUL"><INPUT name="addressList[0].city" type="text" class="inputFullSize" id="addressList[0].city" value='${frmReg.addressList["0"].city}'></TD>
<TD class="trDashedUL"><DIV class="errorMsg"></DIV></TD>
</TR>
<TR class="trDashedUL">
<TD height="35" class="trDashedUL"><LABEL for="addressList[0].street">Street :</LABEL></TD>
<TD class="trDashedUL"><INPUT name="addressList[0].street" type="text" class="inputFullSize" id="addressList[0].street" value="${frmReg.addressList[0].street}"></TD>
<TD class="trDashedUL"><DIV class="errorMsg"></DIV></TD>
</TR>
<TR class="trDashedUL">
<TD height="35" class="trDashedUL"><LABEL for="addressList[0].houseNumber">House:</LABEL></TD>
<TD class="trDashedUL"><INPUT name="addressList[0].houseNumber" type="text" class="inputFullSize" id="addressList[0].houseNumber" value="${frmReg.addressList[0].houseNumber}"></TD>
<TD class="trDashedUL"><DIV class="errorMsg"></DIV></TD>
</TR>
</TABLE><SPAN id="trgt"></SPAN>
<TABLE width="95%" border="0" cellpadding="0" cellspacing="3" id="addrFtr">
<TR>
<TD width="11%" height="35">&nbsp;</TD>
<TD width="36%" align="right"> <A href="javascript:void(0);" id="moreAddress">I need more address</A>&nbsp;&nbsp;&nbsp;</TD>
<TD width="53%" align="left"><INPUT type="submit" name="submit" id="submit"
                                value="  Register  "></TD>
</TR>
</TABLE>
</FORM><BR>
        </TD>
            </TD>
        </TR>
    </TABLE>
<P>
    <A href="${pageContext.request.contextPath}/login.htm">Login</A></P>
</BODY>
</HTML>