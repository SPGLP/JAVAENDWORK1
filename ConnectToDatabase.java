// 第四问 # 问题 2

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectToDatabase {
    // 变量声明：
    public Connection cnn;                      // Connect 对象
    public String cnnName = "root";             // 数据库登录用户名
    public String cnnPassWord = "LslSql114514"; // 数据库登录密码
    public PreparedStatement psta;              // PreparedStatement 对象
    public ResultSet res;                       // Resultset 对象
    public String retName;                      // Start：返回的学生信息 
    public int retSex;                          //
    public String retNum;                       //
    public String retCC;                        //
    public int[] retPoint = new int[5];         //
    public boolean retSPCS;                     //
    public boolean retSA;                       // End：返回的学生信息 
    
    // public Connection lsl_getConnection()
    // 
    // 作用：初始化数据库连接，并返回 Connection 对象
    //
    public Connection lsl_getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  // 加载数据库驱动
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }  
        System.out.println("Driver load success");
        try {
            cnn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studentsinfo_javawork?useUnicode=true&characterEncoding=utf8", 
                cnnName, 
                cnnPassWord
            );                                                    // 使用 utf-8 编码加载数据库
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }                    
        System.out.println("Database connect success");
        System.out.println("");
        return cnn;
    }

    // public void dataAdd()
    // 
    // 作用：将学生数据写入数据库
    //
    public void lsl_dataAdd(String lsl_SN, int lsl_SS, String lsl_SNUM, String lsl_CC, int[] lsl_SP, boolean lsl_SA, boolean lsl_SPCS) {
        String sqlCommand = "insert into studentsinfo(id,studentName,studentSex,studentNumber,studentCourseClass,studentPointEnglish,studentPointOne,studentPointTwo,studentPointThree,studentPointFour,studentSP,studentSA) values (?,?,?,?,?,?,?,?,?,?,?,?);";
        // 数据表插入语句，该表共有 12 项数据项，对应类型分别为(INT,VARCHAR(45),INT,VARCHAR(45),VARCHAR(45),INT,INT,INT,INT,INT,TINYINT,TINYINT)
        try {
            psta = cnn.prepareStatement(sqlCommand);
            psta.setInt(1, 0);                    // 数据项：id
            psta.setString(2, lsl_SN);              // 数据项：studentName
            psta.setInt(3, lsl_SS);                 // 数据项：studentSex
            psta.setString(4, lsl_SNUM);            // 数据项：studentNumber
            psta.setString(5, lsl_CC);              // 数据项：studentCourseClass
            psta.setInt(6, lsl_SP[4]);              // 数据项：studentPointEnglish
            psta.setInt(7, lsl_SP[0]);              // 数据项：studentPointOne
            psta.setInt(8, lsl_SP[1]);              // 数据项：studentPointTwo
            psta.setInt(9, lsl_SP[2]);              // 数据项：studentPointThree
            psta.setInt(10, lsl_SP[3]);             // 数据项：studentPointFour
            psta.setBoolean(11, lsl_SPCS);          // 数据项：studentSP
            psta.setBoolean(12, lsl_SA);            // 数据项：studentSA
            psta.executeUpdate();                                  // 录入完毕，更新数据库
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // public void lsl_DataReadpre()
    // 
    // 作用：读取数据库操作的初始化
    //
    public void lsl_DataReadpre(){
        String sqlCommand = "select * from studentsinfo";
        try {
            psta = cnn.prepareStatement(sqlCommand);
            res = psta.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // public void lsl_DataRead()
    // 
    // 作用：读取数据库，获取学生信息
    //
    public void lsl_DataRead() {
        try {
            retName = res.getString("studentName");
            retSex = res.getInt("studentSex");
            retNum = res.getString("studentNumber");
            retCC = res.getString("studentCourseClass");
            retPoint[4] = res.getInt("studentPointEnglish");
            retPoint[0] = res.getInt("studentPointOne");
            retPoint[1] = res.getInt("studentPointTwo");
            retPoint[2] = res.getInt("studentPointThree");
            retPoint[3] = res.getInt("studentPointFour");
            retSPCS = res.getBoolean("studentSP");
            retSA = res.getBoolean("studentSA");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    
    }
}
