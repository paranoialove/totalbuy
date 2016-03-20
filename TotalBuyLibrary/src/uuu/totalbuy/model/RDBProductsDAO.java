/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.totalbuy.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import uuu.totalbuy.domain.Outlet;
import uuu.totalbuy.domain.Product;
import uuu.totalbuy.domain.TotalBuyException;

/**
 *
 * @author Administrator
 */
class RDBProductsDAO implements DAOInterface<Integer, Product> {
    //先把表單名抽出  以防之後修改  
    private static final String TABLE = "products";
    
    private static final String INSERT_SQL_AUTO_ID = "INSERT INTO " + TABLE
            + " (name, unit_price, free, stock, description, url, type, discount, status)"
            + " VALUES(?,?,?,?,?,?,?,?,?)";

    private static final String INSERT_SQL = "INSERT INTO " + TABLE
            + " (name, unit_price, free, stock, description, url, type, discount, status, id)"
            + " VALUES(?,?,?,?,?,?,?,?,?,?)";

    private static final String UPDATE_SQL = "UPDATE " + TABLE
            + " SET name=?, unit_price=?, free=?, stock=?, description=?, url=?, type=?, discount=?, status=?"
            + " WHERE id=?";
    private static final String DELETE_SQL = "DELETE FROM " + TABLE + " WHERE id=?";

    private static final String SELECT_ALL_SQL = "SELECT id, name, unit_price,"
            + " free, stock, description, url, type, discount, status"
            + " FROM " + TABLE;

    private static final String SELECT_SQL = SELECT_ALL_SQL + " WHERE id=?";

    private static final String SELECT_BY_NAME = SELECT_ALL_SQL + " WHERE name LIKE ?";

    @Override
    public void insert(Product data) throws TotalBuyException {
        if (data == null) {
            throw new IllegalArgumentException("新增產品不得為null!");
        }

        try (Connection connection = RDBConnection.getConnection(); //1. 取得連線
                PreparedStatement pstmt = //2.建立指令
                connection.prepareStatement(
                        data.getId() > 0 ? INSERT_SQL : INSERT_SQL_AUTO_ID,
                        data.getId() > 0 ? Statement.NO_GENERATED_KEYS : Statement.RETURN_GENERATED_KEYS
                );) {
            pstmt.setString(1, data.getName());
            pstmt.setDouble(2, data instanceof Outlet ? ((Outlet) data).getListPrice() : data.getUnitPrice());
            pstmt.setBoolean(3, data.isFree());
            pstmt.setInt(4, data.getStock());
            pstmt.setString(5, data.getDescription());
            pstmt.setString(6, data.getUrl());
            pstmt.setString(7, data.getClass().getSimpleName());
            if (data instanceof Outlet) {
                pstmt.setInt(8, ((Outlet) data).getDiscount());
            } else {
                pstmt.setInt(8, 0);
            }
            pstmt.setInt(9, data.getStatus());
            
                       
            //強迫給號的  就讓他設定  不用回傳
            if (data.getId() > 0) {
                pstmt.setInt(10, data.getId());
            }
            int rows = pstmt.executeUpdate();            
            assert (rows == 1) : "新增產品資料結構有誤:" + data;
            
            //如果產品代號沒有給值，就自動給號   要回傳自動給的號碼
            if (data.getId() <= 0) {
                try (ResultSet rs = pstmt.getGeneratedKeys();) {
                    if (rs.next()) {
                        data.setId(rs.getInt(1));
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "新增產品失敗: " + data, ex);
            throw new TotalBuyException("新增產品失敗!", ex);
        }
    }

    @Override
    public void update(Product data) throws TotalBuyException {
        if (data == null) {
            throw new IllegalArgumentException("修改產品不得為null!");
        }

        try (Connection connection = RDBConnection.getConnection(); //1. 取得連線
                PreparedStatement pstmt = connection.prepareStatement(UPDATE_SQL);) {
            pstmt.setString(1, data.getName());
            pstmt.setDouble(2, data instanceof Outlet ? ((Outlet) data).getListPrice() : data.getUnitPrice());
            pstmt.setBoolean(3, data.isFree());
            pstmt.setInt(4, data.getStock());
            pstmt.setString(5, data.getDescription());
            pstmt.setString(6, data.getUrl());
            pstmt.setString(7, data.getClass().getSimpleName());
            if (data instanceof Outlet) {
                pstmt.setInt(8, ((Outlet) data).getDiscount());
            } else {
                pstmt.setInt(8, 0);
            }
            pstmt.setInt(9, data.getStatus());
            pstmt.setInt(10, data.getId());
            int rows = pstmt.executeUpdate();    
            //------------------要告訴後面去執行  重要!!!!----------------------
            assert (rows == 1) : "修改產品資料結構有誤:" + data;
        } catch (SQLException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "修改產品失敗: " + data, ex);
            throw new TotalBuyException("修改產品失敗!", ex);
        }
    }

    @Override
    public void delete(Product data) throws TotalBuyException {
        if (data == null) {
            throw new IllegalArgumentException("刪除產品不得為null!");
        }

        try (Connection connection = RDBConnection.getConnection(); //1. 取得連線
                PreparedStatement pstmt = connection.prepareStatement(DELETE_SQL);) {
            pstmt.setInt(1, data.getId());
            int rows = pstmt.executeUpdate();
            assert (rows == 1) : "刪除產品資料結構有誤:" + data;
        } catch (SQLException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "刪除產品失敗: " + data, ex);
            throw new TotalBuyException("刪除產品失敗!", ex);
        }
    }

