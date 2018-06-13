package pl.coderslab.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.entity.User;
import pl.coderslab.entity.Game;
import pl.coderslab.entity.Tag;
import pl.coderslab.repository.GameRepository;
import pl.coderslab.repository.TagRepository;
import pl.coderslab.repository.UserRepository;

@Controller
@RequestMapping("/{id}/account")
public class AccountController {

	@Autowired
	UserRepository userRep;
	@Autowired
	GameRepository gameRep;

	@Autowired
	TagRepository tagRep;
	
	
	
	@GetMapping("/profile")
	private String myAccount(@PathVariable Long id, Model model) {
		User user = userRep.findOne(id);
		model.addAttribute("user", user);
		return "user_account/myAccount";
	}
	
	@GetMapping("/suggestedGames")
	private String getSuggestedGames(@PathVariable Long id, Model model) {
		User user = userRep.findUserById(id);
		model.addAttribute("user", user);
		return "user_account/suggestedGames";
	}
	
	@GetMapping("/games")
	private String userGames(@PathVariable Long id, Model model) {
		User user = userRep.findUserById(id);
		model.addAttribute("user", user);
		return "user_account/userGames";
	}
	
	@GetMapping("/addgame")
	private String addGame(@PathVariable Long id, Model model) {
		User user = userRep.findUserById(id);
		model.addAttribute("user", user);
		return "user_account/addUserGame";
	}
	@GetMapping("/{game_id}/add")
	private String addGamePost(@PathVariable Long id, @PathVariable Long game_id, Model model) {
		
		User user = this.userRep.findUserById(id);
		List<Game> userGames = this.userRep.getUserGames(id);
		Game game = this.gameRep.findGameById(game_id);
		String message;
		model.addAttribute("user",user);
		
		for(int i=0; i<userGames.size(); i++) {
			if(userGames.get(i).getId()==game_id) {
				message = "Gra "+game.getName()+" była już wcześniej dodana do listy ulubionych.";
				model.addAttribute("message", message);
				return "user_account/myAccount";
			}
		}
		userGames.add(game);
		user.setUgames(userGames);
		this.userRep.save(user);
		message = "Gra "+game.getName()+" została dodana do Twoich ulubionych.";
		model.addAttribute("message", message);
		return "user_account/myAccount";
	}
	
	@GetMapping("/{game_id}/details")
	public String details(@PathVariable long id, @PathVariable long game_id, Model model) {
		Game game = this.gameRep.findGameById(game_id);
		User user = this.userRep.findUserById(id);
		model.addAttribute("game", game);
		model.addAttribute("user", user);
		return "user_account/gameDetails";
	}
	
	@GetMapping("/{game_id}/del")
	public String delete(@PathVariable long id, @PathVariable long game_id) {
		User user = this.userRep.findUserById(id);
		List<Game> userGames = this.userRep.getUserGames(id);
		for(int i=0; i<userGames.size(); i++) {
			if(userGames.get(i).getId()==game_id) {
				userGames.remove(userGames.get(i));
			}
		}
		user.setUgames(userGames);
		this.userRep.save(user);
		return "redirect:/"+id+"/account/games";
	}
	@GetMapping("/hobbyAdd")
	public String hobbiesAdd(@PathVariable long id, Model model) {
		User user = this.userRep.findUserById(id);
		model.addAttribute("user", user);
		return "user_account/hobbieForm";
	}
	@PostMapping("/hobbyAdd")
	public String hobbiesAddPost(@Valid User user,  BindingResult result, Model model) {
		
		User u = this.userRep.findUserById(user.getId());
		u.setHobbies(user.getHobbies());
		this.userRep.save(u);
		model.addAttribute("user", u);
		return "redirect:/"+user.getId()+"/account/hobbies";
	}
	
	@GetMapping("/hobbies")
	public String hobbies(@PathVariable long id, Model model) {
		User user = this.userRep.findUserById(id);
		model.addAttribute("user", user);
		return "user_account/hobbiesList";
	}
	@GetMapping("{hobby_id}/hobbyDelete")
	public String hobbyDelete(@PathVariable long id, @PathVariable long hobby_id, Model model) {
		User user = this.userRep.findUserById(id);
		List<Tag> hobbies = user.getHobbies();
		for(int i=0; i<hobbies.size(); i++) {
			if(hobbies.get(i).getId()==hobby_id) {
				hobbies.remove(hobbies.get(i));
			}
		}
		user.setHobbies(hobbies);
		this.userRep.save(user);
		return "redirect:/"+id+"/account/hobbies";
	}
	@GetMapping("/edit")
	public String edit(@PathVariable long id, Model model) {
		User user = this.userRep.findUserById(id);
		model.addAttribute("user", user);
		return "user_account/userForm";
	}

	@PostMapping("/edit")
	public String editPost(@PathVariable long id, Model model, @Valid User user, BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:/"+id+"/account/edit";
		}
		User u = this.userRep.findUserById(id);
		u.setFirstName(user.getFirstName());
		u.setLastName(user.getLastName());
		u.setPassword(user.getPassword());
		u.setEmail(user.getEmail());
	
		model.addAttribute("user",u);
		
		this.userRep.save(u);
		return "user_account/message";
	}
	
	@ModelAttribute("tags")
	public List<Tag> getTags(){
		return this.tagRep.findAll();
	}
	
	@ModelAttribute("games")
	public List<Game> getGames(){
	return this.gameRep.findAll();
	}
	
	@ModelAttribute("userGames")
	public List<Game> getUserGames(@PathVariable long id){
	return this.userRep.getUserGames(id);
	}
	

	@ModelAttribute("suggestedGames")
	public List<Game> getSuggestedGames(@PathVariable long id){
		User user = this.userRep.findUserById(id);
		List<Game> games = this.gameRep.findAll();
		List<Game> result = new ArrayList<>();
		List<Game> userGames = this.userRep.getUserGames(id);
		
		////Zbior wszystkich tagow od uzytkownika/////
		List<Tag> userTags = new ArrayList<>();
		for(Game game: userGames) {
			userTags.addAll(game.getTags());
		}
		userTags.addAll(user.getHobbies());
		
		//usuwanie powtorzen z uzyciem setu:
		Set<Tag> temp = new HashSet<>();
		temp.addAll(userTags);
		userTags.clear();
		userTags.addAll(temp);
		//////////////////////////////////////////////

		
		//Stworzenie posortowanej mapy po wartosci dopasowania gry
		Map<Integer,Game> gamesValues = new TreeMap<>();
		int value;
		for(Game game: games) {
			value = game.getValueOfGameAccuracy(userTags);
			if(value>0 && !game.containedByList(userGames)) { 
				gamesValues.put(value, game);
			}
		}
		
		//Przerzucenie gier z mapy do listy tak zeby nie stracily kolejnosci
		Set<Entry<Integer,Game>> entrySet = gamesValues.entrySet();
		for(Entry<Integer,Game> entry: entrySet) {
			result.add(entry.getValue()); // getValue odwołuje saię do game
		}

		//Odwrocenie kolejnosci w liscie gier, tak zeby te z najwieksza wartoscia dopasowania byly pierwsze
		Collections.reverse(result);
		return result;
	}
	
}
