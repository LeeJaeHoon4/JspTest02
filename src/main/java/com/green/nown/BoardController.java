package com.green.nown;

import java.io.IOException;
import java.sql.*;
import javax.naming.*;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import javax.sql.DataSource;



@WebServlet("/boards/*")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn ;
   		
	// 종료시 실행
    @Override
	public void destroy() {

				//conn.close();
	
    		System.out.println("DBCP 소멸");

	}
    //최초 실행시 실행
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		Context initContext;
		try {
			initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");// context 주소값 
			DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle/green");
			conn = ds.getConnection();
			System.out.println("Connection conn : "+ conn);
			System.out.println("JNDI방식으로 context.xml web.xml 설정후 db연결 완료");	
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

	public BoardController() {
    	System.out.println("보드 컨트롤러 생성자 실행");
 
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//db에 존재하는 board 테이블의 자료를 페이지에 로딩
		//조건을 주면 db에서 내부적으로 돌아가는 프로세스를 무시하고 전부 가져오니까 실행 속도가 빨라진다.
		String sql = "select * from board where 1=1 order by no desc";
		PreparedStatement pstmt =null ;
		String path = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//request 라이프 사이클 (request이후 response까지)스코프 안에 setAttribute를 사용하여 rs를 저장
		request.setAttribute("list", rs);
		path="/WEB-INF/views/boards/list.jsp";
		if(path!=null) {
			request.getRequestDispatcher(path).forward(request, response);;
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
