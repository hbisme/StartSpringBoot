package com.hb.start_boot.common;

import com.hb.start_boot.entity.JsonResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice   // 这个注解拦截所有的异常
@ResponseBody  // 为了异常处理完后,给调用方返回json数据
public class GlobalExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    /*
    * 拦截自定义业务异常,返回业务异常信息
    * */
    @ExceptionHandler(BusinessErrorException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public JsonResult handleBusinessError(BusinessErrorException ex){
        String code = ex.getCode();
        String message = ex.getMessage();
        return new JsonResult(code, message);
    }

    /*
     * 参数缺少异常
     * @param ex MissingServletRequestParameterException
     * */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public JsonResult handleHttpMessageNotReadableException(MissingServletRequestParameterException ex) {
        LOGGER.error("缺少请求参数, {}", ex.getMessage());
        return new JsonResult("400", "缺少必要参数");
    }

    /*
    *  空指针异常
    * */
    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public JsonResult handleTypeMismatchException(NullPointerException ex) {
        LOGGER.error("空指针异常, {}", ex.getMessage());
        return new JsonResult("500", "空指针异常");
    }


    /*
    *  系统异常,预期以外的异常
    *  将拦截Exception放在末尾,是通用做法,这样会先拦截上面的具体异常.
    * */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public JsonResult handleUnexpectedServer(Exception ex){
        LOGGER.error("系统异常: ", ex);
        return new JsonResult("500", "系统发生异常, 请联系管理员.");
    }

}

