<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<meta charset="utf-8">
    <title>Video Post Format - Philosophy</title>
    <meta name="description" content="">
    <meta name="author" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

    <link rel="stylesheet" href="resources/css/base.css">
    <link rel="stylesheet" href="resources/css/vendor.css">
    <link rel="stylesheet" href="resources/css/main.css">
	<link rel="stylesheet" href="resources/css/maindairy.css">
	<link rel="stylesheet" href="resources/css/nickdairy.css">
	
	<script src="resources/js/modernizr.js"></script>
    <script src="resources/js/pace.min.js"></script>
    
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
    <link rel="icon" href="favicon.ico" type="image/x-icon">

	<link rel="stylesheet" href="bootstrap.min.css">
	<link href="font-awesome.css" rel="stylesheet">
    <link rel="stylesheet" href="/dist/metisMenu.min.css">
    <link rel="stylesheet" href="/path/to/cdn/bootstrap.min.css" />
    <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
    
    <!-- <link href="simplePagination.css" rel="stylesheet" /> -->
	<!-- <link rel="stylesheet" href="resources/css/styles.css" /> -->
       
</head>
<body id="top">
	<%@ include file="header_menu.jsp"%>
	<%@ include file="account_form.jsp"%>
	<%@ include file="Sign_In.jsp"%>
	<section class="s-content s-content--narrow s-content--no-padding-bottom">

		<article class="row format-audio">
			<div class="container2">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-search"></i></span>
									<input class="form-control" id="livesearch"
										placeholder="영화 제목을 검색하세요." type="text" />
								</div>
							</div>
							<script type="text/javascript">
								var _gaq = _gaq || [];
								_gaq.push([ '_setAccount', 'UA-36251023-1' ]);
								_gaq.push([ '_setDomainName',
										'jqueryscript.net' ]);
								_gaq.push([ '_trackPageview' ]);

								(function() {
									var ga = document.createElement('script');
									ga.type = 'text/javascript';
									ga.async = true;
									ga.src = ('https:' == document.location.protocol ? 'https://ssl'
											: 'http://www')
											+ '.google-analytics.com/ga.js';
									var s = document
											.getElementsByTagName('script')[0];
									s.parentNode.insertBefore(ga, s);
								})();
							</script>
				<div id="jquery-script-menu">
					<div class="jquery-script-center">
						<ul>
							<div class="jquery-script-clear"></div>
					</div>
				</div>
					<div class="container">
						<div class="panel"></br>
						<h4>2020년 XX월 XX일 X요일</h4>
							<input type="text" id="title" placeholder="title" > 
							<input type="text" id="together" placeholder="together" style="display:inline"> 
							<input type="text" id="date" placeholder="date" style="display:inline"> 
							<input type="text" id="location" placeholder="location" style="display:inline">
							<a>별점 :</a>
							<span class="starR on">별1</span> <span class="starR">별2</span> <span
						class="starR">별3</span> <span class="starR">별4</span> <span
						class="starR">별5</span> </br>
							<input
								type="file" id='updatefile' data-value="http://www.google.es/"
								data-text="im_a_file.txt" />
						<div class="starRev">
						</div></div></div>
				<div class="s-content__header-title">
					<div id="editor" contenteditable="false">

						<section id="toolbar">
							<div id="bold" class="icon fas fa-bold"></div>
							<div id="italic" class="icon fas fa-italic"></div>
							<div id="underline" class="icon fas fa-underline"></div>
							<div id="strikeThrough" class="icon fas fa-strikethrough"></div>
							<div id="createLink" class="icon fas fa-link"></div>
							<div id="insertUnorderedList" class="icon fas fa-list-ul"></div>
							<div id="insertOrderedList" class="icon fas fa-list-ol"></div>
							<div id="justifyLeft" class="icon fas fa-align-left"></div>
							<div id="justifyRight" class="icon fas fa-align-right"></div>
							<div id="justifyCenter" class="icon fas fa-align-center"></div>
							<div id="justifyFull" class="icon fas fa-align-justify"></div>

						</section>
						<section id="page" contenteditable="true">
							<p id="page-content"></p>
						</section>
					</div>
					<div id='underbutton'>
					<button type="submit" 
						class="submit btn--primary btn--large full-width" style=" float: right; width: 20%;">저장하기</button>
					<button type="submit" 
						class="submit btn--primary btn--large full-width" style=" float: right; width: 20%;">삭제하기</button>
				</div></div>
		</article>
	</section>
    <!-- preloader
    ================================================== -->
    <div id="preloader">
        <div id="loader">
            <div class="line-scale">
                <div></div>
                <div></div>
                <div></div>
                <div></div>
                <div></div>
            </div>
        </div>
    </div>
    <%@ include file="footer.jsp"%>
	<script src="resources/js/jquery-3.2.1.min.js"></script>
    <script src="resources/js/plugins.js"></script>
    <script src="resources/js/main.js"></script>
    <script src="/path/to/cdn/jquery.min.js"></script>
    
    <script src="bootstrap.min.js"></script>
    <script src="/dist/jquery.metisMenu.js"></script>
    <script src="/path/to/cdn/jquery.min.js"></script>
	<script src="/path/to/build/bootstrap-rating-input.min.js"></script>
	<script src="/path/to/build/bootstrap4-rating-input.min.js"></script>
	<script src="/path/to/cdn/bootstrap.min.js"></script>
	<script src="https://use.fontawesome.com/5ac93d4ca8.js"></script>
	<script src="/path/to/cdn/jquery.min.js"></script>
	<script src="/path/to/jquery.simplePagination.js"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script type="text/javascript">
	
	  var _gaq = _gaq || [];
	  _gaq.push(['_setAccount', 'UA-36251023-1']);
	  _gaq.push(['_setDomainName', 'jqueryscript.net']);
	  _gaq.push(['_trackPageview']);
	
	  (function() {
	    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
	    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
	    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
	  })();

	</script>
	<script src="resources/js/script.js"></script>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="jquery.inputfile.js"></script>
	<script>
		 $('input[type="file"]').inputfile({
		        uploadText: '<span class="glyphicon glyphicon-upload"></span> Select a file',
		        removeText: '<span class="glyphicon glyphicon-trash"></span>',
		        restoreText: '<span class="glyphicon glyphicon-remove"></span>',
		        
		        uploadButtonClass: 'btn btn-primary',
		        removeButtonClass: 'btn btn-default'
		    });
		    </script>
		    <script type="text/javascript">
		
		  var _gaq = _gaq || [];
		  _gaq.push(['_setAccount', 'UA-36251023-1']);
		  _gaq.push(['_setDomainName', 'jqueryscript.net']);
		  _gaq.push(['_trackPageview']);
		
		  (function() {
		    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
		    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
		    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
		  })();					   
					
	</script>
</body>
</html>