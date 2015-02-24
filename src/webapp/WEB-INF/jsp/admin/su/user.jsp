<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<HEAD>
	<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<TITLE>Insert title here</TITLE>
	
<LINK href="<c:url value='/rs/css/main.css' />" rel="stylesheet" type="text/css" />

<SCRIPT type='text/javascript' src='<c:url value="/rs/js/jquery-2.1.3.js" />'></SCRIPT>
<SCRIPT type="text/javascript">

$(document).ready(function() {
		var count=0;
		$('#moreAddr').click( function () {
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
		});
	
});

try{ 
	var frmEl = ["country","city","street","houseNumber"]
	var prefix = '${pageContext.request.contextPath}';

	// function for edit address link 
	function editAddr(id) { 
		/*
		var f = document.forms['fa'+id];
		$("#addrEdit"+id).hide(0);
		for(i=0;i<frmEl.length;i++){
			s=frmEl[i];
			se='#addressList\\['+id+'\\]\\.'+s;
			sl='#l'+s+id;
			$(sl).hide(0);
			
			$(se).attr('disabled', false);
			$(se).attr('readonly', false);
			$(se).fadeIn("slow");			
		}
		// define post handler 
		sb="#addrSubmit"+id;
		$(sb).attr('disabled', false);
		$(sb).fadeIn("slow");
//		$("#selectedFrmId").val(id);
		*/
		f1(false,true,id);
		//
		$(sb).click(function(){
			//alert( $("#fa"+id).serialize() );
			$.ajax({
				type: "POST",
				url: prefix + '/admin/rest/saveAddress',
				data: $("#fa"+id).serialize(),
				success: function(response){	
					console.log("SUCCESS");				
					// we have the response
					if(response.status == "OK"){
						 console.log("AJAX OK");
						 var r=response.object;
						 console.log( "res="+response.object );
						 f2(r,id);
					 }else{
						 console.log("AJAX ERROR : "+response.message);
						 errorInfo = "";
						alert(" ERROR "+response ) ;
					 }
				 },
				 error: function(e){
					 alert('Error: ' + e);
				 }
			});
		

		})
	}
	// ------ fade=true => IN, false => OUT
	var f1=function(status,fade,id){
		alert('a1');
		var f = document.forms['fa'+id];
		if(fade){$("#addrEdit"+id).hide(0);}else{$("#addrEdit"+id).show(0);}
		for(i=0;i<frmEl.length;i++){
			s=frmEl[i];
			se='#addressList\\['+id+'\\]\\.'+s;
			sl='#l'+s+id;
			$(sl).hide(0);
			
			$(se).attr('disabled', status);	// f
			$(se).attr('readonly', status);	// f
			if(fade){$(se).fadeIn("slow");}else{$(se).fadeOut("slow");};
		}
		// define post handler 
		sb="#addrSubmit"+id;
		$(sb).attr('disabled', status);	// f
		if(fade){$(sb).fadeIn("slow");}else{$(sb).fadeOut("slow");}
	};
	// ------ 
	var f2=function(r,id){
		alert("a2+"+id);
		// labels 
		//$("#laddressId"+id).html(r.id);
		$("#lcountry"+id).html(r.country);
		$("#lcity"+id).html(r.city);
		$("#lstreet"+id).html(r.street);
		$("#lhouseNumber"+id).html(r.houseNumber);
		// form
		//$("#addressList\\["+id+"\\]\\.id").html(r.id);
		$("#addressList\\["+id+"\\]\\.country").html(r.country);
		$("#addressList\\["+id+"\\]\\.city").html(r.city);
		$("#addressList\\["+id+"\\]\\.street").html(r.street);
		$("#addressList\\["+id+"\\]\\.houseNumber").html(r.houseNumber);
		// fade
		f1(true,false,id);
	};
	// -------------------------------------------------------------
	var RestPost = function() {
		$.ajax({
			type: 'POST',
			url:  prefix + '/admin/rest/saveAddress2.htm',
			dataType: 'json',
			async: true,
			success: function(result) {
				alert('At ' + result.time
					+ ': ' + result.message);
			},
			error: function(jqXHR, textStatus, errorThrown) {
				alert(jqXHR.status + ' ' + jqXHR.responseText);
			}
		});
	}


}catch(e){

}
</SCRIPT>

