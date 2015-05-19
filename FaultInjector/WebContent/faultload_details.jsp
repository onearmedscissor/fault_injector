<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Fault Injector: Faultload details</title>
<meta name="description" content="">
<meta name="author" content="ink, cookbook, recipes">
<meta name="HandheldFriendly" content="True">
<meta name="MobileOptimized" content="320">
<meta name="mobile-web-app-capable" content="yes">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">

<!-- Place favicon.ico and apple-touch-icon(s) here  -->

<link rel="shortcut icon" href="http://cdn.ink.sapo.pt/3.1.7/img/favicon.ico">
<link rel="apple-touch-icon" href="http://cdn.ink.sapo.pt/3.1.7/img/touch-icon-iphone.png">
<link rel="apple-touch-icon" sizes="76x76" href="http://cdn.ink.sapo.pt/3.1.7/img/touch-icon-ipad.png">
<link rel="apple-touch-icon" sizes="120x120" href="http://cdn.ink.sapo.pt/3.1.7/img/touch-icon-iphone-retina.png">
<link rel="apple-touch-icon" sizes="152x152" href="http://cdn.ink.sapo.pt/3.1.7/img/touch-icon-ipad-retina.png">
<link rel="apple-touch-startup-image" href="http://cdn.ink.sapo.pt/3.1.7/img/splash.320x460.png" media="screen and (min-device-width: 200px) and (max-device-width: 320px) and (orientation:portrait)">
<link rel="apple-touch-startup-image" href="http://cdn.ink.sapo.pt/3.1.7/img/splash.768x1004.png" media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:portrait)">
<link rel="apple-touch-startup-image" href="http://cdn.ink.sapo.pt/3.1.7/img/splash.1024x748.png" media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:landscape)">

<!-- load Ink's css from the cdn -->
<link rel="stylesheet" type="text/css" href="http://cdn.ink.sapo.pt/3.1.7/css/ink-flex.min.css">
<link rel="stylesheet" type="text/css" href="http://cdn.ink.sapo.pt/3.1.7/css/font-awesome.min.css">

<link rel="stylesheet" type="text/css" href="css/ink-custom.css">

<!-- load Ink's css for IE8 -->
<!--[if lt IE 9 ]>
<link rel="stylesheet" href="http://cdn.ink.sapo.pt/3.1.7/css/ink-ie.min.css" type="text/css" media="screen" title="no title" charset="utf-8">
<![endif]-->

<!-- test browser flexbox support and load legacy grid if unsupported -->
<script type="text/javascript" src="http://cdn.ink.sapo.pt/3.1.7/js/modernizr.js"></script>
<script type="text/javascript">
	Modernizr.load(
	{
		test : Modernizr.flexbox,
		nope : 'http://cdn.ink.sapo.pt/3.1.7/css/ink-legacy.min.css'
	});
</script>

<!-- load Ink's javascript files from the cdn -->
<script type="text/javascript" src="http://cdn.ink.sapo.pt/3.1.7/js/holder.js"></script>
<script type="text/javascript" src="http://cdn.ink.sapo.pt/3.1.7/js/ink-all.min.js"></script>
<script type="text/javascript" src="http://cdn.ink.sapo.pt/3.1.7/js/autoload.js"></script>


<style type="text/css">
body {
	background: #ededed;
}

