package br.com.tchars.calculadorasimples;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText primeiroValor;
    EditText segundoValor;
    TextView resultadoValor;

    Button botaoSomar;
    Button botaoSubtrair;
    Button botaoMultiplicar;
    Button botaoDividir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        primeiroValor = (EditText) findViewById(R.id.inputPrimeiroValor);
        segundoValor = (EditText) findViewById(R.id.inputSegundoValor);
        resultadoValor = (TextView) findViewById(R.id.textoValorResultado);

        botaoSomar = (Button) findViewById(R.id.botaoSomar);
        botaoSubtrair = (Button) findViewById(R.id.botaoSubtrair);
        botaoMultiplicar = (Button) findViewById(R.id.botaoMultiplicar);
        botaoDividir = (Button) findViewById(R.id.botaoDividir);

        botaoSomar.setOnClickListener(v -> {

            if (isValorVazio(primeiroValor.getText().toString()) ||
                isValorVazio(segundoValor.getText().toString()) )
            {
                toastMaker("Você deve preencher os valores...");
                return;
            }

            double v1 = retornaValorConvertido(primeiroValor.getText().toString());
            double v2 = retornaValorConvertido(segundoValor.getText().toString());

            Double resultadoOperacao = realizaConta(v1, v2, ETIPOS_DE_OPERACAO.SOMA);
            resultadoValor.setText(resultadoOperacao.toString());
        });

        botaoSubtrair.setOnClickListener(v -> {

            if (isValorVazio(primeiroValor.getText().toString()) ||
                    isValorVazio(segundoValor.getText().toString()) )
            {
                toastMaker("Você deve preencher os valores...");
                return;
            }

            double v1 = retornaValorConvertido(primeiroValor.getText().toString());
            double v2 = retornaValorConvertido(segundoValor.getText().toString());

            Double resultadoOperacao = realizaConta(v1, v2, ETIPOS_DE_OPERACAO.SUBTRACAO);
            resultadoValor.setText(resultadoOperacao.toString());
        });

        botaoMultiplicar.setOnClickListener(v -> {

            if (isValorVazio(primeiroValor.getText().toString()) ||
                    isValorVazio(segundoValor.getText().toString()) )
            {
                toastMaker("Você deve preencher os valores...");
                return;
            }

            double v1 = retornaValorConvertido(primeiroValor.getText().toString());
            double v2 = retornaValorConvertido(segundoValor.getText().toString());

            Double resultadoOperacao = realizaConta(v1, v2, ETIPOS_DE_OPERACAO.MULTIPLICACAO);
            resultadoValor.setText(resultadoOperacao.toString());
        });

        botaoDividir.setOnClickListener(v -> {

            if (isValorVazio(primeiroValor.getText().toString()) ||
                    isValorVazio(segundoValor.getText().toString()) )
            {
                toastMaker("Você deve preencher os valores...");
                return;
            }

            double v1 = retornaValorConvertido(primeiroValor.getText().toString());
            double v2 = retornaValorConvertido(segundoValor.getText().toString());

            if (v2 == 0) {
                toastMaker("Coé, irmão, divisão por zero não existe.");
                return;
            }

            Double resultadoOperacao = realizaConta(v1, v2, ETIPOS_DE_OPERACAO.DIVISAO);
            resultadoValor.setText(resultadoOperacao.toString());
        });

    }

    private enum ETIPOS_DE_OPERACAO {
        SOMA,
        SUBTRACAO,
        MULTIPLICACAO,
        DIVISAO
    }

    private boolean isValorVazio (String valor) {
        return valor.isEmpty();
    }

    private void toastMaker(String alerta) {
        Toast.makeText(MainActivity.this, alerta,
                Toast.LENGTH_LONG).show();
    }

    private double realizaConta(double v1, double v2, ETIPOS_DE_OPERACAO operacao) {
        switch (operacao) {
            case SOMA:
                return v1 + v2;
            case SUBTRACAO:
                return v1 - v2;
            case MULTIPLICACAO:
                return v1 * v2;
            case DIVISAO:
                return v1 / v2;
            default:
                return 0.0d;
        }
    }

    private double retornaValorConvertido(String valorASerConvertido) {
        return Double.parseDouble(valorASerConvertido);
    }

}