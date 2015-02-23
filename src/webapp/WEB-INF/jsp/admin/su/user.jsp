<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<HEAD>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<TITLE>Insert title here</TITLE>

	<LINK href="<c:url value='/rs/css/main.css' />" rel="stylesheet" type="text/css" />
	
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
</FORM>
<BR>

<c:forEach items="${addrList}" var="addr" varStatus="ind">
${ind.index} = ${addr}

<FORM id="fa${ind.index}" action="${pageContext.request.contextPath}/admin/su/address.htm" method="post" onSubmit="return checkAddress();">
<TABLE width="95%" border="0" cellspacing="0" cellpadding="0">
<TR class="addressTableHeader">
<TD height="35"><SPAN class="trDashedUL">
<INPUT name="addressId" type="hidden" id="addressId" value="${addr.id}">
</SPAN></TD>
<TD height="35">Address</TD>
<TD>&nbsp;</TD>
</TR>
<TR class="trDashedUL">
<TD width="14%" height="35" class="trDashedUL"><LABEL for="country">Country:</LABEL></TD>
<TD width="43%" class="trDashedUL"><INPUT name="country" type="text" class="inputFullSize" id="country" form="fa" value="${addr.country}"></TD>
<TD><DIV class="errorMsg">${faErr.country}</DIV></TD>
</TR>
<TR class="trDashedUL">
<TD height="35" class="trDashedUL"><LABEL for="city">City:</LABEL></TD>
<TD class="trDashedUL"><INPUT name="city" type="text" class="inputFullSize" id="city" form="fa" value="${addr.city}"></TD>
<TD><DIV class="errorMsg">${faErr.city}</DIV></TD>
</TR>
<TR class="trDashedUL">
<TD height="35" class="trDashedUL"><LABEL for="street">Street :</LABEL></TD>
<TD class="trDashedUL"><INPUT name="street" type="text" class="inputFullSize" id="street" form="fa" value="${addr.city}"></TD>
<TD><DIV class="errorMsg">${faErr.street}</DIV></TD>
</TR>
<TR class="trDashedUL">
<TD height="35" class="trDashedUL"><LABEL for="house">House:</LABEL></TD>
<TD class="trDashedUL"><INPUT name="house" type="text" class="inputFullSize" id="house" form="fa" value="${addr.houseNumber}"></TD>
<TD><DIV class="errorMsg">${faErr.house}</DIV></TD>
</TR>
<T class="trDashedUL"R>
<TD height="35" align="center"><A href="javascript:void(0);">Add address</A></TD>
<TD align="right"><INPUT name="addrSubmit" type="submit" id="addrSubmit" form="fa" value="   Edit   "></TD>
<TD>&nbsp;</TD>
</TR>
</TABLE>
<TABLE width="95%" border="0" cellspacing="0" cellpadding="0">
<TR>
<TD width="14%" height="35">&nbsp;</TD>
<TD width="43%" align="right">&nbsp;</TD>
<TD>&nbsp;</TD>
</TR>
</TABLE>
</FORM>
</c:forEach>


<BR>
</TD>
</TR>
</TABLE>
<SCRIPT type="text/javascript">
var spryconfirm1 = new Spry.Widget.ValidationConfirm("spryconfirm1", "fullName");
</SCRIPT>
</BODY>
</HTML>