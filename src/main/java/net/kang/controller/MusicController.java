
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
@RequestMapping("/music")
public class MusicController {
	@Autowired MusicMapper musicMapper;
	@Autowired GenreMapper genreMapper;
	@RequestMapping("list")
    public String list(Model model) {
        List<Music> musics = musicMapper.findAll();
        model.addAttribute("musics", musics);
        return "music/list";
    }

    @RequestMapping(value="create", method=RequestMethod.GET)
    public String create(Model model) {
    	Music music=new Music();
    	List<Genre> genres=genreMapper.findAll();
    	model.addAttribute("music", music);
    	model.addAttribute("genres", genres);
        return "music/edit";
    }

    @RequestMapping(value="create", method=RequestMethod.POST)
    public String create(Model model, Music music) {
        musicMapper.insert(music);
        return "redirect:list";
    }

    @RequestMapping(value="edit", method=RequestMethod.GET)
    public String edit(Model model, @RequestParam("id") int id) {
        Music music=musicMapper.findOne(id);
        List<Genre> genres=genreMapper.findAll();
        model.addAttribute("music", music);
        model.addAttribute("genres", genres);
        return "music/edit";
    }

    @RequestMapping(value="edit", method=RequestMethod.POST)
    public String edit(Model model, Music music) {
        musicMapper.update(music);
        return "redirect:list";
    }

    @RequestMapping("delete")
    public String delete(Model model, @RequestParam("id") int id) {
        musicMapper.delete(id);
        return "redirect:list";
    }

}
