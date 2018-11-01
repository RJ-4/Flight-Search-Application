<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Search Flights</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	</head>
	<body class = "bg-light">
		<h1 class = "text-light bg-secondary py-4 text-center">Flight Search</h1>
		<a href="login" class="pb-2 mr-4" style="float:right">logout</a>
		<div class = "container py-5 text-center text-light">

			<div class="row">
				<div class="col-5">
					<div class="card bg-info card-form">
						<div class="card-body">
							<h3 class = "py-4">Search Flights</h3>
							<form:form action="searchFlights" method="get" modelAttribute="flights">
								<div class="form-row">
									<div class="col">
										<div class="form-group">
											<form:input class="form-control" 
														placeholder="Departure Location" path="departureLocation"
														name="departureLocation"/>	
										</div>								
									</div>
									<div class="col">
										<div class="form-group">
											<form:input class="form-control" 
														placeholder="Arrival Location" path="arrivalLocation" 
														name="arrivalLocation"/>
										</div>
									</div>
								</div>		
								<div class="form-row">
									<div class="col">
										<div class="form-group">
											<input type="date" class="form-control" 
													placeholder="Departure Date (dd-mm-yyyy)" path="departureDate"
													name="departureDate"/>	
										</div>								
									</div>
								</div>
								<div class="form-row">
									<div class="col">
										<div class="form-group">
											Economy <form:radiobutton value="Economy" path="flightClass" checked="checked"
													name="flightClass"/>	
										</div>								
									</div>
									<div class="col">
										<div class="form-group">
											Business <form:radiobutton value="Business" path="flightClass"
													name="flightClass"/>	
										</div>								
									</div>
								</div>
								<div class="form-row">
									<div class="col">
										<div class="form-group">
											<select name="sort" class="form-control">	
												<option value="Sort by Fare" selected>Sort by Fare</option>
												<option value="Sort by Fare and Duration"> 
															 Sort by Fare and Duration</option>
											</select>
										</div>								
									</div>
								</div>
								<div class="form-group mt-4">
									<button type="submit" class="btn btn-outline-light btn-lg" value="Search">Search</button>
								</div>						
							</form:form>
						</div>					
					</div>
				</div>
				
				<div class="col-7">
					<img src="https://static.tacdn.com/img2/flights/airlines/hero_images/_GenericHero_1168x606.jpg"
							class="rounded-circle img-fluid">
				</div>
			</div>
		</div>
		<hr style="border-bottom: 1px solid black">
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
	</body>
</html>