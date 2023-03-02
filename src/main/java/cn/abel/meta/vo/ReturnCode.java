package cn.abel.meta.vo;

/**
 * @ClassName:ReturnCode
 * @Description:定义系统请求返回码与返回描述信息
 * @author:hzyuan@iflytek.com
 * @date:2017年6月1日
 */
public class ReturnCode {

    private ReturnCode() {
    }

    public static final KeyValuePair SUCCESS = new KeyValuePair(0, "成功", "成功");
    public static final KeyValuePair QUERY_DATA_EMPTY = new KeyValuePair(10000, "查询数据为空", "查询数据为空");
    //授权错误码
    public static final KeyValuePair AUTH_APPID_INVALID = new KeyValuePair(10003, "无效的APPID", "APPID无效");
    public static final KeyValuePair AUTH_TOKEN_INVALID = new KeyValuePair(10004, "无效的TOKEN", "TOKEN过期");
    public static final KeyValuePair AUTH_PERMISSION_DENIED = new KeyValuePair(10005, "无权操作", "无权操作");
    public static final KeyValuePair NOT_FOUNT_APPID = new KeyValuePair(10006, "请选择应用", "请选择应用");
    public static final KeyValuePair PASSWORD_ILLEGAL = new KeyValuePair(10007, "密码格式非法", "密码格式非法");
    public static final KeyValuePair PASSWORD_SAME_ERROR = new KeyValuePair(10009, "支付密码不能与登录密码相同", "支付密码不能与登录密码相同");
    public static final KeyValuePair PAY_PASSWORD_ERROR = new KeyValuePair(10010, "余额支付密码错误", "支付密码错误");
    public static final KeyValuePair PAY_PASSWORD_NOTSET = new KeyValuePair(10011, "支付密码未设置", "支付密码未设置");
    public static final KeyValuePair AUTH_VALID_TIMEOUT = new KeyValuePair(10012, "未进行验证或验证已过期请重新进行验证码验证", "未进行验证或验证已过期请重新进行验证码验证");
    public static final KeyValuePair APPID_COUNT_EXCEEDED = new KeyValuePair(10013, "APPID数量超过限制", "APPID数量超过限制");
    //
    public static final KeyValuePair PARAMS_EMPTY = new KeyValuePair(20001, "必选参数为空", "必选参数为空");
    public static final KeyValuePair TIMESTAMP_TIMEOUT = new KeyValuePair(20002, "请求超时", "请求超时");
    public static final KeyValuePair PARAMS_ILLEGAL = new KeyValuePair(20003, "参数非法", "参数非法");
    public static final KeyValuePair REQUEST_METHOD_NOT_SUPPORT = new KeyValuePair(20004, "请求方法不支持", "请求方法不支持");
    public static final KeyValuePair UPLOAD_FILE_EXCEPTION = new KeyValuePair(20005, "", "");
    public static final KeyValuePair SMS_SEND_FAILED = new KeyValuePair(20006, "短信发送失败", "短信发送异常");
    public static final KeyValuePair SMS_CODE_ILLEGAL = new KeyValuePair(20008, "短信验证码校验不通过", "短信验证码校验不通过");
    public static final KeyValuePair OP_TOO_FAST = new KeyValuePair(20010, "操作太频繁", "操作太频繁");
    public static final KeyValuePair MOBILE_NUMBER_EXIST = new KeyValuePair(20011, "手机号码已经存在", "手机号码已经存在");
    public static final KeyValuePair PARAMS_OUT_RANGE = new KeyValuePair(20013, "请求参数超出范围", "请求参数超出范围");
    //应用和用户相关错误码
    public static final KeyValuePair APP_NOT_BELONG_UID = new KeyValuePair(30000, "应用不属于用户", "应用归属异常");
    public static final KeyValuePair APPNAME_EXIST = new KeyValuePair(30001, "应用名称已存在", "应用名称已存在");
    public static final KeyValuePair APPCATEGORY_ILLEGAL = new KeyValuePair(30005, "APP_CATEGORY非法", "APP_CATEGORY非法");
    public static final KeyValuePair UN_CERTIFICATION = new KeyValuePair(30006, "用户未实名认证", "用户未实名认证");

