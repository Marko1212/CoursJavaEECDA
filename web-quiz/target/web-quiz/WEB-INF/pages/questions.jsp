<div id="question">
<h1>${ quiz.question }</h1>

<form action="" method="post">
	<c:forEach items="${ quiz.choices }" var="choice">
	<div class="input-choice">
	<input type="radio" id= "{choice.id}" name="response" value="${ choice.id }">
	<label for="{choice.id}">${ choice.name }</label>
	</div>
	</c:forEach>
	<input type="hidden" name="quiz_id" value="${ quiz.id }" />
	<div class="btn-submit">
	<button>Valider</button>
	</div>
</form>
</div>