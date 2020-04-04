<html>
<body>
<form name="form" method="post" action="Login">
<select name="Medium" id="medium" > 
 <option value="0">Choose A Medium</option> 

 <% 
     for(int i=0; i<medList.size();i++){ 
         Medium med = (Medium)medList.get(i); 
     %> 
 <option value="<%=med.getMedId()%>"><%=med.getMedName()%></option> 
 <%}%> 
 </select>
 </form>
 </body> 
</html>
