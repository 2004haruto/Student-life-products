const submit = document.querySelector('[type=submit]');
const text = document.querySelector('[type=text]');
const tbody = document.querySelector('tbody');
const comment = document.querySelector('.comment');
const control = document.querySelector('.control');
//const remove =document.querySelector("remove");

const removeBtn = document.createElement('Button');
removeBtn.innerText = '削除';
const trTemplate = document.createElement('tr');
const commentTemplate = document.createElement('td');
commentTemplate.classList.add('C');
const controlTemplate = document.createElement('td');

trTemplate.append(commentTemplate);
trTemplate.append(controlTemplate);
controlTemplate.append(removeBtn);

submit.addEventListener('click', (event) => {
    event.preventDefault();
    let t = text.value;
    if (t) {
        const listItem = trTemplate.cloneNode(true);
        listItem.querySelector('.C').innerText = t;
        tbody.append(listItem);
    }
});

tbody.addEventListener('click', (event) => {
    console.dir(event.target);
    if(event.target.tagName == 'BUTTON'){
        event.target.closest('tr').remove();
    }
});
