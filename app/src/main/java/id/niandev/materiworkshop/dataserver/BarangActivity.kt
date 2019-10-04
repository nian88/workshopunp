package id.niandev.materiworkshop.dataserver

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import id.niandev.materiworkshop.R
import kotlinx.android.synthetic.main.activity_server.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class BarangActivity : AppCompatActivity(),BarangView {

    private  var dataBiodata: MutableList<Barang> = mutableListOf()
    private lateinit var adapter: BarangAdapter
    private lateinit var api: BarangApi
    private lateinit var presenter: BarangPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_server)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        api = getService().create(BarangApi::class.java)

        presenter = BarangPresenter(this, api)
        presenter.getBarang()

        rv_barang.setHasFixedSize(true)
        rv_barang.layoutManager= LinearLayoutManager(this)
        rv_barang.addItemDecoration(DividerItemDecoration(this,1))
        adapter = BarangAdapter(dataBiodata,this){}
        rv_barang.adapter = adapter
    }

    override fun showLoading() {
        toast("sedang memuat data")
    }

    override fun hideLoading() {

    }

    override fun doShow(data: List<Barang>) {
        dataBiodata.clear()
        dataBiodata.addAll(data)
        adapter.notifyDataSetChanged()
    }
}
