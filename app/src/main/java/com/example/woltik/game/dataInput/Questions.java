package com.example.woltik.game.dataInput;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by woLTik on 04-Dec-17.
 */

public class Questions {
    public List<Question> questions = new ArrayList<>();

    public Questions(){
        questions.add(new Question("5+5 = 10", true));
        questions.add(new Question("5*5 = 10", false));
        questions.add(new Question("25-16 = 9", true));
        questions.add(new Question("15+150 = 165", true));
        questions.add(new Question("2^3 = 6", false));
        questions.add(new Question("100 + 1000 = 1100", true));
        questions.add(new Question("100 + 1000 = 200", false));
        questions.add(new Question("6 * 7 = 42", true));
        questions.add(new Question("3 * 3 * 3 = 30 - 3", true));
        questions.add(new Question("2^10 = 2000", false));
        questions.add(new Question("1 = 1", true));
        questions.add(new Question("0! = 0", false));
        questions.add(new Question("|-16| / 2 = 8", true));
        questions.add(new Question("15 + 150 * 0 = 15", true));
        questions.add(new Question("2 / 2 - 1 = 2", false));
        questions.add(new Question("1.5 + 2/4 = 2", true));
        questions.add(new Question("5 * 5 = 20", false));
        questions.add(new Question("8 * 10 * 5 * 2 * 0 = 0", true));
        questions.add(new Question("(A)16 = (11)10", false));
        questions.add(new Question("(A)16 = 10", true));
        questions.add(new Question("(-2)^2 = -4", false));
        questions.add(new Question("(-1) * 2/(-1) = 2", true));

   }

    public Question getRandomQuestion(){
        Random random = new Random();
        int ran = random.nextInt(questions.size());
        return questions.get(ran);
    }
}
