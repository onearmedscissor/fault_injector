<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Fault Injector: Edit experiment</title>
        <meta name="description" content="">
        <meta name="author" content="ink, cookbook, recipes">
        <meta name="HandheldFriendly" content="True">
        <meta name="MobileOptimized" content="320">
        <meta name="mobile-web-app-capable" content="yes">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">

        <!-- Place favicon.ico and apple-touch-icon(s) here  -->
        <link rel="shortcut icon" href="ink-3.1.2/img/favicon.ico">
        <link rel="apple-touch-icon" href="ink-3.1.2/img/touch-icon-iphone.png">
        <link rel="apple-touch-icon" sizes="76x76" href="ink-3.1.2/img/touch-icon-ipad.png">
        <link rel="apple-touch-icon" sizes="120x120" href="ink-3.1.2/img/touch-icon-iphone-retina.png">
        <link rel="apple-touch-icon" sizes="152x152" href="ink-3.1.2/img/touch-icon-ipad-retina.png">
        <link rel="apple-touch-startup-image" href="ink-3.1.2/img/splash.320x460.png" media="screen and (min-device-width: 200px) and (max-device-width: 320px) and (orientation:portrait)">
        <link rel="apple-touch-startup-image" href="ink-3.1.2/img/splash.768x1004.png" media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:portrait)">
        <link rel="apple-touch-startup-image" href="ink-3.1.2/img/splash.1024x748.png" media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:landscape)">

        <!-- load Ink's CSS -->
        <link rel="stylesheet" type="text/css" href="ink-3.1.2/css/ink-flex.min.css">
        <link rel="stylesheet" type="text/css" href="css/ink-custom.css">
        <link rel="stylesheet" type="text/css" href="ink-3.1.2/css/font-awesome.min.css">

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

            <header class="clearfix header-bar all-80">
                <div class="column-group">
                    <div class="all-25 small-100 tiny-100"></div>
                    <div class="all-35 small-100 tiny-100"><h1>Fault injector</h1></div>
                    <div class="all-40 small-100 tiny-100"></div>
                </div>
            </header>

            <div class="column-group gutters">
                <div class="all-80">
                    <nav class="ink-navigation xlarge-push-left large-push-left half-top-space">
                        <ul class="menu horizontal">
                            <li><a href="#">Home</a></li>
                        </ul>
                    </nav>
                    <nav class="ink-navigation xlarge-push-right large-push-right half-top-space">
                        <ul class="menu horizontal">
                            <li class="active"><a href="#">Logout jaff</a></li>
                        </ul>
                    </nav>
                </div>
            </div>

            <div class="column-group">
                <div class="all-20 small-100 tiny-100"></div>
                <div class="all-40 small-100 tiny-100">
                    <h2>>> Edit experiment</h2>
                    <h4 class="top-space"><s:property value="experiment.name" /></h4>
                    <hr />
                </div>
                <div class="all-40 small-100 tiny-100"></div>
            </div>

            <div class="column-group">
                <div class="all-20 small-100 tiny-100">
                </div>
                <div class="all-40 small-100 tiny-100">

				<form action="saveexperiment" class="ink-form all-100 small-100 tiny-100" method="post">
                    <fieldset>

                        <div class="control-group column-group gutters required">
                            <label for="name" class="all-35 align-right">Name</label>
                            <div class="control all-65">
                            	<!-- <input type="text" id="name" name="name"> -->
                                <s:textfield id="name" name="name" value="%{experiment.name}"/>
                            </div>
                        </div>
                        
                        <div class="control-group column-group gutters required">
                            <label for="creatorname" class="all-35 align-right">Creator name</label>
                            <div class="control all-65">
                            	<!-- <input type="text" id="creatorname" name="creatorName"> -->
                                <s:textfield id="creatorname" name="creatorName" value="%{experiment.creatorName}"/>
                            </div>
                        </div>
                        
                        <div class="control-group column-group gutters">
                            <label for="creationdate" class="all-35 align-right">Creation date</label>
                            <div class="control all-65">
                                <!-- <input type="text" id="creationdate" name="creationDate"> -->
                                <s:textfield id="creationdate" disabled="true" value="%{experiment.creationDate}"/>
                            </div>
                        </div>
                        
                        <div class="control-group column-group gutters required">
                            <label for="targetname" class="all-35 align-right">Target name</label>
                            <div class="control all-65">
                                <!-- <input type="text" id="targetname" name="targetName"> -->
                                <s:textfield id="targetname" name="targetName" value="%{experiment.targetName}"/>
                            </div>
                        </div>
                        
                        <div class="control-group column-group gutters required">
                            <label for="workloadname" class="all-35 align-right">Workload name</label>
                            <div class="control all-65">
                                <!-- <input type="text" id="workloadname" name="workloadName"> -->
                                <s:textfield id="workloadname" name="workloadName" value="%{experiment.workloadName}"/>
                            </div>
                        </div>
                        
                        <div class="control-group column-group gutters required">
                            <label for="faultloadname" class="all-35 align-right">Faultload name</label>
                            <div class="control all-65">
                                <!-- <input type="text" id="faultloadname" name="faultloadName"> -->
                                <s:textfield id="faultloadname" name="faultloadName" value="%{experiment.faultloadName}"/>
                            </div>
                        </div>
                        
                        <div class="control-group column-group gutters required">
                            <label for="outputfilename" class="all-35 align-right">Output filename</label>
                            <div class="control all-65">
                                <!-- <input type="text" id="outputfilename" name="outputFilename"> -->
                                <s:textfield id="outputfilename" name="outputFilename" value="%{experiment.outputFilename}"/>
                            </div>
                        </div>

                        <div class="control-group column-group gutters required">
                            <label for="description" class="all-35 align-right">Description</label>
                            <div class="control all-65">
                                <!-- <textarea id="description" name="description"></textarea> -->
                                <s:textarea id="description" name="description" rows="5" maxlength="300" value="%{experiment.description}"/>
                            </div>
                        </div>
                    </fieldset>
                    
                    <button class="ink-button" type="submit">Submit</button>
                </form>

                </div>
            </div>
        </div>

        <div class="top-space"></div>

        <script src="js/jquery/jquery-1.11.2.js"></script>
        <script src="js/my-jquery.js"></script>
</body>
</html>
