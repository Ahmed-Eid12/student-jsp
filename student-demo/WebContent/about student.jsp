<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<!-- about students css link-->
<link rel="stylesheet" href="about-student.css">

<!-- bootstrap link-->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Student Info</title>
</head>
<body>
	<div class="header-content">
			<h1>About Students</h1>
			<a href="index.jsp">Home</a>
	</div>
	<div class="container">
			<section>
					<div class="form-contents">
						<form action="${AddNewStudent}" method="POST" class="form-group">
							<div class="form-content">
								<label for="student-name">Student Name:</label>
								<input type="text" id="student-name" placeholder="Name" name="student-name" class="form-control">
							</div>
							<div class="form-content">
								<label for="student-email">Student Email:</label>
								<input type="email" id="student-email" placeholder="Email" class="form-control" name="student-email">
							</div>
							<div class="form-content">
								<label for="student-dept">Student Department:</label>
								<input type="text" id="student-dept" placeholder="Department" class="form-control" name="student-department">
							</div>
							<input type="submit" value="Save Student" name="addStudent">
						</form>
					</div>
				</section>
	</div>
	<div class="about-student-table">

	</div>
</body>
</html>