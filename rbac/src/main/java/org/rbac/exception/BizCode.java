package org.rbac.exception;

/**
 * 业务代码
 * 业务错误代码按模块分配，由4位数字组成，格式为0000～9999。
 * 前两位数字为模块代码，后两位数字为错误码。
 * 0000 代表成功
 * 9999 代表服务调用失败
 * 供应商管理模块 10**
 * 产品管理模块 11**
 * 代理酬金模块 12**
 * 13**
 * 文件操作模块 14**
 * 通用模块 99**
 * 如此类推...
 *
 * @author xty
 * Created by xty on 2021/3/28.
 * @since 1.0
 */
public enum BizCode {

    OK(0000, "成功"),
    SIGN_ERROR(0001, "sign不正确"),
    CARD_NO_EXIST(0002, "卡号不正确"),
    CLOSE_GPRS_FAIL(0003, "GPRS开启失败"),
    OPEN_GPRS_FAIL(0004, "GPRS停用失败"),

    URL_NOT_FOUND(404, "请求url不存在"),
    CHECK_FAIL(0001, "校验不通过"),
    /**
     * session模块
     */
    SESSION_ILLEGAL(401, "非法的Session"),
    SESSION_INVALID(401, "登录已过期"),

    /**
     * 菜单模块
     */
    MENU_LIST_ERROR(402, "获取失败"),

    /**
     * 通用模块 99**
     */
    RECORD_NOT_EXISTS(9900, "记录不存在"),
    VALIDATE_ERROR(9901, "参数校验错误!"),
    SESSION_CHANNEL_INFO_ERROR(9902, "会话获取渠道信息失败"),
    SESSION_INFO_NULL_ERROR(9903, "获取不到登录信息"),
    PARAM_ERROR(9904, "参数错误!"),
    FILE_LIMIT_ERROR(9905, "导入行数超过文件限制!"),
    REFUND_APPLY_ERROR(9906, "退款申请失败"),
    ENABLE_STATE_SAME(9907, "状态相同，不能修改"),
    BUSINESS_NOT_SUPPORT(9908, "业务不支持"),

    ERROR(9999, "内部错误"),

    /**
     * 供应商管理模块 10**
     */
    RECORD_ID_NOT_EXISTS(1001, "查询id为空"),
    RECORD_NAME_EXISTS(1002, "名称相同"),
    RECORD_PARAM_ERROR(1003, "参数错误"),
    RECORD_TYPE_ERROR(1004, "参数类型错误"),
    RECORD_IS_NULL(1005, "内容不能为空"),
    OPERATOR_REPEATE(1006, "不能重复操作"),
    RECORD_REPEATE(1007, "记录重复"),

    /**
     * 接口管理模块 11**
     */
    INTERFACE_DICT_ID_NOT_EXISTS(1100, "接口字典字段interfaceDictId缺失"),
    INTERFACE_DICT_CONTENT_NAME_EXISTS(1101, "名称存在相同"),
    INTERFACE_PARAM_EMPTY(1102, "参数为空"),
    INTERFACE_INTERFACE_SERVER_ID_EMPTY(1103, "interfaceServerId为空"),
    INTERFACE_CALL_METHOD_EMPTY(1104, "callMethod为空"),
    INTERFACE_API_CALL_CLASS_EMPTY(1105, "apiCallClass为空"),
    INTERFACE_API_CLASS_INSTANCE_EMPTY(1106, "获取实例失败,请配置正确的接口调用类"),
    INTERFACE_INTERFACE_PARAM_CONFIG_ID_EMPTY(1107, "interfaceParamConfigId不能为空"),
    INTERFACE_CONDITION_REPEATE(1108, "基础规则存在相同条件"),
    INTERFACE_CONDITION_ERROR(1109, "基础规则存在相同条件"),

