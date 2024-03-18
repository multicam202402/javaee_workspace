<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="com.oreilly.servlet.MultipartRequest"%>
<%

    /* 클라이언트가 전송한 제목, 바이너리 파일을 넘겨받아 서버의 원하는 경로에 저장하자
        = 업로드
    */
    //클라이언트가 요청을 시도하면 , 서버측에서는 이 요청을 처리하기 위한 내장객체들이
    //메모리에 생성되는데, 요청내용과 관련된 객체는 request 이고, 응답정보를구성하기 위한
    //객체는 response 객체이다 
    //요청시 전송되어온, 파라미터에 인코딩을 지정해야 한글이 깨지지 않음
    request.setCharacterEncoding("utf-8");//전송되어오는 데이터가 깨지지 않도록 처리

    //클라이언트가 multipart/form-data 형식으로 데이터를 전송할 경우 , 더이상 문자열로
    //취급해서는 안됌!!! 따라서 아래와 같은 reqest.getParameter("") 문자열을 취급하는 
    //메서드 이므로, 복합된 데이터형식인 업로드 처리를 할수 없다..
    //결론: 업로드 컴포넌트를 이용해야 한다
    //String title = request.getParameter("title"); //html에서 전송한 변수 즉 파라미터명을 기재
    //out.print("클라이언트가 전송한 제목은 "+title);

    //바이너리 파일은 자체가 String 으로 처리될 수 없기 때문에, 또한 파일도 서버에 저장
    //하는 복잡한과정을 거쳐야 하므로, 별도의 업로드 컴포넌트를 이용해야 한다..
    //String photo = request.getParameter("photo");

    //첫번째 생성자: 
    String savePath="D:/javaee_workspace/site0318/data";

    //cos.jar는 생성자 호출 만으로도 업로드 완료
    MultipartRequest multi = new MultipartRequest(request, savePath);

    //제목을 추출 , cos.jar 에서는 기존의 request의 메서드명을 유지함 
    String title = multi.getParameter("title");
    out.print("넘겨받은 제목은 "+title+"<br>");
    
    out.print("업로드 성공");
%>