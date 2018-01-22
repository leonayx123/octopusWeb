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
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/iview.css">
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/vue.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/iview.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
</head>
<body>
<div id="contain">
  <template>
    <Tabs value="name1">
      <TabPane on-click="getTrades()" label="标签一" name="name1">标签一的内容</TabPane>
      <TabPane label="标签二" name="name2">标签二的内容</TabPane>
      <TabPane label="标签三" name="name3">标签三的内容</TabPane>
    </Tabs>
  </template>
</div>


<script>
    let vue=new Vue({
        el:"#contain",
        data:{
            nowSearch:"trades",
            userId:"1mil10coins",
            trades:null,
            btc:null,
            wallets:null,
            adds:null
        },
        methods:{
           getTrades:function(){
             _this=this;
             $.get("trade.do",{userId:this.userId,status:status}).success(function(json){
               _this.trades=json.trades;
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
