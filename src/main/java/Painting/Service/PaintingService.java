package Painting.Service;

import Painting.DAO.PaintingRepository;
import Painting.Model.Artist;
import Painting.Model.Painting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PaintingService {
//    field injection (not recommended)
    @Autowired
    ArtistService artistService;
    @Autowired
    PaintingRepository paintingRepository;
//    constructor injection
    //@Autowired
    public PaintingService(ArtistService artistService, PaintingRepository paintingRepository){
        this.artistService = artistService;
        this.paintingRepository = paintingRepository;
    }
//    setter injection
//    @Autowired
    public void setArtistService(ArtistService artistService){
        this.artistService = artistService;
    }
//    chances are, if we want to add a painting to an artist, or get all paintings from an artist,
//    what we're going to end up doing is sending some identifying information about the artist we want
//    from the frontend to backend (id, name)
//    we will use that information to grab what we need
//    in this case, we will grab first the identified artist, and leverage spring ORM to grab
//    a list of paintings produced by that artist
    public List<Painting> getAllPaintingsByArtistId(int id){
        Artist a = artistService.getArtistById(id);
        return a.getPaintings();
//        the process may be the same for eg getting a user's cart items, for getting a post's comments, etc
    }
    public void savePaintingToArtistName(String name, Painting p){
        Artist a = artistService.getArtistByName(name);
        p.setArtist(a);
        paintingRepository.save(p);
    }
}
