package id.niandev.materiworkshop.sqllite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import id.niandev.materiworkshop.R
import kotlinx.android.synthetic.main.activity_edit.*
import org.jetbrains.anko.db.update
import org.jetbrains.anko.makeCall
import org.jetbrains.anko.toast

class EditActivity : AppCompatActivity() {
      var id:Long = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        loadData()

        supportActionBar?.title = "List Aktivity"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        btn_EditSqlite.setOnClickListener {
            saveEdit()
        }
    }

    private fun saveEdit() {
        database.use {
            update("pelajartable","nama" to edit_sqlite_nama.text.toString(), "alamat" to edit_sqlite_alamat.text.toString())
                .whereArgs("id = {id}", "id" to id).exec()
        }
        toast("Pembaharuan Sukses")
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
    private fun loadData() {
        val dataBiodata = intent.getParcelableExtra<Biodata>("data")
        edit_sqlite_nama.setText(dataBiodata.nama)
        edit_sqlite_alamat.setText(dataBiodata.alamat)

        id=dataBiodata.id
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }
}
