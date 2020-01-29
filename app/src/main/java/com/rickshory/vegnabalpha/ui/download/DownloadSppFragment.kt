package com.rickshory.vegnabalpha.ui.download

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.rickshory.vegnabalpha.R

class DownloadSppFragment : Fragment()  {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)

        // TODO Remove the line below when observeAuthenticationState is implemented
        binding.authButton.text = getString(R.string.login_button_text)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeAuthenticationState()
        binding.authButton.setOnClickListener { launchSignInFlow() }
    }
}