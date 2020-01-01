package pl.wiktor.shop.shopadministration.controller.advice;

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
import pl.wiktor.shop.shopadministration.controller.TagController;
import pl.wiktor.shop.shopadministration.exception.InvalidTagException;

@ControllerAdvice(assignableTypes = TagController.class)
public class AdviceTagControllerExceptionHandler extends ResponseEntityExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(value = {
            DataIntegrityViolationException.class
    })
    protected ResponseEntity<Object> handleConflict(Exception ex, WebRequest request) {
        InvalidTagException invalidTagException = new InvalidTagException();
        String bodyOfResponse = invalidTagException.getMessage();
        logger.error(bodyOfResponse);
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
}
