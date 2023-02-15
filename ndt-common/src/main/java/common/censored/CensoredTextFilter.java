package main.java.common.censored;

import com.hankcs.algorithm.AhoCorasickDoubleArrayTrie;
import com.tdt.cqsta.common.constants.CommonConstant;
import com.tdt.cqsta.common.constants.RegexConstants;
import com.tdt.cqsta.common.utils.TextUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class CensoredTextFilter {

    private static Logger log = LoggerFactory.getLogger(CensoredTextFilter.class);
    private AhoCorasickDoubleArrayTrie<String> dictionary = new AhoCorasickDoubleArrayTrie<>();
    private List<AhoCorasickDoubleArrayTrie<String>.Hit<String>> badWordList = new ArrayList<>();
    private Map<String, String> badWordsCompounds = new HashMap<>();

    public CensoredTextFilter() {
        loadDictionary();
    }

    /**
     * How to use? ... CensoredTextFilter().replaceProfanityContent(contentStr);
     *
     * @param contentStr: Crap!What a stupid decision!
     * @return: c*ap!what a s*upid decision!
     */
    public String replaceProfanityContent(String contentStr) {
        try {
            Set<String> badWords = searchForBadWords(contentStr);
            if (!CollectionUtils.isEmpty(badWords)) contentStr = replaceMultipleProfanity(contentStr, badWords);
        } catch (Exception ex) {
            log.warn("Error when censored content", ex);
        }
        return contentStr;
    }

    private void loadDictionary() {
        Map<String, String> words = new HashMap<>();
        try {
            FileInputStream file = new FileInputStream(CommonConstant.DICTIONARY_PATH);
            Stream<String> lines = new BufferedReader(new InputStreamReader(file)).lines();

            lines.forEach(badPhrase -> {
                String word = StringUtils.trimToEmpty(badPhrase).toLowerCase();
                badWordsCompounds.put(word, badPhrase);
                words.put(word, word);
            });
        } catch (Exception e) {
            log.warn("Something went wrong with loading a file.", e);
        } finally {
            dictionary.build(words);
        }
    }

    private Set<String> searchForBadWords(String input) {
        if (StringUtils.isBlank(input)) return new LinkedHashSet<>();

        String inputLowerCase = input.toLowerCase();
        Set<String> badWords = new LinkedHashSet<>();
        String parseInput = inputLowerCase.replaceAll(RegexConstants.MATCH_A_SINGLE_CHARACTER, StringUtils.EMPTY);

        if (dictionary.exactMatchSearch(parseInput) > 0) {
            badWords.add(input);
            return badWords;
        }

        if (CollectionUtils.isEmpty(badWordList)) badWordList = dictionary.parseText(inputLowerCase);

        for (AhoCorasickDoubleArrayTrie<String>.Hit<String> hit : badWordList) {
            if (TextUtils.containsCompound(inputLowerCase, hit.value)) {
                badWords.add(badWordsCompounds.get(hit.value));
                inputLowerCase = TextUtils.replaceCompound(inputLowerCase, hit.value, StringUtils.EMPTY);
            }
        }
        return badWords;
    }

    private String replaceMultipleProfanity(String input, Set<String> badWords) {
        for (String badWord : badWords)
            input = TextUtils.replaceCompound(input.toLowerCase(), badWord, TextUtils.replaceCensoredText(badWord));
        return input;
    }

}
