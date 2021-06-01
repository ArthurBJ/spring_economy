<#ftl encoding="UTF-8"/>
<#import "layouts/base.ftlh" as base>
<@base.main css=["profile.css"] scripts=["modalWindow.js"] title="Личный кабинет">
    <div class="content">
        <div class="container">
            <div class="row">
                <div class="profile-cont_title">
                    Личный кабинет
                </div>
                <div class="offset-3 col-md-3 right profile-cont_title">
                    <button class="btn_mini" onclick="location.href='/logout'">Выйти</button>
                </div>
            </div>
            <div class="info">
                <div class="container">
                    <div class="row">
                        <div class="profile-cont_subtitle left">
                            Информация
                        </div>

                        <div class="col-md-3 profile-cont_subtitle">

                            <!--ModalForm-->
                            <div class="text-center">
                                <a href="" class="btn_mini_2 btn-default" data-toggle="modal"
                                   data-target="#modalForm" onclick="swa()">Изменить</a>
                            </div>
                        </div>
                    </div>
                    <div class="row info-cont">
                        <div class="col-md-3">
                            <a style="width: 40%" target="_blank">
                                <img class="profile_avatar" src="/get/image/${user.image}"
                                     alt="avatar">
                            </a>
                        </div>
                        <div class="offset-3 col-md-6">
                            <div class="row info-cont_text">
                                ${user.lastname}
                            </div>
                            <div class="row info-cont_text">
                                ${user.firstname}
                            </div>
                            <div class="row info-cont_text">
                                ${user.email}
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div id="overlay">
            <div class="popup">
                <button class="close" title="Закрыть окно" onclick="swa2()"></button>
                <p class="modal_text">Изменить фотографию</p>
                <form action="/profile" method="post" enctype="multipart/form-data">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                    <p class="button_modal">
                    <span class="btn_mini_3 float-left">
                         Имя <input type="text" name="firstname" value="${user.firstname}">
                    </span>
                        <span class="btn_mini_3 float-left">
                         Фамилия <input type="text" name="lastname" value="${user.lastname}">
                    </span>
                        <span class="btn_mini_3 float-left">
                         Прикрепить файл <input type="file" name="image" accept="image/*">
                    </span>
                    </p>
                    <p class="center" style="padding-top: 30px">
                        <button class="btn_mini_2" type="submit">Сохранить</button>
                    </p>
                </form>
            </div>
        </div>

        <div class="history">
            <div class="container">
                <div class="row">
                    <div class="profile-cont_subtitle">
                        История
                    </div>
                </div>
                <div class="container offset-1">
                    <#if purchases??>
                        <#list purchases as purch>
                            <#list purch.products as product>
                                <div class="row history-cont_cards">
                                    <div class="card" style="border-radius: 20px; width: 90%">
                                        <div class="card-body ">
                                            <div class="row">
                                                <div class="col-md-2">
                                                    <div class="card-body_img" style="padding: 70px 50px">
                                                        <img src="/get/services/${product.getImage()}"
                                                             alt="product">
                                                    </div>
                                                </div>
                                                <div class="container offset-2 col-md-6">
                                                    <div class="row">
                                                        <div class="card-body_title">
                                                            ${product.getName()}
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="card-body_text">
                                                            ${product.getDescription()}
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="card-body_price">
                                                            Стоимость: ${product.getPrice()}P
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </#list>
                        </#list>
                    </#if>
                </div>

                <div class="row history-cont_btn">
                    <button class="offset-2 col-md-8 btn" onclick="location.href='/chat'">
                        Чат
                    </button>
                </div>
            </div>
        </div>
    </div>
</@base.main>