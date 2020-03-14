package com.example.mydatabase;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mydatabase.database.DataDiri;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    //menempatkan data sesuai dengan data yang ada di dao
    Context context;
    private DataDiri[] list;
    public Adapter(DataDiri[] list, Context context) {
        this.list = list;
        this.context = context;
    }
    //mengatur layout yang mana akan dipakai
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.datadiriitem,parent,false);
        return new ViewHolder(view);
    }
    //menampilkan ke recycler view
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        //mulai megambil data dan mensetnya ke textView
        //cara 1
        final DataDiri item = list[position];
        holder.tvNama.setText(item.getNama());
        holder.tvJenkel.setText("" + item.getJkelamin());
        holder.tvAlamat.setText(item.getAlamat());
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent edit = new Intent(context,UpdateDataActivity.class);
                edit.putExtra("id",item.getId());
                edit.putExtra("nama",item.getNama());
                edit.putExtra("jenkel",item.getJkelamin());
                edit.putExtra("alamat",item.getAlamat());
                context.startActivity(edit);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama,tvAlamat,tvJenkel;
        LinearLayout layout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tvNama);
            tvAlamat = itemView.findViewById(R.id.tvAlamat);
            tvJenkel =itemView.findViewById(R.id.tvJenkel);
            layout = itemView.findViewById(R.id.layout);
        }
    }
}
