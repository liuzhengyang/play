<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Play Talk</title>

    <!-- Bootstrap core CSS -->
    <link href="/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="/static/css/talk.css" rel="stylesheet">


</head>

<body>

<!--3rd Party Fonts & Icons-->
<link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Open+Sans"/>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">

<div class="container fill">
    <div class="row chat-wrap">

        <!-- Contacts & Conversations -->
        <div class="col-sm-3 panel-wrap">

            <!-- Overlay Menu / Contacts -->
            <div class="col-sm-12 section-wrap collapse" id="Contacts">

                <!--Header-->
                <div class="row header-wrap">
                    <div class="chat-header col-sm-12">
                        <h4>Select a Contact</h4>
                        <div class="header-button">
                            <a class="btn pull-right" href="#Contacts" data-toggle="collapse">
                                <i class="fa fa-close"></i>
                            </a>
                        </div>
                    </div>
                </div>

                <!--Contacts-->
                <div class="row content-wrap">
                    <#list friends as friend>
                        <div class="contact btn">
                            <div class="media-body">
                                <#--<h5 class="media-heading">#{friend.userModel.username}</h5>-->
                                <h5 class="media-heading">${friend.userModel.username}</h5>
                            </div>
                        </div>
                    </#list>
                    <div class="contact btn">
                        <div class="media-body">
                            <h5 class="media-heading">Walter White</h5>
                        </div>
                    </div>
                </div>

            </div>

            <!--Left Menu / Conversation List-->
            <div class="col-sm-12 section-wrap">

                <!--Header-->
                <div class="row header-wrap">
                    <div class="chat-header col-sm-12">
                        <h4 id="username">${user.name}</h4>
                        <div class="header-button">
                            <a class="btn pull-right" href="#Contacts" data-toggle="collapse">
                                <i class="fa fa-pencil-square-o fa-lg"></i>
                            </a>
                        </div>
                    </div>
                </div>

                <!--Conversations-->
                <div class="row content-wrap">
                    <#list friends as friend>
                        <div class="conversation btn">
                            <div class="media-body">
                                <h5 class="media-heading" id="contactName">${friend.userModel.username}</h5>
                                <small class="pull-right time">Last seen 12:10am</small>
                            </div>
                        </div>
                    </#list>
                </div>

            </div>

        </div>

        <!-- Messages & Info -->
        <div class="col-sm-9 panel-wrap">

            <!--Main Content / Message List-->
            <div class="col-sm-9 section-wrap" id="Messages">

                <!--Header-->
                <div class="row header-wrap">
                    <div class="chat-header col-sm-12">
                        <h4>Conversation Title</h4>
                        <div class="header-button">
                            <a class="btn pull-right info-btn">
                                <i class="fa fa-info-circle fa-lg"></i>
                            </a>
                        </div>
                    </div>
                </div>

                <!--Messages-->
                <div class="row content-wrap messages" id="message-box">

                </div>

                <!--Message box & Send Button-->
                <div class="row send-wrap">
                    <div class="send-message">
                        <div class="message-text">
                            <textarea id="input-text" class="no-resize-bar form-control" rows="2" placeholder="Write a message..."></textarea>
                        </div>
                        <div class="send-button">
                            <a class="btn" id="send-btn">Send <i class="fa fa-send"></i></a>
                        </div>
                    </div>
                </div>

            </div>

            <!--Sliding Menu / Conversation Members-->
            <div class="col-sm-3 section-wrap" id="Members">

                <!--Header-->
                <div class="row header-wrap">
                    <div class="chat-header col-sm-12">
                        <h4>Conversation Info</h4>
                        <div class="header-button">
                            <a class="btn pull-right info-btn">
                                <i class="fa fa-close"></i>
                            </a>
                        </div>
                    </div>
                </div>

                <!--Members-->
                <div class="row content-wrap">
                    <div class="contact">
                        <div class="media-body">
                            <h5 class="media-heading">Walter White</h5>
                            <small class="pull-left time"><i>Owner</i></small>
                        </div>
                    </div>
                    <div class="contact">
                        <div class="media-body">
                            <h5 class="media-heading">Walter White</h5>
                            <small class="pull-left time"><i>Invited</i></small>
                        </div>
                    </div>
                    <div class="contact">
                        <div class="media-body">
                            <h5 class="media-heading">Walter White</h5>
                            <small class="pull-left time"><i>Owner</i></small>
                        </div>
                    </div>
                    <div class="contact">
                        <div class="media-body">
                            <h5 class="media-heading">Walter White</h5>
                            <small class="pull-left time"><i>Invited</i></small>
                        </div>
                    </div>
                </div>

            </div>

        </div>
    </div>
</div>


</body>

<script src="/static/js/jquery.min.js"></script>
<script src="/static/js/talk.js"></script>
</html>
