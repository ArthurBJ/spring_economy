<#ftl encoding="UTF-8">
<#import "layouts/base.ftlh" as base>
<@base.main title="Заказать звонок" css=["contact.css"] scripts=["jquery.maskedinput.min.js", "contact.js"]>
    <div class="content">
        <div class="container">

            <#if success??>
                <div style="padding-top: 20px">
                    <div class="alert alert-success fade show" role="alert">
                        ${success}
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                </div>
            </#if>

            <div class="offset-2 col-md-8 contact-card">
                <div class="card" style="border-radius: 20px">
                    <div class="card-body">
                        <div class="card-contact_title center">
                            Спасибо за желание <br> воспользоваться моими услугами! <br> Оставьте свой номер телефона
                            <br>
                            для связи!
                        </div>
                        <form action="/contact" method="post">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                            <div class="form-group">
                                <label for="phone"></label>
                                <input type="tel" class="form-control cont_input" id="phone" name="tel"
                                       placeholder="+7 (999) 99 99 999">
                            </div>
                            <div class="offset-4 cont_btn">
                                <button class="btn">
                                    Отправить
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</@base.main>