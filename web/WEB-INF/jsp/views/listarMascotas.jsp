<%-- 
    Document   : listarMascotas
    Created on : 28/02/2022, 05:20:20 PM
    Author     : F&F
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
       <h1 style="text-align: center;">Mascotas</h1>
       <div class="panel panel-primary" style="margin: auto; width: 50%">
           <div class="panel-heading"></div>
           <table class="table table-hover">
               
               <thead>
                   <tr>
               <th>Id</th>
               <th>Placa</th>
               <th>Nombre</th>
               <th>Sexo</th>
               <th>Raza</th>
               <th>Años</th>
               <th>opciones</th>
                   </tr>
               </thead>
       
       </div>
       
       <c:forEach items="${mascotas}" var="mascotas">
      
   <tr class="text-center">
        <td> <c:out value="${mascotas.id}" > </c:out> </td>
        <td> <c:out value="${mascotas.placa}" > </c:out> </td>
        <td> <c:out value="${mascotas.nombre}" > </c:out> </td>
        <td> <c:out value="${mascotas.sexo}" > </c:out> </td>
        <td> <c:out value="${mascotas.raza}" > </c:out> </td>
        <td> <c:out value="${mascotas.edad}" > </c:out> </td>
        
        
        <td> <a href="addMascota.htm" class="btn btn-primary my-2">Añadir Mascota</a></td>
        
        <td> <a href="deleteMascota.htm?id=${mascotas.id}"class="btn btn-danger my-2">Borrar mascota</a></td>
        
        <td> <a href="updateMascota.htm?id=${mascotas.id}"class="btn btn-warning my-2">Actualizar mascota</a></td>
        
    </tr>
        </c:forEach>
         <a href="index.htm" class="btn btn-primary my-2">Regresar</a>
        
        <br>
            </table> 
    </body>
</html>
