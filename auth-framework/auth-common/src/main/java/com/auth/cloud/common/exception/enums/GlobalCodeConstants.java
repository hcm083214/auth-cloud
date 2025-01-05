package com.auth.cloud.common.exception.enums;

import com.auth.cloud.common.exception.ErrorCode;

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

    ErrorCode SUCCESS = new ErrorCode(200, "error.success");

    // ========== 客户端错误段 ==========

    ErrorCode BAD_REQUEST = new ErrorCode(400, "error.bad.request");
    ErrorCode UNAUTHORIZED = new ErrorCode(401, "error.unauthorized");
    ErrorCode FORBIDDEN = new ErrorCode(403, "error.forbidden");
    ErrorCode NOT_FOUND = new ErrorCode(404, "error.not.found");
    ErrorCode METHOD_NOT_ALLOWED = new ErrorCode(405, "error.method.not.allowed");
    ErrorCode BAD_CREDENTIALS = new ErrorCode(401, "error.bad.credentials");
    // 并发请求，不允许
    ErrorCode LOCKED = new ErrorCode(423, "error.locked");
    ErrorCode TOO_MANY_REQUESTS = new ErrorCode(429, "error.too.many.requests");

    // ========== 服务端错误段 ==========

    ErrorCode INTERNAL_SERVER_ERROR = new ErrorCode(500, "error.internal.server.error");
    ErrorCode NOT_IMPLEMENTED = new ErrorCode(501, "error.not.implemented");
    ErrorCode ERROR_CONFIGURATION = new ErrorCode(502, "error.error.configuration");

    // ========== 自定义错误段 ==========
    // 重复请求
    ErrorCode REPEATED_REQUESTS = new ErrorCode(900, "error.repeated.requests");
    ErrorCode DEMO_DENY = new ErrorCode(901, "error.demo.deny");

    ErrorCode UNKNOWN = new ErrorCode(999, "error.unknown");


}
