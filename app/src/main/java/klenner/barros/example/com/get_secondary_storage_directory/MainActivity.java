package klenner.barros.example.com.get_secondary_storage_directory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import klenner.barros.example.com.get_secondary_storage_directory.Utils.Directories;

public class MainActivity extends AppCompatActivity {

    private Button btnPrimary,btnSecondary;
    private TextView txtVwPrimary,txtVwSecondary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPrimary=findViewById(R.id.btnPrimary);
        btnSecondary=findViewById(R.id.btnSecondary);
        txtVwPrimary=findViewById(R.id.txtVwPrimary);
        txtVwSecondary=findViewById(R.id.txtVwSecondary);

        btnPrimary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String primaryStoreDir =Directories.getPrimaryStoreDir();
                txtVwPrimary.setText(primaryStoreDir);
            }
        });

        btnSecondary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String primaryStoreDir =Directories.getSecondaryStoreDir(getApplicationContext());
                txtVwSecondary.setText(primaryStoreDir);
            }
        });
    }
}
