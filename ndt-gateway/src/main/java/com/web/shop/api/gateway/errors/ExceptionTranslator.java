package com.web.shop.api.gateway.errors;

import com.netflix.zuul.exception.ZuulException;
import com.tdt.cqsta.common.dto.MetaDTO;
import com.tdt.cqsta.common.dto.ResponseMetaData;
import com.tdt.cqsta.common.enums.MetaData;
import com.tdt.cqsta.common.utils.ObjectUtil;
import com.tdt.cqsta.gateway.config.GatewayConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import static com.tdt.cqsta.common.constants.CommonConstant.CONTENT_TYPE;

/**
 * Controller advice to translate the server side exceptions to client-friendly json structures.
 * The error response follows RFC7807 - Problem Details for HTTP APIs (https://tools.ietf.org/html/rfc7807).
 */
@ControllerAdvice
@Slf4j
public class ExceptionTranslator {

    @Autowired
    private GatewayConfig gatewayConfig;

    @ExceptionHandler
    public void handleException(Exception ex, HttpServletResponse response) throws IOException {
        log.warn("Error", ex);
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.getWriter().write(ObjectUtil.convertObjectToJson(new ResponseMetaData(
                new MetaDTO(MetaData.INTERNAL_SERVER_ERROR))));
        response.setContentType(CONTENT_TYPE);
        response.flushBuffer();
    }

    @ExceptionHandler
    public void handleZuulException(ZuulException ex, HttpServletResponse response) throws IOException {
        log.warn("ZuulException", ex);
        response.setStatus(HttpStatus.FORBIDDEN.value());
        response.getWriter().write(ObjectUtil.convertObjectToJson(new ResponseMetaData(
                new MetaDTO(MetaData.FORBIDDEN))));
        response.setContentType(CONTENT_TYPE);
        response.flushBuffer();
    }

    @ExceptionHandler
    public void handleTokenInvalidException(TokenInvalidException ex, HttpServletResponse response) throws IOException {
        log.warn("Passing invalid Token", ex);
        response.setStatus(HttpStatus.FORBIDDEN.value());
        response.getWriter().write(ObjectUtil.convertObjectToJson(new ResponseMetaData(
                new MetaDTO(MetaData.FORBIDDEN))));
        response.setContentType(CONTENT_TYPE);
        response.flushBuffer();
    }

    @ExceptionHandler
    public void handleMaxUploadSizeExceededException(MaxUploadSizeExceededException ex, HttpServletResponse response) throws IOException {
        log.warn("Max Upload Size Exceeded Exception {}", ex.getMessage());
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.getWriter().write(ObjectUtil.convertObjectToJson(new ResponseMetaData(
                new MetaDTO(MetaData.MAX_UPLOAD_SIZE_EXCEEDED_EXCEPTION.getMetaCode(),
                        String.format(MetaData.MAX_UPLOAD_SIZE_EXCEEDED_EXCEPTION.getMessage(), gatewayConfig.getMaxFileSize())),
                new ArrayList<>())));
        response.setContentType(CONTENT_TYPE);
        response.flushBuffer();
    }

}
