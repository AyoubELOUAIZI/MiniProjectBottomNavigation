package com.example.miniprojectbottomnavigation

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.OvershootInterpolator
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.fragment.app.Fragment
import com.example.miniprojectbottomnavigation.fragment.ContactFragment
import com.example.miniprojectbottomnavigation.fragment.GalleryFragment
import com.example.miniprojectbottomnavigation.fragment.HomeFragment
import com.example.miniprojectbottomnavigation.fragment.SettingFragment
import com.qamar.curvedbottomnaviagtion.CurvedBottomNavigation
import androidx.activity.viewModels
import androidx.core.animation.doOnEnd

class MainActivity : AppCompatActivity() {
    private val viewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //this code is  for the splashscreen
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                !viewModel.isReady.value
            }
            setOnExitAnimationListener {screen->
                val zoomX=ObjectAnimator.ofFloat(
                    screen.iconView,
                    View.SCALE_X,
                    0.4f,
                    0.0f
                )
                zoomX.interpolator=OvershootInterpolator()
                zoomX.duration=300L
                zoomX.doOnEnd { screen.remove() }

                val zoomY=ObjectAnimator.ofFloat(
                    screen.iconView,
                    View.SCALE_Y,
                    0.4f,
                    0.0f
                )
                zoomY.interpolator=OvershootInterpolator()
                zoomY.duration=300L
                zoomY.doOnEnd { screen.remove() }

                zoomX.start()
                zoomY.start()


            }
        }
        setContentView(R.layout.activity_main)
        // Set the title for the activity
        //supportActionBar?.title = "Your Activity Name"

        val bottomNavigation = findViewById<CurvedBottomNavigation>(R.id.bottomNavigation)
        bottomNavigation.add( CurvedBottomNavigation.Model(1,"Home",R.drawable.ic_home_24))
        bottomNavigation.add( CurvedBottomNavigation.Model(2,"School",R.drawable.ic_school_24))
        bottomNavigation.add( CurvedBottomNavigation.Model(3,"Gallery",R.drawable.ic_gallery))
        bottomNavigation.add( CurvedBottomNavigation.Model(4,"Contact",R.drawable.ic_contact_support24))
        bottomNavigation.add( CurvedBottomNavigation.Model(5,"Setting",R.drawable.ic_settings_24))


        bottomNavigation.setOnClickMenuListener {
            when(it.id){
                1->{
                    replaceFragment(HomeFragment())
                }
                2->{
                    replaceFragment(GalleryFragment())
                }
                3->{
                    replaceFragment(GalleryFragment())
                }
                4->{
                    replaceFragment(ContactFragment())
                }
                5->{
                    replaceFragment(GalleryFragment())
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