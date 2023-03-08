package com.example.fragmentnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragmentnavigation.Fragments.FragmentA
import com.example.fragmentnavigation.Fragments.FragmentB

class MainActivity : AppCompatActivity(),Communicator {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentA= FragmentA()
        //to start the app with  fragment A
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container,fragmentA).commit()
    }


    override fun passData(editTextData: String) {
        val bundle = Bundle()
        bundle.putString("message",editTextData)

        val transaction = this.supportFragmentManager.beginTransaction()
        val fragmentB= FragmentB()

        fragmentB.arguments = bundle

        //to pass data to fragment B and open it
        transaction.replace(R.id.fragment_container,fragmentB).commit()

    }

}