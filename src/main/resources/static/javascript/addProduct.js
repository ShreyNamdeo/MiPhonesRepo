var currentTab = 0; // Current tab is set to be the first tab (0)
showTab(currentTab); // Display the current tab

function showTab(n) {
  // This function will display the specified tab of the form...
  var x = document.getElementsByClassName("tab");
  x[n].style.display = "block";
  //... and fix the Previous/Next buttons:
  if (n == 0) {
    document.getElementById("prevBtn").style.display = "none";
  } else {
    document.getElementById("prevBtn").style.display = "inline";
  }
  if (n == (x.length - 1)) {
    document.getElementById("nextBtn").innerHTML = "Submit";
  } else {
    document.getElementById("nextBtn").innerHTML = "Next";
  }
  //... and run a function that will display the correct step indicator:
  fixStepIndicator(n)
}

function nextPrev(n) {
  // This function will figure out which tab to display
  var x = document.getElementsByClassName("tab");
  // Exit the function if any field in the current tab is invalid:
  if (n == 1 && !validateForm()) return false;
  // Hide the current tab:
  x[currentTab].style.display = "none";
  // Increase or decrease the current tab by 1:
  currentTab = currentTab + n;
  // if you have reached the end of the form...
  if (currentTab >= x.length) {
    // ... the form gets submitted:
    document.getElementById("regForm").submit();
    return false;
  }
  // Otherwise, display the correct tab:
  showTab(currentTab);
}

function validateForm() {
  // This function deals with validation of the form fields
  var x, y, i, valid = true;
  x = document.getElementsByClassName("tab");
  y = x[currentTab].getElementsByTagName("input");
  // A loop that checks every input field in the current tab:
  for (i = 0; i < y.length; i++) {
    // If a field is empty...
    if (y[i].value == "") {
      // add an "invalid" class to the field:
      y[i].className += " invalid";
      // and set the current valid status to false
      valid = false;
    }
  }
  // If the valid status is true, mark the step as finished and valid:
  if (valid) {
    document.getElementsByClassName("step")[currentTab].className += " finish";
  }
  return valid; // return the valid status
}

function fixStepIndicator(n) {
  // This function removes the "active" class of all steps...
  var i, x = document.getElementsByClassName("step");
  for (i = 0; i < x.length; i++) {
    x[i].className = x[i].className.replace(" active", "");
  }
  //... and adds the "active" class on the current step:
  x[n].className += " active";
}

var videoId = 'videoOnUpload';
var scaleFactor = 0.25;
var snapshots = [];

/**
 * Captures a image frame from the provided video element.
 *
 * @param {Video} video HTML5 video element from where the image frame will be captured.
 * @param {Number} scaleFactor Factor to scale the canvas element that will be return. This is an optional parameter.
 *
 * @return {Canvas}
 */
function capture(video, scaleFactor) {
	if(scaleFactor == null){
		scaleFactor = 1;
	}
	var w = video.videoWidth * scaleFactor;
	var h = video.videoHeight * scaleFactor;
	var canvas = document.createElement('canvas');
		canvas.width  = w;
	    canvas.height = h;
	var ctx = canvas.getContext('2d');
		ctx.drawImage(video, 0, 0, w, h);
    return canvas;
}

/**
 * Invokes the <code>capture</code> function and attaches the canvas element to the DOM.
 */
