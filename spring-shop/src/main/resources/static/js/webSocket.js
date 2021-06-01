$(document).ready(function () {
    connect()
})

function connect() {
    var socket = new SockJS('/chat');
    stompClient = Stomp.over(socket);

    stompClient.connect({}, function(frame) {
        stompClient.subscribe('/chat/messages', function(response) {
            console.log("nice")
            var data = JSON.parse(response.body);
            var messages = $("#messages");
            messages.append($('<li class="d-flex justify-content-between mb-4">' +
                '                                            <div class="chat-body white" style="overflow-x: hidden ">' +
                '                                                <div class="header">' +
                '                                                    <strong class="primary-font">' + data["sender"] +'</strong>' +
                '                                                </div>' +
                '                                                <hr class="w-100">' +
                '                                                <p class="mb-0" style="width: 80%;">' +
                '                                                    ' + data["message"] + ' ' +
                '                                                </p>' +
                '                                            </div>' +
                '                                        </li>'))
        });
    });
}

function send(){
    stompClient.send("/app/chat", {}, JSON.stringify({
        'message': $("#message").val(),
        "sender" :$("#username").val()
    }));
}
