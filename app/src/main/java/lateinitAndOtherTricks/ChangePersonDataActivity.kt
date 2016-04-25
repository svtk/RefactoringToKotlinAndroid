package lateinitAndOtherTricks

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.svtk.refactoringtokotlinandroid.PERSON
import com.svtk.refactoringtokotlinandroid.R
import kotlinx.android.synthetic.main.person_data.*
import org.jetbrains.anko.onClick

class ChangePersonDataActivity : Activity() {
    lateinit var person: Person

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.person_data)

        person = intent.getParcelableExtra(PERSON)

        et_name.setText(person.name)
        et_email.setText(person.email ?: "")
        et_phone_number.setText(person.phoneNumber ?: "")

        button_ok.onClick {
            with (person) {
                name = et_name.text.toString()
                email = et_email.text.toString()
                phoneNumber = et_phone_number.text.toString()
            }
            onBackPressed()
        }
    }

    override fun onBackPressed() {
        val newIntent = Intent()
//        newIntent.action = Intent.ACTION_INSERT_OR_EDIT
//        newIntent.putExtra("status", "person_added")
        newIntent.putExtra(PERSON, person)
        setResult(RESULT_OK, newIntent)
        super.onBackPressed()
    }
}