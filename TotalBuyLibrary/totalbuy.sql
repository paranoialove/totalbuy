DROP DATABASE IF EXISTS totalbuy;

CREATE DATABASE totalbuy;
/*!40100 DEFAULT CHARACTER SET utf8 */

USE totalbuy;

/*DROP TABLE IF EXISTS customers;*/

CREATE TABLE  customers (
  id char(10) NOT NULL,
  name varchar(20) NOT NULL,
  gender char(1) NOT NULL,
  password varchar(20) NOT NULL,
  email varchar(45) NOT NULL,
  birthday date DEFAULT NULL,
  phone varchar(20) DEFAULT NULL,
  address varchar(100) DEFAULT NULL,
  married tinyint(1) DEFAULT '0',
  blood_type varchar(2) DEFAULT NULL,
  type varchar(10) DEFAULT NULL,
  discount int(10) unsigned NOT NULL DEFAULT '0',
  status int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO customers (id, name, gender, password, email) 
VALUES("A123456789", "張三", 'M', '123456', 'test@uuu.com.tw');

INSERT INTO customers
(id,name,gender,password,email,birthday,phone,address,married,blood_type,type,discount)
VALUES("A123456770", "王武", 'M', '123456', 'wang.five@gmail.com', '1980-3-5', '0225149191', '台北市復興北路5F', false, 'AB', null, 0);

commit;

CREATE TABLE  products (
  id int(10) unsigned NOT NULL AUTO_INCREMENT,
  name varchar(100) NOT NULL,
  unit_price double NOT NULL DEFAULT '0',
  free boolean NOT NULL DEFAULT '0',
  stock int(10) unsigned NOT NULL DEFAULT '0',
  description varchar(300) DEFAULT NULL,
  url varchar(100) DEFAULT NULL,
  type varchar(40) DEFAULT NULL,
  discount int(10) unsigned NOT NULL DEFAULT '0',
  status int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

TRUNCATE TABLE products;

INSERT INTO products (id, name, unit_price, description, url) VALUES(1, "LG V10", 19500, "雙螢幕+雙前鏡頭", 
    "http://cf-attach.i-sogi.com/tw/product/img/LG_V10_1223062723735_160x120.jpg");
INSERT INTO products (id, name, unit_price, stock, description, url, type, discount) 
    VALUES(2, "HTC Desire 728 dual sim", 7300, 10, 
    "機身只有 7.87mm，重 153g，方便隨身攜帶，擁有雙色輕薄外型與亮眼的全鏡面螢幕設計，搭配上霧面防指紋背蓋，提供舒適手感。",
    "http://cf-attach.i-sogi.com/tw/product/img/hTC_Desire_728_dual_sim_0907025507289_360x270.jpg", "Outlet", 30);
INSERT INTO products (name, unit_price) VALUES("Apple iPhone 6 Plus 64GB", 26000);
INSERT INTO products (id, name, unit_price, stock, description, url, type, discount) 
    VALUES(4, "Acer Liquid Z330", 3100, 10, 
    "Acer Liquid Z330擁有142g輕巧機身，圓潤流線，讓你輕鬆放入口袋。外型優雅潤澤、搭配特殊織紋背蓋設計，配置 4.5 吋觸控螢幕、854x480pixels解析度，採用Zero Air Gap，支援BluelightShield抗藍光技術，可保護眼睛避免傷害；再加上DTS Studio Sound優質音效技術，提供5.1聲道3D自然立體音效，帶給您清澈透析的聽覺體驗，輕鬆滿足影音娛樂需求。",
    "http://cf-attach.i-sogi.com/tw/product/img/Acer_Liquid_Z330_0903101303930_160x120.jpg", "Product", 0);
INSERT INTO products (id, name, unit_price, stock, description, url, type, discount) 
    VALUES(5, "HTC Desire 530", 4700, 10, 
    "Desire 530 將背蓋化身為藝術家的畫布，利用特殊設計的噴嘴、噴灑壓力調整與顏料黏著度，創造每支手機絕無僅有的獨特性，成為結合潮流時尚元素與消費性電子產品的最佳代表作；且每個機身都有色彩對應的按鈕，以極簡配搭觸感柔軟的聚碳酸酯機身，讓你愛不釋手，手機還配備掛繩，復刻經典造型，加入可以千變萬化的個性化元素。HTC Desire 530 搭載 5 吋 HD Super LCD 觸控螢幕，還擁有手機吊飾孔；此外，耳機模式下支援 HTC BoomSound 音效處理，不管你使用哪種耳機聆聽都可以享受無可比擬的音樂饗宴。",
    "http://cf-attach.i-sogi.com/tw/product/img/hTC_Desire_530_0221220121798_640x480.jpg", "Product", 0);
INSERT INTO products (id, name, unit_price, stock, description, url, type, discount) 
    VALUES(6, "HTC One A9 32GB", 13500, 10, 
    "全新的外型流線設計與細膩的邊框角度處理，擁有一體成型超薄金屬機身與優美線條，並在電源鍵周圍以精準的稜線接合，將螢幕鑲嵌於邊框內，提供接近自然與輕薄的手感。HTC One A9 32GB 搭載 5 吋 1,920 x 1,080pixels 解析度 AMOLED 觸控螢幕，並用康寧玻璃覆蓋螢幕，呈現生動與絢麗的成色效果；加上 BoomSound 配備杜比音效、Hi-Fi DAC 技術，具備優於 CD 的 24-bit、192KHz 音質表現，感受音樂中前所未有的豐富層次與厚度；再搭配 HTC Pro Studio 高傳真雙驅動環繞音效耳機，即可享受置身錄音室的臨場感。",
    "http://cf-attach.i-sogi.com/tw/product/img/hTC_Desire_728_dual_sim_0907025507289_360x270.jpg", "Product", 0);
INSERT INTO products (id, name, unit_price, stock, description, url, type, discount) 
    VALUES(7, "HTC Desire 728 dual sim", 7300, 10, 
    "機身只有 7.87mm，重 153g，方便隨身攜帶，擁有雙色輕薄外型與亮眼的全鏡面螢幕設計，搭配上霧面防指紋背蓋，提供舒適手感。",
    "http://cf-attach.i-sogi.com/tw/product/img/hTC_Desire_728_dual_sim_0907025507289_360x270.jpg", "Outlet", 30);
INSERT INTO products (id, name, unit_price, stock, description, url, type, discount) 
    VALUES(8, "Apple iPhone SE 16GB", 15500, 10, 
    "噴砂處理的鋁金屬打造光緞質感外觀，輕巧、精細的機身，握在手中，恰到好處；搭載絢麗的 4 吋 Retina 顯示器，讓一切看起來色彩鮮豔且清晰銳利，表面擁有防指印疏油外膜，讓手機清潔更便利；採用霧面切邊設計，搭配與機身顏色相襯的不鏽鋼標誌，成就完美外觀，並在主畫面按鈕內建 Touch ID 指紋感應器。",
    "http://cf-attach.i-sogi.com/tw/product/img/Apple_iPhone_6S_64GB_0909204209568_640x480.jpg", "Product", 0);
commit;