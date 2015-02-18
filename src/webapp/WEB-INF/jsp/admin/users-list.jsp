<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<HEAD>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<TITLE>User`s list</TITLE>

	<LINK href="<c:url value="/rs/css/main.css" />" rel="stylesheet">

</HEAD>
<BODY>
<TABLE width="780" border="0" align="center" cellpadding="0" cellspacing="0" class="loginTable">
<TR>
<TD height="40" align="center" class="loginTableHeader">User`s list</TD>
</TR>
<TR>
<TD height="300" align="center" valign="top">
<FORM id="frm1" action="login.htm" method="post" onSubmit="return checkForm();">
<TABLE width="95%" border="0" cellspacing="1" cellpadding="1">
<TR>
<TD height="22" align="center">&nbsp;</TD>
<TD align="center">&nbsp;</TD>
<TD align="center">&nbsp;</TD>
<TD align="right"><A href="#">Add new User</A></TD>
</TR>
<TR>
<TD width="15%" height="35" align="center" bgcolor="#66CCCC"><STRONG>
<LABEL for="textfield">Email</LABEL>
</STRONG></TD>
<TD width="33%" align="center" bgcolor="#66CCCC"><STRONG>Full name</STRONG></TD>
<TD width="25%" align="center" bgcolor="#66CCCC"><STRONG>Role</STRONG></TD>
<TD width="27%" align="center" bgcolor="#66CCCC"><STRONG>Edit action</STRONG></TD>
</TR>
<TR>
<TD height="35">&nbsp;</TD>
<TD>&nbsp;</TD>
<TD>&nbsp;</TD>
<TD>&nbsp;</TD>
</TR>
<TR>
<TD height="35">&nbsp;</TD>
<TD>&nbsp;</TD>
<TD>&nbsp;</TD>
<TD>&nbsp;</TD>
</TR>
</TABLE>
</FORM>
</TD>
</TR>
</TABLE>
</BODY>
</HTML>