//问题二 # 第 1 问

import java.util.*;
import java.util.Scanner;

public class MainWin {
    //变量声明：
    static Scanner scan = new Scanner(System.in);  // 扫描器

    //主函数
    //
    public static void main(String[] args) {
        // 变量声明：
        String lsl_pwInput;                         // 存放输入的密码
        int lsl_falsePWtimes = 0;                   // 密码错误数

        // 程序逻辑：
        System.out.println("+++++欢迎进入学生出国留学录入和判断系统+++++");
        System.out.println("请输入密码：");
        do {                                    // 循环密码输入判断
            lsl_pwInput = scan.next();
            if(lsl_pwInput.equals("123")) {
                lsl_systemMeun();
                break;                          // 正确则退出循环
            } else {                            // 错误的密码处理方式：
                if (lsl_falsePWtimes > 3) {     // 如果错误次数大于 3
                    System.out.print("密码错误次数过多，请联系管理员确认密码！");
                    System.exit(0);      // 退出系统
                }
                System.out.println("密码错误，请重试");
                lsl_falsePWtimes += 1;
            }
        } while(true);
    }

    // public static void systemMeun()
    //
    // 作用：系统主菜单的处理
    //
    public static void lsl_systemMeun() {
        // 变量声明：
        int lsl_opType = 0;                      // 操作种类
        boolean shouldExit = false;              // 退出系统标志
        String lsl_StuName;                      // 学生姓名
        int lsl_StuSex;                          // 学生性别
        String lsl_StuNumber;                    // 学生学号
        String lsl_CourseClass;                  // 学生班级
        int[] lsl_StuPoint = new int[5];         // 学生成绩，lsl_StuPoint[4] 为英语成绩

        //程序逻辑：
        System.out.println("");
        System.out.println("欢迎进入学生出国留学录入和判断系统");
        System.out.println("");
        System.out.println("操作指南：1-学生出国留学资格判断；2-退出系统；3-符合条件的人数统计；4-不符合条件的人数统计");
        System.out.println("");
        do {
            System.out.print("指令 > ");
            lsl_opType = scan.nextInt();
            switch(lsl_opType) {
                case 1:
                    //学生出国留学资格判断的逻辑：
                    System.out.print("请输入学生姓名：");
                    lsl_StuName = scan.next();
                    System.out.print("请输入学生性别（输入数字：1-男；0-女）：");
                    lsl_StuSex = scan.nextInt();
                    System.out.print("请输入学生学号：");
                    lsl_StuNumber = scan.next();
                    System.out.print("请输入学生班级：");
                    lsl_CourseClass = scan.next();
                    for (int i = 0; i < 4; i++) {
                        System.out.print("输入第" + (i + 1) + "科成绩");
                        lsl_StuPoint[i] = scan.nextInt();
                    }
                    System.out.print("请输入英语成绩：");
                    lsl_StuPoint[4] = scan.nextInt();
                    Student student = new Student(  
                                                    lsl_StuName, 
                                                    lsl_StuSex, 
                                                    lsl_StuNumber, 
                                                    lsl_CourseClass, 
                                                    lsl_StuPoint
                                                );
                    if (student.lsl_canStudyAbroad()) {
                        System.out.println("该学生满足出国留学的资格");
                    } else {
                        System.out.println("该学生不满足出国留学的资格");
                    }
                    break;
                case 2:
                    System.out.println("退出系统");
                    shouldExit = true; break;
                case 3:
                    System.out.println("符合条件的人数统计"); break;
                case 4:
                    System.out.println("不符合条件的人数统计"); break;
                default:
                    System.out.println("未知操作，请查阅操作指南并检查输入的指令"); break;
            }
        } while (!shouldExit);
    }
}
