package com.auth.cloud.common.enums;

import com.auth.cloud.common.pojo.GlobalCode;

/**
 * 全局错误码枚举
 * 0-999 系统异常编码保留
 *
 * 一般情况下，使用 HTTP 响应状态码 https://developer.mozilla.org/zh-CN/docs/Web/HTTP/Status
 * 虽然说，HTTP 响应状态码作为业务使用表达能力偏弱，但是使用在系统层面还是非常不错的
 * 比较特殊的是，因为之前一直使用 0 作为成功，就不使用 200 啦。
 *
 * @author
 */
public interface GlobalCodeConstants {

    GlobalCode SUCCESS = new GlobalCode(200, "error.success");

    // ========== 客户端错误段 ==========

    GlobalCode BAD_REQUEST = new GlobalCode(400, "error.bad.request");
    GlobalCode UNAUTHORIZED = new GlobalCode(401, "error.unauthorized");
    GlobalCode FORBIDDEN = new GlobalCode(403, "error.forbidden");
    GlobalCode NOT_FOUND = new GlobalCode(404, "error.not.found");
    GlobalCode METHOD_NOT_ALLOWED = new GlobalCode(405, "error.method.not.allowed");
    GlobalCode BAD_CREDENTIALS = new GlobalCode(401, "error.bad.credentials");
    // 并发请求，不允许
    GlobalCode LOCKED = new GlobalCode(423, "error.locked");
    GlobalCode TOO_MANY_REQUESTS = new GlobalCode(429, "error.too.many.requests");

    // ========== 服务端错误段 ==========

    GlobalCode INTERNAL_SERVER_ERROR = new GlobalCode(500, "error.internal.server.error");
    GlobalCode NOT_IMPLEMENTED = new GlobalCode(501, "error.not.implemented");
    GlobalCode ERROR_CONFIGURATION = new GlobalCode(502, "error.error.configuration");

    // ========== 自定义错误段 ==========
    // 重复请求
    GlobalCode REPEATED_REQUESTS = new GlobalCode(900, "error.repeated.requests");
    GlobalCode DEMO_DENY = new GlobalCode(901, "error.demo.deny");

    GlobalCode UNKNOWN = new GlobalCode(999, "error.unknown");


}