    /**
     * 代理酬金
     */
    AGENT_NAME_EXISTS(1200, "代理名称已存在"),
    AGENT_CODE_EXISTS(1201, "代理ID已存在"),
    AGENT_CONF_EXISTS(1202, "代理配置已存在"),
    AGENT_CONF_NOT_EXISTS(1203, "代理商配置记录不存在"),
    AGENT_NOT_EXISTS(1204, "代理商不存在"),
    AGENT_DISCOUNT_NOT_EXISTS(1205, "酬金策略id不存在"),
    PRODUCT_PACKAGE_NOT_EXISTS(1206, "产品套餐不存在"),
    AGENT_CODE_ERROR(1207, "酬金编码不合法"),
    AGENT_DISCOUNT_CODE_ERROR(1208, "酬金策略编码不合法"),
    AGENT_DISCOUNT_STATE_UNABLE(1209, "禁止对禁用状态的酬金策略进行禁用"),
    AGENT_DISCOUNT_STATE_ABLE(1210, "禁止对启用状态的酬金策略进行启用"),
    AGENT_DISCOUNT_CODE_EXISTS(1211, "酬金策略编码已存在"),

    /**
     * 文件操作模块 14**
     */
    UPLOAD_FILE_HAS_ERROR(1400, "上传文件存在错误"),
    FILE_IO_ERROR(1401, "文件IO操作异常"),
    CACHE_FILE_ERROR(1402, "缓存文件异常"),
    SAVE_EXCEL_DATA_ERROR(1403, "保存Excel数据异常"),
    ANALYSE_EXCEL_DATA_ERROR(1404, "解析Excel数据异常"),
    FILE_NOT_EXISTS(1405, "文件不存在"),
    FILE_IS_EMPTY(1406, "文件数据为空"),
    DATA_OVER_SIZE(1407, "文件数据超过10万"),
    EXPORT_KEY_NOT_EXIST(1408, "导出任务类型不存在"),
    ROWS_UNREASONABLE(1409, "文件切分行数应在10万到20万之间"),
    ROWS_TOO_SMALL(1410, "切分文件行数不应太小"),
    SIZE_EXCEEDS_THE_MAXIMUM(1411, "超出分页大小限制"),
    SIZE_TOO_SMALL(1412, "分页不应太小"),
    EXPORT_KEY_REPEAT(1413, "导出枚举key重复，请检查冲突"),
    FILE_SIZE_LIMIT_EXCEEDED(1414, "上传文件大小超出限制"),

    /**
     * 采购策略模块 15**
     */
    PURCHASE_DISCOUNT_REPEAT(1500, "非月套餐产品同一供应商只能配置一个折扣"),
    OTHER_USER_AUDIT_NOT_PASSED(1501, "存在未审核通过的其他用户的编辑记录"),
    PURCHASE_DISCOUNT_NOT_EXISTS(1502, "采购折扣不存在"),
    PURCHASE_DISCOUNT_STANDARD_NOT_PASSED(1503, "该策略的套餐标准价已失效,不可编辑"),
    PURCHASE_DISCOUNT_STATE_UNABLE(1504, "禁止对禁用状态的采购策略进行禁用"),
    PURCHASE_DISCOUNT_STATE_ABLE(1505, "禁止对启用状态的采购策略进行启用"),

    /**
     * 产品模块 16**
     */
    PRODUCT_REPEAT(1600, "产品组重复"),
    PRODUCT_MANAGE_UNAVAILABLE(1601, "当前产品归属产品组不可用"),
    PRODUCT_EXISTS(1602, "产品已存在"),
    PRODUCT_NOT_EXISTS(1603, "产品不存在"),
    PRODUCT_IS_BOUND(1604, "产品已被卡绑定"),
    PRODUCT_STATE_UNABLE(1605, "禁止对禁用状态的产品进行禁用"),
    PRODUCT_STATE_ABLE(1606, "禁止对启用状态的产品进行启用"),
    PRODUCT_PACKAGE_CONFIG_NOT_EXISTS(1607, "套餐不存在"),
    PRODUCT_NAME_NOT_EXISTS(1608, "没有该产品名称"),
    PRODUCT_VERSION_NOT_EXISTS(1609, "没有该产品版本"),
    PRODUCT_EXPIRY_DATE_NOT_EXISTS(1610, "没有该有效期"),
    PRODUCT_PACKAGE_CONFIG_STATE_UNABLE(1611, "禁止对禁用状态的产品套餐配置进行禁用"),
    PRODUCT_PACKAGE_CONFIG_STATE_ABLE(1612, "禁止对启用状态的产品套餐配置进行启用"),

