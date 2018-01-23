package com.sdyc.octopus.service.record;

import com.sdyc.octopus.beans.IcoAccount;
import com.sdyc.octopus.comm.Coin;
import com.sdyc.octopus.comm.Exchange;
import com.sdyc.octopus.dto.AccUserBtcDTO;
import com.sdyc.octopus.dto.RecordBtcAddDTO;
import com.sdyc.octopus.utils.DataTablesPagination;
import com.sdyc.octopus.utils.PageInfo;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by yangxun on 2018-01-23.
 */
public interface RecordService {

    /**
     * 交易记录
     * @param userId
     * @param status
     * @param bDate  eDate
     * @param hEx
     * @param lEx
     * @param coin
     * @param page
     * @return
     */
    public DataTablesPagination getTradeTurnover(String userId, Integer status, Date bDate, Date eDate, Exchange hEx, Exchange lEx, Coin coin, DataTablesPagination page);

    public List<RecordBtcAddDTO> getBtcAdd(String userId,Map<String,Object> params,PageInfo pageInfo);

    public AccUserBtcDTO getUserBtcDto(String userId);


    public List<IcoAccount> getUserWalletAccount(String userId);
}
