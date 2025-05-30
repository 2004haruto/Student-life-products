public class ECCSoft {
    //下請けを持っている
    public Subcontractor sub = new TulipCompany();
    public ECCSoft() {
        System.out.println("信頼と実績のECCソフト株式会社です！");
        System.out.println("どんな課題でも私たちが真摯に解決します！！");
    }

    public void work(){
        sub.work();
    }
    //下請けの変更をするメソッド
    public void setSubcontractor(Subcontractor sub){
        this.sub = sub;//下請けの変更
        System.out.println(sub.getName() + "に変更します!");
    }
}
