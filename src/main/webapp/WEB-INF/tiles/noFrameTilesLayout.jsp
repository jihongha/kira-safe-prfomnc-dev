<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles"  prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
    <tiles:insertAttribute name="loadFile"/>
</head>
<body>
<div id="wrap">
 
    <div id="body">
    	<tiles:insertAttribute name="body"/>
    </div>
 
</div>
</body>
</html>
