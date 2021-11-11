<!DOCTYPE html>
<#import "macro/menu_ui.ftlh" as menu_ui/>
<#import "/spring.ftl" as spring/>

<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Website</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=PT+Sans:400,700&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Lora:ital,wght@0,700;1,500;1,600;1,700&family=Open+Sans&display=swap" rel="stylesheet">
    <link rel="stylesheet"  href="<@spring.url "/css/style.css"/>" type="text/css">
</head>
<body>
<@menu_ui.menu/>
<header class="header">
    <div class="container">
        <div class="header__bg">
            <img src="<@spring.url "/img/10360.jpg"/>" alt="error">
        </div>
        <div class="header__content">
            <p>Мы создаем наши продукты, чтобы помочь вам обрести эту любовь через заботу о себе и своей коже.
                В Cosmopolitan мы верим в красоту каждого человека. Наша миссия — помочь вам ощутить собственную красоту.</p>
            <a href="<@spring.url "/catalog?category=нормальная"/>" class="header__button">Перейти в каталог</a>
        </div>
    </div>
</header>
<div class="concept">
    <div class="container">
        <div class="concept__bg">
            <img src="<@spring.url "/img/cosmetics2.png"/>" alt="error">
        </div>
        <div class="concept__content">
            <div class="main__text">
                <p>При создании продуктов мы следуем трем основным принципам:</p>
                -Качественные натуральные ингредиенты<br>
                - Универсальные формулы, которые подойдут даже чувствительной коже<br>
                - Отсутствие тестов на животных
            </div>
        </div>
    </div>
</div>
</body>
</html>