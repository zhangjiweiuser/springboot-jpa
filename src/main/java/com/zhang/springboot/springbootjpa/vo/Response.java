package com.zhang.springboot.springbootjpa.vo;

public class Response {
    public int code;
    public String msg;
    public Object data;
    private static int SUCCESS_CODE = 200;
    private static String SUCCESS_MSG = "success";

    private static int ERROR_CODE = -1;
    private static String ERROR_MSG = "error";

    private static int SERVICE_EXCEPTION_CODE = 6001;
    private static String SERVICE_EXCEPTION_MSG = "服务异常";

    public static Response SUCCESS(Object data) {
        Response response = new Response();
        response.code = SUCCESS_CODE;
        response.msg = SUCCESS_MSG;
        response.data = data;
        return response;
    }

    public static Response ERROR(String msg) {
        Response response = new Response();
        response.code = ERROR_CODE;
        response.msg = msg;
        return response;
    }

    public static Response ERROR(int code, String msg) {
        Response response = new Response();
        response.code = code;
        response.msg = msg;
        return response;
    }
    public static Response SERVICE_EXCEPTION() {
        Response response = new Response();
        response.code = SERVICE_EXCEPTION_CODE;
        response.msg = SERVICE_EXCEPTION_MSG;
        return response;
    }
}
