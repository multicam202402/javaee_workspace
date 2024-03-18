<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@ page import="java.io.File"%>
<%@ page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.commons.fileupload.FileItem"%>
<%
    //클라이언트가 전송한 텍스트와 바이너리가 합쳐진 상태이므로, 기존의 request객체만으로
    //는 업로드를 처리할 수 없다.. 왜? request.getParameter() 텍스트 데이터만 처리가능..
    //결론) 업로드 컴포넌트를 이용해야 함 (Apache Fileupload )

    //업로드와 관련된 설정 정보를 담당하는 객체 
    DiskFileItemFactory factory=new DiskFileItemFactory();

    //용량 제한 
    int maxSize = 1*1024*1024; //1M byte
    factory.setSizeThreshold(maxSize);

    //저장 경로
    factory.setRepository(new File("D:/javaee_workspace/site0318/data"));


    //업로드를 처리하는 객체인 ServletFileUpload 객체를 생성하면서 설정 정보 객체를 
    //생성자의 매개변수로 넘기자 
    ServletFileUpload upload=new ServletFileUpload(factory);

    //업로드 처리 (업로드 된 내용 분석)
    //reqeust 내장객체를 매개변수로 넣으면 업로드된 요청을 분석하여, html의 모든 
    //컴포넌트들을 FileItem 라는 객체로 받게 됨..
    List<FileItem> itemList=upload.parseRequest(request); 

    //각 아이템에 담겨진 데이터를 끄집어 내자 
    for( FileItem item : itemList){
        if(item.isFormField()){ //텍스트 박스라면...
            out.print(item.getString("utf-8")+"<br>"); //text 박스의 값을 추출하는 메서드..
        }else{
            //반복문 내에 섞여 있는 FileItem 중, 바이너리 파일을 골라내어 , 서버에 저장처리..
            out.print("파일명은 "+item.getName()+"<br>"); //파일의 이름을 추출 
        }
    }

%>