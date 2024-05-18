package com.example.dua

import android.graphics.Color
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private var duaArabic = mutableListOf<String>()
    private var duaTranslations = mutableListOf<String>()
    private var duaEnglish = mutableListOf<String>()
    private val mediaFiles = mutableListOf<String>()
    private var titles = mutableListOf<String>()
    private lateinit var view_pager2: ViewPager2
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var playButton: Button
    var audioFiles = intArrayOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        addTitles()
       audioFiles= intArrayOf(R.raw.dua0, R.raw.dua1,R.raw.dua2,R.raw.dua3,R.raw.dua4,R.raw.dua5)


     //   val view = layoutInflater.inflate(R.layout.items, null)



       playButton = findViewById(R.id.playButton)

        mediaPlayer = MediaPlayer()
      //  mediaPlayer = MediaPlayer.create(this, R.raw.dua1)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar.setNavigationIcon(R.drawable.ic_menu);
        drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        view_pager2 = findViewById(R.id.view_pager)
        val navigationView = findViewById<NavigationView>(R.id.nav_view)

        //getSupportActionBar()?.setTitle("Dua of Prophet Adam عليه السلام")
        supportActionBar?.title = "Dua of Prophet Adam عليه السلام"

        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav)
        drawerLayout.addDrawerListener(toggle)

        toggle.syncState()
        drawerLayout.setScrimColor(Color.TRANSPARENT)
        post()


        view_pager2.adapter = ViewPagerAdapter(duaArabic, duaTranslations,duaEnglish)

        view_pager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                // Update the audio file when the page changes
                mediaPlayer.reset();
                supportActionBar?.title = titles[position]
                mediaPlayer = MediaPlayer.create(applicationContext, audioFiles[position]);
                if (playButton.text=="Pause")
                {
                    playButton.text="Play Dua"
                }
            }
        })

        playButton.setOnClickListener {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.pause()
                playButton.text="Play Dua"
            } else {
                mediaPlayer.start()
                playButton.text="Pause"
            }
        }
        navigationView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.adam -> selected(0)
                R.id.Yunus -> selected(1)
                R.id.Ayub -> selected(2)
                R.id.Ibrahim -> selected(3)
                R.id.Musa -> selected(4)
                R.id.Yusuf -> selected(5)

                // Add similar cases for other menu items
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }




    }




    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }
    private fun selected(duaID:Int) {



        when (duaID) {
           0->  {
               contentUpdate(0)

           }
            1-> {
                contentUpdate(1)
            }
            2-> {
                contentUpdate(2)
            }
            3-> {
                contentUpdate(3)
            }
            4-> {
                contentUpdate(4)
            }
            5 -> {
                contentUpdate(5)
            }
        }


    }
    private fun addtolist(arabic: String, translation: String,english: String) {

        duaArabic.add(arabic)
        duaTranslations.add(translation)
        duaEnglish.add(english)

    }

    private fun post() {
       // for (i in 1..5) {
       //     addtolist("بِسْمِ ٱللَّهِ ٱلرَّحْمَـٰنِ ٱلرَّحِيمِ ١ $i", "Description $i", R.mipmap.ic_launcher_round)
      //  }
        addtolist("رَبَّنَا ظَلَمْنَا أَنْفُسَنَا وَإِنْ لَمْ تَغْفِرْ لَنَا وَتَرْحَمْنَا لَنَكُونَنَّ مِنَ الْخَاسِرِينَ", "Our Lord, we have wronged ourselves, and if You do not forgive us and have mercy upon us, we will surely be among the losers.","Rabbanaa zalamnaaa anfusanaa wa-in lam taghfir lanaa wa tarhamnaa lanakoonanna minal khaasireen")
        addtolist("لَّآ إِلَـٰهَ إِلَّآ أَنتَ سُبْحَـٰنَكَ إِنِّى كُنتُ مِنَ ٱلظَّـٰلِمِين", "There is no god ˹worthy of worship˺ except You. Glory be to You! I have certainly done wrong.","La ilaha illa anta subhanaka inni kuntu minaz-zalimin")
        addtolist("أَنِّي مَسَّنِيَ الضُّرُّ وَأَنتَ أَرْحَمُ الرَّاحِمِينَ َ", "Verily, distress has seized me, and You are the Most Merciful of all those who show mercy.","Annee massaniya alddurru waanta arhamu alrrahimeena")
       addtolist("رَبَّنَا ٱغْفِرْ لِى وَلِوَٰلِدَىَّ وَلِلْمُؤْمِنِينَ يَوْمَ يَقُومُ ٱلْحِسَابُ","Our Lord! Forgive me, my parents, and the believers on the Day when the judgment will come to pass.","Rabbana ighfir lee waliwalidayya walilmumineena yawma yaqoomu alhisabu")
        addtolist("رَبِّ إِنِّى لِمَآ أَنزَلْتَ إِلَىَّ مِنْ خَيْرٍۢ فَقِيرٌۭ","My Lord! I am truly in ˹desperate˺ need of whatever provision You may have in store for me.","Rabbi innee lima anzalta ilayya min khayrin faqeerun")
        addtolist("فَاطِرَ ٱلسَّمَـٰوَٰتِ وَٱلْأَرْضِ أَنتَ وَلِىِّۦ فِى ٱلدُّنْيَا وَٱلْـَٔاخِرَةِ ۖ تَوَفَّنِى مُسْلِمًۭا وَأَلْحِقْنِى بِٱلصَّـٰلِحِينَ","O˺ Originator of the heavens and the earth! You are my Guardian in this world and the Hereafter. Allow me to die as one who submits1 and join me with the righteous.","Fatira alssamawati waalardi anta waliyyee fee alddunya waalakhirati tawaffanee musliman waalhiqnee bialssaliheena")


    }
    private fun addTitles() {


        titles.add("Dua of Prophet Adam عليه السلام") //0
        titles.add("Dua of Prophet Yunus عليه السلام")//1
        titles.add("Dua of Prophet Ayub عليه السلام")//2
        titles.add("Dua of Prophet Ibrahim عليه السلام")//3
        titles.add("Dua of Prophet Musa عليه السلام")//4
        titles.add("Dua of Prophet Yusuf عليه السلام")//5
        titles.add("Dua of Prophet  عليه السلام")//6
        titles.add("Dua of Prophet  عليه السلام")//7
        titles.add("Dua of Prophet  عليه السلام")//8
        titles.add("Dua of Prophet  عليه السلام")//9




    }

    private fun contentUpdate(pos:Int)
    {
        supportActionBar?.title = titles[pos]
        view_pager2.setCurrentItem(pos, true)
        mediaPlayer.reset()
        mediaPlayer = MediaPlayer.create(this, audioFiles[pos])
    }



}