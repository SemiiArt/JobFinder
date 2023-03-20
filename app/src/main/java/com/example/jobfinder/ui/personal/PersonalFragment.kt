package com.example.jobfinder.ui.personal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.jobfinder.R
import com.example.jobfinder.databinding.FragmentPersonalBinding
import com.example.jobfinder.ui.authentication.signup.SignUpScreen
import com.example.jobfinder.ui.theme.JobFinderTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PersonalFragment : Fragment() {

    private var _binding: FragmentPersonalBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(PersonalViewModel::class.java)

        _binding = FragmentPersonalBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.composeView.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                JobFinderTheme {
                    PersonalScreen(
                        onLogOutSuccess = {
                            findNavController().navigate(R.id.action_navigation_notifications_to_logInFragment2)
                        },
                        onNavigateToChangePassword = {
                            findNavController().navigate(R.id.action_navigation_notifications_to_changePasswordFragment)
                        },
                        onNavigateToAboutUs = {
                            findNavController().navigate(R.id.action_navigation_notifications_to_aboutUsFragment)
                        }
                    )
                }
            }
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}