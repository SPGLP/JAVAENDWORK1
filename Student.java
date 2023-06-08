//第一题#问题2

public class Student {
    //变量声明：
    String name;                    // 学生姓名
    int sex;                        // 学生性别
    String studentNumber;           // 学号
    String courseClass;             // 班级
    int[] point = new int[5];       // 成绩，其中 point[5] 为英语

    // canStudyAbroad() 
    //
    // 作用：判断学生是符合拥有出国留学的资格
    //
    boolean canStudyAbroad() {
        int i;
        for (i = 0; i < 4; i++) {   // 判断其它科目成绩是否都大于 80，否则返回 false
            if (point[i] < 80) {
                return false;
            }
        }
        if (point[5] < 95) {        // 判断英语成绩是否大于 95，是则返回 true，否则返回 false
            return false;
        } else {
            return true;
        }
    }
}
