/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.totalbuy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uuu.totalbuy.domain.BloodType;
import uuu.totalbuy.domain.Customer;
import uuu.totalbuy.model.CustomerService;

/**
 *
 * @author PattyTai
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/register.do"})
public class RegisterServlet extends HttpServlet {

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
        List<String> errors = new ArrayList<>();
        
        request.setCharacterEncoding("UTF-8");
        //1. 取得並檢查register.html中的表單資料
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        String gender = request.getParameter("gender");
        //System.out.println("gender: " + gender);
        String email = request.getParameter("email");
        String checkCode = request.getParameter("check_code");
        String birthday = request.getParameter("birthday");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String married = request.getParameter("married");
        String bloodType = request.getParameter("blood_type");        
        
        if (id == null || (id = id.trim()).length() == 0) {
            errors.add("必須輸入會員帳號");
        }

        if (name == null || (name = name.trim()).length() == 0) {
            errors.add("必須輸入會員姓名");
        }

        if (password1 == null || (password1 = password1.trim()).length() == 0
                || password2 == null || (password2 = password2.trim()).length() == 0) {
            errors.add("必須輸入會員密碼與確認密碼");
        } else if (!password1.equals(password2)) {
            errors.add("必須會員密碼與確認密碼必須一致且大小寫相符");
        }

        if (gender == null || (gender = gender.trim()).length() == 0) {
            errors.add("必須輸入會員性別");
        }

        if (email == null || (email = email.trim()).length() == 0) {
            errors.add("必須輸入電子郵件");
        }

        if (checkCode == null || (checkCode = checkCode.trim()).length() == 0) {
            errors.add("必須輸入驗證碼");
        } else {
            //....
        }

        if (errors.size() == 0) {
            //2. 執行商業邏輯
            try {
                Customer c = new Customer();
                c.setId(id);
                c.setName(name);
                c.setPassword(password1);
                c.setGender(gender.charAt(0));
                c.setEmail(email);
                
                c.setBirthday(birthday);
                c.setPhone(phone);
                c.setAddress(address);
                c.setMarried(married!=null);
                c.setBloodType(
                       bloodType==null || bloodType.length()==0?null:BloodType.valueOf(bloodType));
                
                
                CustomerService service = new CustomerService();
                service.register(c);

                //3.1 產生成功回應
                response.setContentType("text/html");
                response.setCharacterEncoding("UTF-8");
                try (PrintWriter out = response.getWriter()) {
                    /* TODO output your page here. You may use following sample code. */
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Servlet RegisterServlet</title>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>" + this.getServletContext().getInitParameter("app-name") + "</h1>");
                    out.println("<h2>註冊成功: " + c + "</h2>");
                    out.println("</body>");
                    out.println("</html>");
                    return;
                }
            } catch (Exception ex) {
                errors.add(ex.toString());
            }
        }

        //3.2 產生錯誤回應
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegisterServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>" + this.getServletContext().getInitParameter("app-name") + "</h1>");
            out.println("<p>註冊失敗: " + errors + "</p>");
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