    /**
     * 供应商管理模块 17**
     */
    SUPPLIER_NOT_EXISTS(1700, "供应商不存在"),
    SUPPLIER_NAME_EXISTS(1701, "供应商名称已存在"),

    /**
     * 审核模块 18*
     */
    AUDIT_FLECT_ERROR(1800, "操作出错"),
    AUDIT_APPROVED_ERROR(1801, "审批通过操作出错"),
    AUDIT_FLOW_NAME_EXIST(1802, "审批流程名已存在"),
    AUDIT_CANNOT_MODIFY(1803, "存在非本人提交的待审核记录，操作失败"),
    AUDIT_CONFIG_ERROR(1804, "修改审核配置出错"),
    AUDIT_TYPE_ID_NO_EXIST(1805, "类型ID不存在"),
    AUDIT_USER_NO_EXIST(1806, "审批人不存在"),

    /**
     * 出库模块 19*
     */
    INVENTORY_EXPORT_ERROR(1900, "出库错误"),
    INVENTORY_EXPORT_OVER_COUNT(1901, "出库数量大于10万"),
    INVENTORY_EXPORT_REPEAT_ERROR(1902, "卡号或者iccid重复,请检查模板"),
    INVENTORY_EXPORT_ZERO(1903, "出库数量为0"),

    /**
     * 客户管理模块 20**
     */
    CHANNEL_NOT_EXISTS(2000, "子客户不存在"),
    CHANNEL_NAME_EXISTS(2001, "子客户名称已存在"),
    CHANNEL_CALLBACK_URL_CANT_BE_NULL(2005, "需要回调时，回调地址不能为空"),
    CHANNEL_SMS_URL_CANT_BE_NULL(2006, "需要短信提醒时，短信接收地址不能为空"),
    CHANNEL_LEVEL_ERROR(2007, "没有该客户等级"),
    CHANNEL_APP_FIELD_CANT_BE_NULL(2008, "子客户的应用领域不能为空"),
    CHANNEL_SALES_MANAGER_CANT_BE_NULL(2009, "销售经理不能为空"),
    PARENT_CHANNEL_NOT_EXISTS(2010, "父客户不存在"),
    PARENT_CHANNEL_NOT_ENOUGH_AMOUNT(2011, "父客户金额不足"),
    CHANNEL_STATE_NOT_ALLOW(2012, "客户已禁用，子客户不能启用"),

    /**
     * 入库 21**
     */
    RE_INVENTORY_CHECK_ERROR(2100, "重新入库校验失败"),
    RE_INVENTORY_DATA_ZERO(2101, "卡数据为空"),
    RE_INVENTORY_OVER_COUNT(2102, "卡数据数量大于10万"),
    RE_INVENTORY_IN_ERROR(2103, "重新入库办理阶段失败"),
    INVENTORY_IMPORT_DATA_EMPTY_ERROR(2004, "数据结果集为空"),
    INVENTORY_IMPORT_CARD_REPEATE_ERROR(2005, "卡号或者sim卡号重复，请检查模板"),
    PREPAY_DEADLINE_ERROR(2006, "预付期限有误"),
    SMS_PACKAGE_ID_EMPTY_ERROR(2007, "短信套餐不能为空"),
    SMS_PURCHASE_DISCOUNT_EMPTY_ERROR(2008, "短信采购折扣不能为空"),
    RE_EXPORT_OVER_COUNT(2009, "入库数量大于10万"),

    /**
     * 套餐变更 22**
     */
    PACKAGE_CHANGE_CHANNEL_PRODUCT_CONFIG_NOT_EXIST_ERROR(2200, "产品套餐配置不存在"),
    PACKAGE_CHANGE_PARENT_CHANNEL_PRODUCT_CONFIG_NOT_EXIST_ERROR(2201, "父客户产品套餐配置不存在"),
    PACKAGE_CHANGE_PARENT_CHANNEL_PRODUCT_CONFIG_EXIST_MUTCH_ERROR(2202, "父客户产品套餐配置存在多个"),
    PACKAGE_CHANGE_PACKAGE_NOT_ALL_NULL(2203, "运营商套餐和客户套餐不能同时为空"),
    PACKAGE_CHANGE_CARD_REPEATE(2204, "卡号或者sim卡号重复"),
    PACKAGE_CHANGE_CHANNEL_PRODUCT_DISCOUNT_NOT_EXIST(2205, "客户折扣不存在"),
    PACKAGE_CHANGE_CHANNEL_PRODUCT_DISCOUNT_SALE_NOT_EXIST(2206, "客户销售折扣或价格为空"),

