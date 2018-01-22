package com.sdyc.octopus.beans;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <pre>
 * User:        yangxun
 * Date:        2018/1/18  18:14
 * Email:       yangxun@nowledgedata.com.cn
 * Version      V1.0
 * Company:     ����ʶ���˳���Ϣ�Ƽ����޹�˾
 * Discription:
 *
 * Modify:      2018/1/18  18:14
 * Author:
 * </pre>
 */

public class IcoAccount {

    long   seqkey;

    String userId;

    String exchange;

    long batchNum;


    Double btc=0.0;
    Double eth=0.0;
    Double xrp=0.0;
    Double bch=0.0;
    Double ada=0.0;
    Double ltc=0.0;
    Double xem=0.0;
    Double neo=0.0;
    Double xlm=0.0;
    Double iota=0.0;
    Double eos=0.0;
    Double dash=0.0;
    Double trx=0.0;
    Double xmr=0.0;
    Double btg=0.0;
    Double etc=0.0;
    Double icx=0.0;
    Double lsk=0.0;
    Double qtum=0.0;
    Double xrb=0.0;
    Double omg=0.0;
    Double usdt=0.0;

    Date   groupDate;
    Date   createDate;
    Date   updateDate;




    private static String upfs(String name) {
        name = name.substring(0, 1).toUpperCase() + name.substring(1);
        return  name;

    }

    //�������� �����ȡĳ��ico��ֵ
    public Double getIcoValue(String cpl)throws Exception{

        Method method= this.getClass().getDeclaredMethod("get"+upfs(cpl));

       return (Double)method.invoke(this);

    }

    //�������� ��������ĳ��ico��ֵ
    public void setIcoValue(String cpl,Double value)throws Exception{

        Method method= this.getClass().getDeclaredMethod("set"+upfs(cpl),Double.class);

        method.invoke(this,value);

    }


    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public long getBatchNum() {
        return batchNum;
    }

    public void setBatchNum(long batchNum) {
        this.batchNum = batchNum;
    }

    public long getSeqkey() {
        return seqkey;
    }

    public void setSeqkey(long seqkey) {
        this.seqkey = seqkey;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }



    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public Double getBtc() {
        return btc;
    }

    public void setBtc(Double btc) {
        this.btc = btc;
    }

    public Double getEth() {
        return eth;
    }

    public void setEth(Double eth) {
        this.eth = eth;
    }

    public Double getXrp() {
        return xrp;
    }

    public void setXrp(Double xrp) {
        this.xrp = xrp;
    }

    public Double getBch() {
        return bch;
    }

    public void setBch(Double bch) {
        this.bch = bch;
    }

    public Double getAda() {
        return ada;
    }

    public void setAda(Double ada) {
        this.ada = ada;
    }

    public Double getLtc() {
        return ltc;
    }

    public void setLtc(Double ltc) {
        this.ltc = ltc;
    }

    public Double getXem() {
        return xem;
    }

    public void setXem(Double xem) {
        this.xem = xem;
    }

    public Double getNeo() {
        return neo;
    }

    public void setNeo(Double neo) {
        this.neo = neo;
    }

    public Double getXlm() {
        return xlm;
    }

    public void setXlm(Double xlm) {
        this.xlm = xlm;
    }

    public Double getIota() {
        return iota;
    }

    public void setIota(Double iota) {
        this.iota = iota;
    }

    public Double getEos() {
        return eos;
    }

    public void setEos(Double eos) {
        this.eos = eos;
    }

    public Double getDash() {
        return dash;
    }

    public void setDash(Double dash) {
        this.dash = dash;
    }

    public Double getTrx() {
        return trx;
    }

    public void setTrx(Double trx) {
        this.trx = trx;
    }

    public Double getXmr() {
        return xmr;
    }

    public void setXmr(Double xmr) {
        this.xmr = xmr;
    }

    public Double getBtg() {
        return btg;
    }

    public void setBtg(Double btg) {
        this.btg = btg;
    }

    public Double getEtc() {
        return etc;
    }

    public void setEtc(Double etc) {
        this.etc = etc;
    }

    public Double getIcx() {
        return icx;
    }

    public void setIcx(Double icx) {
        this.icx = icx;
    }

    public Double getLsk() {
        return lsk;
    }

    public void setLsk(Double lsk) {
        this.lsk = lsk;
    }

    public Double getQtum() {
        return qtum;
    }

    public void setQtum(Double qtum) {
        this.qtum = qtum;
    }

    public Double getXrb() {
        return xrb;
    }

    public void setXrb(Double xrb) {
        this.xrb = xrb;
    }

    public Double getOmg() {
        return omg;
    }

    public void setOmg(Double omg) {
        this.omg = omg;
    }

    public Double getUsdt() {
        return usdt;
    }

    public void setUsdt(Double usdt) {
        this.usdt = usdt;
    }

    public Date getGroupDate() {
        return groupDate;
    }

    public void setGroupDate(Date groupDate) {
        this.groupDate = groupDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }


    @Override
    public int hashCode() {
        return  (userId+exchange) .hashCode();
    }


    @Override
    public String toString() {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        StringBuffer sb=new StringBuffer()
        .append(userId).append(",")
        .append(exchange)
        .append(",").append(btc)
        .append(",").append(eth)
        .append(",").append(xrp)
        .append(",").append(bch)
        .append(",").append(ada)
        .append(",").append(ltc)
        .append(",").append(xem)
        .append(",").append(neo)
        .append(",").append(xlm)
        .append(",").append(iota)
        .append(",").append(eos)
        .append(",").append(dash)
        .append(",").append(trx)
        .append(",").append(xmr)
        .append(",").append(btg)
        .append(",").append(etc)
        .append(",").append(icx)
        .append(",").append(lsk)
        .append(",").append(qtum)
        .append(",").append(xrb)
        .append(",").append(omg)
        .append(",").append(usdt);

        return sb.toString();
    }


    @Override
    public boolean equals(Object obj) {
        if(obj instanceof IcoAccount){
            IcoAccount obj1=(IcoAccount)obj;
            if( obj1.exchange.equals(this.exchange) && obj1.userId.equals(this.userId)){
                return  true;
            }

        }
        return false;
    }
}
