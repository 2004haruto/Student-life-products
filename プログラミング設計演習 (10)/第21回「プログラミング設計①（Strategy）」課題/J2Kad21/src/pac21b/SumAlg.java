package pac21b;

// 計算アルゴリズム
interface SumAlg {
    void sum(int n);
}
class NobitaAlg implements SumAlg {
    public void sum(int n) { System.out.println("のび太：え～っ、わかんないよ～"); }
}
class SuneoAlg implements SumAlg {
    public void sum(int n) {
        System.out.println("スネ夫：こんなの簡単さ。順番に足していけばいいんだ。");
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            System.out.println("スネ夫：" + i + "を足して");
            sum += i;
        }
        System.out.println("スネ夫：答えは" + sum + "だよ！");
    }
}
class DekisugiAlg implements SumAlg {
    public void sum(int n) {
        System.out.println("出木杉：こんなの簡単さ。再帰処理を使えばいいんだ。");
        int sum = recursion(n);
        System.out.println("出木杉：答えは" + sum + "だよ！");
    }
    private int recursion(int n) {
        System.out.println("出木杉：ここは再帰処理" + n + "だよ。");
        int rval = (n <= 1)? 1: recursion(n - 1) + n;
        System.out.println("出木杉：呼び出し元へ戻るね。");
        return rval;
    }
}
class SizukaAlg implements SumAlg {
    public void sum(int n) {
        System.out.println("しずか：逆順に並べてみればいいんだわ。");

        for (int i = 1; i <= n; i++) {
            System.out.printf("%3d", i);
        }
        System.out.println();

        for (int i = 1; i <= n; i++) {
            System.out.printf("%3d", (n - i + 1));
        }
        System.out.println();

        System.out.println("しずか：上と下を足すと・・・");
        for (int i = 1; i <= n; i++) {
            System.out.printf("%3d", (i + (n - i + 1)));
        }
        System.out.println();
        System.out.println("しずか：そうか！" + (n + 1) + " * " + n + "を計算して半分にすればいいんだわ！");
        System.out.println("しずか：答えは" + ((n + 1) * n / 2) + "よ！");
    }
}
