package net.xdclass.demoproject.handler;

import net.xdclass.demoproject.utils.JsonData;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
@ControllerAdvice
public class CustomExtHandler {

//    @ExceptionHandler(value= Exception.class)
//    JsonData handlerException(Exception e, HttpServletRequest request){
//       return JsonData.buildError("服务端出问题了",-2);
//    }

    @ExceptionHandler(value= Exception.class)
    Object handlerException(Exception e, HttpServletRequest request){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error.html");//设置默认配置
        modelAndView.addObject("msg",e.getMessage());
        return modelAndView;
    }
}
