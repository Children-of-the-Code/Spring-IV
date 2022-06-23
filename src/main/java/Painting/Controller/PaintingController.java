package Painting.Controller;

import Painting.Model.Painting;
import Painting.Service.PaintingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("painting")
public class PaintingController {
    /*
    Changes are happening
     */
    PaintingService paintingService;
    @Autowired
    public PaintingController(PaintingService paintingService){
        this.paintingService = paintingService;
    }
    @GetMapping({"id"})
    public List<Painting> getAllPaintingsByArtistId(@PathVariable int id){
        return paintingService.getAllPaintingsByArtistId(id);
    }
    @PostMapping({"name"})
    public void savePaintingToArtistName(@PathVariable String name, @RequestBody Painting p){
        paintingService.savePaintingToArtistName(name, p);
    }

    public String SomeMethod(){
//        some method
        return "String";
    }
}
