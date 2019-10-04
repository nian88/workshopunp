package id.niandev.materiworkshop.anko

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.niandev.materiworkshop.R
import org.jetbrains.anko.longToast
import org.jetbrains.anko.toast

class AnkoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anko)
        val nama = intent.getStringExtra("nama")
        longToast(nama)
    }
}
