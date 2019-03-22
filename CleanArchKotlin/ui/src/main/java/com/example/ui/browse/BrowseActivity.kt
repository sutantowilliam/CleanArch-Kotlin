package com.example.ui.browse

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.presentation.browse.BrowseProfilesContract
import com.example.presentation.model.ProfileView
import com.example.ui.R
import com.example.ui.mapper.ProfileMapper
import dagger.android.AndroidInjection
import javax.inject.Inject
import kotlinx.android.synthetic.main.activity_browse.recycler_browse

class BrowseActivity : AppCompatActivity(), BrowseProfilesContract.View {
    @Inject
    lateinit var onboardingPresenter: BrowseProfilesContract.Presenter
    @Inject
    lateinit var browseAdapter: BrowseAdapter
    @Inject
    lateinit var mapper: ProfileMapper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_browse)
        AndroidInjection.inject(this)
        setupBrowseRecycler()
    }

    override fun setPresenter(presenter: BrowseProfilesContract.Presenter) {
        onboardingPresenter = presenter
    }

    override fun showProfiles(profiles: List<ProfileView>) {
        browseAdapter.profiles = profiles.map { mapper.mapToViewModel(it) }
        browseAdapter.notifyDataSetChanged()
        recycler_browse.visibility = View.VISIBLE
    }

    override fun onStart() {
        super.onStart()
        onboardingPresenter.start()
    }

    private fun setupBrowseRecycler() {
        recycler_browse.layoutManager = LinearLayoutManager(this)
        recycler_browse.adapter = browseAdapter
    }
}