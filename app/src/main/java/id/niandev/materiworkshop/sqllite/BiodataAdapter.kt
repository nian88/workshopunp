package id.niandev.materiworkshop.sqllite

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.niandev.materiworkshop.R
import kotlinx.android.synthetic.main.item_biodata.view.*

class BiodataAdapter(private val itemBiodata: List<Biodata>, private val mContext: Context, private val listener:(Biodata)->Unit)
    :RecyclerView.Adapter<BiodataAdapter.BiodataViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BiodataViewHolder {
        return BiodataViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_biodata,parent,false))
    }

    override fun getItemCount(): Int {
        return itemBiodata.size
    }

    override fun onBindViewHolder(holder: BiodataViewHolder, position: Int) {
        holder.BindItem(itemBiodata[position],mContext,listener)
    }

    class BiodataViewHolder (view:View) : RecyclerView.ViewHolder(view){
        val txtnama = view.txt_list_nama
        val img_profil = view.img_list_profil
        fun BindItem (biodata: Biodata,mContext: Context,listener: (Biodata) -> Unit){
            txtnama.text = biodata.nama
//            Glide.with(mContext).load(biodata)
            itemView.setOnClickListener {
                listener(biodata)
            }
        }
    }
}
