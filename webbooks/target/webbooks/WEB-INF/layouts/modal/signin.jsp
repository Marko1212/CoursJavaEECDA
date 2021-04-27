<div id="open-modal-signin">
    <div class="modal">
        <a href="#" class="close-modal" onClick="closeModal(this);">&#x2716;</a>
        <form action="${pageContext.request.contextPath}/signin" method="post" class="input">
            <div>
                <div><label for="signin-email">Email</label></div>
                <div><input type="email" name="email" id="signin-email" autoFocus
                            ></div>

            </div>
            <div>
                <div><label for="signin-password">Password</label></div>
                <div><input type="password" name="password" id="signin-password" ></div>

            </div>
            <div>
                <p class="center"><a href="#open-modal-signup">Sign Up</a></p>
            </div>
            <div class="center">
                <button type="submit">Sign in</button>
            </div>
        </form>
    </div>
</div>