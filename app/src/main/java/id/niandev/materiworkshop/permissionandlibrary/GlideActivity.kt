package id.niandev.materiworkshop.permissionandlibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import id.niandev.materiworkshop.R
import kotlinx.android.synthetic.main.activity_glide.*

class GlideActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_glide)

        Glide.with(this).asDrawable().load("https://2.bp.blogspot.com/-Ac_MyWChN_A/V5OPSIjXLaI/AAAAAAAAAAg/7zohvN2XcN81fERUDhV9MLQpd3bzQJ0wACLcB/s1600/logounp.jpg")
            .into(img_glide)
    }
}
