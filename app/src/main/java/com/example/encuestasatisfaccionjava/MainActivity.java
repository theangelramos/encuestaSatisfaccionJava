package com.example.encuestasatisfaccionjava;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText nombreInput;
    private SeekBar satisfaccionSeekBar;
    private EditText comentariosInput;
    private Button enviarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inicialización de las vistas
        nombreInput = findViewById(R.id.nombreInput);
        satisfaccionSeekBar = findViewById(R.id.satisfaccionSeekBar);
        comentariosInput = findViewById(R.id.comentariosInput);
        enviarButton = findViewById(R.id.enviarButton);

        // Configurar el SeekBar
        satisfaccionSeekBar.setMax(10); // Escala de 0 a 10

        // Configuración del click listener para el botón enviar
        enviarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = nombreInput.getText().toString();
                int satisfaccion = satisfaccionSeekBar.getProgress();
                String comentarios = comentariosInput.getText().toString();

                // Crear mensaje para el Toast
                String mensaje = "Nombre: " + nombre +
                        "\nNivel de satisfacción: " + satisfaccion + "/10" +
                        "\nComentarios: " + comentarios;

                Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_LONG).show();
            }
        });
    }
}