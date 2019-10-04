package id.niandev.materiworkshop.dataserver

import retrofit2.http.POST
import rx.Single

interface BarangApi {
    @POST("barang.json")
    fun getBarang(): Single<List<Barang>>


}