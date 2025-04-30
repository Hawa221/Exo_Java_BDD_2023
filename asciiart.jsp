package com.example.asciiart;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AsciiArtService {

    public List<String> generateArt(AsciiArtRequest req) {
        String T = req.getText().toUpperCase();
        int L = req.getWidth();
        int H = req.getHeight();
        List<String> rows = req.getAlphabetLines();

        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ?";
        List<String> result = new ArrayList<>();

        for (int i = 0; i < H; i++) {
            StringBuilder line = new StringBuilder();
            for (char c : T.toCharArray()) {
                int index = alphabet.indexOf(c);
                if (index == -1) index = 26;
                int start = index * L;
                int end = start + L;
                line.append(rows.get(i).substring(start, end));
            }
            result.add(line.toString());
        }

        return result;
    }
}
