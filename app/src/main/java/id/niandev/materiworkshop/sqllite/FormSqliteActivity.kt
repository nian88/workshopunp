package id.niandev.materiworkshop.sqllite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.niandev.materiworkshop.R
import kotlinx.android.synthetic.main.activity_form_sqlite.*
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class FormSqliteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_sqlite)

        btn_saveSqlite.setOnClickListener {
            saveToSqlite()
        }
        btn_showSqlite.setOnClickListener {
            startActivity<ListActivity>()
        }
    }
    private fun saveToSqlite() {
        val nama:String = sqlite_nama.text.toString()
        val alamat:String = sqlite_alamat.text.toString()
        database.use {
            insert("pelajartable","nama" to nama, "alamat" to alamat)
        }
        toast("Sukses Menyimpan")
    }
}
