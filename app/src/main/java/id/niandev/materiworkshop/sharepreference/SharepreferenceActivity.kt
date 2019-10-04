package id.niandev.materiworkshop.sharepreference

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import id.niandev.materiworkshop.R
import kotlinx.android.synthetic.main.activity_sharepreference.*

class SharepreferenceActivity : AppCompatActivity() {

    val utilSharepreference=UtilSharepreference()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sharepreference)
        btn_save.setOnClickListener {
            if(!checkContent()){
                return@setOnClickListener
            }
            if (saveToPreference()){
                Toast.makeText(this, "Simpan Berhasil", Toast.LENGTH_SHORT).show()
                txt_nama.text.clear()
                txt_email.text.clear()
            }
        }
        btn_tampil.setOnClickListener {
            val nama :String = utilSharepreference.getString(this,"nama").toString()
            val email :String = utilSharepreference.getString(this,"email").toString()

            Toast.makeText(this, "Nama Saya : {$nama}, Email : {$email}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun checkContent() :Boolean {
        if (TextUtils.isEmpty(txt_nama.text)){
            txt_nama.error = "Harap Isi Nama"
            return false
        }
        if (txt_nama.text.length<3){
            txt_nama.error = "Nama kurang dari 3"
            return false
        }
        if (TextUtils.isEmpty(txt_email.text)){
            txt_email.error = "Harap Isi Email"
            return false
        }
        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(txt_email.text).matches())
        {
            txt_email.error = "Harap Isi Email Dengan Benar"
            return false
        }
        return true
    }

    private fun saveToPreference():Boolean {
        utilSharepreference.setString(this,"nama",txt_nama.text.toString())
        utilSharepreference.setString(this,"email",txt_email.text.toString())
        return true
    }
}
