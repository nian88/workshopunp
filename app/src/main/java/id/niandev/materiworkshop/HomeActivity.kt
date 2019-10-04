package id.niandev.materiworkshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.niandev.materiworkshop.anko.AnkoActivity
import id.niandev.materiworkshop.dataserver.BarangActivity
import id.niandev.materiworkshop.intent.IntentNoDataActivity
import id.niandev.materiworkshop.permissionandlibrary.GlideActivity
import id.niandev.materiworkshop.sharepreference.SharepreferenceActivity
import id.niandev.materiworkshop.sqllite.FormSqliteActivity
import kotlinx.android.synthetic.main.activity_home.*
import org.jetbrains.anko.startActivity

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        btn_sharepreference.setOnClickListener {
            val intent = Intent(this@HomeActivity  , SharepreferenceActivity::class.java)
            startActivity(intent)
        }
        btn_intent.setOnClickListener {
            val intent = Intent(this@HomeActivity  , IntentNoDataActivity::class.java)
            startActivity(intent)
        }
        btn_glide.setOnClickListener {
            val intent = Intent(this@HomeActivity  , GlideActivity::class.java)
            startActivity(intent)
        }
        btn_anko.setOnClickListener {
            startActivity<AnkoActivity>(
                "nama" to "azhar",
                "alamat" to "Gurah"
            )
        }
        btn_sqlite.setOnClickListener {
            startActivity<FormSqliteActivity>()
        }

        btn_server.setOnClickListener {
            startActivity<BarangActivity>()
        }
    }
}
