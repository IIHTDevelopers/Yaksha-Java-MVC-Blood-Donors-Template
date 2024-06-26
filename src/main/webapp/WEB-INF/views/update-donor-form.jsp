<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Add Blood Donor</title>
	</head>
	<body>
	<div class="container mt-4">
		<h2 class="bg-success text-center text-white p-3 rounded">Blood Donor Group </h2>
		<h3 class="text-center">Update Donor</h3>
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<hr>
				<form:form action="saveDonor" modelAttribute="donor" method="POST">
				<c:out value="${donor.gender}" />
					<!-- need to associate this data with donor id -->
					<form:hidden path="id"/>
					<div class="form-group">
						<label for="firstName">First Name <i class="text-info"><i class="fas fa-asterisk"></i></i></label>
						<form:errors path="firstName" cssClass="text-danger"/>
						<form:input path="firstName" name="firstName" class="form-control"/>
					</div>
					<div class="form-group">
						<label for="lastName">Last Name <i class="text-info"><i class="fas fa-asterisk"></i></i></label>
						<form:errors path="lastName" cssClass="text-danger"/>
						<form:input path="lastName" name="lastName" class="form-control"/>
					</div>
					<div class="form-group">
						<label for="email">Email <i class="text-info"><i class="fas fa-asterisk"></i></i></label>
						<form:errors path="email" cssClass="text-danger"/>
						<form:input path="email" name="email" class="form-control"/>
					</div>
                    <div class="form-group">
						<label for="mobileNumber">Mobile Number <i class="text-info"><i class="fas fa-asterisk"></i></i></label>
						<form:input type="number" path="mobileNumber" name="mobileNumber" class="form-control"/>
						<form:errors path="mobileNumber" cssClass="text-danger"/>
					</div>
					<div class="form-group">
                        <label for="gender">Gender <i class="text-info"><i class="fas fa-asterisk"></i></i></label>
                        <select name="gender" class="gender-dropdown">
                            <option value="">Select Gender</option>
                            <option value="male" ${donor.gender == 'male' ? 'selected' : ''}>Male</option>
                            <option value="female" ${donor.gender == 'female' ? 'selected' : ''}>Female</option>
                            <option value="other" ${donor.gender == 'other' ? 'selected' : ''}>Other</option>
                        </select>
                        <form:errors path="gender" cssClass="text-danger"/>
                    </div>

					<div class="form-group">
						<label for="state">State <i class="text-info"><i class="fas fa-asterisk"></i></i></label>
						<form:input path="state" name="state" class="form-control"/>
						<form:errors path="state" cssClass="text-danger"/>
					</div>
					<div class="form-group">
						<label for="city">City <i class="text-info"><i class="fas fa-asterisk"></i></i></label>
						<form:input path="city" name="city" class="form-control"/>
						<form:errors path="city" cssClass="text-danger"/>
					</div>
					<div class="form-group">
						<label for="bloodGroup">Blood Group <i class="text-info"><i class="fas fa-asterisk"></i></i></label>
						<form:input path="bloodGroup" name="bloodGroup" class="form-control"/>
						<form:errors path="bloodGroup" cssClass="text-danger"/>
					</div>

					<input type="submit" value="Save" class="btn btn-info btn-lg btn-block"/>
				</form:form>
			</div>
		</div>
		<a href="${pageContext.request.contextPath}/donor/list" class="badge badge-secondary">Back to List</a>
	</div>
	</body>
</html>