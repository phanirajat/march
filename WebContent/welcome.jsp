<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <script>
   $(document).click(function(){
        if(typeof timeOutObj != "undefined") {
            clearTimeout(timeOutObj);
        }

        timeOutObj = setTimeout(function(){ 
            localStorage.clear();
            window.location = "/";
        }, 12);   //will expire after twenty minutes

   });
</script>
	<%
	String name = (String)session.getAttribute("uname");
	if(name != null){
	%>
	<h1>
	<%=name%>
	</h1>
    <%}
	else 
		request.getRequestDispatcher("\register.jsp").forward(request, response);
    %>
    
</body>
</html>