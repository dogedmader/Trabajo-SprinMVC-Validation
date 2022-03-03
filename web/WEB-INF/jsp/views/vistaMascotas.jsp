<%-- 
    Document   : vistaMascotas
    Created on : 15/02/2022, 05:03:31 PM
    Author     : F&F
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        
    <body>
        
        
        <h1 style="text-align: center;">Mascotas</h1>
       <div class="panel panel-primary" style="margin: auto; width: 50%">
           <div class="panel-heading">Mascotas Registradas</div>
           <table class="table table-hover">
               
               <thead>
                   <tr>
               <th>Placa</th>
               <th>Nombre</th>
               <th>Sexo</th>
               <th>Raza</th>
               <th>Edad</th>
                   </tr>
               </thead>
           </table> 
       </div>
        
        <br>
          <c:out value="${id}" > </c:out>
          <c:out value="${placa}" > </c:out>
          <c:out value="${nombre}" > </c:out>
          <c:out value="${sexo}"> </c:out>
          <c:out value="${raza}"> </c:out>
          <c:out value="${edad}"> </c:out>
          <br>
          <a href="index.htm" class="btn btn-primary my-2">Regresar</a>
          <br>
    </body>
</html>
