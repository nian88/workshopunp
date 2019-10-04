package id.niandev.materiworkshop.dataserver

import android.util.Log
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class BarangPresenter (private val view: BarangView,
                       private val barangApi: BarangApi) {

    fun getBarang() {
        view.showLoading()
        barangApi.getBarang()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { barang ->
                    view.hideLoading()
                    view.doShow(barang)

                },
                { error ->
                    Log.e("Error", error.message)
                    view.hideLoading()
                }
            )

    }

}