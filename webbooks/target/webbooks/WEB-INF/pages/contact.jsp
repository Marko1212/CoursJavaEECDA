<main class="contact">
	<form action="${pageContext.request.contextPath}/contact" method="post">
		<div>
			<div><label for="fullname">Full name</label></div>
			<div><input type="text" name="fullname" id="fullname"
						title="Ne dois pas avoir de caracteres speciaux"
						value="${contact.fullname}"></div>
			<c:if test="${errors.fullname != ''}">
				<span class="errors">${errors.fullname}</span>
			</c:if>
		</div>
		<div>
			<div><label for="email">Email</label></div>
			<div><input type="email" name="email" id="email" value="${contact.email}"></div>
			<c:if test="${errors.email != ''}">
				<span class="errors">${errors.email}</span>
			</c:if>
		</div>
		<div>
			<div><label for="message">Message</label></div>
			<div><textarea name="message" id="message" title="20 caractères minimum">${contact.message}</textarea></div>
			<c:if test="${errors.message != ''}">
				<span class="errors">${errors.message}</span>
			</c:if>
		</div>
		<div>
			<button type="submit">Send email</button>
		</div>
	</form>
</main>
