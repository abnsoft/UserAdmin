<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<HEAD>
	<META http-equiv="Content-Type" content="text/html; charset=utf-8">
	<TITLE>Login</TITLE>

	<LINK href='<c:url value="/rs/css/main.css" />' rel='stylesheet' />
    
    <SCRIPT type='text/javascript' src='<c:url value="/rs/js/jquery-2.1.3.js" />'></SCRIPT>
	<SCRIPT type="text/javascript" >
	$(document).ready(function() {
		$("#j_username").focus();
	});
	</SCRIPT>

</HEAD>
<BODY>
<TABLE width="500" border="0" align="center" cellpadding="0" cellspacing="0">
<TR>
<TD width="50%" height="30">&nbsp;</TD>
<TD width="50%" align="right">&nbsp;</TD>
</TR>
</TABLE>
<TABLE width="500" border="0" align="center" cellpadding="0" cellspacing="0" class="loginTable">
        <TR>
            <TD height="40" align="center" class="loginTableHeader"><STRONG>Login</STRONG></TD>
        </TR>
        <TR>
            <TD height="200" align="center" valign="top">
<c:if test="${not empty loginError}">  
  <DIV class="errorMsg">  
   <BR>
Your login attempt was not successful.  
 <BR>
Caused :  
   ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}  
  <BR>
</DIV>  
 </c:if>  
 <BR>
<FORM id="frm1" action="<c:url value='j_spring_security_check' />" method="post"
                    onSubmit="return checkForm();">
    <TABLE width="95%" border="0" cellspacing="0" cellpadding="0">
                        <TR>
                            <TD width="20%" height="35"><LABEL for="j_username">Email:</LABEL></TD>
                            <TD width="46%"><INPUT name="j_username" type="text" autofocus class="inputFullSize"
                                id="j_username" tabindex="10" autocomplete="off"></TD>
                            <TD width="34%">&nbsp;</TD>
                        </TR>
                        <TR>
                            <TD height="35"><LABEL for="j_password">Password:</LABEL></TD>
                            <TD><INPUT name="j_password" type="password" class="inputFullSize"
                                id="j_password" tabindex="20" autocomplete="off"></TD>
                            <TD>&nbsp;</TD>
                        </TR>
                        <TR>
                            <TD height="35">&nbsp;</TD>
                            <TD align="left"><INPUT name="remember-me" type="checkbox" id="remember-me" tabindex="30">
<LABEL for="remember-me"> Remember me</LABEL></TD>
                            <TD><INPUT name="submit" type="submit" id="submit" tabindex="9999"
                                value="  Войти  "></TD>
                        </TR>
                        <TR>
                            <TD height="35">&nbsp;</TD>
                            <TD>&nbsp;</TD>
                            <TD>&nbsp;</TD>
                        </TR>
</TABLE>
            </FORM>
            </TD>
        </TR>
</TABLE>
<P>
        <A href="${pageContext.request.contextPath}/register.htm">Register new user</A></P>
<DIV id="footer">Content for  id "footer" Goes Here</DIV>
</BODY>
</HTML>