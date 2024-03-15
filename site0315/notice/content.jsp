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


//자바스크립트는 db연동을 직접 수행할 수 없으므로, 서버측에 삭제를 요청하자
function del(){
	//서버측의 삭제를 담당하는 jsp에게 요청을 시도 
	location.href="/notice/del.jsp";
}

</script>
</head>
<body>

<h3>글 상세보기</h3>

<div class="container">
  <form id="form1">
	<!--
	id 와 name  공통점: 문서내의 요소를 구분하기 위한 용도
	차이점 : name은 중복을 허용하고 + 서버에 전송시 전송 파라미터 역할까지 수행
				즉  http 상의 전송 시 데이터를 실어 나르는 변수 역할을 수행
	-->
    <input type="text" name="title" placeholder="제목입력..">
    <input type="text" name="writer" placeholder="작성자 입력..">
    <textarea name="content" placeholder="내용입력.." style="height:200px"></textarea>

    <input type="button" value="수정하기" onClick="">
	<input type="button" value="삭제하기" onClick="del();">
	<input type="button" value="목록보기" onClick="location.href='/notice/list.jsp'">

  </form>
</div>

</body>
</html>
