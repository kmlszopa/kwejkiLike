package pl.kamilszopa.controller;

import org.jcp.xml.dsig.internal.MacOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
    public String showFavs(ModelMap modelMap){
        return("favorites");
    }

    @RequestMapping("/")
    public String listGifts(ModelMap modelMap)
    {
        List<Gif> allGifs = gifRepository.getAllGifs();
        modelMap.put("gifs",allGifs);
        return "home";
    }
    @RequestMapping("/gif/{name}")
    public String gifDetails(@PathVariable String name, ModelMap modelMap){
        Gif gif = gifRepository.findByName(name);
        modelMap.put("gif",gif);
        return "gif-details";
    }
}