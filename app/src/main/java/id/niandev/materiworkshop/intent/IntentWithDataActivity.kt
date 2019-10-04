package id.niandev.materiworkshop.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import id.niandev.materiworkshop.R
import kotlinx.android.synthetic.main.activity_intent_with_data.*

class IntentWithDataActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_with_data)
        val bundle = intent.extras
        val name:String = bundle.getString("nama","data Kosong")
        val alamat:String = bundle.getString("alamat","data Kosong")
        Toast.makeText(this,"Sukses",Toast.LENGTH_SHORT).show()

        txt_data_nama.text=name
        txt_data_alamat.text=alamat


    }
}
