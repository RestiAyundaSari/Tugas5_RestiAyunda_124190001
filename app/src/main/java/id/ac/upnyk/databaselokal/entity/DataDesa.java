package id.ac.upnyk.databaselokal.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "desa_db")
public class DataDesa {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "desa")
    private String desa;

    @ColumnInfo(name = "kecamatan")
    private String kecamatan;

    @ColumnInfo(name = "kabupaten")
    private String kabupaten;

    @ColumnInfo(name = "jml_RT")
    private String rt;

    @ColumnInfo(name = "jml_warga")
    private String warga;

    @ColumnInfo(name = "jml_bangunan")
    private String bangun;

    public int getId() {
        return id;
    }

    public void setId(@NonNull int id) { this.id = id; }

    public String getDesa() {
        return desa;
    }

    public void setDesa(String desa) {
        this.desa = desa;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public String getKabupaten() {
        return kabupaten;
    }

    public void setKabupaten(String kabupaten) {
        this.kabupaten = kabupaten;
    }

    public String getRt() {
        return rt;
    }

    public void setRt(String rt) {
        this.rt = rt;
    }

    public String getWarga() {
        return warga;
    }

    public void setWarga(String warga) {
        this.warga = warga;
    }

    public String getBangun() {
        return bangun;
    }

    public void setBangun(String bangun) {
        this.bangun = bangun;
    }

}
