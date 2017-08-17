
$('.dropdown-toggle').dropdown();

/* -------------------
         Product
 * ------------------- */

$('#products_list').click(function(){
    window.location.href='/admin';
});

$('#add_product').click(function(){
    window.location.href='/admin/product/add';
});
$('#delete_product').click(function(){
    var data = { 'toDelete[]' : []};
    $(":checked").each(function() {
        data['toDelete[]'].push($(this).val());
    });
    $.post("/admin/product/delete", data, function(data, status) {
        window.location.reload();
    });
});



/* -------------------
        Product type
 * ------------------- */

$('#product_type_list').click(function(){
    window.location.href='/admin/product_type';
});
$('#add_product_type').click(function(){
    window.location.href='/admin/product_type/add';
});
$('#delete_product_type').click(function(){
    var data = { 'toDelete[]' : []};
    $(":checked").each(function() {
        data['toDelete[]'].push($(this).val());
    });
    $.post("/admin/product_type/delete", data, function(data, status) {
        window.location.reload();
    });
});




/* -------------------
          Users
 * ------------------- */

$('#users_list').click(function(){
    window.location.href='/admin/users';
});
$('#delete_user').click(function(){
    var data = { 'toDelete[]' : []};
    $(":checked").each(function() {
        data['toDelete[]'].push($(this).val());
    });
    $.post("/admin/users/delete", data, function(data, status) {
        window.location.reload();
    });
});

/* -------------------
            Orders
 * ------------------- */

$('#orders_list').click(function(){
    window.location.href='/admin/orders';
});
$('#delete_order').click(function(){
    var data = { 'toDelete[]' : []};
    $(":checked").each(function() {
        data['toDelete[]'].push($(this).val());
    });
    $.post("/admin/orders/delete", data, function(data, status) {
        window.location.reload();
    });
});





$('#go_index').click(function(){
    window.location.href='/';
});
