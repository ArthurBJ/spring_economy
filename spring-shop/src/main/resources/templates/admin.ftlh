<#ftl encoding="UTF-8"/>
<#import "layouts/base.ftlh" as base>
<#import "spring.ftl" as spring/>
<@base.main title="Админ" css=["register.css"]>
    <div class="content">
        <div class="container">
            <div class="register-cont_title">
                Добавить услугу
            </div>

            <@spring.bind "productForm"/>
            <form class="form-signin" method="post" action="/admin" autocomplete="off" enctype="multipart/form-data">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                <div class="row cards">
                    <div class="card border-white offset-3 col-md-6 card_settings">
                        <div class="card-body text-center ">
                            <div class="register-cont_input_top">
                                <label for="lastname">
                                    Название
                                </label>
                                <@spring.formInput "productForm.name" "class='form-control register-cont_input'"/>
                                <@spring.showErrors "<br>" "error"/>
                            </div>

                            <div class="register-cont_input_middle">
                                <label for="firstname">
                                    <label for="lastname">description</label>
                                </label>
                                <@spring.formTextarea "productForm.description" "class='form-control register-cont_input'"/>
                                <@spring.showErrors "<br>" "error"/>
                            </div>

                            <div class="register-cont_input_middle">
                                <label for="email">
                                    Price
                                </label>
                                <@spring.formInput "productForm.price" "class='form-control register-cont_input'" "number"/>
                                <@spring.showErrors "<br>" "error"/>
                            </div>

                            <div class="register-cont_input_middle">
                                <label for="password">
                                    Фото услуги
                                </label>
                                <input type="file" name="image" accept="image/*">
                            </div>

                            <div class="register-cont_input_bottom">
                                <label for="passwordAgain">
                                    Категория
                                </label>
                                <select name="categoryId" id="">
                                    <#list categories as category>
                                        <option value="${category.id}">${category.name}</option>
                                    </#list>
                                </select>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row register-cont_input_top">
                    <button class=" offset-4 col-md-4 btn" type="submit">
                        Добавить
                    </button>
                </div>
            </form>
        </div>
    </div>
</@base.main>