</HEAD>
<BODY>
    <TABLE width="780" border="0" align="center" cellpadding="0" cellspacing="0">
        <TR>
            <TD width="50%" height="30" align="left">[<A
                href="${pageContext.request.contextPath}/admin/users-list.htm">User list</A>]
            </TD>
            <TD width="50%" align="right"><jsp:include page="../../common/commonWelcome.jsp" /></TD>
        </TR>
    </TABLE>
    <TABLE width="780" border="0" align="center" cellpadding="0" cellspacing="0" class="loginTable">
        <TR>
            <TD height="40" align="center" class="loginTableHeader">User info</TD>
        </TR>
        <TR>
            <TD height="300" align="center"><BR>
                <FORM id="frm1" action="${pageContext.request.contextPath}/admin/su/user.htm" method="post"
                    onSubmit="return checkForm();">
                    <TABLE width="95%" border="0" cellspacing="0" cellpadding="0">
                        <TR>
                            <TD height="35" class="trDashedUL">ID:</TD>
                            <TD class="trDashedUL">${frmUser.id}</TD>
                            <TD class="trDashedUL">&nbsp;</TD>
                        </TR>
                        <TR>
                            <TD width="14%" height="35" class="trDashedUL"><LABEL for="email">Email:</LABEL>
                                <INPUT name="id" type="hidden" id="id" value="${frmUser.id}"></TD>
                            <TD width="43%" class="trDashedUL"><INPUT name="email" type="text"
                                class="inputFullSize input" id="email" value="${frmUser.email}"></TD>
                            <TD width="43%" class="trDashedUL"><DIV class="errorMsg">${frmUserErr["valid.frmUser.email"]}</DIV></TD>
                        </TR>
                        <TR>
                            <TD height="35" class="trDashedUL"><LABEL for="fullName">Full name:</LABEL></TD>
                            <TD class="trDashedUL"><INPUT name="fullName" type="text"
                                class="inputFullSize input" id="fullName" value="${frmUser.fullName}"></TD>
                            <TD class="trDashedUL"><DIV class="errorMsg">${frmUserErr["valid.frmUser.fullName"]}</DIV></TD>
                        </TR>
                        <TR>
                            <TD height="35" class="trDashedUL"><LABEL for="role">Role :</LABEL></TD>
                            <TD class="trDashedUL"><SELECT name="role" class="inputFullSize input"
                                id="role" <c:if test="${personCurId eq frmUser.id}">disabled="disabled"</c:if>>
                                    <c:forEach items="${personRoles}" var="role">
                                        <OPTION value="${role}"
                                            <c:if test="${frmUser.role eq role}">SELECTED</c:if>>${role}</OPTION>
                                    </c:forEach>
                            </SELECT></TD>
                            <TD class="trDashedUL"><DIV class="errorMsg">${frmUserErr["valid.frmUser.role"]}</DIV></TD>
                        </TR>
                        <TR>
                            <TD height="35" class="trDashedUL"><LABEL for="timezone">Timezone:</LABEL></TD>
                            <TD class="trDashedUL"><SELECT name="timezone" class="inputFullSize input"
                                id="timezone">
                                    <c:forEach items="${timezonesList}" var="tz">
                                        <OPTION value="${tz.key}"
                                            <c:if test="${frmUser.timezone eq tz.key}">SELECTED</c:if>>${tz.value}</OPTION>
                                    </c:forEach>
                            </SELECT></TD>
                            <TD class="trDashedUL"><DIV class="errorMsg">${frmUserErr["valid.frmUser.timezone"]}</DIV></TD>
                        </TR>
                        <TR>
                            <TD height="35" class="trDashedUL"><LABEL for="created">Created:</LABEL></TD>
                            <TD class="trDashedUL">${frmUser.created}<%--<INPUT name="created" type="text" class="inputFullSize input" id="password5" value="${frmUser.created}" readonly>--%></TD>
                            <TD class="trDashedUL"><DIV class="errorMsg">${frmUserErr["valid.frmUser.created"]}</DIV></TD>
                        </TR>
                        <TR>
                            <TD height="35" class="trDashedUL"><LABEL for="updated">Updated:</LABEL></TD>
                            <TD class="trDashedUL">${frmUser.updated}<%--<INPUT name="updated" type="text" class="inputFullSize input" id="password6" value="${frmUser.updated}" readonly>--%></TD>
                            <TD class="trDashedUL"><DIV class="errorMsg">${frmUserErr["valid.frmUser.updated"]}</DIV></TD>
                        </TR>
                        <TR>
                            <TD height="35">&nbsp;</TD>
                            <TD align="right"><INPUT type="submit" name="submit" id="submit"
                                value="  Update  "></TD>
                            <TD>&nbsp;</TD>
                        </TR>
                    </TABLE>
                </FORM> <BR>

                <TABLE width="95%" border="0" cellpadding="0" cellspacing="3" id="addTMPL"
                    style="display: none;">
                    <TR class="addressTableHeader">
                        <TD width="12%" height="35">&nbsp;</TD>
                        <TD width="36%" height="35">Address</TD>
                        <TD width="52%">&nbsp;</TD>
                    </TR>
                    <TR class="trDashedUL">
                        <TD width="12%" height="35" class="trDashedUL"><LABEL for="addressListX.country">Country:</LABEL></TD>
                        <TD width="37%" class="trDashedUL"><INPUT name="addressListX.country" type="text"
                            class="inputFullSize" id="addressListX.country"></TD>
                        <TD width="51%" class="trDashedUL"><DIV class="errorMsg"></DIV></TD>
                    </TR>
                    <TR class="trDashedUL">
                        <TD height="35" class="trDashedUL"><LABEL for="addressListX.city">City:</LABEL></TD>
                        <TD class="trDashedUL"><INPUT name="addressListX.city" type="text"
                            class="inputFullSize" id="addressListX.city"></TD>
                        <TD class="trDashedUL"><DIV class="errorMsg"></DIV></TD>
                    </TR>
                    <TR class="trDashedUL">
                        <TD height="35" class="trDashedUL"><LABEL for="addressListX.street">Street
                                :</LABEL></TD>
                        <TD class="trDashedUL"><INPUT name="addressListX.street" type="text"
                            class="inputFullSize" id="addressListX.street"></TD>
                        <TD class="trDashedUL"><DIV class="errorMsg"></DIV></TD>
                    </TR>
                    <TR class="trDashedUL">
                        <TD height="35" class="trDashedUL"><LABEL for="addressListX.houseNumber">House:</LABEL></TD>
                        <TD class="trDashedUL"><INPUT name="addressListX.houseNumber" type="text"
                            class="inputFullSize" id="addressListX.houseNumber"></TD>
                        <TD class="trDashedUL"><DIV class="errorMsg"></DIV></TD>
                    </TR>
                </TABLE> <c:forEach items="${addrList}" var="addr" varStatus="ind">
