package com.sdyc.octopus.service.record.impl;

import com.sdyc.octopus.beans.IcoAccount;
import com.sdyc.octopus.comm.Coin;
import com.sdyc.octopus.comm.Exchange;
import com.sdyc.octopus.dto.AccCoinBalanceDTO;
import com.sdyc.octopus.dto.AccUserBtcDTO;
import com.sdyc.octopus.dto.RecordBtcAddDTO;
import com.sdyc.octopus.service.record.RecordService;
import com.sdyc.octopus.utils.DataTablesPagination;
import com.sdyc.octopus.utils.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by yangxun on 2018-01-23.
 */
@Service
public class RecordServiceImpl implements RecordService {

    @Resource
    JdbcTemplate jdbcTemplate;



    @Override
    public DataTablesPagination getTradeTurnover(String userId, Integer status, Date bDate, Date eDate, Exchange hEx, Exchange lEx, Coin coin, DataTablesPagination page) {
        Assert.notNull(userId,"用户不能为空");

        StringBuffer sql=new StringBuffer(" from record_trade_turnover where 1=1");
        ArrayList<Object> args=new ArrayList<>();
        if(StringUtils.isNotBlank(userId)){
            sql.append(" AND userId like ?");
            args.add("%"+userId+"%");
        }

        //状态
        if(null!=status){
            sql.append(" AND status=?");
            args.add(status);
        }
        //时间
        if(null!=bDate){
            sql.append(" AND time>=?");
            args.add(bDate);
        }
        if(null!=eDate){
            sql.append(" AND time<=?");
            args.add(eDate);
        }
        //交易所
        if(null!=hEx){
            sql.append(" AND higherEx=?");
            args.add(hEx.toString());
        }
        if(null!=lEx){
            sql.append(" AND lowerEx=?");
            args.add(lEx.toString());
        }
        //币种
        if(null!=coin){
            sql.append(" AND coinId=?");
            args.add(coin.toString());
        }
        int count =jdbcTemplate.queryForObject("SELECT count(0)"+sql, Integer.class,args.toArray());
        page.setiTotalRecords(count);

        sql.append(" order by time desc limit ?,?");
        args.add(page.getStart());
        args.add(page.getLength());
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("SELECT * " + sql, args.toArray());
        page.setData(maps);
        return page;
    }

    @Override
    public List<RecordBtcAddDTO> getBtcAdd(String userId, Map<String, Object> params, PageInfo pageInfo) {
        StringBuffer sql=new StringBuffer("select * from from record_btc_add where userId=?");
        ArrayList<Object> args=new ArrayList<>();
        args.add(userId);
        if(params!=null&&params.size()>0){
            Iterator<String> it= params.keySet().iterator();
            while(it.hasNext()){
                String key=it.next();
                sql.append(" and ").append(key).append(" = ? ");
                Object value=params.get(key);
                args.add(value);
            }
        }
        sql.append(" order by time desc limit ")
                .append(pageInfo.getStart()).append(",").append(pageInfo.getRowPerPage());

        return jdbcTemplate.query(sql.toString(),args.toArray(),new BeanPropertyRowMapper<RecordBtcAddDTO>(RecordBtcAddDTO.class)) ;
    }

    @Override
    public AccUserBtcDTO getUserBtcDto(String userId) {
        String sql="select * from acc_user_btc where userId=? ";
        List<AccUserBtcDTO> rss= jdbcTemplate.query(sql,new Object[]{userId},new BeanPropertyRowMapper<AccUserBtcDTO>(AccUserBtcDTO.class));
        if(rss!=null&&rss.size()>0){
            return  rss.get(0);
        }
        return null;
    }

    @Override
    public List<IcoAccount> getUserWalletAccount(String userId) {
        HashMap<String,IcoAccount> bmap=new HashMap<String, IcoAccount>();
        String sql= "select * from acc_coin_balance where userId=? ";
        List<AccCoinBalanceDTO> bls=  jdbcTemplate.query(sql, new Object[]{userId},new BeanPropertyRowMapper<AccCoinBalanceDTO>(AccCoinBalanceDTO.class));

        for(AccCoinBalanceDTO acc:bls){
            IcoAccount  icoAccount=  bmap.get(acc.getExchangeId());
            if(icoAccount==null){
                icoAccount=new IcoAccount();
                icoAccount.setUserId(userId);
                icoAccount.setExchange(acc.getExchangeId());

                bmap.put(acc.getExchangeId(),icoAccount);
            }

            try {
                icoAccount.setIcoValue(acc.getCoinId(),acc.getCoinAmt().doubleValue());

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        Iterator<String> it= bmap.keySet().iterator();

        List<IcoAccount>  res=new ArrayList<IcoAccount>();
        while (it.hasNext()){
            String key=it.next();

            res.add(bmap.get(key));
        }

        return  res;
    }
}
