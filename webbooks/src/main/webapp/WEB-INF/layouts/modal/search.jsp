<div id="open-modal-search">
    <div class="modal">
        <a href="#" class="close-modal" onClick="closeModal(this);">&#x2716;</a>
        <div class="input">
            <input type="text" name="search" id="search"
                   placeholder="Enter isbn/title/author" data-url="${pageContext.request.contextPath}/"
                   onKeyUp="searchBooks(this);" autoFocus>
        </div>
        <div class="response" id="response"></div>
    </div>
</div>