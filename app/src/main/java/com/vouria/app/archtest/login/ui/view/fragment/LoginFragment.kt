package com.vouria.app.archtest.login.ui.view.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.databinding.ktx.BuildConfig
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.vouria.app.archtest.R
import com.vouria.app.archtest.core.base.BaseFragment
import com.vouria.app.archtest.core.data.local.AppDataBase
import com.vouria.app.archtest.databinding.FragmentLoginBinding
import com.vouria.app.archtest.login.data.local.LocalDataSource
import com.vouria.app.archtest.login.data.local.dao.UserDao
import com.vouria.app.archtest.login.data.remote.RemoteDataSource
import com.vouria.app.archtest.login.data.remote.interfaces.LoginApiService
import com.vouria.app.archtest.login.data.repository.UserRepository
import com.vouria.app.archtest.login.ui.NetworkResult
import com.vouria.app.archtest.login.ui.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>() {
    //    @Inject
//    lateinit var context1: Context
    private val BASE_URL = "https://api.example.com/"

    //    private lateinit var viewModel: LoginViewModel
    private val viewModel: LoginViewModel by viewModels()
    private lateinit var userRepository: UserRepository
    private lateinit var local: LocalDataSource
    private lateinit var remote: RemoteDataSource

    private lateinit var apiService: LoginApiService
    private lateinit var dataBase: AppDataBase
    private lateinit var userDao: UserDao

    private lateinit var navController: NavController
    private lateinit var binding: FragmentLoginBinding

//    @Inject
//    lateinit var context1: Context

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

//        dataBase=AppDataBase.getDatabase(requireContext())
//        userDao = dataBase.userDao()
//        local = LocalDataSource(userDao)
//        apiService=provideRetrofit(provideOkHttpClient()).create(LoginApiService::class.java)
//        remote = RemoteDataSource(apiService)
//        userRepository= UserRepository(remote,local)
//        viewModel = ViewModelProvider(
//            this,
//            DemoViewModelFactory(userRepository)
//        )[LoginViewModel::class.java]

        observe()
        listener()

    }

    private fun listener() {
        binding.txtGoToMain.setOnClickListener {

            viewModel.login(
                binding.tvUsername.text.toString().trim(),
                binding.tvPassword.text.toString().trim()
            )
//            navController.navigate(R.id.action_loginFragment2_to_mainActivity2)
        }
        binding.txtGoToForgetPage.setOnClickListener {
            navController.navigate(R.id.action_loginFragment2_to_forgetPasswordFragment)
        }
    }

    private fun observe() {
        viewModel.loginResponse.observe(viewLifecycleOwner) {
            when (it) {
                is NetworkResult.Loading -> {
                    binding.progressBar.isVisible = it.isLoading
                }

                is NetworkResult.Success -> {
                    Log.e("TAG", it.data.email)
                    binding.progressBar.isVisible = false
                    navController.navigate(R.id.action_loginFragment2_to_mainActivity2)
                }

                is NetworkResult.Failure -> {
                    binding.progressBar.isVisible = false
                }
            }
        }
    }

    class DemoViewModelFactory constructor(private val repository: UserRepository) :
        ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
                LoginViewModel(this.repository) as T
            } else {
                throw IllegalArgumentException("ViewModel Not Found")
            }
        }
    }

    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level =
                    if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
            })
            .build()
    }

    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


}