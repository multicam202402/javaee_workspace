<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}

input[type=text], select, textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  margin-top: 6px;
  margin-bottom: 16px;
  resize: vertical;
}

input[type=button] {
  background-color: #04AA6D;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=button]:hover {
  background-color: #45a049;
}

.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
</style>
<script>
/*
자바스크립트는 언어 능력이 부족해서가 아니라, 프론트 앤드 측 기술이므로, 
소스가 노출되어 지기 때문에 db 연동을 직접하게 되면, 보안상 취약....
따라서 직접 오라클에 연동하지말고, 원하는 데이터를 서버로 전송만 하고, 서버측의 
스크립트 기술인 백앤드 기술인 jsp에게 의뢰하자~!! (즉 요청하자...)
*/
function send(){
	
}
</script>
</head>
<body>

<h3>Contact Form</h3>

<div class="container">
  <form action="/notice/글등록담당.jsp">

    <input type="text" id="fname" name="firstname" placeholder="제목입력..">
    <input type="text" id="lname" name="lastname" placeholder="작성자 입력..">
    <textarea id="subject" name="subject" placeholder="내용입력.." style="height:200px"></textarea>

    <input type="button" value="글쓰기" onClick="send()">

  </form>
</div>

</body>
</html>
