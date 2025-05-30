const submit = document.querySelector('[type=submit]');
const text = document.querySelector('[type=text]');
const tbody = document.querySelector('tbody');
const removeBtn = document.createElement('Button');
removeBtn.innerText = '削除';
const trTemplate = document.createElement('tr');
const commentTemplate = document.createElement('td');
commentTemplate.classList.add('C');
const controlTemplate = document.createElement('td');

trTemplate.append(commentTemplate);
trTemplate.append(controlTemplate);
controlTemplate.append(removeBtn);

let tasks = [];

submit.addEventListener('click', (event) => {
  event.preventDefault();
  const t = text.value.trim();
  if (t) {
    tasks.push(t);
    updateLocalStorage();
    renderTasks();
    text.value = '';
  }
});

tbody.addEventListener('click', (event) => {
  if (event.target.tagName === 'BUTTON') {
    const index = Array.from(tbody.children).indexOf(event.target.closest('tr'));
    tasks.splice(index, 1);
    updateLocalStorage();
    renderTasks();
  }
});

function updateLocalStorage() {
  localStorage.setItem('tasks', JSON.stringify(tasks));
}

function renderTasks() {
  tbody.innerHTML = '';
  tasks.forEach(task => {
    const listItem = trTemplate.cloneNode(true);
    listItem.querySelector('.C').innerText = task;
    tbody.append(listItem);
  });
}

window.addEventListener('DOMContentLoaded', () => {
  const storedTasks = localStorage.getItem('tasks');
  if (storedTasks) {
    tasks = JSON.parse(storedTasks);
    renderTasks();
  }
});
