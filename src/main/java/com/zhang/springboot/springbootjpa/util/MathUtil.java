package com.zhang.springboot.springbootjpa.util;

import com.google.common.collect.Maps;
import org.apache.commons.jexl2.Expression;
import org.apache.commons.jexl2.JexlContext;
import org.apache.commons.jexl2.JexlEngine;
import org.apache.commons.jexl2.MapContext;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Map;

public class MathUtil {
    public static void main(String[] args) throws ScriptException {
        long start = System.currentTimeMillis();

        JexlEngine jexl = new JexlEngine();
        Map<String, Object> map = Maps.newHashMap();
        map.put("k", 10);
        map.put("x", 2);
        map.put("y", 4);
        String formula = "k-(x-y)*0.1";
        Expression expression2 = jexl.createExpression(formula);
        JexlContext jc = new MapContext();
        for (String key : map.keySet()) {
            jc.set(key, map.get(key));
        }
        System.out.println(expression2.evaluate(jc));
        System.out.println(System.currentTimeMillis() - start);
        start = System.currentTimeMillis();
        ScriptEngine se = new ScriptEngineManager().getEngineByName("JavaScript");
        double k = 10;
        double x = 2;
        double y = 4;
        String expression = k + "-(" + x + "-" + y + ")*" + 0.1;
        Double value = (Double) se.eval(expression);
        System.out.println(value);
        System.out.println(System.currentTimeMillis() - start);
    }
}
