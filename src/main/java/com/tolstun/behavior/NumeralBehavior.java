package com.tolstun.behavior;

import com.tolstun.model.Numeral.ArabicNumeral;
import com.tolstun.model.Numeral.RomanNumeral;
import com.tolstun.statics.RomanNumeralType;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumeralBehavior {


    static public final ArabicToRomanFunction arabicToRomanProcess = (final ArabicNumeral arabicNumeral) -> {

        Integer changeableNumber = arabicNumeral.number();
        var romanNumeral = new StringBuilder();

        var romanTemplateNumerals = Stream
                .of(RomanNumeralType.values())
                .sorted(Comparator.comparing(RomanNumeralType::getValue).reversed())
                .collect(Collectors.toList());

        for (var romanTemplate : romanTemplateNumerals) {
            while (romanTemplate.getValue() <= changeableNumber) {
                romanNumeral.append(romanTemplate.name());
                changeableNumber -= romanTemplate.getValue();
            }
        }
        return new RomanNumeral(romanNumeral.toString());
    };


    static public final RomanToArabicFunction romanToArabicProcess = (final RomanNumeral romanNumeral) -> {

        var arabicNumber = romanNumeral.numeral()
                .toUpperCase()
                .chars()
                .parallel()
                .mapToObj(Character::toString)
                .flatMap(
                        itemRomanNumeral -> Stream
                                .of(RomanNumeralType.values())
                                .filter(romanTemplate -> romanTemplate.name().equals(itemRomanNumeral))
                                .findFirst()
                                .stream()
                )
                .mapToInt(RomanNumeralType::getValue)
                .sum();

        return new ArabicNumeral(arabicNumber);
    };


    @FunctionalInterface
    public interface ArabicToRomanFunction {
        RomanNumeral apply(final ArabicNumeral arabicNumeral);
    }


    @FunctionalInterface
    public interface RomanToArabicFunction {
        ArabicNumeral apply(final RomanNumeral romanNumeral);
    }

}
