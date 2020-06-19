package com.tolstun.model;

import com.tolstun.behavior.NumeralBehavior;


public class Numeral {


    public record ArabicNumeral(Integer number) {

        public RomanNumeral toRomanNumeral() {
            return NumeralBehavior.arabicToRomanProcess.apply(this);
        }
    }

    public record RomanNumeral(String numeral) {

        public ArabicNumeral toArabicNumeral() {
            return NumeralBehavior.romanToArabicProcess.apply(this);
        }
    }

}



