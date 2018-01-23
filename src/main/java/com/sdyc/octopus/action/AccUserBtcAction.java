package com.sdyc.octopus.action;

import com.sdyc.octopus.comm.BaseAction;
import com.sdyc.octopus.service.userBtc.AccUserBtcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * @Company
 * @Discription
 * @Author houfengli
 * @CreateDate 2018/1/23 19:43
 * @Version 1.0
 */
@Controller
@RequestMapping("/userBtc")
public class AccUserBtcAction  extends BaseAction {
    @Autowired
    private AccUserBtcService userBtcService;

    @RequestMapping("/index.do")
    public String userBtc(ModelMap modelMap){
        List<Map<String, Object>> all = userBtcService.findAll();
        modelMap.put("data",all);
        return "userBtc/index";
    }

}
