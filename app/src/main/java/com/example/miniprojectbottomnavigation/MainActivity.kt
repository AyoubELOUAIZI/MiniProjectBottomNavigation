package com.example.miniprojectbottomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.fragment.app.Fragment
import com.example.miniprojectbottomnavigation.fragment.ContactFragment
import com.example.miniprojectbottomnavigation.fragment.GalleryFragment
import com.example.miniprojectbottomnavigation.fragment.HomeFragment
import com.example.miniprojectbottomnavigation.fragment.SettingFragment
import com.qamar.curvedbottomnaviagtion.CurvedBottomNavigation
import androidx.activity.viewModels

class MainActivity : AppCompatActivity() {
    private val viewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                !viewModel.isReady.value
            }
        }
        setContentView(R.layout.activity_main)

        val bottomNavigation = findViewById<CurvedBottomNavigation>(R.id.bottomNavigation)
        bottomNavigation.add( CurvedBottomNavigation.Model(1,"Home",R.drawable.ic_home_24))
        bottomNavigation.add( CurvedBottomNavigation.Model(2,"Setting",R.drawable.ic_settings_24))
        bottomNavigation.add( CurvedBottomNavigation.Model(3,"Home",R.drawable.ic_home_24))
        bottomNavigation.add( CurvedBottomNavigation.Model(4,"Setting",R.drawable.ic_settings_24))

        bottomNavigation.setOnClickMenuListener {
            when(it.id){
                1->{
                    replaceFragment(HomeFragment())
                }
                2->{
                    replaceFragment(SettingFragment())
                }
                3->{
                    replaceFragment(GalleryFragment())
                }
                4->{
                    replaceFragment(ContactFragment())
                }
            }
            true
        }

        // default bottom tab selected
        replaceFragment(HomeFragment())
        bottomNavigation.show(1,true)



    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer,fragment)
            .commit()
    }


}