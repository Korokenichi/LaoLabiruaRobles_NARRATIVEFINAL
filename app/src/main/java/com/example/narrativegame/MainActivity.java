package com.example.narrativegame;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
    public String scenario;
    public int baseanswer;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scenario = "Enter1";
        baseanswer = 0;

        TextView storyBackground = findViewById(R.id.txtStoryBackground);
        TextView storyOutcome = findViewById(R.id.txtStoryOutcome);

        Button decision1 = findViewById(R.id.btnDecision1);
        Button decision2 = findViewById(R.id.btnDecision2);
        decision1.setOnTouchListener(this);
        decision2.setOnTouchListener(this);


        storyBackground.setText("In a world where Patrick's Imagination may live into its fullest. \n \n Here's a twist! \n \n You play as the main Villain of Patrick Ramses' Imagination.");

        storyOutcome.setText("You have two choices to foil him \n \n " +
                "Decision #1 Provoke him into a fight \n \n " +
                "Decision #2 Plan for a Grand Prepartion to have higher \n chance to win a fight with him.");

        decision1.setText("Provoke");
        decision2.setText("Plan");

        // 1 - Provoke, 2 - Plan

    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        TextView storyOutcome = findViewById(R.id.txtStoryOutcome);
        TextView storyBackground = findViewById(R.id.txtStoryBackground);
        String space=String.valueOf(baseanswer);
        Button decision1 = findViewById(R.id.btnDecision1);
        Button decision2 = findViewById(R.id.btnDecision2);

        if (event.getAction() == MotionEvent.ACTION_DOWN) {

            switch (view.getId()){
                case R.id.btnDecision1:
                    baseanswer = 1;
                    break;
                case R.id.btnDecision2:
                    baseanswer = 2;
                    break;
                }
            }


        else if (event.getAction() == MotionEvent.ACTION_UP) {

            //built scenarios: (Provoke, Plan)

            // Descision 1s
            if (baseanswer == 1){
                switch (scenario) {
                    case "Start": // Start
                        storyBackground.setText("In a world where Patrick's Imagination may live into its fullest. \n \n Here's a twist! \n \n You play as the main Villain of Patrick Ramses' Imagination.");
                        storyOutcome.setText("You have two choices to foil him \n \n " +
                                "Decision #1 Provoke him into a fight \n \n " +
                                "Decision #2 Plan for a Grand Prepartion to have higher \n chance to win a fight with him.");
                        scenario = "Enter1";
                        decision1.setText("Provoke");
                        decision2.setText("Plan");
                        break;
                    case "Enter1": // 1 - Enter Provoke
                        storyBackground.setText("You know have provoke him into a fight,\n Patrick started his adventure\n to reach your Evil Fortress");
                        storyOutcome.setText("You have two courses of action \n \n" +
                                "Decision #1 Lay Booby trap in their Journey for them to be weakened and have the higher advantage \n \n" +
                                "Decision #2 Become a Chad, a MADLAD and doesn't care about a single problem with this situation because, you, yourself know your POWER!");
                        scenario = "Provoke1";
                        decision1.setText("Booby Trap");
                        decision2.setText("BE A MADLAD");
                        break;
                        //**__//
                    case "Provoke1": // 1 - Provoke1
                        storyBackground.setText("Your booby trap was pretty noticable in the eyes of Patrick. After that they caught you and killed you, damn.");
                        storyOutcome.setText("Start Over");
                        scenario = "Start";
                        decision1.setText("Restart");
                        decision2.setText(":(");
                        break;
                        //**__//
                    case "Provoke2": // 2 - Provoke2
                        storyBackground.setText("You shielded Pat's attack! Nice! You have a big opportunity to smack him!");
                        storyOutcome.setText("");
                        scenario = "ProvokeShield";
                        decision1.setText("Continue");
                        decision2.setText("");
                        break;
                    case "ProvokeShield": // 2 - Provoke2
                        storyBackground.setText("What will you do?");
                        storyOutcome.setText("Decision #1 Kick him in the nuts!" +
                                "\n \nDecision #2 Punch him on the face!");
                        scenario = "ProvokeShield1";
                        decision1.setText("Kick nuts");
                        decision2.setText("Punch face");
                        break;
                        //**__//
                    case "ProvokeShield1": // 1 - Provoke1
                        storyBackground.setText("You kicked his nuts and he died, but he also kicked your nuts and you died. \n \n So you won... but at what cost...");
                        storyOutcome.setText("THE END");
                        scenario = "Start";
                        decision1.setText("Restart");
                        decision2.setText(":|");
                        break;
                        //**__//
                    case "ProvokeSword1": // 1 - Provoke1
                        storyBackground.setText("You became friends! \n \n Yay!");
                        storyOutcome.setText("THE END");
                        scenario = "Start";
                        decision1.setText("Restart");
                        decision2.setText(":D");
                        break;
                    //**__//
                    case "Plan1": // 1 - Plan1
                        storyBackground.setText("Your trap was pretty noticable in the eyes of Patrick. After that they caught you and killed you, damn.");
                        storyOutcome.setText("Start Over");
                        scenario = "Start";
                        decision1.setText("Restart");
                        decision2.setText(":(");
                        break;
                }
            }

            // Descision 2s
            if (baseanswer == 2){
                switch (scenario) {
                    case "Enter1": // 2 - Plan Enter
                        storyBackground.setText("You now have started to plan you GRAND PREPARATION but you noticed that Patrick Ramses have now started to their Journey to defeat the Evil Villain in his Imagination");
                        storyOutcome.setText("You have Two course of action \n \n " +
                                "Decision #1 You lay traps on their journey, this will give you more \n time to do your grand plan but this will provoke the\n Patrick Ramses which they may move of their journey go faster \n \n" +
                                "Decision #2 This make your Grand plan goes faster but you will never know \n how fast they will arrive.");
                        decision1.setText("Traps!");
                        decision2.setText("Something???");
                        scenario = "Plan1";
                        break;
                    case "Plan1": // 2 - Plan1
                        storyBackground.setText("Unfortunately, you had a heart attack.");
                        storyOutcome.setText("Start Over");
                        scenario = "Start";
                        decision1.setText("Restart");
                        decision2.setText(":(");
                        break;
                    case "Provoke1": // 2 - Provoke1
                        storyBackground.setText("You found yourself in front of Pat. \n \n What's your next move?");
                        storyOutcome.setText("Decision #1 Use your shield. \n \n" +
                                "Decision #2 Use your sword.");
                        scenario = "Provoke2";
                        decision1.setText("Shield");
                        decision2.setText("Sword");
                        break;
                    case "Provoke2": // 2 - Provoke2
                        storyBackground.setText("You slashed right through Pat, but he managed to survive the cut! He slashed YOU down and you took quite the beating.");
                        storyOutcome.setText("");
                        scenario = "ProvokeSword";
                        decision1.setText("");
                        decision2.setText("Continue");
                        break;
                    case "ProvokeSword": // 2 - Provoke2
                        storyBackground.setText("Pat seems to be tired. \n What's your next move?");
                        storyOutcome.setText("Desicion #1 Retreat and become friends?\n \n" +
                                "Desicion #2 Open Fire!");
                        scenario = "ProvokeSword1";
                        decision1.setText("Be Friends!");
                        decision2.setText("Fire");
                        break;
                    //**__//
                    case "ProvokeShield1": // 1 - Provoke1
                        storyBackground.setText("You punched his face and he died, but he also punched your face and you died. \n \n So you won... but at what cost...");
                        storyOutcome.setText("THE END");
                        scenario = "Start";
                        decision1.setText("Restart");
                        decision2.setText(":|");
                        break;
                    //**__//
                    //**__//
                    case "ProvokeSword1": // 1 - Provoke1
                        storyBackground.setText("You fired and he died! \n \n Yay!");
                        storyOutcome.setText("THE END");
                        scenario = "Start";
                        decision1.setText("Restart");
                        decision2.setText(":)");
                        break;
                    //**__//

                }
            }
        }
        return false;


    }
}
