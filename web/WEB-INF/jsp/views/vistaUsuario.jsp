<%-- 
    Document   : vistaUsuario
    Created on : 14/02/2022, 09:59:11 AM
    Author     : SENA
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> 
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <%---- nombre: <% String nombre = (String)request.getAttribute("n"); %>
        <%= nombre %>
        
        <br>
        
        correo: <% String correo = (String)request.getAttribute("c"); %>
        <%= correo %>
        ------%>
       <h1 style="text-align: center;">Usuarios</h1>
       <div class="panel panel-primary" style="margin: auto; width: 50%">
           <div class="panel-heading">Usuarios Registrados</div>
           <table class="table table-hover">
               
               <thead>
                   <tr>
               <th>Id</th>
               <th>Nombre</th>
               <th>Cedula</th>
               <th>Correo</th>
               <th>Telefono</th>
                   </tr>
               </thead>
           </table> 
       </div>
       
         <br>
          <c:out value="${id}" > </c:out>
          <br>
          <c:out value="${nombre}" > </c:out>
          <br>
          <c:out value="${cedula}" > </c:out>
          <br>
          <c:out value="${correo}"> </c:out>
          <br>
          <c:out value="${telefono}"> </c:out>
          <br>
          <c:out value="${direccion}"> </c:out>
          <br>
          <c:out value="${ciudad}"> </c:out>
         <br>
        
        <a href="index.htm" class="btn btn-primary my-2">Regresar</a>
         
        <br>
    </body>
</html>
