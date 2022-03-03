<%-- 
    Document   : frmUsuario
    Created on : 14/02/2022, 08:03:25 AM
    Author     : SENA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>



<!DOCTYPE html>
<html>
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario Usuarios</title>
    </head>
    <body class="bg-secondary"> 
        <section class="d-flex justify-content-center">
            
            <form:form commandName="Usuario">
                <br>
                <form:errors path="*" element="div" class="alert alert-danger"></form:errors>
                <br>
                <form:label path="nombre">Nombre Usuario</form:label>
                <form:input class="form-control" path="nombre"></form:input>
                <br>
                <form:label path="cedula">Cedula</form:label>
                <form:input class="form-control" path="cedula"></form:input>
                <br>
                <form:label path="correo">Correo</form:label>
                <form:input class="form-control" path="correo"></form:input>
                <br>
                <form:label path="telefono">Telefono</form:label>
                <form:input class="form-control" path="telefono"></form:input>
                <br>
                <form:label path="direccion">Dirección</form:label>
                <form:input class="form-control" path="direccion"></form:input>
                <br>
                <form:label path="ciudad">Ciudad</form:label>
                <form:input class="form-control" path="ciudad"></form:input>
                <br>
                <form:button name="Enviar" class="btn btn-primary my-2">Enviar</form:button>
                
                <a href="index.htm" class="btn btn-primary my-2">Regresar</a>
                <a href="listarUsuarios.htm" class="btn btn-primary my-2">ListarUsuarios</a>
                
            </form:form>
                
         </section>       
        
    </body>              
    
</html>
