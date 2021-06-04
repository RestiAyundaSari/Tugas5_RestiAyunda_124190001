package id.ac.upnyk.databaselokal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import id.ac.upnyk.databaselokal.adapter.DesaAdapter;
import id.ac.upnyk.databaselokal.entity.AppDatabase;
import id.ac.upnyk.databaselokal.entity.DataDesa;
import id.ac.upnyk.databaselokal.main.DesaContact;
import id.ac.upnyk.databaselokal.main.LihatDataDesa;
import id.ac.upnyk.databaselokal.presenter.DesaPresenter;

public class EditDataDesa extends AppCompatActivity implements DesaContact.view {
    private AppDatabase appDatabase;
    private DesaPresenter desaPresenter;
    private DesaAdapter desaAdapter;
    private EditText etDesa, etKec, etKab, etRT,etWarga,etBangun ;
    private Button btnSubmit;
    private String setDesa, setKec, setKab, setRT,setWarga,setBangun ;
    private boolean edit = false;
    private int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_data_item);

        etDesa = findViewById(R.id.et_nama_desa);
        etKec = findViewById(R.id.et_kecamatan);
        etKab = findViewById(R.id.et_kabupaten);
        etRT = findViewById(R.id.et_jml_RT);
        etWarga = findViewById(R.id.et_jml_warga);
        etBangun = findViewById(R.id.et_jml_bangunan);

        btnSubmit = findViewById(R.id.btn_submit);
        desaPresenter= new DesaPresenter(this);
        appDatabase = AppDatabase.iniDb(getApplicationContext());

        setDesa = getIntent().getStringExtra("desa");
        setKec = getIntent().getStringExtra("kecamatan");
        setKab = getIntent().getStringExtra("kabupaten");
        setRT = getIntent().getStringExtra("jml_RT");
        setWarga = getIntent().getStringExtra("jml_warga");
        setBangun = getIntent().getStringExtra("jml_bangunan");

        id = getIntent().getIntExtra("id", 99);

        etDesa.setText(setDesa);
        etKec.setText(setKec);
        etKab.setText(setKab);
        etRT.setText(setRT);
        etWarga.setText(setWarga);
        etBangun.setText(setBangun);

        btnSubmit.setOnClickListener(this);
    }

    @Override
    public void resetForm() {
        etDesa.setText("");
        etKec.setText("");
        etKab.setText("");
        etRT.setText("");
        etWarga.setText("");
        etBangun.setText("");
        btnSubmit.setText("Submit");
    }

    @Override
    public void sukses() {
        Toast.makeText(getApplicationContext(), "sukses", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(), LihatDataDesa.class));
    }

    @Override
    public void editData(DataDesa item) {
        etDesa.setText(item.getDesa());
        etKec.setText(item.getKecamatan());
        etKab.setText(item.getKabupaten());
        etRT.setText(item.getRt());
        etWarga.setText(item.getWarga());
        etBangun.setText(item.getBangun());

        edit = true;
        btnSubmit.setText("Update");
    }

    @Override
    public void onClick(View v) {
        String NamaDesa,NamaKecamatan,NamaKabupaten,JmlRT,JmlWarga,JmlBangunan;
        NamaDesa = etDesa.getText().toString();
        NamaKecamatan = etKec.getText().toString();
        NamaKabupaten = etKab.getText().toString();
        JmlRT= etRT.getText().toString();
        JmlWarga = etWarga.getText().toString();
        JmlBangunan = etBangun.getText().toString();
        if(v ==  btnSubmit){
            if(NamaDesa.equals("") || NamaKecamatan.equals("") || NamaKabupaten.equals("") || JmlRT.equals("")|| JmlWarga.equals("")|| JmlBangunan.equals("")) {
                Toast.makeText(this, "Harap isi semua data", Toast.LENGTH_SHORT).show();
            } else {

                desaPresenter.editData(NamaDesa,NamaKecamatan,NamaKabupaten,JmlRT,JmlWarga,JmlBangunan, id, appDatabase);
                edit = false;
            }
            resetForm();
        }
    }
}
