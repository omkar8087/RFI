package com.example.rfi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.findNavController
import com.example.rfi.database.Api.YourRequestModel
import com.example.rfi.viewmodel.RfiViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: RfiViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_login__page)

        val requestModel = YourRequestModel("value1", "value2")
        viewModel.fetchUserData(requestModel) { userRole ->
            navigateToRoleFragment(userRole)

        }
    }

    private fun navigateToRoleFragment(userRole: String){
        val navController = findNavController(R.id.nav_graph)

        when(userRole){
            "maker" -> navController.navigate(R.id.action_login_Page_to_maker_home)
            "checker" -> navController.navigate(R.id.action_login_Page_to_checker_home)
            "approver" -> navController.navigate(R.id.action_login_Page_to_approver_home)
        }
    }
}