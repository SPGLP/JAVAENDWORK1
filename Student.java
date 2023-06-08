//第一题#问题2

class Student{
    String name;    // 学生姓名
    int sex;    //性别：男0；女1
    String studentNumber;   // 学号
    int pointEnglish;   // 英语成绩
    int pointCourse1;   // 课程1成绩
    int pointCourse2;   // 课程2成绩
    int pointCourse3;   // 课程3成绩
    int pointCourse4;   // 课程3成绩

    boolean canStudyAbroad() {
        if((pointCourse1 & pointCourse2 & pointCourse3 & pointCourse4) > 80 & pointEnglish > 95) {
            return true;
        } else {
            return false;
        }
    }
}