<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ page import="service.*"%>
<%@ page import="dto.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.time.LocalDate"%>
<%@ page import="java.time.format.DateTimeFormatter"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<link href="static/css/ClassOmm.css" rel="stylesheet" type="text/css">

<style>
.title {
	font-family: 'Arial', sans-serif;
	color: #333;
	text-align: center;
	padding: 20px;
	background-color: #f0f0f0;
	border-radius: 8px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
	margin: 20px;
	max-width: 600px;
	margin-left: auto;
	margin-right: auto;
}

th, td {
	text-align: center;
}
</style>
<body>

	<h1 class="title">BPI, UBS, AFS Class Deploy Check</h1>

	<div id="dateType">
		<label for="dateInput">날짜 조회</label> <input type="date" id="dateInput"
			name="dateInput">
	</div>

	<table border="1">

		<thead>
			<tr>
				<th>클래스명</th>
				<th>배포된 시간</th>
				<th>서버 명</th>
				<th>BPI class</th>
				<th>BPI omm</th>
				<th>UBS class</th>
				<th>UBS omm</th>
				<th>AFS class</th>
				<th>AFS omm</th>
				<th>DIFF</th>
			</tr>
		</thead>

		<tbody id="classTableBody">

		</tbody>

	</table>

</body>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	/* AJAX */
	$(document).ready(function() {
		fetchData();

		$('#dateInput').change(function() {
			fetchData();
		});
	});

	function fetchData() {

		var today = new Date();
		var year = today.getFullYear();
		var month = String(today.getMonth() + 1).padStart(2, '0');
		var day = String(today.getDate()).padStart(2, '0');
		var todayDate = year + '-' + month + '-' + day;
		var selectedDate = $('#dateInput').val();

		if (selectedDate == "") {
			selectedDate = todayDate;
		}

		$.ajax({
			url : '/class_sync/classOmm?' + "date=" + selectedDate,
			method : 'GET',
			dataType : 'json',
			success : function(data) {

				var tbody = $('#classTableBody');
				tbody.empty();

				$.each(data, function(index, item) {
					var row = $('<tr>');
					row.append($('<td>').text(item.className));
					row.append($('<td>').text(item.time));
					row.append($('<td>').text(item.serverName));
					row.append($('<td>').text(item.aliceClass));
					row.append($('<td>').text(item.aliceOmm));
					row.append($('<td>').text(item.allanClass));
					row.append($('<td>').text(item.allanOmm));
					row.append($('<td>').text(item.aceClass));
					row.append($('<td>').text(item.aceOmm));

					var buttonCell = $('<td>');
					var button = $('<button>').text('check').attr('id',
							'myButton');
					buttonCell.append(button);
					row.append(buttonCell);

					tbody.append(row);
				});
			},
			error : function(xhr, status, error) {
				console.error('FAIL AJAX', error);
			}
		});
	}

	// 버튼 클릭 이벤트 처리
	$(document).on(
			'click',
			'#myButton',
			function() {

				var className = $(this).closest('tr').find('td:eq(0)').text();
				var serverName = $(this).closest('tr').find('td:eq(2)').text();

				window.location.href = '/class_sync/diffCheck?className='
						+ encodeURIComponent(className) + '&serverName='
						+ encodeURIComponent(serverName);
			});
</script>

</html>