package com.param;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ParamServlet
 */
// @WebServlet("/ParamServlet")
// 이 부분이 주석이 되어 있으면 web.xml에서 정의했다는 의미
public class ParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// 작동 안 되면 web.xml 19번 라인을 /ParamServlet으로 수정
	
		// 데이터
		String name = request.getParameter("name");
		// name 속성에 적힌 것을 받아오므로(not id) 주의한다.
		String temp = request.getParameter("age");
		int age = Integer.parseInt(temp);
		
		String mi;
		
		if(age>=20) {
			mi = "성인";
		}else
			mi = "미성년자";
		
		
		// 응답
		response.setContentType("text/html;charset=UTF-8");
		//response.setCharacterEncoding("UTF-8");
		// 위 두 줄 중 하나가 있어야 한글이 안 깨짐. response.getWriter() 객체 생성 전에 지정해 준다.
		PrintWriter out = response.getWriter();
		
		String str = "<html><body>저의 이름은 "+name+"이고, 나이는 "+age+"세이기 때문에 "+mi+"입니다.";
		// 자바에서 넘어가면서 깨지나봄 ㅜㅜ 역슬래시는 html 코드에는 안 들어감 
		str+="<br><button onclick = \"goBack()\">뒤로가기</button>";
		str+="<script> function goBack(){history.back()}</script>";
		str+="</body></html>";
		out.println(str);
	}


}
