/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import Dao.ConectarDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import models.UsuarioBean;
import models.UsuarioBeanValidation;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author SENA
 */

public class usuarioController {
    
    private JdbcTemplate jdbcTemplate;
    private UsuarioBeanValidation validarUsuario;
    
    public usuarioController(){
        ConectarDB con = new ConectarDB();
        jdbcTemplate = new JdbcTemplate(con.conDB());
        this.validarUsuario = new UsuarioBeanValidation();
    }
    
    /*********************************/
    
    @RequestMapping("listarUsuarios.htm")
    public ModelAndView formUsuario(){
        ModelAndView mav = new ModelAndView();
        String sql = "select * from personas";
        List datos = jdbcTemplate.queryForList(sql);
        mav.addObject("personas",datos);
        mav.setViewName("views/listarUsuarios");
        return mav;
    }
    /************insertar*********/
    
        @RequestMapping(value="addUsuario.htm", method = RequestMethod.GET)
        public ModelAndView addusuario(){
            ModelAndView mav = new  ModelAndView();
        mav.addObject("Usuario",new UsuarioBean());
        mav.setViewName("views/addUsuario");
        return mav;
        }
        
        @RequestMapping(value="addUsuario.htm", method = RequestMethod.POST)
        public ModelAndView addusuario(@ModelAttribute("Usuario")UsuarioBean usb,
                 BindingResult result,
                 SessionStatus status){ 
            {
            ModelAndView mav = new  ModelAndView();
            //-----------------------------------------------------
            this.validarUsuario.validate(usb, result);
            
            if(result.hasErrors()){
            mav.addObject("Usuario", new UsuarioBean());
            mav.setViewName("views/addUsuario");
            return mav;
            }
            
            else{    
                String sql = "insert into personas(nombre, correo, cedula, telefono, direccion, ciudad) values(?,?,?,?,?,?)";
                jdbcTemplate.update(sql, usb.getNombre(), usb.getCorreo(), usb.getCedula(),usb.getTelefono(), usb.getDireccion(), usb.getCiudad());
                mav.setViewName("redirect:/listarUsuarios.htm");
                return mav;
            }
        }
        }
        
        /************borrar*********/
    
     @RequestMapping("deleteUsuario.htm")
     public ModelAndView deleteUsuario( HttpServletRequest req){
        ModelAndView mav = new ModelAndView();
        int id = Integer.parseInt(req.getParameter("id"));
        String sql = "delete from personas where id = ?";
        jdbcTemplate.update(sql, id);
        mav.setViewName("redirect:/listarUsuarios.htm");
        return mav;
     }
     
        /************actualizar*********/
    
     @RequestMapping(value= "updateUsuario.htm", method = RequestMethod.GET)
     public ModelAndView actUsuario(HttpServletRequest req){
        ModelAndView mav = new ModelAndView();
        
        int id = Integer.parseInt(req.getParameter("id"));
        
        UsuarioBean usb = consulUsuarioId(id);
        
        mav.addObject("Usuario",usb);
        
        mav.setViewName("views/updateUsuario");
        
        return mav;
     }
     
     public UsuarioBean consulUsuarioId(int id){
         UsuarioBean usb = new UsuarioBean();
         String sql = "select * from personas where id = "+ id;
         return (UsuarioBean)jdbcTemplate.query(
                 sql,
                 new ResultSetExtractor<UsuarioBean>(){
                   @Override
                   public UsuarioBean extractData(ResultSet rs) throws SQLException, DataAccessException {
                   if(rs.next()){ 
                       usb.setId(rs.getInt("id"));
                       usb.setNombre(rs.getString("nombre"));
                       usb.setCedula(rs.getString("cedula"));
                       usb.setCorreo(rs.getString("correo"));
                       usb.setDireccion(rs.getString("direccion"));
                       usb.setCiudad(rs.getString("ciudad"));
                   }
                   return usb;
                   }
                 }
         );
     }
     @RequestMapping(value="updateUsuario.htm", method = RequestMethod.POST)
     public ModelAndView actUsuario(UsuarioBean usb){
        ModelAndView mav = new ModelAndView();
        String sql = "insert into personas(nombre, correo, cedula, telefono, direccion, ciudad) values(?,?,?,?,?,?)";
        jdbcTemplate.update(sql, usb.getNombre(), usb.getCorreo(), usb.getCedula(), 
                            usb.getTelefono(), usb.getDireccion(), usb.getCiudad());
        
        mav.setViewName("redirect:/listarUsuarios.htm");
        return mav;
     }
     
}