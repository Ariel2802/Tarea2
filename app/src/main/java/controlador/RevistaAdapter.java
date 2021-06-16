package controlador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tarea2.R;

import java.util.List;

import modelo.Revista;

public class RevistaAdapter extends RecyclerView.Adapter<RevistaAdapter.ViewHolder> {

    private List<Revista> listaRevista;
    private LayoutInflater lInflater;
    private Context context;

    public RevistaAdapter(List<Revista> listaRevista, Context context) {
        this.listaRevista = listaRevista;
        this.lInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return listaRevista.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = lInflater.inflate(R.layout.layout_item, null);
        ViewHolder holder = new RevistaAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final RevistaAdapter.ViewHolder holder, final int position) {
        holder.bindData(listaRevista.get(position));
    }

    public List<Revista> getListaRevista() {
        return listaRevista;
    }

    public void setListaRevista(List<Revista> listaRevista) {
        this.listaRevista = listaRevista;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView lblRevista, lblAnio, lblVolumen, lblNumero;

        ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.picCover);
            lblRevista = itemView.findViewById(R.id.lblRevista);
            lblAnio = itemView.findViewById(R.id.lblYear);
            lblVolumen = itemView.findViewById(R.id.lblVol);
            lblNumero = itemView.findViewById(R.id.lblNumero);
        }

        private void bindData(final Revista revista) {
            Glide.with(context).load(revista.getCover()).into(imageView);
            lblRevista.setText(revista.getTitle());
            lblAnio.setText("Año: " + String.valueOf(revista.getYear()));
            lblVolumen.setText("Volumen: " + String.valueOf(revista.getVolume()));
            lblNumero.setText("Número: " + String.valueOf(revista.getNumber()));
        }
    }
}
