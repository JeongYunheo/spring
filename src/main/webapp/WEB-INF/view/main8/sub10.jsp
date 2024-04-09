<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- 웬만하면 .key 사용(이 더 편리함) --%>
<h1>${names.son}</h1>
<h1>${names.lee}</h1>
<h1>${names.kim}</h1>
<hr>
<h1>${names["son"]}</h1>
<h1>${names["lee"]}</h1>
<h1>${names["kim"]}</h1>
<hr>
<%-- 한글이거나 띄어쓰기가 있는 등.. 특수한 상황일때 주로 쓰임 --%>
<h1>${others["손흥민"]}</h1>
<h1>${others["lee kang in"]}</h1>
</body>
</html>
