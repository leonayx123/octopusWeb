package com.sdyc.octopus.action;

import com.sdyc.octopus.beans.IcoAccount;
import com.sdyc.octopus.comm.BaseAction;
import com.sdyc.octopus.comm.Coin;
import com.sdyc.octopus.comm.Exchange;
import com.sdyc.octopus.dto.AccUserBtcDTO;
import com.sdyc.octopus.dto.RecordBtcAddDTO;
import com.sdyc.octopus.service.record.RecordService;
import com.sdyc.octopus.utils.DataTablesPagination;
import com.sdyc.octopus.utils.PageInfo;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yangxun on 2018-01-23.
 */
@Controller
@RequestMapping("/record")
public class RecordAction extends BaseAction {
    @Resource
    RecordService recordService;


    @RequestMapping("/index.do")
    public ModelAndView goIndex(String userId){
//        String userId = getUserFromSession();
        return new ModelAndView("record/index").addObject("userId",userId);

    }

    @ResponseBody
    @RequestMapping("/trade.do")
    public DataTablesPagination trade(String userId,Integer status, @DateTimeFormat(pattern = "yyyy-MM-dd HH") Date bDate,
                                      @DateTimeFormat(pattern = "yyyy-MM-dd HH")  Date eDate, Exchange hEx, Exchange lEx, Coin coin, DataTablesPagination page){

        DataTablesPagination tradeTurnover = recordService.getTradeTurnover(userId, status, bDate, eDate, hEx, lEx, coin, page);
        return  tradeTurnover;
    }


    @ResponseBody
    @RequestMapping("/btc.do")
    public Map<String,Object> btc(){
        String userId = getUserFromSession();
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
