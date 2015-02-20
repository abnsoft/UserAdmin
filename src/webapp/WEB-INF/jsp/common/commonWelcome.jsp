<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sprSec" uri="http://www.springframework.org/security/tags"%>

<c:if test="${sessionScope.userName!=null}">Hello ${sessionScope.userName} </c:if>[<a href="<c:url value="/logout"/>">Logout</a>]
