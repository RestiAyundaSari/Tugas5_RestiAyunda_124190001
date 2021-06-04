package id.ac.upnyk.databaselokal.presenter;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import id.ac.upnyk.databaselokal.entity.AppDatabase;
import id.ac.upnyk.databaselokal.entity.DataDesa;
import id.ac.upnyk.databaselokal.main.DesaContact;

public class DesaPresenter implements DesaContact.datapresenter{
    DesaContact.view view;
    DesaContact.hapus viewH;
    public DesaPresenter(DesaContact.view view) {
        this.view = view;
    }

    public DesaPresenter(DesaContact.hapus viewH) {
        this.viewH = viewH;
    }

    class EditData extends AsyncTask<Void, Void, Integer> {
        private AppDatabase database;
        private DataDesa dataDesa;
        public EditData(AppDatabase database, DataDesa dataDesa) {
            this.database = database;
            this.dataDesa = dataDesa;
        }

        @Override
        protected Integer doInBackground(Void... voids) {
            return database.dao().updateData(dataDesa);
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            Log.d("integer db", "onPostExecute: " + integer);
            view.sukses();
        }
    }

    @Override
    public void editData(String desa, String kecamatan, String kabupaten, String rt, String warga, String bangun,int id, AppDatabase database) {
        final DataDesa dataDesa = new DataDesa();
        dataDesa.setDesa(desa);
        dataDesa.setKecamatan(kecamatan);
        dataDesa.setKabupaten(kabupaten);
        dataDesa.setRt(rt);
        dataDesa.setWarga(warga);
        dataDesa.setBangun(bangun);
        dataDesa.setId(id);
        new EditData(database, dataDesa).execute();
    }
    class DeleteData extends AsyncTask<Void, Void, Void>{
        private AppDatabase database;
        private DataDesa dataDesa;
        Context context;
        public DeleteData(AppDatabase database, DataDesa dataDesa) {
            this.database = database;
            this.dataDesa = dataDesa;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            database.dao().deleteData(dataDesa);
            return  null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            viewH.sukses();
        }

    }
    @Override
    public void deleteData(DataDesa dataDesa, AppDatabase database) {
        new DeleteData(database,dataDesa).execute();
    }

}