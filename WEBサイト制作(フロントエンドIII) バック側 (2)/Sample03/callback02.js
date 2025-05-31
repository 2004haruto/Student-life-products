console.log('1: 処理を開始します');

function doSomething(callback) {
  setTimeout(() => {
    console.log('2: 3秒待ってから実行される処理');
    callback(); // コールバック関数を呼び出す
  }, 1000);
}

function afterDone() {
  console.log('3: 処理を終了します。');
}

// doSomething関数にコールバック関数を渡す
doSomething(afterDone);