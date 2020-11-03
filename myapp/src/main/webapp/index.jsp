<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>


	<div class="form-horizontal">
		<div class="form-group">



			<label class="control-label col-sm-2" for="email">select
				category:</label>

			<div class="col-sm-10">
				<select onchange="catchange(this.value)" class="form-control">
					<option>select category</option>
					<option value="1">cat1</option>

					<option value="2">cat2</option>
					<option value="3">cat3</option>

				</select>
			</div>
		</div>
	</div>

	<div class="form-horizontal">
		<div class="form-group">

			<label class="control-label col-sm-2" for="email">select
				sub-category:</label>

			<div class="col-sm-10">
				<select id="subcat"  class="form-control">

				</select>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		function catchange(id) {
			$.ajax({
				type : 'post',
				data : {
					'id' : id
				},
				url : 'listajax',
				dataType : 'json',
				success : function(data) {
					
					$("#subcat").empty();
				
					var select = document.getElementById('subcat');

					for ( var i in data) {
						console.log(data[i].name);
						$(select).append(
								'<option value=' + data[i].id + '>'
										+ data[i].name + '</option>');
					}
				},
				error : function(res) {
					$('#message').text('Error!');
					$('.dvLoading').hide();
				}
			});
		}
	</script>
</body>
</html>
