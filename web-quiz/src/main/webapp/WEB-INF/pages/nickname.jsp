
      <form
        action="${ pageContext.request.contextPath }/nickname"
        method="post"
      >
        <div>
          <label for="nickname">Veuillez rentrer un Pseudo</label>
          <div>
            <input
              type="text"
              name="nickname"
              id="nickname"
              placeholder="JCVM59, toto75019,..."
              value=${nickname}
              >
            <c:if test="${error != null}">
              <p style="color: red; font-size: 2rem;">${error}</p>
            </c:if>
          </div>
        </div>
        <div>
          <button type="submit">Suivant</button>
        </div>
      </form>