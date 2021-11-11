
function clickDelete(id){
    $.ajax({
        url: '/api/products/' + id,
        type: "DELETE",
        success: $('[data-id=' + id + ']').fadeOut()
    });
}

function saveCount(id){
    let count = $('input[data-id=' + id + ']').val();
    console.log(count);
    $.ajax({
        contentType: 'application/json',
        data: count,
        url: '/api/products/' + id,
        type: "PUT",
        success: alert("изменения сохранены")
    });
}

$(document).ready(function (){
});