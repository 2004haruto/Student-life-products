function firstTask(callback) {
    setTimeout(() => {
      console.log('1番目のタスク完了');
      callback();
    }, 1000);
  }
  
  function secondTask(callback) {
    setTimeout(() => {
      console.log('2番目のタスク完了');
      callback();
    }, 1000);
  }
  
  function thirdTask() {
    setTimeout(() => {
      console.log('3番目のタスク完了');
    }, 1000);
  }
  
  // コールバック地獄の例
  firstTask(() => {
    secondTask(() => {
      thirdTask();
    });
  });