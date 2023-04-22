package com.example.fragment

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.example.fragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var bind: ActivityMainBinding
    private val dataModel: DataModel by viewModels()
    @SuppressLint("CommitTransaction")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

       toFragment(BlankFragment.newInstance(), R.id.placeHolder)
        toFragment(BlankFragment2.newInstance(), R.id.placeHolder2)

        dataModel.messageForActivity.observe(this) {
            bind.textView.text = it
        }
    }

    private fun toFragment(fragment: Fragment, idHolder: Int) {
        supportFragmentManager
            .beginTransaction()
            .replace(idHolder, fragment).commit()
    }
}