document.addEventListener('DOMContentLoaded', function() {
    let fileInput = document.querySelector('#fileUpload');
    let fileInputDark = document.querySelector('#fileUploadDark');
    let filenameContainer = document.querySelector('#filename');
    let filenameContainerDark = document.querySelector('#filenameDark');
    let photoFilenameContainer = document.querySelector('#photoFilename');
    let dropZone = document.querySelector('#fileUpload');
    let dropZoneDark = document.querySelector('#fileUploadDark');
    let photoUpload = document.querySelector('#photoUpload');
    let photoName = document.querySelector('#photoName');

    fileInput.addEventListener('change', function() {
      	filenameContainer.innerText = fileInput.value.split('\\').pop();
    });
    fileInputDark.addEventListener('change', function() {
      	filenameContainerDark.innerText = fileInputDark.value.split('\\').pop();
    });
    photoUpload.addEventListener('change', function() {
      	photoFilenameContainer.innerText = photoUpload.value.split('\\').pop();
    });
    fileInput.addEventListener('dragenter', function() {
    	dropZone.classList.add('dragover');
    });
    fileInputDark.addEventListener('dragenter', function() {
    	dropZoneDark.classList.add('dragover');
    });

    fileInput.addEventListener('dragleave', function() {
      	dropZone.classList.remove('dragover');
    });
    fileInputDark.addEventListener('dragleave', function() {
      	dropZoneDark.classList.remove('dragover');
    });

    let logo = document.getElementById('logo');
    if(logo.getAttribute('src') == "" || null) {
        logo.src = '/img/placeholder.png';
    }
    let logoDark = document.getElementById('logoDark');
    if(logoDark.getAttribute('src') == "" || null) {
        logoDark.src = '/img/placeholder.png';
    }
    let photo = document.getElementById('photo');
    if(photo && photo.getAttribute('src') == "" || null) {
        photo.src = '/img/placeholder.png';
    }

    fileInput.onchange = function() {
        let fileInput = document.querySelector('#fileUpload');
        const formData = new FormData();

        formData.append('file', fileInput.files[0]);

        const options = {
            method: 'POST',
            body: formData,
        };

        fetch('/uploadFile', options)
            .then(function(response) {
                  return response.json();
        })
            .then(function(data){
                console.log(data);
                document.getElementById("imageUrl").value = data.fileViewUri;
                document.getElementById("logo").src = data.fileViewUri;
        });
    }
    fileInputDark.onchange = function() {
        let fileInputDark = document.querySelector('#fileUploadDark');
        const formData = new FormData();

        formData.append('file', fileInputDark.files[0]);

        const options = {
            method: 'POST',
            body: formData,
        };

        fetch('/uploadFile', options)
            .then(function(response) {
                  return response.json();
        })
            .then(function(data){
                console.log(data);
                document.getElementById("imageUrlDark").value = data.fileViewUri;
                document.getElementById("logoDark").src = data.fileViewUri;
        });
    }
    if (photoUpload) {
        photoUpload.onchange = function() {
            let photoUpload = document.querySelector('#photoUpload');
            const formData = new FormData();

            formData.append('file', photoUpload.files[0]);

            const options = {
                method: 'POST',
                body: formData,
            };

            fetch('/uploadFile', options)
                .then(function(response) {
                      return response.json();
            })
                .then(function(data){
                    console.log(data);
                    document.getElementById("photoUrl").value = data.fileViewUri;
                    document.getElementById("photo").src = data.fileViewUri;
            });
        }
    }
});