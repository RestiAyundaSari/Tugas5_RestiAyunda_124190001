package id.ac.upnyk.databaselokal.main;

import android.view.View;

import java.util.List;

import id.ac.upnyk.databaselokal.entity.AppDatabase;
import id.ac.upnyk.databaselokal.entity.DataDesa;

public interface DesaContact {

    interface view extends View.OnClickListener{
        void resetForm();
        void sukses();
        //void getData(List<DataDesa> list);
        void editData(DataDesa item);
        //void deleteData(Datadesa item);
    }
    interface datapresenter{
        //readData(AppDatabase database);
        void editData(String desa, String kecamatan, String kabupaten, String rt, String warga, String bangun,int id, AppDatabase database);
        void deleteData(DataDesa dataDesa, AppDatabase database);
    }
    interface Cetak extends View.OnClickListener{
        void getData(List<DataDesa> list);
    }
    interface hapus{
        // void resetForm();
        void sukses();
        void deleteData(DataDesa item);
    }
}
