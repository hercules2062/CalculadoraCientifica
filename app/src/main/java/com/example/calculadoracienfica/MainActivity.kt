package com.example.calculadoracienfica

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import net.objecthunter.exp4j.ExpressionBuilder
import kotlin.math.cos
import kotlin.math.log
import kotlin.math.pow
import kotlin.math.sin
import kotlin.math.sqrt
import kotlin.math.tan

class MainActivity : AppCompatActivity() {
    private lateinit var display : TextView
    private lateinit var input_resultado : TextView
    private var operacao_input : Int = 0
    private var valor1_input : Double = 0.0
    private var valor2_input : Double = 0.0
    private var resetar_input : Boolean = false
    private var resetar_display : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        enableEdgeToEdge()

        display = findViewById<TextView>(R.id.display)
        input_resultado = findViewById<TextView>(R.id.input_resultado)

        val btn_0 = findViewById<Button>(R.id.btn_0)
        val btn_1 = findViewById<Button>(R.id.btn_1)
        val btn_2 = findViewById<Button>(R.id.btn_2)
        val btn_3 = findViewById<Button>(R.id.btn_3)
        val btn_4 = findViewById<Button>(R.id.btn_4)
        val btn_5 = findViewById<Button>(R.id.btn_5)
        val btn_6 = findViewById<Button>(R.id.btn_6)
        val btn_7 = findViewById<Button>(R.id.btn_7)
        val btn_8 = findViewById<Button>(R.id.btn_8)
        val btn_9 = findViewById<Button>(R.id.btn_9)
        val btn_sen = findViewById<Button>(R.id.btn_sen)
        val btn_cos = findViewById<Button>(R.id.btn_cos)
        val btn_tan = findViewById<Button>(R.id.btn_tan)
        val btn_2nd = findViewById<Button>(R.id.btn_segundo)
        val btn_pi = findViewById<Button>(R.id.btn_pi)
        val btn_e = findViewById<Button>(R.id.btn_e)
        val btn_c = findViewById<Button>(R.id.btn_c)
        val btn_del = findViewById<Button>(R.id.btn_del)
        val btn_quadrado = findViewById<Button>(R.id.btn_ao_quadrado)
        val btn_1barrax = findViewById<Button>(R.id.btn_1barrax)
        val btn_modulo = findViewById<Button>(R.id.btn_modulo)
        val btn_exp = findViewById<Button>(R.id.btn_exp)
        val btn_mod = findViewById<Button>(R.id.btn_mod)
        val btn_raiz_quadrada = findViewById<Button>(R.id.btn_raiz_quadrada)
        val btn_abre_parenteses = findViewById<Button>(R.id.btn_abre_parenteses)
        val btn_fecha_parenteses = findViewById<Button>(R.id.btn_fecha_parenteses)
        val btn_fatorial = findViewById<Button>(R.id.btn_fatorial)
        val btn_divisao = findViewById<Button>(R.id.btn_divisao)
        val btn_elevado = findViewById<Button>(R.id.btn_elevado)
        val btn_multiplicacao = findViewById<Button>(R.id.btn_multiplicacao)
        val btn_10_elevado = findViewById<Button>(R.id.btn_10_elevado)
        val btn_subtrai = findViewById<Button>(R.id.btn_subtrai)
        val btn_log = findViewById<Button>(R.id.btn_log)
        val btn_soma = findViewById<Button>(R.id.btn_soma)
        val btn_in = findViewById<Button>(R.id.btn_in)
        val btn_mais_menos = findViewById<Button>(R.id.btn_mais_menos)
        val btn_ponto = findViewById<Button>(R.id.btn_ponto)
        val btn_igual = findViewById<Button>(R.id.btn_igual)

