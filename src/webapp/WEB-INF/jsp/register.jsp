<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<HEAD>
<META http-equiv="Content-Type" content="text/html; charset=utf-8">
<TITLE>Register User</TITLE>

<LINK href='<c:url value="/rs/css/main.css" />' rel="stylesheet" />

</HEAD>
<BODY>
    <BR>
    <TABLE width="750" border="0" align="center" cellpadding="0" cellspacing="0" class="loginTable">
        <TR>
            <TD height="40" align="center" class="loginTableHeader"><STRONG>Register</STRONG></TD>
        </TR>
        <TR>
            <TD height="300" align="center">
                <FORM id="frm1" action="${pageContext.request.contextPath}/register.htm" method="post"
                    onSubmit="return checkForm();">
                    <INPUT name="register" type="hidden" id="register" form="frm1" value="yes">					
                    
                    <TABLE width="95%" border="0" cellspacing="3" cellpadding="0">
                        <TR>
                            <TD width="12%" height="35"><LABEL for="email">Email:</LABEL></TD>
                            <TD width="37%"><INPUT name="email" type="text" class="inputFullSize"
                                id="email" autocomplete="off" value="${frmReg.email}"></TD>
                            <TD width="51%" valign="middle">&nbsp;<SPAN class="errorMsg">${frmReg.errorsMap["valid.frmReg.email"]}</SPAN></TD>
                        </TR>
                        <TR>
                            <TD height="35"><LABEL for="password">Password:</LABEL></TD>
                            <TD><INPUT name="password" type="password" class="inputFullSize"
                                id="password" autocomplete="off" value="${frmReg.password}"></TD>
                            <TD valign="middle">&nbsp;<SPAN class="errorMsg">${frmReg.errorsMap["valid.frmReg.password"]}<BR>
${frmReg.errorsMap["valid.frmReg.passwordInvalid"]}</SPAN></TD>
                        </TR>
                        <TR>
                            <TD height="35"><LABEL for="password2">... Repeat:</LABEL></TD>
                            <TD><INPUT name="password2" type="password" class="inputFullSize"
                                id="password2" autocomplete="off" value="${frmReg.password2}"></TD>
                            <TD valign="middle">&nbsp;<SPAN class="errorMsg">${frmReg.errorsMap["valid.frmReg.passwordConfDiff"]}</SPAN></TD>
                        </TR>
                    </TABLE>
<BR>
<TABLE width="95%" border="0" cellpadding="0" cellspacing="3" id="addrTbl">
<TR class="addressTableHeader">
<TD height="35">&nbsp;</TD>
<TD height="35">Address</TD>
<TD>&nbsp;</TD>
</TR>
<TR class="trDashedUL">
<TD width="12%" height="35" class="trDashedUL"><LABEL for="country">Country:</LABEL></TD>
<TD width="37%" class="trDashedUL"><INPUT name="country" type="text" class="inputFullSize" id="email2" value="${frmReg.addressList[0].country}"></TD>
<TD width="51%"><DIV class="errorMsg">${frmUserErr.country}</DIV></TD>
</TR>
<TR class="trDashedUL">
<TD height="35" class="trDashedUL"><LABEL for="city">City:</LABEL></TD>
<TD class="trDashedUL"><INPUT name="city" type="text" class="inputFullSize" id="fullname" value="${frmReg.addressList[0].city}"></TD>
<TD><DIV class="errorMsg">${frmUserErr.city}</DIV></TD>
</TR>
<TR class="trDashedUL">
<TD height="35" class="trDashedUL"><LABEL for="street">Street :</LABEL></TD>
<TD class="trDashedUL"><INPUT name="street" type="text" class="inputFullSize" id="fullname2" value="${frmReg.addressList[0].street}"></TD>
<TD><DIV class="errorMsg">${frmReg.addressList.street}</DIV></TD>
</TR>
<TR class="trDashedUL">
<TD height="35" class="trDashedUL"><LABEL for="house">House:</LABEL></TD>
<TD class="trDashedUL"><INPUT name="house" type="text" class="inputFullSize" id="password7" value="${frmReg.addressList[0].house}"></TD>
<TD><DIV class="errorMsg">${frmUserErr.house}</DIV></TD>
</TR>
<T class="trDashedUL"R>
<TR>
<TD height="35">&nbsp;</TD>
<TD align="right"><INPUT type="submit" name="submit3" id="submit3" value="  Add more address  ">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<INPUT type="submit" name="submit" id="submit"
                                value="  Register  "></TD>
<TD align="center">&nbsp;</TD>
</TR>
</TABLE>
                </FORM>
        </TD>
            </TD>
        </TR>
    </TABLE>
<P>
    <A href="${pageContext.request.contextPath}/login.htm">Login</A></P>
</BODY>
</HTML>