    /**
     * 充值办理 23**
     */
    UNSUPPORTED_TYPE(2300, "卡信息不支持该类型"),
    RECHARGE_EXPORT_ZERO(2301, "充值数量为0"),
    RECHARGE_OVER_COUNT(2302, "卡数据数量大于10万"),
    RECHARGE_ERROR(2303, "充值办理错误"),

    /**
     * 共享池/客户共享池入池/退池/变更池 24**
     */
    POOL_EXPORT_ZERO(2401, "卡数量为0"),
    POOL_OVER_COUNT(2402, "卡数据数量大于10万"),
    POOL_NAME_EXIST(2403, "该共享池名称已存在"),
    POOL_NOT_EXISTS(2404, "共享池不存在"),
    CUST_POOL_NAME_EXIST(2405, "该客户共享池名称已存在"),

    FLOW_PACKAGE_IN_DIFFERENT(2406, "卡待入共享池记录的流量池套餐跟变更套餐不一致"),
    FLOW_PACKAGE_CHANGE_DIFFERENT(2407, "卡变更共享池记录的流量池套餐跟变更套餐不一致"),
    EXIST_CHANGE_CUSTOMER_POOL_RECORD(2408, "卡存在客户共享池变更记录"),
    EXIST_IN_CUSTOMER_POOL_RECORD(2409, "卡存在客户共享池预入池记录"),
    CUSTOMER_PACKAGE_IN_DIFFERENT(2410, "卡待入客户共享池记录的客户套餐跟变更套餐不一致"),
    CUSTOMER_PACKAGE_CHANGE_DIFFERENT(2411, "卡变更客户共享池记录的客户套餐跟变更套餐不一致"),

    SHARE_POOL_STATE_UNABLE(2412, "禁止对禁用状态的共享池进行禁用"),
    SHARE_POOL_STATE_ABLE(2413, "禁止对启用状态的共享池进行启用"),
    CUSTOMER_POOL_STATE_UNABLE(2414, "禁止对禁用状态的客户共享池进行禁用"),
    CUSTOMER_POOL_STATE_ABLE(2415, "禁止对启用状态的客户共享池进行启用"),
    /**
     * 停开机
     */
    MANUAL_USER_CHANNEL_NO_EXITS(2501, "未配置用户渠道"),
    MANUAL_CARDNOS_EMPTY(2502, "卡号数组不能为空"),
    MANUAL_IMPORT_TYPE_EMPTY(2503, "导入类型不能为空"),

    /**
     * 续费
     */
    RENEWAL_MOUTH_EMPTY(2601, "续费月份不能为空"),
    RENEWAL_CUST_PACKAGE_ID_EMPTY(2602, "客户套餐ID不能为空"),
    RENEWAL_CARD_NO_EMPTY(2603, "卡号不能为空"),
    RENEWAL_PARENT_SELL_CODE_EMPTY(2604, "父客户销售价格不能为空"),
    RENEWAL_CHILD_SELL_CODE_EMPTY(2605, "子客户销售价格不能为空"),
    RENEWAL_IMPORTY_EMPTY(2606, "导入类型不能为空"),
    RENEWAL_CHANNEL_PARENT_ID_EMPTY(2607, "父客户id不能为空"),
    RENEWAL_AUDIT_ID_EMPTY(2608, "审核任务ID不能为空"),
    RENEWAL_ORDER_NO_EMPTY(2609, "订单号不能为空"),
    RENEWAL_BUSINESS_ID_EMPTY(2610, "业务ID不能为空"),
    RENEWAL_PACKAGE_TYPE_EMPTY(2611, "该卡套餐类型为空，不允许续费"),
    RENEWAL_PACKAGE_EMPTY(2612, "该卡没有设置客户套餐,不允许续费"),
    RENEWAL_PACKAGE_NO_EXITS(2613, "客户套餐不存在,不允许续费"),
    RENEWAL_DISCOUNT_EMPTY(2614, "子客户续费折扣列表为空,不允许续费"),
    RENEWAL_PARENT_DISCOUNT_EMPTY(2615, "父客户续费折扣列表为空,不允许续费"),
    RENEWAL_PARENT_PACKAGE_EMPTY(2616, "父客户没有设置子客户对应的套餐,不允许续费"),
    RENEWAL_PARENT_PACKAGE_MORE_EMPTY(2617, "父客户设置了多个套餐,不允许续费"),
    RENEWAL_CARD_STATE_ERROR(2618, "该卡不处于使用、沉默、GPRS停用或到期停用状态,不允许续费"),
    RENEWAL_CANCEL_MOUTH_EMPTY(2619, "退订月份不能为空"),


