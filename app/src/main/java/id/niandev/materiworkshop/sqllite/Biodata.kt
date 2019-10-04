package id.niandev.materiworkshop.sqllite

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class Biodata(val id:Long, val nama:String, val alamat :String) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readLong(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeString(nama)
        parcel.writeString(alamat)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Biodata> {
        override fun createFromParcel(parcel: Parcel): Biodata {
            return Biodata(parcel)
        }

        override fun newArray(size: Int): Array<Biodata?> {
            return arrayOfNulls(size)
        }
    }
}