package com.auth.cloud.common.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.auth.cloud.common.pojo.CommonResult;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 黄灿民
 * 响应处理类，用于统一处理HTTP响应
 * @date 2025/01/05
 */
public class ResponseHandler {
    // 定义响应的内容类型为JSON格式，字符集为UTF-8
    private static final String CONTENT_TYPE = "application/json;charset=utf-8";

    /**
     * 处理HTTP响应的方法
     *
     * @param response HTTP响应对象，用于设置响应头和响应体
     * @param code 响应状态码
     * @param message 响应消息
     */
    public static void handler(HttpServletResponse response, Integer code, String message) {
        // 设置响应的内容类型
        response.setContentType(CONTENT_TYPE);
        // 创建一个错误的CommonResult对象，包含状态码和消息
        CommonResult<String> resultVO = CommonResult.error(code, message);
        // 将CommonResult对象转换为JSON字符串
        String jsonString = JSON.toJSONString(resultVO);

        // 使用try-with-resources确保资源正确关闭
        try (PrintWriter out = response.getWriter()) {
            // 将JSON字符串写入响应体
            out.write(jsonString);
            // 刷新输出流，确保数据被发送
            out.flush();
        } catch (IOException e) {
            // 记录异常日志
            e.printStackTrace();
            // 根据实际需求处理异常，例如返回默认错误信息
        }
    }
}

