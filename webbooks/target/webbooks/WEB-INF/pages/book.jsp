<main class="one-book">
	<h1>${book.title}</h1>
	<section class="photo_description">
		<article>
			<img src="${book.thumbnail}" alt="">
		</article>
		<aside>
			<div class="row">
				<div>Auteur</div>
				<div>
					<c:forEach items="${book.authors}" var="author" varStatus="status">
						${author}${status.last ? '' : ','}
					</c:forEach>
				</div>
			</div>
			<div class="row">
				<div>Langage</div>
				<div>${book.language}</div>
			</div>
			<div class="row">
				<div>Date de parution</div>
				<div>${book.publishedDate}</div>
			</div>
			<c:forEach items="${book.industryId}" var="id">
				<c:if test="${id.type  == 'ISBN_13'}">
					<div class="row">
						<div>ISBN_13</div>
						<div>${id.identifier}</div>
					</div>
				</c:if>
				<c:if test="${id.type  == 'ISBN_10'}">
					<div class="row">
						<div>ISBN_10</div>
						<div>${id.identifier}</div>
					</div>
				</c:if>
				<c:if test="${id.type  == 'OTHER'}">
					<div class="row">
						<div>OTHER</div>
						<div>${id.identifier}</div>
					</div>
				</c:if>
			</c:forEach>

			<div class="row">
				<div>Nombres de pages</div>
				<div>${book.pageCount}</div>
			</div>
		</aside>
	</section>
	<section class="synopsis">
		<h2>Synopsis</h2>
		<p> ${book.description} </p>
	</section>
</main>