    public static final KeyValuePair APPID_ILLEGAL = new KeyValuePair(30015, "应用ID非法", "应用ID非法");
    public static final KeyValuePair PASSWORD_ILLEGAL_EXCEPTION = new KeyValuePair(30017, "密码格式非法", "密码格式非法");

    public static final KeyValuePair SEND_EMAIL_FAIL = new KeyValuePair(30020, "邮件发送失败", "邮件发送异常");
    public static final KeyValuePair EMAIL_VERIFY_CODE_ERROR = new KeyValuePair(30021, "邮件验证码错误", "邮件验证码错误");
    public static final KeyValuePair CER_SCHOOLNAME_ILLEGAL = new KeyValuePair(30023, "等待人工认证", "等待人工认证");
    public static final KeyValuePair EMALI_ADDRESS_EXIST = new KeyValuePair(30024, "邮箱地址已存在", "邮箱地址已存在");

    public static final KeyValuePair APP_NOT_HAVE_BUSINESS = new KeyValuePair(30025, "该应用未开通此项服务", "该应用未开通此项服务");
    public static final KeyValuePair UPLOAD_FILE_TOO_LARGE = new KeyValuePair(30027, "上传文件太大", "上传文件太大");

    public static final KeyValuePair NOT_FOUND_ACCOUNTID = new KeyValuePair(30031, "accountId不存在", "accountId不存在");
    public static final KeyValuePair ADD_SERVICES = new KeyValuePair(30032, "添加服务超时", "添加服务超时");
    public static final KeyValuePair ALREADY_ADD_SERVICES = new KeyValuePair(30033, "您已是yeta用户,请继续使用xfyeta.com登录", "您已是yeta用户,请继续使用xfyeta.com登录");
    public static final KeyValuePair ILLEGAL_CHARACTER = new KeyValuePair(30034, "热词包含非中文字符", "热词包含非中文字符");
    public static final KeyValuePair CHARACTER_LENGTH_OVERRUN = new KeyValuePair(30035, "热词长度超限", "热词长度超限");
    public static final KeyValuePair NUMBER_OF_CHARACTERS_EXCEEDED = new KeyValuePair(30036, "热词个数限制", "热词个数限制");
    public static final KeyValuePair JOIN_SEPARATOR = new KeyValuePair(30037, "热词中有连续分隔符", "热词中有连续分隔符");
    public static final KeyValuePair NOT_EXIST = new KeyValuePair(30040, "热词为空", "热词为空");

    public static final KeyValuePair UPLOAD_FILE_CHARSET_NOT_DETECT = new KeyValuePair(30041, "上传文件编码方式不是UTF-8", "上传文件编码方式不是UTF-8");
    public static final KeyValuePair UPLOAD_FILE_CONTENT_NOT_RIGHT = new KeyValuePair(30042, "上传文件内容不符合规范，参考注意事项", "上传文件内容不符合规范，参考注意事项");
    public static final KeyValuePair DELETE_FILE_OPT_NOT_SUCCESS = new KeyValuePair(30043, "删除文件异常，请稍后重试", "删除文件异常，请稍后重试");
    public static final KeyValuePair HARDWARE_ALREADY_EXISTS = new KeyValuePair(30044, "服务已创建，不可重复创建", "服务已创建，不可重复创建");
    public static final KeyValuePair COMBINATION_NOT_SUPPORTED = new KeyValuePair(30045, "暂不支持该组合，请参考技术文档说明", "暂不支持该组合，请参考技术文档说明");


