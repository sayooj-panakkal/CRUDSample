<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="./base.jsp"%>
</head>
<body>

	<div class=" container mt-3">
		<div class="row">
			<div class="col-md-12">
				<h1 class="text-center mb-3">Welcome to Product App</h1>
				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col">Id</th>
							<th scope="col">Product Name</th>
							<th scope="col">Description</th>
							<th scope="col">Price</th>
							<th scope="col">Delete</th>
							<th scope="col">Update</th>
							
							
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${productlist }" var="p">
						<tr>
							<th scope="row">${p.id}</th>
							<td>${p.name}</td>
							<td>${p.description}</td>
							<td class="font-weight-bold"> &#x20b9;${p.price}</td>
							<td><a href="delete/${p.id} "><i class="fas fa-trash-alt text-danger"></i></a>
						    <td><a href="update/${p.id} "><i class="fas fa-pen-nib text-primary"></i></a> 
						</tr>
						</c:forEach>
						
					</tbody>
				</table>
				<div class="container text-center">
				<a href="add-product" class="btn btn-outline-success">Add Product</a>
				
			</div>
		</div>
</body>
</html>
