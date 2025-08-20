package com.example.demo.controllers;

import com.example.demo.entities.Game;
import com.example.demo.services.GameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@Controller
@RequestMapping("/games")
public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

//    @GetMapping
//    public List<Game> getAllGames() {
//        return gameService.getAllGames();
//    }
    //crud
@GetMapping
public String list(Model model) {
    model.addAttribute("games", gameService.list());
    return "games/list";
}

    // Create form
    @GetMapping("/new")
    // @RequestParam optional - Query Paramater (Ex. Pagination)
    public String createForm(Model model) {
        model.addAttribute("game", new Game());
        model.addAttribute("formTitle", "Add Game");
        return "games/form";
    }

    // Edit form
    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("game", gameService.get(id));
        model.addAttribute("formTitle", "Edit Game");
        return "games/form";
    }

    // Save (create or update)
    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("game") Game game, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("formTitle", (game.getId() == null ? "Add" : "Edit") + " Game");
            return "games/form";
        }
        gameService.save(game);
        return "redirect:/games";
    }

    // Delete
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        gameService.delete(id);
        return "redirect:/games";
    }

}
