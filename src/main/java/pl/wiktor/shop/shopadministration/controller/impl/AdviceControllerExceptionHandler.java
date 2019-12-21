package pl.wiktor.shop.shopadministration.controller.impl;

import org.postgresql.util.PSQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import pl.wiktor.shop.shopadministration.controller.CategoryController;
import pl.wiktor.shop.shopadministration.exception.InvalidCategoryNameException;

@ControllerAdvice(assignableTypes = CategoryController.class)
public class AdviceControllerExceptionHandler extends ResponseEntityExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(value = {IllegalArgumentException.class, DataIntegrityViolationException.class, NullPointerException.class})
    protected ResponseEntity<Object> handleConflict(Exception ex, WebRequest request){
        InvalidCategoryNameException invalidCategoryNameException = new InvalidCategoryNameException();
        String bodyOfResponse = invalidCategoryNameException.getMessage();
        logger.error(bodyOfResponse);
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
}
