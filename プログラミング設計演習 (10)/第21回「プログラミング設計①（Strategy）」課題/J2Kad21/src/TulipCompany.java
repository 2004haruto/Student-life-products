//抽象クラスのSubcontractorを継承
public class TulipCompany extends Subcontractor{
    //コンストラクタ
    public TulipCompany(){
        //nameを上書き
        name = "チューリップ商会";
    }
    public void work(){
        System.out.println("チューリップ商会「下請けはつらいなー！」");
    }
}
