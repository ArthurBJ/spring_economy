<#ftl encoding="UTF-8">
<#import "layouts/base.ftlh" as base>
<@base.main title="Чат" css=["chat.css"] scripts=["sockjs.js", "stomp.js", "webSocket.js"]>
    <div class="content">
        <div class="container">
            <div class="offset-3 col-md-6 chat_padding">
                <div class="card chat-room" style="border-radius: 20px">
                    <div class="card-body">
                        <div class="chat-message">
                            <ul class="list-unstyled chat-1 scrollbar-light-blue" id="messages">
                            </ul>

                            <div class="white">
                                <div class="form-group basic-textarea">
                                    <textarea class="form-control"  rows="3"
                                              placeholder="текст" name="message" id="message"></textarea>
                                    <input type="text" name="username" value="${username}" hidden id="username">
                                </div>
                            </div>
                            <div>
                                <button onclick="send()" class="btn float-right">Отправить</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</@base.main>