    // 实名认证变更相关
    public static final KeyValuePair IDCARD_EMPTY = new KeyValuePair(30050, "请输入身份证号", "请输入身份证号");
    public static final KeyValuePair IDCARD_ERROR = new KeyValuePair(30051, "身份证号错误，请确认并再次提交", "身份证号错误，请确认并再次提交");
    public static final KeyValuePair CERTIFICATION_ENTERPRISE = new KeyValuePair(30052, "已完成企业实名认证，不能再进行学生认证", "已完成企业实名认证，不能再进行学生认证");
    public static final KeyValuePair CERTIFICATION_STUDENT = new KeyValuePair(30053, "学生认证审核中", "学生认证审核中");
    public static final KeyValuePair CERTIFICATION_INDIVIDUAL = new KeyValuePair(30054, "已完成个人实名认证，不能再进行初创团队认证", "已完成个人实名认证，不能再进行初创团队认证");
    public static final KeyValuePair ENTERPRISE_REGISTERTIME = new KeyValuePair(30055, "企业注册时间超过5年，不能再进行初创团队认证", "企业注册时间超过5年，不能再进行初创团队认证");
    public static final KeyValuePair CERTIFICATION_ENTREPRENEUR = new KeyValuePair(30056, "初创团队认证审核中", "初创团队认证审核中");
    public static final KeyValuePair CERTIFICATION_UPGRADING = new KeyValuePair(30057, "认证类型变更中", "认证类型变更中");
    public static final KeyValuePair SCHOOL_TIME = new KeyValuePair(30062, "入学时间大于5年,不能进行学生认证", "入学时间大于5年,不能进行学生认证");
    public static final KeyValuePair CERTIFICATION_TYPE_MISMATCH = new KeyValuePair(30063, "认证变更申请类型与原认证类型不匹配", "认证变更申请类型与原认证类型不匹配");
    public static final KeyValuePair WELFARE_APPLYING = new KeyValuePair(30064, "公益身份审核中", "公益身份审核中");
    public static final KeyValuePair CERTIFICATION_CHANGING = new KeyValuePair(30065, "实名认证变更中", "实名认证变更中");

    public static final KeyValuePair AUTHENTICATION_EXCEPTION = new KeyValuePair(30066, "身份验证异常", "身份验证异常");

    // 控制台礼包相关
    public static final KeyValuePair GIFT_PACKAGE_ERROR = new KeyValuePair(31000, "礼包不存在", "礼包不存在");
    public static final KeyValuePair ACTIVATE_FAIL = new KeyValuePair(31001, "礼包激活失败", "礼包激活失败");
    public static final KeyValuePair PP_NONE_SELECTED = new KeyValuePair(31002, "语音合成礼包未选择发音人", "语音合成礼包未选择发音人");
    public static final KeyValuePair ACTIVATE_GIFT_PACKAGE_NO_REPEAT = new KeyValuePair(31003, "活动礼包不可重复激活", "活动礼包不可重复激活");

    // 礼品卡兑换相关
    public static final KeyValuePair EXCHANGE_CODE_USED = new KeyValuePair(32000, "兑换码已被使用", "兑换码已被使用");
    public static final KeyValuePair EXCHANGE_CODE_EXIPRED = new KeyValuePair(32001, "兑换码已过期", "兑换码已过期");
    public static final KeyValuePair EXCHANGE_CODE_ERROR = new KeyValuePair(32002, "兑换码不正确", "兑换码不正确");

    //会员相关
    public static final KeyValuePair OVER_LENGTH = new KeyValuePair(33001, "会员总时长不可超过3年", "会员总时长不可超过3年");
    public static final KeyValuePair USER_LEVEL_LOWER = new KeyValuePair(33002, "用户等级低于权益可领取等级", "用户等级低于权益可领取等级");
    public static final KeyValuePair BENEFIT_USED = new KeyValuePair(33003, "已领取", " 已领取");
    public static final KeyValuePair CONDITIONS_NOT_MET = new KeyValuePair(33004, "未满足领取条件", "未满足领取条件");