    @Override
    public Product get(Integer key) throws TotalBuyException {
        Product p = null;
        try (Connection connection = RDBConnection.getConnection(); //1. 取得連線
                PreparedStatement pstmt = connection.prepareStatement(SELECT_SQL);) { //2. 建立指令) 

            pstmt.setInt(1, key);
            //3. 執行指令，取回結果
            try (ResultSet rs = pstmt.executeQuery();) {
                while (rs.next()) {
                    String type = rs.getString("type");
                    p = createProduct(type);
                    p.setId(rs.getInt("id"));
                    p.setName(rs.getString("name"));
                    p.setUnitPrice(rs.getDouble("unit_price"));
                    p.setFree(rs.getBoolean("free"));
                    p.setStock(rs.getInt("stock"));
                    p.setDescription(rs.getString("description"));
                    p.setUrl(rs.getString("url"));
                    if (p instanceof Outlet) {
                        ((Outlet) p).setDiscount(rs.getInt("discount"));
                    }
                    p.setStatus(rs.getInt("status"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "查詢產品失敗: key-" + key, ex);
            throw new TotalBuyException("查詢產品失敗!", ex);
        }
        return p;
    }

    private Product createProduct(String type) {
        Product c;
        if (type != null && type.length() > 0) {
            String className = Product.class.getName().replace("Product", type);
            System.out.println("className:" + className);
            try {
                c = (Product) Class.forName(className).newInstance();
                return c;
            } catch (Exception ex) {
                Logger.getLogger(RDBProductsDAO.class.getName()).log(Level.INFO, "type無法建立物件:" + className, ex);
            }
        }
        return c = new Product();
    }

    @Override
    public List<Product> getAll() throws TotalBuyException {
        List<Product> list = new ArrayList<>();
        try (Connection connection = RDBConnection.getConnection(); //1. 取得連線
                PreparedStatement pstmt = connection.prepareStatement(SELECT_ALL_SQL); //2. 建立指令
                ResultSet rs = pstmt.executeQuery();) {//3. 執行指令，取回結果
            while (rs.next()) {
                String type = rs.getString("type");
                Product p = createProduct(type);
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setUnitPrice(rs.getDouble("unit_price"));
                p.setFree(rs.getBoolean("free"));
                p.setStock(rs.getInt("stock"));
                p.setDescription(rs.getString("description"));
                p.setUrl(rs.getString("url"));
                if (p instanceof Outlet) {
                    ((Outlet) p).setDiscount(rs.getInt("discount"));
                }
                p.setStatus(rs.getInt("status"));
                list.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "查詢全部產品失敗!", ex);
            throw new TotalBuyException("查詢全部產品失敗!", ex);
        }
        return list;
    }

    public List<Product> getByName(String data) throws TotalBuyException {
        List<Product> list = new ArrayList<>();
        try (Connection connection = RDBConnection.getConnection(); //1. 取得連線
                PreparedStatement pstmt = connection.prepareStatement(SELECT_BY_NAME);) { //2. 建立指令

            pstmt.setString(1, '%' + data + '%');
            try (ResultSet rs = pstmt.executeQuery();) {//3. 執行指令，取回結果
                while (rs.next()) {
                    String type = rs.getString("type");
                    Product p = createProduct(type);
                    p.setId(rs.getInt("id"));
                    p.setName(rs.getString("name"));
                    p.setUnitPrice(rs.getDouble("unit_price"));
                    p.setFree(rs.getBoolean("free"));
                    p.setStock(rs.getInt("stock"));
                    p.setDescription(rs.getString("description"));
                    p.setUrl(rs.getString("url"));
                    if (p instanceof Outlet) {
                        ((Outlet) p).setDiscount(rs.getInt("discount"));
                    }
                    p.setStatus(rs.getInt("status"));
                    list.add(p);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "查詢產品(by Name)失敗!", ex);
            throw new TotalBuyException("查詢產品(by Name)失敗!", ex);
        }
        return list;
    }

    public static void main(String[] args) {
        try {
            RDBProductsDAO dao = new RDBProductsDAO();
//            Product p1 = new Product(0, "Acer Liquid Jade S", 6600);
//            p1.setDescription("時尚打造，重量僅 116 克、厚度僅 7.78 公厘，並採用新一代天網雷雕天線，透過獨特的菱格紋背蓋設計，將天線與背殼融合為一，除了讓手機更纖薄，同時也能加強收訊品質，而機身為圓弧設計，整體外型洗鍊優雅。");
//            p1.setUrl("http://cf-attach.i-sogi.com/tw/product/img/Acer_Liquid_Jade_S_1209095709653_360x270.jpg");
//            try {
//                dao.insert(p1);
//            } catch (TotalBuyException ex) {
//                System.out.println("無法新增:" + (ex.getCause() == null ? "" : ex.getCause().getMessage()));
//            }

            Product p2 = new Product(5, "Acer八核心4G LTE 高效能智慧型手機 Acer Liquid X1", 7100);
            p2.setDescription("5.7 吋 IPS 螢幕、1,280 x 720pixels 螢幕解析度，機身採輕薄設計，機身厚度為 8.5mm 僅 164g，採用 Gorilla Glass 3 高硬度玻璃與 Zero Air Gap 全貼合技術，其色澤、清晰度與飽和度更佳，並可大幅降低折射反光。");
            p2.setUrl("http://cf-attach.i-sogi.com/tw/product/img/Acer_Liquid_X1_0602140002783_360x270.jpg");
            try {
                dao.insert(p2);
            } catch (TotalBuyException ex) {
                dao.update(p2);
                System.out.println("無法新增:" + (ex.getCause() == null ? "" : ex.getCause().getMessage()));
            }

            Outlet p3 = new Outlet(6, "ASUS ZenFone 2 Laser ZE500KL", 4700);
            p3.setDescription("植入第四代康寧大猩猩玻璃，搭配 5 吋 720P HD IPS 面板觸控螢幕、1,280 x 720pixels 螢幕解析度，擁有清晰亮麗且細膩又不失真的畫面呈現，讓用戶在觀看影片、閱讀書籍、瀏覽網頁時都能得到絕佳的視覺體驗。");
            p3.setUrl("http://cf-attach.i-sogi.com/tw/product/img/ASUS_ZenFone_2_Laser_ZE500KL_0731080831477_360x270.jpg");
            try {
                dao.insert(p3);
            } catch (TotalBuyException ex) {
                dao.update(p3);
                System.out.println("無法新增:" + (ex.getCause() == null ? "" : ex.getCause().getMessage()));
            }

            Product p = dao.get(6);
            //((Outlet)p).setDiscount(15);
            p.setUnitPrice(3700);
            dao.update(p);
            List<Product> list = dao.getByName("acer");
            System.out.println("--------------\n查詢全部:\n" + list);
            // dao.delete(p);
            System.out.println("--------------\n查詢全部:\n" + list.size());
            
        } catch (TotalBuyException ex) {
            System.out.println(ex + ":" + ex.getCause() == null ? "" : ex.getCause().getMessage());
        }
    }
}
