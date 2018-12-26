package com.sys.gateway.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomersVO {
    private Long id;					// 客户ID
    private String key;					// 邮箱_平台
    private String customerName;		// 客户名
    private String name;				// 姓名
    private String nickName;			// 姓名
    private String country;				// 国家
    private String language;			// 语言
    private String currency;			// 货币
    private String city;				// 城市
    private String stateProvince;		// 州省
    private String address;				// 地址
    private String post;				// 邮编
    private String mobilePhone;			// 手机
    private String telephone;			// 固话
    private String email;				// 电子	邮件
    private Integer hasEmail;			// 电子邮件
    private String facebook;			// Facebook
    private String twitter;				// Twitter
    private String googlePlus; 			// Google+
    private String qq; 					// qq
    private String weixin; 				// weixin
    private String birthday;			// 生日
    private String sex;					// 性别
    private List<Integer> labels = new ArrayList();// 标签
    private String channelType;			// 渠道类型
    private String platformAccount;		//第三方平台账号，用来发平台站内信
    private String symbol;				//第三方平台账号唯一标识
    private Integer orderSum = 0;		// 订单总数
    private Double orderAmount = 0.0;	// 订单总金额
    private Double orderPriceAvg = 0.0;// 平均订单价
    private Integer orderRefundCount = 0;// 退款订单数
    private Double orderRefundPrice = 0.0;// 退款订单金额
    private Integer frequency = 0;		// 购买频次(天)
    private Integer placeOrderSkuSum = 0;// 下单商品总数
    private String platformCustomerService;// 平台客服
    private Integer creator;			// 创建人
    private String firstPlaceOrderDate;	// 第一次下单时间
    private String lastPlaceOrderDate;	// 最后下单时间
    private Integer serviceCount = 0;	// 服务次数
    private String firstServiceDate; 	//第一次服务时间
    private String lastServiceDate; 	//最后一次服务时间
    private String createDate;			// 数据创建时间
    private String updateDate;			// 数据更新时间
    private String systemRemark;		// 系统备注
    // private List<OrderList> orderList;
    private String sku;
    private String skuCategoryId;
    private List<String> skus;
    private List<Integer> skuCategoryIds;
    private List<Integer> brandIds;
    private List<String> aiSkus;
    private List<Integer> aiSkuCategoryIds;
    private List<Integer> aiBrandIds;
    private List<String> favoriteSkus;
    private List<Integer> favoriteSkuCategoryIds;
    private List<Integer> favoriteBrandIds;
    private Integer forbidSalePromotion = 0;// 是否禁止推销
    private String remark;					// 备注
    private Integer customerType; 			// 客户类型
    private Integer customerType2; 			//客户类型二级分类， 如一级红人客户，二级amazon站内红人
    private Integer includeOrder = 0;
    private Integer visitPages = 0;			//访问页面数
    private Integer isRegisterUser = 0;		//否注册用户
    private Map<String,Object> extraData = new HashMap<String,Object>();
    private Integer website;				//站点
    private List<Integer> websites;			//站点
    private Integer activated = 0;			//是否激活 1:激活 0：未激活
    private Integer subscribe;
    private String registerTime;			//注册时间
    private String lastLoginTime;			//最后登陆时间
    private Integer memberLevel;			//
    private Integer point;					//会员积分
    private String firstClickDate;
    private String lastClickDate;
    private String firstOpenDate;
    private String lastOpenDate;
    private Integer isAndroidUser = 0;
    private String androidToken;


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Integer getForbidSalePromotion() {
        return forbidSalePromotion;
    }

    public void setForbidSalePromotion(Integer forbidSalePromotion) {
        this.forbidSalePromotion = forbidSalePromotion;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public List<Integer> getLabels() {
        return labels;
    }

    public void setLabels(List<Integer> labels) {
        this.labels = labels;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
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

    public Integer getServiceCount() {
        return serviceCount==null?0:serviceCount;
    }

    public void setServiceCount(Integer serviceCount) {
        this.serviceCount = serviceCount;
    }

    public Integer getOrderSum() {
        return orderSum;
    }

    public void setOrderSum(Integer orderSum) {
        this.orderSum = orderSum;
    }

    public Double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Double getOrderPriceAvg() {
        return orderPriceAvg;
    }

    public void setOrderPriceAvg(Double orderPriceAvg) {
        this.orderPriceAvg = orderPriceAvg;
    }

    public Integer getOrderRefundCount() {
        return orderRefundCount;
    }

    public void setOrderRefundCount(Integer orderRefundCount) {
        this.orderRefundCount = orderRefundCount;
    }

    public Double getOrderRefundPrice() {
        return orderRefundPrice;
    }

    public void setOrderRefundPrice(Double orderRefundPrice) {
        this.orderRefundPrice = orderRefundPrice;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public Integer getPlaceOrderSkuSum() {
        return placeOrderSkuSum;
    }

    public void setPlaceOrderSkuSum(Integer placeOrderSkuSum) {
        this.placeOrderSkuSum = placeOrderSkuSum;
    }

    public String getPlatformCustomerService() {
        return platformCustomerService;
    }

    public void setPlatformCustomerService(String platformCustomerService) {
        this.platformCustomerService = platformCustomerService;
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

    public String getSystemRemark() {
        return systemRemark;
    }

    public void setSystemRemark(String systemRemark) {
        this.systemRemark = systemRemark;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
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

    /*
     * public List<OrderList> getOrderList() { return orderList; }
     *
     * public void setOrderList(List<OrderList> orderList) { this.orderList = orderList; }
     */

    @Override
    public String toString() {
        return "CrmCustomer [id=" + id + ",key=" + key + ", customerName=" + customerName + ", name=" + name + ", country=" + country + ", language=" + language + ", currency=" + currency + ", city=" + city + ", stateProvince=" + stateProvince + ", address=" + address + ", post=" + post + ", mobilePhone=" + mobilePhone + ", telephone=" + telephone + ", email=" + email + ", facebook=" + facebook + ", twitter=" + twitter + ", googlePlus=" + googlePlus + ", birthday=" + birthday + ", sex=" + sex + ", labels=" + labels + ", channelType=" + channelType + ", serviceCount=" + serviceCount + ", orderSum=" + orderSum + ", orderAmount=" + orderAmount + ", orderPriceAvg=" + orderPriceAvg + ", orderRefundCount=" + orderRefundCount + ", orderRefundPrice=" + orderRefundPrice + ", frequency=" + frequency + ", placeOrderSkuSum=" + placeOrderSkuSum + ", platformCustomerService=" + platformCustomerService + ", firstPlaceOrderDate=" + firstPlaceOrderDate + ", lastPlaceOrderDate=" + lastPlaceOrderDate
                + ", createDate=" + createDate + ", updateDate=" + updateDate + ", systemRemark=" + systemRemark + ", " + ", forbidSalePromotion=" + forbidSalePromotion + ", remark=" + remark + "]";
    }

    public Integer getCustomerType() {
        return customerType;
    }

    public void setCustomerType(Integer customerType) {
        this.customerType = customerType;
    }

    public Integer getIncludeOrder() {
        return includeOrder;
    }

    public void setIncludeOrder(Integer includeOrder) {
        this.includeOrder = includeOrder;
    }

    public Integer getVisitPages() {
        return visitPages;
    }

    public void setVisitPages(Integer visitPages) {
        this.visitPages = visitPages;
    }

    public Integer getIsRegisterUser() {
        return isRegisterUser;
    }

    public void setIsRegisterUser(Integer isRegisterUser) {
        this.isRegisterUser = isRegisterUser;
    }

    public String getSkuCategoryId() {
        return skuCategoryId;
    }

    public void setSkuCategoryId(String skuCategoryId) {
        this.skuCategoryId = skuCategoryId;
    }

    public Map<String, Object> getExtraData() {
        return extraData;
    }

    public void setExtraData(Map<String, Object> extraData) {
        this.extraData = extraData;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public Integer getCustomerType2() {
        return customerType2;
    }

    public void setCustomerType2(Integer customerType2) {
        this.customerType2 = customerType2;
    }

    public List<String> getSkus() {
        return skus;
    }

    public void setSkus(List<String> skus) {
        this.skus = skus;
    }

    public List<Integer> getSkuCategoryIds() {
        return skuCategoryIds;
    }

    public void setSkuCategoryIds(List<Integer> skuCategoryIds) {
        this.skuCategoryIds = skuCategoryIds;
    }

    public String getFirstServiceDate() {
        return firstServiceDate;
    }

    public void setFirstServiceDate(String firstServiceDate) {
        this.firstServiceDate = firstServiceDate;
    }

    public String getLastServiceDate() {
        return lastServiceDate;
    }

    public void setLastServiceDate(String lastServiceDate) {
        this.lastServiceDate = lastServiceDate;
    }

    public List<Integer> getBrandIds() {
        return brandIds;
    }

    public void setBrandIds(List<Integer> brandIds) {
        this.brandIds = brandIds;
    }

    public Integer getWebsite() {
        return website;
    }

    public void setWebsite(Integer website) {
        this.website = website;
    }

    public Integer getActivated() {
        return activated;
    }

    public void setActivated(Integer activated) {
        this.activated = activated;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Integer getMemberLevel() {
        return memberLevel;
    }

    public void setMemberLevel(Integer memberLevel) {
        this.memberLevel = memberLevel;
    }

    public String getFirstClickDate() {
        return firstClickDate;
    }

    public void setFirstClickDate(String firstClickDate) {
        this.firstClickDate = firstClickDate;
    }

    public String getLastClickDate() {
        return lastClickDate;
    }

    public void setLastClickDate(String lastClickDate) {
        this.lastClickDate = lastClickDate;
    }

    public String getFirstOpenDate() {
        return firstOpenDate;
    }

    public void setFirstOpenDate(String firstOpenDate) {
        this.firstOpenDate = firstOpenDate;
    }

    public String getLastOpenDate() {
        return lastOpenDate;
    }

    public void setLastOpenDate(String lastOpenDate) {
        this.lastOpenDate = lastOpenDate;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public List<Integer> getWebsites() {
        return websites;
    }

    public void setWebsites(List<Integer> websites) {
        this.websites = websites;
    }

    public Integer getHasEmail() {
        return hasEmail;
    }

    public void setHasEmail(Integer hasEmail) {
        this.hasEmail = hasEmail;
    }

    public Integer getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(Integer subscribe) {
        this.subscribe = subscribe;
    }

    public String getAndroidToken() {
        return androidToken;
    }

    public void setAndroidToken(String androidToken) {
        this.androidToken = androidToken;
    }

    public Integer getIsAndroidUser() {
        return isAndroidUser;
    }

    public void setIsAndroidUser(Integer isAndroidUser) {
        this.isAndroidUser = isAndroidUser;
    }

    public List<String> getAiSkus() {
        return aiSkus;
    }

    public void setAiSkus(List<String> aiSkus) {
        this.aiSkus = aiSkus;
    }

    public List<Integer> getAiSkuCategoryIds() {
        return aiSkuCategoryIds;
    }

    public void setAiSkuCategoryIds(List<Integer> aiSkuCategoryIds) {
        this.aiSkuCategoryIds = aiSkuCategoryIds;
    }

    public List<Integer> getAiBrandIds() {
        return aiBrandIds;
    }

    public void setAiBrandIds(List<Integer> aiBrandIds) {
        this.aiBrandIds = aiBrandIds;
    }

    public List<String> getFavoriteSkus() {
        return favoriteSkus;
    }

    public void setFavoriteSkus(List<String> favoriteSkus) {
        this.favoriteSkus = favoriteSkus;
    }

    public List<Integer> getFavoriteSkuCategoryIds() {
        return favoriteSkuCategoryIds;
    }

    public void setFavoriteSkuCategoryIds(List<Integer> favoriteSkuCategoryIds) {
        this.favoriteSkuCategoryIds = favoriteSkuCategoryIds;
    }

    public List<Integer> getFavoriteBrandIds() {
        return favoriteBrandIds;
    }

    public void setFavoriteBrandIds(List<Integer> favoriteBrandIds) {
        this.favoriteBrandIds = favoriteBrandIds;
    }
}