    //WS 错误码
    public static final KeyValuePair WS_INSERT_APP_MST_ERROR = new KeyValuePair(40000, "ws插入app_mst发生错误", "服务异常");
    public static final KeyValuePair WS_INSERT_APP_PROFILE_ERROR = new KeyValuePair(40001, "ws插入app_profile发生错误", "服务异常");
    public static final KeyValuePair WS_UPDATE_USER_MST_ERROR = new KeyValuePair(40002, "ws更新user_mst发生错误", "服务异常");
    public static final KeyValuePair WS_UPDATE_USER_PROFILE_ERROR = new KeyValuePair(40003, "ws更新user_profile发生错误", "服务异常");
    public static final KeyValuePair WS_GET_COUNT_ERROR = new KeyValuePair(40004, "ws查询getCount错误", "服务异常");
    public static final KeyValuePair WS_INSERT_APP_APPAPPLYSTEP_ERROR = new KeyValuePair(40005, "ws插入app_apply_step发生错误", "服务异常");
    public static final KeyValuePair WS_METER_API_ERROR = new KeyValuePair(40006, "ws计量接口错误", "服务异常");
    public static final KeyValuePair WS_UPDATE_APP_MST_ERROR = new KeyValuePair(40007, "ws更新app_mst发生错误", "服务异常");
    public static final KeyValuePair WS_UPDATE_APP_PROFILE_ERROR = new KeyValuePair(40008, "ws更新app_profile发生错误", "服务异常");

    //业务相关错误
    public static final KeyValuePair ISE_FREE_ERROR = new KeyValuePair(50000, "评测SDK/WEIABI篇章阅读功能失败", "篇章阅读功能开通失败");
    public static final KeyValuePair ISE_EXBUS_INFO_ERROR = new KeyValuePair(50001, "评测SDK/WEIABI拓展能力获取失败", "评测SDK/WEIABI拓展能力获取失败");
    public static final KeyValuePair ISE_EXBUS_WASOPENED_ERROR = new KeyValuePair(50002, "评测拓展能力已开通过", "评测拓展能力已开通，不能再次领取");

    public static final KeyValuePair IAT_FREE_ERROR = new KeyValuePair(50003, "语音听写增值能力失败", "语音听写增值能力开通失败");
    public static final KeyValuePair IAT_EXBUS_INFO_ERROR = new KeyValuePair(50004, "语音听写增值能力获取失败", "语音听写增值能力获取失败");
    public static final KeyValuePair IAT_EXBUS_WASOPENED_ERROR = new KeyValuePair(50005, "语音听写增值能力已开通过", "语音听写增值能力已开通，不能再次领取");

