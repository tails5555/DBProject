package net.kang.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.kang.dto.Genre;
import net.kang.dto.Music;
import net.kang.mapper.GenreMapper;
import net.kang.mapper.MusicMapper;
@Controller
@RequestMapping("/genre")
public class GenreController {
	@Autowired MusicMapper musicMapper;
	@Autowired GenreMapper genreMapper;
	@RequestMapping("list")
    public String list(Model model) {
        List<Genre> genres = genreMapper.findAll();
        model.addAttribute("genres", genres);
        return "genre/list";
    }
	@RequestMapping(value="create", method=RequestMethod.GET)
    public String create(Model model) {
    	Genre genre=new Genre();
    	model.addAttribute("genre", genre);
        return "genre/edit";
    }

    @RequestMapping(value="create", method=RequestMethod.POST)
    public String create(Model model, Genre genre) {
        genreMapper.insert(genre);
        return "redirect:list";
    }

    @RequestMapping(value="edit", method=RequestMethod.GET)
    public String edit(Model model, @RequestParam("id") int id) {
        Genre genre=genreMapper.findOne(id);
        List<Music> musics=musicMapper.findByGenreId(id);
        genre.setMusics(musics);
        model.addAttribute("genre", genre);
        return "genre/edit";
    }

    @RequestMapping(value="edit", method=RequestMethod.POST)
    public String edit(Model model, Genre genre) {
        genreMapper.update(genre);
        return "redirect:list";
    }
}
