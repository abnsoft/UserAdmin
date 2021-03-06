<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<HEAD>
	<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<TITLE>Insert title here</TITLE>
	
<LINK href="<c:url value='/rs/css/main.css' />" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="<c:url value='/rs/jquery-ui-1.13/jquery-ui.css' />">

<SCRIPT type='text/javascript' src='<c:url value="/rs/js/jquery-2.1.3.js" />'></SCRIPT>
<script type='text/javascript' src='<c:url value="/rs/jquery-ui-1.13/jquery-ui.js" />'></script>
<SCRIPT type="text/javascript">

$(document).ready(function() {
		var count=(parseInt( $('#savedAddressesNumber').val() )); // -1
		var flagNew=false;
		
		console.log( "init count="+count );
		
		$('#moreAddr').click( function () {
			console.log( "count in function = "+count ) ;
			console.log( 'savedAddressesNumber='+( parseInt($('#savedAddressesNumber').val())) );
			flagNew=true;
			console.log( "flagNew = "+flagNew ) ;
			//
			// check limit added new address form - only 1 new allowed
			//
			if(count>( parseInt($('#savedAddressesNumber').val()))){fSave();return;};
			// start clone 
			var clonedTag="#frmNew";
			var Clonedtable = $(clonedTag).clone(true).html(function(i, oldHTML){
				oldHTML = oldHTML.replace(/IndX/g, count);
				return oldHTML;
			});
			//
			Clonedtable.appendTo('#trgt');
			$("#trgt").html(function(i, txt){
			txt=	txt.replace(/addTMPL/g, "addTBL"+count);
				return txt;
			})
			$('#lTitleAddress'+count).html("["+(count+1)+"]");
			$("#addTBL"+count).show();
			// init button
			editAddr(count,flagNew);
			//
			count++;
			flagNew=false;
		});
	
});

try{ 
	var frmEl = ["country","city","street","houseNumber"]
	var prefix = '${pageContext.request.contextPath}';

	// function for edit address link 
	function editAddr(id,fl) { 
		f1(false,true,id);
		//
		sb="#addrSubmit"+id;
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
						fMsg(response.message,"msgSuccess",id);
						f2(r,id);
						// increment 
						if(fl){
							$('#savedAddressesNumber').val(id+1);
							console.log( "update savedAddressesNumber="+$('#savedAddressesNumber').val() );
						}
					 }else{
						console.log("AJAX ERROR : "+response.message);
						fMsg(response.message,"msgError");
					 }
				 },
				 error: function(e){
	
					 alert('Error occured!' + e.message);
				 }
			});
		

		})
	}
	// ---------------------
	var fMsg=function(m,c,id){
		var s="#lFrmAddress"+id;
		$(s).attr( "class", c );
		$(s).html(m);
		$(s).fadeIn("500");
		setTimeout(function() {
    		$(s).fadeOut('slow');
		}, 5000); // <-- time in milliseconds
	};
	// ------ fade=true => IN, false => OUT=hide
	var f1=function(status,fade,id){
		var f = document.forms['fa'+id];
		if(fade){$("#addrEdit"+id).hide(0);}else{$("#addrEdit"+id).fadeIn("slow");}
		for(i=0;i<frmEl.length;i++){
			s=frmEl[i];
			se='#addressList\\['+id+'\\]\\.'+s;
			sl='#l'+s+id;
			if(fade){$(sl).hide(0);}else{$(sl).fadeIn("slow");}
			
			$(se).attr('disabled', status);	// f
			$(se).attr('readonly', status);	// f
			if(fade){$(se).fadeIn("slow");}else{$(se).fadeOut(0);};
		}
		// define post handler 
		sb="#addrSubmit"+id;
		$(sb).attr('disabled', status);	// f
		if(fade){$(sb).fadeIn("slow");}else{$(sb).fadeOut(0);}
	};
	// ------ 
	var f2=function(r,id){
		// labels 
		$("#laddressId"+id).html(r.id);
		$("#lcountry"+id).html(r.country);
		$("#lcity"+id).html(r.city);
		$("#lstreet"+id).html(r.street);
		$("#lhouseNumber"+id).html(r.houseNumber);
		// form
		$("#addressList\\["+id+"\\]\\.id").val(r.id);
		$("#addressList\\["+id+"\\]\\.country").val(r.country);
		$("#addressList\\["+id+"\\]\\.city").val(r.city);
		$("#addressList\\["+id+"\\]\\.street").val(r.street);
		$("#addressList\\["+id+"\\]\\.houseNumber").val(r.houseNumber);
		// fade
		f1(true,false,id);
	};
	var fSave=function() {
    $( "#dialog-message" ).dialog({
      modal: true,
      buttons: {
        Ok: function() {
          $( this ).dialog( "close" );
        }
      }
    });
  }

}catch(e){

}
</SCRIPT>

