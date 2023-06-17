// 第四问 # 问题 2

import java.sql.SQLException;
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
        int saveSum = 0;                         // 已保存学生个数
        SpecialStudent student;                  // 批量声明 999 个 Class 数组以保存学生信息
        ConnectToDatabase ctd = new ConnectToDatabase(); // 引入数据库连接类以使用连接方法
        int sumSA;                               // 符合或不符合出国留学资格学生总数

        //程序逻辑：
        System.out.println("");
        System.out.println("欢迎进入学生出国留学录入和判断系统");
        System.out.println("");
        ctd.lsl_getConnection();
        System.out.println("操作指南：1-学生出国留学资格判断；2-退出系统；3-符合条件的人数统计；4-不符合条件的人数统计；5-输出人员信息");
        System.out.println("");
        do {
            System.out.print("指令 > ");
            lsl_opType = scan.nextInt();
            switch(lsl_opType) {
                case 1:
                    //学生出国留学资格判断的逻辑：
                    try {
                        System.out.print("请输入学生姓名：");
                        lsl_StuName = scan.next();
                        System.out.print("请输入学生性别（输入数字：1-男；0-女）：");
                        lsl_StuSex = scan.nextInt();
                        System.out.print("请输入学生学号：");
                        lsl_StuNumber = scan.next();
                        System.out.print("请输入学生班级：");
                        lsl_CourseClass = scan.next();
                        for (int i = 0; i < 4; i++) {
                            System.out.print("输入第" + (i + 1) + "科成绩：");
                            lsl_StuPoint[i] = scan.nextInt();
                        }
                        System.out.print("请输入英语成绩：");
                        lsl_StuPoint[4] = scan.nextInt();
                        student = new SpecialStudent(  
                                                        lsl_StuName, 
                                                        lsl_StuSex, 
                                                        lsl_StuNumber, 
                                                        lsl_CourseClass, 
                                                        lsl_StuPoint
                                                    );
                        System.out.print("是否获得互联网+竞赛国家级奖项：（1-是；0-否）：");
                        if(scan.nextInt() == 1) {
                            student.spcStudent = true;
                            student.lsl_canStudyAbroad(student.spcStudent);
                        } else {
                            student.spcStudent = false;
                            student.lsl_canStudyAbroad();
                        }
                        ctd.lsl_dataAdd(student.name, student.sex, student.studentNumber, student.courseClass, student.point, student.spcStudent, student.canSA);
                        // 写入数据库
                        System.out.println("已保存该学生信息");
                        System.out.println("");
                    } catch (Exception e) {                     // 错误处理
                        System.out.println("发生了错误导致判断和保存失败，请检查您的输入内容是否合法，或者尝试重启程序");
                    }
                    break;
                case 2:
                    System.out.println("退出系统");
                    try {
                        ctd.res.close();
                        ctd.psta.close();
                        ctd.cnn.close();
                    } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    shouldExit = true; break;
                case 3:
                    // 符合条件的人数统计逻辑：
                    sumSA = 0;
                    ctd.lsl_DataReadpre();
                    try {
                        while (ctd.res.next()) {
                            ctd.lsl_DataRead();
                            if (ctd.retSA) {
                                sumSA ++;
                            }
                        }
                    } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.println("符合留学资格学生总数：" + sumSA);
                    System.out.println(""); break;
                case 4:
                   // 不符合条件的人数统计逻辑：
                    sumSA = 0;
                    ctd.lsl_DataReadpre();
                    try {
                        while (ctd.res.next()) {
                            ctd.lsl_DataRead();
                            if (!ctd.retSA) {
                                sumSA ++;
                            }
                        }
                        System.out.println("不符合留学资格学生总数：" + sumSA);
                    } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.println(""); break;
                case 5:
                    // 输出人员信息逻辑：
                    System.out.println("所有保存的学生信息如下：");
                    System.out.println("");
                    try {
                        ctd.lsl_DataReadpre();
                        while (ctd.res.next()) {
                            ctd.lsl_DataRead();
                            System.out.println(ctd.retName);
                        }
                        System.out.println("========================");
                    } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                default:
                    System.out.println("未知操作，请查阅操作指南并检查输入的指令");
                    System.out.println(""); break;
            }
        } while (!shouldExit);
    }
}
