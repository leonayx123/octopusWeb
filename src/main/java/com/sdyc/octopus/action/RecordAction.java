package com.sdyc.octopus.action;

import com.sdyc.octopus.beans.IcoAccount;
import com.sdyc.octopus.dto.AccUserBtcDTO;
import com.sdyc.octopus.dto.RecordBtcAddDTO;
import com.sdyc.octopus.dto.RecordTradeTurnoverDTO;
import com.sdyc.octopus.service.record.RecordService;
import com.sdyc.octopus.utils.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yangxun on 2018-01-23.
 */
@Controller
@RequestMapping("/record")
public class RecordAction {
    @Resource
    RecordService recordService;


    @RequestMapping("/index.do")
    public ModelAndView goIndex(String userId){

        return new ModelAndView("record/index").addObject("userId",userId);

    }

    @ResponseBody
    @RequestMapping("/trade.do")
    public Map<String,Object> trade(String userId,String status){
        Map<String,Object> map=new HashMap<>();
        HashMap<String,Object> param=new HashMap<>();
        if(StringUtils.isBlank(status)){

            param.put("status",Integer.parseInt(status));
        }

        PageInfo pageInfo=new PageInfo();
        pageInfo.setCurrentPage(1);
        pageInfo.setRowPerPage(100);
        List<RecordTradeTurnoverDTO> trades= recordService.getTradeTurnover(userId, param, pageInfo);
        map.put("success",true);
        map.put("trades",trades);

        return  map;
    }


    @ResponseBody
    @RequestMapping("/btc.do")
    public Map<String,Object> btc(String userId){
        Map<String,Object> map=new HashMap<>();

        PageInfo pageInfo =new PageInfo();
        pageInfo.setCurrentPage(1);
        pageInfo.setRowPerPage(100);
        List<RecordBtcAddDTO> adds= recordService.getBtcAdd(userId,null,pageInfo) ;
        AccUserBtcDTO btc= recordService.getUserBtcDto(userId);
        map.put("success",true);
        map.put("adds",adds);
        map.put("btc",btc);
        return  map;
    }


    @ResponseBody
    @RequestMapping("/wallet.do")
    public Map<String,Object> wallet(String userId){
        Map<String,Object> map=new HashMap<>();

        PageInfo pageInfo =new PageInfo();
        pageInfo.setCurrentPage(1);
        pageInfo.setRowPerPage(100);
        List<IcoAccount> accounts= recordService.getUserWalletAccount(userId) ;

        map.put("success",true);
        map.put("wallets",accounts);
        return  map;
    }
}
