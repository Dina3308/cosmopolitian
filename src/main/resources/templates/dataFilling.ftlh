<#import "/spring.ftl" as spring/>

<html>
<head>
    <title>оформление заказа</title>
    <link rel="stylesheet" href=https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css>
    <link rel="stylesheet"  href="<@spring.url "/css/dataFilling.css"/>" type="text/css">
</head>
<body>
<div class="container">
    <form method="post" action="/order">
        <div class="form-row">
            <div class="col">
                <input type="text" class="form-control" name="name" placeholder="Имя">
                <div style="color:red" ><#if validation??>
                        <#if validation.hasFieldErrors('name')>${validation.getFieldErrors("name")[0].defaultMessage}</#if>
                    </#if></div>
            </div>
            <div class="col">
                <input type="text" class="form-control" name="surname" placeholder="Фамилия">
                <div style="color:red" ><#if validation??>
                        <#if validation.hasFieldErrors('surname')>${validation.getFieldErrors("surname")[0].defaultMessage}</#if>
                    </#if></div>
            </div>
        </div>
        <div class="form-row">
            <div class="col">
                <input  type="email" class="form-control" name="email" placeholder="E-mail">
                <div style="color:red" ><#if validation??>
                        <#if validation.hasFieldErrors('email')>${validation.getFieldErrors("email")[0].defaultMessage}</#if>
                    </#if></div>
            </div>
            <div class="col">
                <input  type="number" class="form-control" name="numberPhone" placeholder="номер телефона ">
                <div style="color:red" ><#if validation??>
                        <#if validation.hasFieldErrors('numberPhone')>${validation.getFieldErrors("numberPhone")[0].defaultMessage}</#if>
                    </#if></div>
            </div>
        </div>
        <div class="form-row">
            <div class="col">
                <input  type="text" class="form-control" name="region" placeholder="край/область/регион">
                <div style="color:red" ><#if validation??>
                        <#if validation.hasFieldErrors('region')>${validation.getFieldErrors("region")[0].defaultMessage}</#if>
                    </#if></div>
            </div>
            <div class="col">
                <input  type="text" class="form-control" name="city" placeholder="город">
                <div style="color:red" ><#if validation??>
                        <#if validation.hasFieldErrors('city')>${validation.getFieldErrors("city")[0].defaultMessage}</#if>
                    </#if></div>
            </div>
        </div>
        <div class="form-row">
            <div class="col">
                <input  type="text" class="form-control" name="street" placeholder="улица, дом, квартира">
                <div style="color:red" ><#if validation??>
                        <#if validation.hasFieldErrors('street')>${validation.getFieldErrors("street")[0].defaultMessage}</#if>
                    </#if></div>
            </div>
            <div class="col">
                <input type="text" class="form-control" name="index" placeholder="почтовый индекс">
                <div style="color:red" ><#if validation??>
                        <#if validation.hasFieldErrors('index')>${validation.getFieldErrors("index")[0].defaultMessage}</#if>
                    </#if></div>
            </div>
        </div>
        <div class="form-row">
            <div class="col">
                <input  type="text" class="form-control" name="cardNumber" placeholder="номер карты">
                <div style="color:red" ><#if validation??>
                        <#if validation.hasFieldErrors('cardNumber')>${validation.getFieldErrors("cardNumber")[0].defaultMessage}</#if>
                    </#if></div>
            </div>
            <div class="col">
                <input  type="text" class="form-control" name="cvv" placeholder="cvv-код">
                <div style="color:red" ><#if validation??>
                        <#if validation.hasFieldErrors('cvv')>${validation.getFieldErrors("cvv")[0].defaultMessage}</#if>
                    </#if></div>
            </div>
        </div>
        <div class="form-row">
            <div class="col">
                <input  type="text" class="form-control" name="month" placeholder="ММ">
                <div style="color:red" ><#if validation??>
                        <#if validation.hasFieldErrors('month')>${validation.getFieldErrors("month")[0].defaultMessage}</#if>
                    </#if></div>
            </div>
            /
            <div class="col">
                <input  type="text" class="form-control" name="year" placeholder="ГГ">
                <div style="color:red" ><#if validation??>
                        <#if validation.hasFieldErrors('year')>${validation.getFieldErrors("year")[0].defaultMessage}</#if>
                    </#if></div>
            </div>
        </div>
        <div class="form-row">
            <div class="col">
                <button class="orderBtn" type="submit" name="btn" >Оформить заказ</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>