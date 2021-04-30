<div id="open-modal-signup">
	<div class="modal">
		<a href="#" class="close-modal" onclick="closeModal(this);">&#x2716;</a>
		<form action="${pageContext.request.contextPath}/signup" method="post" class="input">
			<div>
				<div><label for="fullname">Full name</label></div>
				<div><input type="fullname" name="fullname" id="fullname"
							autofocus></div>
				<c:if test="${signup-errors.fullname != ''}">
					<span class="errors">${signup-errors.fullname}</span>
				</c:if>
			</div>
			<div>
				<div><label for="signup-email">Email</label></div>
				<div><input type="email" name="email" id="signup-email"
							title="Ne dois pas avoir de caracteres speciaux"
							></div>
				<c:if test="${signup-errors.email != ''}">
					<span class="errors">${signup-errors.email}</span>
				</c:if>
			</div>
			<div>
				<div><label for="signup-password">Password</label></div>
				<div><input type="password" name="password" id="signup-password"></div>
				<c:if test="${signup-errors.password != ''}">
					<span class="errors">${signup-errors.password}</span>
				</c:if>
			</div>
			<div>
				<div><label for="repassword">Password Verify</label></div>
				<div><input type="password" name="repassword" id="repassword">
				</div>
				<c:if test="${signup-errors.rePassword != ''}">
					<span class="errors">${signup-errors.rePassword}</span>
				</c:if>
			</div>
			<div>
				<p class="center"><a href="#open-modal-signin">Sign In</a></p>
			</div>
			<div class="center">
				<button type="submit">Sign up</button>
			</div>
		</form>
	</div>
</div>