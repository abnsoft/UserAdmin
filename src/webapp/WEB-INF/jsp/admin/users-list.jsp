<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sprSec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<HEAD>
	<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<TITLE>User`s list</TITLE>

	<LINK href="<c:url value="/rs/css/main.css" />" rel="stylesheet">

	<META http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
	<META http-equiv="Pragma" content="no-cache" />
	<META http-equiv="Expires" content="0" />

</HEAD>
<BODY>
<TABLE width="780" border="0" align="center" cellpadding="0" cellspacing="0">
<TR>
<TD width="50%" height="30">&nbsp;</TD>
<TD width="50%" align="right"><jsp:include page="../common/commonWelcome.jsp" /></TD>
</TR>
</TABLE>
<TABLE width="780" border="0" align="center" cellpadding="0" cellspacing="0" class="loginTable">
    <TR>
            <TD height="40" align="center" class="loginTableHeader">Users</TD>
        </TR>
        <TR>
            <TD height="300" align="center" valign="top">
                <FORM id="frm1" action="login.htm" method="post" onSubmit="return checkForm();">
                    <TABLE width="95%" border="0" cellspacing="1" cellpadding="1">
                        <TR>
                            <TD height="22" align="center">&nbsp;</TD>
                            <TD align="center">&nbsp;</TD>
                            <TD align="center">&nbsp;</TD>
                            <TD align="right"><sprSec:authorize ifAllGranted="ROLE_OWNER">Add new User</A></sprSec:authorize></TD>
                        </TR>
                        <TR>
                            <TD width="15%" height="25" align="center" bgcolor="#66CCCC"><STRONG>
                                    <LABEL for="textfield">Email</LABEL>
                            </STRONG></TD>
                            <TD width="33%" align="center" bgcolor="#66CCCC"><STRONG>Full name</STRONG></TD>
                            <TD width="25%" align="center" bgcolor="#66CCCC"><STRONG>Role</STRONG></TD>
                            <TD width="27%" align="center" bgcolor="#66CCCC"><STRONG>Edit action</STRONG></TD>
                        </TR>
                        <c:forEach var="person" items="${persons}">
                        <TR>
                            <TD height="25" align="center" class="trDashedUL">&nbsp;${person.email}</TD>
                        <TD align="center" class="trDashedUL">&nbsp;<c:if test="${empty person.name}">unknown</c:if><c:if test="${not empty person.name}">${person.name}</c:if></TD>
                            <TD align="center" class="trDashedUL">&nbsp;${person.role}</TD>
                            <TD align="center" class="trDashedUL inactiveLink"><sprSec:authorize ifAllGranted="ROLE_EDITOR"><A href="${pageContext.request.contextPath}/admin/su/user.htm?userId=${person.id}">Edit</A></sprSec:authorize><sprSec:authorize ifAllGranted="ROLE_USER">Edit</sprSec:authorize></TD>
                        </TR>
                        </c:forEach>
                        <TR>
                            <TD height="25">&nbsp;</TD>
                            <TD>&nbsp;</TD>
                            <TD>&nbsp;</TD>
                            <TD>&nbsp;</TD>
                        </TR>
                    </TABLE>
                </FORM>
            </TD>
        </TR>
    </TABLE>
<P>&nbsp;</P>
</BODY>
</HTML>