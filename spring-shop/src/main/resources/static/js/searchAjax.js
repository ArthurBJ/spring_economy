$("#form").submit(function (event) {
    event.preventDefault();
    let json = {
        'input': $("#inputSearch").val(),
        'filter': $('input[name=filter]:checked').val()
    }
    $.ajax({
        url: "/search",
        type: "POST",
        contentType: "application/json;charset=UTF-8",
        data: JSON.stringify(json),
        dataType: "json",
        success: function (data) {
            console.log(data)
            $('#results').html('');
            data.forEach(function (product) {
                $('#results').append($(
                    '<div class="col-md-4">' +
                    '<div class="card services_card">' +
                    '<div class="card-body center">' +
                    '<div class="services_img">' +
                    '<img src="/get/services/' + product['image'] + '" alt="service">' +
                    '</div>' +
                    '<div class="services_title">' +
                    product['name'] +
                    '</div>' +
                    '<div class="services_price">' +
                    product['price'] + 'Р' +
                    '</div>' +
                    '<div class="btn_pad">' +
                    '<button class="btn services_btn"' +
                    ' onclick="d(' + product['id'] + ')">' +
                    'Get !' +
                    '</button>' +
                    '</div>' +
                    '</div>' +
                    '</div>' +
                    '</div>'))
            });
        }
    });
});