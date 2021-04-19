<div id="question">
<h1>${ quiz.question }</h1>

<form action="" method="post">
	<c:forEach items="${ quiz.choices }" var="choice">
	<div class="input-choice">
	<label for="{choice.id}">${ choice.name }</label>
	<input type="radio" id= "{choice.id}" name="response" value="${ choice.name }">
	</div>
	</c:forEach>
	
	<button>Valider</button>
</form>
</div>