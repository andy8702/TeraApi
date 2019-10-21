package com.zy.tera

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.zy.tera.fragments.BasicInfoFragment
import com.zy.tera.fragments.OneCourseFragment
import com.zy.tera.fragments.SearchCoachFragment
import com.zy.tera.fragments.ShopSearchFragment
import kotlinx.android.synthetic.main.activity_bottomnav.*

/**
 * Created by Yang ZHOU on 2019/10/21.
 */
class BottomNavActivity : BaseActivity() {

    lateinit var coachFragment: SearchCoachFragment
    lateinit var oneCourseFragment: OneCourseFragment
    lateinit var shopSearchFragment: ShopSearchFragment
    lateinit var basicInfoFragment: BasicInfoFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_bottomnav)

        initFragment()

        initView()

        showFragmentIndex(0)
    }

    fun initFragment() {
        coachFragment = SearchCoachFragment()
        oneCourseFragment = OneCourseFragment()
        shopSearchFragment = ShopSearchFragment()
        basicInfoFragment = BasicInfoFragment()
    }

    fun initView() {
        design_navigation_view.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.tab_one -> {
                    showFragmentIndex(0)
                    true
                }

                R.id.tab_two -> {
                    showFragmentIndex(1)
                    true
                }

                R.id.tab_three -> {
                    showFragmentIndex(2)
                    true
                }

                R.id.tab_four -> {
                    showFragmentIndex(3)
                    true
                }

                else -> {
                    false
                }

            }

        })
    }

    private fun showFragmentIndex(index: Int) {
        val transaction = supportFragmentManager.beginTransaction()

        when (index) {
            0 -> {
                transaction.replace(R.id.mainFragment, coachFragment)
            }

            1 -> {
                transaction.replace(R.id.mainFragment, oneCourseFragment)
            }

            2 -> {
                transaction.replace(R.id.mainFragment, shopSearchFragment)
            }

            3 -> {
                transaction.replace(R.id.mainFragment, basicInfoFragment)
            }

            else -> {

            }
        }
        transaction.addToBackStack(null)
        transaction.commit()

    }


}