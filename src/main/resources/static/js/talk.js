/!* Slide Members Info *!/
$('.info-btn').on('click', function () {
    $("#Messages").toggleClass('col-sm-12 col-sm-9');
});


$(function () {

    // Create WebSocket connection.
    const socket = new WebSocket('ws://localhost:8081');

    // Connection opened
    socket.addEventListener('open', function (event) {
        socket.send('Hello Server!');
    });

    // Listen for messages
    socket.addEventListener('message', function (event) {
        console.log('Message from server', event.data);
    });



    $("#send-btn").on('click', function () {
        console.log("hello");
        console.log("input is " + $("#input-text").val());
        // $("#input-text").val('')
        var content = $("#input-text").val();
        var time = new Date().getTime();
        var receiverId = 2;
        var newMessageHtml = "<div class=\"msg\">\n" +
            "                        <div class=\"media-body\">\n" +
            "                            <small class=\"pull-right time\"><i class=\"fa fa-clock-o\"></i> " + time + "</small>\n" +
            "\n" +
            "                            <h5 class=\"media-heading\">Walter White</h5>\n" +
            "                            <small class=\"col-sm-11\"> " + content + "</small>\n" +
            "                        </div>\n" +
            "                    </div>";
        console.log(newMessageHtml)
        $("#message-box").append(newMessageHtml)


        // send message api
        var data = {
            senderId: '1',
            content: content,
            sendTime: time,
            receiverId: receiverId
        }
        $.post("/api/message/send", data, function (data) {
            console.log("result " + data);
        });
    })

})