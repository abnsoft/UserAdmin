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
<TABLE width="780" border="0" align="center" cellpadding="0" cellspacing="0">
<TR>
<TD width="50%" height="30" align="left">[<A href="${pageContext.request.contextPath}/admin/users-list.htm">User list</A>]</TD>
<TD width="50%" align="right"><jsp:include page="../../common/commonWelcome.jsp" /></TD>
</TR>
</TABLE>
<TABLE width="780" border="0" align="center" cellpadding="0" cellspacing="0" class="loginTable">
<TR>
<TD height="40" align="center" class="loginTableHeader">User info</TD>
</TR>
<TR>
<TD height="300" align="center">
<BR>
<FORM id="frm1" action="${pageContext.request.contextPath}/admin/su/user.htm" method="post" onSubmit="return checkForm();">
<TABLE width="95%" border="0" cellspacing="0" cellpadding="0">
<TR>
<TD width="14%" height="35" class="trDashedUL"><LABEL for="email">Email:</LABEL> <INPUT name="id" type="hidden" id="id" value="${frmUser.id}"></TD>
<TD width="43%" class="trDashedUL"><INPUT name="email" type="text" class="inputFullSize" id="email" value="${frmUser.email}"></TD>
<TD width="43%" class="trDashedUL"><DIV class="errorMsg">${frmUserErr["valid.frmUser.email"]}</DIV></TD>
</TR>
<TR>
<TD height="35" class="trDashedUL"><LABEL for="fullName">Full name:</LABEL></TD>
<TD class="trDashedUL"><INPUT name="fullName" type="text" class="inputFullSize" id="fullName" value="${frmUser.fullName}"></TD>
<TD class="trDashedUL"><DIV class="errorMsg">${frmUserErr["valid.frmUser.fullName"]}</DIV></TD>
</TR>
<TR>
<TD height="35" class="trDashedUL"><LABEL for="role">Role :</LABEL></TD>
<TD class="trDashedUL"><SELECT name="role"  class="inputFullSize" id="role" <c:if test="${personCurId eq frmUser.id}">disabled="disabled"</c:if>  >
<c:forEach items="${personRoles}" var="role">
<OPTION value="${role}" <c:if test="${frmUser.role eq role}">SELECTED</c:if> >${role}</OPTION>
</c:forEach>
</SELECT></TD>
<TD class="trDashedUL"><DIV class="errorMsg">${frmUserErr["valid.frmUser.role"]}</DIV></TD>
</TR>
<TR>
<TD height="35" class="trDashedUL"><LABEL for="timezone">Timezone:</LABEL></TD>
<TD class="trDashedUL"><SELECT name="timezone" class="inputFullSize" id="timezone">
<c:forEach items="${timezonesList}" var="tz">
<OPTION value="${tz.key}" <c:if test="${frmUser.timezone eq tz.key}">SELECTED</c:if> >${tz.value}</OPTION>
</c:forEach>
</SELECT></TD>
<TD class="trDashedUL"><DIV class="errorMsg">${frmUserErr["valid.frmUser.timezone"]}</DIV></TD>
</TR>
<TR>
<TD height="35" class="trDashedUL"><LABEL for="created">Created:</LABEL></TD>
<TD class="trDashedUL">${frmUser.created}<%--<INPUT name="created" type="text" class="inputFullSize" id="password5" value="${frmUser.created}" readonly>--%></TD>
<TD class="trDashedUL"><DIV class="errorMsg">${frmUserErr["valid.frmUser.created"]}</DIV></TD>
</TR>
<TR>
<TD height="35" class="trDashedUL"><LABEL for="updated">Updated:</LABEL></TD>
<TD class="trDashedUL">${frmUser.updated}<%--<INPUT name="updated" type="text" class="inputFullSize" id="password6" value="${frmUser.updated}" readonly>--%></TD>
<TD class="trDashedUL"><DIV class="errorMsg">${frmUserErr["valid.frmUser.updated"]}</DIV></TD>
</TR>
<TR>
<TD height="35">&nbsp;</TD>
<TD align="right"><INPUT type="submit" name="submit" id="submit" value="  Update  "></TD>
<TD>&nbsp;</TD>
</TR>
</TABLE>
<BR>
<TABLE width="95%" border="0" cellspacing="0" cellpadding="0">
<TR class="addressTableHeader">
<TD height="35">&nbsp;</TD>
<TD height="35">Address</TD>
<TD>&nbsp;</TD>
</TR>
<TR class="trDashedUL">
<TD width="14%" height="35" class="trDashedUL"><LABEL for="email">Country:</LABEL></TD>
<TD width="43%" class="trDashedUL"><INPUT name="country" type="text" class="inputFullSize" id="email" value="{frmUser.country}"></TD>
<TD><DIV class="errorMsg">${frmUserErr.country}</DIV></TD>
</TR>
<TR class="trDashedUL">
<TD height="35" class="trDashedUL"><LABEL for="fullName">City:</LABEL></TD>
<TD class="trDashedUL"><INPUT name="city" type="text" class="inputFullSize" id="fullname" value="{frmUser.city}"></TD>
<TD><DIV class="errorMsg">${frmUserErr.city}</DIV></TD>
</TR>
<TR class="trDashedUL">
<TD height="35" class="trDashedUL"><LABEL for="timezone">Street :</LABEL></TD>
<TD class="trDashedUL"><SELECT name="select2" id="select2">
</SELECT></TD>
<TD><DIV class="errorMsg">${frmUserErr.street}</DIV></TD>
</TR>
<TR class="trDashedUL">
<TD height="35" class="trDashedUL"><LABEL for="password7">House:</LABEL></TD>
<TD class="trDashedUL"><INPUT name="house" type="text" class="inputFullSize" id="password7" value="{frmUser.house}"></TD>
<TD><DIV class="errorMsg">${frmUserErr.house}</DIV></TD>
</TR>
<T class="trDashedUL"R>
<TD height="35">&nbsp;</TD>
<TD align="right"><INPUT type="submit" name="submit2" id="submit2" value="  Update  "></TD>
<TD>&nbsp;</TD>
</TR>
<TR>
<TD height="35">&nbsp;</TD>
<TD align="right">&nbsp;</TD>
<TD><INPUT type="submit" name="submit3" id="submit3" value="  Add more address  "></TD>
</TR>
</TABLE>
</FORM>
<BR>
</TD>
</TR>
</TABLE>
</BODY>
</HTML>