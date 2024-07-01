package com.example.finalexam.controller;

import com.example.finalexam.dao.*;
import com.example.finalexam.entity.Editora;
import com.example.finalexam.entity.Juegos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping(value="/api/orders")
public class JuegosController {

    @Autowired
    JuegosDao juegosDao;
    @Autowired
    DistribuidoraDao distribuidoraDao;
    @Autowired
    EditoraDao editoraDao;
    @Autowired
    PlataformaDao plataformaDao;
    @Autowired
    GeneroDao generoDao;


    //listar
    @GetMapping({"/list", "", "/"})
    public String listarJuegos(Model model) {
        model.addAttribute("listaJuegos",juegosDao.listarJuegos());
        return "/api/order/list";
    }

    //nuevo
    @GetMapping("/new")
    public String nuevoProductoFrm(@ModelAttribute("juegos") Juegos juegos, Model model) {
        model.addAttribute("listaDistribuidora", distribuidoraDao.listarDistribuidora());
        model.addAttribute("listaEditora", editoraDao.listarEditora());
        model.addAttribute("listaGenero",generoDao.listarGenero());
        model.addAttribute("listaPlataforma", plataformaDao.listarPlataforma());

        return "/api/order/form";
    }

    @PostMapping("/save")
    public String guardarJuego(@ModelAttribute("product")  Juegos juegos, BindingResult bindingResult,
                                  Model model, RedirectAttributes attr) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("listaDistribuidora", distribuidoraDao.listarDistribuidora());
            model.addAttribute("listaEditora", editoraDao.listarEditora());
            model.addAttribute("listaGenero",generoDao.listarGenero());
            model.addAttribute("listaPlataforma", plataformaDao.listarPlataforma());
            return "/api/order/form";
        } else {
            String msg = "Juego " + (juegos.getId() == 0 ? "creado" : "actualizado") + " exitosamente";
            attr.addFlashAttribute("msg", msg);
            juegosDao.guardarJuego(juegos);
            return "redirect:/juegos";
        }
    }

    @GetMapping("/edit")
    public String editarJuegos(Model model, @RequestParam("id") int id) {

        Juegos juegosBuscar = juegosDao.obtenerJuegoPorId(id);

        if (juegosBuscar != null) {
            model.addAttribute("juegos", juegosBuscar);
            model.addAttribute("listaDistribuidora", distribuidoraDao.listarDistribuidora());
            model.addAttribute("listaEditora", editoraDao.listarEditora());
            model.addAttribute("listaGenero",generoDao.listarGenero());
            model.addAttribute("listaPlataforma", plataformaDao.listarPlataforma());
            return "/api/order/form";
        } else {
            return "redirect:/juegos";
        }
    }
}
