package com.ssh.roomdb

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class InsertActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert)

        val nameEdit: EditText = findViewById(R.id.name_edit)
        val ageEdit: EditText = findViewById(R.id.age_edit)
        val saveBtn: Button = findViewById(R.id.save_btn)

        saveBtn.setOnClickListener {

            val sName = nameEdit.text.toString()
            val sAge = ageEdit.text.toString()

            // 사용자 등록
            insertUser(sName, sAge)
        }
    }

    private fun insertUser(name: String, age: String){
        val user = User(null, name, age)
        val db: AppDatabase? = AppDatabase.getDatabase(applicationContext)

        db?.userDao()?.insertUser(user)

        // 상태값을 돌려준다.
        setResult(Activity.RESULT_OK)

        // 액티비티 닫기
        finish()
    }
}