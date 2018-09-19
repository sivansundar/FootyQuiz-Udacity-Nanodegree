/*
 * PROJECT LICENSE
 *
 * This project was submitted by Sivan Chakravarthy as part of the Nanodegree At Udacity.
 *
 * As part of Udacity Honor code, your submissions must be your own work, hence
 * submitting this project as yours will cause you to break the Udacity Honor Code
 * and the suspension of your account.
 *
 * Me, the author of the project, allow you to check the code as a reference, but if
 * you submit it, it's your own responsibility if you get expelled.
 *
 * Copyright (c) 2017 Sivan Chakravarthy
 *
 * Besides the above notice, the following license applies and this license notice
 * must be included in all works derived from this project.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */


package quiz.com.footyquiz;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioButton q1_ans_mb, q1_ans_bfc;
    boolean hasq1_ans_mb, hasq1_ans_bfc;

    CheckBox q2_ans_gss, q2_ans_sc, q2_ans_mb, q2_ans_db;
    boolean hasQ2_ans_sc, hasQ2_ans_db, hasQ2_ans_gss, hasQ2_ans_mb;

    RadioButton q3_op1_gss;
    boolean hasQ3_ans_gss;

    EditText q4_ans_edittext;
    String q4_ans_string;

    RadioButton q5_ans_imv, q5_ans_srn;
    boolean hasQ5_ans_imv;

    RadioButton q6_ans_as;
    boolean hasQ6_ans_as;


    int correct;
    int incorrect_answers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Question 1
        q1_ans_mb = (RadioButton) findViewById(R.id.Q1_op1_mb);
        q1_ans_bfc = (RadioButton) findViewById(R.id.Q1_op2_bfc);

        //Question 2
        q2_ans_gss = (CheckBox) findViewById(R.id.Q2_ans_gss);
        q2_ans_sc = (CheckBox) findViewById(R.id.Q2_ans_sc);
        q2_ans_mb = (CheckBox) findViewById(R.id.Q2_ans_mb);
        q2_ans_db = (CheckBox) findViewById(R.id.Q2_ans_db);

        //Question 3
        q3_op1_gss = (RadioButton) findViewById(R.id.Q3_op1_gss);

        //Question 4
        q4_ans_edittext = (EditText) findViewById(R.id.Q4_ans_edittext);

        //Question 5
        q5_ans_imv = (RadioButton) findViewById(R.id.Q5_ans_imv);
        q5_ans_srn = (RadioButton) findViewById(R.id.Q5_ans_srn);

        //Question 6
        q6_ans_as = (RadioButton) findViewById(R.id.Q6_ans_as);

        correct = 0;
        incorrect_answers = 0;
    }

    public void submit(View view) {
        //Checks the status of the options for Question 1
        hasq1_ans_mb = q1_ans_mb.isChecked();
        hasq1_ans_bfc = q1_ans_bfc.isChecked();

        //Checks the status of the options for Question 2
        hasQ2_ans_sc = q2_ans_sc.isChecked();
        hasQ2_ans_db = q2_ans_db.isChecked();
        hasQ2_ans_gss = q2_ans_gss.isChecked();
        hasQ2_ans_mb = q2_ans_mb.isChecked();

        //Checks the status of the options for Question 3
        hasQ3_ans_gss = q3_op1_gss.isChecked();

        //Checks the status of the answer for Question 4
        q4_ans_string = q4_ans_edittext.getText().toString().trim();

        //Checks the status of the options for Question 5
        hasQ5_ans_imv = q5_ans_imv.isChecked();

        //Checks the status of the options for Question 6
        hasQ6_ans_as = q6_ans_as.isChecked();

        Q1();
        Q2();
        Q3();
        Q4();
        Q5();
        Q6();

        if (correct == 1 || incorrect_answers == 1) {
            Toast.makeText(this, "With " + correct + " correct answer and " + incorrect_answers + " incorrect answers" + "\n"
                    + "Your final score is " + correct + "/" + "6.", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "With " + correct + " correct answers and " + incorrect_answers + " incorrect answers" + "\n"
                    + "Your final score is " + correct + "/" + "6.", Toast.LENGTH_LONG).show();
        }

        correct = 0;
        incorrect_answers = 0;

    }

    public void Q1() {
        if (hasq1_ans_bfc) { // QUESTION 1
            correct(1);
        } else {
            incorrect(1);
        }
    }

    public void Q2() {
        if ((hasQ2_ans_db && hasQ2_ans_sc) && (!hasQ2_ans_gss && !hasQ2_ans_mb)) {
            correct(2);
        } else {
            incorrect(2);
        }
    }

    public void Q3() {
        if (hasQ3_ans_gss) { // QUESTION 3
            correct(3);
        } else {
            incorrect(3);
        }
    }

    public void Q4() {
        if (q4_ans_string.equals("64")) {
            correct(4);
        } else {
            incorrect(4);
        }
    }

    public void Q5() {
        if (hasQ5_ans_imv) {
            correct(5);
        } else {
            incorrect(5);
        }

    }

    public void Q6() {
        if (hasQ6_ans_as) {
            correct(6);
        } else {
            incorrect(6);
        }
    }

    public void incorrect(int question_number) {
        Log.d("Quiz : ", "Question " + question_number + " is INCORRECT");
        incorrect_answers++;

    }

    public void correct(int question_number) {
        correct++;
        Log.d("Quiz : ", "Question " + question_number + " is CORRECT");

    }
}
