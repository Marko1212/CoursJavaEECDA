<h1>Choisis le nombre de questions désirées :</h1>

<div class="list-number-questions">
<c:forEach begin="5" end="20" step="5" var="i">
<div class="number-questions">
			<a href="${ pageContext.request.contextPath }/questions?number_questions=${i}">${ i }</a>
	</div>
</c:forEach>
</div>