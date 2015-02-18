<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<HEAD>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<TITLE>Insert title here</TITLE>

	<LINK href="<c:url value="/rs/css/main.css" />" rel="stylesheet" />

</HEAD>
<BODY>
<TABLE width="500" border="0" align="center" cellpadding="0" cellspacing="0" class="loginTable">
<TR>
<TD height="40" align="center" class="loginTableHeader">User info</TD>
</TR>
<TR>
<TD height="300" align="center">
<FORM id="frm1" action="login.htm" method="post" onSubmit="return checkForm();">
<TABLE width="95%" border="0" cellspacing="0" cellpadding="0">
<TR>
<TD width="20%" height="35"><LABEL for="textfield">Email:</LABEL> </TD>
<TD width="46%"><INPUT name="textfield" type="text" class="inputFullSize" id="textfield"></TD>
<TD width="34%">&nbsp;</TD>
</TR>
<TR>
<TD height="35"><LABEL for="password">Password:</LABEL></TD>
<TD><INPUT name="password" type="password" class="inputFullSize" id="password"></TD>
<TD>&nbsp;</TD>
</TR>
<TR>
<TD height="35">&nbsp;</TD>
<TD align="right"><INPUT type="submit" name="submit" id="submit" value="  Войти  "></TD>
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
</BODY>
</HTML>