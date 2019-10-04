package id.niandev.materiworkshop.sqllite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import id.niandev.materiworkshop.R
import kotlinx.android.synthetic.main.activity_list.*
import org.jetbrains.anko.ctx
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class ListActivity : AppCompatActivity() {

    private  var dataBiodata: MutableList<Biodata> = mutableListOf()
    private lateinit var adapter: BiodataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        supportActionBar?.title = "List Aktivity"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        rv_biodata.setHasFixedSize(true)
        rv_biodata.layoutManager= LinearLayoutManager(this)
        rv_biodata.addItemDecoration(DividerItemDecoration(this,1))
        adapter = BiodataAdapter(dataBiodata,this){
           startActivity<EditActivity>(
               "data" to it
           )
        }
        loadData()
        rv_biodata.adapter = adapter
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

    override fun onResume() {
        loadData()
        super.onResume()
    }
    override fun onBackPressed() {
        super.onBackPressed()
    }

    private fun loadData() {
        dataBiodata.clear()
        database.use {
            val result = select("pelajartable")
            val data = result.parseList(classParser<Biodata>())
            dataBiodata.addAll(data)
        }
        adapter.notifyDataSetChanged()
    }

}
