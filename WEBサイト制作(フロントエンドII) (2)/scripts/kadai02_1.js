document.querySelector('#box1BgBtn').onclick = () =>{
    box1.style.backgroundColor = document.querySelector('#setBgTxt').value;
};
document.querySelector('#box2ColorBtn').onclick = () =>{
    box2Text.style.color = document.querySelector('#setColorTxt').value;
};
document.querySelector('#box3FontSizeBtn').onclick = () =>{
    box3Text.style.fontSize = document.querySelector('#setFontSizeTxt').value;
};
document.querySelector('#box4BorderBtn').onclick = () =>{
    box4.style.border = document.querySelector('#setBorderTxt').value;
};