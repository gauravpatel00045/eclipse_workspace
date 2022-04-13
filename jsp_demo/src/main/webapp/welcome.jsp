<%   
String name=request.getParameter("uname");  
out.print("welcome "+name);  
%> 

<%   
String websiteName=request.getParameter("web_name");  
response.sendRedirect(websiteName);  
%>  