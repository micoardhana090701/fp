package com.packagesayur.yursayur.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.packagesayur.yursayur.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    lateinit var binding: ActivityRegisterBinding
    lateinit var mAuth: FirebaseAuth;
    private var mShouldFinish = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mAuth = FirebaseAuth.getInstance()

        binding.tvLogin.setOnClickListener{
            finish()
        }

        binding.btnRegisterR.setOnClickListener{
            val email = binding.etEmailR.text.toString()
            val password = binding.etPasswordR.text.toString()
            val passwordConf = binding.etPasswordRType.text.toString()

            if (email.isEmpty()){
                binding.etEmailR.error = "Email Harus Diisi"
                binding.etEmailR.requestFocus()
                return@setOnClickListener
            }
            if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.etEmailR.error = "Format Email Tidak Sesuai"
                binding.btnRegisterR.requestFocus()
                return@setOnClickListener
            }
            if (passwordConf != password){
                Toast.makeText(this,"Password Tidak Sama", Toast.LENGTH_SHORT).show()
            }
            if (passwordConf.isEmpty()){
                binding.etPasswordRType.error = "Password Konfirmasi Harus Diisi"
                binding.etPasswordRType.requestFocus()
                return@setOnClickListener
            }
            if (password.isEmpty()){
                binding.etPasswordR.error = "Password Tidak Boleh Kosong"
                binding.etPasswordR.requestFocus()
                return@setOnClickListener
            }
            if (password.length < 8){
                binding.etPasswordR.error = "Password Minimal 8 Karakter"
                binding.etPasswordR.requestFocus()
                return@setOnClickListener
            }
            mShouldFinish = true
            RegisterUser(email, password)
        }
    }

    private fun RegisterUser(email: String, password: String) {
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this){
                if (it.isSuccessful){
                    Toast.makeText(this, "Registrasi Berhasil", Toast.LENGTH_SHORT).show()
                    val sharedPreferences = getSharedPreferences("login_status", Context.MODE_PRIVATE)
                    val editor = sharedPreferences.edit()
                    editor.putBoolean("isLoggedIn", true)
                    editor.apply()
                    val intent = Intent(this, HomeActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this, "Registrasi Gagal", Toast.LENGTH_SHORT).show()
                }
            }
    }
    override fun onStop() {
        super.onStop()
        if (mShouldFinish) {
            finish()
        }
    }
}

