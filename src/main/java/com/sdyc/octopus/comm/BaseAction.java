package com.sdyc.octopus.comm;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Company
 * @Discription
 * @Author houfengli
 * @CreateDate 2018/1/23 13:40
 * @Version 1.0
 */
public class BaseAction {

    protected Logger log = LogManager.getLogger(this.getClass());
    private static final String user_id="1mil10coins";
    private static final String version="v18.01 a";

    @ModelAttribute
    public ModelMap setVersion(ModelMap map, RedirectAttributes redirectAttributes){
        //不加redirectAttributes参数,当redirect时，ＵＲＬ会加version参数
        map.put("version",version);
        return map;
    }
    protected String getUserFromSession(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return user_id;
    }
}
