var grabar = document.getElementById("grabar")
grabar.addEventListener('click', GRABAR)
var parar = document.getElementById("parar")
parar.addEventListener('click', PARAR)

var mediaRecorder
var chunks = [];

navigator.mediaDevices.getUserMedia({
    audio: false,
    video: true
}).then((stream) => {
    console.log(stream)
    mediaRecorder = new MediaRecorder(stream, {mimeType: 'video/webm; codecs=vp8'});

    // alert('gracias por permitirnos verte')
    var video = document.querySelector('video');
    var camara = document.getElementById("camara")
    console.log(video)
    console.log(camara)
    video.src = "2.mp4"
    camara.srcObject = stream;
    camara.onloadedmetadata = (e) => { camara.play() }
    mediaRecorder.onstop = () => {
        console.log("ya se grabó algo!")
        var clipName = prompt('Enter a name for your sound clip');

        var clipContainer = document.createElement('article');
        var clipLabel = document.createElement('p');
        var audio = document.createElement('video');
        var deleteButton = document.createElement('button');
  
        clipContainer.classList.add('clip');
        audio.setAttribute('controls', '');
        deleteButton.innerHTML = "Delete";
        clipLabel.innerHTML = clipName;
  
        soundClips = document.getElementById("xxx")
        clipContainer.appendChild(audio);
        clipContainer.appendChild(clipLabel);
        clipContainer.appendChild(deleteButton);
        soundClips.appendChild(clipContainer);
  
        audio.controls = true;
        var blob = new Blob(chunks, {type: 'video/webm; codecs=vp8'});
        // chunks = [];
        var audioURL = URL.createObjectURL(blob);
        audio.src = audioURL;
        
        // esto debí colocarlo en la función PARAR
        // mediaRecorder.ondataavailable = function(e) {
        //     console.log(e)
        //     chunks.push(e.data);
        //   }
    }
}).catch(function (error) {
    console.log(error)
    // alert('Si gustas utilizar este sistema permite el acceso a tu cámara')
});

function GRABAR(params) {
    mediaRecorder.start();
    console.log(mediaRecorder.state);
    console.log("recorder started");
    // record.style.background = "red";
    // record.style.color = "black";
}

function PARAR(params) {
    mediaRecorder.stop();
    console.log(mediaRecorder.state);
    console.log("recorder stopped");

    // este método debe ir al parar para pushear la captura en el array
    mediaRecorder.ondataavailable = function(e) {
        console.log(e)
        chunks.push(e.data);
      }
    // record.style.background = "";
    // record.style.color = "";
}