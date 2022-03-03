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
public class addMascotaValidation implements Validator{
    
    @Override
    public boolean supports(Class<?> type) {
       return MascotasBean.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
    MascotasBean Mascota = (MascotasBean) o;
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "placa","require.placa","El campo placa es obligatorio"); 
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre","require.nombre","El campo nombre es obligatorio");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sexo","require.sexo","El campo sexo es obligatorio");  
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "raza","require.raza","El campo raza es obligatorio");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "edad","require.edad","El campo edad es obligatorio");
    
    }
}
