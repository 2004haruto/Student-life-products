// dayjsの読み込み 今回はES Module形式で読み込み
import dayjs from 'dayjs';

// 現在の日付を取得
const now = dayjs();

// 日付をフォーマットして出力
console.log('現在の日付と時刻:', now.format('YYYY-MM-DD HH:mm:ss'));

// 1週間後の日付を取得
const nextWeek = now.add(7, 'day');

// 1週間後の日付をフォーマットして出力
console.log('1週間後の日付:', nextWeek.format('YYYY-MM-DD'));