    /**
     * 客户套餐
     */
    CHANNEL_PACKAGE_NOT_EXIST(2701, "客户套餐不存在"),
    CHANNEL_DISCOUNT_EXIST(2702, "产品策略已经存在"),
    CALC_PRICE_INCORRECT(2703, "和标准价格计算不正确"),
    PRICE_CANT_NEGATIVE_NUMBER(2704, "价格折扣不能负数"),
    PKG_CONF_NOT_NULL(2705, "关联客户产品不能为空"),
    CHANNEL_DISCOUNT_HAS_OPEN(2706, "一个套餐只能外放一个策略"),
    CONF_STATE_NOT_ALLOW(2707, "客户已禁用套餐，子客户不能启用"),

    /**
     * 告警模块
     */
    ALARM_THRESHOLD_EMPTY(2801, "告警阈值必填"),
    ALARM_SEND_TYPE_EMPTY(2802, "短信+平台 通知方式，短信推送时间必填"),
    ALARM_SMS_ID_EMPTY(2803, "短信+平台 通知方式，短信ID必填"),
    ALARM_GPRS_THRESHOLD_EMPTY(2804, "断网告警阈值必填"),
    ALARM_GPRS_THRESHOLD_CHECKED_EMPTY(2805, "客户共享池断网告警阈值必须选择一个"),
    ALARM_GPRS_THRESHOLD_MULTIPLE_EMPTY(2806, "单卡流量超过流量套餐倍数（倍）必填"),
    ALARM_REPEATE(2807, "告警策略已经存在"),
    ALARM_STATE_SAME(2808, "状态相同，不能修改"),
    ALARM_CHANNEL_EMPTY(2809, "子客户不能为空"),
    ALARM_PUSHER_USER_NAME_EMPTY(2810, "短信+平台 通知方式，推送人姓名必填"),
    ALARM_PUSHER_PHONE_EMPTY(2811, "短信+平台 通知方式，推送人手机号必填"),
    ALARM_CARD_NO_REPEATE(2812, "卡号重复"),
    ALARM_PUSHER_DTL_EMPTY(2813, "推送人明细数组必填"),
    ALARM_PUSHER_LIMIT_LENGTH(2814, "一条告警类型仅限同时支持20个推送人"),
    ALARM_PUSHER_REPEATE(2815, "告警推送人配置信息已经存在"),
    ALARM_PARAM_ERROR(2816, "参数格式错误"),
    ALARM_CUST_POOL_EXECUTE_TASK_ERROR(2817, "非待执行状态"),
    ALARM_CUST_POOL_CANCLE_TASK_ERROR(2819, "已终止不需要中断"),
    ALARM_CUST_POOL_FINISH_TASK_ERROR(2820, "已执行不能终止"),
    ALARM_IN_CUST_POOL_EMPTY(2821, "已入客户共享池不能为空"),
    ALARM_PRODUCT_NAME_EMPTY(2822, ",入客户共享池值，流量套餐类型不能为空"),
    ALARM_PRODUCT_NAME_ERROR(2823, "入客户共享池,流量套餐类型必须为月套餐"),
    ALARM_PRODUCT_NAME_NO_EXITS(2824, "流量套餐不存在"),
    ALARM_PRODUCT_NAME_NO_BELONG_CHANNEL(2825, "流量套餐不属于该客户"),
    ALARM_CUSTPACKAGE_NAME_NO_BELONG_PROD(2826, "客户套餐不属于该流量套餐类型"),
    ALARM_CUSTPACKAGE_NAME_NO_BELONG_CHANNEL(2827, "客户套餐不属于该客户"),
    ALARM_CUSTPOOL_NO_EXITS(2828, "客户共享池不存在"),
    ALARM_CUSTPOOL_NO_BELONG_CHANNEL(2829, "客户共享池不属于该客户"),
    ALARM_PUSHER_SYS_CHANNEL_ERROR(2830, "推送人为内部人员，不需要选择子客户"),
    ALARM_NOTIFICATION_WAY_ERROR(2831, "通知方式为仅平台通知，短信推送信息等字段不需要填"),
    ALARM_ALARM_ERROR(2832, "达量告警类型，达量断网阈值不需要填"),
    ALARM_GPRS_ERROR(2833, "达量断网告警，达量告警阈值不需要填"),
    ALARM_PUSHER_CHANNEL_ERROR(2834, "只能设置渠道客户类型"),
    ALARM_PUSHER_SYS_ERROR(2835, "只能设置内部人员类型"),
    ALARM_ALARMTYPE_ERROR(2836, "非告警范围下的告警类型"),
    ALARM_ALARMTYPE_CARD_ERROR(2837, "单卡告警告警类型错误"),
    ALARM_GPRS_THRESHOLD_ERROR(2838, "达量告警类型，达量断网阈值不需要填"),
    ALARM_ALARM_THRESHOLD_ERROR(2839, "达量断网告警类型，达量告警阈值不需要填"),
    ALARM_GPRS_THRESHOLD_NO_CHECK_EMPTY(2840, "未选择百分比告警，则池子达量断网阈值百分比不需要填"),
    ALARM_MUTIPL_THRESHOLD_NO_CHECK_EMPTY(2841, "未选择单卡倍数告警，则池子单卡倍数阈值不需要填"),
    ALARM_PUSHERTYPE_ERROR(2842, "推送人类型错误"),
    ALARM_CUST_PACKAGE_EXPIRATION(2843, "到期告警，到期阈值必填"),
    /**
     * 酬金变更、采购折扣变更 29**
     */
    NEW_DISCOUNT_NOT_NULL(2901, "新酬金策略不能为空"),
    NEW_DISCOUNT_NOT_EXIST(2902, "新酬金策略不存在"),
    USE_NEW_NOT_NULL(2903, "请选择是否使用新策略"),
    RENEW_MONTH_NOT_NULL(2904, "续订月份不能为空"),
    PAY_TYPE_NOT_ALLOWED(2905, "续订只能是预付费"),
    VALID_MONTH_NOT_NULL(2906, "有效期不能为空"),


