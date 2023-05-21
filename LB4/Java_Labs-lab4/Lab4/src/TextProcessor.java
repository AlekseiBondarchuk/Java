import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TextProcessor {
    private String text;

    public TextProcessor(String text) {
        this.text = text;
    }

    public String processText() {
        StringBuilder processedText = new StringBuilder();

        String[] sentences = splitSentences(text);
        for (String sentence : sentences) {
            Sentence processedSentence = processSentence(sentence);
            appendSentence(processedText, processedSentence);
        }

        return trimText(processedText);
    }

    private String[] splitSentences(String text) {
        return text.split("[.!?]+");
    }

    private Sentence processSentence(String sentence) {
        List<Word> words = extractWords(sentence);

        List<Word> vowelWords = filterVowelWords(words);
        sortVowelWords(vowelWords);

        replaceVowelWords(words, vowelWords);

        return new Sentence(words);
    }

    private List<Word> extractWords(String sentence) {
        List<Word> words = new ArrayList<>();

        String[] sentenceWords = sentence.split("\\s+");
        for (String word : sentenceWords) {
            words.add(new Word(word));
        }

        return words;
    }

    private List<Word> filterVowelWords(List<Word> words) {
        List<Word> vowelWords = new ArrayList<>();
        for (Word word : words) {
            if (startsWithVowel(word)) {
                vowelWords.add(word);
            }
        }
        return vowelWords;
    }

    private void sortVowelWords(List<Word> vowelWords) {
        Collections.sort(vowelWords, (w1, w2) -> {
            char firstConsonant1 = findFirstConsonant(w1);
            char firstConsonant2 = findFirstConsonant(w2);
            return Character.compare(firstConsonant1, firstConsonant2);
        });
    }

    private void replaceVowelWords(List<Word> words, List<Word> vowelWords) {
        int vowelWordIndex = 0;
        for (int i = 0; i < words.size(); i++) {
            Word word = words.get(i);
            if (vowelWords.contains(word)) {
                Word vowelWord = vowelWords.get(vowelWordIndex);
                words.set(i, vowelWord);
                vowelWordIndex++;
            }
        }
    }

    private boolean startsWithVowel(Word word) {
        char firstChar = Character.toLowerCase(word.toString().charAt(0));
        return "аоиыуэ".contains(Character.toString(firstChar));
    }

    private char findFirstConsonant(Word word) {
        String str = word.toString();
        for (int i = 0; i < str.length(); i++) {
            char ch = Character.toLowerCase(str.charAt(i));
            if (!"аоиыуэ".contains(Character.toString(ch))) {
                return ch;
            }
        }
        return 'z';
    }

    private void appendSentence(StringBuilder processedText, Sentence sentence) {
        processedText.append(sentence.toString()).append(" ");
    }

    private String trimText(StringBuilder processedText) {
        return processedText.toString().trim();
    }
}
