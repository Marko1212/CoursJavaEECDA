<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport"
			  content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
		<meta http-equiv="X-UA-Compatible" content="ie=edge">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">
		<title>WebBooks<c:if test="title"> - ${title}</c:if>
		</title>
	</head>
	<body>
		<header>
			<div class="logo">
				<object data="${pageContext.request.contextPath}/assets/img/book_icon.svg"
						type=""
						width="64"></object>
				<h1>WebBooks</h1>
			</div>
			<nav>
				<ul>
					<li class="${header_active == "Home" ? 'active' : ''}">
						<a href="${pageContext.request.contextPath}/">Home</a>
					</li>
					<li class="${header_active == "Contact" ? 'active' : ''}">
						<a href="${pageContext.request.contextPath}/contact">Contact</a>
					</li>
					<li onclick="openModal(this);">
						<a href="#open-modal-search">Search</a>
					</li>
					<li class="${header_active == "Settings" ? 'active' : ''}" id="nav-user">
						<c:if test="${sessionScope.user != null}">
							<a href="#open-settings">
								<img src="${pageContext.request.contextPath}/assets/img/cable_black_48dp.svg"
									 alt="">
							</a>
						</c:if>
						<c:if test="${sessionScope.user == null}">
						<a href="${sessionScope.user == null ? '#open-modal-signin' : '#open-modal-signup'}">
							<img src="${pageContext.request.contextPath}/assets/img/${sessionScope.user == null ? 'person_black_48dp' : 'cable_black_48dp'}.svg"
								 alt="">
						</a>
						</c:if>
					</li>
				</ul>
			</nav>
		</header>

		<div class="container">
			<c:if test="${page != null}">
				<c:import url="pages/${page}.jsp"/>
			</c:if>
		</div>

		<c:import url="layouts/modal/settings.jsp" />
		<c:import url="layouts/modal/search.jsp" />
		<c:import url="layouts/modal/signin.jsp" />
		<c:import url="layouts/modal/signup.jsp" />

		<script>
            function openModal(li) {
                document.querySelectorAll("nav > ul > li").forEach(li => li.className = "")
                li.classList.toggle("active");
            }

            function closeModal(a) {
                document.querySelectorAll("nav > ul > li").forEach(li => li.className = "")
            }

            function searchBooks(input) {
                const val = input.value;
                const url = input.dataset.url;
                // http://localhost:8080/webbooks/search?q=toto
                if (val.length > 1) {
                    fetch(url + 'search?q=' + val)
                        .then(response => {
                            let js = response.json()
                            return js
                        })
                        .then(json => {
                            console.log(json)
                            let str = "";
                            for (let b of json) {
                                if (b.title === undefined) {
                                    continue;
                                }
                                str += '<div><a href="' + url + 'books?id=' + b.id + ' " ><img src="' + b.thumbnail + '" alt=""><div class="search-description">'
                                str += '<span>' + b.title + '</span>'
                                str += '<span>' + b.language + '</span>'
                                str += '<span>' + b.publishedDate + '</span>'
                                str += '</div></a></div>'
                            }
                            document.getElementById("response").innerHTML = str;
                        });
                } else {
                    document.getElementById("response").innerHTML = "";
                }
            }

            window.addEventListener('hashchange', function () {
                const hash = window.top.location.hash.substr(1);
                if (hash.length > 0) {
                    if (hash === "open-settings") {
                        const div = document.getElementById("nav-user")
                        const url = new URL(location.href)
                        url.hash = ""
                        div.querySelector("a").href = url
                    } else {
                        const div = document.getElementById(hash)
                        div.querySelector("input:first-child").focus()
                    }
                }
            })

		</script>
	</body>
</html>
