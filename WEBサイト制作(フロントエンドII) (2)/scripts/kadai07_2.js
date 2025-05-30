const addition = document.querySelector('#openItemDialog');
const span = document.querySelector('.material-icons');
const itemPrice=document.querySelector("#itemPrice");
const Name =document.querySelector('#itemName');
const text = document.querySelector('[type=text]');
const itemDescription =document.querySelector('#itemDescription');
const submit = document.querySelector('[type=submit]');
const tbody = document.querySelector('tbody');
const removeBtn = document.createElement('Button');
removeBtn.innerText = '削除';
removeBtn.classList.add('remove');
const trTemplate = document.createElement('tr');
const commentTemplate = document.createElement('td');
commentTemplate.classList.add('C');
const controlTemplate = document.createElement('td');
const str=document.createElement('td');
str.classList.add('D');
const setr=document.createElement('td');
setr.classList.add('E');
const mtr=document.createElement('td');
mtr.classList.add('F');

trTemplate.append(commentTemplate);
trTemplate.append(str);
trTemplate.append(setr);
trTemplate.append(mtr);
trTemplate.append(controlTemplate);
controlTemplate.append(removeBtn);

console.log(trTemplate);

addition.addEventListener('click', (event) => {
    itemDialog.showModal();
    })
    submit.addEventListener('click', (event) => {
        event.preventDefault();
        let productid = text.value;
        let productname=Name.value;
        let productd=itemDescription.value;
        let productp=itemPrice.value;
if (productid,productname,productd,productp) {
            const idlistItem = trTemplate.cloneNode(true);
            idlistItem.querySelector('.C').innerText = productid;
            tbody.append(idlistItem);
            const idlistItem2 = trTemplate.cloneNode(true);
            idlistItem.querySelector('.D').innerText = productname;
            tbody.append(idlistItem);
            const idlistItem3 = trTemplate.cloneNode(true);
            idlistItem.querySelector('.E').innerText = productd;
            tbody.append(idlistItem);
            const idlistItem4 = trTemplate.cloneNode(true);
            idlistItem.querySelector('.F').innerText = productp;
            tbody.append(idlistItem);

        }
});

span.addEventListener('click', (event) => {
    //もしクリックされたものがdialogだったら
    if (onclick = span) {
        //ダイアログを閉じる
        itemDialog.close();
    }
});

//削除処理
tbody.addEventListener('click', (event) => {
    console.dir(event.target);
    if (event.target.tagName == 'BUTTON') {
        event.target.closest('tr').remove();
    }
});