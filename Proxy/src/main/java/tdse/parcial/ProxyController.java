package tdse.parcial;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProxyController {
    

    @GetMapping("/proxy")
    public ProxyBody rellSequence(@RequestParam(value="value") int value){

        try {
            String pellSequence = ProxyConnection.startConnection("http://ec2-54-211-214-228.compute-1.amazonaws.com:6500/pellseq?value="+value);
            return new ProxyBody("Secuencia de Pell",value, pellSequence);
        } catch (IOException e) {
            System.err.println("The First Instance is Dead, tryinng the second one");
            try {
                String pellSequenceInstanceTwo = ProxyConnection.startConnection("http://ec2-13-219-73-154.compute-1.amazonaws.com:6500/pellseq?value="+value);
                return new ProxyBody("Secuencia de Pell", value, pellSequenceInstanceTwo);

            } catch (IOException i) {
                throw new ProxyException("Both instances are dead");
            }
        }
    }


}
