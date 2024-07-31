package com.minhnh.hapedu.shared.exceptions;

import com.minhnh.hapedu.application.response.exception.BusinessExceptionResponse;
import com.minhnh.hapedu.application.response.exception.ExceptionResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Log4j2
public class AppExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ExceptionResponse> unknownExceptionHandler(Exception exception) {
        log.error("> ERROR: ", exception);
        return new ResponseEntity<>(
                ExceptionResponse.builder()
                        .success(false)
                        .message("Có lỗi xảy ra. Vui lòng thử lại")
                        .build(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @ExceptionHandler(value = {NotAuthorizedException.class, AccessDeniedException.class})
    public ResponseEntity<ExceptionResponse> notAuthorizedExceptionHandler(Exception exception) {
        return new ResponseEntity<>(
                ExceptionResponse.builder().success(false).message(exception.getMessage()).build(),
                HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(value = ForbiddenException.class)
    public ResponseEntity<ExceptionResponse> forbiddenExceptionHandler(Exception exception) {
        return new ResponseEntity<>(
                ExceptionResponse.builder().success(false).message(exception.getMessage()).build(),
                HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<ExceptionResponse> notFoundExceptionHandler(Exception exception) {
        return new ResponseEntity<>(
                ExceptionResponse.builder().success(false).message(exception.getMessage()).build(),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<ExceptionResponse> badRequestExceptionHandler(Exception exception) {
        return new ResponseEntity<>(
                ExceptionResponse.builder().success(false).message(exception.getMessage()).build(),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<BusinessExceptionResponse> businessExceptionHandler(BusinessException exception) {
        return new ResponseEntity<>(
                BusinessExceptionResponse.builder()
                        .success(false)
                        .message(exception.getMessage())
                        .messageCode(exception.getMessageCode())
                        .build(),
                exception.getHttpStatus()
        );
    }
}
