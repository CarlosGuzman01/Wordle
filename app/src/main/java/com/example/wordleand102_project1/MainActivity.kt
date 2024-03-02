package com.example.wordleand102_project1


import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        toolbar.title = "Wordle"


        var attemptsCounter = 0
        val randomWord = FourLetterWordList.getRandomFourLetterWord().uppercase()


        val button = findViewById<Button>(R.id.theButton)
        val editText = findViewById<EditText>(R.id.editText)


        val attempt1 = findViewById<TextView>(R.id.attempt1)


        val check1 = findViewById<TextView>(R.id.check1)

        val attempt2 = findViewById<TextView>(R.id.attempt2)
        val check2 = findViewById<TextView>(R.id.check2)

        val attempt3 = findViewById<TextView>(R.id.attempt3)
        val check3 = findViewById<TextView>(R.id.check3)

        val finalText = findViewById<TextView>(R.id.answer)

        button.setOnClickListener {
            var editTextValue = editText.text.toString()

            var final = editTextValue.uppercase()


            var str1 = SpannableString(final)


            attemptsCounter++

            for (i in 0..3) {
                if (final[i] == randomWord[i]) {
                    str1.setSpan(
                        ForegroundColorSpan(Color.GREEN),
                        i,
                        i + 1,
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                    )

                } else if (randomWord.contains(final[i])) {
                    str1.setSpan(
                        ForegroundColorSpan(Color.RED), i, i + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                    )

                } else {


                }
            }

            when (attemptsCounter) {
                1 -> {
                    attempt1.text = final
                    check1.text = str1
                }

                2 -> {
                    attempt2.text = final
                    check2.text = str1
                }

                3 -> {
                    attempt3.text = final
                    check3.text = str1
                    finalText.text = randomWord
                }
            }

            editText.setText("")

        }

    }


}