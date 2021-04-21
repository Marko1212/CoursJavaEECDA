<div id="question">
	<h1>${ quiz.question }</h1>
	
	<form action="" method="post">
		
		<c:forEach items="${ quiz.choices }" var="choice">
		<div class="input-choice">
			<input type="radio" id="${ choice.id }" name="response" value="${ choice.id }" />
			<label for="${ choice.id }"
				   class="${choice.id == good_id ? 'good_answer' : choice.id == answer ? 'bad_answer' : ''}">
					${ choice.name }
			</label>
		</div>
		</c:forEach>		
		<input type="hidden" name="quiz_id" value="${ quiz.id }" />
		
		<div class="btn-submit">
			<c:if test="${answer == null}">
				<button id="submit">Valider</button>
			</c:if>

			<c:if test="${answer != null}">
				<a href="#open-modal">Anecdote</a>
			</c:if>
		</div>
	</form>


	<div id="open-modal" class="modal">
		<div>
			<h3>Anecdote</h3>
			<p>${quiz.anecdote}</p>
			<c:if test="${end}">
				<a href="${pageContext.request.contextPath}/the-end">
					Fini
				</a>
			</c:if>
			<c:if test="${!end}">
			<a href="${pageContext.request.contextPath}/questions?number_questions=${number_questions}">
				Question suivante
			</a>
			</c:if>
		</div>
	</div>

</div>

<script>
	const inputs = document.querySelectorAll(".container #question .input-choice input[type='radio']");
	// es6
	inputs.forEach(tag => {
	    tag.addEventListener('change', () => {
	        document.getElementById("submit").style.display = 'block';
		})
	});
	// es5
    // for (const tag of inputs) {
    //     tag.addEventListener('change', function() {
    //         document.getElementById("submit").style.display = 'block';
    //     });
    // }
</script>