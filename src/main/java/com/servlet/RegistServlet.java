package com.servlet;

import com.util.GetConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //设置请求编码、响应方式和编码方式
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        List<String> usernameList = new ArrayList<>();
        String registerName = request.getParameter("username");
        String registerPassword = request.getParameter("password");
        String registerRepeatpsd = request.getParameter("repeatPsd");
        String gender = request.getParameter("gender");

        try (Connection conn = new GetConnection().getConnection()) {
            System.out.println("Database connection: " + (conn != null));
            if (registerPassword.equals(registerRepeatpsd)) {
                //遍历tb_user表中username字段
                String select = "SELECT username FROM tb_user";
                try (Statement st = conn.createStatement();
                     ResultSet rs = st.executeQuery(select)) {

                    while (rs.next()) {
                        usernameList.add(rs.getString("username"));
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                    out.println("查询用户时发生错误，请稍后再试。错误信息：" + e.getMessage());
                    return;
                }

                if (usernameList.contains(registerName)) {
                    out.println("用户名已注册，请重新尝试。");
                } else {
                    String insert = "INSERT INTO tb_user(username,password,gender) VALUES(?,?,?)";
                    try (PreparedStatement ptst = conn.prepareStatement(insert)) {
                        ptst.setString(1, registerName);
                        ptst.setString(2, registerPassword);
                        ptst.setString(3, gender);
                        ptst.executeUpdate();
                        out.println("欢迎注册。");
                    } catch (SQLException e) {
                        e.printStackTrace();
                        out.println("注册时发生错误，请稍后再试。错误信息：" + e.getMessage());
                    }
                }
            } else {
                out.println("两次密码输入不一致，请重新尝试。");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            out.println("数据库连接失败，请稍后再试。错误信息：" + e.getMessage());
        }

        out.flush();
        out.close();
    }
}
