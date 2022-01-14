var exampleModal = document.getElementById('exampleModal')
exampleModal.addEventListener('show.bs.modal', function (event) {
    // Button that triggered the modal
    var button = event.relatedTarget
    // Extract info from data-bs-* attributes
    var recipient = button.getAttribute('data-bs-whatever')
    // If necessary, you could initiate an AJAX request here
    // and then do the updating in a callback.
    //
    // Update the modal's content.
    var modalTitle = exampleModal.querySelector('.modal-title')
    var modalBodyInput = exampleModal.querySelector('.modal-body input')
    var modalBodyInput3 = exampleModal.querySelector('.mb-4 input')
    var modalBodyInput2 = exampleModal.querySelector('.modal-body textarea')

    modalTitle.textContent = 'New message to ' + recipient
    modalBodyInput.value = recipient
    modalBodyInput2.value = recipient
    modalBodyInput3.value = recipient
})