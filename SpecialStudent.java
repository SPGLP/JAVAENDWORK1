// 第四问 # 问题 2

public class SpecialStudent extends Student {

    public SpecialStudent(String n, int s, String sn, String cc, int[] p) {
        super(n, s, sn, cc, p);
    }
    
    // lsl_canStudyAbroad() 
    //
    // 作用：判断学生是符合拥有出国留学的资格
    //
    // 备注：调用父类 Student 的 lsl_canStudyAbroad() 方法
    //
    public void lsl_canStudyAbroad() {
        super.lsl_canStudyAbroad();
    }

    // lsl_canStudyAbroad(boolean) 
    //
    // 作用：判断学生是符合拥有出国留学的资格
    //
    // 备注：重载后的子类的 lsl_canStudyAbroad() 方法
    //
    public void lsl_canStudyAbroad(boolean ss) {
        if (ss) {
            System.out.println("该学生符合出国留学资格");
            canSA = true;
        }
    }
}
