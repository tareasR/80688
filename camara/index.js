navigator.mediaDevices.getUserMedia({
    audio:false,
    video:true
}).then((stream)=>{
    console.log(stream)
    // alert('gracias por permitirnos verte')
    var video = document.querySelector('video');
    var camara = document.getElementById("camara")
    console.log(video)
    console.log(camara)
    video.src = "2.mp4"
    camara.srcObject = stream;
    camara.onloadedmetadata = (e) => {camara.play()}
}).catch(function(error){
    console.log(error)
    // alert('Si gustas utilizar este sistema permite el acceso a tu cámara')
});