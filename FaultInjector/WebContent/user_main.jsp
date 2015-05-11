<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Fault Injector: User main menu</title>
<meta name="description" content="">
<meta name="author" content="ink, cookbook, recipes">
<meta name="HandheldFriendly" content="True">
<meta name="MobileOptimized" content="320">
<meta name="mobile-web-app-capable" content="yes">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">

<!-- Place favicon.ico and apple-touch-icon(s) here  -->
<link rel="shortcut icon" href="ink-3.1.2/img/favicon.ico">
<link rel="apple-touch-icon" href="ink-3.1.2/img/touch-icon-iphone.png">
<link rel="apple-touch-icon" sizes="76x76"
	href="ink-3.1.2/img/touch-icon-ipad.png">
<link rel="apple-touch-icon" sizes="120x120"
	href="ink-3.1.2/img/touch-icon-iphone-retina.png">
<link rel="apple-touch-icon" sizes="152x152"
	href="ink-3.1.2/img/touch-icon-ipad-retina.png">
<link rel="apple-touch-startup-image"
	href="ink-3.1.2/img/splash.320x460.png"
	media="screen and (min-device-width: 200px) and (max-device-width: 320px) and (orientation:portrait)">
<link rel="apple-touch-startup-image"
	href="ink-3.1.2/img/splash.768x1004.png"
	media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:portrait)">
<link rel="apple-touch-startup-image"
	href="ink-3.1.2/img/splash.1024x748.png"
	media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:landscape)">

<!-- load Ink's CSS -->
<link rel="stylesheet" type="text/css"
	href="ink-3.1.2/css/ink-flex.min.css">
<link rel="stylesheet" type="text/css" href="css/ink-custom.css">
<link rel="stylesheet" type="text/css"
	href="ink-3.1.2/css/font-awesome.min.css">

<!-- load Ink's CSS for IE8 -->
<!--[if lt IE 9 ]>
<link rel="stylesheet" href="ink-3.1.2/css/ink-ie.min.css" type="text/css" media="screen" title="no title" charset="utf-8">
        <![endif]-->

<!-- test browser flexbox support and load legacy grid if unsupported -->
<script type="text/javascript" src="ink-3.1.2/js/modernizr.js"></script>
<script type="text/javascript">
            Modernizr.load({
              test: Modernizr.flexbox,
              nope : '../css/ink-legacy.min.css'
            });
        </script>

<!-- load Ink's javascript files -->
<script type="text/javascript" src="ink-3.1.2/js/holder.js"></script>
<script type="text/javascript" src="ink-3.1.2/js/ink-all.min.js"></script>
<script type="text/javascript" src="ink-3.1.2/js/autoload.js"></script>

<style type="text/css">
body {
	background: #ededed;
}

header {
	border-bottom: 1px solid #cecece;
}

footer {
	background: #ccc;
}
</style>
</head>
<body>
	<div class="ink-grid">

		<!--[if lte IE 9 ]>
            <div class="ink-alert basic" role="alert">
                <button class="ink-dismiss">&times;</button>
                <p>
                    <strong>You are using an outdated Internet Explorer version.</strong>
                    Please <a href="http://browsehappy.com/">upgrade to a modern browser</a> to improve your web experience.
                </p>
            </div>
            <![endif]-->

		<!-- Add your site or application content here -->

		<!--             <div class="double-top-space"> -->
		<!-- 	            <header class="clearfix half-top-padding header-bar all-80"> -->
		<!-- 	                <div class="column-group"> -->
		<!-- 	                    <div class="all-25 small-100 tiny-100"></div> -->
		<!-- 	                    <div class="all-35 small-100 tiny-100"><h1>Fault injector</h1></div> -->
		<!-- 	                    <div class="all-40 small-100 tiny-100"></div> -->
		<!-- 	                </div> -->
		<!-- 	            </header> -->
		<!--             </div> -->

		<header class="clearfix vertical-padding">

		<h1 class="logo xlarge-push-left large-push-left">
			FAULT INJECTOR<small>smaller text</small>
		</h1>
		</header>

		<div class="column-group gutters">
			<div class="all-80">
				<nav class="ink-navigation half-top-space">
				<ul class="breadcrumbs">
					<li class="active"><a href="#">Home</a></li>
				</ul>
				</nav>
			</div>
		</div>

		<div class="column-group">
			<div class="all-20 small-100 tiny-100"></div>
			<div class="all-40 small-100 tiny-100">
				<h2 class="bottom-space">User main menu</h2>
			</div>
			<div class="all-40 small-100 tiny-100"></div>
		</div>

		<div class="column-group">
			<div class="all-15 small-100 tiny-100"></div>
			<div class="all-45 small-100 tiny-100">
				<h4>Experiment selection</h4>
				<hr />

				<table id="experiments" class="ink-table grey tableSection">
					<thead>
						<tr>
							<th colspan="5" class="align-left">Select the experiment to
								run:</th>
						</tr>
					</thead>
					<tbody>
						<s:if test="experiments.size > 0">
							<s:iterator value="experiments">
								<tr id="row_<s:property value="i"/>">
									<td class="all-100"><a
										href="<s:url action="showexperiment"><s:param name="id"><s:property value="exp_id"/></s:param></s:url>"><s:property
												value="name" /></a></td>
									<td class="all-15"><a
										href="<s:url action="editexperiment"><s:param name="id"><s:property value="exp_id"/></s:param></s:url>">edit</a></td>
									<td class="all-5">|</td>
									<td class="all-15"><a
										href="<s:url action="deleteexperiment"><s:param name="id"><s:property value="exp_id"/></s:param></s:url>">delete</a></td>
									<td class="all-5"><a class="help">?</a></td>
								</tr>
							</s:iterator>
						</s:if>
					</tbody>
				</table>

				<div id="help-experiments" class="ink-alert block info" role="alert"
					style="display: none">
					<button class="ink-dismiss">&times;</button>
					<h4>Experiment options menu</h4>
					<p>Here you can view, edit, delete or run previously created
						experiments, or alternatively start creating a new one.</p>
				</div>

				<div class="all-50 align-left">
					<form action="#">
						<button class="ink-button buttonSection" disabled>Run
							selected experiment</button>
					</form>
				</div>
				<h4 class="top-space">New Experiment</h4>
				<hr />
				<div class="all-50 align-left">
					<a href="clearnewexperimentforward" class="ink-button" id="create">Create
						new experiment...</a>
				</div>
			</div>
			<div class="all-20 small-100 tiny-100"></div>
		</div>
	</div>

	<div class="top-space"></div>

	<script src="js/jquery/jquery-1.11.2.js"></script>
	<script src="js/my-jquery.js"></script>

	<script type="text/javascript">
	        $(document).ready(function() {
// 	            $('.help').on('mouseover', function() {
// 	              $('#help-experiments').show();
// 	            });
	            
// 	            $('.help').on('mouseout', function() {
// 	                $('#help-experiments').hide();
// 	              });

				$('.help').click(function(event) {
					$('#help-experiments').show();
				});
	    	});
        </script>
</body>
</html>