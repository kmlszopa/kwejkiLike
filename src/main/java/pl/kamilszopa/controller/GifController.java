package pl.kamilszopa.controller;

import com.sun.org.apache.xpath.internal.operations.Mult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.kamilszopa.data.GifRepository;
import pl.kamilszopa.model.Gif;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
        List<Gif> allGifs = gifRepository.getAll();
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

    @GetMapping("/search")
    public String search(@RequestParam(value = "q") String name, ModelMap modelMap) {
        List<Gif> searchedGifs = gifRepository.findByChars(name);
        modelMap.addAttribute("gifs", searchedGifs);
        return "results";
    }

    @GetMapping("addGif")
    public String addGif() {
        return "addForm";
    }

    @PostMapping("addedgif")
    public String added(@RequestParam("file") MultipartFile file, @RequestParam("title") String name) {
        if (!file.isEmpty()) {
            try {
                String filename = "src/main/resources/static/gifs/" + file.getOriginalFilename();
                byte[] bytes = file.getBytes();
                File fsFile = new File(filename);
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(fsFile));
                stream.write(bytes);
                stream.close();

            } catch (Exception e) {

            }
        }
        Gif gif = new Gif();
        gif.setName(file.getOriginalFilename());
        gifRepository.save(gif);
        return "home";
    }


}
