<!DOCTYPE html>
<#import "macro/menu_ui.ftlh" as menu_ui/>
<#import "/spring.ftl" as spring/>

<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Продукты</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=PT+Sans:400,700&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Lora:ital,wght@0,700;1,500;1,600;1,700&family=Open+Sans&display=swap" rel="stylesheet">
    <link rel="stylesheet"  href="<@spring.url "/css/style.css"/>" type="text/css">
    <link rel="stylesheet" href="<@spring.url"/css/catalog.css"/>" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="<@spring.url "/js/admin.js"/>"></script>
</head>
<body>
    <@menu_ui.menu/>
    <div class="container-2">
        <form method="get" action="/admin/addProduct">
            <button class="button" id="addProduct">Добавить новый продукт</button>
        </form>
    </div>
    <div class="container-1">
        <div class="products" id="products2">
            <table>
                <tr class="head">
                    <th>изображение</th>
                    <th>наименование</th>
                    <th>цена в долларах</th>
                    <th>количествo</th>
                    <th>кол-во проданных товаров</th>
                </tr>
                <#if products??>
                    <#assign x = 0>
                    <#list products as product>
                        <tr data-id="${product.id}" >
                            <td data-id="${product.id}">
                                <img src="<@spring.url "/img/${product.productImg}"/>" alt="error"/>
                            </td>
                            <td data-id="${product.id}" class="title">
                                <p>${product.productName}</p>
                                <p>${product.description}</p>
                            </td>
                            <td data-id="${product.id}" >
                                ${product.productPrice}
                            </td>
                            <td data-id="${product.id}" >
                                <div data-id="${product.id}" class="count_box">
                                    <input class="inp_price" data-id="${product.id}" name="count" type="number" min="0" value="${product.productCount}">
                                </div>
                                <button id="btn" onclick="saveCount('${product.id}')" data-id="${product.id}" name="save"> сохранить </button>
                            </td>
                            <td data-id="${product.id}" >
                                ${sold[x]}
                                <#assign x++>
                            </td>
                        </tr>
                    </#list>
                </#if>
            </table>
        </div>
    </div>
</body>
</html>