//第一题#问题2

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
    boolean lsl_canStudyAbroad() {
        int i;
        for (i = 0; i < 4; i++) {   // 判断其它科目成绩是否都大于 80，否则返回 false
            if (point[i] < 80) {
                return false;
            }
        }
        if (point[4] < 95) {        // 判断英语成绩是否大于 95，是则返回 true，否则返回 false
            return false;
        } else {
            return true;
        }
    }
}
