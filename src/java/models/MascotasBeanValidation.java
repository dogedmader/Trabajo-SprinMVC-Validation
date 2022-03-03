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
 * @author F&F
 */
public class MascotasBeanValidation implements Validator{
    
    @Override
    public boolean supports(Class<?> type) {
       return MascotasBean.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
    MascotasBean Mascota = (MascotasBean) o;
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "placa","required.placa","El campo placa es obligatorio"); 
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre","required.nombre","El campo nombre es obligatorio");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sexo","required.sexo","El campo sexo es obligatorio");  
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "raza","required.raza","El campo raza es obligatorio");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "edad","required.edad","El campo edad es obligatorio");
    
    }
    
}
