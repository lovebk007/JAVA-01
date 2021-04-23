/**
  用户信息表
 */
-- 用户登录表/用户注册表
CREATE TABLE user_login(
  login_id BIGINT UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '用户ID',
  login_name VARCHAR(20) NOT NULL COMMENT '用户登录名',
  password CHAR(32) NOT NULL COMMENT 'md5加密的密码',
  user_state TINYINT NOT NULL DEFAULT 1 COMMENT '用户状态 0未启用 1启用 2异常 3注销',
  create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '登录时间',
  update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY pk_user(login_id)
) ENGINE = innodb COMMENT '用户登录表';

-- 用户地址表
CREATE TABLE user_address(
  user_address_id BIGINT UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '自增主键ID',
  login_id BIGINT UNSIGNED NOT NULL COMMENT 'user_login表的自增ID',
  postcode SMALLINT NOT NULL COMMENT '邮编',
  province SMALLINT NOT NULL COMMENT '地区表中省份的ID',
  city SMALLINT NOT NULL COMMENT '地区表中城市的ID',
  district SMALLINT NOT NULL COMMENT '地区表中的区ID',
  address VARCHAR(200) NOT NULL COMMENT '具体的地址门牌号',
  is_default TINYINT NOT NULL COMMENT '是否默认地址',
  create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '登录时间',
  update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY pk_address(user_address_id)
) ENGINE = innodb COMMENT '用户地址表';

-- 用户详情表
CREATE TABLE user_details(
  user_details_id BIGINT UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '自增主键ID',
  login_id BIGINT UNSIGNED NOT NULL COMMENT 'user_login表的自增ID',
  whether_married TINYINT COMMENT '是否已婚 0未婚 1已婚',
  education_level TINYINT COMMENT '受教育水平 0初中 1高中 2专科 3本科 4硕士 5博士 6博士后',
  age INT COMMENT '年龄',
  gender TINYINT COMMENT '性别 0女 1男',
  mobile varchar(11) COMMENT '手机号',
  id_card_type TINYINT DEFAULT 0 COMMENT '证件类型 0身份证 1驾驶证 2护照 3港澳台 4港澳台通行证',
  id_card_No varchar(30) COMMENT '证件号码',
  email varchar(200) COMMENT '邮箱',
  PRIMARY KEY pk_details(user_details_id)
)ENGINE = innodb COMMENT '用户详情表';

-- 用户积分表
CREATE TABLE user_point(
  point_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '积分ID',
  login_id BIGINT UNSIGNED NOT NULL COMMENT 'user_login表的自增ID',
  source TINYINT UNSIGNED NOT NULL COMMENT '积分来源：0订单，1登陆，2活动',
  refer_number INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '积分来源相关编号',
  change_point SMALLINT NOT NULL DEFAULT 0 COMMENT '变更积分数',
  current_point SMALLINT NOT NULL DEFAULT 0 COMMENT '当前积分总数',
  create_time TIMESTAMP NOT NULL COMMENT '积分生成时间',
  update_time TIMESTAMP NOT NULL COMMENT '积分修改时间',
  PRIMARY KEY pk_point(point_id)
) ENGINE = innodb COMMENT '用户积分表';

-- 用户登录日志表
CREATE TABLE user_login_log(
  log_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '登陆日志ID',
  login_id BIGINT UNSIGNED NOT NULL COMMENT 'user_login表的自增ID',
  login_time TIMESTAMP NOT NULL COMMENT '用户登录时间',
  login_ip INT UNSIGNED NOT NULL COMMENT '登录IP',
    login_mac_address varchar(200) COMMENT '登录MAC地址',
  login_device_type TINYINT COMMENT '登录机器类型 0-PC 1-Android 2-IOS',
  login_device_model varchar(30) COMMENT '登录设备型号',
  login_type TINYINT NOT NULL COMMENT '登录类型：0未成功，1成功',
  PRIMARY KEY pk_log(log_id)
) ENGINE = innodb COMMENT '用户登录日志表';

/**
  商品信息表
 */
-- 商品信息表
CREATE TABLE product_info(
  product_id BIGINT UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '商品ID',
  product_code CHAR(16) NOT NULL COMMENT '商品编码',
  product_name VARCHAR(20) NOT NULL COMMENT '商品名称',
  product_picture_id BIGINT UNSIGNED NOT NULL COMMENT '商品图片表的ID',
  bar_code VARCHAR(50) NOT NULL COMMENT '条型码',
  brand_id BIGINT UNSIGNED NOT NULL COMMENT '品牌表的ID',
  one_category_id SMALLINT UNSIGNED NOT NULL COMMENT '一级分类ID',
  two_category_id SMALLINT UNSIGNED NOT NULL COMMENT '二级分类ID',
  three_category_id SMALLINT UNSIGNED NOT NULL COMMENT '三级分类ID',
  supplier_id BIGINT UNSIGNED NOT NULL COMMENT '商品的供应商ID',
  price DECIMAL(8,2) NOT NULL COMMENT '商品销售价格',
  publish_status TINYINT NOT NULL DEFAULT 0 COMMENT '上下架状态：0下架 1上架',
  audit_status TINYINT NOT NULL DEFAULT 0 COMMENT '审核状态：0未审核，1已审核 2审核不通过',
  production_date DATETIME NOT NULL COMMENT '生产日期',
  effective_date DATETIME NOT NULL COMMENT '有效日期',
  description TEXT NOT NULL COMMENT '商品描述',
  create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '商品录入时间',
  update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '商品修改时间',
  PRIMARY KEY pk_product(product_id)
) ENGINE = innodb COMMENT '商品信息表';

