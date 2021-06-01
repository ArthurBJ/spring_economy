<#ftl encoding="UTF-8"/>
<#import "layouts/base.ftlh" as base>
<@base.main title="Корзина" css=["profile.css", "basket.css"]>
    <div class="content">
        <div class="container">
            <div class="profile-cont_title center">
                Корзина
            </div>

            <#if error??>
                <div style="padding-top: 20px">
                    <div class="alert alert-danger fade show" role="alert">
                        ${error}
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close"></button>
                    </div>
                </div>
            </#if>

            <div class="list-services">
                <div class="container offset-1">
                    <#if basket??>
                        <#list basket.products as product>
                            <div class="row history-cont_cards">
                                <div class="card" style="border-radius: 20px; width: 90%">
                                    <div class="card-body">
                                        <div class="row">
                                            <div class="col-md-2">
                                                <div class="card-body_img" style="padding: 70px 50px">
                                                    <img src="/get/services/${product.image}"
                                                         alt="product image">
                                                </div>
                                            </div>
                                            <div class="container offset-2 col-md-6">
                                                <div class="row">
                                                    <div class="card-body_title">
                                                        ${product.name}
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="card-body_text">
                                                        ${product.description}
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="card-body_price">
                                                        Стоимость: ${product.price} P
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <a class="btn_basket" href="/basketService/delete/${product.id}">Удалить</a>
                                </div>
                            </div>
                        </#list>
                    </#if>
                </div>
            </div>

            <div class="pay center">
                <a class="btn" href="/purchase">Оплатить</a>
            </div>
        </div>
    </div>
</@base.main>