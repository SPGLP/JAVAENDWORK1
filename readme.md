# 关于数据库的配置说明

本题（第四问 # 题目2）的数据库配置方案如下：

数据库版本：MySQL 8.0.33
connector 版本：mysql-connector-java 8.0.33

用户名：root
密码：LslSql114514

数据库名称：studentsinfo_javawork
数据库编码：utf8mb3_general_ci

数据表名称：studentsinfos

数据表项： 
```
          id                   |  INT                |  主键、自增

          studentName          |  VARCHAR(45)   

          studentSex           |  INT

          studentNumber        |  VARCHAR(45)

          studentCourseClass   |  VARCHAR(45)

          studentPointEnglish  |  INT

          studentPointOne      |  INT

          studentPointTwo      |  INT

          studentPointThree    |  INT

          studentPointFour     |  INT

          studentSP            |  TINYINT(BOOLEAN)

          studentSA            |  TINYINT(BOOLEAN)
```