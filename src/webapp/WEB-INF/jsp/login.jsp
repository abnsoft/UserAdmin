<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<HEAD>
<META http-equiv="Content-Type" content="text/html; charset=utf-8">
<TITLE>Insert title here</TITLE>

<LINK href='<c:url value="/rs/css/main.css" />' rel='stylesheet' />

</HEAD>
<BODY>
    <BR>
    <TABLE width="500" border="0" align="center" cellpadding="0" cellspacing="0" class="loginTable">
        <TR>
            <TD height="40" align="center" class="loginTableHeader"><STRONG>Login</STRONG></TD>
        </TR>
        <TR>
            <TD height="200" align="center">
                <FORM id="frm1" action="<c:url value='j_spring_security_check' />" method="post"
                    onSubmit="return checkForm();">
                    <TABLE width="95%" border="0" cellspacing="0" cellpadding="0">
                        <TR>
                            <TD width="20%" height="35"><LABEL for="j_username">Email:</LABEL></TD>
                            <TD width="46%"><INPUT name="j_username" type="text" autofocus="autofocus" class="inputFullSize"
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
                            <TD align="right"><INPUT name="submit" type="submit" id="submit" tabindex="30"
                                value="  Войти  "></TD>
                            <TD>&nbsp;</TD>
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
        <A href="${pageContext.request.contextPath}/register.htm">Register new user</A>
    </P>
</BODY>
</HTML>