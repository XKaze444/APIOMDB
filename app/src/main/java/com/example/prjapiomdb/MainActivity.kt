package com.example.prjapiomdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.prjapiomdb.databinding.ActivityMainBinding
import com.example.prjapiomdb.fragment.DataFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCari.setOnClickListener{
            showFragment()
        }


    }

    private fun showFragment() {
        val mFragmentManager = supportFragmentManager
        val mFragmentTransaction =  mFragmentManager.beginTransaction()
        val mFragment = DataFragment()

        val textCari=binding.etCari.text
        val mBundle = Bundle()
        mBundle.putString("carimovie",textCari.toString())
        mFragment.arguments = mBundle

        mFragmentTransaction.replace(R.id.fl_data,mFragment).commit()
    }
}