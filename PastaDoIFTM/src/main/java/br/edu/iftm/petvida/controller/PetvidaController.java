package br.edu.iftm.petvida.controller;

import br.edu.iftm.petvida.model.Animal;
import br.edu.iftm.petvida.model.Tutor;
import br.edu.iftm.petvida.repository.AnimalRepository;
import br.edu.iftm.petvida.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Controller
public class PetvidaController {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private TutorRepository tutorRepository;

    @GetMapping("/ficha")
    public String ficha(Model model) {
        Animal animal = animalRepository.buscarPorId(1);
        Tutor tutor = tutorRepository.buscarPorId(animal.getIdTutor());

        model.addAttribute("animal", animal);
        model.addAttribute("tutor", tutor);
        return "ficha";
    }

    @GetMapping("/tutor")
    public String tutor(Model model) {
        Tutor tutor = tutorRepository.buscarPorId(1);
        int totalAnimais = animalRepository.contarAnimais();

        model.addAttribute("tutor", tutor);
        model.addAttribute("totalAnimais", totalAnimais);
        return "tutor";
    }

    @GetMapping("/resumo")
    public String resumo(Model model) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, d 'de' MMMM 'de' yyyy", new Locale("pt", "BR"));
        String dataAtual = LocalDateTime.now().format(formatter);

        model.addAttribute("dataAtual", dataAtual);
        model.addAttribute("totalAnimais", animalRepository.contarAnimais());
        model.addAttribute("totalTutores", tutorRepository.buscarTodos().size());
        return "resumo";
    }
}