package com.example.examn;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;

public class MyModel {
    public String NombreProduc;
    public String DescripcionProd;
    public String Cantidad;
    public String Precio;
    public String laboratorio;
    public int image;

    public MyModel(){

    }

    public MyModel(String nombreProduc, String descripcionProd, String cantidad, String precio, String laboratorio) {
        NombreProduc = nombreProduc;
        DescripcionProd = descripcionProd;
        Cantidad = cantidad;
        Precio = precio;
        this.laboratorio = laboratorio;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getNombreProduc() {
        return NombreProduc;
    }

    public void setNombreProduc(String nombreProduc) {
        NombreProduc = nombreProduc;
    }

    public String getDescripcionProd() {
        return DescripcionProd;
    }

    public void setDescripcionProd(String descripcionProd) {
        DescripcionProd = descripcionProd;
    }

    public String getCantidad() {
        return Cantidad;
    }

    public void setCantidad(String cantidad) {
        Cantidad = cantidad;
    }

    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String precio) {
        Precio = precio;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }
}
