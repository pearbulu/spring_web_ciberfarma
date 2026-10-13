package com.ciberfarma.spring_web_crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ciberfarma.spring_web_crud.util.Alert;

@Controller
public class LoginController {

	@GetMapping("/")
    public String root() {
        return "login";
    }
	
	@GetMapping("iniciar-sesion")
	public String iniciarSesion(RedirectAttributes flash) {
		String alert = Alert.sweetImageUrl("Bienvenido a Ciberfarma", "Nombre de usuario", "/imagenes/welcome-pharmacy.gif");
		flash.addFlashAttribute("alert", alert);
		return "redirect:/home/dashboard";
	}
	
	@GetMapping("cerrar-sesion")
	public String cerrarSesion() {
		return "redirect:/";
	}
}
