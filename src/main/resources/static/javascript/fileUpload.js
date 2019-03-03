var numberOfFiles = 0;
var selectedFiles = [];
$(document).ready(function() {
    document.getElementById('pro-image').addEventListener('change', readImage, false);

    $( ".preview-images-zone" ).sortable();

    $(document).on('click', '.image-cancel', function() {
        let no = $(this).data('no');
        $(".preview-image.preview-show-"+no).remove();
        numberOfFiles = numberOfFiles - 1;
        ///delete selectedFiles[no];
        console.log(no-4);
        selectedFiles.splice((no-4),1);
        console.log(selectedFiles);
        /*console.log(numberOfFiles);*/
    });

    $(".video-text").css("display","none");
    $(".input-group-btn").css("width","0");
    $(".video-btn-1 , .video-btn-2").hover(function(){
        $(".input-group-btn").css("width","1%");
        $(".video-text").css("display","block");
        $(".video-text").css("width","100% !important");
    });

    function getId(url) {
        var regExp = /^.*(youtu.be\/|v\/|u\/\w\/|embed\/|watch\?v=|\&v=)([^#\&\?]*).*/;
        var match = url.match(regExp);

        if (match && match[2].length == 11) {
            return match[2];
        } else {
            return 'error';
        }
    }
    $(".video-btn-2").click(function(){
        alert("here");
        var myId = getId($("#video").val());
        alert(myId);
        $('#video-box').html('<iframe width="560" height="315" src="//www.youtube.com/embed/' + myId + '" frameborder="0" allowfullscreen></iframe>');
    });
});



var num = 4;
function readImage() {
    if (window.File && window.FileList && window.FileReader) {
        files = event.target.files; //FileList object
        var output = $(".preview-images-zone");

        for (let i = 0; i < files.length; i++) { //i<files.length
            var file = files[i];
            if (!file.type.match('image')) continue;
            var picReader = new FileReader();
            if(numberOfFiles < 5 ){
                selectedFiles.push(file[i]);
                picReader.addEventListener('load', function (event) {
                    var picFile = event.target;
                    var html =  '<div class="preview-image preview-show-' + num + '">' +
                                '<div class="image-cancel" data-no="' + num + '">x</div>' +
                                '<div class="image-zone"><img id="pro-img-' + num + '" src="' + picFile.result + '"></div>' +
                                '<div class="tools-edit-image"><a href="javascript:void(0)" data-no="' + num + '" class="btn btn-light btn-edit-image">edit</a></div>' +
                                '</div>';
                    uploadToS3(picFile);
                    output.append(html);
                    num = num + 1;
                });
                numberOfFiles = numberOfFiles+1;
                picReader.readAsDataURL(file);
            }
        }
        console.log(selectedFiles);
        //alert("selected files length : "+selectedFiles.length);
        /*console.log(numberOfFiles);*/
        $("#pro-image").val('');
    } else {
        console.log('Browser not support');
    }
}

var progress = 0;
function uploadToS3(file){
    //alert(binaryUrl);
    event.preventDefault();

    // get the reference to the actual file in the input
    //var theFormFile = $('#theFile').get()[0].files[0];

    $.ajax({
        type: 'PUT',
        url: "https://chalkandboards-p.s3.amazonaws.com/8ef31466-9634-41a8-b7d5-b29cd1321141?response-content-type=image%2Fjpeg&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20190303T115717Z&X-Amz-SignedHeaders=host&X-Amz-Expires=900&X-Amz-Credential=AKIAJ5B33LOM7VFNIEGQ%2F20190303%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Signature=a318280ce22a57c591f6355e7dc8fbefd96dd127ea943708add8e1b46af0cc9e",
        // Content type must much with the parameter you signed your URL with
        contentType: 'binary/octet-stream',
        // this flag is important, if not set, it will try to send data as a form
        processData: false,
        // the actual file is sent raw
        crossDomain: true,
        headers: { 'Access-Control-Allow-Headers': 'x-requested-with' ,'Access-Control-Allow-Origin' : '*'},
        data: file.result
    })
    .success(function() {
        alert('File uploaded');
        progress = progress+20;
        alert(progress+"%");
        $("#uploadImageBar").css("width", progress+"%");
        $("#uploadImageBar").html(progress+"% Complete (success)");
    })
    .error(function() {
        alert('File NOT uploaded');
        console.log( arguments);
    });
    return false;
}