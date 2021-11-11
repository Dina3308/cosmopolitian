<!DOCTYPE html>
<#import "macro/menu_ui.ftlh" as menu_ui/>
<#import "/spring.ftl" as spring/>

<html lang="ru" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>Каталог товаров</title>
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
    <div class = "nav">
        <table>
            <tr class="nav_head">
                <th>тип кожи</th>
            </tr>
            <tr id="1" class="nav_content" >
                <td>
                    <a href="<@spring.url "/catalog?category=сухая"/>">сухая</a>
                </td>
            </tr>
            <tr id="2" class="nav_content" >
                <td >
                    <a href="<@spring.url "/catalog?category=нормальная"/>">нормальная</a>
                </td>
            </tr>
            <tr id="3" class="nav_content" >
                <td>
                    <a href="<@spring.url "/catalog?category=жирная"/>">жирная</a>
                </td>
            </tr>
            <tr id="4" class="nav_content" >
                <td>
                    <a href="<@spring.url "/catalog?category=комбинированная"/>" >комбинированная</a>
                </td>
            </tr>
            <tr id="5" class="nav_content" >
                <td>
                    <a href="<@spring.url "/catalog?category=проблемная"/>">проблемная</a>
                </td>
            </tr>
        </table>
        <table>
            <td class="nav_content">
                <a href="<@spring.url "/catalog?category=популярные"/>">популярные продукты</a>
            </td>
        </table>
    </div>

    <div class="products">
        <table>
            <tr class="head">
                <th>изображение</th>
                <th>наименование</th>
                <th>цена в рублях</th>
                <th>количествo</th>
                <th>cумма</th>
                <th>действие</th>
            </tr>
            <#if products??>
                <#list products as product>
                    <tr>
                        <td >
                            <img src="<@spring.url "img/${product.productImg}"/>" alt="error"/>
                        </td>
                        <td class="title">
                            <p>${product.productName}</p>
                            <p>${product.description}</p>
                        </td>
                        <td data-id="${product.id}" id="price" >
                            ${product.productPrice}
                        </td>
                        <td>
                            <div class="count_box">
                                <input class="inp_price"  onchange="onCountChange(${product.id})" data-id="${product.id}" name="count" type="number" max="${product.productCount}" min="1" value="1">
                            </div>
                        </td>
                        <td>
                            <label data-id="${product.id}" id="resultPrice">${product.productPrice}</label>
                        </td>
                        <td>
                            <#assign isActive = false>
                            <#if baskets??>
                                <#list baskets as basket>
                                    <#if product.id == basket.productId>
                                        <#assign isActive = true>
                                    </#if>
                                </#list>
                                <#if isActive>
                                    <button class="button" name="addToBasket">в корзинe</button>
                                    <#else>
                                        <button class="button" onclick="clickCreateBasket('${product.id}')" data-id="${product.id}" name="addToBasket">в корзину</button>
                                </#if>
                                <#else>
                                    <button class="button" onclick="clickCreateBasket('${product.id}')" data-id="${product.id}" name="addToBasket">в корзину</button>
                            </#if>
                        </td>
                    </tr>
                </#list>
            </#if>
        </table>
    </div>
</div>
</body>
</html>