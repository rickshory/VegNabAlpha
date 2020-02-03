package com.rickshory.vegnabalpha.ui.download

import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.rickshory.vegnabalpha.R
import com.rickshory.vegnabalpha.databinding.FragmentDownloadSppBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DownloadSppFragment : Fragment()  {

    companion object {
        const val TAG = "DownloadSppFragment"
    }

    private lateinit var binding: FragmentDownloadSppBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_download_spp, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.downloadBtn.setOnClickListener {
            viewLifecycleOwner.lifecycleScope.launch(Dispatchers.Default) { // will get dispatched to DefaultDispatcher
                Log.i(TAG,"Default               : I'm working in thread ${Thread.currentThread().name}")
            }
//            // we are going to call Download async task to begin our download
//            val task = DownloadTask(ProgressDialog(applicationContext));
//            task.execute("http://www.rickshory.com/downloads/spplist.txt");
        }
    }
}