    /**
     * 门户用户模块 30**
     */

    PORTAL_LOGIN_FAIL(3001, "用户名或密码、验证码不正确"),
    PORTAL_LOGIN_USER_DISABLE(3002, "该商户用户已禁用"),
    PORTAL_LOGIN_FAIL_THIRD(3003, "统一认证中心调用异常"),
    PORTAL_LOGIN_FAIL_THIRD_NULl(3004, "统一认证中心调用返回空"),
    PORTAL_PARSE_RESULT_ERROR(3005, "统一认证中心返回数据有误"),
    PORTAL_UNIAUTH_ERROR(3005, "统一认证中心内部错误"),
    PORTAL_UNIAUTH_UNKNOWN_ERROR(3006, "统一认证中心未知错误"),
    PORTAL_USER_NO_BIND_CHANNEL(3007, "该用户未绑定渠道，请联系管理员"),
    PORTAL_UNIAUTH_NO_BIND_CHANNEL(3007, "获取父渠道资源id失败"),
    PORTAL_USER_REGISTER_NO_CHANNEL(3008, "注册子客户用户，客户id不能为空"),
    PORTAL_USER_REGISTER_THIRD_ERROR(3009, "统一认证中心注册异常"),
    PORTAL_USER_EXIST(3010, "账号已存在"),
    PORTAL_USER_NOT_EXIST(3011, "账号不存在"),
    PORTAL_PASSWORD_NOT_MATCH(3012, "密码与确认密码不一致"),
    PORTAL_LOGIN_EXPIRE(3013, "登录已过期"),
    PORTAL_GET_MODULE_ERROR(3014, "登录成功，获取菜单异常"),
    PORTAL_USER_NO_PERMISSION(3015, "当前用户无权限"),
    MSG_ERROR_USER_NO_CHANNEL(3016, "该用户未绑定渠道，请联系管理员"),
    PORTAL_USER_NOT_BELONG(3017, "该商户用户所属渠道与当前登录用户不同"),
    PORTAL_CHARGE_NO_CHANEL(3018, "找不到对应的充值渠道跟供应商信息"),
    PORTAL_CHARGE_NO_PACKAGE(3019, "找不到对应的充值包信息"),
    PORTAL_CAPTCHA_EXPIRED(3020, "图形验证码已过期"),
    PORTAL_CAPTCHA_ERROR(3021, "输入验证码错误"),

