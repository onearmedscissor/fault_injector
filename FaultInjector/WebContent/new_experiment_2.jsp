<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>Fault Injector: Create new experiment [2/4]</title>
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
            Modernizr.load({
                test: Modernizr.flexbox,
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

            header h1 small:before  {
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

            <header class="vertical-space">
                <h1>FAULT INJECTOR<small>Create new experiment</small></h1>

                <div class="column-group">
                    <div class="all-85">
                        <nav class="ink-navigation">
                            <ul class="breadcrumbs green">
                                <li><a href="loadexperiments">Home</a></li>
                                <li class="active"><a href="#">New experiment [2/4]</a></li>
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
            <div class="column-group gutters">
                <div class="all-100">
                    <h2 class="bottom-space">Create new experiment [2/4]</h2>

					<table id="targets" class="ink-table grey dynamicTable">
						<thead>
							<tr>
								<th colspan="4" class="align-left large">Select your target:</th>
							</tr>
						</thead>
						<tbody class="column-group">
							<s:if test="targets.size > 0">
								<s:iterator value="targets">
									<s:if test="#session.experimentBean.targetId == target_id">
										<tr id="<s:property value="target_id"/>" class="all-100 column-group highlight">
									</s:if>
									<s:else>
										<tr id="<s:property value="target_id"/>" class="all-100 column-group">
									</s:else>
										<td class="all-70 quarter-top-space"><a href="<s:url action="showtarget"><s:param name="id"><s:property value="target_id"/></s:param></s:url>" class="large all-100"><s:property value="name"/></a></td>
										<td class="all-15"><a href="<s:url action="edittarget"><s:param name="id"><s:property value="target_id"/></s:param></s:url>" class="ink-button all-100">edit</a></td>
										<td class="all-15"><a href="<s:url action="deletetarget"><s:param name="id"><s:property value="target_id"/></s:param></s:url>" class="ink-button all-100">delete</a></td>
										<td class="all-5"><a href="#" class="help all-100">?</a></td>
									</tr>
								</s:iterator>
							</s:if>
						</tbody>
					</table>
					
					<div id="help-targets" class="ink-alert block info" role="alert" style="display:none">
					    <button class="ink-dismiss">&times;</button>
					    <h4>Target options menu</h4>
					    <p>Here you can view, edit or delete previously created targets or alternatively create a new one.</p>
					</div>
					
					<a href="new_target.jsp" class="ink-button all-20" id="newtarget">Create new target...</a>
                    <div class="column-group push-center">
                    	<a href="new_experiment_1.jsp" class="ink-button double-top-space all-25" id="previous">&lt; Previous</a>
						<button class="ink-button double-top-space all-25 dynamicButton" id="next" disabled>Next &gt;</button>
	               </div>
                </div>
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
        
        <script type="text/javascript">
	        $(document).ready(function() {
// 	            $('.help').on('mouseover', function() {
// 	              $('#help-targets').show();
// 	            });
	            
// 	            $('.help').on('mouseout', function() {
// 	                $('#help-targets').hide();
// 	              });

	            $('.help').click(function(event) {
					$('#help-targets').show();
				});
	    	});
        </script>
		
		<script type="text/javascript">
// 			$('#previous').click(function(event)
// 				{
// 					var tid = $('.highlight').attr("id");
					
// 					$.ajax({
// 						method: "POST",
// 						url: "new_experiment_1.jsp",
// 						data: { tid : tid },
// 						success:
// 							function()
// 							{
// 						    	//alert("TID -> "+tid);
// 								window.location = "new_experiment_1.jsp";
// 							}
// 					});
// 				});
		
			$('#next').click(function(event)
			{
				var tid = $('.highlight').attr("id");
				
				$.ajax({
					method: "POST",
					url: "createexperiment2.action",
					data: { tid : tid },
					success:
						function()
						{
					    	//alert("TID -> "+tid);
							window.location = "loadworkloads.action";
						}
				});
			});
		</script>
</body>
</html>