function shoot(){
    alert("shoot called");
	var video  = document.getElementById(videoId);
	var output = document.getElementById('output');
	var canvas = capture(video, scaleFactor);
		/*canvas.onclick = function(){
			window.open(this.toDataURL());
		};*/
	snapshots.unshift(canvas);
	output.innerHTML = '';
	for(var i=0; i<1; i++){
		output.append(snapshots[i]);
	}
	$("#uploadScreenshotButton").css("display","table");
}
function addTumbnailImage(videoName){
    alert(videoName);
    var canvas = document.createElement('canvas');
    var dataURL = canvas.toDataURL();
    var blobBin = atob(dataURL.split(',')[1]);
    var array = [];
    for(var i = 0; i < blobBin.length; i++) {
        array.push(blobBin.charCodeAt(i));
    }
    var file=new Blob([new Uint8Array(array)], {type: 'image/png'});


    var formdata = new FormData();
    formdata.append("thumbnail.png", file);

    alert(dataURL);
    $.ajax({
    type: "POST",
    url: "/upload/VIDEO/"+videoName+"/thumbnail",
    data: formdata,
    processData: false,
    contentType: false
    }).done(function(o) {
        console.log('saved');
        // If you want the file to be visible in the browser
        // - please modify the callback in javascript. All you
        // need is to return the url to the file, you just saved
        // and than put the image in your browser.
    });
}
$(document).ready(function(){
    $("#nextBtn").click(function(){
        //alert("next clicked");
        var resolution = $("#pixx").val()+' X '+$("#pixy").val()+' Pixels, '+$("#resA").val()+' : '+$("#resB").val()+' Resolution '+$("#resDescription").val();
        var cardSlotValue = $("input[name='cardslot']:checked").val();
        var loudspeakerValue = $("input[name='loudspeaker']:checked").val();
        var jackValue = $("input[name='jack']:checked").val();
        var nfcValue = $("input[name='nfc']:checked").val();
        var radioValue = $("input[name='radio']:checked").val();
        var mainCameraTypeVal = $("#mainCameraType").children("option:selected").val();
        var mainCameraVideoResolution = $("#mainCameraVideoResolution").val()+'p @'+$("#mainCameraFramerate").val()+' fps';
        var selfieCameraTypeVal = $("#selfieCameraType").children("option:selected").val();
        var selfieCameraVideoResolution = $("#selfieCameraVideoResolution").val()+'p @'+$("#selfieCameraVideoFramerate").val()+' fps';

        event.preventDefault();
        var productData = {
            productId : $("#productId").val(),
            productName : $("#name").val(),
            networkTechnology : $("#technology").val(),
            announced : $("#announced").val(),
            status : $("#status").val(),
            bodyLength : $("#length").val(),
            bodyWidth : $("#breath").val(),
            bodyHeight : $("#height").val(),
            weight : $("#weight").val(),
            simType : $("#simTechnology").val(),
            displayType : $("#displayType").val(),
            displaySize : $("#displaySize").val(),
            resolution : resolution,
            colors : $("#colors").val(),
            price : $("#price").val(),
            batteryType : $("#batteryType").val(),
            batteryCharging : $("#batteryCharging").val(),
            cardSlot : cardSlotValue,
            internalStorage : $("#internalStorage").val(),
            loudSpeaker : loudspeakerValue,
            mm35jack : jackValue,
            soundFeatures : $("#soundFeatures").val(),
            wlan : $("#wlan").val(),
            bluetooth : $("#bluetooth").val(),
            gps : $("#gps").val(),
            nfc : nfcValue,
            radio : radioValue,
            usb : $("#usb").val(),
            os : $("#os").val(),
            chipSet : $("#chipset").val(),
            cpu : $("#cpu").val(),
            gpu : $("#gpu").val(),
            mainCameraType : mainCameraTypeVal,
            mainCameraDescription : $("#mainCameraDescription").val(),
            mainCameraFeatures : $("#mainCameraFeatures").val(),
            mainCameraVideo : mainCameraVideoResolution,
            selfieCameraType : selfieCameraTypeVal,
            selfieCameraDescription : $("#selfieCameraDescription").val(),
            selfieCameraFeatures : $("#selfieCameraFeature").val(),
            selfieCameraVideo : selfieCameraVideoResolution,
            otherSensors : $("#featureSensors").val(),
            description : $("#description").val()
        }
        var productDataJson = JSON.stringify(productData);
        $.ajax({
            type: 'PUT',
            url: "/product",
            contentType: 'application/json',
            processData: false,
            crossDomain: true,
            headers: { 'Access-Control-Allow-Headers': 'x-requested-with' ,'Access-Control-Allow-Origin' : '*'},
            data: productDataJson
        })
        .success(function(result) {
            console.log(result);
        })
        .error(function() {
            alert('Product update failed');
            console.log( arguments);
        });
    });
});
