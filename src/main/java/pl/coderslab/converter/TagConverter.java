package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.entity.Tag;
import pl.coderslab.repository.TagRepository;

public class TagConverter implements Converter<String, Tag>{
	@Autowired
	private TagRepository tagRepo;
	
	@Override
	public Tag convert(String id) {
		return this.tagRepo.findTagById(Long.parseLong(id));
	}

}
