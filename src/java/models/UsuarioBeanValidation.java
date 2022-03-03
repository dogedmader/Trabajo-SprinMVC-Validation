/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author SENA
 */
public class UsuarioBeanValidation implements Validator{

    @Override
    public boolean supports(Class<?> type) {
       return UsuarioBean.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
    UsuarioBean Usuario = (UsuarioBean) o;
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre","required.nombre","El campo nombre es obligatorio"); 
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cedula","required.cedula","El campo cedula es obligatorio");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "correo","required.correo","El campo correo es obligatorio");  
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telefono","required.telefono","El campo telefono es obligatorio");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "direccion","required.direccion","El campo direccion es obligatorio");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ciudad","required.ciudad","El campo ciudad es obligatorio");
    
    }
    
}
