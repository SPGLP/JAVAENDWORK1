//第一题#问题2

class Student{
    // 变量声明：
    String name;                // 学生姓名
    int sex;                    // 性别：男0；女1
    String studentNumber;       // 学号
    String CourseClass;         // 班级
    int[] point = new int[5];   // 成绩，其中 point[0] 为英语

    // canStudyAbroad()
    //
    // 作用：判断学生是否符合拥有留学的资格
    //
    boolean canStudyAbroad() {
        int i;
        for (i = 0; i < 4 ; i++) {
            if (point[i] < 80) {    // 判断其它科目成绩是否都大于80分，否则返回 false
                return false;   
            }
        }
        if(point[5] < 95) {         // 判断英语科目成绩是否都大于95分，是则返回 true，否则返回 false
            return false;
        } else {
            return true;
        }
    }
}