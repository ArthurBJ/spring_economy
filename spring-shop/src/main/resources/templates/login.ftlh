<#ftl encoding="UTF-8"/>
<#import "layouts/base.ftlh" as base>
<#import "spring.ftl" as spring/>
<@base.main css=["register.css"] title="Авторизация">
    <div class="content">
        <div class="container">
            <div class="register-cont_title">
                Авторизация
            </div>

            <#if error??>
                <div style="padding-top: 20px">
                    <div class="alert alert-danger fade show" role="alert">
                        ${error}
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                </div>
            </#if>

            <form class="form-signin" method="post" action="/login" autocomplete="off">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                <div class="row cards">
                    <div class="card offset-3 col-md-6" style="border-radius: 20px">
                        <div class="card-body text-center">
                            <div class="register-cont_input_top">
                                <label for="inputEmail">Email</label>
                                <input type="email" id="inputEmail" class="form-control register-cont_input"
                                       required name="email">
                            </div>
                            <div class="register-cont_input_middle">
                                <label for="inputPassword">Пароль</label>
                                <input type="password" id="inputPassword" class="form-control register-cont_input"
                                       required name="password">
                            </div>
                            <div class="form-check">
                                <input type="checkbox" class="form-check-input" id="exampleCheck1" name="rememberMe">
                                <label class="form-check-label" for="exampleCheck1">Запомнить меня</label>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row cards">
                    <button class="offset-4 col-md-4 btn" type="submit">
                        Войти
                    </button>
                </div>
            </form>
        </div>
    </div>
</@base.main>