    /**
     * 门户商户模块
     */
    PORTAL_MERCHANT_EXIST(3100, "商户名已存在"),
    PORTAL_MERCHANT_NOT(3101, "当前用户不是子客户用户"),
    PORTAL_MERCHANT_NOT_EXIST(3102, "商户不存在"),
    PORTAL_MERCHANT_STATE_NO_CHANGE(3103, "状态没变，不用重复设置"),
    MERCHANT_NO_BELONG_CHANNEL(3104, "下游商户所属渠道与当前用户渠道不一致"),
    CARD_NO_BELONG_CHANNEL(3105, "等卡不属于该用户，该用户不具备对应卡的分配权限"),
    USER_NO_BELONG_MERCHANT(3106, "该用户不属于商户用户"),
    /**
     * 门户卡分配
     */
    DISTRIBUTE_EXCEL_CARD_NO_EXITS(3200, "导入的卡不存在"),
    DISTRIBUTE_CARD_NO_BELONG_USER(3201, "卡不属于当前子渠道客户"),

    /**
     * h5 40**
     */

    TOKEN(4001, "token不匹配!"),
    CODE(4002, "验证码已过期请重新输入!"),
    SMS_CODE(4003, "验证码错误!"),
    FAIL_SMS(4004, "短信发送失败!"),
    H5_LOGIN_EXPIRE(4005, "登录已过期"),
    H5_ICCID_ERROR(4006, "卡片有误"),

    /**
     * 外放接口 41**
     */

    OPEN_TOKEN(4101, "参数错误"),
    OPEN_SIGN_ERROR(4102, "签名错误"),
    OPEN_CHANNEL_NO_ERROR(4103, "channelNo不正确"),
    OPEN_TX_DATE_OUT_RANGE(4104, "txnDate参数范围不正确,要在5分钟内"),
    OPEN_RENEW_BUSINESS_ORDER_NOT_EXIST(4105, "续费业务订单不存在"),
    OPEN_RENEW_ORDER_NOT_EXIST(4106, "续费订单不存在"),
    OPEN_BUSINESS_NOT_SUPPORT(4107, "业务不支持"),
    OPEN_EXPIRE_MONTH_ERROR(4108, "续费期限有误"),
    OPEN_OTHER(4199, "其他错误"),


    /**
     * 风险防控 42**
     */
    RISK_CARD_NOT_EXIST(4201,"卡号对应记录不存在"),

    //   运营商状态 逗号隔开多个状态,1:测试,2:沉默,3:使用,4:当月停用,5:预约销户,6:人工停用,7:到期停用,8:渠道停用,9:运营商停用,10:进行中,11:解绑,12:续费开机
    RISK_CARD_STATE_5(4202,"预约销户的卡不能同步"),

    //   运营商状态 逗号隔开多个状态,1:测试,2:沉默,3:使用,4:当月停用,5:预约销户,6:人工停用,7:到期停用,8:渠道停用,9:运营商停用,10:进行中,11:解绑,12:续费开机
    RISK_CARD_STATE_NOT_9(4203,"非运营商停用的卡不能同步"),

    RISK_CARD_STATE5_NO_LIMITAREA(4204,"销户或未知区域限制省份不能同步"),
    RISK_SELECT_RECORD(4205,"请选择记录"),

    RISK_INTERFACE_METHOD_ERROR(4206,"接口调用异常，请联系管理员"),

    ;


    private final Integer code;
    private final String desc;

    BizCode(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static BizCode codeOf(int code) {
        for (BizCode value : values()) {
            if (value.code == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("不支持的业务代码: " + code);
    }
}
