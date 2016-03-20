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
  free tinyint(1) NOT NULL DEFAULT '0',
  stock int(10) unsigned NOT NULL DEFAULT '0',
  description varchar(200) DEFAULT NULL,
  url varchar(100) DEFAULT NULL,
  type varchar(40) DEFAULT NULL,
  discount int(10) unsigned NOT NULL DEFAULT '0',
  status int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
TRUNCATE TABLE products;

INSERT INTO products (id, name, unit_price) VALUES(1, "雙螢幕+雙前鏡頭 LG V10", 23500);
INSERT INTO products (id, name, unit_price, stock, description, url, type, discount) 
    VALUES(2, "HTC Desire 728 dual sim", 7300, 10, 
    "機身只有 7.87mm，重 153g，方便隨身攜帶，擁有雙色輕薄外型與亮眼的全鏡面螢幕設計，搭配上霧面防指紋背蓋，提供舒適手感。",
    "http://cf-attach.i-sogi.com/tw/product/img/hTC_Desire_728_dual_sim_0907025507289_360x270.jpg", "Outlet", 30);
INSERT INTO products (name, unit_price) VALUES("Apple iPhone 6 Plus 64GB", 26000);
commit;