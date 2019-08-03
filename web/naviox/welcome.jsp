<%@include file="../xava/imports.jsp"%>

<%@page import="org.openxava.application.meta.MetaApplications"%>
<%@page import="org.openxava.application.meta.MetaApplication"%>

<%-- To put your own text add entries in the i18n messages files of your project --%>

<%
String applicationName = request.getContextPath().substring(1);
MetaApplication metaApplication = MetaApplications.getMetaApplication(applicationName);
%>

<h1>Consultorio Jurídico</h1>

