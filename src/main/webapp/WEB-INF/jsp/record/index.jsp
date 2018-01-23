<%--
  Created by IntelliJ IDEA.
  User: yangxun
  Date: 2018-01-23
  Time: 4:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <%String context=request.getContextPath(); %>
    <title></title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/bootstrap-3.3.0-dist/dist/css/bootstrap.css">
  <link rel="stylesheet" type="text/css" href="http://cdn.datatables.net/1.10.15/css/jquery.dataTables.css">
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/vue.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap-3.3.0-dist/dist/js/bootstrap.js"></script>


  <script type="text/javascript" charset="utf8" src="http://cdn.datatables.net/1.10.15/js/jquery.dataTables.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/DataTables/js/jquery.dataTables_bootstrap.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/DataTables/js/dataTables.defaults.js"></script>

</head>
<body class="container">
<div id="contain" style="padding-bottom: 10px">
  <ul class="nav nav-tabs">
    <li :class="{'active':activeItem=='exchangeRecode'}" v-on:click="slctItem('exchangeRecode')"><a href="#">交易记录</a></li>
    <li :class="{'active':activeItem=='exchangeRecode1'}" v-on:click="slctItem('exchangeRecode1')"><a href="#">SVN</a></li>
    <li :class="{'active':activeItem=='exchangeRecode2'}" v-on:click="slctItem('exchangeRecode2')"><a href="#">iOS</a></li>
    <li :class="{'active':activeItem=='exchangeRecode3'}" v-on:click="slctItem('exchangeRecode3')"><a href="#">VB.Net</a></li>
  </ul>
  <div class="form-inline pull-right" style="padding: 10px">
    <label for="name">交易所（高）：</label>
    <select class="form-control" v-on:change="getTrades()" v-model="slctHEx">
      <option value="binance">binance</option>
      <option value="gateIo">gateIo</option>
      <option value="huobipro">huobipro</option>
      <option value="okex">okex</option>
      <option value="zb">zb</option>
    </select>
    <label for="name">交易所（低）：</label>
    <select class="form-control" v-on:change="getTrades()" v-model="slctLEx">
      <option value="binance">binance</option>
      <option value="gateIo">gateIo</option>
      <option value="huobipro">huobipro</option>
      <option value="okex">okex</option>
      <option value="zb">zb</option>
    </select>
    <label for="name">状态：</label>
    <select class="form-control" v-on:change="getTrades()" v-model="slctStatus">
      <option value="0">price diff too small</option>
      <option value="1">successful</option>
      <option value="2">tradable value too small</option>
      <option value="3">not enough bcoin on lower</option>
      <option value="4">sell failed</option>
      <option value="5">buy failed</option>
    </select>
    <br>
    <label for="name">时间：</label>
    <input type="text" class="form-control" placeholder="开始时间">~ <input type="text" class="form-control" placeholder="结束时间">
  </div>
</div>
<table class="table table-striped table-bordered table-hover" id="accessRecordList">
  <thead><tr>
    <td>userId</td>
    <td>coinId</td>
    <td>higherEx</td>
    <td>highPrice</td>
    <td>higherBidVal1</td>
    <td>higherBidVal2</td>
    <td>higherBidVal3</td>

    <td>lowerEx</td>
    <td>lowerPrice</td>
    <td>lowerAskVal1</td>
    <td>lowerAskVal2</td>
    <td>lowerAskVal3</td>

    <td>priceDiff</td>
    <td>status</td>
    <td>msg</td>

    <td>tradeValueBuy</td>
    <td>tradeValueMargin</td>
    <td>tradeValueMarginPct</td>
    <td>tradeValueSell</td>
    <td>time</td>
    <%--<td>操作</td>--%>
  </tr>
  </thead>
</table>

<script>
    let vue=new Vue({
        el:"#contain",
        data:{
            nowSearch:"trades",
            userId:"1mil10coins",
            trades:null,
            btc:null,
            wallets:null,
            adds:null,
            activeItem:"exchangeRecode",
            slctHEx:null,
            slctLEx:null,
            slctStatus:null,
            table:null
        },
        created:function(){
           this.getTrades();
        },
        methods:{
            slctItem:function (item) {
                this.activeItem=item;
            },
            //交易记录
           getTrades:function(){
             _this=this;
             if(this.table){
                 this.table.ajax.reload();
                 return
             }
               var url="${pageContext.request.contextPath}/record/trade.do";

               this.table=$("#accessRecordList").DataTable({
                   "ajax":{
                       url:url,
                       data:function(d){
                           d.status=_this.slctStatus;
                           d.hEx=_this.slctHEx;
                           d.lEx=_this.slctLEx;
                       }
                   } ,
                   serverSide: true,
                   columns: [
                       {"data": "userId"},
                       {"data": "coinId"},
                       {"data": "higherEx"},
                       {"data": "highPrice"},
                       {"data": "higherBidVal1"},
                       {"data": "higherBidVal2"},
                       {"data": "higherBidVal3"},

                       {"data": "lowerEx"},
                       {"data": "lowerPrice"},
                       {"data": "lowerAskVal1"},
                       {"data": "lowerAskVal2"},
                       {"data": "lowerAskVal3"},

                       {"data": "priceDiff"},
                       {"data": "status"},
                       {"data": "msg"},

                       {"data": "tradeValueBuy"},
                       {"data": "tradeValueMargin"},
                       {"data": "tradeValueMarginPct"},
                       {"data": "tradeValueSell"},
                       {"data": "time"}
                   ],
                   columnDefs: [
                       {
                           targets: 19,
                           render: function (a, b, c, d) {
                               return new Date(a).toLocaleString();
                           }
                       }

                   ],

               });
           },
           getBtc:function(userId){
             _this=this;
             $.get("btc.do",{userId:this.userId}).success(function(json){
               _this.adds=json.adds;
               _this.btc=json.btc;
             });
           },
           getWallet: function () {
             _this=this;
             $.get("wallet.do",{userId:this.userId}).success(function(json){
               _this.wallets=json.wallets;
             });
           }
        }
    });

</script>
</body>
</html>
