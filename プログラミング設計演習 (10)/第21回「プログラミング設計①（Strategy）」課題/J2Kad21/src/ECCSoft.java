public class ECCSoft {
    //�������������Ă���
    public Subcontractor sub = new TulipCompany();
    public ECCSoft() {
        System.out.println("�M���Ǝ��т�ECC�\�t�g������Ђł��I");
        System.out.println("�ǂ�ȉۑ�ł����������^���ɉ������܂��I�I");
    }

    public void work(){
        sub.work();
    }
    //�������̕ύX�����郁�\�b�h
    public void setSubcontractor(Subcontractor sub){
        this.sub = sub;//�������̕ύX
        System.out.println(sub.getName() + "�ɕύX���܂�!");
    }
}
