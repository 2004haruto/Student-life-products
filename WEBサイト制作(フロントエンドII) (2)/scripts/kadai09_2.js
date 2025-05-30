const addition = document.querySelector('#openItemDialog');
const span = document.querySelector('.material-icons');
const itemPrice = document.querySelector("#itemPrice");
const Name = document.querySelector('#itemName');
const text = document.querySelector('[type=text]');
const itemDescription = document.querySelector('#itemDescription');
const submit = document.querySelector('[type=submit]');
const tbody = document.querySelector('tbody');
const removeBtn = document.createElement('Button');
removeBtn.innerText = '削除';
removeBtn.classList.add('remove');
const trTemplate = document.createElement('tr');
const commentTemplate = document.createElement('td');
commentTemplate.classList.add('C');
const controlTemplate = document.createElement('td');
const str = document.createElement('td');
str.classList.add('D');
const setr = document.createElement('td');
setr.classList.add('E');
const mtr = document.createElement('td');
mtr.classList.add('F');

trTemplate.append(commentTemplate);
trTemplate.append(str);
trTemplate.append(setr);
trTemplate.append(mtr);
trTemplate.append(controlTemplate);
controlTemplate.append(removeBtn);

addition.addEventListener('click', (event) => {
    itemDialog.showModal();
});

submit.addEventListener('click', (event) => {
    event.preventDefault();
    let productId = text.value;
    let productName = Name.value;
    let productDescription = itemDescription.value;
    let productPrice = itemPrice.value;
    if (productId && productName && productDescription && productPrice) {
        const newItem = {
            id: productId,
            name: productName,
            description: productDescription,
            price: productPrice,
        };

        addTableRow(newItem);

        // Local Storageにデータを追加して保存
        const storedItems = JSON.parse(localStorage.getItem('items')) || [];
        storedItems.push(newItem);
        updateLocalStorage(storedItems);

        // // 入力フォームをリセット
        // text.value = '';
        // Name.value = '';
        // itemDescription.value = '';
        // itemPrice.value = '';

        itemDialog.close();
    }
});

span.addEventListener('click', (event) => {
    if (event.target.tagName === 'SPAN') {
        itemDialog.close();
    }
});

// 削除ボタンをクリックした時の処理
tbody.addEventListener('click', (event) => {
    if (event.target.classList.contains('remove')) {
        const row = event.target.closest('tr');
        const productId = row.querySelector('.C').innerText;

        // テーブルから行を削除
        row.remove();

        // Local Storageから該当の商品情報を削除して保存
        const storedItems = JSON.parse(localStorage.getItem('items')) || [];
        const updatedItems = storedItems.filter(item => item.id !== productId);
        updateLocalStorage(updatedItems);
    }
});

// ページが読み込まれたときの処理
window.addEventListener('DOMContentLoaded', () => {
    // Local Storageからデータを取得
    const storedItems = JSON.parse(localStorage.getItem('items')) || [];

    // 取得したデータをテーブルに表示
    storedItems.forEach(item => {
        addTableRow(item);
    });
});

// 商品情報をLocal Storageに保存する関数
function updateLocalStorage(items) {
    localStorage.setItem('items', JSON.stringify(items));
}

// テーブルに行を追加する関数
function addTableRow(item) {
    const newRow = trTemplate.cloneNode(true);
    newRow.querySelector('.C').innerText = item.id;
    newRow.querySelector('.D').innerText = item.name;
    newRow.querySelector('.E').innerText = item.description;
    newRow.querySelector('.F').innerText = item.price;
    tbody.appendChild(newRow);
}
