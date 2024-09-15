package com.example.managerpracticeapp.ui.reservation
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.webkit.JavascriptInterface
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.managerpracticeapp.R
import com.example.managerpracticeapp.databinding.ActivityReservationStep5Binding

class ReservationStep5Activity : AppCompatActivity() {
    private lateinit var binding: ActivityReservationStep5Binding
    private lateinit var selectedAddress : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityReservationStep5Binding.inflate(layoutInflater)
        setContentView(binding.root)

        navigateToPrevious()
        navigateToNext()
        createWeb()
    }
    private fun createWeb(){
        binding.roadAddressEditText.setOnClickListener{
            showWebViewDialog();
        }
    }
    private fun showWebViewDialog(){
        val dialogView = LayoutInflater.from(this).inflate(R.layout.search_address_dialog,null)
        val builder = AlertDialog.Builder(this).setView(dialogView)
        val alertDialog = builder.create()

        val webView = dialogView.findViewById<WebView>(R.id.dialog_webview)

        webView.settings.apply {
            javaScriptEnabled = true
            allowFileAccess = true
            domStorageEnabled = true
            javaScriptCanOpenWindowsAutomatically = true
        }
        webView.webChromeClient = WebChromeClient()
        // webView.loadUrl("file:///android_asset/www/search_address.html") // HTTP 서버를 통해 HTML 파일을 제공하도록 설정하는 것이 좋습니다.
        webView.addJavascriptInterface(AndroidBridge(), "androidInterface")

        alertDialog.show()
        alertDialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
    }
    inner class AndroidBridge {

        @JavascriptInterface
        fun processAddress(address: String) {
            // 선택한 주소를 EditText에 표시
            selectedAddress = address
            runOnUiThread {
                binding.roadAddressEditText.setText(address)
            }
        }
    }
    private fun navigateToPrevious() {
        binding.backBtn.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        binding.previousBtn.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun navigateToNext() {
        binding.nextBtn.setOnClickListener {
            val intent = Intent(this, ReservationStep6Activity::class.java)
            startActivity(intent)
        }
    }
}
