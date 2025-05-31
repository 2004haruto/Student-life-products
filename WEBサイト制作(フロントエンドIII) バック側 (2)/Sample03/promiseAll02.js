// 非同期処理をシミュレートするPromise関数

// 成功する関数
const fetchData1 = () => new Promise((resolve, reject) => {
    setTimeout(() => {
      resolve('データ1の取得に成功');
    }, 1000);
  });
  
  // 失敗する関数
  const fetchData2 = () => new Promise((resolve, reject) => {
    setTimeout(() => {
      reject('データ2の取得に失敗'); // 失敗をシミュレート
    }, 2000);
  });
  
  // Promise.allSettledを使ってすべての結果を取得
  async function fetchAllData() {
    const results = await Promise.allSettled([fetchData1(), fetchData2()]);
    
    results.forEach((result) => {
      if (result.status === 'fulfilled') {
        console.log('成功:', result.value);  // 成功した場合の結果
      } else {
        console.error('失敗:', result.reason);  // 失敗した場合のエラーメッセージ
      }
    });
  }
  
  fetchAllData();