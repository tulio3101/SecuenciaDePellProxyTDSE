package tdse.parcial;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProxyController {
    

    @GetMapping("/proxy")
    public ProxyBody rellSequence(@RequestParam(value="value") int value) throws IOException{

        String pellSequence = ProxyConnection.startConnection("http://localhost:6500/pellseq?value="+value);

        return new ProxyBody("Secuencia de Pell",value, pellSequence);

    }


}
