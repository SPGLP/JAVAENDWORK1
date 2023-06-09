//第二题 # 问题4

public class Student {
    //变量声明：
    String name;                    // 学生姓名
    int sex;                        // 学生性别：男1；女0
    String studentNumber;           // 学号
    String courseClass;             // 班级
    int[] point = new int[5];       // 成绩，其中 point[4] 为英语
    boolean canSA;                  // 是否能出国留学标记

    public Student(String n, int s, String sn, String cc, int[] p) {
        this.name = n;
        this.sex = s;
        this.studentNumber = sn;
        this.courseClass = cc;
        for(int i = 0; i < 5; i++) {
            this.point[i] = p[i];
        }
    }

    // canStudyAbroad() 
    //
    // 作用：判断学生是符合拥有出国留学的资格
    //
    public void lsl_canStudyAbroad() {
        canSA = true;
        if (point[4] > 95) {         // 如果英语大于 95
            for (int i = 0; i < 4; i++) {
                if (point[i] < 80) { // 如果存在科目小于 80
                    canSA = false;
                    break;  
                }
            }
        } else {
            canSA = false;
        }
        if(canSA) {
            System.out.println("该学生符合出国留学资格");
        } else {
            System.out.println("该学生不符合出国留学资格");
        }
    }
}
