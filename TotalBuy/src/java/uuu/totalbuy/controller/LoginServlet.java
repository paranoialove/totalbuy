/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.totalbuy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uuu.totalbuy.domain.Customer;
import uuu.totalbuy.domain.TotalBuyException;
import uuu.totalbuy.model.CustomerService;

/**
 *
 * @author PattyTai
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login.do"})
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ServletContext context = this.getServletContext();
                
        List<String> errors = new ArrayList<>();

        //1. 讀取並檢查請求中的表單資料
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String checkCode = request.getParameter("check_code");

        if (id == null || id.length() == 0) {
            errors.add("必須輸入帳號");
        }

        if (password == null || password.length() == 0) {
            errors.add("必須輸入密碼");
        }

        if (checkCode == null || checkCode.length() == 0) {
            errors.add("必須輸入檢核碼");
        } else {
            //檢查檢核碼是否符合圖片中內容
        }
        
        if (errors != null && errors.size() == 0) {
            //2. 呼叫商業邏輯
            CustomerService service = new CustomerService();
            try {
                Customer c = service.login(id, password);
                System.out.println("c:" + c);
                if (c != null) {
                    ServletContext application = this.getServletContext();
                    Integer count = (Integer)application.getAttribute("app.login.count");
                    if(count==null){
                        count=30005;
                    }else{
                        count++;
                    }                    
                    application.setAttribute("app.login.count", count);
                    
                    //3.1 產生成功回應
                    response.setContentType("text/html");
                    response.setCharacterEncoding("UTF-8");
                    try (PrintWriter out = response.getWriter();) {
                        /* TODO output your page here. You may use following sample code. */
                        out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<title>Servlet LoginServlet</title>");
                        out.println("</head>");
                        out.println("<body>");
                        out.println("<h1>" + context.getInitParameter("app-name") + "</h1>");
                        out.println("<h2>登入成功!" + c.getName() + "</h2>");
                        out.println("<p>線上人次共有: " + count + "</p>");
                        out.println("</body>");
                        out.println("</html>");
                        return;
                    }
                }
            } catch (TotalBuyException ex) {
                System.out.println("無法登入: "+ ex);
                if(ex.getCause()!=null){
                    this.log("無法登入",  ex);
                    errors.add("無法登入，請聯絡系統管理員!");
                }else{
                    errors.add(ex.getMessage());
                }
            }
        }

        //3.2 產生失敗回應
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter();) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>" + context.getInitParameter("app-name") + "</h1>");
            out.println("<p>登入失敗:" + errors + "</p>");
            out.println("<input type='button' value='回上頁' onclick='history.back();'>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}