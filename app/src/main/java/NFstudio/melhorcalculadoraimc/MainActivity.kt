package NFstudio.melhorcalculadoraimc

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners();
    }

    private fun setListeners(){


        btCalcula.setOnClickListener {
            CalcularIMC(etPeso.text.toString(),etAltura.text.toString())

        }

        //Aqui colocamos uma ação para o botão informações
        btInform.setOnClickListener{
            //aqui chamamos a ResultActivity
            val intent = Intent(this,ResultActivity::class.java)
            startActivity(intent)
        }

    }


    private fun CalcularIMC(peso:String, altura:String){
        val peso = peso.toFloatOrNull()
        val altura = altura.toFloatOrNull()
        if (peso != null && altura != null){

            var imc = peso / (altura * altura)
            tvIMC.text = "IMC\n%.2f".format(imc)

            //depois que mostrar o valor mostra o botão de informações;
            gMostraBt.isVisible = true

        }
    }
}