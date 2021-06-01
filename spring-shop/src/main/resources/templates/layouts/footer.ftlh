<footer id="sticky-footer" class="foo text-white-50">
    <div class="container cont_foo">
        <div class="row">
            <div class="offset-1 col-md-3">
                <a href="/"><img src="/assets/user/crutch.png" alt="logo"></a>
            </div>
            <div class="offset-1 col-md-2">
                <div class="row"><a class="nav-link " href="/advantages">
                        Преимущества
                    </a>
                </div>
                <div class="row"><a class="nav-link " href="/stages">
                        Этапы
                    </a>
                </div>
                <div class="row"><a class="nav-link " href="/services">
                        Услуги
                    </a>
                </div>
                <#if user??>
                    <div class="row"><a class="nav-link " href="/profile">
                            Профиль
                        </a>
                    </div>
                    <div class="row"><a class="nav-link " href="/basket">
                            Корзина
                        </a>
                    </div>
                <#else>
                    <div class="row"><a class="nav-link " href="/login">
                            Авторизация
                        </a>
                    </div>
                    <div class="row"><a class="nav-link " href="/register">
                            Регистрация
                        </a>
                    </div>
                </#if>
            </div>
            <div class="offset-2 col-md-3">
                <div class="row">
                    <a href="tel:+79186663333" class="ml-auto phone"> +7 (918) 666-33-33</a>
                </div>
                <div class="row">
                    <a class="nav-link  ml-auto" href="/contact">
                        Контакты
                    </a>
                </div>
            </div>
        </div>
    </div>
</footer>
