package com.indic.proposal.service.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
@Slf4j
public class ProposalInterceptor  implements HandlerInterceptor {
    List<String> headerList = Arrays.asList("X_USER_ID","X_USERNAME", "X_AUTHORITY", "X_VERIFICATION",
                                            "X_USER_ACCESS", "X_ACCESS_SOURCE", "X_ACCESS_SOURCE_HIERARCHY");
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (checkHeaderForEmptyORNullValues(request)){
            return true;
        }else{
            response.setStatus(502);
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }

    private boolean checkHeaderForEmptyORNullValues(HttpServletRequest request) {
        Boolean flag = true;
        for(String headerName: headerList){
            String fromReuest = request.getHeader(headerName);
            if(fromReuest != null && !fromReuest.trim().isEmpty()){
                flag = true;
            }else {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
