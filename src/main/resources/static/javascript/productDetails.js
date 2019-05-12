$(document).ready(function() {
    $('#compareButton').click(function(){
        window.location.href = "/productDetailsCompare?q1="+$(this).attr('name')+"&q2="+$("#productsList").val();
    });

    $('#expand-button').click(function (){
        $('#collapse-button').toggleClass("hidden");
        $('#expand-button').toggleClass("hidden");
        $('#additional-technologies').slideToggle();
    });

    $('#collapse-button').click(function (){
        $('#expand-button').toggleClass("hidden");
        $('#collapse-button').toggleClass("hidden");
        $('#additional-technologies').slideToggle();
    });
});