-- 商品图片信息表
CREATE TABLE product_picture_info(
  picture_id BIGINT UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '商品图片ID',
  product_id BIGINT UNSIGNED NOT NULL COMMENT '商品ID',
  picture_desc VARCHAR(50) COMMENT '图片描述',
  picture_url VARCHAR(200) NOT NULL COMMENT '图片URL',
  is_master TINYINT NOT NULL DEFAULT 0 COMMENT '是否主图：0.非主图1.主图',
  picture_order TINYINT NOT NULL DEFAULT 0 COMMENT '图片排序',
  picture_status TINYINT NOT NULL DEFAULT 1 COMMENT '图片是否有效：0无效 1有效',
  create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '图片录入时间',
  update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '图片修改时间',
  PRIMARY KEY pk_picture(picture_id)
)ENGINE=innodb COMMENT '商品图片信息表';

-- 商品评论表
CREATE TABLE product_comment(
  comment_id BIGINT UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '评论ID',
  product_id BIGINT UNSIGNED NOT NULL COMMENT '商品ID',
  order_id BIGINT UNSIGNED NOT NULL COMMENT '订单ID',
  login_id BIGINT UNSIGNED NOT NULL COMMENT '用户ID',
  title VARCHAR(200) NOT NULL COMMENT '评论标题',
  content VARCHAR(2000) NOT NULL COMMENT '评论内容',
  audit_status TINYINT NOT NULL COMMENT '审核状态：0未审核，1已审核',
  audit_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '评论审核时间',
  create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '评论发布时间',
  update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '评论修改时间',
  PRIMARY KEY pk_comment(comment_id)
) ENGINE = innodb COMMENT '商品评论表';


-- 商品品牌信息表
CREATE TABLE product_brand_info(
  brand_id BIGINT UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '品牌ID',
  product_id BIGINT UNSIGNED NOT NULL COMMENT '商品ID',
  brand_name VARCHAR(50) NOT NULL COMMENT '品牌名称',
  telephone VARCHAR(50) NOT NULL COMMENT '联系电话',
  brand_web VARCHAR(100) COMMENT '品牌网址',
  brand_logo VARCHAR(100) COMMENT '品牌logo URL',
  brand_desc VARCHAR(150) COMMENT '品牌描述',
  brand_status TINYINT NOT NULL DEFAULT 0 COMMENT '品牌状态,0禁用,1启用',
  brand_order TINYINT NOT NULL DEFAULT 0 COMMENT '排序',
  create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '录入时间',
  update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY pk_brand (brand_id)
)ENGINE=innodb COMMENT '商品品牌信息表';

-- 商品供应商信息表
CREATE TABLE product_supplier_info(
  supplier_id BIGINT UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '供应商ID',
  product_id BIGINT UNSIGNED NOT NULL COMMENT '商品ID',
  supplier_code CHAR(8) NOT NULL COMMENT '供应商编码',
  supplier_name CHAR(50) NOT NULL COMMENT '供应商名称',
  supplier_type TINYINT NOT NULL COMMENT '供应商类型：1.自营，2.平台',
  link_man VARCHAR(10) NOT NULL COMMENT '供应商联系人',
  phone_number VARCHAR(50) NOT NULL COMMENT '联系电话',
  bank_name VARCHAR(50) NOT NULL COMMENT '供应商开户银行名称',
  bank_account VARCHAR(50) NOT NULL COMMENT '银行账号',
  address VARCHAR(200) NOT NULL COMMENT '供应商地址',
  supplier_status TINYINT NOT NULL DEFAULT 0 COMMENT '状态：0禁止，1启用',
  create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '录入时间',
  update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY pk_supplier(supplier_id)
) ENGINE = innodb COMMENT '商品供应商信息表';

-- 商品分类表
CREATE TABLE product_category(
  category_id BIGINT UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '分类ID',
  product_id BIGINT UNSIGNED NOT NULL COMMENT '商品ID',
  category_name VARCHAR(10) NOT NULL COMMENT '分类名称',
  category_code VARCHAR(10) NOT NULL COMMENT '分类编码',
  parent_id BIGINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '父分类ID',
  category_level TINYINT NOT NULL DEFAULT 1 COMMENT '分类层级',
  category_status TINYINT NOT NULL DEFAULT 1 COMMENT '分类状态',
  modified_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT  '最后修改时间',
  PRIMARY KEY pk_category(category_id)
)ENGINE=innodb COMMENT '商品分类表';


/**
  订单信息表
 */