${ind.index} = ${addr}

<FORM id="fa${ind.index}" action="${pageContext.request.contextPath}/admin/su/address.htm" method="post"
                        onSubmit="return checkAddress();">
                        <TABLE width="95%" border="0" cellspacing="0" cellpadding="0">
                            <TR class="addressTableHeader">
                                <TD height="35"><INPUT name="addressList[${ind.index}].id" type="hidden"
                                    id="addressList[${ind.index}].id" value="${addr.id}"> <INPUT
                                    name="personId" type="hidden" id="personId"
                                    value="${frmUser.id}">
<INPUT
                                    name="selectedFrmId" type="hidden" id="selectedFrmId"
                                    value="${ind.index}"></TD>
                                <TD height="35">[${ind.index+1}] Address</TD>
                                <TD class="trDashedUL">&nbsp;</TD>
                            </TR>
                            <TR class="trDashedUL">
                                <TD height="35" class="trDashedUL">ID:</TD>
                                <TD class="trDashedUL"><SPAN id="laddressId${ind.index}">${addr.id}</SPAN></TD>
                                <TD class="trDashedUL">&nbsp;</TD>
                            </TR>
                            <TR>
                                <TD width="14%" height="35" class="trDashedUL"><LABEL
                                    for="country${ind.index}">Country:</LABEL></TD>
                                <TD width="43%" class="trDashedUL"><SPAN id="lcountry${ind.index}">${addr.country}</SPAN><INPUT
                                    name="addressList[${ind.index}].country" type="text" disabled class="inputFullSize"
                                    id="addressList[${ind.index}].country" autocomplete="off" value="${addr.country}"
                                    readonly style="display: none"></TD>
                                <TD class="trDashedUL"><DIV class="errorMsg">${faErr.country}</DIV></TD>
                            </TR>
                            <TR>
                                <TD height="35" class="trDashedUL"><LABEL for="city${ind.index}">City:</LABEL></TD>
                                <TD class="trDashedUL"><SPAN id="lcity${ind.index}">${addr.city}</SPAN><INPUT
                                    name="addressList[${ind.index}].city" type="text" disabled class="inputFullSize"
                                    id="addressList[${ind.index}].city" autocomplete="off" value="${addr.city}" readonly
                                    style="display: none"></TD>
                                <TD class="trDashedUL"><DIV class="errorMsg">${faErr.city}</DIV></TD>
                            </TR>
                            <TR>
                                <TD height="35" class="trDashedUL"><LABEL for="street${ind.index}">Street
                                        :</LABEL></TD>
                                <TD class="trDashedUL"><SPAN id="lstreet${ind.index}">${addr.street}</SPAN><INPUT
                                    name="addressList[${ind.index}].street" type="text" disabled class="inputFullSize"
                                    id="addressList[${ind.index}].street" autocomplete="off" value="${addr.street}" readonly
                                    style="display: none"></TD>
                                <TD class="trDashedUL"><DIV class="errorMsg">${faErr.street}</DIV></TD>
                            </TR>
                            <TR>
                                <TD height="35" class="trDashedUL"><LABEL for="houseNumber${ind.index}">House:</LABEL></TD>
                                <TD class="trDashedUL"><SPAN id="lhouseNumber${ind.index}">${addr.houseNumber}</SPAN><INPUT
                                    name="addressList[${ind.index}].houseNumber" type="text" disabled class="inputFullSize"
                                    id="addressList[${ind.index}].houseNumber" style="display: none" autocomplete="off"
                                    value="${addr.houseNumber}" readonly></TD>
                                <TD class="trDashedUL"><DIV class="errorMsg">${faErr.houseNumber}</DIV></TD>
                            </TR>
                            <TR>
                                <TD height="35" align="center">&nbsp;</TD>
                                <TD align="right"><SPAN id="addrEdit${ind.index}"><A
                                        href="javascript:void(0);" onClick="return editAddr(${ind.index})">Edit</A></SPAN>&nbsp;
                                    <INPUT name="addrSubmit${ind.index}" type="button" disabled
                                    id="addrSubmit${ind.index}" value="   Save   " style="display: none"></TD>
                                <TD>&nbsp;</TD>
                            </TR>
                        </TABLE>
                    </FORM>
                </c:forEach> <SPAN id="trgt"></SPAN>
                <TABLE width="95%" border="0" cellspacing="0" cellpadding="0">
                    <TR>
                        <TD width="14%" height="35">&nbsp;</TD>
                        <TD width="43%" align="left"><A href="javascript:void(0);" id="moreAddr">Add
                                more address</A></TD>
                        <TD>&nbsp;</TD>
                    </TR>
                </TABLE> <BR></TD>
        </TR>
    </TABLE>
</BODY>
</HTML>