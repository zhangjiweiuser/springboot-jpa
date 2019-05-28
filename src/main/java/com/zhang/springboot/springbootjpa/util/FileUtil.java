package com.zhang.springboot.springbootjpa.util;

import com.google.common.collect.Lists;
import com.google.common.io.Files;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class FileUtil {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        BufferedReader bufferedReader = Files.newReader(new File("E:/1.txt"), Charset.forName("UTF-8"));
        String str;
        List<String> names = Lists.newArrayList();
        int num = 0;
        String sql = "insert into budget_subject(subject_name) values (?);";
        while ((str = bufferedReader.readLine()) != null) {
            if (!"".equals(str) && !"计算".equals(str) && !"导入".equals(str)) {
                System.out.println(num++ + "==" + str);
                names.add(str);
            }
        }
        System.out.println(num);
        bufferedReader.close();
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC&useSSL=false", "root", "root");
        final PreparedStatement ps = conn.prepareStatement(sql);
        for (String name : names) {
            ps.setString(1, name);
            ps.addBatch();
        }
        ps.executeBatch();
        conn.close();
    }
}
