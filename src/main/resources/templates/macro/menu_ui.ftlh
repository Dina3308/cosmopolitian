<#import "/spring.ftl" as spring/>
<#macro menu>
    <nav class="nav-wrapper">
        <div class="container">
            <div class="row">
                <div class="col-md-2">
                    <div class="logo" >Cosmopolitan</div>
                </div>

                <div class="col-md-8">
                    <div class="navigation">
                        <a href="<@spring.url "/catalog"/>" class="navigation_link" >Каталог</a>
                        <a href="" class="navigation_link" >cosmopolitan_russia@gmail.com</a>

                    </div>
                </div>
                <div class="col-md-1">
                    <div class="icons">
                        <a href="<@spring.url "/account"/>" class="navigation_link" >Профиль</a>
                    </div>
                </div>
                <div class="col-md-1">
                    <div class="icons">
                        <a href="<@spring.url "/basket"/>" class="navigation_link" >Корзина</a>
                    </div>
                </div>
            </div>
        </div>
    </nav>
</#macro>