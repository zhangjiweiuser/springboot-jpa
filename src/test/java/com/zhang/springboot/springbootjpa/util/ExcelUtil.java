package com.zhang.springboot.springbootjpa.util;

import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.support.ExcelTypeEnum;
import org.junit.Test;

import java.io.*;

public class ExcelUtil {

    @Test
    public void testRead07() {
        try {
            File file = new File("E://loan.xlsx");
            InputStream is = new FileInputStream(file);
            ExcelListener listener = new ExcelListener();
            ExcelReader reader = new ExcelReader(is,  null, listener,true);
            reader.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
