<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section class="carroussel">
	<article>
		<img src="${pageContext.request.contextPath}/assets/img/femme-hamac-livre.jpg" alt="">
	</article>
</section>
<div class="container">
	<main class="index">
		<h2>Recents books</h2>
		<section>
			<c:forEach items="${books}" var="book">
				<a href="${pageContext.request.contextPath}/books?id=${book.id}">
					<article>
						<img src="${book.thumbnail}" alt="">
						<h5>${book.title}</h5>
						<h6>${book.publishedDate}</h6>
					</article>
				</a>
			</c:forEach>
		</section>
	</main>
</div>
