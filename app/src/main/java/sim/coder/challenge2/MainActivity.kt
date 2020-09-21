package sim.coder.challenge2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: Button
    private lateinit var prevButton: Button
    private lateinit var questionTextView: TextView

    private val questionBank = listOf(

        Question(R.string.sanna,true),
        Question(R.string.cairo,true),
        Question(R.string.aden,false),
        Question(R.string.ibb,true)
    )

    private var currentIndex = 0




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        trueButton = findViewById(R.id.t_button)
        falseButton = findViewById(R.id.f_button)
        nextButton = findViewById(R.id.next_button)
        prevButton = findViewById(R.id.prev_button)
        questionTextView = findViewById(R.id.q_textview)

        updateQuestion()



        prevButton.setOnClickListener {



        }


        trueButton.setOnClickListener {
            checkAnswer(true)
        }

        falseButton.setOnClickListener {
            checkAnswer(false)
        }

        nextButton.setOnClickListener {
            currentIndex = (currentIndex + 1) % questionBank.size
            updateQuestion()
        }


    }

    fun updateQuestion(){

        val questionTextResId = questionBank[currentIndex].textResId
        questionTextView.setText(questionTextResId)
    }

    fun checkAnswer(userAnswer:Boolean){

        val correctAnswer = questionBank[currentIndex].answer

        if (correctAnswer==userAnswer){

            Toast.makeText(this,"Correct!", Toast.LENGTH_LONG).show()
        }else{

            Toast.makeText(this,"OOps! false", Toast.LENGTH_LONG).show()
        }
    }


}
