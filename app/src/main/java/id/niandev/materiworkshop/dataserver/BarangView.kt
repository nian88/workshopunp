package id.niandev.materiworkshop.dataserver

interface BarangView {
    fun showLoading()
    fun hideLoading()
    fun doShow(data:List<Barang>)
}