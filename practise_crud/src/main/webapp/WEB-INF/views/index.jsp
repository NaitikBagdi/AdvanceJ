<html>
<body>
<head>
<%@include file="./base.jsp"%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
</body>


<div class="container mt-3">
	<div class="row">
		<div class='col-md-12'>
			<h1>User data</h1>
			<div class="container text-right">
				<a href="add-user" class="btn btn-outline-success">Add user</a>
			</div>
			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th scope="col">Id</th>
						<th scope="col">First Name</th>
						<th scope="col">Last Name</th>
						<th scope="col">Date of birth</th>
						<th scope="col">Mobile Number</th>
						<th scope="col">Address1</th>
						<th scope="col">Address2</th>
						<th scope="col">Age</th>
						<th scope="col">Gender</th>
						<th scope="col">Email</th>
						<th scope="col">Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${users}" var="user">
						<tr>
							<th scope="row">${user.id}</th>
							<td>${user.firstName}</td>
							<td>${user.lastName}</td>
							<td>${user.dateOfBirth}</td>
							<td>${user.mobile}</td>
							<td>${user.address1}</td>
							<td>${user.address2}</td>
							<td>${user.age}</td>
							<td>${user.gender}</td>
							<td>${user.email}</td>
							<td><a href="delete/${user.id}">
								<i class="fa-solid fa-trash fa-lg text-danger mr-2 cursor-pointer"
									style="cursor: pointer;"></i></a>
									<a href="update/${user.id}">
								<i class="fa-regular fa-pen-to-square fa-lg text-primary "
								style="cursor: pointer;"></i></a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
</html>
