const thumbnails = document.querySelectorAll('.thumbnail');
const dialog = document.querySelector('#imgDialog');

thumbnails.forEach(( element ) => {
    element.addEventListener('click',(event) =>{
        //console.log(element.querySelector('img').src);
        dialog.querySelector('img').src = element.querySelector('img').src;
        dialog.showModal();
    });
    dialog.addEventListener('click', (event) => {
        dialog.close();
    });
});