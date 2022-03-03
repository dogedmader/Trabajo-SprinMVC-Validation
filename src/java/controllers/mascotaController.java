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
import models.MascotasBean;
import models.MascotasBeanValidation;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author F&F
 */
public class mascotaController {
    
     private final JdbcTemplate jdbcTemplate;
     private MascotasBeanValidation validarMascotas;
     
    public mascotaController(){
        ConectarDB con = new ConectarDB();
        jdbcTemplate = new JdbcTemplate(con.conDB());
        this.validarMascotas = new MascotasBeanValidation();
    }
    
     @RequestMapping("listarMascotas.htm")
    public ModelAndView formMascotas(){
        ModelAndView mav = new ModelAndView();
        String sql = "select * from mascotas";
        List datos = jdbcTemplate.queryForList(sql);
        mav.addObject("mascotas",datos);
        mav.setViewName("views/listarMascotas");
        return mav;
    }
    
    /************insertar*********/
        @RequestMapping(value="addMascota.htm", method = RequestMethod.GET)
        public ModelAndView addmascota(){
        ModelAndView mav = new  ModelAndView();
        mav.addObject("Mascota",new MascotasBean());
        mav.setViewName("views/addMascota");
        return mav;
        }
        
        @RequestMapping(value="addMascota.htm", method = RequestMethod.POST)
        public ModelAndView addmascota(@ModelAttribute("Mascota") MascotasBean msb,
                BindingResult result, 
                SessionStatus status){
            {
        ModelAndView mav = new  ModelAndView();
        //-------------------------------------------------
        this.validarMascotas.validate(msb, result);
        
        if(result.hasErrors()){
        mav.addObject("Mascota",new MascotasBean());
        mav.setViewName("views/addMascota");
        return mav;
        }
        
        else{
        String sql = "insert into mascotas(placa, nombre, sexo, raza, edad) values(?,?,?,?,?)";
        jdbcTemplate.update(sql, msb.getPlaca() ,msb.getNombre(), msb.getSexo(), msb.getRaza(),msb.getEdad());
        mav.setViewName("redirect:/listarMascotas.htm");
        return mav;
        }
            }
        }
    
        /************borrar*********/
    
     @RequestMapping("deleteMascota.htm")
     public ModelAndView deleteMascota( HttpServletRequest req){
        ModelAndView mav = new ModelAndView();
        int id = Integer.parseInt(req.getParameter("id"));
        String sql = "delete from mascotas where id = ?";
        jdbcTemplate.update(sql, id);
        mav.setViewName("redirect:/listarMascotas.htm");
        return mav;
     }
     
        /************actualizar*********/
    
     @RequestMapping(value= "updateMascota.htm", method = RequestMethod.GET)
     public ModelAndView actMascota(HttpServletRequest req){
        ModelAndView mav = new ModelAndView();
        
        int id = Integer.parseInt(req.getParameter("id"));
        
        MascotasBean msb = consulMascotaId(id);
        
        mav.addObject("Mascota",msb);
        
        mav.setViewName("views/UpdateMascotas");
        
        return mav;
     }
     
     public MascotasBean consulMascotaId(int id){
         MascotasBean msb = new MascotasBean();
         String sql = "select * from mascotas where id = "+ id;
         return (MascotasBean)jdbcTemplate.query(
                 sql,
                 new ResultSetExtractor<MascotasBean>(){
                   @Override
                   public MascotasBean extractData(ResultSet rs) throws SQLException, DataAccessException {
                   if(rs.next()){ 
                       msb.setId(rs.getInt("id"));
                       msb.setPlaca(rs.getString("placa"));
                       msb.setNombre(rs.getString("nombre"));
                       msb.setSexo(rs.getString("sexo"));
                       msb.setRaza(rs.getString("raza"));
                       msb.setEdad(rs.getString("edad"));
                   }
                   return msb;
                   }
                 }
         );
     }
     @RequestMapping(value="updateMascota.htm", method = RequestMethod.POST)
     public ModelAndView actMascota(MascotasBean msb){
        ModelAndView mav = new ModelAndView();
        String sql = "insert into mascotas(placa, nombre, sexo, raza, edad) values(?,?,?,?,?)";
        jdbcTemplate.update(sql, msb.getPlaca() ,msb.getNombre(), msb.getSexo(), msb.getRaza(),msb.getEdad());
         
        mav.setViewName("redirect:/listarMascotas.htm");
        return mav;
     }
  
}