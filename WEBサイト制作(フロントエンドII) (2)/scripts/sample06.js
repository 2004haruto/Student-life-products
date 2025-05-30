const list = document.querySelector('#list');
const listText = document.querySelector('#listText');
const addBtn = document.querySelector('#addBtn');
const removeAllBtn = document.querySelector('#removeAllBtn');

//liタグのテンプレート作成
const listItemtemplate = document.querySelector('li');
console.log(listItemtemplate);

addBtn.addEventListener('click', () => {
	//#listTextに入力された値を取得
  let text = listText.value;
	//#listTextに値が入力されていたら
  if(text){
    listItemTemplate.innerText = text;
    list.append(listItemTemplate);
  }
});

addBtn.addEventListener('click', () => {
    let text = listText.value;
    if(text){
      // listItemTemplate.innerText = text;
      const listItem = listItemTemplate.cloneNode(true);
      listItem.innerText = text;
      list.append(listItem);
    }
  });

  //li削除
  removeAllBtn.addEventListener('click',(event) => {
    const listItem = list.querySelectorAll('li');
    listItem.forEach((listItem) => {
      listItem.remove;
    });
  })