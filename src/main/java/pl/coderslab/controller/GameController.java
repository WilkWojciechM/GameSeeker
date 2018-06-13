package pl.coderslab.controller;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.coderslab.entity.Game;
import pl.coderslab.entity.Tag;
import pl.coderslab.repository.GameRepository;
import pl.coderslab.repository.TagRepository;

@Controller
@RequestMapping("/games")
public class GameController {

	@Autowired
	GameRepository gameRepo;
	@Autowired
	TagRepository tagRepo;

	@GetMapping("/list")
	public String list() {
		return "admin_games/gameList";

	}
	
	@GetMapping("/form")
	public String form(Model model) {
		model.addAttribute("game", new Game());
		return "admin_games/gameAddForm";
	}

	@PostMapping("/form")
	public String formPost(@Valid Game game, BindingResult result) {
		if (result.hasErrors()) {
			return "admin_games/gameAddForm";
		}
		
		this.gameRepo.save(game);
		return "redirect:/games/list";
	}

	@GetMapping("/{id}/edit")
	public String edit(@PathVariable Long id, Model model) {
		Game game = this.gameRepo.findGameById(id);
		model.addAttribute("game", game);
		return "admin_games/gameAddForm";
	}

	@PostMapping("/{id}/edit")
	public String editPost(@PathVariable Long id, @Valid Game game, BindingResult result) {
		if (result.hasErrors()) {
			return "admin_games/gameAddForm";
		}
		Game g = this.gameRepo.findGameById(id);
		g.setCouchCoop(game.isCouchCoop());
		g.setCreated(game.getCreated());
		g.setDescription(game.getDescription());
		g.setHardwareRequirements(game.getHardwareRequirements());
		g.setImageUrl(game.getImageUrl());
		g.setLanguage(game.getLanguage());
		g.setMovieUrl(game.getMovieUrl());
		g.setMultiplayer(game.isMultiplayer());
		g.setName(game.getName());
		g.setPEGI(game.getPEGI());
		g.setPrice(game.getPrice());
		g.setTags(game.getTags());
		this.gameRepo.save(g);
		return "redirect:/games/list";
	}

	@GetMapping("/{id}/delete")
	public String delete(@PathVariable Long id) {
		Game game = this.gameRepo.findGameById(id);
		this.gameRepo.delete(game);
		return "redirect:/games/list";
	}
	
	@ModelAttribute("games")
	public List<Game> getGames() {
		return this.gameRepo.findAll(new Sort(Sort.Direction.ASC, "name"));
	}
	

	@ModelAttribute("tags")
	public List<Tag> getTags(){
	return this.tagRepo.findAll();
	}
	

	@ModelAttribute("PEGI")
	public List<String> getPEGI() {
		List<String> list = new ArrayList<>();
		list.add("3");
		list.add("7");
		list.add("12");
		list.add("16");
		list.add("18");

		return list;
	}

	@ModelAttribute("language")
	public List<String> getLangugage() {
		List<String> list = new ArrayList<>();
		list.add("polish");
		list.add("english");
		list.add("french");
		list.add("german");
		list.add("spanish");

		return list;
	}

}
