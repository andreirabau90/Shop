var basketUser = null;

function getProductsGroup(id) {
    $.ajax({
        url: "getProductsFromGroupById",
        data: {"id": id},
        dataType: "json",
        success: function (data) {
            $("#productList").empty();
            for (var i = 0; i < data.length; i++) {
                var name = data[i].name.toString();
                var idParam = data[i].id;
                $("#productList").append('<input type="button" id="\'' + data[i].id + '\'" class="button-product button" onclick="getProduct(' + idParam + ')" value="' + name + '"/><br>');
            }
        }
    });
    return false;
}

function getProduct(id) {
    $.ajax({
        url: "getProduct",
        data: {"id": id},
        dataType: "json",
        success: function (data) {
            groupId = data.group.id;
            productId = data.id;
            $("#product").empty();
            $("#product").append(
                "<h2 class='product-name'>" + data.name + "</h2>" +
                "<img class='product-image' src=\"/image/00"+productId+".jpg\">" +
                "<p class='product-description '>" + data.description + "</p>" +
                "<p><h4 class='product-price'>price for 1 kg : " + data.price + "</h4></p>");
            if (basketUser != null) {
                $("#product").append("<button id='buy' class='product-button button' onclick='addOrDeleteProductInBasket(basketUser,productId,true)'>buy</button>");
            }
        }
    });
}


function addOrDeleteProductInBasket(idBasket, idProduct, addOrDelete) {
    $.ajax({
        url: "addOrDeleteProductInBasket",
        async: false,
        data: {idBasket: idBasket, idProduct: idProduct, addOrDelete: addOrDelete},
        cache: false,
        dataType: "text",
        success: function () {
            getBasket(idBasket)
        }
    });
    return false;
}

var showBasketList = true;
function getBasket(id) {
    $.ajax({
        url: "getBasketById",
        data: {"id": id},
        dataType: "json",
        cache: false,
        success: function (data) {
            $("#basketList").hide();
            var totalPrice=0;
            if (showBasketList) {
                $("#basketList").show();
                for (var i = 0; i < data.basketProducts.length; i++) {
                    var name = data.basketProducts[i].name;
                    var price = data.basketProducts[i].price;
                    totalPrice = totalPrice + price;
                    idBasket = data.id;
                    idProduct = data.basketProducts[i].id;
                    $("#basketList").append('name : ' + name + '  price : ' + price + '<button id="' + idProduct + '" class="basket" onclick="addOrDeleteProductInBasket(idBasket,this.id,false)" >delete</button><br>');
                }
                $("#basketList").append("Total price = "+totalPrice);
                showBasketList = false;
            } else {
                $("#basketList").empty().hide();
                showBasketList = true;
            }


        }
    })
}
