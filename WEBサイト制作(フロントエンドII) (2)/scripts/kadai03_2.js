const header = document.querySelector('header');

document.addEventListener('scroll',(event) => {
    const headerY = header.offsetTop;
    if(headerY >= 60){
        header.style.top = '-60px';
    }else{
        header.style.top = '0';
    }
});

document.addEventListener('mousemove',(event) => {
    if(event.clientY >= 60){
        header.style.top = '-60px';
    }else{
        header.style.top = '0';
    }
})