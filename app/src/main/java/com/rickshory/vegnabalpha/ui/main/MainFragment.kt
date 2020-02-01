package com.rickshory.vegnabalpha.ui.main

import android.app.Activity
import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.auth.FirebaseAuth
import com.rickshory.vegnabalpha.R
import com.rickshory.vegnabalpha.data.LoginViewModel
import com.rickshory.vegnabalpha.databinding.FragmentMainBinding
import kotlinx.coroutines.*

class MainFragment : Fragment() {

    companion object {
        const val TAG = "MainFragment"
        const val SIGN_IN_RESULT_CODE = 1001
    }

    // Get a reference to the ViewModel scoped to this Fragment
    private val viewModel by viewModels<LoginViewModel>()
    private lateinit var binding: FragmentMainBinding

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
        viewLifecycleOwner.lifecycleScope.launch { // context of the parent, main runBlocking coroutine
            Log.i(TAG,"main runBlocking      : I'm working in thread ${Thread.currentThread().name}")
        }
        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.Unconfined) { // not confined -- will work with main thread
            Log.i(TAG,"Unconfined            : I'm working in thread ${Thread.currentThread().name}")
        }
        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.Default) { // will get dispatched to DefaultDispatcher
            Log.i(TAG,"Default               : I'm working in thread ${Thread.currentThread().name}")
        }
        viewLifecycleOwner.lifecycleScope.launch(newSingleThreadContext("MyOwnThread")) { // will get its own new thread
            Log.i(TAG,"newSingleThreadContext: I'm working in thread ${Thread.currentThread().name}")
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == SIGN_IN_RESULT_CODE) {
            val response = IdpResponse.fromResultIntent(data)
            if (resultCode == Activity.RESULT_OK) {
                // User successfully signed in
                Log.i(
                    TAG,
                    "Successfully signed in user ${FirebaseAuth.getInstance().currentUser?.displayName}!"
                )
            } else {
                // Sign in failed. If response is null the user canceled the
                // sign-in flow using the back button. Otherwise check
                // response.getError().getErrorCode() and handle the error.
                Log.i(TAG, "Sign in unsuccessful ${response?.error?.errorCode}")
            }
        }
    }

    /**
     * Observes the authentication state and changes the UI accordingly.
     * If there is a logged in user: (1) show a logout button and (2) display their name.
     * If there is no logged in user: show a login button
     */
    private fun observeAuthenticationState() {
//        val noteToDisplay = viewModel.getNoteToDisplay(requireContext())
        val noteToDisplay =""

            viewModel.authenticationState.observe(viewLifecycleOwner, Observer { authenticationState ->
            when (authenticationState) {
                LoginViewModel.AuthenticationState.AUTHENTICATED -> {
                    binding.userText.text = getUserPersonalization(noteToDisplay)

                    binding.authButton.text = getString(R.string.logout_button_text)
                    binding.authButton.setOnClickListener {
                        AuthUI.getInstance().signOut(requireContext())
                    }
                }
                else -> {
                    binding.userText.text = getString(R.string.message_noauth)

                    binding.authButton.text = getString(R.string.login_button_text)
                    binding.authButton.setOnClickListener {
                        launchSignInFlow()
                    }
                }
            }
        })
    }

    private fun getUserPersonalization(optionalNote: String): String {
        return String.format(
            resources.getString(
                R.string.user_message_authed,
                FirebaseAuth.getInstance().currentUser?.displayName,
                optionalNote)
        )
    }

    private fun launchSignInFlow() {
        // Give users the option to sign in / register with their email
        // or Google account.
        // If users choose to register with their email,
        // they will need to create a password as well
        val providers = arrayListOf(
            AuthUI.IdpConfig.EmailBuilder().build(),
            AuthUI.IdpConfig.GoogleBuilder().build()
            // Can provide more ways to register & sign in here
        )

        // Create and launch sign-in intent.
        // We listen to the response of this activity with the
        // SIGN_IN_RESULT_CODE code
        startActivityForResult(
            AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(providers)
                .build(),
            SIGN_IN_RESULT_CODE
        )
    }
}
