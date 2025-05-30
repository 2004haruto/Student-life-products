//JCDB API���C���|�[�g����
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class UserRegistration{
	
	public static void main(String[] args) throws Exception{
		
		System.out.println("�`�`�`���[�U�o�^�����`�`�`\n");
		
		//�f�[�^�x�[�X�ڑ��ɕK�v�ȕϐ���錾
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try{
			
			//�X�L���i�[�C���X�^���X��
			Scanner sc = new Scanner(System.in);
			
			//�e���ڂ̓��͂��s��
			System.out.print("���O����͂��Ă��������F");
			String UNAME = sc.nextLine();
			System.out.print("�ӂ肪�Ȃ���͂��Ă�������:");
			String RUBY = sc.nextLine();
			System.out.print("���[���A�h���X����͂��Ă�������:");
			Sting MAIL = sc.nextLine();
			System.out.print("�p�X���[�h����͂��Ă��������F");
			String PASSWORD = sc.nextLine();
			System.out.print("�d�b�ԍ�����͂��Ă��������F");
			String TEL = sc.nextLine();
			//�J�[�h�ԍ��͔C�ӂȂ̂ŁA����ɂ�菈���𕪊�
			String CARD_NO = null;
			System.out.print("�J�[�h�ԍ���o�^���܂����Hy�y�͂��z�A����ȊO�y�������z�F");
			String cname = sc.nextLine();
			if (cname.equalsIgnoreCase("y")) {
				System.out.print("�J�[�h�ԍ�����͂��Ă��������F");
				CARD_NO = sc.nextLine();
			}
			System.out.print("�X�֔ԍ�����͂��Ă��������F");
			String POST_NO = sc.nextLine();
			// ���͂���Z���̃��X�g���쐬
			while(true) {
				System.out.print("���͂���Z������͂��Ă��������F");
				String ADDRESS = sc.nextLine();
				addresses.add(ADDRESS);

				System.out.print("�ʂ̂��͂����o�^���܂����Hy�y�͂��z�A����ȊO�y�������z�F");
				String anotheradd = sc.nextLine();

				if(!anotheradd.equalsIgnoreCase("y")) {
					break;
				}
			}

			System.out.println("�`�`�`�f�[�^�x�[�X�ɓo�^���`�`�`\n");
			
			//�h���C�o��ǂݍ���(���ϐ���CLASSPAHT�̐ݒ肪�K�v)
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//�f�[�^�x�[�X���
			String dbname = "studb";   //�ڑ��f�[�^�x�[�X
			String dbuser = "dbuser";  //�f�[�^�x�[�X���[�U
			String dbpass = "ecc";     //���O�C���p�X���[�h
			//JDBC�h���C�o���ݒ�
			String dbinfo =
					"jdbc:mysql://localhost/"+dbname+"?characterEncoding=UTF-8&serverTimezone=JST";
			//�f�[�^�x�[�X�ɐڑ�����
			conn = DriverManager.getConnection(dbinfo, dbuser, dbpass);
			conn.setAutoCommit(false); //�I�[�g�R�~�b�g�𖳌�

			st = conn.createStatement();
			//Insert�������s����(User�\)
			String userInsert = String.format(
					"INSERT INTO User (UNAME, RUBY, MAIL, PASSWORD, TEL, CARD_NO) VALUES ('%s', '%s', '%s', '%s', '%s', '%s')",
					UNAME, RUBY, MAIL, PASSWORD, TEL, CARD_NO
			);
			st.executeUpdate(userInsert, Statement.RETURN_GENERATED_KEYS);
			
			//Insert�������s����(Deliaddress�\)
			for (String addr : addresses) {
				String addressInsert = String.format(
						"INSERT INTO Deliaddress (USER_NO, ADDRESS) VALUES ('%d', '%s')",
						USER_NO, addr
				);
				st.executeUpdate(addressInsert);
			}
			//����I���Ȃ�R�~�b�g
			conn.commit();
			
			
			System.out.println("�`�`�`�o�^�������������܂����`�`�`\n");
			
		}catch(Exception e){
			//�G���[�̏ꍇ�́A���[���o�b�N���s���B
			if(conn != null){
				conn.rollback();
				System.out.println("�`�`�`�o�^�������ُ�I�����܂����`�`�`\n");
			}
			e.printStackTrace();
			
		}finally{
			
			//MySQL�Ƃ̐ڑ���ؒf����
			if(st != null){ st.close(); }
			if(conn != null){ conn.close(); }
			
		}
	}
}