        btn_0.setOnClickListener {
            adiciona_input("0")
        }
        btn_1.setOnClickListener {
            adiciona_input("1")
        }
        btn_2.setOnClickListener {
            adiciona_input("2")
        }
        btn_3.setOnClickListener {
            adiciona_input("3")
        }
        btn_4.setOnClickListener {
            adiciona_input("4")
        }
        btn_5.setOnClickListener {
            adiciona_input("5")
        }
        btn_6.setOnClickListener {
            adiciona_input("6")
        }
        btn_7.setOnClickListener {
            adiciona_input("7")
        }
        btn_8.setOnClickListener {
            adiciona_input("8")
        }
        btn_9.setOnClickListener {
            adiciona_input("9")
        }
        btn_del.setOnClickListener{
            apaga_ultimo()
        }
        btn_c.setOnClickListener{
            limpa_tela()
        }
        btn_pi.setOnClickListener{
            adiciona_input("3.141592")
            resetar_input = true
        }
        btn_e.setOnClickListener{
            adiciona_input("2.718281")
            resetar_input = true
        }
        btn_sen.setOnClickListener{
            if(input_resultado.text.toString()!="0"){
                adiciona_display_equacao("sen("+input_resultado.text.toString()+")")
                resetar_input = true
                adiciona_input(sin(input_resultado.text.toString().toDouble()).toString())
                resetar_display = true
                resetar_input = true
            }
        }
        btn_cos.setOnClickListener{
            if(input_resultado.text.toString()!="0"){
                adiciona_display_equacao("cos("+input_resultado.text.toString()+")")
                resetar_input = true
                adiciona_input(cos(input_resultado.text.toString().toDouble()).toString())
                resetar_display = true
                resetar_input = true
            }
        }
        btn_tan.setOnClickListener{
            if(input_resultado.text.toString()!="0"){
                adiciona_display_equacao("tan("+input_resultado.text.toString()+")")
                resetar_input = true
                adiciona_input(tan(input_resultado.text.toString().toDouble()).toString())
                resetar_display = true
                resetar_input = true
            }
        }
        btn_quadrado.setOnClickListener{
            var resultado = input_resultado.text.toString().toDouble().pow(2)
            adiciona_display_equacao(input_resultado.text.toString()+"^2")
            resetar_input = true
            adiciona_input(resultado.toString())
            resetar_input = true
        }
        btn_1barrax.setOnClickListener{
            var resultado = 1/input_resultado.text.toString().toDouble()
            resetar_input = true
            adiciona_input(resultado.toString())
            resetar_input = true
        }
        btn_modulo.setOnClickListener{
            var valor = input_resultado.text.toString().toDouble()
            adiciona_display_equacao("abs("+input_resultado.text.toString()+")")
            if (valor<0){
                valor*(-1)
            }
            resetar_input = true
            adiciona_input(valor.toString())
            resetar_input = true
        }
        btn_exp.setOnClickListener{
            // valor*(10^x)
            if(input_resultado.text.toString() != "0") {
                valor1_input = input_resultado.text.toString().toDouble()
                operacao_input = 1
                adiciona_input(",e+")
            }
            resetar_input = true
        }
        btn_mod.setOnClickListener{
            adiciona_input("mod")
            valor1_input = input_resultado.text.toString().toDouble()
            operacao_input = 3
        }
        btn_raiz_quadrada.setOnClickListener{
            if(input_resultado.text.toString() != "0"){
                resetar_input = true
                adiciona_display_equacao("sqrt("+input_resultado.text.toString()+")")
                adiciona_input(sqrt(input_resultado.text.toString().toDouble()).toString())
                resetar_display = true
            }
        }
        btn_abre_parenteses.setOnClickListener{
            if(input_resultado.text.toString() != "0"){
                adiciona_operacao("*(")
            }else{
                adiciona_operacao("(")
            }
        }
        btn_fecha_parenteses.setOnClickListener{
            if(display.text.toString().contains("(")){
                adiciona_operacao(")")
            }
            resetar_input = true
        }
        btn_elevado.setOnClickListener{
            operacao_input = 2
            if(input_resultado.text.toString() == "0") {
                adiciona_input("0^")
            }else{
                valor1_input = input_resultado.text.toString().toDouble()
                adiciona_input("^")
            }
            //resetar_input = true
            resetar_display = true
        }
        btn_10_elevado.setOnClickListener{
            adiciona_display_equacao(10.0.pow(input_resultado.text.toString().toDouble()).toString())
            resetar_input = true
            resetar_display = true
        }
        btn_log.setOnClickListener{
            if(input_resultado.text.toString() == "0"){
                input_resultado.text = "Inválido"
            }else{
                var resultado = log(input_resultado.text.toString().toDouble(), 10.0)
                //adiciona_display_equacao("log("+input_resultado.text.toString()+")")
                adiciona_display_equacao(resultado.toString())
                resetar_input = true
                adiciona_input(resultado.toString())
                resetar_input = true
                resetar_display = true
            }
        }
        btn_soma.setOnClickListener{
            adiciona_operacao("+")
        }
        btn_subtrai.setOnClickListener{
            if(input_resultado.text.toString()=="0"){
                input_resultado.text = "-"
            }else{
                adiciona_operacao("-")
            }
        }
        btn_multiplicacao.setOnClickListener{
            adiciona_operacao("*")
        }
        btn_divisao.setOnClickListener{
            adiciona_operacao("/")
        }
        btn_mais_menos.setOnClickListener{
            var resultado = input_resultado.text.toString().toDouble()*(-1)
            input_resultado.text = resultado.toString()
        }
        btn_fatorial.setOnClickListener{
            var x = input_resultado.text.toString().toDouble()
            var resultado = x
            while (x>1){
                x=x-1
                resultado = resultado * x
            }
            adiciona_display_equacao(resultado.toString())
        }
        btn_ponto.setOnClickListener{
            adiciona_input(".")
        }
        btn_igual.setOnClickListener{
            adiciona_display_equacao()
            calcula_resultado_expressao()
            //input_resultado.text = eval(display.text.toString()).toString()
            resetar_input = true
            resetar_display = true
        }
    }

    fun adiciona_operacao(operacao : String){
        if(resetar_input == true && resetar_display == false){
            adiciona_display_equacao(operacao)
        }else{
            if(input_resultado.text.toString()!="0"){
                adiciona_display_equacao(input_resultado.text.toString())
                adiciona_display_equacao(operacao)
                resetar_input = true
            }else{
                if(operacao == "(" || operacao == "-"){
                    input_resultado.text = operacao
                }
            }
        }
    }

    fun adiciona_input(string : String){
        if(resetar_input == true ){
            input_resultado.text = "0"
            resetar_input = false
        }
        if (input_resultado.text == "0") {
            if (string == "0" || string == "1" || string == "2" || string == "3" || string == "4" || string == "5" || string == "6" || string == "7" || string == "8" || string == "9") {
                input_resultado.text = string
            } else {
                val sb = StringBuilder()
                input_resultado.text = string //sb.append(input_resultado.text).append(string).toString()
            }
        } else {
            val sb = StringBuilder()
            input_resultado.text = sb.append(input_resultado.text).append(string).toString()
        }
    }

    fun adiciona_display_equacao(string: String){
        if(resetar_display == true){
            display.text = ""
            resetar_display = false
        }
        val sb = StringBuilder()
        display.text = sb.append(display.text).append(string).toString()
        //input_resultado.text = "0"
    }

    fun adiciona_display_equacao(){
        if(resetar_display == true){
            display.text = ""
            resetar_display = false
        }
        val sb = StringBuilder()
        display.text = sb.append(display.text).append(input_resultado.text).toString()
        //input_resultado.text = "0"
    }

    fun apaga_ultimo(){
        if (resetar_input == true){
            input_resultado.text = "0"
        }else {
            if (input_resultado.text.contains(",e+")) {
                input_resultado.text = input_resultado.text.dropLast(3)
            } else {
                if (!input_resultado.text.contains("0")) {
                    input_resultado.text = input_resultado.text.dropLast(1)
                }
            }
        }
    }

    fun limpa_tela() {
        if (input_resultado.text != "0") {
            input_resultado.text = "0"
        } else {
            display.text = ""
        }
    }

    fun calcula_resultado_expressao(){
        val e = ExpressionBuilder(display.text.toString()).build()
        input_resultado.text = e.evaluate().toString()
    }
}