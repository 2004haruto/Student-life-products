document.querySelector('#loginBtn').onclick = () =>{
    loginDialog.showModal();
};
document.querySelector('#closeBtn').onclick = () =>{
    loginDialog.close();
};
//ダイアログがクリックされた時に
const dialog = document.querySelector('dialog');
dialog.addEventListener('click', (event) => {
	//もしクリックされたものがdialogだったら
	if(onclick = dialog){
		//ダイアログを閉じる
        loginDialog.close();
	}
});