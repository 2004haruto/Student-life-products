//JCDB APIをインポートする
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class UserRegistration{
	
	public static void main(String[] args) throws Exception{
		
		System.out.println("～～～ユーザ登録処理～～～\n");
		
		//データベース接続に必要な変数を宣言
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try{
			
			//スキャナーインスタンス化
			Scanner sc = new Scanner(System.in);
			
			//各項目の入力を行う
			System.out.print("名前を入力してください：");
			String UNAME = sc.nextLine();
			System.out.print("ふりがなを入力してください:");
			String RUBY = sc.nextLine();
			System.out.print("メールアドレスを入力してください:");
			Sting MAIL = sc.nextLine();
			System.out.print("パスワードを入力してください：");
			String PASSWORD = sc.nextLine();
			System.out.print("電話番号を入力してください：");
			String TEL = sc.nextLine();
			//カード番号は任意なので、質問により処理を分岐
			String CARD_NO = null;
			System.out.print("カード番号を登録しますか？y【はい】、それ以外【いいえ】：");
			String cname = sc.nextLine();
			if (cname.equalsIgnoreCase("y")) {
				System.out.print("カード番号を入力してください：");
				CARD_NO = sc.nextLine();
			}
			System.out.print("郵便番号を入力してください：");
			String POST_NO = sc.nextLine();
			// お届け先住所のリストを作成
			while(true) {
				System.out.print("お届け先住所を入力してください：");
				String ADDRESS = sc.nextLine();
				addresses.add(ADDRESS);

				System.out.print("別のお届け先を登録しますか？y【はい】、それ以外【いいえ】：");
				String anotheradd = sc.nextLine();

				if(!anotheradd.equalsIgnoreCase("y")) {
					break;
				}
			}

			System.out.println("～～～データベースに登録中～～～\n");
			
			//ドライバを読み込む(環境変数でCLASSPAHTの設定が必要)
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//データベース情報
			String dbname = "studb";   //接続データベース
			String dbuser = "dbuser";  //データベースユーザ
			String dbpass = "ecc";     //ログインパスワード
			//JDBCドライバ情報設定
			String dbinfo =
					"jdbc:mysql://localhost/"+dbname+"?characterEncoding=UTF-8&serverTimezone=JST";
			//データベースに接続する
			conn = DriverManager.getConnection(dbinfo, dbuser, dbpass);
			conn.setAutoCommit(false); //オートコミットを無効

			st = conn.createStatement();
			//Insert文を実行する(User表)
			String userInsert = String.format(
					"INSERT INTO User (UNAME, RUBY, MAIL, PASSWORD, TEL, CARD_NO) VALUES ('%s', '%s', '%s', '%s', '%s', '%s')",
					UNAME, RUBY, MAIL, PASSWORD, TEL, CARD_NO
			);
			st.executeUpdate(userInsert, Statement.RETURN_GENERATED_KEYS);
			
			//Insert文を実行する(Deliaddress表)
			for (String addr : addresses) {
				String addressInsert = String.format(
						"INSERT INTO Deliaddress (USER_NO, ADDRESS) VALUES ('%d', '%s')",
						USER_NO, addr
				);
				st.executeUpdate(addressInsert);
			}
			//正常終了ならコミット
			conn.commit();
			
			
			System.out.println("～～～登録処理が完了しました～～～\n");
			
		}catch(Exception e){
			//エラーの場合は、ロールバックを行う。
			if(conn != null){
				conn.rollback();
				System.out.println("～～～登録処理が異常終了しました～～～\n");
			}
			e.printStackTrace();
			
		}finally{
			
			//MySQLとの接続を切断する
			if(st != null){ st.close(); }
			if(conn != null){ conn.close(); }
			
		}
	}
}