    public static final KeyValuePair TTS_SPEAKERS_DRAM_ERROR = new KeyValuePair(50006, "语音合成发音人领取失败", "语音合成发音人领取失败");
    public static final KeyValuePair TTS_SPEAKERS_DRAM_NO_POWER = new KeyValuePair(50006, "语音合成发音人无资格领取", "语音合成发音人无资格领取");
    public static final KeyValuePair TTS_SPEAKERS_DRAM_ERROR_SIZE = new KeyValuePair(50006, "语音合成发音人领取发音人数异常", "语音合成发音人领取发音人数异常");
    public static final KeyValuePair CHANGE_VOICE_DRAM_ERROR = new KeyValuePair(50011, "音色转换发音人领取失败", "音色转换发音人领取失败");
    public static final KeyValuePair CHANGE_VOICE_DRAM_NO_POWER = new KeyValuePair(50011, "音色转换发音人无资格领取", "音色转换发音人无资格领取");
    public static final KeyValuePair CHANGE_VOICE_DRAM_ERROR_SIZE = new KeyValuePair(50011, "音色转换发音人领取发音人数异常", "音色转换发音人领取发音人数异常");
    public static final KeyValuePair IAT_LANGUAGE_DRAM_ERROR = new KeyValuePair(50007, "听写语种领取失败", "听写语种领取失败");
    public static final KeyValuePair IAT_LANGUAGE_DRAM_NO_POWER = new KeyValuePair(50007, "听写语种无资格领取", "听写语种无资格领取");
    public static final KeyValuePair IAT_LANGUAGE_DRAM_ERROR_SIZE = new KeyValuePair(50007, "听写语种领取发音人数异常", "听写语种领取发音人数异常");
    public static final KeyValuePair VMS_CNT_NOT_EXISTS = new KeyValuePair(50008, "虚拟人形象数据不存在", "虚拟人形象数据不存在");
    public static final KeyValuePair VMS_CNT_ALREADY_SET = new KeyValuePair(50009, "虚拟人形象已设置，无法重复设置", "虚拟人形象已设置，无法重复设置");
    public static final KeyValuePair VMS_CNT_NEED_CONC = new KeyValuePair(50010, "购买虚拟人能力之后，才能设置默认形象", "购买虚拟人能力之后，才能设置默认形象");
    //支付相关错误
    public static final KeyValuePair ALIPAY_FORM_EXCEPTION = new KeyValuePair(60001, "支付宝支付页发生错误", "支付异常");
    public static final KeyValuePair NO_BALANCE_EXCEPTION = new KeyValuePair(60002, "账户无余额", "账户无余额");
    public static final KeyValuePair NO_ENOUGH_BALANCE_EXCEPTION = new KeyValuePair(60003, "余额不足", "余额不足");
    public static final KeyValuePair TICKET_ILLEGAL_EXCEPTION = new KeyValuePair(60004, "非法优惠券", "优惠券非法");
    public static final KeyValuePair DISCOUNT_ILLEGAL_EXCEPTION = new KeyValuePair(60005, "折扣出错", "折扣异常");
    public static final KeyValuePair REDUCE_PRICE_ILLEGAL_EXCEPTION = new KeyValuePair(60006, "减价出错", "减价异常");
    public static final KeyValuePair FIRST_ORDER_ILLEGAL_EXCEPTION = new KeyValuePair(60007, "首单优惠出错", "首单优惠异常");
    public static final KeyValuePair ORDER_ILLEGAL_EXCEPTION = new KeyValuePair(60008, "非法订单", "订单非法");
    public static final KeyValuePair PACKAGE_ILLEGAL_EXCEPTION = new KeyValuePair(60009, "非法套餐", "套餐非法");
    public static final KeyValuePair TRADE_TYPE_ILLEGAL_EXCEPTION = new KeyValuePair(60010, "非法支付方式", "支付方式非法");
    public static final KeyValuePair NO_TICKET_EXCEPTION = new KeyValuePair(60011, "无代金券", "无代金券");
    public static final KeyValuePair UNDER_TICKET_THRESHOLD = new KeyValuePair(60013, "价格低于优惠券门槛值", "价格低于优惠券门槛值");
    public static final KeyValuePair PACKAGE_STORAGE_EXCEPTION = new KeyValuePair(60014, "超出套餐容量限制", "库存不足");
    public static final KeyValuePair WARE_ILLEGAL_EXCEPTION = new KeyValuePair(60015, "非法商品", "商品非法");
    public static final KeyValuePair ORDER_NUMBER_ILLEGAL = new KeyValuePair(60016, "订单购买数量非法", "商品购买数量超过限制");
    public static final KeyValuePair DISTRIBUTE_TICKET_ILLEGAL = new KeyValuePair(60017, "领取的优惠券非法", "该券不可领取");
    public static final KeyValuePair TICKET_ALREADY_DISTRIBUTE = new KeyValuePair(60018, "用户已经领取该优惠券", "您已经领取过该优惠券，请勿重复领取");
    public static final KeyValuePair GIFTCARD_ALREADY_DISTRIBUTE = new KeyValuePair(60019, "礼品卡不属于该用户", "当前礼品卡无效，请勿使用");
    public static final KeyValuePair GIFTCARD_NOT_ALLOW_EXCEPTION = new KeyValuePair(60026, "不能用礼品卡购买礼品卡", "不能用礼品卡购买礼品卡");
    public static final KeyValuePair GIFTCARD_NOT_ALLOW_OLD_EXCEPTION = new KeyValuePair(60027, "老用户不能购买该礼品卡", "老用户不能购买该礼品卡");
    public static final KeyValuePair REBUY_PACKAGE_ILLEGAL = new KeyValuePair(60020, "商品重复购买", "特殊商品一个用户只能购买一个");
    public static final KeyValuePair PRICE_ILLEGAL_EXCEPTION = new KeyValuePair(60021, "非法套餐", "选择的套餐价格不可低于0");
    public static final KeyValuePair TIME_TYPE_ILLEGAL_EXCEPTION = new KeyValuePair(60022, "非法套餐", "选择的套餐类型不一致");
    public static final KeyValuePair TIME_VALID_ILLEGAL_EXCEPTION = new KeyValuePair(60023, "非法套餐", "选择的套餐有效期错误");
    public static final KeyValuePair PACKAGE_PERSON_ILLEGAL_EXCEPTION = new KeyValuePair(60024, "未进行个人认证", "未进行个人认证");
    public static final KeyValuePair PACKAGE_COMPANY_ILLEGAL_EXCEPTION = new KeyValuePair(60025, "未进行企业认证", "未进行企业认证");
    public static final KeyValuePair PACKAGE_CERTIFICATE_ILLEGAL_EXCEPTION = new KeyValuePair(60026, "未进行实名认证", "未进行实名认证");
    // 工单相关
    public static final KeyValuePair WORK_ORDER_NO_PERMISSION = new KeyValuePair(61001, "尊敬的用户，您未获得该工单权限，请核实后重新尝试", "尊敬的用户，您未获得该工单权限，请核实后重新尝试");
    public static final KeyValuePair WORK_ORDER_FINISHED = new KeyValuePair(61002, "尊敬的用户，此工单已完结，如若有什么疑问，请提交新的工单", "尊敬的用户，此工单已完结，如若有什么疑问，请提交新的工单");
    public static final KeyValuePair WORK_ORDER_TAG_EMPTY = new KeyValuePair(61003, "标签为空，请至少选择一个标签", "标签为空，请至少选择一个标签");
    //订单相关错误
    public static final KeyValuePair ADDRESS_NOT_BELONG_UID = new KeyValuePair(70004, "地址不属于用户", "地址归属异常");
    public static final KeyValuePair CART_GOOD_NOT_MATCH = new KeyValuePair(70005, "购买商品与购物车信息不匹配", "购买商品与购物车信息不匹配");
    public static final KeyValuePair CART_NOT_EXIST = new KeyValuePair(70006, "用户购物车不存在", "用户购物车不存在异常");
    public static final KeyValuePair CART_PRODUCTS_EMPTY = new KeyValuePair(70007, "用户购物车没有商品", "用户购物车商品为空异常");
    public static final KeyValuePair COUPON_GIFT_EXCEPTION = new KeyValuePair(70008, "优惠券与礼品卡不可同时使用", "优惠券与礼品卡不可同时使用");
    public static final KeyValuePair NOT_ACTIVITY_NEWUSER_EXCEPTION = new KeyValuePair(70009, "非活动期间新注册用户", "非活动期间新注册用户");

