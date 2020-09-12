package kr.co.softcampus.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.softcampus.model.Test2Service;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("*.mvc")
public class HomeController extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String url = request.getRequestURI();
        //view로 사용할 jsp
        String viewNmae = null;
        System.out.println(request);
        if(url.contains("main.mvc")) {
            viewNmae = "main.jsp";
            //System.out.println("main 요청");
        }else if(url.contains("test1.mvc")) {
        	//파라미터 데이터 추출
        	String str1 = request.getParameter("data1");
        	String str2 = request.getParameter("data2");
        	int number1 = Integer.parseInt(str1);
        	int number2 = Integer.parseInt(str2);
        	int result = number1 + number2;
        	viewNmae = "test1.jsp";
        	request.setAttribute("result", result);
        	
            //System.out.println("test1 요청");
        }else if(url.contains("test2.mvc")) {
        	viewNmae = "test2.jsp";
        	
            //모델 요청
        	int result = Test2Service.minus(request);
        	request.setAttribute("result", result);
        }
        
        RequestDispatcher dis = request.getRequestDispatcher(viewNmae);
        dis.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
