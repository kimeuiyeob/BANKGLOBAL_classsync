<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>

<link href="static/css/DiffCheck.css" rel="stylesheet" type="text/css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="static/js/diff-match-patch.js"></script>
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

.flex-div {
	width: 25%;
	display: flex;
	justify-content: center;
}

.bigTitle {
	width: 200px;
}
</style>

<body>

	<div class="flex-container">
		<div class="flex-div">
			<div class="bigTitle">
				<h1 class="title" class="heading">${result1Name}</h1>
			</div>
		</div>
		<div class="flex-div">
			<div class="bigTitle">
				<h1 class="title" class="heading">${standardName}</h1>
			</div>
		</div>
		<div class="padding-right"></div>

		<div class="flex-div">
			<div class="bigTitle">
				<h1 class="title" class="heading">${standardName}</h1>
			</div>
		</div>
		<div class="flex-div">
			<div class="bigTitle">
				<h1 class="title" class="heading">${result2Name}</h1>
			</div>
		</div>
	</div>


	<div class="flex-container">
		<div class="flex-item">
			<div class="inner-content" id="box1">${result1}</div>
		</div>
		<div class="flex-item">
			<div class="inner-content" id="box2">${standardResult}</div>
		</div>

		<div class="padding-right"></div>

		<div class="flex-item">
			<div class="inner-content" id="box3">${standardResult}</div>
		</div>

		<div class="flex-item">
			<div class="inner-content" id="box4">${result2}</div>
		</div>

	</div>

</body>

<script>
	var dmp = new diff_match_patch();

	function launch() {

		/* 1번,2번 2번기준으로 비교 */
		var text1 = $('#box1').text();
		var text2 = $('#box2').text();

		var d = dmp.diff_main(text1, text2);
		var ds = dmp.diff_prettyHtml(d);

		html_formatted = ds.replaceAll('{', '<br><br>{<br>').replaceAll(';',
				';<br>');

		$('#box2').html(html_formatted.replace(/&para;/g, ''));

		/* 3번,4번 3번기준으로 비교 */
		var text4 = $('#box4').text();
		var text3 = $('#box3').text();

		var d1 = dmp.diff_main(text4, text3);
		var ds2 = dmp.diff_prettyHtml(d1);

		html_formatted = ds2.replaceAll('{', '<br><br>{<br>').replaceAll(';',
				';<br>');

		$('#box3').html(html_formatted.replace(/&para;/g, ''));
	}

	launch();
</script>
</html>