package com.sys.gateway.vo;

public class CustomerDB {

    //主键ID
    private String id;

    //基础信息
    private String customerId; //客户ID
    private String customerName;//客户名称
    private String name;//姓名
    private String nickName;//昵称
    private String sex;//性别
    private String country;//国家
    private String stateProvince;//州省
    private String city;//城市
    private String language;//语言
    private String currency;//货币
    private String address;//地址
    private String post;//邮编
    private String mobilePhone;//手机
    private String telephone;//固定电话
    private String email;//邮箱
    private String facebook;//Facebook
    private String twitter;//Twitter
    private String googlePlus;//Google+
    private String birthday;//生日

    //订单信息
    private String orderSumAmount;//订单总数/总金额
    private String orderPriceAvg;//平均订单价
    private String orderRefundCountPrice;//退款订单数/金额
    private String frequency;//购买频率(天)
    private String placeOrderSkuSum;//下单商品总数
    private String serviceCount;//营销次数
    private String sku;//SKU
    private String skuCategoryId;//商品类别
    private String platformAccount;//最近购买店铺标识
    private String symbol;//最近购买店铺标识

    //其他信息
    private String customerType="订单客户";//客户类型
    private String channelType;//渠道类型
    private String forbidSalePromotion;//推销状态

    //时间信息
    private String firstPlaceOrderDate;//第一次下单时间
    private String lastPlaceOrderDate;//最后一次下单时间
    private String createDate;//创建时间
    private String updateDate;//更新时间

    //标签
    private String labels;

    public CustomerDB(){}

    public CustomerDB(CustomersVO vo){
        this.customerId = vo.getId()+"";
        this.customerName = vo.getCustomerName();
        this.name = vo.getName();
        this.nickName = vo.getNickName();
        this.sex = vo.getSex();
        this.country = vo.getCountry();
        this.stateProvince = vo.getStateProvince();
        this.city = vo.getCity();
        this.language = vo.getLanguage();
        this.currency = vo.getCurrency();
        this.address = vo.getAddress();
        this.post = vo.getPost();
        this.mobilePhone = vo.getMobilePhone();
        this.telephone = vo.getTelephone();
        this.facebook = vo.getFacebook();
        this.twitter = vo.getTwitter();
        this.googlePlus = vo.getGooglePlus();
        this.birthday = vo.getBirthday();

        this.orderSumAmount = vo.getOrderSum() + "/" + vo.getOrderAmount();
        this.orderPriceAvg = vo.getOrderPriceAvg()+"";
        this.orderRefundCountPrice = vo.getOrderRefundCount() + "/" + vo.getOrderRefundPrice();
        this.frequency = vo.getFrequency()+"";
        this.placeOrderSkuSum = vo.getPlaceOrderSkuSum()+"";
        this.serviceCount = vo.getServiceCount()+"";
        this.sku = vo.getSku();
        this.skuCategoryId = vo.getSkuCategoryId();
        this.platformAccount = vo.getPlatformAccount();
        this.symbol = vo.getSymbol();

        this.channelType = vo.getChannelType();
        this.forbidSalePromotion = vo.getForbidSalePromotion() == 1? "禁止" : "允许";

        this.firstPlaceOrderDate = vo.getFirstPlaceOrderDate();
        this.lastPlaceOrderDate = vo.getLastPlaceOrderDate();
        this.createDate = vo.getCreateDate();
        this.updateDate = vo.getUpdateDate();

        this.labels = "";
    }

    public String getLabels() {
        return labels;
    }

    public void setLabels(String labels) {
        this.labels = labels;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getGooglePlus() {
        return googlePlus;
    }

    public void setGooglePlus(String googlePlus) {
        this.googlePlus = googlePlus;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getOrderSumAmount() {
        return orderSumAmount;
    }

    public void setOrderSumAmount(String orderSumAmount) {
        this.orderSumAmount = orderSumAmount;
    }

    public String getOrderPriceAvg() {
        return orderPriceAvg;
    }

    public void setOrderPriceAvg(String orderPriceAvg) {
        this.orderPriceAvg = orderPriceAvg;
    }

    public String getOrderRefundCountPrice() {
        return orderRefundCountPrice;
    }

    public void setOrderRefundCountPrice(String orderRefundCountPrice) {
        this.orderRefundCountPrice = orderRefundCountPrice;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getPlaceOrderSkuSum() {
        return placeOrderSkuSum;
    }

    public void setPlaceOrderSkuSum(String placeOrderSkuSum) {
        this.placeOrderSkuSum = placeOrderSkuSum;
    }

    public String getServiceCount() {
        return serviceCount;
    }

    public void setServiceCount(String serviceCount) {
        this.serviceCount = serviceCount;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getSkuCategoryId() {
        return skuCategoryId;
    }

    public void setSkuCategoryId(String skuCategoryId) {
        this.skuCategoryId = skuCategoryId;
    }

    public String getPlatformAccount() {
        return platformAccount;
    }

    public void setPlatformAccount(String platformAccount) {
        this.platformAccount = platformAccount;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public String getForbidSalePromotion() {
        return forbidSalePromotion;
    }

    public void setForbidSalePromotion(String forbidSalePromotion) {
        this.forbidSalePromotion = forbidSalePromotion;
    }

    public String getFirstPlaceOrderDate() {
        return firstPlaceOrderDate;
    }

    public void setFirstPlaceOrderDate(String firstPlaceOrderDate) {
        this.firstPlaceOrderDate = firstPlaceOrderDate;
    }

    public String getLastPlaceOrderDate() {
        return lastPlaceOrderDate;
    }

    public void setLastPlaceOrderDate(String lastPlaceOrderDate) {
        this.lastPlaceOrderDate = lastPlaceOrderDate;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }
}
