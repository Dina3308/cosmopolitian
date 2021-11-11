<#import "/spring.ftl" as spring/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Форма для регистрации</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet"  href="<@spring.url "/css/signIn.css"/>" type="text/css">
</head>
<body>
<div id="range2">
    <div class="outer">
        <div class="middle">
            <div class="inner">
                <div class="login-wr">
                    <h2>Регистрация</h2>
                    <form action="/signUp" class="form" method="post">
                        <input class="input" type="email" name="email" placeholder="Введите E-mail">
                        <div style="color:red" ><#if validation??>
                                <#if validation.hasFieldErrors('email')>${validation.getFieldErrors("email")[0].defaultMessage}</#if>
                            </#if></div>
                        <input class="input" type="text" name="name" placeholder="Введите свое имя">
                        <div style="color:red" ><#if validation??>
                                <#if validation.hasFieldErrors('name')>${validation.getFieldErrors("name")[0].defaultMessage}</#if>
                            </#if></div>
                        <input class="input" type="text" name="surname" placeholder="Введите свое Фамилию">
                        <div style="color:red" ><#if validation??>
                                <#if validation.hasFieldErrors('surname')>${validation.getFieldErrors("surname")[0].defaultMessage}</#if>
                            </#if></div>
                        <input class="input" type="password" name="password" placeholder="Введите пароль">
                        <div style="color:red" ><#if validation??>
                                <#if validation.hasFieldErrors('password')>${validation.getFieldErrors("password")[0].defaultMessage}</#if>
                            </#if></div>
                        <input class="input" type="password" name="repeatPassword" placeholder="Введите ещё раз пароль">

                        <button type="submit"> Регистрация </button>
                    </form>
                    <#if error??>
                        ${error}
                    </#if>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>