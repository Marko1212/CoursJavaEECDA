<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <link
      rel="stylesheet"
      href="${ pageContext.request.contextPath }/assets/css/style.css"
    />
    <title>Quiz - ${title}</title>
</head>
<body>

<div class="container">

	<c:if test="${ page != null }">
		<c:import url="pages/${page}.jsp" />
	</c:if>

</div>

</body>
</html>