header h1 small:before {
	content: "|";
	margin: 0 0.5em;
	font-size: 1.6em;
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
		<div class="top-space"></div>

		<header class="vertical-space">
			<h1>
				FAULT INJECTOR<small>Faultload details</small>
			</h1>

			<div class="column-group">
				<div class="all-85">
					<nav class="ink-navigation">
						<ul class="breadcrumbs green">
							<li><a href="loadexperiments">Home</a></li>
							<li><a href="loadfaultloads">New experiment [4/4]</a></li>
							<li class="active"><a href="#">Faultload details</a></li>
						</ul>
					</nav>
				</div>
				<div class="all-15">
					<nav class="ink-navigation">
						<ul class="breadcrumbs green align-center">
							<li><a href="#">Logout jaff</a></li>
						</ul>
					</nav>
				</div>
			</div>
		</header>

		<div class="column-group">
			<div class="all-20"></div>
			<div class="all-60">
				<h2 class="bottom-space">Faultload details</h2>
				<table class="ink-table alternating hover">
					<tbody>
						<tr>
							<td class="all-25 align-right fw-400">Faultload name</td>
							<td class="all-75 fw-300"><s:property value="faultload.name" /></td>
						</tr>
						<tr>
							<td class="all-25 align-right fw-400">Creation date</td>
							<td class="all-75 fw-300"><s:property value="faultload.creation_date" /></td>
						</tr>
						<tr>
							<td class="all-25 align-right fw-400">Experiment name</td>
							<td class="all-75 fw-300"><s:property value="faultload.experiment.name" /></td>
						</tr>
						<tr>
							<td class="all-25 align-right fw-400">Description</td>
							<td class="all-75 fw-300"><s:property value="faultload.description" /></td>
						</tr>
						<tr>
							<td class="all-25 align-right fw-400">Time interval (ms)</td>
							<td class="all-75 fw-300"><s:property value="faultload.time_interval" /></td>
						</tr>
						<s:iterator value="faults">
							<s:iterator value="hardwares">
								<s:if test="hw_fault_type =='m'">
									<tr>
										<td class="all-25 align-right fw-400">Hardware fault type</td>
										<td class="all-75 fw-300">memory</td>
									</tr>
									<tr>
										<td class="all-25 align-right fw-400">Memory range start</td>
										<td class="all-75 fw-300"><s:property value="faultload.mem_range_beg" /></td>
									</tr>
									<tr>
										<td class="all-25 align-right fw-400">Memory range end</td>
										<td class="all-75 fw-300"><s:property value="faultload.mem_range_end" /></td>
									</tr>
								</s:if>
								<s:else>
									<tr>
										<td class="all-25 align-right fw-400">Hardware fault type</td>
										<td class="all-75 fw-300">register</td>
									</tr>
								</s:else>
								<tr>
									<td class="all-25 align-right fw-400">Number of faults</td>
									<td class="all-75 fw-300"><s:property value="faultload.n_faults" /></td>
								</tr>
								<s:if test="%{bit_flip}">
									<tr>
										<td class="all-25 align-right fw-400">Fault class</td>
										<td class="all-75 fw-300">bit-flip</td>
									</tr>
								</s:if>
								<s:else>
									<tr>
										<td class="all-25 align-right fw-400">Fault class</td>
										<td class="all-75 fw-300">stuck at</td>
									</tr>
								</s:else>
								<tr>
									<td class="all-25 align-right fw-400">Bits to change start</td>
									<td class="all-75 fw-300"><s:property value="bitStart" /></td>
								</tr>
								<tr>
									<td class="all-25 align-right fw-400">Bits to change end</td>
									<td class="all-75 fw-300"><s:property value="bitEnd" /></td>
								</tr>
							</s:iterator>
						</s:iterator>
						<s:iterator value="faultload.registers">
							<tr>
								<td class="all-25 align-right fw-400">Register name</td>
								<td class="all-75 fw-300"><s:property value="name" /></td>
							</tr>
						</s:iterator>
						<s:iterator value="faults">
							<s:if test="%{kernel_mode}">
								<tr>
									<td class="all-25 align-right fw-400">Mode</td>
									<td class="all-75 fw-300">kernel</td>
								</tr>
							</s:if>
							<s:else>
								<tr>
									<td class="all-25 align-right fw-400">Mode</td>
									<td class="all-75 fw-300">user</td>
								</tr>
							</s:else>
							<tr>
								<td class="all-25 align-right fw-400">Process ID</td>
								<td class="all-75 fw-300"><s:property value="pid" /></td>
							</tr>
							<s:if test="trigger_type=='tp'">
								<tr>
									<td class="all-25 align-right fw-400">Fault trigger type</td>
									<td class="all-75 fw-300">temporal</td>
								</tr>
								<tr>
									<td class="all-25 align-right fw-400">Temporal trigger start (ms)</td>
									<td class="all-75 fw-300"><s:property value="time_start" /></td>
								</tr>
								<tr>
									<td class="all-25 align-right fw-400">Temporal trigger end (ms)</td>
									<td class="all-75 fw-300"><s:property value="time_end" /></td>
								</tr>
							</s:if>
							<s:elseif test="trigger_type=='sc'">
								<tr>
									<td class="all-25 align-right fw-400">Fault trigger type</td>
									<td class="all-75 fw-300">spatial (code segment)</td>
								</tr>
								<tr>
									<td class="all-25 align-right fw-400">Mode</td>
									<td class="all-75 fw-300"><s:property value="read_address" /></td>
								</tr>
								<tr>
									<td class="all-25 align-right fw-400">Memory address</td>
									<td class="all-75 fw-300"><s:property value="mem_address" /></td>
								</tr>
							</s:elseif>
							<s:else>
								<tr>
									<td class="all-25 align-right fw-400">Fault trigger type</td>
									<td class="all-75 fw-300">spatial (data segment)</td>
								</tr>
								<tr>
									<td class="all-25 align-right fw-400">Mode</td>
									<td class="all-75 fw-300"><s:property value="read_address" /></td>
								</tr>
								<tr>
									<td class="all-25 align-right fw-400">Memory address</td>
									<td class="all-75 fw-300"><s:property value="mem_address" /></td>
								</tr>
							</s:else>
						</s:iterator>
						
					</tbody>
				</table>
				<!--                     <a href="loadfaultloads" class="ink-button all-25">Ok</a> -->
			</div>
			<div class="all-20"></div>
		</div>
	</div>
	<footer class="clearfix double-top-space">
		<div class="ink-grid">
			<ul class="unstyled inline half-vertical-space">
				<li class="active"><a href="#">About</a></li>
				<li><a href="#">Sitemap</a></li>
				<li><a href="#">Contacts</a></li>
			</ul>
			<p class="note">Identification of the owner of the copyright, either by name, abbreviation, or other designation by which it is generally known.</p>
		</div>
	</footer>

	<script src="js/jquery/jquery-1.11.2.js"></script>
	<script src="js/my-jquery.js"></script>
</body>
</html>
