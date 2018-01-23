package com.sdyc.octopus.service.userBtc.impl;

import com.sdyc.octopus.service.userBtc.AccUserBtcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Company
 * @Discription
 * @Author houfengli
 * @CreateDate 2018/1/23 19:39
 * @Version 1.0
 */
@Service
public class AccUserBtcServiceImpl implements AccUserBtcService {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public List<Map<String, Object>> findAll() {
        String sql="SELECT *,CONVERT(addRatio*100,decimal(10,2))  ratio FROM acc_user_btc ";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }
}
