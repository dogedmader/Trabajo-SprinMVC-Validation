package controllers;

import javax.servlet.http.HttpServletRequest;
import models.MascotasBean;
import models.UsuarioBean;
import models.UsuarioBeanValidation;
import models.MascotasBeanValidation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class principalController {
    
    private UsuarioBeanValidation validarUsuario;
    private MascotasBeanValidation validarMascotas;

    public principalController() {
        this.validarUsuario = new UsuarioBeanValidation();
        this.validarMascotas = new MascotasBeanValidation();
    }
    
    @RequestMapping(value="frmUsuario.htm", method = RequestMethod.GET)
    public ModelAndView usuario(){
        return new ModelAndView("views/frmUsuario", "Usuario", new UsuarioBean() );
        }
    
    @RequestMapping(value="frmUsuario.htm", method = RequestMethod.POST)
    public ModelAndView verUsuario(
            @ModelAttribute("Usuario") UsuarioBean usuario,
            BindingResult result,
            SessionStatus status
              
    )
    {
        this.validarUsuario.validate(usuario, result);
        if(result.hasErrors()){
            ModelAndView mav = new ModelAndView();
            mav.addObject("Usuario", new UsuarioBean());
            mav.setViewName("views/frmUsuario");
            return mav;
        
        }
        else{ 
        ModelAndView mav = new ModelAndView();
        mav.setViewName("views/vistaUsuario");
        mav.addObject("nombre",usuario.getNombre());
        mav.addObject("cedula",usuario.getCedula());
        mav.addObject("correo",usuario.getCorreo());
        mav.addObject("telefono",usuario.getTelefono());
        mav.addObject("direccion",usuario.getDireccion());
        mav.addObject("ciudad",usuario.getCiudad());
        return mav;
        }
    } 
    
    
    
    /***********************************************************/
    
    
    @RequestMapping(value="frmMascotas.htm", method = RequestMethod.GET)
    public ModelAndView mascotas(){
        return new ModelAndView("views/frmMascotas", "Mascotas", new MascotasBean() );
        }
    
    @RequestMapping(value="frmMascotas.htm", method = RequestMethod.POST)
    public ModelAndView verMascotas(
            @ModelAttribute("Mascotas") MascotasBean mascotas,
            BindingResult result,
            SessionStatus status
              
    ){
        this.validarMascotas.validate(mascotas, result);
        if(result.hasErrors()){
            ModelAndView mav = new ModelAndView();
            mav.addObject("Mascotas", new MascotasBean());
            mav.setViewName("views/frmMascotas");
            return mav;
        
        }
        else{ 
        ModelAndView mav = new ModelAndView();
        mav.setViewName("views/vistaMascotas");
        mav.addObject("placa",mascotas.getPlaca());
        mav.addObject("nombre",mascotas.getNombre());
        mav.addObject("sexo",mascotas.getSexo());
        mav.addObject("raza",mascotas.getRaza());
        mav.addObject("edad",mascotas.getEdad());
        return mav;
        }
    } 
    
    
    
    /**@RequestMapping("frmUsuario.htm")
    public ModelAndView formUsuario(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("views/frmUsuario");
        return mav;
    }*/
    
    @RequestMapping("frmMascotas.htm")
    public ModelAndView formMascotas(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("views/frmMascotas");
        return mav;
         
    }
    
    @RequestMapping("login.htm")
    public ModelAndView login(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("views/login");
        return mav;
         
    }
}


    
  
    
    
    
/**      
    
    
    
    @RequestMapping("vistaUsuario.htm")
    public ModelAndView vistaUsuario(HttpServletRequest req){
        ModelAndView mav = new ModelAndView();
        
        String nom = req.getParameter("txtUsuario");
        String cd = req.getParameter("txtCedula");
        String mail = req.getParameter("txtCorreo");
        String tel = req.getParameter("txtTelefono");
        
        mav.addObject("no",nom);  
        mav.addObject("cc",cd); 
        mav.addObject("c",mail);
        mav.addObject("num",tel);  
        
        mav.setViewName("views/vistaUsuario");
        return mav;
         
    }
    
    @RequestMapping("vistaMascotas.htm")
    public ModelAndView vistaMascotas(HttpServletRequest req){
        ModelAndView mav = new ModelAndView();
        
        String plc= req.getParameter("txtPlaca");
        String nom = req.getParameter("txtNombre");
        String sex = req.getParameter("txtSexo");
        String race = req.getParameter("txtRaza");
        String age = req.getParameter("txtEdad");
        
        mav.addObject("pl",plc);   
        mav.addObject("n",nom);
        mav.addObject("sx",sex);   
        mav.addObject("rz",race);
        mav.addObject("ag",age);   
        
        mav.setViewName("views/vistaMascotas");
        return mav;
         
    }*/