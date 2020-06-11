package com.example.examn;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.ContentView;
import androidx.lifecycle.ViewModel;

public class MyAdapter extends BaseAdapter {
    //atributos
    private Context context;
    private int layout;
    private prueba farma;// ArrayList de Prueba -- lista

    //generar constructor con los 3 atributos definidos
    public MyAdapter(Context context, int layout, prueba farma) {
        this.context = context;
        this.layout = layout;
        this.farma = farma;
    }


    @Override
    public int getCount() {//# de item que se van a mostrar ene el listView
        return farma.size();// Regresar la cantidad de elemento que tenga la lista
    }

    @Override
    public Object getItem(int position)//obtener el item de la coleccion
    {
        return farma.get(position);
    }

    @Override
    public long getItemId(int position)// obtener el id del item en la colecciones
    {
        return position;
    }

    static class viewFarma{//se declara los elemntos que no son estaticos de la lista
        //se define los elementos de Item_list
        // que van llevar la lista con diferentes datos
        private TextView textViewNombreProduc;
        private TextView textViewDescripcionProd;
        private TextView textViewCantidad;
        private TextView textViewPrecio;
        private TextView textViewlaboratorio;
        private ImageView imageViewtext;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) { // muestra cada elemnto de la lista
        viewFarma farmac;
        if(convertView==null || convertView.getTag()==null){
            LayoutInflater layoutInflater=LayoutInflater.from(this.context);//infla la lista personalizada
            convertView=layoutInflater.inflate(R.layout.item_list,null);
            farmac= new viewFarma();
            //referencia el elemento a mostrar
            farmac.textViewNombreProduc=(TextView)convertView.findViewById(R.id.textViewNombreProdc);
            farmac.imageViewtext=(ImageView)convertView.findViewById(R.id.imageViewproduct);
            farmac.textViewDescripcionProd=(TextView)convertView.findViewById(R.id.textView2Presentacion);
            farmac.textViewCantidad=(TextView)convertView.findViewById(R.id.textViewCantidad);
            farmac.textViewPrecio=(TextView)convertView.findViewById(R.id.textViewPrecio);
            farmac.textViewlaboratorio=(TextView)convertView.findViewById(R.id.textViewLaboratorio);
        }else{
            farmac=(viewFarma)convertView.getTag();
        }
        // se define un objeto de MyModel con el que se obtiene la posicion de los
        //los elementos de La lista y se accede a sus propiedades Get y set, aqui
        // se le asigna su valor alos texView de Item_list
        MyModel current_Item= farma.get(position);//elemento actual de la lista
        farmac.textViewNombreProduc.setText(current_Item.getNombreProduc());
        farmac.textViewDescripcionProd.setText(current_Item.getDescripcionProd());
        farmac.textViewCantidad.setText(current_Item.getCantidad());
        farmac.textViewPrecio.setText(current_Item.getPrecio());
        farmac.textViewlaboratorio.setText(current_Item.getLaboratorio());
        farmac.imageViewtext.setImageResource(farma.get(position).getImage());
        return convertView;// devuelve la lista
    }
}
