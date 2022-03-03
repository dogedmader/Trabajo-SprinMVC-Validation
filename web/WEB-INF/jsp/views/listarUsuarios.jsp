<%-- 
    Document   : listarUsuarios
    Created on : 24/02/2022, 07:32:48 AM
    Author     : SENA
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    
    

<html>
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
           <div class="panel-heading"></div>
           <table class="table table-hover">
               
               <thead>
                   <tr>
               <th>Id</th>
               <th>Nombre</th>
               <th>Correo</th>
               <th>Cedula</th>
               <th>Telefono</th>
               <th>Direccion</th>
               <th>Ciudad</th>
               <th>opciones</th>
                   </tr>
               </thead>
       
       </div>
       
       <c:forEach items="${personas}" var="personas">
      
   <tr class="text-center">
           <td> <c:out value="${personas.id}" > </c:out> </td>
          <td>  <c:out value="${personas.nombre}" > </c:out> </td>
        <td>    <c:out value="${personas.correo}" > </c:out> </td>
        <td>    <c:out value="${personas.cedula}" > </c:out> </td>
         <td>   <c:out value="${personas.telefono}" > </c:out> </td>
        <td>    <c:out value="${personas.direccion}" > </c:out> </td>
        <td>    <c:out value="${personas.ciudad}" > </c:out> </td>
        
        
        <td> <a href="addUsuario.htm" class="btn btn-primary my-2">Añadir usuario</a></td>
        
        <td> <a href="deleteUsuario.htm?id=${personas.id}"class="btn btn-danger my-2">Borrar usuario</a></td>
        
        <td> <a href="updateUsuario.htm?id=${personas.id}"class="btn btn-warning my-2">Actualizar usuario</a></td>
        
    </tr>
        </c:forEach>
         <a href="index.htm" class="btn btn-primary my-2">Regresar</a>
        
        <br>
            </table> 
    </body>
</html>
