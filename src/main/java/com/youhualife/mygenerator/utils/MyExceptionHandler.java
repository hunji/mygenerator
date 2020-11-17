package com.youhualife.mygenerator.utils;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author hunji
 * @version 1.0
 * @date 2020-11-17 15:15
 */
@Component
public class MyExceptionHandler implements HandlerExceptionResolver {
    private Logger logger = LoggerFactory.getLogger(getClass());
    
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ReturnResult r = new ReturnResult();
        try {
            response.setContentType("application/json;charset=utf-8");
            response.setCharacterEncoding("utf-8");

            if (ex instanceof MyException) {
                r.put("code", ((MyException) ex).getCode());
                r.put("msg", ((MyException) ex).getMessage());
            }else if(ex instanceof DuplicateKeyException){
                r = ReturnResult.error("数据库中已存在该记录");
            }else{
                r = ReturnResult.error();
            }

            //记录异常日志
            logger.error(ex.getMessage(), ex);
            String json = JSON.toJSONString(r);
            response.getWriter().print(json);
        } catch (Exception e) {
            logger.error("MyExceptionHandler 异常处理失败", e);
        }
        return new ModelAndView();
    }
}
