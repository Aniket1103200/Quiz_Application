package com.quiz.util;

public class ResponseUtils {
    public static <T> ApiResponse<T> createErrorResponse(String message) {
        return new ApiResponse.Builder<T>()
                .status("error")
                .message(message)
                .build();
    }

    public static <T> ApiResponse<T> createSuccessResponse(T data, String message) {
        return new ApiResponse.Builder<T>()
                .status("success")
                .message(message)
                .data(data)
                .build();
    }
}
