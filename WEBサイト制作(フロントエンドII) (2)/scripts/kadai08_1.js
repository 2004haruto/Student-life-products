//必要なDOMを取得
const uname=document.querySelector("#user_name");
const aname=document.querySelector("#author_name");
const product=document.querySelector("#product_url");
const video=document.querySelector("#video_url");
const category=document.querySelector("#product_category");
const description=document.querySelector("#description");
const storage=window.sessionStorage;
console.log(storage);
const submitbtn =document.querySelector("[type=submit]");
//inputタグとかとってくる
//SessionStrageからデータを取得
uname.value=storage.getItem('uname');
aname.value=storage.getItem('aname');
product.value=storage.getItem('product_url');
video.value=storage.getItem('video_url');
if(storage.getItem('product_category')){
    category.value=storage.getItem('product_category');
}
description.value=storage.getItem('description');
//データがあればinputタグに表示
//inputタグのvalue属性に設定する
//登録ボタンが押されたら
submitbtn.addEventListener('click', (event) => {
    event.preventDefault();
    storage.setItem("uname",uname.value);
    storage.setItem("aname",aname.value);
    storage.setItem("product_url",product.value);
    storage.setItem("video_url",video.value);
    storage.setItem("product_category",category.value);
    storage.setItem("description",description.value);
});
//formに入力されているデータをsessionStrageに保存