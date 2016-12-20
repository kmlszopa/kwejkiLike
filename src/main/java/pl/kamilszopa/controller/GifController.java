package pl.kamilszopa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pl.kamilszopa.data.GifRepository;
import pl.kamilszopa.model.Gif;

import java.util.List;

/**
 * Created by kmlsz on 09.12.2016.
 */

@Controller
public class GifController {
    @Autowired
    private GifRepository gifRepository;

    @GetMapping("/favs")
    public String showFavs(ModelMap modelMap) {

        return ("favorites");
    }

    @RequestMapping("/")
    public String listGifts(ModelMap modelMap) {
        List<Gif> allGifs = gifRepository.getAllGifs();
        modelMap.put("gifs", allGifs);
        return "home";
    }

    @RequestMapping("/gif/{name}")
    public String gifDetails(@PathVariable String name, ModelMap modelMap) {
        Gif gif = gifRepository.findByName(name);
        modelMap.put("gif", gif);
        return "gif-details";
    }

    @GetMapping("/favorites")
    public String gifFavorites(ModelMap modelMap) {
        List<Gif> favoritesGifs = gifRepository.findByFavorites();
        modelMap.addAttribute("gifs", favoritesGifs);
        return "results";
    }

    @GetMapping("search")
    public String search(@RequestParam(value = "q") String name, ModelMap modelMap) {
        List<Gif> searchedGifs = gifRepository.findByChars(name);
        modelMap.addAttribute("gifs", searchedGifs);
        return "results";
    }

    @GetMapping("addGif")
    public String addGif(ModelMap modelMap){
        return "addForm";
    }
}