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
public class addUsuariosBeanValidation implements Validator {
    
    @Override
    public boolean supports(Class<?> type) {
       return UsuarioBean.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
    UsuarioBean Cliente = (UsuarioBean) o;
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre","require.nombre","El campo nombre es obligatorio"); 
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cedula","require.cedula","El campo cedula es obligatorio");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "correo","require.correo","El campo correo es obligatorio");  
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telefono","require.telefono","El campo telefono es obligatorio");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "direccion","require.direccion","El campo direccion es obligatorio");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ciudad","require.ciudad","El campo ciudad es obligatorio");
    
    }
}
