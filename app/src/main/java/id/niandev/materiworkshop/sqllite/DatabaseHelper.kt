package id.niandev.materiworkshop.sqllite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

val Context.database :  DatabaseHelper
    get() = DatabaseHelper.getInstance(applicationContext)
class DatabaseHelper (ctx:Context) : ManagedSQLiteOpenHelper(ctx,"sekolah.db",null,1){
    companion object{
        private var instance:DatabaseHelper?=null
        @Synchronized
        fun getInstance (ctx: Context):DatabaseHelper{
            if (instance == null){
                instance = DatabaseHelper(ctx.applicationContext)
            }
            return instance as DatabaseHelper
        }
    }
    override fun onCreate(db: SQLiteDatabase) {
        db.createTable("pelajartable", true,
            "id" to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
            "nama" to TEXT,
            "alamat" to TEXT
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.dropTable("pelajartable", true)
    }
}