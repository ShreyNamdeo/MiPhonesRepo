function deleteProductMedia(mediaId){
    $.ajax({
    type: "DELETE",
    url: "/product/media/"+mediaId,
    processData: false,
    contentType: false
    }).done(function(o) {
        console.log('deleted');
        // delete this.parent row from the list on delete
        $("#"+mediaId).parents().eq(3).remove();
    });
}