package com.brodroid.aacademia

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var firebaseDatabase: FirebaseDatabase? = null
        var databaseReference: DatabaseReference? = null

        firebaseDatabase = FirebaseDatabase.getInstance("https://aacademy-c0452-default-rtdb.firebaseio.com/")
        databaseReference = firebaseDatabase.getReference("lessons")

        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                // this method is call to get the realtime
                // updates in the data.
                // this method is called when the data is
                // changed in our Firebase console.
                // below line is for getting the data from
                // snapshot of our database.
                val lessons: MutableList<Lesson> = mutableListOf()
                snapshot.children.mapNotNullTo(lessons) {
                    it.getValue(Lesson::class.java)
                    // after getting the value we are setting
                    // our value to our text view in below line.
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // calling on cancelled method when we receive
                // any error or we are not able to get the data.
                Toast.makeText(this@MainActivity, "Fail to get data.", Toast.LENGTH_SHORT).show()
            }
        })
    }
}