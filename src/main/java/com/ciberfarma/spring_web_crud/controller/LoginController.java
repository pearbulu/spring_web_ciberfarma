package com.ciberfarma.spring_web_crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ciberfarma.spring_web_crud.dto.AutenticacionFilter;
import com.ciberfarma.spring_web_crud.service.AutenticacionService;
import com.ciberfarma.spring_web_crud.util.Alert;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LoginController {

	private final AutenticacionService autenticacionService;

	@GetMapping("/")
	public String root(Model model) {
		model.addAttribute("filter", new AutenticacionFilter(null, null));
		return "login";
	}

	@GetMapping("iniciar-sesion")
	public String iniciarSesion(@ModelAttribute AutenticacionFilter filter, RedirectAttributes flash,
			HttpSession session) {

		var usuario = autenticacionService.autenticathe(filter);

		// validamos usuario existente
		if (usuario == null) {
			var alert = Alert.sweetAlertError("Cuenta y/o clave inválidos");
			flash.addFlashAttribute("alert", alert);
			return "redirect:/";
		}

		// validamos usuario si está activo
		if (!usuario.getActivo()) {
			var alert = Alert.sweetAlertError("Usuario inactivado, comunicarse con soporte");
			flash.addFlashAttribute("alert", alert);
			return "redirect:/";
		}

		session.setAttribute("fullName", usuario.getFullName());
		session.setAttribute("idTipo", usuario.getTipo().getIdTipo());

		String routeImage = "/imagenes/welcome-pharmacy.gif";
		String alert = Alert.sweetImageUrl("Bienvenido a Ciberfarma", usuario.getFullName(), routeImage);
		flash.addFlashAttribute("alert", alert);
		return "redirect:/home/dashboard";
	}

	@GetMapping("cerrar-sesion")
	public String cerrarSesion(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
