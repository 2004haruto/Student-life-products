// dayjsの読み込み 今回はES Module形式で読み込み
import dayjs from 'dayjs';

// 現在の日付を取得
const now = dayjs();

//現在の日付を表示する
export function showCurrentDate() {
    console.log('現在の日付:', now.format('YYYY-MM-DD'));
}
 
//現在の日付に、引数で渡された日数を加算した日付を表示する
export function addDaysToDate(days) {
    console.log('現在の日付に365日足した日付:' ,dayjs().add(days, 'day').format('YYYY-MM-DD'));
}
