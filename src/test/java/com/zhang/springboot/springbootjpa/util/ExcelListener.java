package com.zhang.springboot.springbootjpa.util;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.List;

public class ExcelListener extends AnalysisEventListener {
    private List<Object> datas = new ArrayList<>();

    @Override
    public void invoke(Object o, AnalysisContext context) {
        System.out.println("当前行:" + context.getCurrentRowNum());
        System.out.println("当前sheet:" + context.getCurrentSheet().getSheetNo());
        System.out.println(o);
        datas.add(o);

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }

    public List<Object> getDatas() {
        return datas;
    }

    public void setDatas(List<Object> datas) {
        this.datas = datas;
    }

}
