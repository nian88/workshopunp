package id.niandev.materiworkshop.dataserver

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.niandev.materiworkshop.R
import kotlinx.android.synthetic.main.item_barang.view.*

class BarangAdapter (private val itemBarang: List<Barang>, private val mContext: Context, private val listener:(Barang)->Unit)
    : RecyclerView.Adapter<BarangAdapter.BarangViewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BarangViewHolder {
        return BarangViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_barang,parent,false))
    }

    override fun getItemCount(): Int {
        return itemBarang.size
    }

    override fun onBindViewHolder(holder: BarangViewHolder, position: Int) {
        holder.BindItem(itemBarang[position],mContext,listener)
    }

    class BarangViewHolder (view: View) : RecyclerView.ViewHolder(view){
        val txtnama = view.txt_barang_nama
        val txtharga = view.txt_barang_harga
        val imgbarang = view.img_barang
        fun BindItem (barang: Barang,mContext: Context,listener: (Barang) -> Unit){
            txtnama.text = barang.namabarang
            txtharga.text = barang.hargabarang.toString()
            Glide.with(mContext).load(barang.gambar).into(imgbarang)
        }
    }
}