<#ftl encoding="UTF-8"/>
<#import "layouts/base.ftlh" as base>
<#import "spring.ftl" as spring/>
<@base.main title="Регистрация" css=["register.css"]>
    <div class="content">
        <div class="container">
            <div class="register-cont_title">
                Регистрация
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
            <@spring.bind "signUpForm"/>
            <form class="form-signin" method="post" action="/register" autocomplete="off">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                <div class="row cards">
                    <div class="card border-white offset-3 col-md-6 card_settings">
                        <div class="card-body text-center ">
                            <div class="register-cont_input_top">
                                <label for="lastname">
                                    Фамилия
                                </label>
                                <@spring.formInput "signUpForm.lastname" "class='form-control register-cont_input'"/>
                                <@spring.showErrors "<br>" "error"/>
                            </div>

                            <div class="register-cont_input_middle">
                                <label for="firstname">
                                    <label for="lastname">Имя</label>
                                </label>
                                <@spring.formInput "signUpForm.firstname" "class='form-control register-cont_input'"/>
                                <@spring.showErrors "<br>" "error"/>
                            </div>

                            <div class="register-cont_input_middle">
                                <label for="email">
                                    Email
                                </label>
                                <@spring.formInput "signUpForm.email" "class='form-control register-cont_input'"/>
                                <@spring.showErrors "<br>" "error"/>
                            </div>

                            <div class="register-cont_input_middle">
                                <label for="password">
                                    Пароль
                                </label>
                                <@spring.formPasswordInput "signUpForm.password" "class='form-control register-cont_input'"/>
                                <#if equalsError??>
                                    <p class="error">${equalsError}</p>
                                </#if>
                                <#if hardError??>
                                    <p class="error">${hardError}</p>
                                </#if>
                            </div>

                            <div class="register-cont_input_bottom">
                                <label for="passwordAgain">
                                    Повторите пароль
                                </label>
                                <@spring.formPasswordInput "signUpForm.repeatPassword" "class='form-control register-cont_input'"/>
                                <#if equalsError??>
                                    <p class="error">${equalsError}</p>
                                </#if>
                                <#if hardError??>
                                    <p class="error">${hardError}</p>
                                </#if>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row register-cont_input_top">
                    <button class=" offset-4 col-md-4 btn" type="submit">
                        Зарегистрироваться
                    </button>
                </div>
            </form>
        </div>
    </div>
</@base.main>