    //登录异常
    public static final KeyValuePair LOGIN_EXCEPTION = new KeyValuePair(80000, "登录异常，请重新登录", "登录异常，请重新登录");
    public static final KeyValuePair LOGIN_REDIRECT_EXCEPTION = new KeyValuePair(80003, "登录跳转异常，请重新登录", "登录异常，请重新登录");

    public static final KeyValuePair FILEUPOLAD_EXCEPTION = new KeyValuePair(80002, "文件上传异常，请重新上传", "文件上传异常，请重新上传");
    public static final KeyValuePair FILEUPOLAD_TYPE_EXCEPTION = new KeyValuePair(80003, "文件上传类型错误，请重新上传", "文件上传类型错误，请重新上传");

    //系统错误码
    public static final KeyValuePair SYS_EXCEPTION = new KeyValuePair(99999, "系统异常", "系统异常");
    //购物车相关错误码
    public static final KeyValuePair SHOPPING_CART_ITEM_NUM = new KeyValuePair(90001, "购买数量非法", "请合理添加商品数量");
    public static final KeyValuePair NOT_CART_PRODUCT = new KeyValuePair(90002, "非购物车商品", "非购物车商品");

    public static final KeyValuePair MESSAGE_OPERATE = new KeyValuePair(90003, "消息操作失败", "消息操作失败");

    // 系统异常
    public static final KeyValuePair FILE_UPLOAD_FAIL = new KeyValuePair(99001, "UCloud文件上传失败", "UCloud文件上传失败");

    public static final KeyValuePair AUDIT_ILLEGAL = new KeyValuePair(90004, "操作失败", "内容不合规");
}




