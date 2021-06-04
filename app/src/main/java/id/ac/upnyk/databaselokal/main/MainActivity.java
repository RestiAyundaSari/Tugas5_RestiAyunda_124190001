package id.ac.upnyk.databaselokal.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import id.ac.upnyk.databaselokal.R;
import id.ac.upnyk.databaselokal.entity.AppDatabase;
import id.ac.upnyk.databaselokal.entity.DataDesa;

public class MainActivity extends AppCompatActivity {
    private EditText etDesa, etKec, etKab, etRT,etWarga,etBangun ;
    private Button btnSubmit, btnLihat;
    private String setDesa, setKec, setKab, setRT,setWarga,setBangun ;

    AppDatabase appDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etDesa= findViewById(R.id.et_nama_desa);
        etKec = findViewById(R.id.et_kecamatan);
        etKab = findViewById(R.id.et_kabupaten);
        etRT = findViewById(R.id.et_jml_RT);
        etWarga = findViewById(R.id.et_jml_warga);
        etBangun = findViewById(R.id.et_jml_bangunan);;
        btnSubmit = findViewById(R.id.btn_submit);
        btnLihat = findViewById(R.id.btn_lihat);
        appDatabase = AppDatabase.iniDb(getApplicationContext());
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input();
                Intent submit = new Intent(getApplicationContext(), LihatDataDesa.class);
                startActivity(submit);
            }
        });
        btnLihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lihat = new Intent(getApplicationContext(), LihatDataDesa.class);
                startActivity(lihat);
            }
        });
    }
    public void input(){

        setDesa = etDesa.getText().toString();
        setKec = etKec.getText().toString();
        setKab = etKab.getText().toString();
        setRT = etRT.getText().toString();
        setWarga = etWarga.getText().toString();
        setBangun = etBangun.getText().toString();

        final DataDesa dataDesa = new DataDesa();
        dataDesa.setDesa(setDesa);
        dataDesa.setKecamatan(setKec);
        dataDesa.setKabupaten(setKab);
        dataDesa.setRt(setRT);
        dataDesa.setWarga(setWarga);
        dataDesa.setBangun(setBangun);

        new InsertData(appDatabase, dataDesa).execute();
    }

    class InsertData extends AsyncTask<Void, Void, Long> {
        private AppDatabase database;
        private DataDesa dataDesa;

        public InsertData(AppDatabase database, DataDesa dataDesa) {
            this.database = database;
            this.dataDesa = dataDesa;
        }

        @Override
        protected Long doInBackground(Void... voids) {
            return database.dao().insertData(dataDesa);
        }

        @Override
        protected void onPostExecute(Long aLong) {
            super.onPostExecute(aLong);
            Toast.makeText(getApplicationContext(), "sukses", Toast.LENGTH_SHORT).show();

        }

    }
}