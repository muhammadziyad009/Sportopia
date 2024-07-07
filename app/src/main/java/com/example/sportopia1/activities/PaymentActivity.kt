package com.example.sportopia1.activities



import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.Window
import com.example.sportopia1.dao.OrdersDAO
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.sportopia1.R
import com.example.sportopia1.database.OrdersDatabase
import com.example.sportopia1.databinding.ActivityPaymentBinding
import com.example.sportopia1.entities.Orders
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.Date

class PaymentActivity : AppCompatActivity() {
    lateinit var binding:ActivityPaymentBinding
    private lateinit var database:OrdersDatabase
    private lateinit var ordersDAO: OrdersDAO
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)




        supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.WHITE))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title= "Payment Details"
        supportActionBar?.elevation=0F

        database=OrdersDatabase.getDatabase(this)

        binding.btnPlaceOrder.setOnClickListener{

            val ordersname = binding.etOrdersFname.text.toString()
            val phonenumber = binding.etOrdersPnumber.text.toString()
            val address = binding.etOrdersAddress.text.toString()


            if(ordersname.equals("")){

                binding.etOrdersFname.error = "Enter Full Name"
                binding.etOrdersFname.requestFocus()

                GlobalScope.launch {
                    database.ordersDAO()
                        .insertOrders(Orders(0, ordersname, phonenumber, address, Date().toString(), ))



                }



            }

            //call function of custom dialog box
            showAlert()
            Handler(Looper.getMainLooper()).postDelayed(
                {

                    startActivity(Intent(this,Landing::class.java))
                    finish()
                },3000
            )


    }
            }

    private fun showAlert() {
        val dialog= Dialog(this)

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.confirmation_alert_box)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()

    }
}
