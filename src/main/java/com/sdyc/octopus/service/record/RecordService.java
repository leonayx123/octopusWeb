package com.sdyc.octopus.service.record;

import com.sdyc.octopus.beans.IcoAccount;
import com.sdyc.octopus.dto.AccUserBtcDTO;
import com.sdyc.octopus.dto.RecordBtcAddDTO;
import com.sdyc.octopus.dto.RecordTradeTurnoverDTO;
import com.sdyc.octopus.utils.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by yangxun on 2018-01-23.
 */
public interface RecordService {

    public List<RecordTradeTurnoverDTO> getTradeTurnover(String userId,Map<String,Object> params,PageInfo pageInfo);

    public List<RecordBtcAddDTO> getBtcAdd(String userId,Map<String,Object> params,PageInfo pageInfo);

    public AccUserBtcDTO getUserBtcDto(String userId);


    public List<IcoAccount> getUserWalletAccount(String userId);
}
