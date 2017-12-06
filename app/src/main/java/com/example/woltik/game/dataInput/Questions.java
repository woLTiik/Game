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
    }

    public Question getRandomQuestion(){
        Random random = new Random();
        int ran = random.nextInt(questions.size());
        return questions.get(ran);
    }
}
