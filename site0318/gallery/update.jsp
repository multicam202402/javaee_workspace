<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@ page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@ page import="java.io.File"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.commons.fileupload.FileItem"%>
<%
    /*
    클라이언트가 전송한 복합형 데이터(multipart)를 넘겨받아, 수정을 처리... 
    이미지가 넘어온 경우는 기존 파일 삭제 ,새롭게 등록 + db 업데이트 
    이미지가 넘어오지 않았다면, 즉 파일 업로드의 의사가 없기 때문에 db 만 업데이트
    */
    
    DiskFileItemFactory factory = new DiskFileItemFactory();
    int maxSize = 1*1024*1024;
    String savePath = "D:/javaee_workspace/site0318/data/";

    factory.setSizeThreshold(maxSize); //용량 제한 
    factory.setRepository(new File(savePath)); //저장 경로

    //업로드 처리 객체 생성 
    ServletFileUpload upload = new ServletFileUpload(factory); //설정 적용

    //업로드된 데이터 분석 (parse)
    List<FileItem> itemList = upload.parseRequest(request); //내장 객체를 인수로 넣어주면, 업로드 내용 분석 

    //리스트에 채워진 각 FileItem 들을 꺼내서 정보를 사용해보자 
    String title=null;
    String writer=null;
    String content=null;
    String filename=null;
    int gallery_idx=0;

    for(FileItem item  : itemList){
        if(item.isFormField()){//일반 텍스트 데이터와 (input type='text'라면..)
            if(item.getFieldName().equals("title")){//제목이라면...
                title = item.getString("utf-8");
            }else if(item.getFieldName().equals("writer")){//작성자라면...
                writer = item.getString("utf-8");
            }else if(item.getFieldName().equals("content")){//내용이라면...
                content = item.getString("utf-8");
            }else if(item.getFieldName().equals("filename")){//파일명이라면..
                filename=item.getString("utf-8");
            }else if(item.getFieldName().equals("gallery_idx")){//idx라면..
                gallery_idx=Integer.parseInt(item.getString("utf-8"));
            }
        }else{//바이너리 파일 데이터..(input type='file' 이라면...)
            
        }
    }

    //수정 쿼리 
    //String sql="update gallery set title=? , writer=? , content=? , filename=?";
    //sql+="  where gallery_idx=내가지금보고있는글idx";

    String sql="update gallery set title='"+title+"', writer='"+writer+"', content='"+content+"', filename='"+filename+"'";
    sql+="  where gallery_idx="+gallery_idx;

    out.print(sql);
%>