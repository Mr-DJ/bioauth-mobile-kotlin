package com.example.biopass

import android.Manifest
import android.app.KeyguardManager
import android.content.Context
import android.content.pm.PackageManager
import android.hardware.biometrics.BiometricPrompt
import android.os.Build
import android.os.Bundle
import android.os.CancellationSignal
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.biopass.presentation.ConnectedWeb
import com.example.biopass.presentation.biometrics.BiometricScreen
import com.example.biopass.presentation.login_register.BioPassLogin
import com.example.biopass.presentation.screen.Screens
import com.example.biopass.ui.theme.BioPassTheme

class MainActivity : ComponentActivity() {

    private var cancellationSignal: CancellationSignal? = null


    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BioPassTheme {

                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Screens.LoginScreen.route){
                    composable(Screens.LoginScreen.route){
                        BioPassLogin(navController)
                    }
                    composable(Screens.ConnectedWebScreen.route){
                        ConnectedWeb(navController)
                    }
                    composable(Screens.BiometricScreen.route){
                        BiometricScreen { launchBiometric() }
                    }
                }

            }
        }
    }

    private val authenticationCalBack: BiometricPrompt.AuthenticationCallback
        get() = @RequiresApi(Build.VERSION_CODES.P)
        object : BiometricPrompt.AuthenticationCallback() {
            override fun onAuthenticationError(errorCode: Int, errString: CharSequence?) {
                notifyUser("Authentication Error $errorCode")
                super.onAuthenticationError(errorCode, errString)
            }

            override fun onAuthenticationHelp(helpCode: Int, helpString: CharSequence?) {
                super.onAuthenticationHelp(helpCode, helpString)
            }

            override fun onAuthenticationFailed() {
                super.onAuthenticationFailed()
            }

            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult?) {
                notifyUser("Authentication Succeeded "+result.toString())
                super.onAuthenticationSucceeded(result)
            }
        }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun checkBiometricSupport(): Boolean{
        val keyguardManager = getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager

        if (!keyguardManager.isDeviceSecure){
            notifyUser("lock screen security not enabled in the setting")
            return false
        }
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.USE_BIOMETRIC) != PackageManager.PERMISSION_GRANTED){
            notifyUser("Finger print authentication permission not enabled")
            return false
        }
        return packageManager.hasSystemFeature(PackageManager.FEATURE_FINGERPRINT)


    }

    @RequiresApi(Build.VERSION_CODES.P)
    private fun launchBiometric(){
        if (checkBiometricSupport()){
            val  biometricPrompt = BiometricPrompt
                .Builder(this)
                .setTitle("Allow Biometric Authentication")
                .setSubtitle("You will no longer required username and password during login")
                .setDescription("We use biometric authentication to protect your data")
                .setNegativeButton("Not Now", this.mainExecutor) { dialogInterface, i ->
                    notifyUser("Authentication cancelled")

                }
                .build()

            biometricPrompt.authenticate(getCancelletionSignal(), mainExecutor, authenticationCalBack)

        }
    }

    private fun getCancelletionSignal(): CancellationSignal {
        cancellationSignal = CancellationSignal()
        cancellationSignal?.setOnCancelListener {
            notifyUser("Ath Cancelled via Signal")
        }

        return cancellationSignal as CancellationSignal
    }

    private fun notifyUser(message: String){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show()
    }

}
