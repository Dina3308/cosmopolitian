function clickCreateBasket(id){
    let count = $('input[data-id=' + id + ']').val();
    let button = $('button[data-id=' + id + ']');
    $.ajax({
        contentType: 'application/json',
        url: '/api/baskets/create/' + id,
        data: count,
        type: "POST",
        statusCode: {
            404: function (){
                alert("пожалуйста сначала авторизуйтесь");
            },
            200: function (){
                button.text("в корзине");
                alert("продукт добавлен в корзину");
            }
        }
    });
}

function clickDelete(id){
    $.ajax({
        url: 'api/baskets/' + id,
        type: "DELETE",
        success: $('[data-id=' + id + ']').fadeOut()
    });
}

function onCountChange(id){
    let count = $('input[data-id=' + id + ']');
    let resultPrice = $('label[data-id=' + id + ']');
    let price = $('td[data-id=' + id + ']' + '[id=price]').text();
    let totalPrice = $("#totalPrice");

    if(parseInt(count.val(), 10) > parseInt(count.attr('max'), 10)){
        count.val(count.attr('max'));
    }
    if(count.val() === "" || parseInt(count.val(), 10) <= 0){
        count.val(1);
    }

    console.log(totalPrice.text());

    if(totalPrice){
        totalPrice.text( parseInt(totalPrice.text(), 10) - parseInt(resultPrice.text(), 10));
    }
    resultPrice.text(parseInt(count.val(), 10) * parseInt(price, 10));
    if(totalPrice){
        totalPrice.text( parseInt(totalPrice.text(), 10) + parseInt(resultPrice.text(), 10));
    }
}

function saveCount(id){
    let count = $('input[data-id=' + id + ']').val();
    console.log(count);
    $.ajax({
        contentType: 'application/json',
        data: count,
        url: '/api/baskets/' + id,
        type: "PUT",
        success: alert("изменения сохранены")
    });
}

$(document).ready(function (){
    let totalPrice = $("#totalPrice");
    totalPrice.text(0);
    $("td[id=price]").each(function(){
        let id = $(this).data('id');
        let count = $('input[data-id=' + id + ']').val();
        let element = $(this);
        let resultPrice = $(`label[id=resultPrice][data-id=${id}]`);

        let response = $.ajax({
            url: '/priceConverter/' + $(this).text(),
            type: 'GET'
        })
        response.done(function (data){
            element.text(data);
            resultPrice.text(parseInt(data, 10) * parseInt(count, 10));
            if(totalPrice){
                totalPrice.text(parseInt(totalPrice.text(), 10) + parseInt(resultPrice.text(), 10));
            }
        })
    });
});