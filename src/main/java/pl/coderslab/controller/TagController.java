package pl.coderslab.controller;

import java.util.List;

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
import pl.coderslab.entity.User;
import pl.coderslab.repository.TagRepository;

@Controller
@RequestMapping("/tags")
public class TagController {
	
	@Autowired
	TagRepository tagRepo;
	
	
	@GetMapping("/list")
	public String list() {
		return "admin_tags/tagList";
	}
	
	@GetMapping("/form")
	public String form(Model model) {
		model.addAttribute("tag", new Tag());
		return "admin_tags/tagForm";
	}
	@PostMapping("/form")
	public String formPost(@Valid Tag tag, BindingResult result) {
		if (result.hasErrors()) {
			return "admin_tags/tagForm";
		}
		this.tagRepo.save(tag);
		return "redirect:/tags/list";
	}
	@GetMapping("/{id}/delete")
	public String delete(@PathVariable Long id) {
		Tag tag = this.tagRepo.findTagById(id);
		this.tagRepo.delete(tag);
		return "redirect:/tags/list";
	}
	@GetMapping("/{id}/edit")
	public String edit(@PathVariable Long id, Model model) {
		Tag tag= this.tagRepo.findTagById(id);
		model.addAttribute("tag", tag);
		return "admin_tags/tagForm";
	}
	@PostMapping("/{id}/edit")
	public String editPost(@Valid Tag tag, BindingResult result) {
		if (result.hasErrors()) {
			return "admin_tags/tagForm";
		}
		this.tagRepo.save(tag);
		return "redirect:/tags/list";
	}
	@ModelAttribute("tags")
	public List<Tag> getTags() {
		return this.tagRepo.findAll(new Sort(Sort.Direction.ASC, "name"));
	}
	
	
	
}
