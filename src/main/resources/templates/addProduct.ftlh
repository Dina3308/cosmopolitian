<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>добавить товар</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet"  href="<@spring.url "/css/addProduct.css"/>" type="text/css">
</head>
<body>
<div class="addProduct">
    <form action="/admin/addProduct" class="form" method="post" enctype="multipart/form-data">
        <p><b>Название товара:</b><br>
            <input type="text" name="productName">
        <div style="color:red" ><#if validation??>
                <#if validation.hasFieldErrors('productName')>${validation.getFieldErrors("productName")[0].defaultMessage}</#if>
            </#if></div>
        </p>
        <p><b>Категория товара:</b><br>
            <input type="text" list="категория" name="category"  >
            <datalist id="категория">
                <option value="жирная">
                <option value="комбинированная">
                <option value="нормальная">
                <option value="сухая">
                <option value="проблемная">
            </datalist>
        <div style="color:red" ><#if validation??>
                <#if validation.hasFieldErrors('category')>${validation.getFieldErrors("category")[0].defaultMessage}</#if>
            </#if></div>
        </p>
        <p><b>Цена товара в долларах:</b><br>
            <input type="number" name="productPrice" >
        <div style="color:red" ><#if validation??>
                <#if validation.hasFieldErrors('productPrice')>${validation.getFieldErrors("productPrice")[0].defaultMessage}</#if>
            </#if></div>
        </p>
        <p><b>Количество товара:</b><br>
            <input type="number" name="productCount">
        <div style="color:red" ><#if validation??>
                <#if validation.hasFieldErrors('productCount')>${validation.getFieldErrors("productCount")[0].defaultMessage}</#if>
            </#if></div>
        </p>
        <p><b>Описание товара:</b><br>
            <textarea name="description" cols="60" rows="6"></textarea>
        <div style="color:red" ><#if validation??>
                <#if validation.hasFieldErrors('description')>${validation.getFieldErrors("description")[0].defaultMessage}</#if>
            </#if></div>
        </p>
        <input type="file" name="productImg" accept="image/*">
        <div style="color:red" ><#if validation??>
                <#if validation.hasFieldErrors('productImg')>${validation.getFieldErrors("productImg")[0].defaultMessage}</#if>
            </#if></div>
        <button type="submit"> Добавить </button>
    </form>
</div>
</body>
</html>