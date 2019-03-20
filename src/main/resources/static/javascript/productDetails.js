$(document).ready(function() {
    $('#compareButton').click(function(){
        window.location.href = "/productDetailsCompare?q1="+$(this).attr('name')+"&q2="+$("#productsList").val();
    });
});