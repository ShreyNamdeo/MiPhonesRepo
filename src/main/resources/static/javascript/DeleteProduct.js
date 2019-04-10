function deleteProduct(productId){
    $.ajax({
    type: "DELETE",
    url: "/product/"+productId,
    processData: false,
    contentType: false
    }).done(function(o) {
        console.log('deleted');
        // delete this.parent row from the list on delete
        $("#"+productId).parents().eq(5).remove();
    });
}