CREATE TABLE product_order(
  order_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  order_sn BIGINT UNSIGNED NOT NULL COMMENT '订单编号',
  login_id BIGINT UNSIGNED NOT NULL COMMENT '下单人ID',
  receiver_name VARCHAR(10) NOT NULL COMMENT '收货人姓名',
  province SMALLINT NOT NULL COMMENT '省',
  city SMALLINT NOT NULL COMMENT '市',
  district SMALLINT NOT NULL COMMENT '区',
  address VARCHAR(100) NOT NULL COMMENT '地址',
  payment_method TINYINT NOT NULL COMMENT '支付方式：1现金，2余额，3网银，4支付宝，5微信',
  order_amount DECIMAL(8,2) NOT NULL COMMENT '订单金额',
  discount_amount DECIMAL(8,2) NOT NULL DEFAULT 0.00 COMMENT '优惠金额',
  payment_money DECIMAL(8,2) NOT NULL DEFAULT 0.00 COMMENT '支付金额',
  shipping_sn VARCHAR(50) COMMENT '快递单号',
  create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '下单时间',
  shipping_time DATETIME COMMENT '发货时间',
  payment_time DATETIME COMMENT '支付时间',
  receive_time DATETIME COMMENT '收货时间',
  order_status TINYINT NOT NULL DEFAULT 0 COMMENT '订单状态',
  order_point INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '订单积分',
  invoice_time VARCHAR(100) COMMENT '发票抬头',
  update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY pk_order(order_id)
)ENGINE = innodb COMMENT '订单表';

-- 订单详情表
CREATE TABLE order_detail(
  order_detail_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '订单详情表ID',
  order_id BIGINT UNSIGNED NOT NULL COMMENT '订单表ID',
  product_id BIGINT UNSIGNED NOT NULL COMMENT '订单商品ID',
  product_name VARCHAR(50) NOT NULL COMMENT '商品名称',
  product_count INT NOT NULL DEFAULT 1 COMMENT '购买商品数量',
  product_price DECIMAL(8,2) NOT NULL COMMENT '购买商品单价',
  weight FLOAT COMMENT '商品重量',
  warehouse_id INT UNSIGNED NOT NULL COMMENT '仓库ID',
  order_amount DECIMAL(8,2) NOT NULL COMMENT '订单价格',
  create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '下单时间',
  update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY pk_order_detail(order_detail_id)
)ENGINE = innodb COMMENT '订单详情表';

-- 购物车表
CREATE TABLE order_cart(
  cart_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '购物车ID',
  login_id BIGINT UNSIGNED NOT NULL COMMENT '用户ID',
  product_id BIGINT UNSIGNED NOT NULL COMMENT '商品ID',
  product_count INT NOT NULL COMMENT '加入购物车商品数量',
  product_price DECIMAL(8,2) NOT NULL COMMENT '商品价格',
  create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '加入购物车时间',
  update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY pk_cart(cart_id)
) ENGINE = innodb COMMENT '购物车表';


-- 商品库存表
CREATE TABLE product_warehouse(
  product_warehouse_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '商品库存ID',
  product_id BIGINT UNSIGNED NOT NULL COMMENT '商品ID',
  warehouse_id BIGINT UNSIGNED NOT NULL COMMENT '仓库ID',
  current_count INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '当前库存商品数量',
  lock_count INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '当前占用库存商品数量',
  in_transit_count INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '在途商品数量',
  create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '入库时间',
  update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY pk_product_warehouse(product_warehouse_id)
)ENGINE = innodb COMMENT '商品库存表';

-- 仓库信息表
CREATE TABLE warehouse_info(
  warehouse_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '仓库ID',
  warehouse_sn CHAR(5) NOT NULL COMMENT '仓库编码',
  warehouse_name VARCHAR(10) NOT NULL COMMENT '仓库名称',
  warehouse_phone VARCHAR(20) NOT NULL COMMENT '仓库电话',
  contact VARCHAR(10) NOT NULL COMMENT '仓库联系人',
  province SMALLINT NOT NULL COMMENT '省',
  city SMALLINT NOT NULL COMMENT '市',
  district SMALLINT NOT NULL COMMENT '区',
  address VARCHAR(100) NOT NULL COMMENT '仓库地址',
  warehouse_status TINYINT NOT NULL DEFAULT 1 COMMENT '仓库状态：0禁用，1启用',
  create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  modified_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY pk_warehouse_info(warehouse_id)
)ENGINE = innodb COMMENT '仓库信息表';

-- 物流公司信息表
CREATE TABLE transport_company_info(
  transport_company_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  transport_company_code VARCHAR(10) COMMENT '快递公司编码',
  transport_company_name VARCHAR(20) NOT NULL COMMENT '物流公司名称',
  contact VARCHAR(20) NOT NULL COMMENT '物流公司联系人',
  telephone VARCHAR(20) NOT NULL COMMENT '物流公司联系电话',
  transport_price DECIMAL(8,2) NOT NULL DEFAULT 0.00 COMMENT '配送价格',
  create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  modified_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY pk_transport_company_info(transport_company_id)
)ENGINE = innodb COMMENT '物流公司信息表';