</HEAD>
<BODY><div id="dialog-message" title="New Address" style="display:none">
  <p>
    <span class="ui-icon ui-icon-circle-check" style="float:left; margin:0 7px 50px 0;"></span>
    ${frmUserJsOnlyOneNewAddress}
  </p>
  
</div>
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
                            <TD class="trDashedUL">&nbsp;<SPAN class="msgSuccess" id="msgToUser">&nbsp;${msgToUser}</SPAN></TD>
                        </TR>
                        <TR>
                            <TD width="14%" height="35" class="trDashedUL"><LABEL for="email">Email:</LABEL>
                                <INPUT name="id" type="hidden" id="id" value="${frmUser.id}">
<INPUT name="savedAddressesNumber" type="hidden" id="savedAddressesNumber" value="${savedAddressesNumber}"></TD>
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
<span id="frmNew">
<FORM 
	id="faIndX" 
    action="${pageContext.request.contextPath}/admin/rest/saveAddress" 
    method="post" 
    onSubmit="return checkAddress();">
                <TABLE width="95%" border="0" cellpadding="0" cellspacing="3" id="addTMPL"  style="display: none;">
                    <TR class="addressTableHeader">
                        <TD width="12%" height="35"><INPUT name="addressList[IndX].id" type="hidden" id="addressList[IndX].id" value="0">
<INPUT name="personId" type="hidden" id="personId" value="${frmUser.id}">
<INPUT name="selectedFrmId" type="hidden" id="selectedFrmId" value="${savedAddressesNumber}"></TD>
                        <TD width="37%" height="35"><SPAN id="lTitleAddressIndX">&nbsp;</SPAN>&nbsp;Address</TD>
                        <TD width="52%">&nbsp;<SPAN class="msgSuccess" id="lFrmAddressIndX">&nbsp;</SPAN></TD>
                    </TR>
<TR class="trDashedUL">
<TD height="35" class="trDashedUL">ID:</TD>
<TD class="trDashedUL"><SPAN id="laddressIdIndX">NEW</SPAN></TD>
<TD class="trDashedUL">&nbsp;</TD>
</TR>
                    <TR class="trDashedUL">
                        <TD width="12%" height="35" class="trDashedUL"><LABEL for="addressList[IndX].country">Country:</LABEL></TD>
                        <TD width="37%" class="trDashedUL"><SPAN id="lcountryIndX">&nbsp;</SPAN><INPUT name="addressList[IndX].country" type="text"
                            class="inputFullSize" id="addressList[IndX].country"></TD>
                        <TD width="52%" class="trDashedUL"><DIV class="errorMsg"></DIV></TD>
                    </TR>
                    <TR class="trDashedUL">
                        <TD height="35" class="trDashedUL"><LABEL for="addressList[IndX].city">City:</LABEL></TD>
                        <TD class="trDashedUL"><SPAN id="lcityIndX">&nbsp;</SPAN><INPUT name="addressList[IndX].city" type="text"
                            class="inputFullSize" id="addressList[IndX].city"></TD>
                        <TD class="trDashedUL"><DIV class="errorMsg"></DIV></TD>
                    </TR>
                    <TR class="trDashedUL">
                        <TD height="35" class="trDashedUL"><LABEL for="addressList[IndX].street">Street
                                :</LABEL></TD>
                        <TD class="trDashedUL"><SPAN id="lstreetIndX">&nbsp;</SPAN> <INPUT name="addressList[IndX].street" type="text"
                            class="inputFullSize" id="addressList[IndX].street"></TD>
                        <TD class="trDashedUL"><DIV class="errorMsg"></DIV></TD>
                    </TR>
                    <TR class="trDashedUL">
                        <TD height="35" class="trDashedUL"><LABEL for="addressList[IndX].houseNumber">House:</LABEL></TD>
                        <TD class="trDashedUL"><SPAN id="lhouseNumberIndX">&nbsp;</SPAN> <INPUT name="addressList[IndX].houseNumber" type="text"
                            class="inputFullSize" id="addressList[IndX].houseNumber"></TD>
                        <TD class="trDashedUL"><DIV class="errorMsg"></DIV></TD>
                    </TR>
<TR>
<TD height="35" align="center">&nbsp;</TD>
<TD align="right"><SPAN id="addrEditIndX" style="display:none"><A
                                        href="javascript:void(0);" onClick="return editAddr(IndX)">Edit</A></SPAN>&nbsp;<INPUT name="addrSubmitIndX" type="button" id="addrSubmitIndX" value="   Save   " style=""></TD>
<TD>&nbsp;</TD>
</TR>
                </TABLE> 
</FORM></span>
                
<c:forEach items="${addrList}" var="addr" varStatus="ind">
                
<FORM id="fa${ind.index}" action="${pageContext.request.contextPath}/admin/su/address.htm" method="post"onSubmit="return checkAddress();">
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
                            <TD class="trDashedUL">&nbsp;<SPAN class="msgSuccess" id="lFrmAddress${ind.index}">&nbsp;</SPAN></TD>
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
</c:forEach> 
                
            <SPAN id="trgt"></SPAN>
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