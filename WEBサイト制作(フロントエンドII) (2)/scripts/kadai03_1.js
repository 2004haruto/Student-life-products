const header = document.querySelector('#naviWrap');
window.addEventListener('scroll', (event) => {
    let y = document.documentElement.scrollTop;
    const categoryNavi = document.querySelector('#categoryNavi');
    if (naviWrap.offsetTop < y) {
        categoryNavi.style.top = y + 'px';
    } else {
        categoryNavi.style.top = naviWrap.style.top;
    }
});
