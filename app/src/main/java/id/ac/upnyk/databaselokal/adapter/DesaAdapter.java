package id.ac.upnyk.databaselokal.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import id.ac.upnyk.databaselokal.EditDataDesa;
import id.ac.upnyk.databaselokal.R;
import id.ac.upnyk.databaselokal.entity.DataDesa;
import id.ac.upnyk.databaselokal.main.DesaContact;

public class DesaAdapter extends RecyclerView.Adapter<DesaAdapter.ViewHolder> {

    Context context;
    List<DataDesa> list;
    DesaContact.hapus view;

    public DesaAdapter(Context context, List<DataDesa> list, DesaContact.hapus view) {
        this.view = view;
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public DesaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.lihat_data_item, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final DataDesa data = list.get(i);
        viewHolder.tvDesa.setText(data.getDesa());
        viewHolder.tvKec.setText(data.getKecamatan());
        viewHolder.tvKab.setText(data.getKabupaten());
        viewHolder.tvRT.setText(data.getRt());
        viewHolder.tvWarga.setText(data.getWarga());
        viewHolder.tvBangun.setText(data.getBangun());
        viewHolder.id.setText(String.valueOf(data.getId()));
        viewHolder.btnHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.deleteData(data);
                // return true;
            }
        });
        viewHolder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x = new Intent(context, EditDataDesa.class);
                x.putExtra("desa", data.getDesa());
                x.putExtra("kecamatan", data.getKecamatan());
                x.putExtra("kabupaten", data.getKabupaten());
                x.putExtra("jml_RT", data.getRt());
                x.putExtra("jml_warga", data.getWarga());
                x.putExtra("jml_bangunan", data.getBangun());
                x.putExtra("id", data.getId());
                x.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(x);
            }
        });

    }

    @Override
    public int getItemCount() { return list.size(); }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvDesa,tvKec,tvKab,tvRT,tvWarga,tvBangun,id;
        Button btnHapus, btnEdit;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDesa = itemView.findViewById(R.id.lihat_desa);
            tvKec = itemView.findViewById(R.id.lihat_kecamatan);
            tvKab= itemView.findViewById(R.id.lihat_kabupaten);
            tvRT = itemView.findViewById(R.id.lihat_RT);
            tvWarga= itemView.findViewById(R.id.lihat_warga);
            tvBangun = itemView.findViewById(R.id.lihat_bangunan);
            btnHapus = itemView.findViewById(R.id.btn_hapus);
            btnEdit = itemView.findViewById(R.id.btn_edit);
            id = itemView.findViewById(R.id.lihat_Id);
        }
    }

}
