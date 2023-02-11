package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.calculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvAc.setOnClickListener {

            binding.inputText.text = ""
            binding.outputText.text = ""
        }

        binding.tv0.setOnClickListener {

            binding.inputText.append("0")
        }

        binding.tv1.setOnClickListener {

            binding.inputText.append("1")
        }

        binding.tv2.setOnClickListener {

            binding.inputText.append("2")
        }

        binding.tv3.setOnClickListener {

            binding.inputText.append("3")
        }

        binding.tv4.setOnClickListener {

            binding.inputText.append("4")
        }

        binding.tv5.setOnClickListener {

            binding.inputText.append("5")
        }

        binding.tv6.setOnClickListener {

            binding.inputText.append("6")
        }

        binding.tv7.setOnClickListener {

            binding.inputText.append("7")
        }

        binding.tv8.setOnClickListener {

            binding.inputText.append("8")
        }

        binding.tv9.setOnClickListener {

            binding.inputText.append("9")
        }

        binding.tvAddition.setOnClickListener {

            binding.inputText.append("+")
        }

        binding.tvSubtraction.setOnClickListener {

            binding.inputText.append("-")
        }

        binding.tvMultiplication.setOnClickListener {

            binding.inputText.append("*")
        }

        binding.tvDivided.setOnClickListener {

            binding.inputText.append("/")
        }

        binding.tvDot.setOnClickListener {

            binding.inputText.append(".")
        }

        binding.tvStartBracket.setOnClickListener {

            binding.inputText.append("(")
        }

        binding.tvClear.setOnClickListener {
            val length = binding.inputText.length()
            if (length > 0) {
                binding.inputText.text = binding.inputText.text.subSequence(0, length - 1)
            }
        }

        binding.tvEndBracket.setOnClickListener {

            binding.inputText.append(")")
        }

        binding.tvEqual.setOnClickListener {

            val expression = ExpressionBuilder(binding.inputText.text.toString()).build()
            val result = expression.evaluate()
            val longresult = result.toLong()

            if (result == longresult.toDouble()) {

                binding.outputText.text = longresult.toString()
            } else {
                binding.outputText.text = result.toString()
            }
        }
    }
}