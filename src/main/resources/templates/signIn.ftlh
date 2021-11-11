<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Форма для авторизации</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet"  href="<@spring.url "/css/signIn.css"/>" type="text/css">
  </head>
<body>
<div id="range2">
    <div class="outer">
        <div class="middle">
            <div class="inner">
                <div class="login-wr">
                    <h2>Вход</h2>
                    <form action="/signIn" class="form" method="post">
                        <input type="text" name="email" placeholder="Введите e-mail">
                        <input type="password" name="password" placeholder="Введите пароль">
                        <a href="/signUp"> <p> У вас нет аккаунта? Регистрация </p></a>
                        <button type="submit"> Авторизация </button>
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