package tdse.parcial;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    @GetMapping("/pellseq")
    public String request(@RequestParam(value="value") int value) {

        if (value < 2){
            throw new MathException("Value must be greater than 2");
        }

        return PellSeq.generatingSequence(value);

    }

}