// document.querySelector('#saveBtn').onclick = () => {
//     console.log('click');
// }

document.querySelector('#saveBtn').addEventListener('click', (event) => {
    console.log('click!!');
    console.log(event.target);
});

document.querySelector('#saveBtn').addEventListener('click', () => {
    console.log('hoge');
});