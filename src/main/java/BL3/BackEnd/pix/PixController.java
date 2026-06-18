package BL3.BackEnd.pix;

import BL3.BackEnd.pix.dto.CreateChavePix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pix")
// isso aqui em baixo serve por ser um projeto local
@CrossOrigin(origins = "*")
public class PixController {

    private PixService pixService;

    @Autowired
    public PixController(PixService pixService) {
        this.pixService = pixService;
    }

    @PostMapping
    public ResponseEntity createPix(@RequestBody CreateChavePix createChavePix){
        pixService.createPix(createChavePix);
        return ResponseEntity.ok().build();
    }



    @GetMapping("{idUser}")
    public ResponseEntity getAllByUser(@PathVariable int idUser){
        List<CreateChavePix> chaves = pixService.getAllKeys(idUser);
        return ResponseEntity.ok(chaves);
    }

}
