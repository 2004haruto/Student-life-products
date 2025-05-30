const descriptions = {
  'margherita': '絶妙なシンプルさと独自の風味が特長。国産の厳選素材で作られ、No.1人気を誇るマルゲリータ。',
  'pepperoni': '食欲を満たすボリュームと絶妙なスパイシーさが魅力のペパロニピザ。満足感と味のハーモニーをお楽しみください。',
  'bolognese': '全世代に愛される定番ボロネーゼ。新鮮な生パスタと絶妙なもちもち食感が楽しめる一品。',
  'carbonara': '北海道産生クリームとチーズで仕上げたカルボナーラ。ボリューム満点で軽快な味わいが特長です。',
};


const image = document.querySelectorAll('.popular-item');
const itemdialog = document.querySelector('#itemDialog');
const dialogimg=itemdialog.querySelector('#itemImageWrapper');



  image.forEach((element) => {
  const iteminfo = element.querySelector('.item-info');
  const Name = iteminfo.getElementsByTagName('a');
  const Price =iteminfo.getElementsByTagName('span');
  const getId=element.id;
    element.addEventListener('click', (event) => {
        event.preventDefault();
        itemdialog.querySelector('#itemDialogName').innerText=Name[0].innerText;
        itemdialog.querySelector('#itemDialogPrice').innerText=Price[0].innerText;
        itemdialog.querySelector("#itemDialogDescription").innerText=descriptions[getId];

        dialogimg.querySelector('img').src = element.querySelector('img').src;
        itemdialog.showModal();
    });
});

itemdialog.addEventListener('click', (event) => {
    itemdialog.close();
});