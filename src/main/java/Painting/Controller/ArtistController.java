package Painting.Controller;

import Painting.Model.Artist;
import Painting.Service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("artist")
public class ArtistController {
    ArtistService artistService;
    @Autowired
    public ArtistController(ArtistService artistService){
        this.artistService = artistService;
    }
    @GetMapping("id/{id}")
    public Artist getArtistById(@PathVariable int id){
        return artistService.getArtistById(id);
    }
    @GetMapping("name/{name}")
    public Artist getArtistByName(@PathVariable String name){
        return artistService.getArtistByName(name);
    }
    @GetMapping
    public List<Artist> getAllArtists(){
        return artistService.getAllArtists();
    }
    @PostMapping
    public void saveArtist(@RequestBody Artist a){
        artistService.saveArtist(a);
    }
    @GetMapping("nameexists/{name}")
    public boolean checkArtistExistsByName(@PathVariable String name){
        return artistService.checkArtistExistsByName(name);
    }
    @GetMapping("idexists/{id}")
    public boolean checkArtistExistsById(@PathVariable int id){
        return artistService.checkArtistExistsById(id);
    }
}
