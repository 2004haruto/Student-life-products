const slider = document.querySelector('#slider');
const sliderAll = document.querySelectorAll('#slider li');

let intervalId = null;

const delay = 3000;

let intervalCount = 0;
let next = 0;

sliderAll[intervalCount].classList.toggle('show');

    setInterval(() => {
    if(intervalCount == sliderAll.length - 1){
        next = 0;
        //console.log(intervalCount);
    }else{
        next = intervalCount + 1;
    }
    sliderAll[intervalCount].classList.toggle('show');
    sliderAll[next].classList.toggle('show');
    intervalCount = next;
},delay);