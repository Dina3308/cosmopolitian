<!DOCTYPE html>
<#import "macro/menu_ui.ftlh" as menu_ui/>
<#import "/spring.ftl" as spring/>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Личный кабинет</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=PT+Sans:400,700&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Lora:ital,wght@0,700;1,500;1,600;1,700&family=Open+Sans&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="<@spring.url "/css/catalog.css"/>" type="text/css">
    <link rel="stylesheet" href="<@spring.url "/css/account.css"/>" type="text/css">
</head>
<body>
<div class="container">
    <div class="navigation">
        <p class="account">Личный кабинет </p>
        <p>Имя: ${user.name}</p>
        <p>Фамилия: ${user.surname}</p>
        <p>e-mail: ${user.email}</p>
        <a class="catalog" href='<@spring.url "/catalog?category=нормальная"/>'>Каталог</a> <br>
        <a href="<@spring.url "/logout"/>">Выйти из аккаунта</a> <br>
        <a href="<@spring.url "/basket"/>">Корзина</a> <br>
        <#assign role = "ADMIN">
        <#if user.isAdmin()>
            <a href='<@spring.url "/admin/products"/>'>Админка</a> <br>
        </#if>
    </div>
    <div class="content">
        <div class="block">
            <p>Мои заказы</p>
        </div>
        <#if orders??>
            <#list orders as order>
                <div class="order_content">
                    <p>Номер заказа: ${order.getId()}</p>
                    <p>Итого: ${order.getTotalPrice()}</p>
                    <p>Адрес доставки: ${order.getRegion()}, ${order.getCity()}, ${order.getStreet()}</p>
                    <p>Покупатель: ${order.getName()} ${order.getSurname()}</p>
                    <table class="table-products">
                        <tr class="head_order">
                            <th class="img">изображение</th>
                            <th>наименование</th>
                            <th>цена в руб.</th>
                            <th>количествo</th>
                            <th>сумма</th>
                        </tr>
                        <#list order.products as product>
                            <tr>
                                <td>
                                    <img src='<@spring.url "/img/${product.productImg}"/>' alt="error">
                                </td>
                                <td class="title">
                                    ${product.getProductName()}<br>
                                    ${product.getDescription()}
                                </td>
                                <td>
                                   ${product.getProductPrice()}
                                </td>
                                <td>
                                    <div class="count_box">
                                        ${product.getProductCount()}
                                    </div>
                                </td>
                                <td>
                                    <label id="resultPrice">${product.getProductPrice() * product.getProductCount()}</label>
                                </td>
                            </tr>
                        </#list>
                    </table>
                </div>
                </#list>
            </#if>
    </div>
    </div>
</div>

</body>
</html>