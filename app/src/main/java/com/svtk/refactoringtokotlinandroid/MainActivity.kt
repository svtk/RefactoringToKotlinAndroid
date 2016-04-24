package com.svtk.refactoringtokotlinandroid

import android.app.Activity
import android.app.ListActivity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import org.jetbrains.anko.startActivityForResult

class MainActivity : ListActivity() {
    val people = mutableListOf(Person("Alice"), Person("Bob"), Person("John"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        people.forEachIndexed { i, person -> person.id = i }
        val adapter = ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, people.map(Person::name))
        listAdapter = adapter
    }

    override fun onListItemClick(l: ListView?, v: View?, position: Int, id: Long) {
        super.onListItemClick(l, v, position, id)

        startActivityForResult<ChangePersonDataActivity>(
                PERSON_OK_CODE, PERSON to people[position])
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PERSON_OK_CODE && resultCode == Activity.RESULT_OK) {
            val updatedPersonInfo = data.getParcelableExtra<Person>("PERSON")
            people[updatedPersonInfo.id] = updatedPersonInfo
        }
    }
}

val PERSON = "PERSON"
val PERSON_OK_CODE = 1

