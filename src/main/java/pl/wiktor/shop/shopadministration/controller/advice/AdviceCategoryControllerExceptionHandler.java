package pl.wiktor.shop.shopadministration.controller.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import pl.wiktor.shop.shopadministration.controller.CategoryController;
import pl.wiktor.shop.shopadministration.exception.InvalidCategoryNameException;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice(assignableTypes = CategoryController.class)
public class AdviceCategoryControllerExceptionHandler extends ResponseEntityExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(value = {
            IllegalArgumentException.class,
            DataIntegrityViolationException.class,
            NullPointerException.class,
            EntityNotFoundException.class,
            EmptyResultDataAccessException.class
    })
    protected ResponseEntity<Object> handleConflict(Exception ex, WebRequest request) {
        InvalidCategoryNameException invalidCategoryNameException = new InvalidCategoryNameException();
        String bodyOfResponse = invalidCategoryNameException.getMessage();
        logger.error(bodyOfResponse);
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
}
