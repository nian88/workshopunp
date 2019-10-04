package id.niandev.materiworkshop.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.niandev.materiworkshop.R
import kotlinx.android.synthetic.main.activity_intent_no_data.*

class IntentNoDataActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_no_data)

        btn_intent_with_data.setOnClickListener {
            val bundle=Bundle()
            bundle.putString("nama",ed_nama.text.toString())
            bundle.putString("alamat",ed_alamat.text.toString())
            val intent=Intent(this,IntentWithDataActivity::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }
}
