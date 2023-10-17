package com.ssh.roomdb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val insertBtn: FloatingActionButton = findViewById(R.id.insert_btn)
        insertBtn.setOnClickListener {
            val intent: Intent = Intent(this, InsertActivity::class.java)

            activityResult.launch(intent)
        }

        // 사용자 조회
        loadUserList()

    }

     private val activityResult: ActivityResultLauncher<Intent> = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){
        if (it.resultCode == RESULT_OK){
            // 돌아온 값이 ok라면

            // 사용자 조회
            loadUserList()
        }

    }

    // 사용자 조회
    private fun loadUserList() {

        val db: AppDatabase? = AppDatabase.getDatabase(applicationContext)

        val userList: List<User> = db?.userDao()!!.getAlluser()

        if(userList.isNotEmpty()){

            val position: Int = userList.size -1

            Toast.makeText(this, "최근 등록자: " + userList.get(position).usrName,Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this, "등록자 없음", Toast.LENGTH_SHORT).show()
        }
    }
}