package com.zwy.base.restfulapi;

import org.springframework.http.HttpStatus;

/**
 * 类 名: Results
 * 描 述: 响应结果集
 * 作 者: 张文雅
 * 创 建：2020年1月15日
 * 版 本：v1.0.0
 *
 * 历 史: (版本) 作者 时间 注释
 */
public final class Results {

    private Results(){
    }

    /**
     * 类 名: Results.Code
     * 描 述: 响应代码
     * 作 者: 张文雅
     * 创 建：2020年1月15日
     * 版 本：v1.0.0
     * 历 史: (版本) 作者 时间 注释
     */
    public static final class Code {

        public static final int OK = 0;

        public static final int BAD_REQUEST = HttpStatus.BAD_REQUEST.value();

        public static final int UNAUTHORIZED = HttpStatus.UNAUTHORIZED.value();

        public static final int FORBIDDEN = HttpStatus.FORBIDDEN.value();

        public static final int NOT_FOUND = HttpStatus.NOT_FOUND.value();

        public static final int INTERNAL_SERVER_ERROR = HttpStatus.INTERNAL_SERVER_ERROR.value();

        private Code(){
        }
    }

    public static Result<Void> ok() {
        return ok(null, null);
    }

    public static Result<Void> ok(String message) {
        return ok(message, null);
    }

    public static <T> Result<T> ok(T data) {
        return ok(null, data);
    }

    public static <T> Result<T> ok(String message, T data) {
        return response(HttpStatus.OK, Code.OK, message, data);
    }

    public static Result<Void> badRequest() {
        return badRequest(null, null);
    }

    public static Result<Void> badRequest(String message) {
        return badRequest(message, null);
    }

    public static <T> Result<T> badRequest(String message, T data) {
        return response(HttpStatus.BAD_REQUEST, Code.BAD_REQUEST, message, data);
    }

    public static Result<Void> unauthorized() {
        return unauthorized(null, null);
    }

    public static Result<Void> unauthorized(String message) {
        return unauthorized(message, null);
    }

    public static <T> Result<T> unauthorized(String message, T data) {
        return response(HttpStatus.UNAUTHORIZED, Code.UNAUTHORIZED, message, data);
    }

    public static Result<Void> forbidden() {
        return forbidden(null, null);
    }

    public static Result<Void> forbidden(String message) {
        return forbidden(message, null);
    }

    public static <T> Result<T> forbidden(String message, T data) {
        return response(HttpStatus.FORBIDDEN, Code.FORBIDDEN, message, data);
    }


    public static Result<Void> notFound() {
        return notFound(null, null);
    }

    public static Result<Void> notFound(String message) {
        return notFound(message, null);
    }

    public static <T> Result<T> notFound(String message, T data) {
        return response(HttpStatus.NOT_FOUND, Code.NOT_FOUND, message, data);
    }

    public static Result<Void> internalServerError() {
        return internalServerError(null, null);
    }

    public static Result<Void> internalServerError(String message) {
        return internalServerError(message, null);
    }

    public static <T> Result<T> internalServerError(String message, T data) {
        return response(HttpStatus.INTERNAL_SERVER_ERROR, Code.INTERNAL_SERVER_ERROR, message, data);
    }

    private static <T> Result<T> response(HttpStatus status, int code, String message, T data) {
        return new Result<>(ApiResponse.create(code, message, data), status);
    }
}
