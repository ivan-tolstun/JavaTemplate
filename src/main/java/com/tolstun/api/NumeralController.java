package com.tolstun.api;

import com.tolstun.model.Numeral.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/numeral")
public class NumeralController {

    @GetMapping("/roman/{arabicNumber}")
    public String getRomannNumeral(@PathVariable Integer arabicNumber) {
        return new ArabicNumeral(arabicNumber).toRomanNumeral().numeral();
    }

    @GetMapping("/arabic/{romanNumeral}")
    public Integer getArabicNumber(@PathVariable String romanNumeral) {
        return new RomanNumeral(romanNumeral).toArabicNumeral().number();
    }
}
