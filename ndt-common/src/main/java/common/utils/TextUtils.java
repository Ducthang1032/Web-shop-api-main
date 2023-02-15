package main.java.common.utils;

import com.tdt.cqsta.common.constants.CommonConstant;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextUtils {

    public static String replaceCompound(String text, String compound, String wordReplacement) {
        String compoundRegex = createCompoundRegex(compound);
        return text.replaceAll(compoundRegex, wordReplacement);
    }

    public static boolean containsCompound(String source, String compound) {
        String compoundRegex = createCompoundRegex(compound);
        Pattern p = Pattern.compile(compoundRegex);
        Matcher m = p.matcher(source);
        return m.find();
    }

    public static String createCompoundRegex(String compound) {
        StringBuilder compoundRegexBuilder = new StringBuilder();

        //This matches to a word boundary before the first word
        compoundRegexBuilder.append("\\b");

        // Inserts each character into the regex
        for (int i = 0; i < compound.length(); i++) {
            compoundRegexBuilder.append(compound.charAt(i));

            // Between each letter there could be any amount of whitespace
            if (i < compound.length() - 1) {
                compoundRegexBuilder.append("\\s*");
            }
        }

        // Makes sure the last word isn't part of a larger word
        compoundRegexBuilder.append("\\b");

        return compoundRegexBuilder.toString();
    }

    /**
     * @param censoredText stupid
     * @return s*upid
     */
    public static String replaceCensoredText(String censoredText) {
        if (StringUtils.isNotBlank(censoredText) && censoredText.length() >= 2)
            return censoredText.substring(0, 1).concat(CommonConstant.ASTERISK).concat(censoredText.substring(2));
        return censoredText;
    }

}
