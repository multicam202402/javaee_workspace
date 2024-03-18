<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
table {
	border-collapse: collapse;
	border-spacing: 0;
	width: 100%;
	border: 1px solid #ddd;
}

th, td {
	text-align: left;
	padding: 16px;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
    $(function(){
        //jquery 의 syntax (구문)  :    (css선택자).어떻게()
        $("button").click(function(){
            //서버에 있는 자원을 요청하자...개발자가 아무것도 요청 방법을 지정하지 않을 경우
            //defualt는 GET방식이다 , 우리가 흔히 사용해왔던 일반 링크는 사실 GET방식 
            //요청 이었따 
            location.href="/gallery/write.jsp";
        });
    });

</script>
</head>
<body>

	<h2>Zebra Striped Table</h2>
	<p>For zebra-striped tables, use the nth-child() selector and add a
		background-color to all even (or odd) table rows:</p>

	<table>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Points</th>
		</tr>
		<tr>
			<td>Jill</td>
			<td>Smith</td>
			<td>50</td>
		</tr>
		<tr>
			<td>Eve</td>
			<td>Jackson</td>
			<td>94</td>
		</tr>
		<tr>
			<td>Adam</td>
			<td>Johnson</td>
			<td>67</td>
		</tr>

        <tr>
            <td colspan="3">
                <button>글쓰기</button>
            </td>
        </tr>
	</table>

</body>
</html>
