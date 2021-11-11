<!DOCTYPE html>
<#import "macro/menu_ui.ftlh" as menu_ui/>
<#import "/spring.ftl" as spring/>

<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Корзина</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=PT+Sans:400,700&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Lora:ital,wght@0,700;1,500;1,600;1,700&family=Open+Sans&display=swap" rel="stylesheet">
    <link rel="stylesheet"  href="<@spring.url "/css/style.css"/>" type="text/css">
    <link rel="stylesheet" href="<@spring.url "/css/catalog.css"/>" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="<@spring.url "/js/catalog.js"/>"></script>
</head>
<body>
<@menu_ui.menu/>
<div class="container-1">
    <div class="products" id="products2">
        <table>
            <tr class="head">
                <th>изображение</th>
                <th>наименование</th>
                <th>цена в рублях</th>
                <th>количествo</th>
                <th>cумма</th>
                <th>действие</th>
            </tr>
            <#if baskets??>
                <#list baskets as basket>
                    <tr data-id="${basket.id}">
                        <td data-id="${basket.id}">
                            <img src="<@spring.url "/img/${basket.productImg}"/>" alt="error"/>
                        </td>
                        <td data-id="${basket.id}" class="title">
                            <p>${basket.productName}</p>
                            <p>${basket.description}</p>
                        </td>
                        <td data-id="${basket.id}" id="price">
                            ${basket.productPrice}
                        </td>
                        <td data-id="${basket.id}" >
                            <div class="count_box">
                                <input class="inp_price" data-id="${basket.id}" onchange="onCountChange(${basket.id})" name="count" type="number" max="${basket.productCount}" min="1" value="${basket.count}">
                            </div>
                            <button id="btn" data-id="${basket.id}" onclick="saveCount('${basket.id}')" name="save"> сохранить </button>
                        </td>
                        <td data-id="${basket.id}" >
                            <label data-id="${basket.id}" id="resultPrice">${basket.productPrice}</label>
                        </td>
                        <td>
                            <button class="button" onclick="clickDelete('${basket.id}')" data-id="${basket.id}" name="delete">удалить</button>
                        </td>
                    </tr>
                </#list>
            </#if>
        </table>
    </div>
</div>
<form action="/dataFilling" method="get">
    <#if baskets??>
        <div class="order">
            к оплате:
            <label id="totalPrice"></label>
            <button id="orderBtn" class="button" type="submit">оформить заказ</button>
        </div>
    </#if>
</form>
</body>
</html>